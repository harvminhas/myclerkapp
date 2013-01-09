package com.harvraja.myclerk.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class SignInEvent extends GwtEvent<SignInEventHandler>{
public static Type<SignInEventHandler> TYPE = new Type<SignInEventHandler>();
	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<SignInEventHandler> getAssociatedType() {
		// TODO Auto-generated method stub
		return TYPE;
	}

	@Override
	protected void dispatch(SignInEventHandler handler) {
		// TODO Auto-generated method stub
		handler.onSignIn(this);
	}
}
