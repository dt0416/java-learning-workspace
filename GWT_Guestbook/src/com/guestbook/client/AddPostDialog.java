package com.guestbook.client;

import java.util.Date;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;

public class AddPostDialog extends DialogBox {
    private TextBox nicknameTextBox;
    private TextBox titleTextBox;
    private TextArea contentTextArea;

    public AddPostDialog() {
        
        DockPanel dockPanel = new DockPanel();
        setWidget(dockPanel);
        dockPanel.setSize("198px", "161px");
        
        HorizontalPanel horizontalPanel = new HorizontalPanel();
        dockPanel.add(horizontalPanel, DockPanel.NORTH);
        dockPanel.setCellHorizontalAlignment(horizontalPanel, HasHorizontalAlignment.ALIGN_CENTER);
        
        Label label = new Label("新增留言");
        label.setStyleName("dialog-Title");
        horizontalPanel.add(label);
        label.setWidth("81px");
        
        FlexTable flexTable = new FlexTable();
        dockPanel.add(flexTable, DockPanel.CENTER);
        dockPanel.setCellHorizontalAlignment(flexTable, HasHorizontalAlignment.ALIGN_CENTER);
        flexTable.setSize("355px", "183px");
        
        Label lblNewLabel = new Label("暱稱：");
        flexTable.setWidget(0, 0, lblNewLabel);
        
        nicknameTextBox = new TextBox();
        flexTable.setWidget(0, 1, nicknameTextBox);
        
        Label lblNewLabel_1 = new Label("標題：");
        flexTable.setWidget(1, 0, lblNewLabel_1);
        
        titleTextBox = new TextBox();
        flexTable.setWidget(1, 1, titleTextBox);
        
        Label lblNewLabel_2 = new Label("留言內容：");
        flexTable.setWidget(2, 0, lblNewLabel_2);
        
        contentTextArea = new TextArea();
        flexTable.setWidget(2, 1, contentTextArea);
        
        HorizontalPanel horizontalPanel_1 = new HorizontalPanel();
        dockPanel.add(horizontalPanel_1, DockPanel.SOUTH);
        dockPanel.setCellHorizontalAlignment(horizontalPanel_1, HasHorizontalAlignment.ALIGN_CENTER);
        
        Button saveButton = new Button("New button");
        saveButton.setStyleName("dialog-Title");
        saveButton.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                String nickname = nicknameTextBox.getText();
                String title = titleTextBox.getText();
                String content = contentTextArea.getText();
//                Date date = new Date();
//                Post post = new Post(nickname, title, content, date);
                Post post = new Post(nickname, title, content);
                // 呼叫Server端
                PostServiceAsync postService = (PostServiceAsync)GWT.create(PostService.class);
                postService.savePost(post, new AsyncCallback<Boolean>() {
                    
                    @Override
                    public void onSuccess(Boolean result) {
                        hide();
                        Window.alert(result ? "留言已儲存" : "儲存失敗");
                    }
                    
                    @Override
                    public void onFailure(Throwable caught) {
                        Window.alert("遠端呼叫失敗");
                    }
                });
            }
        });
        saveButton.setText("新增");
        horizontalPanel_1.add(saveButton);
        
        Button cancelButton = new Button("New button");
        cancelButton.setStyleName("dialog-Title");
        cancelButton.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                hide();
            }
        });
        cancelButton.setText("取消");
        horizontalPanel_1.add(cancelButton);
        
    }
}
