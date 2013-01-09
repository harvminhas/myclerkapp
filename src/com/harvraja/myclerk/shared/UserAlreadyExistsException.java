package com.harvraja.myclerk.shared;

import com.google.gwt.user.client.rpc.IsSerializable;



public class UserAlreadyExistsException extends Exception implements IsSerializable{
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public UserAlreadyExistsException(String msg){
	  super(msg);
  }
public UserAlreadyExistsException(){
	super();
}
}
