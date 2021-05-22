package com.example.demo.layer2;


import java.sql.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;




/**
 * The persistent class for the CANCELTICKET database table.
 * 
 */
@Entity
@Table(name="CANCELTICKET")
@NamedQuery(name="Cancelticket.findAll", query="SELECT c FROM Cancelticket c")
public class Cancelticket  {
	
	@Id
	private int cancelid;
	
	//@Temporal(TemporalType.TIMESTAMP)
	private Date canceldate;
	
	private Double refundamount;

	private String refundstatus;

	//bi-directional many-to-one association to Reservation
	@OneToOne(cascade=CascadeType.ALL)
	@MapsId
	@JoinColumn(name="TICKETNO")
	private Reservation reservation;

	public Cancelticket() {
		super();
		System.out.println("CancelTicket contr()......");
	}

	public Date getCanceldate() {
		return canceldate;
	}

	public void setCanceldate(Date canceldate) {
		this.canceldate = canceldate;
	}
	/*
	 	public Date getEmployeeHiredate() {
		return employeeHiredate;
	}

	public void setEmployeeHiredate(Date employeeHiredate) {
		this.employeeHiredate = employeeHiredate;
	
	 */

	public int getCancelid() {
		return this.cancelid;
	}

	public void setCancelid(int cancelid) {
		this.cancelid = cancelid;
	}

	public Double getRefundamount() {
		return this.refundamount;
	}

	public void setRefundamount(Double refundamount) {
		this.refundamount = refundamount;
	}

	public String getRefundstatus() {
		return this.refundstatus;
	}

	public void setRefundstatus(String refundstatus) {
		this.refundstatus = refundstatus;
	}
	@JsonIgnore
	public Reservation getReservation() {
		return this.reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

}