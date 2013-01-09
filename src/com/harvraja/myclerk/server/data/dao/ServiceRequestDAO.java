package com.harvraja.myclerk.server.data.dao;

import java.util.ArrayList;

import com.harvraja.myclerk.server.data.MongoDBUtil;
import com.harvraja.myclerk.server.data.ServiceRequest;
import com.harvraja.myclerk.shared.ServiceRequestTO;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

public class ServiceRequestDAO extends AbstractDAO {
	public ArrayList getByUsername(String username){
		super.setCollection(MongoDBUtil.getCollection("requests"));
		ArrayList list = new ArrayList();
        DBObject returnObject=null;
        BasicDBObject query=new BasicDBObject();
        System.out.println("uSERNAME IS: " + username);
        query.put("username", username);
        DBCursor find=super.getCollection().find(query);
        while(find.hasNext()){
            returnObject=find.next();
            ServiceRequestTO to = new ServiceRequestTO();
            to.setDescription((String)returnObject.get("description"));
            to.setType((String)returnObject.get("title"));
            list.add(to);
        }
        return list;
    }
	public void createNewRequest(ServiceRequest sr) {
		super.setCollection(MongoDBUtil.getCollection("requests"));
		BasicDBObject db = sr.createDBObject();
		super.insert(db);
	}
	
}
