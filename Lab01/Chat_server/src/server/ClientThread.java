package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThread extends Thread{

	private Socket socket;

	private PrintWriter writer;
	private BufferedReader reader;
	
	ClientThread(Socket socket){
		this.socket = socket;
	}

	@Override
	public void run() {
		System.out.println("thread run");
		try {
			writer = new PrintWriter(socket.getOutputStream(),true);
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		while(!socket.isClosed()){
			String input;
			try {
				input = reader.readLine();
				if (input != null){
					System.out.print(input);
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//System.out.println("listening");
		}
		
	}
	
}
