package com.harvraja.myclerk.client.event;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

public class PlumbingRequestEvent extends GwtEvent<PlumbingRequestEventHandler> {
	public static Type<PlumbingRequestEventHandler> TYPE = new Type<PlumbingRequestEventHandler>();
	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<PlumbingRequestEventHandler> getAssociatedType() {
		// TODO Auto-generated method stub
		return TYPE;
	}

	@Override
	protected void dispatch(PlumbingRequestEventHandler handler) {
		// TODO Auto-generated method stub
		handler.onCreateRequest(this);
		
	}

}
