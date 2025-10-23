package Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class client {

	public static void main(String[] args) throws UnknownHostException, IOException {

		Socket s=new Socket("192.168.56.1",1234);
		System.out.println("je suis connectée au server");
        OutputStream os=s.getOutputStream();
		PrintWriter pw=new PrintWriter(os,true);
		BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream())); 
		Scanner sc=new Scanner(System.in);
		System.out.println("Entrer une opération :");
		String operation=sc.nextLine();
		pw.println(operation);
		String reponse = br.readLine();
		System.out.println("repose du serveur :"+reponse);
		s.close();
		sc.close();
	}

}
