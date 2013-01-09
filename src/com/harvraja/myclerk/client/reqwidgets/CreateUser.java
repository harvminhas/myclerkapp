/**
 * 
 */
package com.harvraja.myclerk.client.reqwidgets;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.URL;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.TextBox;
import com.harvraja.myclerk.client.MyClerkService;
import com.harvraja.myclerk.client.MyClerkServiceAsync;
import com.harvraja.myclerk.shared.FieldVerifier;
import com.harvraja.myclerk.shared.UserAlreadyExistsException;
import com.harvraja.myclerk.shared.UserProfile;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.harvraja.myclerk.client.presenter.*;

/**
 * @author Rav
 *
 */
public class CreateUser extends Composite implements HasText, SignupPresenter.Display {
	private static boolean isVisible = false;
    private static CreateUser singleton;
	private static CreateUserUiBinder uiBinder = GWT
			.create(CreateUserUiBinder.class);
	private final MyClerkServiceAsync myClerkService = GWT
			.create(MyClerkService.class);
	@UiField TextBox city;
	@UiField TextBox confirmpswd;
	@UiField TextBox pswd;
	@UiField TextBox uname;
	@UiField TextBox lname;
	@UiField TextBox fname;
	@UiField Button button;
	@UiField Label errorLbl;
	@UiField HTMLPanel topPanel;
	@UiField Label mssgLbl;
	
    public static CreateUser getInstance(){
    	if(singleton == null)
    		singleton = new CreateUser();
		return singleton;
    }
	interface CreateUserUiBinder extends UiBinder<Widget, CreateUser> {
	}

	/**
	 * Because this class has a default constructor, it can
	 * be used as a binder template. In other words, it can be used in other
	 * *.ui.xml files as follows:
	 * <ui:UiBinder xmlns:ui="urn:ui:com.google.gwt.uibinder"
	 *   xmlns:g="urn:import:**user's package**">
	 *  <g:**UserClassName**>Hello!</g:**UserClassName>
	 * </ui:UiBinder>
	 * Note that depending on the widget that is used, it may be necessary to
	 * implement HasHTML instead of HasText.
	 */
	private CreateUser() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	public CreateUser(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));

		// Can access @UiField after calling createAndBindUi
		button.setText(firstName);
	}

	public void setText(String text) {
		button.setText(text);
	}

	/**
	 * Gets invoked when the default constructor is called
	 * and a string is provided in the ui.xml file.
	 */
	public String getText() {
		return button.getText();
	}
	private UserProfile getSerializableObject(){
		UserProfile profile = new UserProfile();
		profile.setFname(fname.getText());
		profile.setLname(lname.getText());
		profile.setUsername(uname.getText());
		profile.setPassword(pswd.getText());
		profile.setCity(city.getText());
		return profile;
	}

	@UiHandler("button")
	void onButtonClick(ClickEvent event) {
		if(!FieldVerifier.isConfirmPasswordMatch(pswd.getText(), confirmpswd.getText()))
		{
			errorLbl.setText("Confirm password does not match the password. Please correct.");
			return;
		}
		myClerkService.createUser(this.getSerializableObject(), new AsyncCallback<String>() {
			public void onFailure(Throwable caught) {
				if( caught instanceof UserAlreadyExistsException ){
					errorLbl.setText(caught.getMessage());
				}
	            }
				@Override
				public void onSuccess(String result) {
					// TODO Auto-generated method stub
					mssgLbl.setText("Congratulations, You have been successfully added.");
				}
		});
	}

	@Override
	public HasClickHandlers getSubmitButton() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
