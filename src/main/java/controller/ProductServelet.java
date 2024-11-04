package controller;

import Service.Android.AndroidService;
import Service.Android.IAndroidService;
import Service.Iphone.InIphoneService;
import Service.Iphone.IphoneService;
import com.example.demo5.Android;
import com.example.demo5.Iphone;
import jdk.nashorn.internal.ir.RuntimeNode;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name ="ProductServelet",value="")
public class ProductServelet extends HttpServlet {
   private final InIphoneService iphoneService=new IphoneService();
   private final IAndroidService androidService=new AndroidService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action==null){
            action="";
        }
        switch (action){
            case "add":
                break;
            case "edit":
                break;
                case "delete": break;
            case "AndroidList":showAndroidList(req,resp);break;
            default:
                showList(req, resp);
                break;


        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
   protected void showList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        List<Iphone> IphoneList=iphoneService.findAll();
        req.setAttribute("IphoneList",IphoneList);
        RequestDispatcher dispatcher=req.getRequestDispatcher("index.jsp");
        try {
            dispatcher.forward(req,resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    protected void showAndroidList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        List<Android> AndroidList=androidService.findAll();
        req.setAttribute("AndroidList",AndroidList);
        RequestDispatcher dispatcher=req.getRequestDispatcher("Android.jsp");
        dispatcher.forward(req,resp);
    }
}
