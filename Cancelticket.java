package com.example.demo.layer2;
import java.time.LocalDate;

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
	@Column(name="canceldate",columnDefinition="Date")
	private LocalDate canceldate=LocalDate.now();
	
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

	public LocalDate getCanceldate() {
		return canceldate;
	}

	public void setCanceldate(LocalDate date) {
		this.canceldate = date;
	}

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