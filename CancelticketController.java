package com.example.demo.layer5;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.layer2.Cancelticket;
import com.example.demo.layer4.CancelticketService;
import com.example.demo.layer4.exceptions.TicketNumberAlreadyExistsException;
import com.example.demo.layer4.exceptions.TicketNumberNotFoundException;

@RestController
public class CancelticketController {
	
	
	@Autowired
	CancelticketService canTktServ;
	
	@GetMapping(path="/getCanTkt/{mycancelid}")
	@ResponseBody
	public ResponseEntity<Cancelticket> getCancelticket(@PathVariable("mycancelid") Integer cancelid) throws TicketNumberNotFoundException {
		System.out.println("Cancelticket Controller.......");
		Cancelticket canTkt=null;
		
			canTkt = canTktServ.findCancelticketService(cancelid);
			if(canTkt==null)
			{ return ResponseEntity.notFound().build();
			
			}
			else {
				return ResponseEntity.ok(canTkt);
			}
		
	}
	
	
	@GetMapping(path="/getCanTKts")
	@ResponseBody
	public Set<Cancelticket> getAllCanceltickets() {
		System.out.println("CANCELTICKET Controller....Understanding client and talking to service layer...");
		Set<Cancelticket> canTktset = canTktServ.findCancelticketService();
		return canTktset;
		
	}
	
	@PostMapping(path="/addCanTkt")  //not working
	public String addCancelticket(@RequestBody Cancelticket canTkt)throws TicketNumberAlreadyExistsException
	{
		System.out.println("Cancelticket Controller....Understanding client and talking to service layer...");
		Cancelticket ctObj=new Cancelticket();
		
		ctObj.setCanceldate(canTkt.getCanceldate());
		ctObj.setRefundamount(canTkt.getRefundamount());
		ctObj.setRefundstatus(canTkt.getRefundstatus());
		
		
		 String stmsg = null;
		try {
			stmsg = canTktServ.addCancelticketService(ctObj);
			} 
		catch (TicketNumberAlreadyExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return e.getMessage();
		}
		catch(Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}
		System.out.println("controller printing"+stmsg);
		  return stmsg;
		
		}
	
	@PutMapping(path="/modifyCanTKt") // not working
	public String modifyDepartment(@RequestBody Cancelticket canTkt )throws TicketNumberNotFoundException {
		System.out.println("Ticket Controller....Understanding client and talking to service layer...");
		 String stmsg = null;
		try {
			stmsg = canTktServ.modifyCancelticketService(canTkt);
		} 
		catch (TicketNumberNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return e.getMessage();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("controller is saying: "+stmsg);
		  return stmsg;
		
	}
	
	@DeleteMapping(path="/deleteCanTkt") // not working
	public String removeDepartment(@RequestBody Cancelticket canTkt)throws TicketNumberNotFoundException {
		System.out.println("Cancelticket Controller....Understanding client and talking to service layer...");
		 String stmsg = null;
		try {
			stmsg = canTktServ.removeDepartmentService(canTkt.getCancelid());
		} 
		catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("controller is saying: "+stmsg);
		  return stmsg;	
}
}










