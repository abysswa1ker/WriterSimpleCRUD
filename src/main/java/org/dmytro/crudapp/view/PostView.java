package org.dmytro.crudapp.view;

import org.dmytro.crudapp.controller.LabelController;
import org.dmytro.crudapp.controller.PostController;
import org.dmytro.crudapp.enams.PostStatus;
import org.dmytro.crudapp.model.Label;

import java.util.List;
import java.util.Scanner;

public class PostView {
    private final PostController postController;
    private final Scanner scanner;
    private  final LabelController labelController;

    public PostView(PostController postController, Scanner scanner, LabelController labelController) {
        this.postController = postController;
        this.labelController = labelController;
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        boolean running = true;

        while (running) {
            System.out.println("1. Create post ");
            System.out.println("2. Delete post by id");
            System.out.println("3. get all posts");
            System.out.println("4. Updated posts");
            System.out.println("5. Get posts by id");
            System.out.println("0. exit");
            System.out.println("Select an opinion");

            int opinion = scanner.nextInt();

            switch (opinion) {
                case 1:
                    createPost();
            }
        }
    }

    private void createPost() {
        System.out.println("Enter post content");
        String content = scanner.nextLine();
        System.out.println("chose label to add");
        System.out.println(labelController.getAllLabels());
    }
}
