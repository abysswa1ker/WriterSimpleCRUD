package org.Dmytro.view;

import org.Dmytro.controller.WriterController;
import org.Dmytro.model.Writer;

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
}
