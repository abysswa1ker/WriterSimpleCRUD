package org.dmytro.crudapp.view;

import org.dmytro.crudapp.controller.WriterController;
import org.dmytro.crudapp.model.Writer;

import java.util.Scanner;

public class WriterView {
    private final WriterController writerController;

    public WriterView(WriterController writerController) {
        this.writerController = writerController;
    }

    public void createWriter() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter first name");
        String firstName = scanner.nextLine();
        System.out.println("Enter last name");
        String lastName = scanner.nextLine();

        Writer newWriter = new Writer(firstName, lastName);
        writerController.createWriter(newWriter);

        System.out.println("New writer created");

    }
    public void createWriter(Writer writer) {
        writerController.createWriter(writer);
    }

}
