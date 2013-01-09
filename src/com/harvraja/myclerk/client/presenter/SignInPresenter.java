package com.harvraja.myclerk.client.presenter;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.storage.client.Storage;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.harvraja.myclerk.client.MyClerkServiceAsync;
import com.harvraja.myclerk.client.event.CreateRequestEvent;
import com.harvraja.myclerk.client.event.HomeEvent;
import com.harvraja.myclerk.client.event.SignInEvent;
import com.harvraja.myclerk.client.event.SignUpEvent;
import com.harvraja.myclerk.client.event.ViewRequestsEvent;
import com.harvraja.myclerk.client.reqwidgets.MainMenu;
import com.harvraja.myclerk.shared.InvalidCredentialsException;
import com.harvraja.myclerk.shared.UserAlreadyExistsException;
import com.harvraja.myclerk.shared.UserProfile;

public class SignInPresenter extends AbstractPresenter {
	
	private final Display display;
	
	public interface Display{
		void setErrorMessage(String text);
		void setMessage(String text);
		String getUserName();
		String getPassword();
		HasClickHandlers getSubmitButton();
	    Widget asWidget();
	  }
	public SignInPresenter(MyClerkServiceAsync rpcService, HandlerManager eventBus, Display view){
		super(rpcService, eventBus);
		this.display = view;
	}
	@Override
	public void go(final RootPanel container) {
		bind();
		container.get("mainPanel").clear();
	    container.get("menu").clear();
	    container.get("mainPanel").add(display.asWidget());
	    container.get("menu").add(menu.asWidget());
        
	}
	private void bind(){	
		super.commonBind();
		display.getSubmitButton().addClickHandler(new ClickHandler() {   
		      public void onClick(ClickEvent event) {
		    	 
		    	  UserProfile user = new UserProfile();
		    	  user.setUsername(display.getUserName());
		    	  user.setPassword(display.getPassword());
		    	  System.out.println("Username is: " + user.getUsername() + "/" + user.getPassword());
		    	  
		    	 
		    	
		    	  rpcService.login(user, new AsyncCallback<UserProfile>() {

					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
						display.setErrorMessage(caught.getMessage());
					}

					public void onSuccess(
							UserProfile result) {
						// TODO Auto-generated method stub
						Storage clientStore = Storage.getSessionStorageIfSupported();
						clientStore.setItem("username", result.getUsername());
						eventBus.fireEvent(new HomeEvent());
						
					}
		  			
		  		});
		      }
		    });
		
		
	}
	@Override
	protected void selectMenuLink() {
		// TODO Auto-generated method stub
		menu.SignInLnkSelected();
	}
	

}
