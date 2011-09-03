package br.ufrj.dcc.compgraf.im.ui.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.ufrj.dcc.compgraf.im.ui.options.ResizeOptionsDialog;

public class OpenResizeDialogActionListener implements ActionListener
{

  @Override
  public void actionPerformed(ActionEvent e)
  {
    new ResizeOptionsDialog().setVisible(true);
  }

}
