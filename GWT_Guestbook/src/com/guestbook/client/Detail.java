package com.guestbook.client;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;

public class Detail extends Composite {
    private Label date;
    private Label nickname;
    private Label title;
    private Label content;
    
    public Detail() {
        
        FlexTable flexTable = new FlexTable();
        initWidget(flexTable);
        
        Label lblNewLabel = new Label("留言時間：");
        flexTable.setWidget(0, 0, lblNewLabel);
        
        date = new Label("New label");
        flexTable.setWidget(0, 1, date);
        
        Label lblNewLabel_1 = new Label("匿稱：");
        flexTable.setWidget(1, 0, lblNewLabel_1);
        
        nickname = new Label("New label");
        flexTable.setWidget(1, 1, nickname);
        
        Label lblNewLabel_2 = new Label("標題：");
        flexTable.setWidget(2, 0, lblNewLabel_2);
        
        title = new Label("New label");
        flexTable.setWidget(2, 1, title);
        
        Label lblNewLabel_3 = new Label("留言內容：");
        flexTable.setWidget(3, 0, lblNewLabel_3);
        
        content = new Label("New label");
        flexTable.setWidget(3, 1, content);
    }

    public void setPost(Post post) {
//        date.setText(post.getDate().toString());
        nickname.setText(post.getNickname());
        title.setText(post.getTitle());
        content.setText(post.getContent());
    }
}
