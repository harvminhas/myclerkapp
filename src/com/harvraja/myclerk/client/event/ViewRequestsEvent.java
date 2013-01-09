package com.harvraja.myclerk.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class ViewRequestsEvent extends GwtEvent<ViewRequestsEventHandler>{
public static Type<ViewRequestsEventHandler> TYPE = new Type<ViewRequestsEventHandler>();
	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<ViewRequestsEventHandler> getAssociatedType() {
		// TODO Auto-generated method stub
		return TYPE;
	}

	@Override
	protected void dispatch(ViewRequestsEventHandler handler) {
		// TODO Auto-generated method stub
		handler.onViewRequests(this);
	}

}
