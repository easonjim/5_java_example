package com.jsoft.testzookeeper.test2;

import java.io.IOException;
import java.util.Date;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.EventType;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;

/**
 * 创建属于自己的Watcher，该Watcher监控 zk上的/jfconf 节点， 当该节点下的文件发生变化重新加载缓存
 * ZooKeeper通过Auth和ACL完成节点的权限控制
 * Auth表示某种认证，由于一个ZooKeeper集群可能被多个项目使用，各个项目属于不同的项目组，
 * 他们在进行开发时肯定不想其他项目访问与自己相关的节点，这时可以通过为每个项目组分配一个Auth， 然后每个项目组先通过
 * Auth认证以后再继续相关的操作，这样甲Auth认证的用户就不能操作其他
 * Auth认证后创建的节点，从而实现各个项目之间的隔离。ZooKeeper提供了如下方法完成认证
 */
public class MyClient implements Watcher {

	// zk的连接串
	private final static String CONNECT_STR = "localhost:2181";
	// 连接zk的超时时间
	private static final int SESSION_TIMEOUT = 30000;
	// Auth认证
	public static String authType = "admin";
	public static String authPasswd = "*dmin1234";

	// client获取的数据库信息
	private String uRL;
	private String userName;
	private String passwd;

	public String getuRL() {
		return uRL;
	}

	public void setuRL(String uRL) {
		this.uRL = uRL;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public MyClient() {
		initValue();
	}	

	/**
	 * 获取zk连接
	 *
	 * @return
	 * @throws IOException
	 */
	public ZooKeeper getZk() {
		ZooKeeper zk = null;
		try {
			zk = new ZooKeeper(CONNECT_STR, SESSION_TIMEOUT, this);
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 判断权限是否能访问/jfconf目录
		//zk.addAuthInfo(authType, authPasswd.getBytes());
		return zk;
	}

	/**
	 * 获取zk中相关信息
	 *
	 * @throws Exception
	 */
	private void initValue() {
		try {
			ZooKeeper zk = getZk();
			
			//初始化数据
			if (zk.exists("/jfconf", true) == null) {
				zk.create("/jfconf", "10.12.1.1".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
			}
			if (zk.exists("/jfconf/uRLNode", true) == null) {
				zk.create("/jfconf/uRLNode", "10.12.1.1".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);

			}
			if (zk.exists("/jfconf/userNameNode", true) == null) {
				zk.create("/jfconf/userNameNode", "admin".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
			}
			if (zk.exists("/jfconf/passwdNode", true) == null) {
				zk.create("/jfconf/passwdNode", "admin123".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
			}
			
			//获取数据
			this.uRL = new String(zk.getData("/jfconf/uRLNode", true, null));
			this.userName = new String(zk.getData("/jfconf/userNameNode", true, null));
			this.passwd = new String(zk.getData("/jfconf/passwdNode", true, null));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void changeValue() {
		ZooKeeper zk = getZk();
		try {
			zk.setData("/jfconf/uRLNode", ("192.168.0.1"+new Date()).getBytes(),-1);
		} catch (KeeperException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 如何服务器中的配置信息发生变化，通知process方法，把zk中的数据重新获取，然后放到缓存中
	 */
	@Override
	public void process(WatchedEvent event) {
		System.out.println("ZK事件回调");
		String message = "";
		EventType type = event.getType();
		if (type.equals(Watcher.Event.EventType.None)) {
			message = "connect zk sucess!!!";
		} else if (type.equals(Watcher.Event.EventType.NodeCreated)) {
			message = "znode create sucess!!!";
		} else if (type.equals(Watcher.Event.EventType.NodeChildrenChanged)) {
			message = "child of znode create sucess!!!";
		} else if (type.equals(Watcher.Event.EventType.NodeDataChanged)) {
			message = "znode update success!!!,reload db's information";
			initValue();
		} else if (type.equals(Watcher.Event.EventType.NodeDeleted)) {
			message = "znode delete success!!!";
		}
		System.out.println(message+" start");
		System.out.println("url=" + getuRL());
		System.out.println("userName=" + getUserName());
		System.out.println("passwd=" + getPasswd());
		System.out.println(message+ " end");
	}
}
