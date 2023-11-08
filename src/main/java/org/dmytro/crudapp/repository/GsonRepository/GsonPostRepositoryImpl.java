package org.dmytro.crudapp.repository.GsonRepository;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.dmytro.crudapp.model.Post;
import org.dmytro.crudapp.repository.PostRepository;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class GsonPostRepositoryImpl implements PostRepository {
    private final String filePath = "Posts.json";
    private final Gson gson = new Gson();


    private List<Post> readAll() {
        List<Post> postsList = new ArrayList<>();
        try(Reader reader = new FileReader(filePath)) {
            Type type = new TypeToken<List<Post>>(){}.getType();
            postsList = gson.fromJson(reader, type);
            System.out.println("Read operation successful. Retrieved posts from file.");

        } catch (IOException e) {
            e.printStackTrace();
        }
        return postsList;
    }

    private void writeAll(List<Post> posts) {
        try(FileWriter fileLabels = new FileWriter(filePath)) {
            gson.toJson(posts, fileLabels);
            System.out.println("Write operation successful. Posts  saved to file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public Post getById(Integer id) {
        List<Post> postsList = readAll();
        for (Post post : postsList) {
            if (post.getId() == id) {
                return post;
            }
        }
        return null;
    }

    @Override
    public List<Post> getAll() {
        return readAll();
    }

    @Override
    public Post save(Post post) {
        List<Post> postList = readAll();
        postList.add(post);
        writeAll(postList);
        return post;
    }

    @Override
    public Post update(Post updatedPost) {
        List<Post> postList = readAll();
        for (int i = 0; i < postList.size(); i++) {
            if (postList.get(i).getId() == updatedPost.getId()) {
                postList.set(i, updatedPost);
                writeAll(postList);
                return updatedPost;
            }
        }
        return null;
    }

    @Override
    public Post deleteById(Integer id) {
        List<Post> postList = readAll();
        for(Post post: postList) {
            if (post.getId() == id) {
                postList.remove(post);
            }
        }
        return null;
    }



}
