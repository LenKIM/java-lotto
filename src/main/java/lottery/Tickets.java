package lottery;

import java.util.ArrayList;
import java.util.List;

public class Tickets {

	public static final Tickets ZERO = new Tickets(new ArrayList<>());

	private final List<Ticket> ticketList;

	private Tickets(List<Ticket> ticketList) {
		this.ticketList = ticketList;
	}

	public static Tickets of(List<Ticket> ticketList) {
		return new Tickets(ticketList);
	}

	public int size() {
		return ticketList.size();
	}

	public List<Ticket> getTicketList() {
		return ticketList;
	}
}