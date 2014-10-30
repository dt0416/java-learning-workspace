package com.gb.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;

public class AddPost implements EntryPoint {

    @Override
    public void onModuleLoad() {
        RootPanel rootPanel = RootPanel.get();
        
        Label lblNewLabel = new Label("暱稱:");
        rootPanel.add(lblNewLabel, 10, 10);
        
        TextBox textBox = new TextBox();
        rootPanel.add(textBox, 10, 36);
        
        TextBox textBox_1 = new TextBox();
        rootPanel.add(textBox_1, 10, 106);
        
        Label label = new Label("標題:");
        rootPanel.add(label, 10, 80);
        label.setSize("62px", "20px");
        
        Label label_1 = new Label("留言內容:");
        rootPanel.add(label_1, 10, 141);
        label_1.setSize("72px", "20px");
        
        TextArea textArea = new TextArea();
        rootPanel.add(textArea, 10, 173);
        textArea.setSize("285px", "171px");
        
        Button btnNewButton = new Button("New button");
        btnNewButton.setText("送出留言");
        rootPanel.add(btnNewButton, 10, 366);
    }
}
