/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai2;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.InputMismatchException;
import java.util.Scanner;
import org.w3c.dom.ls.LSOutput;

/**
 *
 * @author Le Van Hieu CE160866
 */
public class QLCB {
    private ArrayList<CanBo> list;
    
    public QLCB() {
        list = new ArrayList<>();
    }
    
    public void addCanBo() {
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        System.out.println("- - - [Add Can Bo] - - -");
        System.out.println("1. Cong Nhan");
        System.out.println("2. Ky Su");
        System.out.println("3. Nhan Vien");
        boolean isValid = false;
        System.out.print("Nhap lua chon cua ban: ");
        do {            
            try {
                choice = sc.nextInt();
                if (choice >= 1 && choice <= 3) {
                    isValid = true;
                } else {
                    System.out.print("Lua chon phai tu 1 den 3! Nhap lai: ");
                }
            } catch (InputMismatchException e) {
                System.out.print("Lua chon phai tu 1 den 3! Nhap lai: ");
            }
            sc.nextLine();
        } while (isValid == false);
        
        String name, gender, address;
        int age = 0;
        
        isValid = false;
        do {
            System.out.print("Nhap ten Can Bo: ");
            name = sc.nextLine().trim();
            if (!name.equals("")) {
                isValid = true;
            } else {
                System.out.println("Tem cua can bo khong duoc trong!");
            }
        } while (isValid == false);
        
        isValid = false;
        do {
            try {
                System.out.print("Nhap tuoi Can Bo: ");
                age = sc.nextInt();
                if (age >= 18 && age <= 100) {
                    isValid = true;
                } else {
                    System.out.println("Tuoi can bo phai tu 18 den 100!");
                }
            } catch (Exception e) {
                System.out.println("Tuoi can bo phai tu 18 den 100!");
            }
            sc.nextLine();
        } while (isValid == false);
        
        isValid = false;
        do {
            System.out.print("Nhap gioi tinh Can Bo: ");
            gender = sc.nextLine().trim();
            if (!gender.equals("")) {
                isValid = true;
            } else {
                System.out.println("Gioi tinh cua can bo khong duoc trong!");
            }
        } while (isValid == false);
    
        isValid = false;
        do {
            System.out.print("Nhap dia chi cua Can Bo: ");
            address = sc.nextLine().trim();
            if (!address.equals("")) {
                isValid = true;
            } else {
                System.out.println("Dia chi cua can bo khong duoc trong!");
            }
        } while (isValid == false);
        
        switch (choice) {
            case 1: 
                int level = 0;
                isValid = false;
                do {
                    try {
                        System.out.print("Nhap Bac cua cong nhan (1 - 10): ");
                        level = sc.nextInt();
                        if (level >= 1 && level <= 10) {
                            isValid = true;
                        } else {
                            System.out.println("Bac tu 1 den 10");
                        }
                    } catch (Exception e) {
                        System.out.println("Bac tu 1 den 10");
                    }
                    sc.nextLine();
                } while (isValid == false);
                this.list.add(new CongNhan(name, age, gender, address, level));
                break;
            case 2:
                String major;
                isValid = false;
                do {                    
                    System.out.print("Nhap Nghanh dao tao cua ky su: ");
                    major = sc.nextLine().trim();
                    if (!major.equals("")) {
                        isValid = true;
                    } else {
                        System.out.println("Nganh khong duoc de trong!");
                    }
                } while (isValid == false);
                this.list.add(new KySu(name, age, gender, address, major));
                break;
            case 3:
                String job;
                isValid = false;
                do {                    
                    System.out.print("Nhap cong viec cua nhan vien: ");
                    job = sc.nextLine().trim();
                    if (!job.equals("")) {
                        isValid = true;
                    } else {
                        System.out.println("Cong viec khong duoc de trong!");
                    }
                } while (isValid == false);
                this.list.add(new NhanVien(name, age, gender, address, job)); 
        }
    }
    
    public void findByName() {
        Scanner sc = new Scanner(System.in);
        String userEnter;
        System.out.println("- - - [Search By Name] - - -");
        System.out.println("Nhap ten ban muon search: ");
        userEnter = sc.nextLine();
        ArrayList<CanBo> newList = new ArrayList<>();
        for (CanBo canBo : this.list) {
            if (canBo.getName().equalsIgnoreCase(userEnter)) {
                newList.add(canBo);
            }
        }
        if (newList.size() > 0) {
            show(newList);
        } else {
            System.out.println("No result for this name!");
            for (CanBo canBo : this.list) {
                if (canBo.getName().toLowerCase().contains(userEnter.toLowerCase())) {
                    newList.add(canBo);
                }
            }
            if (newList.size() > 0) {
                System.out.println("Maybe you search for:");
                show(newList);
            }
        }
    }
    
    private void show(ArrayList<CanBo> newList) {
        System.out.println("Name                | Age | Gender | Address ");
        for (CanBo canBo : newList) {
            System.out.printf("%-20s| %3d | %6s | %s\n", canBo.getName(), canBo.getAge(), canBo.getGender(), canBo.getAddress());
        }
    }
    
    public void showListInforOfficer() {
        show(list);
    }
    
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
