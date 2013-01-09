package com.harvraja.myclerk.client.event;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

public class SignUpEvent extends GwtEvent<SignUpEventHandler> {
	public static Type<SignUpEventHandler> TYPE = new Type<SignUpEventHandler>();
	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<SignUpEventHandler> getAssociatedType() {
		// TODO Auto-generated method stub
		return TYPE;
	}

	@Override
	protected void dispatch(SignUpEventHandler handler) {
		// TODO Auto-generated method stub
		handler.onSignUp(this);
	}

}
