package com.finalbuilt;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;

public class BlockingUser {
	
	private static Message message = null;
	private static Folder folder = null;
	
	public static void blockUser() {
		try {
			message = EmailAccessUsingImap.getMessageToDelete();
			message.setFlag(Flags.Flag.DELETED, true);
			folder = EmailAccessUsingImap.inbox;
			if(folder!=null) {
			folder.close(true);
			}
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
	
	public static void closeInbox() {
		
		folder = EmailAccessUsingImap.inbox;
		try {
			if(folder!=null) {
			folder.close(true);
			}
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
	
	private static String getUser() {

		String user1 = EmailAccessUsingImap.from;
		String user = null ;
		if(user1!=null) {
		String user2[] = user1.split(" ");
		String user3 = user2[user2.length-1];
		user = user3.substring(1, user3.length()-1);
		}
		return user;
	}
	
	
	//call during action performed
	public static void addToBlockedUserList() {
		List<String> users = new ArrayList<>();
		try {
			File reader = new File("D:\\Eclipse\\FinalBuilt\\src\\com\\finalbuilt\\BlockedUser.txt");
			Scanner sc = new Scanner(reader);
			while(sc.hasNext()) {
				users.add(sc.nextLine());
			}
			sc.close();
			Writer writer = new FileWriter("D:\\Eclipse\\FinalBuilt\\src\\com\\finalbuilt\\BlockedUser.txt");
			BufferedWriter br = new BufferedWriter(writer);
			br.write(getUser());
			for (String string : users) {
				br.write(string);
			}
			br.flush();
			br.close();
			blockUser();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//call during downloading mails
	public static int checkBlockedUser() {
		
		String newUser = getUser();
		int count = 0;
		try {
			File reader = new File("D:\\Eclipse\\FinalBuilt\\src\\com\\finalbuilt\\BlockedUser.txt");
			Scanner sc = new Scanner(reader);
			while(sc.hasNext()) {
				if(sc.nextLine().equalsIgnoreCase(newUser)) {
					blockUser();
					System.out.println("block");
					count++;
				}
			}
			System.out.println("not blocked");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return count;
	}
}
