package events;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import view.MyJTextField;

/**
 * Processing focus lost events of text field components on the view
 * @author Yuliya
 *
 */
public class FocusHandler implements FocusListener {
	@Override
	public void focusGained(FocusEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		// call text field method for saving text into it's model
		((MyJTextField) e.getSource()).setDataToModel();

	}
}
