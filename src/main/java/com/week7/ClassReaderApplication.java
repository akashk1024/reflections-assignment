package com.week7;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

// Sample Application to get class information
public class ClassReaderApplication {
    public static void main(String[] args) throws ClassNotFoundException, IOException {
        System.out.println("Please enter the class name");
        Scanner s = new Scanner(System.in);
        String className = s.nextLine();
        int optionChosen, closingOption;
        String showMenuAgain = "yes";
        String fileName = "history.txt"; // For storing the details
        File file = new File(fileName);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true));
             PrintWriter printWriter = new PrintWriter(bufferedWriter)) {

            while (showMenuAgain.equalsIgnoreCase("yes")) {
                showDefaultMenu(); // Display the starting menu option
                optionChosen = s.nextInt(); // Take the input from user

                // switch cases to display details as per user input
                switch (optionChosen) {
                    case 1:
                        Arrays.stream(ClassUtil.getUserMethods(className)).forEach((str) -> {
                            printWriter.println(str);
                            System.out.println(str);
                        });
                        break;
                    case 2:
                        Class cls = ClassUtil.getUserClass(className);
                        printWriter.println(cls);
                        System.out.println(cls);
                        break;
                    case 3:
                        ClassUtil.getSubClasses(className).forEach((str) -> {
                            printWriter.println(str);
                            System.out.println(str);
                        });
                        break;
                    case 4:
                        String str = ClassUtil.getParentClasses(className);
                        printWriter.println(str);
                        System.out.println(str);
                        break;
                    case 5:
                        Arrays.stream(ClassUtil.getConstructors(className)).forEach((str2) -> {
                            printWriter.println(str2);
                            System.out.println(str2);
                        });
                        break;
                    case 6:
                        Arrays.stream(ClassUtil.getFields(className)).forEach((str3) -> {
                            printWriter.println(str3);
                            System.out.println(str3);
                        });
                        break;
                }
                postMenuOption();

                showMenuAgain = s.next();
            }
        }

        // Options to store the history
        showClosingOptions();
        closingOption = s.nextInt();
        switch (closingOption) {
            case 1:
                break;
            case 2:
                Files.lines(Paths.get(fileName)).forEach(System.out::println);
                break;
            case 3:
                Files.deleteIfExists(Paths.get(fileName));
        }
        s.close();


    }

    public static void showDefaultMenu() {
        System.out.println("Select the menu option\n1. Methods\n2. " +
                "Class\n3. Subclasses\n4. Parent classes\n5. Constructors\n6. Data Members");
    }

    public static void postMenuOption() {
        System.out.print("Do you want to see any more information\n\t" +
                "type yes to recheck the menu and no if you want to continue\ncontinue?: ");
    }

    public static void showClosingOptions() {
        System.out.println("1. Store information into file\n2. To see all previous files created\n3. Exit without storing");
    }
}
