package jp.co.aforce;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jp.co.aforce.bean.Customer;
import jp.co.aforce.dao.CustomerDAO;

@WebServlet("/jp/co/aforce/Register.action")
public class RegisterAction extends HttpServlet {

    @Override
    protected void doPost(
    	HttpServletRequest request, HttpServletResponse response
    ) throws ServletException, IOException {
    	
        try {
            execute(request, response);
        } catch (Exception e) {
            throw new ServletException(e);
        }
        
    }

    private void execute(
    	HttpServletRequest request, HttpServletResponse response
    ) throws Exception {
    	
        HttpSession session = request.getSession();
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        CustomerDAO dao = new CustomerDAO();
        try {
            // 创建新的Customer对象并保存到数据库中
            Customer customer = new Customer(username, password);
            dao.addCustomer(customer);
            session.setAttribute("customer", customer);
            
            // 注册成功后重定向到登录页面
            request.getRequestDispatcher("/jsp/loginout.jsp").forward(request, response);
        } catch (Exception e) {
            // 处理异常情况，例如注册失败
            e.printStackTrace();
            request.setAttribute("errorMessage", e.getMessage());
            // 返回错误页面或者其他适当的响应
            request.getRequestDispatcher("/jsp/error.jsp").forward(request, response);
        }
    }
}


