package com.harvraja.myclerk.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class HomeEvent extends GwtEvent<HomeEventHandler>{
public static Type<HomeEventHandler> TYPE = new Type<HomeEventHandler>();
	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<HomeEventHandler> getAssociatedType() {
		// TODO Auto-generated method stub
		return TYPE;
	}

	@Override
	protected void dispatch(HomeEventHandler handler) {
		// TODO Auto-generated method stub
		handler.onHome(this);
	}

}
