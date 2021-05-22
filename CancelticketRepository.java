package com.example.demo.layer3;

import java.util.Set;

import org.springframework.stereotype.Repository;

import com.example.demo.layer2.Cancelticket;

@Repository
public interface CancelticketRepository {

	void addCancelticket(Cancelticket ctRef);   //C - add/create
	Cancelticket findCancelticket(int cancelid);     //R - find/reading
	Set<Cancelticket> findCancelticket();     //R - find all/reading all
	void modifyCancelticket(Cancelticket ctRef); //U - modify/update
	void removeCancelticket(int cancelid); //D - remove/delete
	
	
}
