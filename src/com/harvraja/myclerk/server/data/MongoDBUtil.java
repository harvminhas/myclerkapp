package com.harvraja.myclerk.server.data;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import com.mongodb.MongoException;
import com.mongodb.WriteConcern;

import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MongoDBUtil {
    
    private static DB database;
    
    static{
        try {
            Mongo mongo=new Mongo("localhost",27017);
            database=mongo.getDB("myclerk");
            mongo.setWriteConcern(WriteConcern.SAFE);
        } catch (UnknownHostException ex) {
        	ex.printStackTrace();
            Logger.getLogger(MongoDBUtil.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MongoException ex) {
        	ex.printStackTrace();
            Logger.getLogger(MongoDBUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static DBCollection getCollection(String collectionName){
        
        return database.getCollection(collectionName);
    }
}
