
import java.util.concurrent.Semaphore;
import java.util.*;
class rw {
	static Semaphore rlock=new Semaphore(1);
	static Semaphore dlock=new Semaphore(1);
	static int rcount=0;
	static class Read implements Runnable{

		 @Override
		public void run(){
			try{
				while(true){

				rlock.acquire();
				rcount++;
				if(rcount==1) dlock.acquire();
				rlock.release();
				System.out.println(Thread.currentThread().getName()+" is Reading");
				rlock.acquire();
				rcount--;

				if(rcount==0) dlock.release();
				rlock.release();
				System.out.println(Thread.currentThread().getName()+" Finished Reading");
				Thread.sleep(1500);
				}
			

			}
			catch(Exception e){;}
		}

	}
	static class Write implements Runnable{
		@Override
		public void run(){

		try{
			while(true){
				dlock.acquire();
				System.out.println(Thread.currentThread().getName()+" is Writting");
				dlock.release();
				System.out.println(Thread.currentThread().getName()+" Finished Writting");
				Thread.sleep(1500);


			}
		}
		catch(Exception e){;}
	}
  }
	public static void main(String[] args)throws Exception {
		int i,n,r,w;
		Write write= new Write();
		Read read=new Read();
 		Scanner s= new Scanner(System.in);
		System.out.println("\nEnter the No of readers:");
		r=s.nextInt();
		System.out.println("\n Enter the No of writers:");
		w=s.nextInt();
		n=r+w;
		int rc=0,wc=0;
		Thread[] threads=new Thread[n];

		for(i=0;i<n;i++){
			if(i<r){
				rc++;
				threads[i]=new Thread(read);
				threads[i].setName("Reader "+(rc));
				threads[i].start();
			}
			else{ 
				wc++;
				threads[i]=new Thread(write);
				threads[i].setName("Writer "+(wc));
				threads[i].start();
			}
		}

		
	}
}