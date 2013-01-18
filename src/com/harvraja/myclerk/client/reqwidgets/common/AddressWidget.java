/**
 * 
 */
package com.harvraja.myclerk.client.reqwidgets.common;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.ListBox;

/**
 * @author Rav
 * 
 */
public class AddressWidget extends Composite implements HasText {

	private static AddressWidgetUiBinder uiBinder = GWT
			.create(AddressWidgetUiBinder.class);
	@UiField
	ListBox ctryDropdown;
	@UiField
	ListBox stateDropdown;
	@UiField
	ListBox cityDropdown;

	interface AddressWidgetUiBinder extends UiBinder<Widget, AddressWidget> {
	}

	/**
	 * Because this class has a default constructor, it can be used as a binder
	 * template. In other words, it can be used in other *.ui.xml files as
	 * follows: <ui:UiBinder xmlns:ui="urn:ui:com.google.gwt.uibinder"
	 * xmlns:g="urn:import:**user's package**">
	 * <g:**UserClassName**>Hello!</g:**UserClassName> </ui:UiBinder> Note that
	 * depending on the widget that is used, it may be necessary to implement
	 * HasHTML instead of HasText.
	 */

	public AddressWidget() {
		initWidget(uiBinder.createAndBindUi(this));
		ctryDropdown.addItem("USA", "US");
		ctryDropdown.addItem("CAD", "Canada");

	}

	@Override
	public String getText() {
		// TODO Auto-generated method stub
		return getSelectedCountry() + "/" + getSelectedState() + "/" + getSelectedCity();
	}

	@Override
	public void setText(String text) {
		// TODO Auto-generated method stub

	}

	public String getSelectedCountry() {
		return ctryDropdown.getItemText(ctryDropdown.getSelectedIndex());
	}

	public String getSelectedState() {
		return stateDropdown.getItemText(stateDropdown.getSelectedIndex());
	}

	public String getSelectedCity() {
		return cityDropdown.getItemText(cityDropdown.getSelectedIndex());
	}

}
