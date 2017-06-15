package com.jsoft.testjavathread.test2;

class Counter {
	long count = 0;

	public synchronized void add(long value) {
		this.count += value;
		System.out.println(Thread.currentThread().getName() + ":" + "+" + value + ":" + this.count);
	}
}

class CounterThread extends Thread {

	protected Counter counter = null;

	public CounterThread(Counter counter) {
		this.counter = counter;
	}

	public void run() {
		for (int i = 0; i < 10; i++) {
			counter.add(i);
		}
	}
}

public class App2 {
	public static void main(String[] args) {
		Counter counterA = new Counter();
		Counter counterB = new Counter();
		Thread threadA = new CounterThread(counterA);
		Thread threadB = new CounterThread(counterB);

		threadA.start();
		threadB.start();
	}
}
