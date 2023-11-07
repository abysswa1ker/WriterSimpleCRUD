package org.Dmytro.view;

import org.Dmytro.controller.LabelController;
import org.Dmytro.model.Label;

import java.util.Scanner;

public class LabelView {
    private final LabelController  labelController;

    public LabelView(LabelController labelController) {
        this.labelController = labelController;
    }

    public void createLabel() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter label name");
        String labelName = scanner.nextLine();
        Label newLabel = new Label(labelName);


        labelController.createWriter(newLabel);

    }
}
