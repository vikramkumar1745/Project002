package com.finalbuilt;

import java.util.*;
import javax.mail.*;
import javax.mail.Flags.Flag;
import javax.mail.internet.MimeBodyPart;
import javax.mail.search.FlagTerm;
 
public class EmailAccessUsingImap
{
	public static Folder inbox = null;
	public static int newMessage;
	public static String user;
	public static Object status;
	public static String from;
	public static String domainOfUrls[];
	public static String domainOfSender;
	private static String messageContent;
	private static Message message;
	@SuppressWarnings("static-access")
	private int count = this.newMessage;
	private static String urls[];
	private static List<String> data = null;
 
	public EmailAccessUsingImap(String username,String password)
	{
		String host = "imap.gmail.com";
        String port = "993";
		Properties props = new Properties();
		props.put("mail.imap.host", host);
	    props.put("mail.imap.port", port);
	    props.setProperty("mail.imap.socketFactory.class","javax.net.ssl.SSLSocketFactory");
	    props.setProperty("mail.imap.socketFactory.fallback", "false");
	    props.setProperty("mail.imap.socketFactory.port",String.valueOf(port));
		props.setProperty("mail.store.protocol", "imaps");
		try {
			
			user = username;
			Session session = Session.getDefaultInstance(props, null);
			Store store = session.getStore("imaps");
			store.connect("imap.gmail.com", username, password);
 
			inbox = store.getFolder("Inbox");
			newMessage = inbox.getMessageCount();
			inbox.open(Folder.READ_WRITE);
			Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
			
			if(messages.length == 0) {
				System.out.println("All messages read");
				BlockingUser.closeInbox();
			} else {
				message = messages[messages.length-1];
			try{
				if(count!=newMessage) {
					printEnvelope(message);
					
					count++;
					
				} else {
					System.out.println("No new Mails");
				}
			} catch (Exception ex){
				
				System.err.println("No mails to read");
				ex.printStackTrace();
			}
		}
		}
		catch (NoSuchProviderException e)
		{
			status = "Server Down";
		} catch (AuthenticationFailedException e) {
			
			status = "Incorrect Credentials";
		} catch (MessagingException e) {
			
			status = "Ckeck Your Internet Connection";
		} catch (Exception e) {
			
			status = "no messages to check";
		}
		
	}
 
 	private void printEnvelope(Message message) throws Exception
 	{
 		from = message.getFrom()[0].toString();
 		System.out.println("From : " + from);
 		int blockedStatus = BlockingUser.checkBlockedUser();
 		System.out.println(blockedStatus);
 		if(blockedStatus!=0) {
 			System.out.println("user already blocked");
 		} else {
 			String contentType = message.getContentType();
 			if (contentType.contains("multipart")) {
 				
 				Multipart multiPart = (Multipart) message.getContent();
 				int numberOfParts = multiPart.getCount();
 				for (int i=0; i<numberOfParts; i++) {
 					
 					MimeBodyPart part = (MimeBodyPart) multiPart.getBodyPart(i);
 						messageContent = part.getContent().toString();
 				}
 		    }    
 			else if (contentType.contains("text/plain") || contentType.contains("text/html")) {
        	
 				Object content = message.getContent();
 				if (content != null) {
 					messageContent = content.toString();
 				}
 			}
 		domainUrls(messageContent);		
 		System.out.println(messageContent);
 		}
 	}
 	
 	private static void domainUrls(String content) {
 		
 		if(content.contains("Forwarded")) {
  		
 			List<String> dl = PatternExtractor.extractDomainOfSender(content);
 			String string = dl.get(0);
 			domainOfSender = string.substring(7,string.length()-1);
 		} else {
 			String str[] = from.split("<");
 			domainOfSender = str[1].substring(0,str[1].length()-1);
 		}
 		//Urls
 		List<String> list = PatternExtractor.extractUrls(content);
 		urls = new String[list.size()];
 		for(int i=0; i<list.size(); i++) {
 			urls[i] =list.get(i);
 			System.out.println(urls[i]);
 		}
 		
 		domainOfUrls = PatternExtractor.extracDdomainOfUrls(urls);
 		
 		System.out.println("End");
 		testSetResults();
 	}
 	
 	
 	private static void testSetResults() {
 		
 		data = new ArrayList<String>();	
 		String url[] = new String[urls.length];
 		MainThreadClassForConditons.validatedDomain(domainOfUrls);
 		if(urls.length>1) {
		for (int i=0; i<urls.length; i++) {
			String string1 = ArffConditions.checkCondition(urls[i], domainOfUrls[i], domainOfSender);
			 url[i] = string1 + "," + MyRunnableDomain.ageOfDomain.get(i) + "," + MyRunnableDomain.dnsRecord.get(i);
			 data.add(url[i]);
		}
		writeToFile();
		
		} else {
			GuiNormalMail.call();
		}
		
 	}
 	
 	private static void writeToFile() {
 		ArffFormat.writeToDataFile(data);
 		Algorithm.applyAlgorithm();
 	}
 
 	public static Message getMessageToDelete() {
 		return message;
 	}
 	public static void call(String userName, String userCredentials)
 	{
 		new EmailAccessUsingImap(userName, userCredentials);
 	}

}