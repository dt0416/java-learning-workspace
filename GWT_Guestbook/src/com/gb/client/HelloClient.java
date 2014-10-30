package com.gb.client;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.ui.Label;

public class HelloClient extends Composite {
    private TextBox textBox;

    public HelloClient() {
        
        FlowPanel flowPanel = new FlowPanel();
        initWidget(flowPanel);
        
        Label lblNewLabel = new Label("RPC示範");
        flowPanel.add(lblNewLabel);
        
        textBox = new TextBox();
        flowPanel.add(textBox);
        
        Button btnNewButton = new Button("New button");
        btnNewButton.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                // 利用GWT 的RPC來實作AJAX
                HelloServiceAsync helloService = GWT.create(HelloService.class);
                helloService.hello(textBox.getText(), new AsyncCallback<String>() {
                    
                    @Override
                    public void onSuccess(String result) {
                        Window.alert(result);
                        
                    }
                    
                    @Override
                    public void onFailure(Throwable caught) {
                        Window.alert("ERROR");
                        
                    }
                });
            }
        });
        btnNewButton.setText("call");
        flowPanel.add(btnNewButton);
    }

}
