package com.example.casenhom3.controller;

import com.example.casenhom3.model.Cart;
import com.example.casenhom3.model.ItemCart;
import com.example.casenhom3.model.Product;
import com.example.casenhom3.service.DAO.ProductDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProcessServlet", value = "/ProcessServlet")
public class ProcessServlet extends HttpServlet {
    ProductDAO productDAO=new ProductDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession(true);
        Cart cart=null;
        Object o=session.getAttribute("cart");
        if (o!=null){
            cart= (Cart) o;
        }else {
            cart=new Cart();
        }
        int tnum= Integer.parseInt(request.getParameter("quantity"));
        Long id= Long.valueOf(request.getParameter("id"));
        if (tnum==-1 && cart.getQuantty(id)<=1){
            cart.deleteItemCart(id);

        }else {
            Product product1=productDAO.findById(id);
            Double price=product1.getProductPrice();
            ItemCart itemCart=new ItemCart(product1,price,tnum);
            cart.addItemCart(itemCart);
        }
        List<ItemCart>list=cart.getCartList();
        session.setAttribute("cart",cart);
        session.setAttribute("size",list.size());
        request.getRequestDispatcher("/login/cart.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        Cart cart=null;
        Object o=session.getAttribute("cart");
        if (o!=null){
            cart= (Cart) o;
        }else {
            cart=new Cart();
        }
        Long id= Long.valueOf(request.getParameter("id"));
        cart.deleteItemCart(id);
        List<ItemCart> list=cart.getCartList();
        session.setAttribute("cart",cart);
        session.setAttribute("size",list.size());
        request.getRequestDispatcher("/login/cart.jsp").forward(request,response);
    }
}
