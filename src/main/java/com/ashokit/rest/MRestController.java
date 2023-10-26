package com.ashokit.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ashokit.request.PassengerDto;
import com.ashokit.request.Ticket;
import com.ashokit.service.MakemytripService;

@RestController
public class MRestController {

	@Autowired
	private MakemytripService service;

	@PostMapping("/bookTicket")
	public ResponseEntity<?> bookTicket(@RequestBody PassengerDto passenger) {
		Ticket bookTicket = service.bookTicket(passenger);

		return new ResponseEntity<Ticket>(bookTicket, HttpStatus.CREATED);
	}

	@GetMapping("/bookTicket/{ticketNum}")
	public ResponseEntity<?> getTicket(@PathVariable Integer ticketNum) {
		Ticket bookTicket = service.getTicket(ticketNum);

		return new ResponseEntity<Ticket>(bookTicket,HttpStatus.OK);
	}
}
