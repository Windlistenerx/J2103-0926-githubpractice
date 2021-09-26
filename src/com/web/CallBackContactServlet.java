package com.qf.review.web;

import com.qf.review.domain.ContactInfo;
import com.qf.review.service.ContactService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/callback_contact")
public class CallBackContactServlet extends HttpServlet {
    ContactService service =new ContactService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        //1.接收数据
        String id = request.getParameter("id");
        String currentPage = request.getParameter("currentPage");
        String pageSize = request.getParameter("pageSize");
        //2.处理数据
        ContactInfo contact =service.queryById(id);

        //3.响应数据
        request.setAttribute("contact",contact);
        request.setAttribute("currentPage",currentPage);
        request.setAttribute("pageSize",pageSize);
        request.getRequestDispatcher("update.jsp").forward(request,response);
    }
//阿巴巴阿巴

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
