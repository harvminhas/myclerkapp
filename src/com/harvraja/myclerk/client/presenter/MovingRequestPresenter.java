package com.harvraja.myclerk.client.presenter;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.web.bindery.event.shared.HandlerRegistration;
import com.harvraja.myclerk.client.MyClerkServiceAsync;
import com.harvraja.myclerk.client.event.HomeEvent;
import com.harvraja.myclerk.client.presenter.CreateRequestPresenter.Display;
import com.harvraja.myclerk.client.reqwidgets.common.AddressWidget;
import com.harvraja.myclerk.shared.ServiceRequestTO;

public class MovingRequestPresenter extends AbstractPresenter {
	private final Display display;
	private HandlerRegistration clickRegistration = null;

	public interface Display {
		HasClickHandlers getSubmitButton();

		Widget asWidget();

		String getType();

		

		void setErrorMesage(String msg);

		HasClickHandlers getMoveTypeList();

		AddressWidget getFromCityWidget();

		AddressWidget getToCityWidget();
	}

	public MovingRequestPresenter(MyClerkServiceAsync rpcService,
			HandlerManager eventBus, Display view) {
		super(rpcService, eventBus);
		System.out.println("INSIDE MOVING REQUEST PRESENTER");
		this.display = view;
	}

	@Override
	public void go(RootPanel container) {
		System.out.println("GO");
		bind();
		System.out.println("GO1");
		container.get("mainPanel").clear();
		System.out.println("GO2");
	    container.get("menu").clear();
	    System.out.println("GO3");
	    container.get("mainPanel").add(display.asWidget());
	    System.out.println("GO4");
	    container.get("menu").add(menu.asWidget());
	    System.out.println("GO5");
	}

	private void bind() {
		super.commonBind();

		clickRegistration = display.getSubmitButton().addClickHandler(
				new ClickHandler() {

					@Override
					public void onClick(ClickEvent event) {
						// TODO Auto-generated method stub
						/**ServiceRequestTO to = new ServiceRequestTO();
						to.setType(display.getType());
						to.setDescription(display.getDescription());**/
						System.out
								.println("Moving - click event caught onClick()");
						//saveRequest(to);
					}

				});

	}

	private void saveRequest(ServiceRequestTO to) {
		to.setUsername("raja");
		System.out.println("Moving - calling remote save request");
		rpcService.createRequest(to, new AsyncCallback<ServiceRequestTO>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				display.setErrorMesage(caught.getMessage());
			}

			public void onSuccess(ServiceRequestTO result) {
				System.out.println("Moving - save request successful");
				clickRegistration.removeHandler();
				clickRegistration = null;
				eventBus.fireEvent(new HomeEvent());

			}

		});
	}

	@Override
	protected void selectMenuLink() {
		// TODO Auto-generated method stub

	}

}
