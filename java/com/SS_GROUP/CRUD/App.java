package com.SS_GROUP.CRUD;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// create DAO Object
		LaptopDAO ld = new LaptopDAO();
		while (true) {
			System.out.println("Enter 1-Insert, 2-Delete, 3-Update, 4-View");
			int option = sc.nextInt();

			switch (option) {
			case 1:
				ld.insertLaptop();
				break;
			case 2:
				ld.deleteLaptop();
				break;
			case 3:
				ld.updateLaptop();
				break;
			case 4:
				ld.viewLaptop();
				break;
			default:
				System.err.println("Enter the valid option");
			}
		}
	}
}
