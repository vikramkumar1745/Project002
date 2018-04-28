package com.finalbuilt;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

public class GuiSignout1 {

	private JFrame frame;
	private static GuiSignout1 ref = null;
	private static int count = 0;

	public static void call() {
		EventQueue.invokeLater(()-> {
				try {
					GuiSignout1 window = new GuiSignout1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
		});
	}

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	private GuiSignout1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private JPanel panel_5 = null;
	private void initialize() {
		
		String totalmail = "0";
		String totalurls = "0";
		String ad = null;
		try {
			File file = new File("D:\\Eclipse\\FinalBuilt\\src\\com\\finalbuilt\\counter.txt");
			Scanner sc = new Scanner(file);
			sc.hasNext();
			totalmail = sc.next();
			sc.hasNext();
			totalurls = sc.next();
			sc.close();
			System.out.println(sc);
		} catch(Exception e) {
			System.out.println("timeout");
			System.out.println(ad);
		}
		
		
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setBounds(200, 200, 866, 494);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Team3");
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(52, 58, 184, 94);
		panel.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblTotalMailsChecked = new JLabel("Total Mails Checked");
		lblTotalMailsChecked.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTotalMailsChecked.setBounds(24, 62, 150, 22);
		panel.add(lblTotalMailsChecked);
		
		JLabel totalMails = new JLabel(totalmail);
		totalMails.setHorizontalAlignment(SwingConstants.CENTER);
		totalMails.setFont(new Font("Tahoma", Font.BOLD, 40));
		totalMails.setBounds(47, 10, 85, 48);
		panel.add(totalMails);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(339, 58, 190, 94);
		panel_1.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblTotalPhishingMails = new JLabel("Phishing Mails Detected");
		lblTotalPhishingMails.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTotalPhishingMails.setBounds(10, 64, 180, 20);
		panel_1.add(lblTotalPhishingMails);
		
		JLabel phishingMails = new JLabel(String.valueOf(count));
		phishingMails.setHorizontalAlignment(SwingConstants.CENTER);
		phishingMails.setFont(new Font("Tahoma", Font.BOLD, 40));
		phishingMails.setBounds(65, 10, 63, 50);
		panel_1.add(phishingMails);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(623, 58, 178, 94);
		panel_2.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblTotalMailsChecked_1 = new JLabel("Total Urls Checked");
		lblTotalMailsChecked_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTotalMailsChecked_1.setBounds(25, 61, 143, 23);
		panel_2.add(lblTotalMailsChecked_1);
		
		JLabel totalUrls = new JLabel(totalurls);
		totalUrls.setHorizontalAlignment(SwingConstants.CENTER);
		totalUrls.setFont(new Font("Tahoma", Font.BOLD, 40));
		totalUrls.setBounds(10, 10, 158, 53);
		panel_2.add(totalUrls);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(22, 10, 812, 38);
		panel_3.setBackground(Color.RED);
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblSignedInAs = new JLabel("Signed In As : ");
		lblSignedInAs.setForeground(Color.WHITE);
		lblSignedInAs.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSignedInAs.setBounds(21, 10, 121, 18);
		panel_3.add(lblSignedInAs);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setText(EmailAccessUsingImap.user);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblEmail.setBounds(143, 10, 379, 18);
		panel_3.add(lblEmail);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(52, 190, 98, 94);
		frame.getContentPane().add(panel_4);
		panel_4.setLayout(null);
		
		
		String val9 = getAlgoResult();
		String val[] = val9.split(" ");
		
		JLabel lblJ = new JLabel("J48");
		lblJ.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblJ.setHorizontalAlignment(SwingConstants.CENTER);
		lblJ.setBounds(10, 61, 78, 23);
		panel_4.add(lblJ);
		
		JLabel J48 = new JLabel("00.00");
		J48.setText(val[1]);
		J48.setHorizontalAlignment(SwingConstants.CENTER);
		J48.setFont(new Font("Tahoma", Font.BOLD, 20));
		J48.setBounds(10, 10, 78, 53);
		panel_4.add(J48);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(177, 190, 98, 94);
		frame.getContentPane().add(panel_6);
		panel_6.setLayout(null);
		
		JLabel lblSvm = new JLabel("SVM");
		lblSvm.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSvm.setHorizontalAlignment(SwingConstants.CENTER);
		lblSvm.setBounds(10, 61, 78, 23);
		panel_6.add(lblSvm);
		
		JLabel svm = new JLabel("00.00");
		svm.setText(val[4]);
		svm.setHorizontalAlignment(SwingConstants.CENTER);
		svm.setFont(new Font("Tahoma", Font.BOLD, 20));
		svm.setBounds(10, 10, 78, 51);
		panel_6.add(svm);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBounds(55, 309, 98, 94);
		frame.getContentPane().add(panel_7);
		panel_7.setLayout(null);
		
		JLabel lblOner = new JLabel("OneR");
		lblOner.setHorizontalAlignment(SwingConstants.CENTER);
		lblOner.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblOner.setBounds(10, 63, 78, 21);
		panel_7.add(lblOner);
		
		JLabel oneR = new JLabel("00.00");
		oneR.setText(val[3]);
		oneR.setFont(new Font("Tahoma", Font.BOLD, 20));
		oneR.setHorizontalAlignment(SwingConstants.CENTER);
		oneR.setBounds(10, 10, 78, 54);
		panel_7.add(oneR);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBounds(177, 309, 98, 94);
		frame.getContentPane().add(panel_8);
		panel_8.setLayout(null);
		
		JLabel lblPart = new JLabel("PART");
		lblPart.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPart.setHorizontalAlignment(SwingConstants.CENTER);
		lblPart.setBounds(10, 64, 78, 20);
		panel_8.add(lblPart);
		
		JLabel part = new JLabel("00.00");
		part.setText(val[2]);
		part.setHorizontalAlignment(SwingConstants.CENTER);
		part.setFont(new Font("Tahoma", Font.BOLD, 20));
		part.setBounds(10, 10, 78, 53);
		panel_8.add(part);
		
		JPanel panel_9 = new JPanel();
		panel_9.setForeground(Color.WHITE);
		panel_9.setToolTipText("Blocked Users");
		panel_9.setBounds(339, 190, 462, 30);
		panel_9.setBackground(Color.RED);
		frame.getContentPane().add(panel_9);
		panel_9.setLayout(null);	
		
		JLabel lblUrlsInMail = new JLabel("Blocked Users");
		lblUrlsInMail.setBounds(10, 0, 150, 28);
		panel_9.add(lblUrlsInMail);
		lblUrlsInMail.setForeground(Color.WHITE);
		lblUrlsInMail.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(339, 230, 462, 173);
		textArea.setText(getBlockedUsers());
		frame.getContentPane().add(textArea);
	}
	
	private static String getBlockedUsers() {
		
		
		File file = new File("D:\\Eclipse\\FinalBuilt\\src\\com\\finalbuilt\\BlockedUser.txt");
		String str = "";
		try {
			Scanner sc = new Scanner(file);
			while(sc.hasNext()) {
				str = str + sc.nextLine() + "\n";
				count++;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
		
	}
	
	public static String getAlgoResult() {
		
		
		String str = " ";
		try {
			File file = new File("D:\\Eclipse\\FinalBuilt\\src\\com\\finalbuilt\\AlgoResults.txt");
			Scanner sc = new Scanner(file);
			while(sc.hasNext()) {
				str =  str + sc.nextLine().substring(0,5) + " ";
			}
			sc.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}
}
