package web;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.AccountServer;
import service.AccountServerImpl;

import java.io.IOException;

@WebServlet("/function")
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
        System.out.println("转账成功");
    }

}
