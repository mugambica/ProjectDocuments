package com.example.demo.layer4;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.example.demo.layer2.Cancelticket;
import com.example.demo.layer4.exceptions.*;

@Service
public interface CancelticketService {
	

		void addCancelticketService(Cancelticket ctRef) throws TicketNumberAlreadyExistsException;  //C - add/create
		Cancelticket findCancelticketService(int cancelid) throws TicketNumberNotFoundException;    //R - find/reading
		Set<Cancelticket> findCancelticketService();     //R - find all/reading all
		void modifyCancelticketService(Cancelticket ctRef) throws TicketNumberNotFoundException; //U - modify/update
		void removeCancelticketService(int cancelid) throws TicketNumberNotFoundException; //D - remove/delete
		
		
	}


