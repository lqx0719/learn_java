package test1;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;



public class testSynchronized {
	private static String A = "A";
	private static String B = "B";
	public static void main(String[] args){
		new testSynchronized().deadLock();
	}
	private void deadLock(){
		Thread threadA = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				synchronized(A){
					try{
						Thread.currentThread().sleep(2000);
					}catch(InterruptedException e){
						e.printStackTrace();
					}
					synchronized(B){
						System.out.println("AB");
					}
				}
			}
		});
		
		Thread threadB = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				synchronized(B){
					try{
						Thread.currentThread().sleep(2000);
					}catch(InterruptedException e){
						e.printStackTrace();
					}
					synchronized(A){
						System.out.println("BA");
					}
				}
			}
		});
		
		threadA.start();
		threadB.start();
	}
	
}
