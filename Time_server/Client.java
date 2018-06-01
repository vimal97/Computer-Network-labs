import java.io.*;
import java.net.*;
class Client{
	public static void main(String args[])throws Exception{
		byte[] rec =new byte[2018];
		byte[] sen=new byte[1024];
		DatagramSocket client =new DatagramSocket();
		InetAddress ip=InetAddress.getByName("localhost");
		int port =6766;
		DatagramPacket spack=new DatagramPacket(sen,sen.length,ip,port);
		client.send(spack);
		DatagramPacket rpack=new DatagramPacket(rec,rec.length);
		client.receive(rpack);
		String time=new String(rpack.getData());
		System.out.println("\nServer time>>>"+time);
		client.close();

	}
}