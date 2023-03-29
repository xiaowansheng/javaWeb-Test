package com.bookMall.web;

import com.bookMall.pojo.Cart;
import com.bookMall.pojo.Order;
import com.bookMall.service.OrderService;
import com.bookMall.service.UserService;
import com.bookMall.service.impl.OrderServiceImpl;
import com.bookMall.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class OrderServlet extends BaseServlet {
    private OrderService orderService=new OrderServiceImpl();
    private UserService userService=new UserServiceImpl();

    public Cart getCart(HttpSession session){
        Cart cart=(Cart)session.getAttribute("cart");
        if(cart==null){
            cart=userService.getCart();
            session.setAttribute("cart",cart);
        }
        return cart;
    }

    public void checkout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        //获取购物车对象
        Cart cart= getCart(session);
        //获取用户id
//        Object o=session.getAttribute("username");
//        Integer userId=userService.queryForUserId((String)o);
        Integer userId=(Integer) session.getAttribute("userId");
        //保存订单到购物车
        String orderId=orderService.createOrder(cart,userId);
        cart.clear();
        session.setAttribute("orderId",orderId);
        response.sendRedirect(request.getContextPath()+"/page/manager/order/checkout.jsp");
    }

    public void order(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Order> orders=orderService.showOrdersByUserId((Integer) request.getSession().getAttribute("userId"));
        request.setAttribute("orders",orders);
        request.getRequestDispatcher("/page/manager/order/order.jsp").forward(request,response);
    }
}
