package com.example.demo.layer5;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.layer2.Cancelticket;
import com.example.demo.layer4.CancelticketService;
import com.example.demo.layer4.exceptions.TicketNumberNotFoundException;

@RestController
public class CancelticketController {
	
	
	@Autowired
	CancelticketService canTktServ;
	
	@GetMapping(path="/getCanTkt/{mycancelid}")
	@ResponseBody
	public ResponseEntity<Cancelticket> getCancelticket(@PathVariable("mycancelid") Integer cancelid) throws TicketNumberNotFoundException {
		System.out.println("Department Controller....Understanding client and talking to service layer...");
		Cancelticket canTkt=null;
		
			canTkt = canTktServ.findCancelticketService(cancelid);
			if(canTkt==null)
			{ return ResponseEntity.notFound().build();
			
			}
			else {
				return ResponseEntity.ok(canTkt);
			}
		
	}
	
	
	

}










