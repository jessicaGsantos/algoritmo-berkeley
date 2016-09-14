package br.com.andreluizlunelli.algoritmo_berkeley;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.Assert;

public class ServerBerkeleyTest {
	
//	@BeforeClass
//	public static void initServer() {
//		new Thread() {
//			@Override
//			public void run() {				
//				BerkeleyServer.start();				
//			}
//		}.start();
//	}

	// TODO enviar a hora hh:mm:ss
	
	public void connectInServerTest() {
		try {			
			Socket client = new Socket("127.0.0.1", 9999);
			PrintStream printer = new PrintStream(client.getOutputStream());
			printer.println(1); // manda um valor qualquer para se conectar
			
			Scanner serverReturn = new Scanner(client.getInputStream());
			String nextLine = null;
			while (serverReturn.hasNext()) {
				nextLine = serverReturn.nextLine();				
				System.out.println(nextLine);
				ParseReturn parser = new ParseReturn(nextLine);
				String time = parser.getValue("tempo");
				String direction = parser.getValue("sentido");
				System.out.format("hora:%s, sentido:%s", time, direction);				
			}
			// daqui em diante so passa se o servidor morrer
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
//	@Test
	public void test02() {
		// TODO fazer teste de pergunta aos clientes sobre qual é a idade deles
	}

	
}
