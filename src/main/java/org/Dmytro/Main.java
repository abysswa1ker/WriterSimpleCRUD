package org.Dmytro;

import org.Dmytro.controller.WriterController;
import org.Dmytro.repository.GsonWriterRepositoryImpl;
import org.Dmytro.view.WriterView;

public class Main {
    public static void main(String[] args) {
        GsonWriterRepositoryImpl gsonWriterRepository = new GsonWriterRepositoryImpl();
        WriterController writerController = new WriterController(gsonWriterRepository);

        WriterView writerView = new WriterView(writerController);

        writerView.createWriter();



    }
}