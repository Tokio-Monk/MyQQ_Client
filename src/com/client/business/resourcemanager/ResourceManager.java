/**
 * 
 */
package com.client.business.resourcemanager;

import java.awt.Image;

import javax.swing.ImageIcon;

import com.client.data.LoadImages;


/**
 * @author lenovo
 *
 */
public class ResourceManager {
	
	/*
	 * ͼƬ��Դ������
	 */
	/**
	 * ���ͼƬ
	 * @param imageName
	 * @return
	 */
	public ImageIcon GetImage(String imageName)
	{
		LoadImages image = new LoadImages();
		return image.LoadImageIcon(imageName);
	}
	/**
	 * ���ͼƬ
	 * @param imageName
	 * @return
	 */
	public Image GetImage1(String imageName){
		LoadImages image = new LoadImages();
		return image.loadImage(imageName);
	}
}
