import java.io.*;
import java.net.*;
class TCPclient{
	public static void main(String args[]) throws Exception{
		Socket soc=new Socket("localhost",5656);
		BufferedReader cmsg = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pr =new PrintWriter(soc.getOutputStream(),true);
		BufferedReader smsg=new BufferedReader(new InputStreamReader(soc.getInputStream()));
		String msg;
		while(true){
			pr.println(cmsg.readLine());
			pr.flush();
			if((msg=smsg.readLine())!=null){
				System.out.println(msg);
			}
			
		}
	}
}