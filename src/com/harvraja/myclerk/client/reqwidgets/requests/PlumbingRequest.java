package com.harvraja.myclerk.client.reqwidgets.requests;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.Widget;
import com.harvraja.myclerk.client.presenter.PlumbingRequestPresenter;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.event.dom.client.ClickEvent;

public class PlumbingRequest extends Composite implements HasText, PlumbingRequestPresenter.Display {
    private static PlumbingRequest singleton;
    public static PlumbingRequest getInstance(){
    	if(singleton == null)
    		singleton = new PlumbingRequest();
    	return singleton;
    }
	private static PlumbingRequestUiBinder uiBinder = GWT
			.create(PlumbingRequestUiBinder.class);
	@UiField ListBox listRequestTypes;
	@UiField Button submitBtn;
	@UiField TextArea descText;

	interface PlumbingRequestUiBinder extends UiBinder<Widget, PlumbingRequest> {
	}

	private PlumbingRequest() {
		initWidget(uiBinder.createAndBindUi(this));
		listRequestTypes.addItem("Leak", "Leak");
		listRequestTypes.addItem("Toilet Problem", "Toilet");
		listRequestTypes.addItem("Shower Problem", "Toilet");
		listRequestTypes.addItem("Bath Tub Problem", "Toilet");
		listRequestTypes.addItem("Kitchen Fixture Problem", "Toilet");
	}

	public PlumbingRequest(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));
		
	}

	public void setText(String text) {
		
	}

	public String getText() {
		return null;
	}

	@Override
	public HasClickHandlers getSubmitButton() {
		// TODO Auto-generated method stub
		return submitBtn;
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return listRequestTypes.getValue(listRequestTypes.getSelectedIndex());
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return descText.getText();
	}

	@Override
	public void setErrorMesage(String msg) {
		// TODO Auto-generated method stub
		
	}

	@UiHandler("submitBtn")
	void onSubmitBtnClick(ClickEvent event) {
	}
}
