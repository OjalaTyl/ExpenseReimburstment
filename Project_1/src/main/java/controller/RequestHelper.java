package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestHelper {
	public static void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println(req.getRequestURI());

		String endpoint = req.getRequestURI();
		switch (endpoint) {

		case "/Project_1/api/login":
			LoginController.login(req, resp);
			break;
		case "/Project_1/api/employee":
			EmployeeController.employee(req, resp);
			break;
		case "/Project_1/api/manager":
			ManagerController.manager(req, resp);
			break;
		case "/Project_1/api/employee/tickets":
			switch(req.getMethod()) {
				case "GET":
					EmployeeController.getTickets(req, resp);
					break;
				case "POST":
					EmployeeController.makeTickets(req, resp);
					break;
			}
			break;
		case "/Project_1/api/manager/tickets":
			switch(req.getMethod()) {
				case "GET":
					ManagerController.getTickets(req, resp);
					break;
				case "POST":
					ManagerController.makeTickets(req, resp);
					break;
				case "PUT":
					ManagerController.setTicketStatus(req, resp);
					break;
			}
			break;
		case "/Project_1/api/employeeScript.js":
			resp.sendRedirect("http://localhost:8080/Project_1/employeeScript.js");
			break;
		case "/Project_1/api/managerScript.js":
			resp.sendRedirect("http://localhost:8080/Project_1/managerScript.js");
			break;
		case "/Project_1/api/":
			LoginController.index(req, resp);
			break;
		default:
			resp.sendRedirect("http://localhost:8080/Project_1/api/");
			// Put an error page here as well

		}
	}
}
