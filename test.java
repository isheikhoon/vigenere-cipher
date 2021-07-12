package ics254;
import java.util.*;
import java.io.*;
public class test {

		public static void main(String[] args) throws FileNotFoundException {
			String Key;
			
			System.out.println("1.FileEncryption \n2.FileDecryption\n3.OwnEncryptin\n4.OwnDecryption\n5.Exit");
			Scanner choice = new Scanner(System.in);
			
			int userChoice = choice.nextInt();
		
			if(userChoice == 1) {
				Scanner read = new Scanner(new File("Q1Decrypted.txt"));
				PrintWriter write = new PrintWriter(new File("Q1Encrypted.dec"));
				Key=read.nextLine();
				while(read.hasNextLine()) {
				String encrypted = EncryptionDriver.encryption(Key, 0, "", 0,read.nextLine());
				write.println(encrypted);}
				write.close();
				read.close();
				
			}
			else if(userChoice == 2) {
				System.out.println("enter the decryption key: ");
				Scanner inputkey = new Scanner(System.in);
				String key = inputkey.nextLine();
				Scanner read = new Scanner(new File("Q1Encrypted.dec"));
				PrintWriter write = new PrintWriter(new File("decryptedd2.txt"));
				write.println(key);
				while(read.hasNextLine()) {
				String decrypted = EncryptionDriver.decryption(key, 0,"", 0,read.nextLine());
				write.println(decrypted);}
				write.close();
				inputkey.close();
				read.close();
			}
			else if(userChoice == 3) {
				System.out.println("enter the encrypton key and the text you want to Encrypt: ");
				Scanner inputkey = new Scanner(System.in);
				String key = inputkey.nextLine();
				String word=inputkey.nextLine();
				PrintWriter write = new PrintWriter(new File("Q2Decrypted.txt"));
				String encrypt = EncryptionDriver.encryption(key, 0, "", 0, word);
				System.out.println("The Key that you used is:"+key+"\nThe Encrypted word is:"+encrypt);
				inputkey.close();
				write.close();
			}
			else if(userChoice == 4) {
				System.out.println("enter the decryption key and the text you want to Decrypt: ");
				Scanner inputkey = new Scanner(System.in);
				String key = inputkey.nextLine();
				String word=inputkey.nextLine();
				PrintWriter write = new PrintWriter(new File("Q2Decrypted.txt"));
				String decrypt = EncryptionDriver.decryption(key, 0, "", 0, word);
				System.out.println("The Key that you used is:"+key+"\nThe Decrypted word is:"+decrypt);
				inputkey.close();
				write.close();
			}
			
		}
		
	}
