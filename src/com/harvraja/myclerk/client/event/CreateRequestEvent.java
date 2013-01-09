package com.harvraja.myclerk.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class CreateRequestEvent extends GwtEvent<CreateRequestEventHandler>{
public static Type<CreateRequestEventHandler> TYPE = new Type<CreateRequestEventHandler>();
	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<CreateRequestEventHandler> getAssociatedType() {
		// TODO Auto-generated method stub
		return TYPE;
	}

	@Override
	protected void dispatch(CreateRequestEventHandler handler) {
		// TODO Auto-generated method stub
		handler.onCreateRequest(this);
	}

}
