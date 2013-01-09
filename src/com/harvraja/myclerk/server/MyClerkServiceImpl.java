package com.harvraja.myclerk.server;

import java.util.ArrayList;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.harvraja.myclerk.client.MyClerkService;
import com.harvraja.myclerk.server.data.ServiceRequest;
import com.harvraja.myclerk.server.data.dao.ServiceRequestDAO;
import com.harvraja.myclerk.server.data.dao.UserProfileDAO;
import com.harvraja.myclerk.shared.InvalidCredentialsException;
import com.harvraja.myclerk.shared.ServiceRequestTO;
import com.harvraja.myclerk.shared.UserAlreadyExistsException;
import com.harvraja.myclerk.shared.UserProfile;

public class MyClerkServiceImpl extends RemoteServiceServlet implements
		MyClerkService {

	@Override
	public String createUser(UserProfile user) throws IllegalArgumentException, UserAlreadyExistsException {
		UserProfileDAO dao = new UserProfileDAO();
		dao.saveUserProfile(user);
		return "Done";
	}

	@Override
	public boolean createSupplier() throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return false;
	}
     
	@Override
	public ServiceRequestTO createRequest(ServiceRequestTO srto) throws IllegalArgumentException {
		// TODO Auto-generated method stub
	
		ServiceRequest sr = new ServiceRequest();
		sr.setTitle(srto.getType());
		sr.setDescription(srto.getDescription());
		sr.setUsername(srto.getUsername());
		ServiceRequestDAO dao = new ServiceRequestDAO();
		dao.createNewRequest(sr);
		return null;
	}

	@Override
	public boolean createResponse() throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public UserProfile login(UserProfile user) throws IllegalArgumentException,
			InvalidCredentialsException {
		UserProfileDAO dao = new UserProfileDAO();
		return dao.login(user);
	}

	@Override
	public ArrayList<ServiceRequestTO> getRequests(String username) {
		// TODO Auto-generated method stub
		ServiceRequestDAO dao = new ServiceRequestDAO();
		return dao.getByUsername(username);
	}

}
