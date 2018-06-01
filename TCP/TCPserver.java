import java.io.*;
import java.net.*;
class TCPserver {
	public static void main(String[] args) throws Exception {
		ServerSocket server=new ServerSocket(7676);
		Socket s=server.accept();
		//DataOutputStream dos = new DataOutputStream(s.getOutputStream());
		DataInputStream dis =new DataInputStream(s.getInputStream());
		String msg=new String(dis.readUTF());
		System.out.println(msg);
		//dos.writeUTF("hello from server");
		//dos.close();
		dis.close();
		s.close();

	}
}