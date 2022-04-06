package com.company;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {


        Collection<User> users = new ArrayList<User>();
        users.add(new User( "blaise", "1234"));
        users.add(new User( "peter", "1234"));
        users.add(new User( "april", "1234"));

        UserManager(users);

    }



    public static int Menu() {
        int operation;
        Scanner s = new Scanner(System.in);

        System.out.println("1.Create new user");
        System.out.println("2.Display all users");
        System.out.println("3.Search user");
        System.out.println("4.update user");
        System.out.println("9.Quit");
        System.out.print("Enter your choice:");
        operation = s.nextInt();

        return operation;
    }

    public static void UserManager(Collection<User> users) throws InterruptedException {
        int choice = 0;
        boolean access=false;
        int operation;
        Scanner s = new Scanner(System.in);
        do {
            System.out.println(" ");
        System.out.println("welcome please enter your information to sign in");
        System.out.println(" ");
        System.out.print("username: ");
        String user = s.next();
        System.out.print("password: ");
        String pass = s.next();





            for (User u:users
            ) {

                if (u.getUsername().equals(user) &&u.getPassword().equals(pass)){
                    System.out.println("welcome "+user);

                    access=true;
                }
            }

            if (access==false){
                System.out.println("wrong input ,you can try again(1), sign up(2) or exit(3): ");
                choice = s.nextInt();
            }
            if (choice==2){
                System.out.println("sign up");
                System.out.println(" ");
                System.out.print("username: ");
                String userToCreate = s.next();
                System.out.print("password: ");
                String passToCreate = s.next();
                users.add(new User( userToCreate, passToCreate));
                System.out.println(" ");
                System.out.println("welcome "+userToCreate);
                access=true;
            }
        }while(access==false&&choice==1&&choice!=3);

if (access) {
    do {
        operation = Menu();

        switch (operation) {
            case 1:


                System.out.print("enter username :");
                String username = s.next();
                System.out.print("enter password :");
                String password = s.next();
                users.add(new User(username, password));

                System.out.println("Done!");
                TimeUnit.SECONDS.sleep(5);


                break;
            case 2:
                for (User u : users
                ) {
                    System.out.println(u.getUsername());
                }
                TimeUnit.SECONDS.sleep(5);

                break;
            case 3:
                System.out.print("enter the name of the user you looking for:");
                String userToFind = s.next();
                boolean found = false;
                for (User u : users
                ) {
                    if (u.getUsername().equals(userToFind)) {
                        found = true;
                    }
                }
                if (found) {
                    System.out.println("the user " + userToFind + " exist !");
                } else {
                    System.out.println("user not found !");
                }
                TimeUnit.SECONDS.sleep(5);

                break;
            case 4:
                System.out.print("enter the name of the user to update:");
                String userToUpdate = s.next();
                boolean exist = false;
                for (User u : users
                ) {
                    if (u.getUsername().equals(userToUpdate)) {
                        exist = true;
                        System.out.print("enter new username :");
                        String name = s.next();
                        System.out.print("enter new password :");
                        String pw = s.next();
                        u.setUsername(name);
                        u.setPassword(pw);
                    }
                }
                if (exist) {
                    System.out.println("the user " + userToUpdate + " was updated successfully!");
                } else {
                    System.out.println("user not found !");
                }
                TimeUnit.SECONDS.sleep(5);

                break;

        }
    } while (operation != 9);
}
    }
}


