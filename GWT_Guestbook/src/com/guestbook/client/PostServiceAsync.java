package com.guestbook.client;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface PostServiceAsync {

    void savePost(Post post, AsyncCallback<Boolean> callback);

    void getAllPosts(AsyncCallback<List<Post>> callback);

    void updatePost(Post post, AsyncCallback<Boolean> callback);

    void deletePost(Post post, AsyncCallback<Boolean> callback);
}
