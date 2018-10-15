package server;

import java.net.Socket;

public class ClientThread extends Thread{

	private Socket socket;
	
	ClientThread(Socket socket){
		this.socket = socket;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
}
