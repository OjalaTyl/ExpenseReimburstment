package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Connections.UserDataHandler;
import models.User;
import service.TicketService;
import service.UserService;

public class LoginController {
	
	

	public static void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		UserService service = new UserService();
		if(req.getMethod().equals("POST")) {
			User user = service.getUser(req.getParameter("username"), req.getParameter("password"));
			if(user != null) {
				HttpSession session = req.getSession(true);
				session.setAttribute("employee_id", user.getId());
				session.setAttribute("employee_username", user.getName());
				String nextPage = user.isManager() ? "/api/manager" : "/api/employee";
				resp.sendRedirect(req.getContextPath() + nextPage);
			}
			else {
				resp.sendRedirect("Project_1/api/");
			}
		}
		else {
			resp.setStatus(405);
		}
	}
	
	public static void index(HttpServletRequest req, HttpServletResponse resp)  throws ServletException, IOException{	
		RequestDispatcher redis = req.getRequestDispatcher("/index.html");
		redis.forward(req, resp);
	
	}

}
