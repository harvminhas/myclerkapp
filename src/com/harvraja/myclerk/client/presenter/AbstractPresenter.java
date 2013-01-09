package com.harvraja.myclerk.client.presenter;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.storage.client.Storage;
import com.google.gwt.user.client.ui.HasWidgets;
import com.harvraja.myclerk.client.MyClerkServiceAsync;
import com.harvraja.myclerk.client.event.CreateRequestEvent;
import com.harvraja.myclerk.client.event.HomeEvent;
import com.harvraja.myclerk.client.event.SignInEvent;
import com.harvraja.myclerk.client.event.SignUpEvent;
import com.harvraja.myclerk.client.event.ViewRequestsEvent;
import com.harvraja.myclerk.client.reqwidgets.MainMenu;

public abstract class AbstractPresenter implements Presenter {
	protected  HandlerManager eventBus = null;
	protected  MyClerkServiceAsync rpcService = null;
	protected HasWidgets container;
	protected MainMenu menu;
	protected String loggedUser;
  protected AbstractPresenter(MyClerkServiceAsync rpcService, HandlerManager eventBus){
	  this.eventBus = eventBus;
      
      this.rpcService = rpcService;
      menu = MainMenu.getInstance(eventBus);
      this.selectMenuLink();
      Storage clientStore = Storage.getSessionStorageIfSupported();
	    this.loggedUser =  clientStore.getItem("username");
	    System.out.println("Logged user is: " + loggedUser);
      if(loggedUser == null)
      	menu.setMenu(false);
      else
      	menu.setMenu(true);
  }
  protected abstract void selectMenuLink();
  protected MyClerkServiceAsync getRPCService(){
	  return rpcService;
  }
  protected void commonBind(){
	  
  }
  
}
