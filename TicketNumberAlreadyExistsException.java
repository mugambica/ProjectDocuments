package com.example.demo.layer4.exceptions;



@SuppressWarnings("serial")
public class TicketNumberAlreadyExistsException extends Throwable{
	public TicketNumberAlreadyExistsException(String msg) {
		super(msg);
	}
}
