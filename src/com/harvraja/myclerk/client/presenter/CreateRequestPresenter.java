package com.harvraja.myclerk.client.presenter;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.web.bindery.event.shared.HandlerRegistration;
import com.harvraja.myclerk.client.MyClerkServiceAsync;
import com.harvraja.myclerk.client.event.MovingRequestEvent;
import com.harvraja.myclerk.client.event.PlumbingRequestEvent;

/**
 * 
 * @author Rav To add new request 1. Add method to display to get link 2. In
 *         bind method add click on link handler
 * 
 */
public class CreateRequestPresenter extends AbstractPresenter {
	private final Display display;
	private HandlerRegistration clickRegistration = null;
	private HandlerRegistration movingClickRegistration = null;

	public interface Display {
		HasClickHandlers getResiPlumbingLink();

		HasClickHandlers getCommPlumbingLink();

		Widget asWidget();

		HasClickHandlers getResiMovingLink();

		HasClickHandlers getCommMovingLink();
	}

	public CreateRequestPresenter(MyClerkServiceAsync rpcService,
			HandlerManager eventBus, Display view) {
		super(rpcService, eventBus);
		this.display = view;
	}

	@SuppressWarnings("static-access")
	@Override
	public void go(final RootPanel container) {
		bind();
		container.get("mainPanel").clear();
		container.get("menu").clear();
		container.get("mainPanel").add(display.asWidget());
		container.get("menu").add(menu.asWidget());
	}

	private void bind() {
		clearClickHandlers();

		super.commonBind();
		clickRegistration = display.getResiPlumbingLink().addClickHandler(
				new ClickHandler() {

					public void onClick(ClickEvent event) {
						System.out
								.println("Plumbing - Get Quote button clicked.");
						firePlumbingRequestEvent();

					}
				});
		System.out.println("binding");
		movingClickRegistration = display.getResiMovingLink().addClickHandler(
				new ClickHandler() {

					public void onClick(ClickEvent event) {
						System.out
								.println("Moving - Get Quote button clicked.");
						fireMovingRequestEvent();

					}
				});
	}

	private void fireMovingRequestEvent() {
		// movingClickRegistration.removeHandler();
		eventBus.fireEvent(new MovingRequestEvent());
	}

	private void firePlumbingRequestEvent() {
		clickRegistration.removeHandler();
		eventBus.fireEvent(new PlumbingRequestEvent());
	}

	@Override
	protected void selectMenuLink() {
		// TODO Auto-generated method stub
		menu.CreateRequestLnkSelected();
	}

	private void clearClickHandlers() {
		if (clickRegistration != null)
			clickRegistration.removeHandler();
		if (movingClickRegistration != null)
			movingClickRegistration.removeHandler();
	}

}
