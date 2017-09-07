package com.jsoft.testzookeeper.test1;

import com.fasterxml.jackson.core.JsonProcessingException;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 */
	public AppTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(AppTest.class);
	}

	/**
	 * Rigourous Test :-)
	 */
	public void testApp() {
		assertTrue(true);
	}

	public void testZkConfig() throws JsonProcessingException, InterruptedException {

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
		cfgManager.syncFtpConfigToZk();

		// 模拟客户端自动感知配置变化
		clientApp.run();
	}
	
}
