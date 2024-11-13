package controller;

import com.example.demo5.PhongTro;
import com.example.demo5.PhuongThuc;

import Repository.PhongTroRepo.IPhongTro;
import Repository.PhongTroRepo.PhongTroRepo;
import Repository.PhuongThuc.IPhuongThuc;
import Repository.PhuongThuc.PhuongThucRepo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet(name="ProductServlet", value="")
public class ProductServlet extends HttpServlet {
    private IPhongTro IPhongTro = new PhongTroRepo();
    private IPhuongThuc IPhuongThuc = new PhuongThucRepo();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null || action.equals("list")) {
            listRoom(req, resp);
        } else {
            switch (action) {
                case "addForm":
                    showAddForm(req, resp);
                    break;
                case "editForm":
                    break;
                case "deleteForm":

                    break;
                default:
                    listRoom(req, resp);
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
                addRoom(req, resp);
                break;
            case "edit":

                break;
            case "delete":
                deleteRoom(req, resp);
                break;
            default:
                listRoom(req, resp);
                break;
        }
    }

    private void showAddForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<PhuongThuc> methodList = IPhuongThuc.findAll();
        req.setAttribute("methodList", methodList);
        RequestDispatcher dispatcher = req.getRequestDispatcher("addIP.jsp");
        dispatcher.forward(req, resp);
    }

    private void listRoom(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<PhongTro> roomList = IPhongTro.findAll();
        req.setAttribute("roomList", roomList);
        RequestDispatcher view = req.getRequestDispatcher("listRooms.jsp");
        view.forward(req, resp);
    }

    private void addRoom(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String phone = req.getParameter("phone");
        LocalDate startDate = LocalDate.parse(req.getParameter("startDate"));
        String note = req.getParameter("note");
        int paymentMethodId = Integer.parseInt(req.getParameter("paymentMethod"));

        PhuongThuc paymentMethod = IPhuongThuc.findById(paymentMethodId);

        PhongTro newRoom = new PhongTro(name,phone,startDate,note,paymentMethod);
        IPhongTro.save(newRoom);


        resp.sendRedirect("/?action=list");
    }
    private void deleteRoom(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        IPhongTro.delete(id);
        resp.sendRedirect("/?action=list");
    }
}

//private void deleteRoom(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//    int id = Integer.parseInt(req.getParameter("id"));
//    IPhongTro.delete(id);
//    resp.sendRedirect("/?action=list");
//}


//
//    private void showEditForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        int id = Integer.parseInt(req.getParameter("id"));
//        Iphone Iphone = iphoneRepository.findById(id);
//        List<Brand> brands = brandRepository.findAll();
//        req.setAttribute("iphone", Iphone);
//        req.setAttribute("brands", brands);
//        RequestDispatcher view = req.getRequestDispatcher("updateIP.jsp");
//        view.forward(req, resp);
//    }
//

//
//    private void updateIphone(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        int id = Integer.parseInt(req.getParameter("id"));
//        int brandId = Integer.parseInt(req.getParameter("brand"));
//        String model = req.getParameter("model");
//        String color = req.getParameter("color");
//        double price = Double.parseDouble(req.getParameter("price"));
//        int quality = Integer.parseInt(req.getParameter("quality"));
//
//        Iphone updatedIphone = new Iphone(id, brandId, model, color, price, quality);
//        iphoneRepository.update(updatedIphone);
//        resp.sendRedirect("/?action=list");
//    }
//
//    private void deleteRoom(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        int id = Integer.parseInt(req.getParameter("id"));
//        resp.sendRedirect("/?action=list");
//    }
//

//
//    private void showDeleteIphone(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        int id = Integer.parseInt(req.getParameter("id"));
//        Iphone Iphone = iphoneRepository.findById(id);
//        req.setAttribute("iphone", Iphone);
//        RequestDispatcher view = req.getRequestDispatcher("showDeleteIphone.jsp");
//        view.forward(req, resp);
//    }
//
//}









