package com.ashokit.service;

import com.ashokit.request.PassengerDto;
import com.ashokit.request.Ticket;

public interface MakemytripService {
	
	public Ticket bookTicket(PassengerDto passenger);
	
	public Ticket getTicket(Integer ticketNum);

}
