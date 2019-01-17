package com.client.view;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

public class MyButton extends JButton{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public MyButton()
	{
		setContentAreaFilled(false);
		setBorderPainted(false);
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
			}
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				setBorderPainted(true);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				setBorderPainted(false);
			}
		});
	}
}
