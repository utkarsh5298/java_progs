import java.applet.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class prog extends Applet implements KeyListener {

	TextField t = new TextField();
	Label enter = new Label("Enter text:");
	
	public void init() {
		setLayout(new GridLayout(3,1));
		add(enter);
		add(t);
		t.addKeyListener(this);
		setVisible(true);
	}

	boolean palin(String s) {  
		for (int i=0, j=s.length()-1; i < j; i++, j--)
			if (s.charAt(i) != s.charAt(j))
				return false;
		return true;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyChar() =='p') {
			if (palin(t.getText())) {
				showStatus("Palindrome");
			}
			else {
				showStatus("Not a palindrome");
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

}
