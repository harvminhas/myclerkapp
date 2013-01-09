package com.harvraja.myclerk.client.presenter;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.storage.client.Storage;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.harvraja.myclerk.client.MyClerkServiceAsync;
import com.harvraja.myclerk.client.event.SignInEvent;
import com.harvraja.myclerk.client.event.SignUpEvent;
import com.harvraja.myclerk.client.reqwidgets.MainMenu;

public class SignupPresenter extends AbstractPresenter {
	
	private final Display display;

	public interface Display{
		HasClickHandlers getSubmitButton();
		
	    Widget asWidget();
	  }
	public SignupPresenter(MyClerkServiceAsync rpcService, HandlerManager eventBus, Display view){
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
		
	}
	@Override
	protected void selectMenuLink() {
		// TODO Auto-generated method stub
		menu.SignUpLnkSelected();
	}
	

}
