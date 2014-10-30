package com.guestbook.server;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import com.gb.PMF;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.guestbook.client.Post;
import com.guestbook.client.PostService;

public class PostServiceImpl extends RemoteServiceServlet implements
        PostService {

    @Override
    public boolean savePost(Post post) {
        boolean saved = false;
        try {
            PersistenceManager pm = PMF.get().getPersistenceManager();
            pm.makePersistent(post);
            saved = true;
            pm.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return saved;
    }

    @Override
    public List<Post> getAllPosts() {
        List<Post> posts = null;
        List<Post> results = null;
        try {
            PersistenceManager pm = PMF.get().getPersistenceManager();
            Query query = pm.newQuery("SELECT FROM " + Post.class.getName());
            results = (List<Post>) query.execute();
            //
            posts = new ArrayList<Post>();
            for (Post post : results) {
                post.getNickname();
                posts.add(post);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return posts;
//        return results;
    }

    @Override
    public boolean updatePost(Post post) {
        boolean updated = false;
        try {
            PersistenceManager pm = PMF.get().getPersistenceManager();
            Post p = pm.getObjectById(Post.class, post.getId());
            p.setNickname(post.getNickname());
            p.setTitle(post.getTitle());
            p.setContent(post.getContent());
            updated = true;
            pm.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return updated;
    }

    @Override
    public boolean deletePost(Post post) {
        boolean updated = false;
        try {
            PersistenceManager pm = PMF.get().getPersistenceManager();
            Post p = pm.getObjectById(Post.class, post.getId());
            pm.deletePersistent(p);
            updated = true;
            pm.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return updated;
    }

}
