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
 * �ͻ������ӷ�����
 * @author Administrator
 *
 */
public class ClientToServer implements Runnable{

	//Socket����
	private Socket s;
	//private DataInputStream in = null; //����������
	//private DataOutputStream out = null; //���������
	private ObjectInputStream ois = null;//����������
	private ObjectOutputStream oos = null;//���������
	
    private String IP = ""; //������ip
    private int PORT = 0; //�������˿�
    private String QQNum;
    private boolean flag = false;
    private boolean isSuccessLogin = false;
    private String loginInfo = null;
    private boolean isRegister;
    
    J_MainFrm mainFrm;
    
	/**
	 * ���ӷ�������¼����������
	 * @param mainFrm
	 */
	public ClientToServer(J_MainFrm mainFrm){
    	this.mainFrm = mainFrm;
    	getPropertiesInfo();
    }
	
	 /**
	 * �÷���������÷����������ļ��е�IP��PORT
	 */
	private void getPropertiesInfo(){
		Properties prop = new Properties();
		InputStream inStream = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream("ServerInfo.properties");
		try{
			//�����Ӧ�ļ�ֵ��
			prop.load(inStream);
		}catch(IOException e){
			e.printStackTrace();
		}
		//������Ӧ�ļ���ö�Ӧ��ֵ
		IP = prop.getProperty("serverip");
		PORT = Integer.parseInt(prop.getProperty("servertcp.port"));
	}
		
	/**
	 * ���͵�һ������
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
			//�ر�Scoket
			if(s != null){
				s.close();
			}
		}
		return isSuccessLogin;
	}
	
	/**
	 * ��ȡ�ͻ���ip
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
	 * ��ȡ�û���¼��Ϣ
	 * @return
	 */
	public String getLoginInfo(){
		return loginInfo;
	}
	
	/**
	 * �˳�����
	 */
	/*public void logout() {
		try {
			oos.writeObject("logout");
			String msg = ois.
			if(msg.equals("logout")){
				in.close();
				out.close();
				// �ر�Scoket
				s.close();
				flag = false;
			}

		} catch (Exception e) {
			try {
				in.close();
				out.close();
				// �ر�Scoket
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
