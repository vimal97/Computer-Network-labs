import java.io.*;
import java.net.*;
class Client implements Runnable{
	public static Thread t1=null,t2=null;
	public Socket server;
	public BufferedReader msgin,msg;
	public String cmsg;
	public PrintWriter msgout;
	public Client(){
		try{
		
			cmsg="";
			System.out.println("\nConnecting...");
			server=new Socket("localhost",5055);
			System.out.println("\nConnected");
			msgin=new BufferedReader(new InputStreamReader(server.getInputStream()));
			msgout=new PrintWriter(server.getOutputStream(),true);
			msg=new BufferedReader(new InputStreamReader(System.in));

		}
		catch(Exception e){System.out.println("connection failed at constructor");}
	}
	public void run(){
		
		do{ 
			
			if(Thread.currentThread()==t1){
				try{
				cmsg=msg.readLine();
				msgout.println(cmsg);
				}catch(Exception e){System.out.println("Failed to write to server");}
			}
		

			else{
				try{
					cmsg=msgin.readLine();
					System.out.println(cmsg);
				}
				catch(Exception e){System.out.println("Failed to read from server");}

			}
cmsg=cmsg.substring(cmsg.length()-4,cmsg.length());
		
	}while(!(cmsg.equals("quit")));
  }
  public static void main(String args[]){
  	Client c=new Client();
  	
  	t1=new Thread(c);
  	
  	t2=new Thread(c);
  	t1.start();
  	t2.start();
  }
}
