package com.gb.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

public class UiBinderDemo implements EntryPoint {

    @Override
    public void onModuleLoad() {
        RootPanel rootPanel = RootPanel.get();
        
        ContactWidget contactWidget = new ContactWidget();
        rootPanel.add(contactWidget, 0, 0);
        contactWidget.setSize("274px", "233px");

        // 手動更新contactWidget裡的內容
        Contact contact = new Contact("Hank Tom", "tom@jo87.com", "0990123123", "http://j.snpy.org/worker.png");
        contactWidget.setContact(contact);
        
        // 示範RPC
        HelloClient helloClient = new HelloClient();
        rootPanel.add(helloClient, 0, 250);
    }
}
