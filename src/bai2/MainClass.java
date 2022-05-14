/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai2;

import java.util.Scanner;

/**
 * 
 * @author Le Van Hieu CE160866
 */
public class MainClass {
     public static void main(String[] args) {
        QLCB qlcb = new QLCB();
        Scanner sc = new Scanner(System.in);
        boolean isLoop = true;
        boolean isValid = false;
        int choice = 0;
        do {            
            System.out.println("- - - Menu - - - ");
            System.out.println("1. Add new Officier");
            System.out.println("2. Find by Name");
            System.out.println("3. Show Information Officiers");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            do {
                try {
                    choice = sc.nextInt();
                    if (choice >= 1 && choice <= 4) {
                        isValid = true;
                    } else {
                        System.out.println("Choice (1-4)! Enter Again: ");
                    }
                } catch (Exception e) {
                        System.out.println("Choice (1-4)! Enter Again: ");
               }
                sc.nextLine();
            } while (isValid == false);
            switch (choice) {
                case 1:
                    qlcb.addCanBo();
                    break;
                case 2:
                    qlcb.findByName();
                    break;
                case 3:
                    qlcb.showListInforOfficer();
                    break;
                case 4:
                    isLoop = false;
            }
        } while (isLoop);
    }
}
