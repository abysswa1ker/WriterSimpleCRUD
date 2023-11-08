package org.dmytro.crudapp;

import org.dmytro.crudapp.controller.LabelController;
import org.dmytro.crudapp.controller.PostController;
import org.dmytro.crudapp.controller.WriterController;
import org.dmytro.crudapp.repository.GsonRepository.GsonLabelRepositoryImpl;
import org.dmytro.crudapp.repository.GsonRepository.GsonPostRepositoryImpl;
import org.dmytro.crudapp.repository.GsonRepository.GsonWriterRepositoryImpl;
import org.dmytro.crudapp.view.LabelView;
import org.dmytro.crudapp.view.PostView;
import org.dmytro.crudapp.view.WriterView;

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

//        Label label1 = new Label(1, "game");
//        List<Label> labelList = new ArrayList<>();
//        labelList.add(label);
//
//        Post post = new Post(1,"some text", labelList);
//        List<Post> postList = new ArrayList<>();
//        postList.add(post);
//
//        Writer writer = new Writer(1, "Dima", "Zhabskiy", postList);
//
//        writerView.createWriter(writer);

        System.out.println(writerController.getById(1));
    }
}