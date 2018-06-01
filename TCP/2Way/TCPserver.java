import java.io.*;
import java.net.*;
class TCPserver{
	public static void main(String args[])throws Exception{
		ServerSocket server= new ServerSocket(5656);
		Socket soc=server.accept();
		BufferedReader smsg=new BufferedReader(new InputStreamReader(System.in));
		BufferedReader cmsg=new BufferedReader(new InputStreamReader(soc.getInputStream()));
		PrintWriter pr=new PrintWriter(soc.getOutputStream(),true);
		String msg;
		while(true){
			if((msg=cmsg.readLine())!=null){
				System.out.println(msg);
			}
			pr.println(smsg.readLine());
			pr.flush();
		}

	}
}