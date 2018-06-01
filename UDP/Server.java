import java.io.*;
import java.net.*;
class Server{
	public static void main(String args[])throws Exception{
		DatagramSocket server=new DatagramSocket(4534);
		System.out.println("\nServer is running")
		byte[] recive =new byte[2045];
		byte[] send = new byte[2016];
		while(true){
			DatagramPacket recivepack=new DatagramPacket(recive,recive.length);
			server.receive(recivepack);
			String str=new String(recivepack.getData());
			System.out.println("From client "+str);
			InetAddress ip = recivepack.getAddress();
			int port=recivepack.getPort();
			BufferedReader inputdata=new BufferedReader(new InputStreamReader(System.in));
			String datastring=inputdata.readLine();
			send = datastring.getBytes();
			DatagramPacket sendpack=new DatagramPacket(send,send.length,ip,port);
			server.send(sendpack);

		}

	}
}