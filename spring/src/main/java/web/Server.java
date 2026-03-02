package web;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import web.service.AccountServer;
import web.service.AccountServerImpl;


import java.io.IOException;


@WebServlet("/web")
public class Server extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        doPost(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse response) {
        String fromname = req.getParameter("from");
        String toname = req.getParameter("to");
        String money_type = req.getParameter("money");
        Double money = Double.parseDouble(money_type);
        AccountServer server = new AccountServerImpl();
        server.transfer(fromname, toname, money);
        try {
            req.getRequestDispatcher("/view/ok.html").forward(req, response);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}