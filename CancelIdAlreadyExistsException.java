package com.example.demo.layer4.exceptions;



@SuppressWarnings("serial")
public class CancelIdAlreadyExistsException extends Throwable{
	public CancelIdAlreadyExistsException(String msg) {
		super(msg);
	}
}
