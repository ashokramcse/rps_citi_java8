package com.cts.semaphores;

import java.util.concurrent.Semaphore;

public class SampleThread extends Thread {
	Semaphore semaphore;
	 
	SampleThread(Semaphore semaphore){
	      this.semaphore = semaphore;
	   }
	 
	   public void run() {
	      try {
	    		System.out.println(this.getName()  + " : acquiring lock...");
	    	     System.out.println(this.getName() + " : available Semaphore permits now: "
							+ semaphore.availablePermits());
	    	 	         semaphore.acquire();
	    	 	   
	         System.out.println("Hello " + this.getName());
	         System.out.println(this.getName() + " : got the permit!");
	         try {
	            sleep(2000);
	         } catch (Exception e) {}
	      } catch (InterruptedException ie) {
	      } finally {
	    		System.out.println(this.getName()  + " : releasing lock...");
	         semaphore.release();
	         System.out.println(this.getName() + " : available Semaphore permits now: "
						+ semaphore.availablePermits());
	         System.out.println("Goodbye " + this.getName());
	      }
	   }
}
