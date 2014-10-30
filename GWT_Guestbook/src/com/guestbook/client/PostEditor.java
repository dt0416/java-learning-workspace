package com.guestbook.client;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.ui.TextArea;

public class PostEditor extends DialogBox {
    private Post post;
    private TextBox nickname;
    private TextBox title;
    private TextArea content;
    
    public PostEditor() {
        
        DockPanel dockPanel = new DockPanel();
        setWidget(dockPanel);
        
        FlexTable flexTable = new FlexTable();
        dockPanel.add(flexTable, DockPanel.CENTER);
        
        Label label = new Label("匿稱：");
        flexTable.setWidget(0, 0, label);
        
        nickname = new TextBox();
        flexTable.setWidget(0, 1, nickname);
        
        Label label_1 = new Label("標題：");
        flexTable.setWidget(1, 0, label_1);
        
        title = new TextBox();
        flexTable.setWidget(1, 1, title);
        
        Label label_2 = new Label("留言內容：");
        flexTable.setWidget(2, 0, label_2);
        
        content = new TextArea();
        flexTable.setWidget(2, 1, content);
        
        HorizontalPanel horizontalPanel = new HorizontalPanel();
        dockPanel.add(horizontalPanel, DockPanel.SOUTH);
        
        Button okButton = new Button("New button");
        okButton.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                PostServiceAsync postService = (PostServiceAsync) GWT.create(PostService.class);
                postService.updatePost(getNewPost(), new AsyncCallback<Boolean>() {
                    
                    @Override
                    public void onSuccess(Boolean result) {
                        Window.alert("修改成功");
                        hide();
                    }
                    
                    @Override
                    public void onFailure(Throwable caught) {
                        Window.alert("修改失敗");
                    }
                });
            }
        });
        okButton.setText("編輯");
        horizontalPanel.add(okButton);
        
        Button cancelButton = new Button("New button");
        cancelButton.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                // 隱藏
                hide();
            }
        });
        cancelButton.setText("取消");
        horizontalPanel.add(cancelButton);
    }

    public void setPost(Post post) {
        this.post = post;
//        date.setText(post.getDate().toString());
        nickname.setText(post.getNickname());
        title.setText(post.getTitle());
        content.setText(post.getContent());
    }
    
    public Post getNewPost() {
        post.setNickname(nickname.getText());
        post.setTitle(title.getText());
        post.setContent(content.getText());
        return post;
    }
}
