import java.io.*;
import java.net.*;
class Server extends Thread{
	public String smsg,cmsg;
	public ServerSocket sersoc;
	public Thread t1=null,t2=null,t3=null,t4=null,t5=null;
	public Socket client1,client2,client3,client4;
	public BufferedReader msginput,clientin1,clientin2,clientin3,clientin4;
	public PrintWriter clientout1,clientout2,clientout3,clientout4;
	public Server(){
		try{
			smsg="";
			cmsg="";
			sersoc=new ServerSocket(5055);
			System.out.println("\n\nServer is up ..\n");
			client1=sersoc.accept();
			client2=sersoc.accept();
			client3=sersoc.accept();
			client4=sersoc.accept();
			msginput=new BufferedReader(new InputStreamReader(System.in));
			clientin1=new BufferedReader(new InputStreamReader(client1.getInputStream()));
			clientin2=new BufferedReader(new InputStreamReader(client2.getInputStream()));
			clientin3=new BufferedReader(new InputStreamReader(client3.getInputStream()));
			clientin3=new BufferedReader(new InputStreamReader(client4.getInputStream()));
			clientout1=new PrintWriter(client1.getOutputStream(),true);
			clientout2=new PrintWriter(client2.getOutputStream(),true);
			clientout3=new PrintWriter(client3.getOutputStream(),true);
			clientout4=new PrintWriter(client4.getOutputStream(),true);

		}
		catch(Exception e){}
	}
	public void run(){
		while(!(smsg.equals("quit"))){
			if(Thread.currentThread()==t1){
				try{
					smsg=msginput.readLine();
					clientout1.println("From Server"+smsg);
					clientout2.println("From Server"+smsg);
					clientout3.println("From Server"+smsg);
					clientout4.println("From Server"+smsg);

				}
				catch(Exception e){}
			}
			else if(Thread.currentThread()==t2){
				try{
					cmsg=clientin1.readLine();
					System.out.println(cmsg);
					clientout2.println("From Client1:"+cmsg);
					clientout3.println("From Client1:"+cmsg);
					clientout4.println("From Client1:"+cmsg);

				}
				catch(Exception e){}
			}
			
			else if (Thread.currentThread()==t3){
				try{
					cmsg=clientin2.readLine();
					System.out.println(cmsg);
					clientout1.println("From Client2:"+cmsg);
					clientout3.println("From Client2:"+cmsg);
					clientout4.println("From Client2:"+cmsg);
				}
				catch(Exception e){}
			}
			else if (Thread.currentThread()==t4){
				try{
					cmsg=clientin3.readLine();
					System.out.println(cmsg);
					clientout2.println("From Client3:"+cmsg);
					clientout1.println("From Client3:"+cmsg);
					clientout4.println("From Client3:"+cmsg);
				}
				catch(Exception e){}
			}
			else if (Thread.currentThread()==t5){
				try{
					cmsg=clientin4.readLine();
					System.out.println(cmsg);
					clientout2.println("From Client4:"+cmsg);
					clientout3.println("From Client4:"+cmsg);
					clientout1.println("From Client4:"+cmsg);
				}
				catch(Exception e){}
			}
 cmsg=cmsg.substring(cmsg.length()-4,cmsg.length());


		}
	}
	public static void main(String args[]){
		Server s=new Server();
		s.t1=new Thread(s);
		s.t2=new Thread(s);
		s.t3=new Thread(s);
		s.t4=new Thread(s);
		s.t5=new Thread(s);
		s.t1.start();
		s.t2.start();
		s.t3.start();
		s.t4.start();
		s.t5.start();
	}


}
