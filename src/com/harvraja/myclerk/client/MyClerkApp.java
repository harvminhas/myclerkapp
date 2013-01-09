package com.harvraja.myclerk.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.storage.client.Storage;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;
/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class MyClerkApp implements EntryPoint {
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network "
			+ "connection and try again.";

	
	public void onModuleLoad() {
		System.out.println("INSIDE ON MODULE LOAD");
		GWT.setUncaughtExceptionHandler(new GWT.UncaughtExceptionHandler() {
			@Override
			public void onUncaughtException(Throwable e){
				Window.alert("Uncaught Exception:" +e.getMessage());
			}
			
		});
		MyClerkServiceAsync rpcService = GWT.create(MyClerkService.class);
	    HandlerManager eventBus = new HandlerManager(null);
	    AppController appViewer = new AppController(rpcService, eventBus, null);
	    appViewer.go(RootPanel.get());
		
		
		/**boolean isUserLoggedIn = false;
		
		String url = Window.Location.getHref();
	    if ( url.indexOf("CreateUser")>-1 ) {
	      CreateUser user = CreateUser.getInstance();
	      RootPanel.get("createUser").add(user);   
	      MainMenu menu = MainMenu.getInstance();
	      menu.setMenu(isUserLoggedIn);
	      menu.disableItem("signup");
	      RootPanel.get("menu").add(menu);
	    }else if(url.indexOf("ListServices")>-1){
	    	ListServices services = ListServices.getInstance();
	    	  RootPanel.get("listServices").add(services);   
		      MainMenu menu = MainMenu.getInstance();
		      menu.disableItem("lnkCreateRequest");
		      menu.setMenu(isUserLoggedIn);
		      RootPanel.get("menu").add(menu);
	    }else if(url.indexOf("Main")>-1){	    	 
		      MainMenu menu = MainMenu.getInstance();
		      menu.disableItem("lnkCreateRequest");
		      menu.setMenu(isUserLoggedIn);
		      RootPanel.get("menu").add(menu);
	    }**/
	}
	
}
