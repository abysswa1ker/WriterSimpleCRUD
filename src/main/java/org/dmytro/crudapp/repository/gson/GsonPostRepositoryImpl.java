package org.dmytro.crudapp.repository.gson;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.dmytro.crudapp.model.Post;
import org.dmytro.crudapp.repository.PostRepository;

import java.io.*;
import java.lang.reflect.Type;
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
            System.out.println("Read operation successful. Retrieved posts from file.");
            return postsList;

        } catch (IOException e) {
            return Collections.emptyList();
        }
    }

    private void savePosts(List<Post> posts) {
        try(FileWriter fileLabels = new FileWriter(FILE_PATH)) {
            gson.toJson(posts, fileLabels);
            System.out.println("Write operation successful. Posts  saved to file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public Post getById(Integer id) {
        //TODO: think about this
//        return loadPosts().stream()
//                .filter(post -> post.getId().equals(id))
//                .findFirst()
//                .orElseThrow(() -> new NotFoundException("post not found"));
        List<Post> postsList = loadPosts();
        for (Post post : postsList) {
            if (post.getId() == id) {
                return post;
            }
        }
        return null;
    }

    @Override
    public List<Post> getAll() {
        return loadPosts();
    }

    @Override
    public Post save(Post post) {
        List<Post> postList = loadPosts();
        postList.add(post);
        savePosts(postList);
        return post;
    }

    @Override
    public Post update(Post updatedPost) {
        List<Post> postList = loadPosts();
        for (int i = 0; i < postList.size(); i++) {
            if (postList.get(i).getId() == updatedPost.getId()) {
                postList.set(i, updatedPost);
                savePosts(postList);
                return updatedPost;
            }
        }
        return null;
    }

    @Override
    public void deleteById(Integer id) {
        List<Post> postList = loadPosts();
        for(Post post: postList) {
            if (post.getId() == id) {
                postList.remove(post);
            }
        }
    }



}
