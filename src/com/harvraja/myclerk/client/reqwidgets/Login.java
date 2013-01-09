package com.harvraja.myclerk.client.reqwidgets;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;
import com.harvraja.myclerk.client.presenter.SignInPresenter;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;

public class Login extends Composite implements HasText, SignInPresenter.Display {
	private static Login singleton;
    public static Login getInstance(){
    	if(singleton == null)
    		singleton = new Login();
    	return singleton;
    }
	private static LoginUiBinder uiBinder = GWT.create(LoginUiBinder.class);
	@UiField Button button;
	@UiField Label errorLbl;
	@UiField Label msgLbl;
	@UiField TextBox uname;
	@UiField TextBox passwd;

	interface LoginUiBinder extends UiBinder<Widget, Login> {
	}

	private Login() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	public Login(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));
		
	}

	public void setText(String text) {
		
	}

	public String getText() {
		return null;
	}


	@Override
	public void setErrorMessage(String text) {
		// TODO Auto-generated method stub
		this.errorLbl.setText(text);
	}

	@Override
	public void setMessage(String text) {
		// TODO Auto-generated method stub
		this.msgLbl.setText(text);
	}

	@Override
	public HasClickHandlers getSubmitButton() {
		// TODO Auto-generated method stub
		return this.button;
	}

	@Override
	public String getUserName() {
		// TODO Auto-generated method stub
		return this.uname.getText();
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.passwd.getText();
	}
}
