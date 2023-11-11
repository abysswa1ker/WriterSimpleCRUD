package org.dmytro.crudapp;

import org.dmytro.crudapp.controller.LabelController;
import org.dmytro.crudapp.controller.PostController;
import org.dmytro.crudapp.controller.WriterController;
import org.dmytro.crudapp.model.Label;
import org.dmytro.crudapp.model.Post;
import org.dmytro.crudapp.model.Writer;
import org.dmytro.crudapp.repository.gson.GsonLabelRepositoryImpl;
import org.dmytro.crudapp.repository.gson.GsonPostRepositoryImpl;
import org.dmytro.crudapp.repository.gson.GsonWriterRepositoryImpl;
import org.dmytro.crudapp.view.LabelView;
import org.dmytro.crudapp.view.PostView;
import org.dmytro.crudapp.view.WriterView;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        GsonWriterRepositoryImpl gsonWriterRepository = new GsonWriterRepositoryImpl();
        WriterController writerController = new WriterController(gsonWriterRepository);
        WriterView writerView = new WriterView(writerController);

        GsonLabelRepositoryImpl gsonLabelRepository = new GsonLabelRepositoryImpl();
        LabelController labelController = new LabelController(gsonLabelRepository);
        LabelView labelView = new LabelView(labelController);

        GsonPostRepositoryImpl gsonPostRepository = new GsonPostRepositoryImpl();
        PostController postController = new PostController(gsonPostRepository);
        PostView postView = new PostView(postController);

        Label label = new Label(1, "game");
        List<Label> labelList = new ArrayList<>();
        labelList.add(label);

        Post post = new Post(1,"some text", labelList);
        List<Post> postList = new ArrayList<>();
        postList.add(post);
//
//        Writer writer = new Writer( "Dima", "Zhabskiy", postList);
//
//        writerView.createWriter(writer);
//
//        System.out.println(writerController.getById(1));

        Writer updateWriter = new Writer( "Kate", "Zhabskiy", postList);

        writerController.updatedWriter(updateWriter);
    }
}