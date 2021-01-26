package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import Connections.ReimburstmentDataHandler;
import models.Ticket;
import service.TicketService;

public class ManagerController {
	
	
	public static void manager(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		RequestDispatcher redis = req.getRequestDispatcher("/managerPage.html");
		redis.forward(req, resp);
	
	}
	
	public static void getTickets(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		TicketService service = new TicketService();
		resp.setContentType("application/json");
		HttpSession session = req.getSession(false);
		if(session != null) {
			List<Ticket> tickets = service.getTickets();
			
			ObjectMapper om = new ObjectMapper();
			resp.getWriter().write(om.writeValueAsString(tickets));
		}
		
	}
	
	  static void makeTickets(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		  HttpSession session = req.getSession(false);
		  TicketService service = new TicketService();
		  if(session != null) {
			  int id = (int) session.getAttribute("employee_id");
			  String username = (String) session.getAttribute("employee_username");
			  ObjectMapper om = new ObjectMapper();
			  Ticket ticket = om.readValue(req.getReader(), models.Ticket.class);
			  ticket.setReimburstment_user_id(id);
			  ticket.setUsername(username);
			  ticket.setApproved(-1);
			  service.makeTicket(ticket);
		  }
	  }
	  
	  static void setTicketStatus(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		  TicketService service = new TicketService();
		  ObjectMapper om = new ObjectMapper();
		  Ticket ticket = om.readValue(req.getReader(), models.Ticket.class);
		  int status = ticket.getApproved();
		  int id = ticket.getReimburstment_ticket_id();
		  service.resolveTicket(status, id);
	  }
}
