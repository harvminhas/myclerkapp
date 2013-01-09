package com.harvraja.myclerk.server.data;

import java.util.ArrayList;

import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;

public  class ServiceRequest{
   private String username = null;
   public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

public String getTitle() {
	return title;
}

public void setTitle(String title) {
	this.title = title;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

private String title = null;
   private String description = null;
   private Integer _typeId;
   private ArrayList response = new ArrayList();
   
   public BasicDBObject createDBObject(){
	   BasicDBObject request = (BasicDBObject) BasicDBObjectBuilder.start()
			   .add("title", title)
			   .add("description", description)
			   .add("username", username).get();
	   return request;
   }
}
