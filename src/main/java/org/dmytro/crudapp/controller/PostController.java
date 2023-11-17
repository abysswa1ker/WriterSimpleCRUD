package org.dmytro.crudapp.controller;

import org.dmytro.crudapp.enams.PostStatus;
import org.dmytro.crudapp.model.Label;
import org.dmytro.crudapp.model.Post;
import org.dmytro.crudapp.repository.PostRepository;

import java.util.List;

public class PostController {
    private final PostRepository postRepository;

    public PostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Post createPost(String content, PostStatus postStatus, List<Label> labelList ) {
        Post newPost = new Post(content, postStatus, labelList);
        return postRepository.save(newPost);
    }

    public Post getById(Integer id) {
        return postRepository.getById(id);
    }

    public List<Post> getAllPosts() {
        return postRepository.getAll();
    }

    public Post updatedPost(Integer id, String updatedContent, PostStatus postStatus) {
        Post updatedPost = new Post(id, updatedContent, postStatus);
        return postRepository.update(updatedPost);
    }

    public Post updatedPostWithLabels(Integer id, String updatedContent, List<Label> updatedLabels){
        return null;
    }

    public void deletePostById(int id) {
          postRepository.deleteById(id);
    }



}
