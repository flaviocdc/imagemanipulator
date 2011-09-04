package br.ufrj.dcc.compgraf.im.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.KeyStroke;

public class SwingUtils
{

  public static void addEscapeListener(final JDialog dialog)
  {
    ActionListener escListener = new ActionListener()
    {

      @Override
      public void actionPerformed(ActionEvent e)
      {
        dialog.setVisible(false);
      }
    };

    dialog.getRootPane().registerKeyboardAction(escListener,
        KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0),
        JComponent.WHEN_IN_FOCUSED_WINDOW);

  }
  
  public static void configureDialog(JDialog dialog)
  {
    dialog.setLocationRelativeTo(UIContext.instance().getMainWindow());
    SwingUtils.addEscapeListener(dialog);
    dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
  }

}
