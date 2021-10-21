package com.mobilestore.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mobilestore.model.MobileUser;
import com.mobilestore.service.MobileService;

public class MobilePasswordController extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String newpass = request.getParameter("newpassword");
        String confirmpass = request.getParameter("confirmpassword");
        String email = request.getParameter("email");

        if (newpass.isEmpty() || confirmpass.isEmpty() || email.isEmpty()) {
            out.println("<font color=red>Please fill all the fields</font>");
        } else {
            if (newpass.equals(confirmpass)) {

                MobileUser updatePwd = new MobileUser("", "", newpass, email);

                if (new MobileService().updatePassword(updatePwd)) {
                    RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
                    out.write("password updated");
                    rd.forward(request, response);
                    out.println("<font color=green>Password updated Successfully!!!</font>");
                }
            } else {
                out.println("<font color=red>Password and Confirm Password doesn't matches</font>");
            }
        }
    }
}
