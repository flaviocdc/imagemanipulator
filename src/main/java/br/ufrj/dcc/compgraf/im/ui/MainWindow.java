package br.ufrj.dcc.compgraf.im.ui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

import br.ufrj.dcc.compgraf.im.ui.actions.OpenFileActionListener;
import br.ufrj.dcc.compgraf.im.ui.actions.SaveFileActionListener;

public class MainWindow extends JFrame
{
 
  private JPanel mainPanel;
  
  public MainWindow()
  {
    super("Image Manipulator");
    
    UIContext.instance().setMainWindow(this);
    
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
    
    setSize(800, 600);
    
    createMenu();
    
    initLayout();
  }
  
  private void initLayout()
  {
    mainPanel = new JPanel();
    mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));
    
    add(mainPanel);
    
    mainPanel.add(Box.createRigidArea(new Dimension(10, 10)));
    mainPanel.add(new ToolboxPanel());
    mainPanel.add(Box.createRigidArea(new Dimension(10, 10)));
    
    createImageCanvas();
    
    mainPanel.add(Box.createRigidArea(new Dimension(10, 10)));
  }

  private void createImageCanvas()
  {
    ScrollablePicture scrollableImage = new ScrollablePicture(null);
    JScrollPane imageScrollPane = new JScrollPane(scrollableImage, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    imageScrollPane.setPreferredSize(new Dimension(500, 500));
    imageScrollPane.setViewportBorder(BorderFactory.createLineBorder(Color.BLACK));
    
    mainPanel.add(imageScrollPane);
    
    UIContext.instance().setImageScrollPane(imageScrollPane);
  }

  private void createMenu()
  {
    JMenuBar menuBar = new JMenuBar();
    
    JMenu fileMenu = new JMenu("File");
    
    JMenuItem openMenuItem = new JMenuItem("Open");
    JMenuItem saveMenuItem = new JMenuItem("Save");
    JMenuItem closeMenuItem = new JMenuItem("Close");
    
    openMenuItem.addActionListener(new OpenFileActionListener());
    saveMenuItem.addActionListener(new SaveFileActionListener());
    
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
