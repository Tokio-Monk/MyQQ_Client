package com.client.data;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Properties;

import com.client.view.J_MainFrm;
import com.common.User;

/**
 * 客户端连接服务器
 * @author Administrator
 *
 */
public class ClientToServer implements Runnable{

	//Socket对象
	private Socket s;
	//private DataInputStream in = null; //定义输入流
	//private DataOutputStream out = null; //定义输出流
	private ObjectInputStream ois = null;//定义输入流
	private ObjectOutputStream oos = null;//定义输出流
	
    private String IP = ""; //服务器ip
    private int PORT = 0; //服务器端口
    private String QQNum;
    private boolean flag = false;
    private boolean isSuccessLogin = false;
    private String loginInfo = null;
    private boolean isRegister;
    
    J_MainFrm mainFrm;
    
	/**
	 * 连接服务器登录进入主窗口
	 * @param mainFrm
	 */
	public ClientToServer(J_MainFrm mainFrm){
    	this.mainFrm = mainFrm;
    	getPropertiesInfo();
    }
	
	 /**
	 * 该方法用来获得服务器属性文件中的IP、PORT
	 */
	private void getPropertiesInfo(){
		Properties prop = new Properties();
		InputStream inStream = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream("ServerInfo.properties");
		try{
			//获得相应的键值对
			prop.load(inStream);
		}catch(IOException e){
			e.printStackTrace();
		}
		//根据相应的键获得对应的值
		IP = prop.getProperty("serverip");
		PORT = Integer.parseInt(prop.getProperty("servertcp.port"));
	}
		
	/**
	 * 发送第一次请求
	 * @param u
	 * @return
	 * @throws IOException
	 */
	public boolean sendLoginInfoToServer(User u) throws IOException {
		try {
			s = new Socket(IP,PORT);
			oos = new ObjectOutputStream(s.getOutputStream());
			QQNum = u.getUserId();
			
			String clientIP = getClientIp();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//in.close();
			if(oos != null){
				oos.close();
			}
			//关闭Scoket
			if(s != null){
				s.close();
			}
		}
		return isSuccessLogin;
	}
	
	/**
	 * 获取客户端ip
	 * @return
	 */
	private String getClientIp(){
		InetAddress localAddr = null;
		try {
			localAddr = InetAddress.getLocalHost();
		} catch (UnknownHostException e1) {
			e1.printStackTrace();
		}
		String localIP = localAddr.getHostAddress();
		IP = localIP;
		return IP;
	}
	
	/**
	 * 获取用户登录信息
	 * @return
	 */
	public String getLoginInfo(){
		return loginInfo;
	}
	
	/**
	 * 退出连接
	 */
	/*public void logout() {
		try {
			oos.writeObject("logout");
			String msg = ois.
			if(msg.equals("logout")){
				in.close();
				out.close();
				// 关闭Scoket
				s.close();
				flag = false;
			}

		} catch (Exception e) {
			try {
				in.close();
				out.close();
				// 关闭Scoket
				s.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {

		}
	}*/
	
	@Override
	public void run() {
		try {
			while (true) {
				if(!isRegister){
				}
			}
        }catch (Exception e) {
            e.printStackTrace();
            try {
				s.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
        }
	}
}
