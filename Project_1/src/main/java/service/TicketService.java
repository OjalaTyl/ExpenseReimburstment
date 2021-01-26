package service;



import java.util.List;

import org.apache.log4j.Logger;

import Connections.ReimburstmentDataHandler;
import models.Ticket;

public class TicketService {
	
	private static ReimburstmentDataHandler handler = new ReimburstmentDataHandler();
	private final static Logger logger = Logger.getLogger(Ticket.class);
	
		public void makeTicket(Ticket t ) {
			logger.info("Ticket made.");
			handler.makeTicket(t);			
		}
		
		public List<Ticket> getUserTickets(int id){
			List<Ticket> expList = handler.getUserTickets(id);
			logger.debug("Retrieved all tickets for employee " + id);
			return expList;
		}
		
		public List<Ticket> getTickets(){
			List<Ticket> expList = handler.getTickets();
			logger.debug("Retrieved all tickets");
			return expList;
		}
		
		public void resolveTicket(int approve, int ticket_id) {
			logger.debug("Ticket " + ticket_id + " resolved");
			handler.resolveTicket(approve, ticket_id);
		}
}
