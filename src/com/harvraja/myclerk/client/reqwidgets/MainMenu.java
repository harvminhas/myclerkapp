package com.harvraja.myclerk.client.reqwidgets;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.storage.client.Storage;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.MenuItem;
import com.google.gwt.user.client.ui.InlineHyperlink;
import com.harvraja.myclerk.client.event.CreateRequestEvent;
import com.harvraja.myclerk.client.event.HomeEvent;
import com.harvraja.myclerk.client.event.SignInEvent;
import com.harvraja.myclerk.client.event.SignUpEvent;
import com.harvraja.myclerk.client.event.ViewRequestsEvent;
import com.harvraja.myclerk.client.presenter.IMenu;

public class MainMenu extends Composite implements HasText, IMenu {
    private static MainMenu singleton;
	private static MainMenuUiBinder uiBinder = GWT
			.create(MainMenuUiBinder.class);
	@UiField InlineHyperlink lnkSignUp;
	@UiField InlineHyperlink lnkCreateRequest;
	@UiField InlineHyperlink lnkSignIn;
	@UiField InlineHyperlink lnkViewRequest;
	@UiField InlineHyperlink lnkHome;
	@UiField InlineHyperlink lnkSignOut;
	HandlerManager eventBus;
	interface MainMenuUiBinder extends UiBinder<Widget, MainMenu> {
	}
	public static MainMenu getInstance(HandlerManager eventBus){
    	if(singleton == null){
    		singleton = new MainMenu();
    		singleton.eventBus = eventBus;
    		singleton.commonBind();
    	}
		return singleton;
    }
	private MainMenu() {
		initWidget(uiBinder.createAndBindUi(this));
		
	}
	public void setMenu(boolean isLoggedIn){
		if(!isLoggedIn){
			lnkSignUp.setVisible(true);
			lnkSignIn.setVisible(true);
			lnkCreateRequest.setVisible(false);
			lnkViewRequest.setVisible(false);
			lnkSignOut.setVisible(false);
		}else{
			lnkSignUp.setVisible(false);
			lnkSignIn.setVisible(false);
			lnkCreateRequest.setVisible(true);
			lnkViewRequest.setVisible(true);
			lnkSignOut.setVisible(true);
		}
	}

	public MainMenu(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public String getText() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setText(String text) {
		// TODO Auto-generated method stub
		
	}
	public void disableItem(String name){
		if( name.equals("signup"))
		lnkSignUp.setText("SIGN UP");
		else if(name.equals("lnkCreateRequest")){
			lnkCreateRequest.setText("CREATE REQUEST");
			//lnkCreateRequest.
		}
	}
	@Override
	public HasClickHandlers getCreateRequestLnk() {
		// TODO Auto-generated method stub
		return lnkCreateRequest;
	}
	@Override
	public HasClickHandlers getSignInLnk() {
		// TODO Auto-generated method stub
		return lnkSignIn;
	}
	@Override
	public HasClickHandlers getSignOutLnk() {
		// TODO Auto-generated method stub
		return lnkSignOut;
	}
	@Override
	public HasClickHandlers getSignUpLnk() {
		// TODO Auto-generated method stub
		return lnkSignUp;
	}
	@Override
	public HasClickHandlers getViewRequestLnk() {
		// TODO Auto-generated method stub
		return lnkViewRequest;
	}
	@Override
	public HasClickHandlers getHomeLnk() {
		// TODO Auto-generated method stub
		return lnkHome;
	}
	@Override
	public void SignInLnkSelected() {
		lnkHome.setHTML("HOME");
		lnkCreateRequest.setHTML("Create Requests");
		lnkViewRequest.setHTML("View Requests");
		lnkSignUp.setHTML("Sign Up");
		lnkSignIn.setHTML("<b><u>Sign In</u></b>");
	}
	@Override
	public void SignUpLnkSelected() {
		lnkHome.setHTML("HOME");
		lnkCreateRequest.setHTML("Create Requests");
		lnkViewRequest.setHTML("View Requests");
		lnkSignUp.setHTML("<b><u>Sign Up</u></b>");
		lnkSignIn.setHTML("Sign In");
	}
	@Override
	public void CreateRequestLnkSelected() {
		lnkHome.setHTML("HOME");
		lnkCreateRequest.setHTML("<b><u>Create Requests</u></b>");
		lnkViewRequest.setHTML("View Requests");
		lnkSignUp.setHTML("Sign Up");
		lnkSignIn.setHTML("Sign In");
	}
	@Override
	public void ViewRequestLnkSelected() {
		lnkHome.setHTML("HOME");
		lnkCreateRequest.setHTML("Create Requests");
		lnkViewRequest.setHTML("<b><u>View Requests</u></b>");
		lnkSignUp.setHTML("Sign Up");
		lnkSignIn.setHTML("Sign In");
	}
	@Override
	public void HomeLnkSelected() {
		// TODO Auto-generated method stub
		lnkHome.setHTML("<b><u>HOME</u></b>");
		lnkCreateRequest.setHTML("Create Requests");
		lnkViewRequest.setHTML("View Requests");
		lnkSignUp.setHTML("Sign Up");
		lnkSignIn.setHTML("Sign In");
		
	}
	public void plumbingLinkSelected() {
		// TODO Auto-generated method stub
		lnkHome.setHTML("HOME");
		lnkCreateRequest.setHTML("<b><u>Create Requests</u></b>");
		lnkViewRequest.setHTML("View Requests");
		lnkSignUp.setHTML("Sign Up");
		lnkSignIn.setHTML("Sign In");
	}
	
	
	protected void commonBind(){
		  System.out.println("BINDING - COMMON");
		  getSignUpLnk().addClickHandler(new ClickHandler() {   
		      public void onClick(ClickEvent event) {
		        eventBus.fireEvent(new SignUpEvent());
		      }
		    });
		  getSignOutLnk().addClickHandler(new ClickHandler(){

			@Override
			public void onClick(ClickEvent event) {
				System.out.println("Singout link clicked");
				// TODO Auto-generated method stub
				Storage clientStore = Storage.getSessionStorageIfSupported();
				clientStore.clear();
				System.out.println("common Bind: Firing Home Event");
				eventBus.fireEvent(new HomeEvent());
			}
			  
		  });
		getSignInLnk().addClickHandler(new ClickHandler() {   
		      public void onClick(ClickEvent event) {
		        eventBus.fireEvent(new SignInEvent());
		      }
		    });

		getHomeLnk().addClickHandler(new ClickHandler() {   
		      public void onClick(ClickEvent event) {
		        eventBus.fireEvent(new HomeEvent());
		      }
		    });
		getCreateRequestLnk().addClickHandler(new ClickHandler() {   
		      public void onClick(ClickEvent event) {
		        eventBus.fireEvent(new CreateRequestEvent());
		      }
		    });
		getViewRequestLnk().addClickHandler(new ClickHandler() {   
		      public void onClick(ClickEvent event) {
		        eventBus.fireEvent(new ViewRequestsEvent());
		      }
		    });
	  }

}
