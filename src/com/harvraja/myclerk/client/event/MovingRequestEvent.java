package com.harvraja.myclerk.client.event;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

public class MovingRequestEvent extends GwtEvent<MovingRequestEventHandler> {
	public static Type<MovingRequestEventHandler> TYPE = new Type<MovingRequestEventHandler>();
	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<MovingRequestEventHandler> getAssociatedType() {
		// TODO Auto-generated method stub
		return TYPE;
	}

	@Override
	protected void dispatch(MovingRequestEventHandler handler) {
		// TODO Auto-generated method stub
		handler.onCreateRequest(this);
	}

}
