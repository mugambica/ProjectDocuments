package com.example.demo.layer3;

import java.util.HashSet;

import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Repository;

import com.example.demo.layer2.Cancelticket;

@Repository
public class CancelticketRepositoryImpl implements CancelticketRepository {

	@PersistenceContext
	EntityManager entityManager;
	
	
	@Transactional
	public void addCancelticket(Cancelticket ctRef) {
		entityManager.persist(ctRef);
		
	}
	@Transactional
	public Cancelticket findCancelticket(int cancelid) {
		
		return entityManager.find(Cancelticket.class,cancelid);
		
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Transactional
	public Set<Cancelticket> findCancelticket() {
		
		Set<Cancelticket> cancelticketSet;
		Query query = entityManager.createQuery("from Cancelticket");
		
		cancelticketSet = new HashSet(query.getResultList());
			
		
	return cancelticketSet;
	}

	@Transactional
	public void modifyCancelticket(Cancelticket ctRef) {
		entityManager.merge(ctRef);
		
	}

	@SuppressWarnings("unused")
	@Transactional
	public void removeCancelticket(int cancelid) {
		Cancelticket ctRemove = entityManager.find(Cancelticket.class,cancelid);
		entityManager.remove(cancelid);
		
	}
	/*
	 * @Override public Cancelticket findCancelticket(int cancelid) { // TODO
	 * Auto-generated method stub return null; }
	 */

		

	

}
