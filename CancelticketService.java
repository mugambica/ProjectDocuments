package com.example.demo.layer4;

import java.util.Set;


import org.springframework.stereotype.Service;

import com.example.demo.layer2.Cancelticket;
import com.example.demo.layer4.exceptions.*;

@Service
public interface CancelticketService {
	

		String addCancelticketService(Cancelticket ctRef) throws CancelIdAlreadyExistsException;  //C - add/create
		Cancelticket findCancelticketService(int cancelid) throws CancelIdNotFoundException;    //R - find/reading
		Set<Cancelticket> findCancelticketService();     //R - find all/reading all
		String modifyCancelticketService(Cancelticket ctRef) throws CancelIdNotFoundException; //U - modify/update
		String removeCancelticketService(int cancelid) throws CancelIdNotFoundException; //D - remove/delete
	
		
		
	}


