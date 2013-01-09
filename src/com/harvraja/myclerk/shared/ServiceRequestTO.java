package com.harvraja.myclerk.shared;

import com.google.gwt.user.client.rpc.IsSerializable;

public class ServiceRequestTO implements IsSerializable {
	private String username = null;
   private String type = null;
   private String description = null;
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}

}
