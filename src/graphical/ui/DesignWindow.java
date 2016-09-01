package graphical.ui;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class DesignWindow {
	private JFrame frame;
	private JMenuBar menuBar;
	private JMenu fileMenu, simulationMenu;
	private JMenuItem newMenuItem, saveMenuItem, importBlockMenuItem, exitMenuItem, startMenuItem, stepMenuItem, stopMenuItem;
	
	public DesignWindow(){
		frame = new JFrame("Logical Circuits 2016");
		createMenu();
		
		frame.setSize(800,800);
		frame.setVisible(true);
		// Close program upon exit from window
		frame.addWindowListener(new WindowAdapter() {
	         public void windowClosing(WindowEvent windowEvent){
		        System.exit(0);
	         }        
	      });
	}
	
	private void createMenu(){
		// Create the menu bar where all menus goes.
		menuBar = new JMenuBar();
		
		// File menu
		fileMenu = new JMenu("File");
		menuBar.add(fileMenu);
		// Create menu objects
		newMenuItem = new JMenuItem("New");
		saveMenuItem = new JMenuItem("Save");
		importBlockMenuItem = new JMenuItem("Import .block schematic");
		exitMenuItem = new JMenuItem("Exit");
		newMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		saveMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		fileMenu.add(newMenuItem);
		fileMenu.add(saveMenuItem);
		fileMenu.add(importBlockMenuItem);
		fileMenu.add(exitMenuItem);
		
		// Simulation menu
		simulationMenu = new JMenu("Simulation");
		menuBar.add(simulationMenu);
		// Create menu objects
		startMenuItem = new JMenuItem("Start simulation");
		stepMenuItem = new JMenuItem("Step through");
		stopMenuItem = new JMenuItem("Stop simulation");
		startMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F5, 0));
		stepMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F6, 0));
		simulationMenu.add(startMenuItem);
		simulationMenu.add(stepMenuItem);
		simulationMenu.add(stopMenuItem);
		
		frame.setJMenuBar(menuBar);
	}
}
