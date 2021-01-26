package Connections;

import java.util.List;

import models.Ticket;

public interface ReimburstmentDAO {
	List<Ticket> getTickets();
	List<Ticket> getUserTickets(int user_id);
	void makeTicket(Ticket t);
	void resolveTicket(int approve, int ticket_id);
}
