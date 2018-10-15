package server;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
	
	private ServerSocket sSocket = null;
	
	private ArrayList<ClientThread> clients;
	
	Server(int portNum){
		
		long p = 23;
		long q = 5;
		
		try {
			sSocket = new ServerSocket(portNum);
			mainLoop();
		}catch(Exception e)
		{
			e.printStackTrace();
			System.exit(0);
		}
	}
	
	private void mainLoop(){
		while(true){
			
			try{
				Socket cSocket = sSocket.accept();
				ClientThread client = new ClientThread(cSocket);
				client.start();
				clients.add(client);
				
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String... args){
		new Server(4545);
	}
}
