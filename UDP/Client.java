import java.io.*;
import java.net.*;
class Client{
	public static void main(String args[])throws Exception{
		byte[] send = new byte[2016];
		byte[] rec=new byte[2016];
		String datas;
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		int port=4534;
		InetAddress ip = InetAddress.getByName("localhost");
		DatagramSocket client=new DatagramSocket();
		while(true){
			System.out.println("\nEnter the message: ");
			datas=in.readLine();
			send=datas.getBytes();
			DatagramPacket sendpack=new DatagramPacket(send,send.length,ip,port);
			client.send(sendpack);
			DatagramPacket recivepack=new DatagramPacket(rec,rec.length);
			client.receive(recivepack);
			
			String str=new String(recivepack.getData());
			System.out.println("From Server "+str);
			

		}
	}
}