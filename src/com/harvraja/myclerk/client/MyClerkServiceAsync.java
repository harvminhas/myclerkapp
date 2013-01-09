package com.harvraja.myclerk.client;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.harvraja.myclerk.shared.ServiceRequestTO;
import com.harvraja.myclerk.shared.UserProfile;

public interface MyClerkServiceAsync {

	void createUser(UserProfile user, AsyncCallback<String> callback);

	void createSupplier(AsyncCallback<Boolean> callback);

	void createRequest(ServiceRequestTO sr, AsyncCallback<ServiceRequestTO> callback);

	void createResponse(AsyncCallback<Boolean> callback);

	void login(UserProfile user, AsyncCallback<UserProfile> callback);

	void getRequests(String username,
			AsyncCallback<ArrayList<ServiceRequestTO>> callback);

}
