package com.harvraja.myclerk.client.reqwidgets;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.InlineHyperlink;
import com.google.gwt.user.client.ui.Widget;
import com.harvraja.myclerk.client.presenter.HomePresenter;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.VerticalPanel;

public class HomeView extends Composite implements HomePresenter.Display{
	private static HomeView singleton;
    public static HomeView getInstance(){
    	if(singleton == null)
    		singleton = new HomeView();
    	return singleton;
    }
	private static HomeViewUiBinder uiBinder = GWT
			.create(HomeViewUiBinder.class);
	@UiField VerticalPanel menuComposite;

	interface HomeViewUiBinder extends UiBinder<Widget, HomeView> {
	}

	private HomeView() {
		initWidget(uiBinder.createAndBindUi(this));
	}

}
