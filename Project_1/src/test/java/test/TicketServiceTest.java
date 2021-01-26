package test;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import models.Ticket;
import service.TicketService;

public class TicketServiceTest {
	
	TicketService service = mock(TicketService.class);
	static Ticket t;
	static Ticket t2;
	static Ticket t3;
	
	
	@Before
	public void setUp() throws Exception{
		MockitoAnnotations.initMocks(this);
		t = new Ticket(2, 6, "sam", 123456789.1, "desc", 2, -1);
		t2 = new Ticket(3, 5, "sam", 1.1, "desc2", 2, -1);
		t3 = new Ticket(4, 6, "sam", 132.1, "desc3", 2, -1);
		
	}
	
	@Test 
	public void testUniqueFind() {
		List<Ticket> list = new ArrayList<Ticket>();
		list.add(t);
		list.add(t3);
		when(service.getUserTickets(6)).thenReturn(list);
		List<Ticket> testList = service.getUserTickets(6);
		
		assertEquals(2, testList.size());
		verify(service, times(1)).getUserTickets(6);
	}
	
	@Test 
	public void testAllFind() {
		List<Ticket> list = new ArrayList<Ticket>();
		list.add(t);
		list.add(t2);
		list.add(t3);
		when(service.getTickets()).thenReturn(list);
		assertEquals(3, service.getTickets().size());
	}
	
	@Test
	public void testMakeTicket() {
		service.makeTicket(t);
		verify(service, times(1)).makeTicket(t);
	}
}
