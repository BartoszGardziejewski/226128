package client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

	private Socket socket = null;
	
	private PrintWriter writer;
	private BufferedReader reader;
	
	Client(int portNum){
		
		try{
			socket = new Socket("localhost",portNum);
			
			writer = new PrintWriter(socket.getOutputStream(),true);
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			mainLoop();
		
		}catch(Exception e){
			e.printStackTrace();
			System.exit(0);
		}
	}
	
	private void mainLoop(){
		while(!socket.isClosed()){
			
			
		}
	}
	
	public static void main(String... args){
		new Client(4545);
	}
}
