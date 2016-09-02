package graphical.ui;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

/**
 * Menu that all the different views uses.
 * 
 * @author David Strömner
 */

public class Menu {
	private JMenuBar menuBar;
	private JMenu fileMenu, simulationMenu;
	private JMenuItem newMenuItem, saveMenuItem, openMenuItem, importBlockMenuItem, exitMenuItem, startMenuItem, stepMenuItem, stopMenuItem;
	
	public Menu(JFrame frame){
		// Create the menu bar where all menus goes.
		menuBar = new JMenuBar();
		
		// Create the menues
		createFileMenu();
		createSimulationMenu();
		
		// Add to frame
		frame.setJMenuBar(menuBar);
	}
	
	private void createFileMenu(){
		// File menu
		fileMenu = new JMenu("File");
		menuBar.add(fileMenu);
		// Create menu objects
		newMenuItem = new JMenuItem("New");
		saveMenuItem = new JMenuItem("Save");
		openMenuItem = new JMenuItem("Open");
		importBlockMenuItem = new JMenuItem("Import .block schematic");
		exitMenuItem = new JMenuItem("Exit");
		newMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		saveMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		openMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		fileMenu.add(newMenuItem);
		fileMenu.add(saveMenuItem);
		fileMenu.add(openMenuItem);
		fileMenu.add(importBlockMenuItem);
		fileMenu.add(exitMenuItem);
	}
	
	private void createSimulationMenu(){
		// Simulation menu
		simulationMenu = new JMenu("Simulation");
		menuBar.add(simulationMenu);
		// Create menu objects
		startMenuItem = new JMenuItem("Start");
		stepMenuItem = new JMenuItem("Step through");
		stopMenuItem = new JMenuItem("Stop");
		startMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F5, 0));
		stepMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F6, 0));
		simulationMenu.add(startMenuItem);
		simulationMenu.add(stepMenuItem);
		simulationMenu.add(stopMenuItem);
	}
}
