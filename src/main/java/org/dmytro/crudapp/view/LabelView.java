package org.dmytro.crudapp.view;

import org.dmytro.crudapp.controller.LabelController;
import org.dmytro.crudapp.enams.LabelStatus;
import org.dmytro.crudapp.enams.PostStatus;
import org.dmytro.crudapp.model.Label;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

public class LabelView {
    private final LabelController  labelController;
    private final Scanner scanner;

    public LabelView(LabelController labelController, Scanner scanner) {
        this.labelController = labelController;
        this.scanner = new Scanner(System.in);
    }

    public void run(){
        boolean running = true;

        while (running) {
            System.out.println("1. Create label ");
            System.out.println("2. Delete label by id");
            System.out.println("3. get all labels");
            System.out.println("4. Updated label");
            System.out.println("5. Get label by id");
            System.out.println("0. exit");
            System.out.println("Select an opinion");

            int opinion = scanner.nextInt();
            scanner.nextLine();

            switch (opinion) {
                case 1 :
                    createLabel();
                    break;
                case 2:
                    deleteLabelById();
                    break;
                case 3:
                    getAllLabels();
                    break;
                case 4:
                    updatedLabel();
                    break;
                case 5:
                    getLabelById();
                    break;
                case 6:
                    running =false;
                    break;
                default:
                    System.out.println("invalid opinion. Please try again");
                    break;
            }
        }
    }
    public void createLabel(){
        System.out.println("Enter name");
        String name = scanner.nextLine();

        LabelStatus labelStatus = LabelStatus.ACTIVE;

        Label newLabel = labelController.createLabel(name, labelStatus);
        System.out.println("Label created with ID: " + newLabel.getId());
    }
    public void getLabelById(){
        System.out.println("Enter id");
        int id = scanner.nextInt();

        Label newLabel = labelController.getLabelById(id);
        System.out.println("Label found " + newLabel);
    }

    public void getAllLabels(){
        List<Label> labels = labelController.getAllLabels();
        for (Label label: labels)
            System.out.println(label);
    }

    public void updatedLabel() {
        System.out.println("Enter label id to update");
        Integer id = scanner.nextInt();
        scanner.nextLine();


        System.out.println("Enter update name");
        String name = scanner.nextLine();

        LabelStatus labelStatus = LabelStatus.ACTIVE;

        Label updateLabel = labelController.updatedLabel(id, name, labelStatus);
        System.out.println("label updated with ID: " + updateLabel.getId());
    }

    public void deleteLabelById() {
        System.out.println("Enter id");
        int id = scanner.nextInt();
        labelController.deleteLabelById(id);
        System.out.println("Label deleted");
    }



}
