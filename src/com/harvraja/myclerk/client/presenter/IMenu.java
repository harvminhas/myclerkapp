package com.harvraja.myclerk.client.presenter;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.InlineHyperlink;
import com.google.gwt.user.client.ui.Widget;

public interface IMenu {
	HasClickHandlers getCreateRequestLnk();
    HasClickHandlers getSignInLnk();
    HasClickHandlers getSignUpLnk();
    HasClickHandlers getViewRequestLnk();
    HasClickHandlers getHomeLnk();
    void SignInLnkSelected();
    void SignUpLnkSelected();
    void CreateRequestLnkSelected();
    void ViewRequestLnkSelected();
    void HomeLnkSelected();
    Widget asWidget();
	HasClickHandlers getSignOutLnk();
}
