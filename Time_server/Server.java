import java.io.*;
import java.net.*;
import java.util.*;
class Server{
	public static void main(String args[])throws Exception{
		DatagramSocket server=new DatagramSocket(6766);
		while(true){
			System.out.println("\nSrever is up ");
			byte[] rec=new byte[1024];
			byte[] sen=new byte[2017];
			DatagramPacket recpack=new DatagramPacket(rec,rec.length);
			server.receive(recpack);
			InetAddress ip =recpack.getAddress();
			int port = recpack.getPort();
			Date d=new Date();
			String time =d+"";
			sen=time.getBytes();
			DatagramPacket toclient =new DatagramPacket(sen,sen.length,ip,port);
			server.send(toclient);
			System.out.println("\nSent succesfully");
		}
	}
}