package com.ashokit.serviceimpl;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.ashokit.request.PassengerDto;
import com.ashokit.request.Ticket;
import com.ashokit.service.MakemytripService;

@Service
public class MakeMytripserviceimpl implements MakemytripService{
	
	private String BOOK_TICKET_URL="http://65.2.82.50:8080/bookTicket";
	
	private String GET_TICKET_URL="http://65.2.82.50:8080/get/{ticketNum}";
	@Override
	public Ticket bookTicket(PassengerDto passenger) {
		
		WebClient create = WebClient.create();
		
		Ticket ticket = create.post()
		      .uri(BOOK_TICKET_URL)
		      .bodyValue(passenger)
		      .retrieve()
		      .bodyToMono(Ticket.class)
		      .block();
		
		return ticket;
	}
	
	@Override
	public Ticket getTicket(Integer ticketNum) {
		WebClient create = WebClient.create();
		
		Ticket ticket = create.get()
		      .uri(GET_TICKET_URL,ticketNum)
		      .retrieve()
		      .bodyToMono(Ticket.class)
		      .block();
		      
		return ticket;
	}

}
