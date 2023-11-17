package org.dmytro.crudapp.repository.gson;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.dmytro.crudapp.model.Post;
import org.dmytro.crudapp.repository.PostRepository;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.file.FileSystemNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GsonPostRepositoryImpl implements PostRepository {
    private static final String FILE_PATH = "src/main/resources/posts.json";
    private final Gson gson = new Gson();


    private List<Post> loadPosts() {
        List<Post> postsList = new ArrayList<>();
        try(Reader reader = new FileReader(FILE_PATH)) {
            Type type = new TypeToken<List<Post>>(){}.getType();
            postsList = gson.fromJson(reader, type);
            if (postsList == null) {
                return new ArrayList<>();
            }
            return postsList;
        } catch (IOException e) {
            return Collections.emptyList();
        }
    }

    private void savePosts(List<Post> posts) {
        try(FileWriter fileLabels = new FileWriter(FILE_PATH)) {
            gson.toJson(posts, fileLabels);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public Post getById(Integer id) {
        return loadPosts().stream()
                .filter(post -> post.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new FileSystemNotFoundException("post not found"));
    }

    @Override
    public List<Post> getAll() {
        return loadPosts();
    }


    @Override
    public Post save(Post newPost) {
        List<Post> postList = loadPosts();
        Integer nextInt = postList.stream()
                .mapToInt(Post::getId).max().orElse(0) + 1;
        newPost.setId(nextInt);
        postList.add(newPost);
        savePosts(postList);
        return newPost;
    }

    @Override
    public Post update(Post updatedPost) {
        List<Post> currentPosts = loadPosts();
        List<Post> updatedPosts = currentPosts.stream().
                map(existingPost -> {
                    if (updatedPost.getId().equals(existingPost.getId())) {
                        return updatedPost;
                    }
                    return existingPost;
                }).toList();
        savePosts(updatedPosts);
        return updatedPost;
    }

    @Override
    public void deleteById(Integer id) {
        List<Post> postList = loadPosts();
        postList.removeIf(post -> post.getId().equals(id));
        savePosts(postList);
    }



}
