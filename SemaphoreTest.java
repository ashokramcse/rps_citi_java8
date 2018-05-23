package com.cts.semaphores;

import java.util.concurrent.Semaphore;

public class SemaphoreTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Consider an ATM cubicle with 4 ATMs, 
		//Semaphore can make sure only 4 people can access simultaneously.
		      Semaphore semaphore=new Semaphore(2);
		      SampleThread mt1 = new   SampleThread(semaphore);
		      SampleThread mt2 = new SampleThread(semaphore);
		      SampleThread  mt3 = new SampleThread(semaphore);
		      SampleThread mt4 = new SampleThread(semaphore);
		      mt1.start();
		      mt2.start();
		      mt3.start();
		      mt4.start();
		   
	}

}
