package com.harvraja.myclerk.client.presenter;

import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.RootPanel;

public abstract interface Presenter {
	public abstract void go(final RootPanel container);
}
