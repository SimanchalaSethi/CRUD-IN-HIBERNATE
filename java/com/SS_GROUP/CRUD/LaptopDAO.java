package com.SS_GROUP.CRUD;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class LaptopDAO {
	private static Scanner sc;
	private static Session ss;
	static {
		sc = new Scanner(System.in);
		ss = new Configuration().configure().buildSessionFactory().openSession();
	}

	void insertLaptop() {
		System.out.println("Enter the Name, processor, Price");
		Laptop lap = new Laptop();
		lap.setName(sc.next());
		lap.setProcessor(sc.next());
		lap.setPrice(sc.nextDouble());

		try {
			Transaction tr = ss.beginTransaction();
			ss.save(lap);
			tr.commit();

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	void updateLaptop() {
		System.out.println("Enter the existing id");
		int id = sc.nextInt();
		try {
			Laptop lap = (Laptop) ss.load(Laptop.class, id);
			Transaction tr = ss.beginTransaction();
			System.out.println("Enter new name-1, processor-2 and price-3 of the Laptop");
			int option = sc.nextInt();
			switch (option) {
			case 1:
				System.out.println("Enter the name:");
				lap.setName(sc.next());
				break;
			case 2:
				System.out.println("Enter the processor:");
				lap.setProcessor(sc.next());
				break;
			case 3:
				System.out.println("Enter the price:");
				lap.setPrice(sc.nextDouble());
				break;
			default:
				System.err.println("Enter the above given option.");
			}
			System.out.println("Update successful..........");
		} catch (Exception e) {
			System.err.println("Please, Enter the existing ID");
		}
	}

	void deleteLaptop() {

		System.out.println("Enter the id of Laptop");
		int id = sc.nextInt();
		try {
			Laptop lap = (Laptop) ss.load(Laptop.class, id);
			ss.delete(lap);
			Transaction tr = ss.beginTransaction();
			tr.commit();
			System.out.println("Delete successful..........");
		} catch (Exception e) {
			System.err.println("Please, Enter the existing ID");
		}
	}

	void viewLaptop() {
		System.out.println("Enter the Id of Laptop, which you want to see");
		int id = sc.nextInt();

		try {
			Laptop lap = (Laptop) ss.load(Laptop.class, id);
			System.out.println("your entered id product details:");
			System.out.println("ID:" + lap.getId());
			System.out.println("Name:" + lap.getName());
			System.out.println("Processor:" + lap.getProcessor());
			System.out.println("Price" + lap.getPrice());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
