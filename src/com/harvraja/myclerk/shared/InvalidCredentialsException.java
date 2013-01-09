package com.harvraja.myclerk.shared;

import com.google.gwt.user.client.rpc.IsSerializable;



public class InvalidCredentialsException extends Exception implements IsSerializable{
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public InvalidCredentialsException(String msg){
	  super(msg);
  }
public InvalidCredentialsException(){
	super();
}
}
