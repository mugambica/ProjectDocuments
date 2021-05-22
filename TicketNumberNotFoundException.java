package com.example.demo.layer4.exceptions;



@SuppressWarnings("serial")
public class TicketNumberNotFoundException extends Throwable{
	public TicketNumberNotFoundException(String msg) {
		super(msg);
	}
}
