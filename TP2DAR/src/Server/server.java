package Server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class server {

	public static void main(String[] args) throws IOException {
		Socket socket;
		ServerSocket ss ; 
		ss=new ServerSocket(1234);
		System.out.println("le serveur attend d'un client");
		socket=ss.accept();
		System.out.println("client connecté");
		InputStream is=socket.getInputStream();
		InputStreamReader ir=new InputStreamReader(is);
		BufferedReader br=new BufferedReader(ir);
		PrintWriter pw=new PrintWriter(socket.getOutputStream(),true);
		
		String operation =br.readLine();
		System.out.println("op reçue du le client  :"+operation);
		String resultat=calculer(operation);
		pw.println(resultat);
		System.out.println("res envoyé au client  : "+resultat);
		socket.close();
		ss.close()	;
	}
	private static String calculer(String op ) {
		try	{
			String[] parts = op.split(" ");
			if (parts.length !=3) return"Format invalide";
			double a =Double.parseDouble(parts[0]);
			String operateur =parts[1];
			double b =Double.parseDouble(parts[2]);
			double res = switch (operateur){
			case "+" ->a+b;
			case"-" ->a-b ;
			case "*" ->a*b;
			case"/" ->b!=0 ?a/b :Double.NaN;
			default->Double.NaN ;
			
			};
			return "Résultat :  "+res;
		}catch(Exception e) {
			return"Erreur: opérateur :opération invalide("+e.getMessage()+")";
		}
	}
}
