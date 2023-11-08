package org.dmytro.crudapp.view;

import org.dmytro.crudapp.controller.PostController;
import org.dmytro.crudapp.model.Post;

public class PostView {
    private final PostController postController;

    public PostView(PostController postController) {
        this.postController = postController;
    }

    public void createPost(Post post) {
        postController.createPost(post);
    }
}
