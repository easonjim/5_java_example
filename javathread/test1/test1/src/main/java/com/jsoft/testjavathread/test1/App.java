package com.jsoft.testjavathread.test1;


class MyThread extends Thread{
	public void run(){
		System.out.println("MyThread running");
	}
}

class MyRunnable implements Runnable{
	public void run(){
		System.out.println("MyRunnable running");
	}
}

public class App 
{
    public static void main( String[] args )
    {
        MyThread myThread = new MyThread();
        myThread.start();
        
        Thread myThread2 = new Thread(){
        	public void run(){
        		System.out.println("MyThread2 running");
        	}
        };
        myThread2.start();
        
        MyRunnable myRunnable = new MyRunnable();
        Thread myThread3 = new Thread(myRunnable);
        myThread3.start();
        
        Runnable myRunnable2 = new Runnable() {
			
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("MyRunnable2 running");
			}
		};
		Thread myThread4 = new Thread(myRunnable2);
		myThread4.start();
		
		MyRunnable runnable = new MyRunnable();
		Thread thread = new Thread(runnable, "New Thread");
		thread.start();
		System.out.println(thread.getName());
		
		System.out.println(Thread.currentThread().getName());
    }
}
