package org.Dmytro.view;

import org.Dmytro.controller.PostController;
import org.Dmytro.model.Post;

public class PostView {
    private final PostController postController;

    public PostView(PostController postController) {
        this.postController = postController;
    }

    public void createPost(Post post) {
        postController.createPost(post);
    }
}
