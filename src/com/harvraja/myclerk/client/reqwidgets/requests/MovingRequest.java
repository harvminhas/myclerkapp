package com.harvraja.myclerk.client.reqwidgets.requests;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.MenuItem;
import com.harvraja.myclerk.client.presenter.MovingRequestPresenter;
import com.harvraja.myclerk.client.reqwidgets.common.AddressWidget;

public class MovingRequest extends Composite   implements HasText, MovingRequestPresenter.Display {
	
	private static MovingRequest singleton;
	public static MovingRequest getInstance(){
		if(singleton == null)
			singleton = new MovingRequest();
		return singleton;
	}
	

	private static CreateRequestWidgetUiBinder uiBinder = GWT
			.create(CreateRequestWidgetUiBinder.class);
	@UiField
	VerticalPanel requestPanel;
	@UiField
	ListBox movingType;
	@UiField AddressWidget fromCityWidget;
	@UiField AddressWidget toCityWidget;
	@UiField Button submit;
	@Override
	public HasClickHandlers getMoveTypeList() {
		// TODO Auto-generated method stub
		return movingType;
	}
	@Override
	public AddressWidget getFromCityWidget() {
		// TODO Auto-generated method stub
		return fromCityWidget;
	}
	@Override
	public AddressWidget getToCityWidget() {
		// TODO Auto-generated method stub
		return toCityWidget;
	}
	interface CreateRequestWidgetUiBinder extends
			UiBinder<Widget, MovingRequest> {
	}

	private MovingRequest() {
		initWidget(uiBinder.createAndBindUi(this));
		movingType.addItem("Long Distance Move", "Long Distance Move");
		movingType.addItem("Local Move", "Local Move");
		movingType.setFocus(true);
	
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




	@Override
	public HasClickHandlers getSubmitButton() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public void setErrorMesage(String msg) {
		// TODO Auto-generated method stub
		
	}

}
