package com.harvraja.myclerk.client.reqwidgets.requests;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
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

public class MovingRequest extends Composite implements HasText {
	
	private static MovingRequest singleton;
	public static MovingRequest getInstance(){
		if(singleton == null)
			singleton = new MovingRequest();
		return singleton;
	}
	Command moveCmd = new Command(){
		public void execute(){
			Window.alert("Move Command");
		}
	};
	Command plumbingCmd = new Command(){
		public void execute(){
			Window.alert("Plumbing Command");
		}
	};

	private static CreateRequestWidgetUiBinder uiBinder = GWT
			.create(CreateRequestWidgetUiBinder.class);

	interface CreateRequestWidgetUiBinder extends
			UiBinder<Widget, MovingRequest> {
	}

	private MovingRequest() {
		initWidget(uiBinder.createAndBindUi(this));
		movingType.addItem("Long Distance Move", "Long Distance Move");
		movingType.addItem("Local Move", "Local Move");
		movingType.setFocus(true);
		menuMove.setCommand(moveCmd);
		menuPlumbing.setCommand(plumbingCmd);
	}
	@UiField
	VerticalPanel requestPanel;
	@UiField
	ListBox movingType;
	@UiField MenuItem menuMove;
	@UiField MenuItem menuPlumbing;

	public MovingRequest(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));
		Label lbl1 = new Label("Type of Service");
		requestPanel.add(lbl1);
		
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

}
