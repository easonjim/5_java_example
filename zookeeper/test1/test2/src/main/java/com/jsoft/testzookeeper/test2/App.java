package com.jsoft.testzookeeper.test2;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main(String[] args) throws InterruptedException {
		System.out.println("程序启动，并初始化数据！");
		MyClient client = new MyClient();
		
		//保证在后台运行
		new Thread() {
			@Override
			public void run() {
				while (true) {
					System.out.println("线程监听数据变化！");
					System.out.println("url=" + client.getuRL());
					System.out.println("userName=" + client.getUserName());
					System.out.println("passwd=" + client.getPasswd());
					try {
						Thread.sleep(10 * 1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}				
			};
		}.start();
		
		System.out.println("更新数据！");
		client.changeValue();
	}
}
