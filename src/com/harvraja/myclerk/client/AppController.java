package com.harvraja.myclerk.client;

import com.google.gwt.core.client.impl.AsyncFragmentLoader.Logger;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.RootPanel;
import com.harvraja.myclerk.client.event.CreateRequestEvent;
import com.harvraja.myclerk.client.event.CreateRequestEventHandler;
import com.harvraja.myclerk.client.event.HomeEvent;
import com.harvraja.myclerk.client.event.HomeEventHandler;
import com.harvraja.myclerk.client.event.MovingRequestEvent;
import com.harvraja.myclerk.client.event.MovingRequestEventHandler;
import com.harvraja.myclerk.client.event.PlumbingRequestEvent;
import com.harvraja.myclerk.client.event.PlumbingRequestEventHandler;
import com.harvraja.myclerk.client.event.SignInEvent;
import com.harvraja.myclerk.client.event.SignInEventHandler;
import com.harvraja.myclerk.client.event.SignUpEvent;
import com.harvraja.myclerk.client.event.SignUpEventHandler;
import com.harvraja.myclerk.client.event.ViewRequestsEvent;
import com.harvraja.myclerk.client.event.ViewRequestsEventHandler;
import com.harvraja.myclerk.client.presenter.*;
import com.harvraja.myclerk.client.reqwidgets.CreateUser;
import com.harvraja.myclerk.client.reqwidgets.HomeView;
import com.harvraja.myclerk.client.reqwidgets.CreateRequest;
import com.harvraja.myclerk.client.reqwidgets.Login;
import com.harvraja.myclerk.client.reqwidgets.ViewRequests;
import com.harvraja.myclerk.client.reqwidgets.requests.MovingRequest;
import com.harvraja.myclerk.client.reqwidgets.requests.PlumbingRequest;

public class AppController implements Presenter, ValueChangeHandler<String> {
	private final HandlerManager eventBus;
	private final MyClerkServiceAsync rpcService;
	private RootPanel container;
	private String loggedUser;
	


	public AppController(MyClerkServiceAsync rpcService, HandlerManager eventBus, String loggedUser) {
		this.eventBus = eventBus;
		this.rpcService = rpcService;
		this.loggedUser = loggedUser;
		bind();
	}

	private void bind() {
		System.out.println("BINDING......");
		History.addValueChangeHandler(this);
		eventBus.addHandler(ViewRequestsEvent.TYPE,
				new ViewRequestsEventHandler() {
					@Override
					public void onViewRequests(ViewRequestsEvent event) {
						// TODO Auto-generated method stub
						doViewRequests();
					}

				});
		eventBus.addHandler(PlumbingRequestEvent.TYPE,
				new PlumbingRequestEventHandler() {

					@Override
					public void onCreateRequest(PlumbingRequestEvent event) {
						// TODO Auto-generated method stub
						System.out.println("create plumbing request");
						doPlumbingRequest();
					}

				});
		eventBus.addHandler(MovingRequestEvent.TYPE,
				new MovingRequestEventHandler() {

					@Override
					public void onCreateRequest(MovingRequestEvent event) {
						// TODO Auto-generated method stub
						System.out.println("create moving request");
						doMovingRequest();
					}

				});
		eventBus.addHandler(HomeEvent.TYPE,
				new HomeEventHandler() {

					@Override
					public void onHome(HomeEvent event) {
						// TODO Auto-generated method s
                          doSignOut();
					}

				});
		eventBus.addHandler(CreateRequestEvent.TYPE,
				new CreateRequestEventHandler() {

					@Override
					public void onCreateRequest(CreateRequestEvent event) {
						// TODO Auto-generated method stub
                      doCreateRequest();
					}

				});

		eventBus.addHandler(SignInEvent.TYPE, new SignInEventHandler() {

			@Override
			public void onSignIn(SignInEvent event) {
				// TODO Auto-generated method stub
				doSignIn();
			}

		});

		eventBus.addHandler(SignUpEvent.TYPE, new SignUpEventHandler() {

			@Override
			public void onSignUp(SignUpEvent event) {
				// TODO Auto-generated method stub
				doSignUp();
			}

		});
		eventBus.addHandler(PlumbingRequestEvent.TYPE, new PlumbingRequestEventHandler() {

			@Override
			public void onCreateRequest(PlumbingRequestEvent event) {
				doPlumbingRequest();
			}

		});

	}
    private void doPlumbingRequest(){
    	History.newItem(IEvents.CREATEPLUMBINGREQUEST_EVENT);
    }
    private void doMovingRequest(){
    	History.newItem(IEvents.CREATEMOVINGREQUEST_EVENT);
    }
	private void doCreateRequest() {
		History.newItem(IEvents.CREATEREQUEST_EVENT);
	}

