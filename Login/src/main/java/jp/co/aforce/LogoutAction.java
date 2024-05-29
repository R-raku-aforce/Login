package jp.co.aforce;

import java.io.IOException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/jp/co/aforce/Logout.action")
public class LogoutAction extends HttpServlet{

	 @Override
	    protected void doGet(
	    	HttpServletRequest request, HttpServletResponse response
	    ) throws IOException {
		 
	        HttpSession session = request.getSession();
	        
	        if (session.getAttribute("customer") != null) {
	            session.invalidate();
	            response.sendRedirect(request.getContextPath() + "/jsp/logoutout.jsp");
	        } else {
	            response.sendRedirect(request.getContextPath() + "/jsp/logouterror.jsp");
	        }
	    }
	    
	    @Override
	    protected void doPost(
	    	HttpServletRequest request, HttpServletResponse response
	    ) throws IOException {
	    	
	        doGet(request, response);
	    }
}