import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class prog extends Applet implements KeyListener
{

	TextField t = new TextField();
	Label l = new Label();
	Label enter = new Label("Enter text:");
	
public void init()
	{
		setLayout(new GridLayout(3,1));
		add(enter);
		add(t);
		add(l);
		t.addKeyListener(this);
		setVisible(true);
	}

	boolean palin(String s)
	{  
		for (int i=0, j=s.length()-1; i < j; i++, j--)
			if (s.charAt(i) != s.charAt(j))
				return false;
		return true;

	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		if (e.getKeyChar() =='p')  
		{
			if (palin(t.getText()))
			{
				l.setText("Palindrome");
				showStatus("Palindrome");
			}
			else
			{
				l.setText("Not a palindrome");
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
