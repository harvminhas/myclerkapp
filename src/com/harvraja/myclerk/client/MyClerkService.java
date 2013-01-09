package com.harvraja.myclerk.client;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.harvraja.myclerk.shared.InvalidCredentialsException;
import com.harvraja.myclerk.shared.ServiceRequestTO;
import com.harvraja.myclerk.shared.UserAlreadyExistsException;
import com.harvraja.myclerk.shared.UserProfile;
@RemoteServiceRelativePath("myclerk")
public interface MyClerkService extends RemoteService {
	String createUser(UserProfile user) throws IllegalArgumentException, UserAlreadyExistsException;
	boolean createSupplier() throws IllegalArgumentException;
	ServiceRequestTO createRequest(ServiceRequestTO sr);
	boolean createResponse() throws IllegalArgumentException;
	UserProfile login(UserProfile user) throws IllegalArgumentException, InvalidCredentialsException;
    ArrayList<ServiceRequestTO> getRequests(String username);
}
