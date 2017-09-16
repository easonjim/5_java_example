package com.jsoft.testzookeeper.test1;

import com.fasterxml.jackson.core.JsonProcessingException;

public class App {

	public static void main(String[] args) throws JsonProcessingException, InterruptedException {
		ConfigManager cfgManager = new ConfigManager();
		ClientApp clientApp = new ClientApp();

		// 模拟【配置管理中心】初始化时，从db加载配置初始参数
		cfgManager.loadConfigFromDB();
		
		// 然后将配置同步到ZK
		cfgManager.syncFtpConfigToZk();

		// 模拟客户端程序运行
		clientApp.run();

		// 模拟配置修改
		cfgManager.updateFtpConfigToDB(23, "10.6.12.34", "newUser", "newPwd");
		
		// 然后将配置同步到ZK
		cfgManager.syncFtpConfigToZk();		
		
		//线程阻塞，让程序保持在后台运行
		new Thread() {
			@Override
			public void run() {
				try {
					while (true) {
						Thread.sleep(1);
					}					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}.start();
	}

}
