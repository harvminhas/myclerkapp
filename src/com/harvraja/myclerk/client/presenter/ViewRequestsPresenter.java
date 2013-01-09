package com.harvraja.myclerk.client.presenter;

import java.util.ArrayList;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.harvraja.myclerk.client.MyClerkServiceAsync;
import com.harvraja.myclerk.client.event.HomeEvent;
import com.harvraja.myclerk.client.presenter.ViewRequestsPresenter.Display;
import com.harvraja.myclerk.shared.ServiceRequestTO;

public class ViewRequestsPresenter extends AbstractPresenter {
	private final Display display;
	public ViewRequestsPresenter(MyClerkServiceAsync rpcService,
			HandlerManager eventBus, Display view) {
		super(rpcService, eventBus);
		this.display = view;
		// TODO Auto-generated constructor stub
	}
	
    public interface Display{
    	//HasClickHandlers getSubmitButton();
	    Widget asWidget();
	    void setErrorMesage(String msg);
	    void setRequests(ArrayList<ServiceRequestTO> reqs);
    }
	@Override
	public void go(RootPanel container) {
		bind();
		container.get("mainPanel").clear();
	    container.get("menu").clear();
	    container.get("mainPanel").add(display.asWidget());
	    container.get("menu").add(menu.asWidget());
	    
	    

	}
	private void bind(){
		super.commonBind();
		getData();
	}
	private void getData(){
		 rpcService.getRequests("raja",   new AsyncCallback<ArrayList<ServiceRequestTO>>() {

				@Override
				public void onFailure(Throwable caught) {
					// TODO Auto-generated method stub
					display.setErrorMesage(caught.getMessage());
				}

				@Override
				public void onSuccess(ArrayList<ServiceRequestTO> result) {
					// TODO Auto-generated method stub
					System.out.println("Total results: " + result.size());
					display.setRequests(result);
				}			
	  		});
	}
	@Override
	protected void selectMenuLink() {
		// TODO Auto-generated method stub
		menu.ViewRequestLnkSelected();
	}


}
