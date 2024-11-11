package controller;

import Repository.BrandRepo.BrandRepository;
import Repository.IphoneRepo.IphoneRepository;
import com.example.demo5.Brand;
import com.example.demo5.Iphone;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;



@WebServlet(name="ProductServlet",value="")
public class ProductServlet extends HttpServlet {
    private IphoneRepository iphoneRepository = new IphoneRepository();
    private BrandRepository brandRepository = new BrandRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null || action.equals("list")) {
            listIphones(req, resp);
        } else {
            switch (action) {
                case "addForm":
                    showAddForm(req, resp);
                    break;
                case "editForm":
                    showEditForm(req, resp);
                    break;
                case "deleteForm":
                    showDeleteIphone(req, resp);
                    break;
                default:
                    listIphones(req, resp);
                    break;
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "list";
        }
        switch (action) {
            case "add":
                addIphone(req, resp);
                break;
            case "edit":
                updateIphone(req, resp);
                break;
            case "delete":
                deleteIphone(req, resp);
                break;
            default:
                listIphones(req, resp);
                break;
        }
    }

    private void showAddForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Brand> brands = brandRepository.findAll();
        req.setAttribute("brands", brands);
        RequestDispatcher dispatcher = req.getRequestDispatcher("addIP.jsp");
        dispatcher.forward(req, resp);
    }

    private void showEditForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Iphone Iphone = iphoneRepository.findById(id);
        List<Brand> brands = brandRepository.findAll();
        req.setAttribute("iphone", Iphone);
        req.setAttribute("brands", brands);
        RequestDispatcher view = req.getRequestDispatcher("updateIP.jsp");
        view.forward(req, resp);
    }

    private void addIphone(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int brandId = Integer.parseInt(req.getParameter("brand"));
        String model = req.getParameter("model");
        String color = req.getParameter("color");
        double price = Double.parseDouble(req.getParameter("price"));
        int quality = Integer.parseInt(req.getParameter("quality"));

        Iphone newIphone = new Iphone(0, brandId, model, color, price, quality);
        iphoneRepository.add(newIphone);
        resp.sendRedirect("/?action=list");
    }

    private void updateIphone(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        int brandId = Integer.parseInt(req.getParameter("brand"));
        String model = req.getParameter("model");
        String color = req.getParameter("color");
        double price = Double.parseDouble(req.getParameter("price"));
        int quality = Integer.parseInt(req.getParameter("quality"));

        Iphone updatedIphone = new Iphone(id, brandId, model, color, price, quality);
        iphoneRepository.update(updatedIphone);
        resp.sendRedirect("/?action=list");
    }

    private void deleteIphone(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        iphoneRepository.delete(id);
        resp.sendRedirect("/?action=list");
    }

    private void listIphones(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Iphone> iphones = iphoneRepository.findAll();
        req.setAttribute("iphones", iphones);
        RequestDispatcher view = req.getRequestDispatcher("listIphones.jsp");
        view.forward(req, resp);
    }

    private void showDeleteIphone(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Iphone Iphone = iphoneRepository.findById(id);
        req.setAttribute("iphone", Iphone);
        RequestDispatcher view = req.getRequestDispatcher("showDeleteIphone.jsp");
        view.forward(req, resp);
    }

}








