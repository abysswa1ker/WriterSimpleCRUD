package org.Dmytro;

import org.Dmytro.controller.LabelController;
import org.Dmytro.controller.PostController;
import org.Dmytro.controller.WriterController;
import org.Dmytro.repository.GsonRepository.GsonLabelRepositoryImpl;
import org.Dmytro.repository.GsonRepository.GsonPostRepositoryImpl;
import org.Dmytro.repository.GsonRepository.GsonWriterRepositoryImpl;
import org.Dmytro.view.LabelView;
import org.Dmytro.view.PostView;
import org.Dmytro.view.WriterView;

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