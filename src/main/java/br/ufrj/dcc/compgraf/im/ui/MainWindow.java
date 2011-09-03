package br.ufrj.dcc.compgraf.im.ui;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MainWindow extends JFrame
{
  
  public MainWindow()
  {
    super("Image Manipulator");
    
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
    
    setSize(800, 600);
    
    createMenu();
  }
  
  private void createMenu()
  {
    JMenuBar menuBar = new JMenuBar();
    
    JMenu fileMenu = new JMenu("File");
    
    JMenuItem openMenuItem = new JMenuItem("Open");
    JMenuItem saveMenuItem = new JMenuItem("Save");
    JMenuItem closeMenuItem = new JMenuItem("Close");
    
    fileMenu.add(openMenuItem);
    fileMenu.add(saveMenuItem);
    fileMenu.add(closeMenuItem);
    
    menuBar.add(fileMenu);
    
    setJMenuBar(menuBar);
  }

  public static void main(String[] args)
  {
    new MainWindow(); 
  }

}
