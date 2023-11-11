package org.dmytro.crudapp.view;

import org.dmytro.crudapp.controller.LabelController;
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
            System.out.println("1. ");
            System.out.println("2. ");
            System.out.println("3. ");
            System.out.println("4. ");
            System.out.println("5. ");
            System.out.println("0. ");
            System.out.println(" ");

            int opinion = scanner.nextInt();

            switch (opinion) {
                case 1 :
                    labelController.createLabel();
            }
        }

    }


}
