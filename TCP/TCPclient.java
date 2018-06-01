import java.io.*;
import java.net.*;
class TCPclient{
	public static void main(String args[])throws Exception{
		Socket s = new Socket("localhost",7676);
		//DataInputStream dis =new DataInputStream(s.getInputStream());
		//String msg = new String(dis.readUTF());
		//System.out.println(msg);
		//dis.close();
		DataOutputStream dos=new DataOutputStream(s.getOutputStream());
		dos.writeUTF("client msg");
		dos.close();
		s.close();
	}
}