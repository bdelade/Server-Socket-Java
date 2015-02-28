package com.mygdx.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class FlowManager {
	private boolean isserv=false;	
	private boolean noprob=true;
	
	private Socket socket;
	int port=11111;
	

	
	public FlowManager(){
		
		
		try {
			socket = new Socket("127.0.0.1", port);
		 
			
		} catch (Exception e) {
			
			startServer();
			 
			
			
					}

	
	}


	public boolean erreur() {
		return (noprob);
		
	}

	private void startServer() {
		try {
			isserv=true;
			socket = (new ServerSocket(port)).accept();
			
		
		} catch (IOException e) {
	
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
public void sendCircle(Circle cercle){
	
	try {
		ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
		oos.writeObject(cercle);
		System.out.println("send");
	} catch (Exception e) {
		noprob = false;
	}
	

	
}



public Circle circleReceiver(){
	Circle cercle = null;
	
	try {
		
		ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
		
		cercle = (Circle) ois.readObject();
		System.out.println("recive");
		
	} catch (Exception e) {
		noprob = false;
	}
	
	return cercle;
}
	
public boolean isserv(){
	return isserv;
}







}

	
	
	
	
	
	
	
	
	
	
	
	


