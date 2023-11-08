package org.dmytro.crudapp.controller;

import org.dmytro.crudapp.model.Post;
import org.dmytro.crudapp.repository.PostRepository;

import java.util.List;

public class PostController {
    private final PostRepository postRepository;

    public PostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    public Post getById(int id) {
        return postRepository.getById(id);
    }

    public List<Post> getAllPosts() {
        return postRepository.getAll();
    }

    public Post updatedPost(Post updatedPost) {
        return postRepository.update(updatedPost);
    }

    public void deletePostById(int id) {
          postRepository.deleteById(id);
    }



}
