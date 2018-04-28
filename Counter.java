package com.finalbuilt;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

public class Counter {
	
	public static void getTotalSentMailandUrls(int urls) {
		
		int p = 0, q = 0, r = 0;
		String res = "";
		try {
			File file = new File("D:\\Eclipse\\FinalBuilt\\src\\com\\finalbuilt\\counter.txt");
			Scanner sc = new Scanner(file);
			sc.hasNext();
			String str = sc.nextLine();
			String st[] = str.split(" ");
			p = Integer.parseInt(st[0]);
			p++;
			q = Integer.parseInt(st[1]);
			q = q + urls;
			res = String.valueOf(p) + " " + String.valueOf(q);
			Writer writer = new FileWriter("D:\\Eclipse\\FinalBuilt\\src\\com\\finalbuilt\\counter.txt");
			BufferedWriter br = new BufferedWriter(writer);
			br.write(res);
			br.flush();
			br.close();
			sc.close();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(res);
		
	}
	
}
