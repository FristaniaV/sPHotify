package sPHotify;

import java.util.ArrayList;
import java.util.Scanner;

public class Sphotify {

	Scanner scan = new Scanner(System.in);
	
	ArrayList<String> nameList = new ArrayList<>();
	ArrayList<String> artistList = new ArrayList<>();
	ArrayList<Integer> yearList = new ArrayList<>();
	
	String name;
	String artist;
	Integer year;
	String pass = "sPHotify123";
	String inpass;
	Integer delSong;
	
	public Sphotify() {
		Menu();
	}
	
	public void Menu() {
		int choose = 0;

		do {
			System.out.println("Sphotify");
			System.out.println("============");
			System.out.println("1. Add new song");
			System.out.println("2. View all song");
			System.out.println("3. Get song recommendation");
			System.out.println("4. Delete song");
			System.out.println("5. Exit");
			System.out.print(">> ");
			try {
				choose = scan.nextInt();
			} catch (Exception e) {
				choose = 0;
			} scan.nextLine();
			if (choose == 1) {
				Add();
			} else if (choose == 2) {
				View();
			} else if (choose == 3) {
				Get();
			} else if (choose == 4) {
				Delete();
			} else if (choose == 5) {
				System.exit(0);
			}
		} while (choose > 5 || choose < 1);	
	}
	
	public void Add() {
		do {
			System.out.print("Input song name [More than 5 characters]: ");
			name = scan.nextLine();
		} while (name.length() < 6);
		nameList.add(name);
		
		do {
			System.out.print("Input artist [Starts with 'Artist']: ");
			artist = scan.nextLine();
		} while (!artist.startsWith("Artist"));
		artistList.add(artist);
		
		do {
			System.out.print("Input song release year [Less than or equals to 2020]: ");
			year = scan.nextInt(); scan.nextLine();
		} while (year > 2020);
		yearList.add(year);
		
		do {
			System.out.print("Input password: ");
			inpass = scan.nextLine();
		} while (!(pass.equals(inpass)));
		
		System.out.println("Song successfuly added!");
		System.out.println();
		Menu();
	}
	
	public void View() {
		
		if (nameList.isEmpty()) {
			System.out.println("Your song list is empty! Let's add some song first!");
			System.out.println();
			Menu();
		} else {
			for (int i = 0; i < nameList.size(); i++) {
				for (int j = 0; j < nameList.size() - 1; j++) {
					if (nameList.get(j).compareTo(nameList.get(j + 1)) > 0) {
						String temp;
						int temporary;
						
						temp = nameList.get(j);
						nameList.set(j, nameList.get(j + 1));
						nameList.set((j + 1), temp);
						
						temp = artistList.get(j);
						artistList.set(j, artistList.get(j + 1));
						artistList.set((j + 1), temp);
						
						temporary = yearList.get(j);
						yearList.set(j, yearList.get(j + 1));
						yearList.set((j + 1), temporary);
					}
				}
			}
			
			System.out.println("===========================================================================");
			System.out.printf("| %-3s | %-30s | %-20s | %-10s | \n", "NO", "Name", "Artist", "Year");
			System.out.println("===========================================================================");
			for (int i = 0; i < nameList.size(); i++) {
				System.out.printf("| %-3d | %-30s | %-20s | %-10s |\n", (i+1), nameList.get(i), artistList.get(i), yearList.get(i));
			}
			System.out.println("===========================================================================");
			
			System.out.println();
			Menu();
			
		}
	}
	
	public void Get() {
		if (nameList.isEmpty()) {
			System.out.println("Your song list is empty! Let's add some song first!");
			System.out.println();
			Menu();
		} else {
			
			Integer randIndex = (int)(Math.random() * (nameList.size()+2));

			System.out.println("==================================================");
			System.out.println("              Your Song Recommendation            "); 
			System.out.println("==================================================");
			System.out.println("Song Name        : " + nameList.get(randIndex));
			System.out.println("Song Artist      : " + artistList.get(randIndex));
			System.out.println("Song Release     : " + yearList.get(randIndex));
			System.out.println("==================================================");
			
			System.out.println();
			System.out.println("Please enter to go back to main menu...");
			scan.nextLine();
			Menu();
		}
	}
	
	public void Delete() {
		if (nameList.isEmpty()) {
			System.out.println("Your song list is empty! Let's add some song first!");
			System.out.println();
			Menu();
		} else {
			System.out.println("===========================================================================");
			System.out.printf("| %-3s | %-30s | %-20s | %-10s | \n", "NO", "Name", "Artist", "Year");
			System.out.println("===========================================================================");
			for (int i = 0; i < nameList.size(); i++) {
				System.out.printf("| %-3d | %-30s | %-20s | %-10s |\n", (i+1), nameList.get(i), artistList.get(i), yearList.get(i));
			}
			System.out.println("===========================================================================");
			System.out.println();
			do {
				System.out.println("Choose a  song to be deleted [1-" + nameList.size() + "]: ");
				delSong = scan.nextInt(); scan.nextLine();
			} while (delSong <= 0 || delSong > nameList.size());
			
			int indexDelSong = delSong - 1;
			nameList.remove(indexDelSong);
			artistList.remove(indexDelSong);
			yearList.remove(indexDelSong);
			
			System.out.println("Song deleted!");
			System.out.println();
			Menu();
			}
	}
	

	public static void main(String[] args) {
		new Sphotify();

	}

}
