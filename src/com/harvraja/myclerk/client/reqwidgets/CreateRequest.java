package com.harvraja.myclerk.client.reqwidgets;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.InlineHyperlink;
import com.harvraja.myclerk.client.presenter.*;
import com.harvraja.myclerk.client.reqwidgets.requests.MovingRequest;
import com.harvraja.myclerk.client.reqwidgets.requests.PlumbingRequest;
import com.google.gwt.user.client.ui.Hyperlink;

public class CreateRequest extends Composite implements HasText,
		CreateRequestPresenter.Display {
	private static CreateRequest singleton;

	public static CreateRequest getInstance() {
		if (singleton == null)
			singleton = new CreateRequest();
		singleton.plumbingPanel.setVisible(false);
		singleton.movingPanel.setVisible(false);
		return singleton;
	}

	public static boolean isPanelLoaded = false;
	public static boolean isMovingPanelLoaded = false;

	private static CreateRequestUiBinder uiBinder = GWT
			.create(CreateRequestUiBinder.class);

	interface CreateRequestUiBinder extends UiBinder<Widget, CreateRequest> {
	}

	private CreateRequest() {

		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiField
	VerticalPanel plumbingPanel;
	@UiField
	InlineHyperlink lnkPlumbing;
	@UiField
	Hyperlink commPlumbingLnk;
	@UiField
	Hyperlink resiPlumbingLnk;
	@UiField
	Hyperlink movingLnk;
	@UiField
	Hyperlink commMovingLnk;
	@UiField
	Hyperlink resiMovingLnk;
	@UiField
	VerticalPanel movingPanel;

	@Override
	public String getText() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setText(String text) {
		// TODO Auto-generated method stub

	}

	@UiHandler("lnkPlumbing")
	void onLnkPlumbingClick(ClickEvent event) {
		if (plumbingPanel.isVisible())
			plumbingPanel.setVisible(false);
		else
			plumbingPanel.setVisible(true);
	}

	@Override
	public HasClickHandlers getResiMovingLink() {
		// TODO Auto-generated method stub
		return resiMovingLnk;
	}
	@Override
	public HasClickHandlers getCommMovingLink() {
		// TODO Auto-generated method stub
		return commMovingLnk;
	}

	@Override
	public HasClickHandlers getResiPlumbingLink() {
		// TODO Auto-generated method stub
		return resiPlumbingLnk;
	}

	@Override
	public HasClickHandlers getCommPlumbingLink() {
		// TODO Auto-generated method stub
		return commPlumbingLnk;
	}

	@UiHandler("movingLnk")
	void onMovingLnkClick(ClickEvent event) {
		if (movingPanel.isVisible())
			movingPanel.setVisible(false);
		else
			movingPanel.setVisible(true);
	}
}
