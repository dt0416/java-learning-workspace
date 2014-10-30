package com.gb.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface HelloServiceAsync {

    void hello(String name, AsyncCallback<String> callback);

}
