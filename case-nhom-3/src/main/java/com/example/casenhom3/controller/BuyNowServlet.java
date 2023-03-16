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

@WebServlet(name = "BuyNowServlet", value = "/BuyNowServlet")
public class BuyNowServlet extends HttpServlet {
    ProductDAO productDAO=new ProductDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession(true);
        Cart cart=null;
        Object o=session.getAttribute("cart");
        if (o!=null){
            cart= (Cart) o;
        }else {
            cart=new Cart();
        }
//        int sum= Integer.parseInt(request.getParameter("number"));
        Long  cid= Long.valueOf(request.getParameter("cid"));
//        if ((sum==-1)&&(cart.getQuantty(cid)<=1)){
//            cart.deleteItemCart(cid);
//        }else {
            Product product = productDAO.findById(cid);
            Double price = product.getProductPrice();
            int quantity=1;
            ItemCart itemCart1 = new ItemCart(product, price,quantity);
            cart.addItemCart(itemCart1);
//        }
        List<ItemCart> itemCartList=cart.getCartList();
        session.setAttribute("cart",cart);
        session.setAttribute("size",itemCartList.size());
       response.sendRedirect("/HomePageServlet");
    }
}
