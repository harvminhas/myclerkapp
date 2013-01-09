package com.harvraja.myclerk.client.reqwidgets;

import java.util.ArrayList;
import java.util.Iterator;

import com.google.gwt.cell.client.CheckboxCell;
import com.google.gwt.cell.client.EditTextCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.harvraja.myclerk.shared.ServiceRequestTO;
import com.harvraja.myclerk.client.presenter.*;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.DataGrid;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.FlexTable;

public class ViewRequests extends Composite implements ViewRequestsPresenter.Display {
	private static ViewRequests singleton;
    public static ViewRequests getInstance(){
    	if(singleton == null)
    		singleton = new ViewRequests();
    	return singleton;
    }
	private static ViewRequestsUiBinder uiBinder = GWT
			.create(ViewRequestsUiBinder.class);
	@UiField FlexTable reqTable;

	interface ViewRequestsUiBinder extends UiBinder<Widget, ViewRequests> {
	}

	private ViewRequests() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public void setErrorMesage(String msg) {
		// TODO Auto-generated method stub
		System.out.println("The errormessage is: " + msg);
	}

	@Override
	public void setRequests(ArrayList<ServiceRequestTO> reqs) {
		reqTable.removeAllRows();
		// TODO Auto-generated method stub
		for(int i=0; i<reqs.size(); i++){
			ServiceRequestTO to = reqs.get(i);
			int row = reqTable.getRowCount();
			reqTable.setWidget(reqTable.getRowCount(), 0, new Label(to.getType() + "-" + to.getDescription()));
		}
	}

}
