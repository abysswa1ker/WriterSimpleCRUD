package org.dmytro.crudapp.view;

import org.dmytro.crudapp.controller.LabelController;
import org.dmytro.crudapp.controller.PostController;
import org.dmytro.crudapp.model.Post;
import org.dmytro.crudapp.repository.PostRepository;

public class PostView {
    private final PostController postController;
    PostRepository postRepository;

    public PostView(PostController postController) {
        this.postController = postController;
    }

    public void createPost(Post post) {


    }
}
