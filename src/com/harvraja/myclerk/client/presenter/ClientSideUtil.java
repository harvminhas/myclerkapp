package com.harvraja.myclerk.client.presenter;

import com.google.gwt.storage.client.Storage;

public class ClientSideUtil {
  public static String getUserNameFromLocalStorage(){
	  Storage clientStore = Storage.getLocalStorageIfSupported();
	  return clientStore.getItem("username");
  }
}
