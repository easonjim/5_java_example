package com.jsoft.testzookeeper.test1;

import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;

public class ClientApp {

	FtpConfig ftpConfig;

	private FtpConfig getFtpConfig() {
		if (ftpConfig == null) {
			// 首次获取时，连接zk取得配置，并监听配置变化
			ZkClient zk = ZKUtil.getZkClient();
			ftpConfig = (FtpConfig) zk.readData(ZKUtil.FTP_CONFIG_NODE_NAME);
			System.out.println("从ZK中获取配置数据");
			System.out.println("ftpConfig=>"+ftpConfig);
			System.out.println("注册ZK的回调事件");
			zk.subscribeDataChanges(ZKUtil.FTP_CONFIG_NODE_NAME, new IZkDataListener() {

				@Override
				public void handleDataChange(String s, Object o) throws Exception {
					System.out.println("ZK事件回调handleDataChange：ftpConfig is changed !");
					System.out.println("node:" + s);
					System.out.println("ftpConfig=>" + o.toString());
					ftpConfig = (FtpConfig) o;// 重新加载FtpConfig
				}

				@Override
				public void handleDataDeleted(String s) throws Exception {
					System.out.println("ftpConfig is deleted !");
					System.out.println("node:" + s);
					ftpConfig = null;
				}
			});
		}
		return ftpConfig;

	}

	/**
	 * 模拟程序运行
	 *
	 * @throws InterruptedException
	 */
	public void run() throws InterruptedException {
		System.out.println("程序运行");
		getFtpConfig();				
	}
}
