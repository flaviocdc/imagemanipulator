package br.ufrj.dcc.compgraf.im.ui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;

public class MainWindow extends JFrame
{
  
  public MainWindow()
  {
    super("Image Manipulator");
    
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
    
    setSize(800, 600);
    
    createMenu();
    
    initLayout();
  }
  
  private void initLayout()
  {
    setLayout(new BorderLayout(5, 5));
    
    add(new Canvas(), BorderLayout.CENTER);
    add(new JLabel("Teste"), BorderLayout.LINE_START);
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
    SwingUtilities.invokeLater(new Runnable()
    {
      @Override
      public void run()
      {
        new MainWindow(); 
      }
    });
  }

}
