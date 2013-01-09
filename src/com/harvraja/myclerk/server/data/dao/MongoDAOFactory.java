package com.harvraja.myclerk.server.data.dao;

import com.mongodb.DBCollection;

public class MongoDAOFactory {
	private static final DBCollection MongoDBUtil = null;

	public static ServiceRequestDAO getServiceRequestDao() {
		return (ServiceRequestDAO) getDAOByClassAndName(
				ServiceRequestDAO.class, "serviceRequets"); //collection name
	}

	public static AbstractDAO getDAOByClassAndName(Class c, String name) {
		try {
			DBCollection collection = getCollection(name);

			AbstractDAO d = (AbstractDAO) c.newInstance();
			d.setCollection(collection);
			return d;
		} catch (InstantiationException ex) {
			ex.printStackTrace();
		} catch (IllegalAccessException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public static DBCollection getCollection(String name) {
		return MongoDBUtil.getCollection(name);
	}
}