	private void doSignIn() {
		History.newItem(IEvents.SIGNIN_EVENT);
	}
	private void doSignOut() {
		History.newItem(IEvents.SIGNOUT_EVENT);
	}

	private void doSignUp() {
		History.newItem(IEvents.SIGNUP_EVENT);
	}
	private void doHome(){
	  System.out.println("DO HOME");
		History.newItem(IEvents.MAIN_EVENT);
	}
	private void doViewRequests(){
		History.newItem(IEvents.VIEWREQUESTS_EVENT);
	}

	public void go(final RootPanel container) {
		this.container = container;
		System.out.println("TOKEN IS: " + History.getToken());
		if ("".equals(History.getToken())) {
			History.newItem(IEvents.MAIN_EVENT);
		} else {
			History.fireCurrentHistoryState();
		}
	}

	public void onValueChange(ValueChangeEvent<String> event) {
		String token = event.getValue();
		System.out.println(AppController.class.getName() + ": Onvalue change1: " + token);
		if (token != null) {
			Presenter presenter = null;

			if (token.equals(IEvents.MAIN_EVENT)) {
				presenter = new HomePresenter(rpcService, eventBus,
						HomeView.getInstance());
			}else if(token.equals(IEvents.SIGNOUT_EVENT)){
				presenter = new HomePresenter(rpcService, eventBus,
						HomeView.getInstance());
			}else if(token.equals(IEvents.CREATEREQUEST_EVENT)){
				presenter = new CreateRequestPresenter(rpcService, eventBus, CreateRequest.getInstance());
			}else if(token.equals(IEvents.VIEWREQUESTS_EVENT)){
				presenter = new ViewRequestsPresenter(rpcService, eventBus, ViewRequests.getInstance());
			}else if(token.equals(IEvents.SIGNIN_EVENT)){
				presenter = new SignInPresenter(rpcService, eventBus, Login.getInstance());
			}else if(token.equals(IEvents.SIGNUP_EVENT)){
				presenter = new SignupPresenter(rpcService, eventBus, CreateUser.getInstance());
			}else if(token.equals(IEvents.CREATEPLUMBINGREQUEST_EVENT)){
				presenter = new PlumbingRequestPresenter(rpcService, eventBus, PlumbingRequest.getInstance() );
			}else if(token.equals(IEvents.CREATEMOVINGREQUEST_EVENT)){
				
				presenter = new MovingRequestPresenter(rpcService, eventBus, MovingRequest.getInstance() );
			}
			
			/**
			 * else if (token.equals("createRequest")) { presenter = new
			 * EditContactPresenter(rpcService, eventBus, new
			 * EditContactView()); } else if (token.equals("signUp")) { presenter
			 * = new EditContactPresenter(rpcService, eventBus, new
			 * EditContactView()); }else if(token.equals("signIn")){
			 * 
			 * }
			 **/
			if (presenter != null) {
				presenter.go(container);
			}else{
				System.out.println(AppController.class.getName() + ": PRESENTER IS NULL");
			}
		}
	}
}
