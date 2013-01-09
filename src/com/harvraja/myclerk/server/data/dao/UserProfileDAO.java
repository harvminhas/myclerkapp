package com.harvraja.myclerk.server.data.dao;

import com.harvraja.myclerk.server.data.MongoDBUtil;
import com.harvraja.myclerk.shared.InvalidCredentialsException;
import com.harvraja.myclerk.shared.UserAlreadyExistsException;
import com.harvraja.myclerk.shared.UserProfile;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

public class UserProfileDAO extends AbstractDAO {
   public void saveUserProfile(UserProfile user) throws UserAlreadyExistsException{
	   DBCollection coll= MongoDBUtil.getCollection("users");
	   super.setCollection(MongoDBUtil.getCollection("users"));
	   if(!super.exists("username", user.getUsername())){
		  
		   BasicDBObject db = new BasicDBObject();
		   System.out.println("username; " + user.getUsername());
		   db.put("username", user.getUsername());
		   db.put("firstname", user.getFname());
		   db.put("lastname", user.getLname());
		   db.put("password", user.getPassword());
		   db.put("city", user.getCity());
		   super.insert(db);
	   }else{
		   throw new UserAlreadyExistsException("The username already exists.");
	   }
   }
   public UserProfile login(UserProfile user) throws InvalidCredentialsException{
	   DBCollection coll= MongoDBUtil.getCollection("users");
	   super.setCollection(MongoDBUtil.getCollection("users"));
	   UserProfile retObj = new UserProfile();
	   BasicDBObject query=new BasicDBObject();
       query.put("username", user.getUsername());
       query.put("password", user.getPassword());
       DBCursor find=super.getCollection().find(query);
       if(find.hasNext()){
    	   DBObject db = find.next();
    	   retObj.setUsername((String) db.get("username"));
    	   retObj.setFname((String)db.get("firstname"));
    	   retObj.setLname((String) db.get("lastname"));
           
       }else{
    	   throw new InvalidCredentialsException("Credentials provided don't match. Please fix and try again.");
       }
       return retObj;
   }
}
