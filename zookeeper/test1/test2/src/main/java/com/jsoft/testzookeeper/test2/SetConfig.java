package com.jsoft.testzookeeper.test2;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.ZooDefs.Ids;

public class SetConfig {
	// zk的连接串
	private final static String CONNECT_STR = "localhost:2181";

	// 连接zk的超时时间
	private static final int SESSION_TIMEOUT = 30000;

	// 数据库连接
	private final static String uRLNode = "10.12.1.1";
	private final static String userNameNode = "admin";
	private final static String passwdNode = "admin123";

	// Auth认证
	public static String authType = "digest";
	public static String authPasswd = "*ik1234";

	public static void main(String[] args) {
		try {
			ZooKeeper zk = new ZooKeeper(CONNECT_STR, SESSION_TIMEOUT, new Watcher() {
				@Override
				public void process(WatchedEvent e) {
					System.out.println(" type : " + e.getType() + ",path:" + e.getPath());
				}
			});

			zk.addAuthInfo(authType, authPasswd.getBytes());

			if (zk.exists("/jfconf", true) == null) {
				zk.create("/jfconf", uRLNode.getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
			}
			if (zk.exists("/jfconf/uRLNode", true) == null) {
				zk.create("/jfconf/uRLNode", uRLNode.getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);

			}
			if (zk.exists("/jfconf/userNameNode", true) == null) {
				zk.create("/jfconf/userNameNode", userNameNode.getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
			}
			if (zk.exists("/jfconf/passwdNode", true) == null) {
				zk.create("/jfconf/passwdNode", passwdNode.getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
			}
			zk.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
