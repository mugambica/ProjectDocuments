package com.example.demo.layer4;

import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.layer2.Cancelticket;
import com.example.demo.layer3.CancelticketRepository;
import com.example.demo.layer4.exceptions.CancelIdAlreadyExistsException;
import com.example.demo.layer4.exceptions.CancelIdNotFoundException;

@Service
public class CancelticketServiceImpl implements CancelticketService {
	
	@Autowired
	CancelticketRepository canTktRepo;

	@Override
	public String addCancelticketService(Cancelticket ctRef)throws CancelIdAlreadyExistsException {
		try
		{
		canTktRepo.addCancelticket(ctRef);
		
	}
		 catch (Exception e) {
				e.printStackTrace();
				throw e;
				
			}
		System.out.println("Cancelticket added successfully");
		return "Cancelticket added successfully";
	}

	@Override
	public Cancelticket findCancelticketService(int cancelid) throws CancelIdNotFoundException {
		try
		{
			return canTktRepo.findCancelticket(cancelid);
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			throw new CancelIdNotFoundException("Cancelticket not found");
		}
	
	
		
	}

	@Override
	public Set<Cancelticket> findCancelticketService() {
		
		return canTktRepo.findCancelticket();
	}


	@Override
	public String modifyCancelticketService(Cancelticket ctRef)throws CancelIdNotFoundException {
		Cancelticket ctRef1=canTktRepo.findCancelticket(ctRef.getCancelid());
		if(ctRef1!=null)
		{
			canTktRepo.modifyCancelticket(ctRef);
		}
		else
		{
			throw new CancelIdNotFoundException("CancelId  not found");
		}
		System.out.println("Cancelticket modified successfully");
		return "Cancelticket modified successfully";
		
	}

	@Override
	public String removeCancelticketService(int cancelid)throws CancelIdNotFoundException {
		Cancelticket ctRef1=canTktRepo.findCancelticket(cancelid);
		if(ctRef1!=null)
		{
			canTktRepo.removeCancelticket(ctRef1.getCancelid());
		}
		else
		{
			throw new CancelIdNotFoundException("CancelId  not found");
		}
		return "deleted successfully";
		
	}




}
