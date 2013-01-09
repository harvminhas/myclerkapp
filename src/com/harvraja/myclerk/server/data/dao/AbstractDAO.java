package com.harvraja.myclerk.server.data.dao;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

public class AbstractDAO {
    
    private DBCollection collection;
    private Class cla;
    
    public AbstractDAO(){
        
    }

    
   
    public DBCollection getCollection() {
        return collection;
    }

   
    public void setCollection(DBCollection collection) {
        this.collection = collection;
    }
    
    public DBCursor getAll(){
        DBCursor find=collection.find();
        return find;
    }
    public void insert(BasicDBObject dbObject){
    	System.out.println("Inserting dbobje");
        collection.insert(dbObject);
    }
    public void remove(BasicDBObject dbObject){
        collection.remove(dbObject);
    }
    public void update(BasicDBObject old,BasicDBObject dbObject){
        collection.update(old, dbObject);
    }
    public DBObject getByID(int id){
        DBObject returnObject=null;
        BasicDBObject query=new BasicDBObject();
        query.put("id", new Integer(id));
        DBCursor find=collection.find(query);
        while(find.hasNext()){
            returnObject=find.next();
            
        }
        return returnObject;
    }
    
    public boolean exists(String key, String value){
        DBObject returnObject=null;
        BasicDBObject query=new BasicDBObject();
        query.put(key, value);
        DBCursor find=collection.find(query);
        while(find.hasNext()){
            return true;
            
        }
        return false;
    }

   
}
