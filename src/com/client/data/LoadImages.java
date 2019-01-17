/**
 * 
 */
package com.client.data;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 * @author lenovo
 *
 */
public class LoadImages {

	public LoadImages() {
	}

    public Image loadImage(String name) {
    	File file = new File("image/Chat/"+name+".png");
    	Image img = null;
    	try {
			img = ImageIO.read(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
    	return img;
	}
    
    public ImageIcon LoadImageIcon(String name){
        ImageIcon icon = new ImageIcon(loadImage(name));
		return icon;
    }
    
    public Image loadEpImage(String name) {
	 	File file = new File("image/Chat/12/"+name+".gif");
	 	Image img = null;
	 	try {
				img = ImageIO.read(file);
			} catch (IOException e) {
				e.printStackTrace();
			}
	 	return img;
	}
}
 
