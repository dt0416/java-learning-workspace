package com.gb.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("hello")
public interface HelloService extends RemoteService {
    public String hello(String name);
}
