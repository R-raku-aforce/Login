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

@WebServlet("/jp/co/aforce/Login.action")
public class LoginAction extends HttpServlet {
	
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

        // 处理登录操作
        String url = login(username, password, session);

        // 请求转发到相应的 JSP 页面
        request.getRequestDispatcher(url).forward(request, response);
    }

    // 处理登录操作的方法
    private String login(
    	String username, String password, HttpSession session
    ) throws Exception {
    	
        CustomerDAO dao = new CustomerDAO();
        Customer customer = dao.search(username, password);
        
        if (customer != null) {
            session.setAttribute("customer", customer);
            return "/jsp/loginout.jsp"; // 登录成功，转到成功页面
        } else {
            // 登录失败，设置错误消息
            session.setAttribute("error", "IDもしくはパスワードが違います");
            return "/jsp/login.jsp"; // 登录失败，转到失败页面
        }
    }
}
