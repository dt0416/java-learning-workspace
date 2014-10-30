package com.guestbook.client;

import java.util.List;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTMLTable.Cell;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;

public class PostList implements EntryPoint {
	private FlexTable flexTable;
	private List<Post> posts;
	private int selectRow = -1;

    @Override
	public void onModuleLoad() {
		RootPanel rootPanel = RootPanel.get();
		
		DockPanel dockPanel = new DockPanel();
		rootPanel.add(dockPanel, 0, 0);
		dockPanel.setSize("100px", "100px");
		
		HorizontalPanel horizontalPanel = new HorizontalPanel();
		dockPanel.add(horizontalPanel, DockPanel.NORTH);
		horizontalPanel.setWidth("142px");
		
		Button addButton = new Button("New button");
		addButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
			    // 顯示新增留言對話框
			    AddPostDialog addDialog = new AddPostDialog();
			    addDialog.center();
			}
		});
		addButton.setText("新增");
		horizontalPanel.add(addButton);
		
		Button updateButton = new Button("New button");
		updateButton.addClickHandler(new ClickHandler() {
		    public void onClick(ClickEvent event) {
		        PostEditor editor = new PostEditor();
		        editor.setPost(posts.get(selectRow));
		        editor.center();
		    }
		});
		updateButton.setText("修改");
		horizontalPanel.add(updateButton);
		
		Button deleteButton = new Button("New button");
		deleteButton.addClickHandler(new ClickHandler() {
		    public void onClick(ClickEvent event) {
		        // 提示視窗
		        final DialogBox dialog = new DialogBox();
		        Button confirmButton = new Button("確認刪除");
		        Button cancelButton = new Button("取消");
		        confirmButton.addClickHandler(new ClickHandler() {
                    @Override
                    public void onClick(ClickEvent event) {
                        PostServiceAsync postService = (PostServiceAsync) GWT.create(PostService.class);
                        postService.deletePost(posts.get(selectRow), new AsyncCallback<Boolean>() {
                            
                            @Override
                            public void onSuccess(Boolean result) {
                                if (result) {
                                    Window.alert("刪除成功");
                                } else {
                                    Window.alert("刪除失敗");
                                }
                                dialog.hide();
                            }
                            
                            @Override
                            public void onFailure(Throwable caught) {
                                Window.alert("遠端呼叫失敗");
                            }
                        });
                    }
                });
		        cancelButton.addClickHandler(new ClickHandler() {
                    
                    @Override
                    public void onClick(ClickEvent event) {
                        dialog.hide();
                    }
                });
		        HorizontalPanel hPanel = new HorizontalPanel();
		        hPanel.add(confirmButton);
		        hPanel.add(cancelButton);
		        dialog.setText("是否刪除此留言?");
		        dialog.setWidget(hPanel);
		        dialog.setSize("200px", "150px");
		        dialog.center();
		    }
		});
		deleteButton.setText("刪除");
		horizontalPanel.add(deleteButton);
		
		flexTable = new FlexTable();
		flexTable.addClickHandler(new ClickHandler() {
		    public void onClick(ClickEvent event) {
		        Cell cell = flexTable.getCellForEvent(event);
		        // 取得儲存格所在的列數
		        int row = cell.getRowIndex();
		        // 移除css、指定css
		        if (selectRow != -1) {
		            flexTable.getRowFormatter().removeStyleName(selectRow, "selectedRow");
		        }
		        flexTable.getRowFormatter().addStyleName(row, "selectedRow");
		        selectRow = row;
		        
                // 顯示留言明細
		        Post p = posts.get(row);
		        Detail detail = new Detail();
		        detail.setPost(p);
		        DialogBox dialog = new DialogBox();
		        dialog.add(detail);
		        dialog.setAutoHideEnabled(true);
		        dialog.center();
		        
		    }
		});
		dockPanel.add(flexTable, DockPanel.CENTER);
		// 讀取所有留言清單
		this.readPosts();

	}
	
    
	/**
	 * 讀取所有留言清單
	 */
	private void readPosts() {
	    PostServiceAsync postService = (PostServiceAsync) GWT.create(PostService.class);
	    postService.getAllPosts(new AsyncCallback<List<Post>>() {
            
            @Override
            public void onSuccess(List<Post> result) {
                // 
                flexTable.clear();
                posts = result;
                for(int index = 0; index < posts.size(); index++) {
                    Post post = posts.get(index);
                    flexTable.setWidget(index,  0,  new Label(post.getId()+ ""));
                    flexTable.setWidget(index,  1,  new Label(post.getNickname()));
                    flexTable.setWidget(index,  2,  new Label(post.getTitle()));
//                    flexTable.setWidget(index,  3,  new Label(post.getDate() + ""));
                }
            }
            
            @Override
            public void onFailure(Throwable caught) {
                Window.alert("遠端呼叫失敗");                
            }
        });
	}
}
