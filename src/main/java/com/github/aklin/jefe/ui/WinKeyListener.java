package com.github.aklin.jefe.ui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 */
public class WinKeyListener implements KeyListener {

	private final Window parent;

	public WinKeyListener(final Window parent) {
		this.parent = parent;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
			case KeyEvent.VK_W:
				if (e.isControlDown())
					parent.close();
				break;

		}
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}
}
