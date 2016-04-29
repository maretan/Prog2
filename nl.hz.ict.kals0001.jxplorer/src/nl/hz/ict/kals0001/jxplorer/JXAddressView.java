package nl.hz.ict.kals0001.jxplorer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JXAddressView extends JPanel implements ActionListener
{

	private static final long serialVersionUID = 1L;
	private JLabel addressLabel;
	private JTextField addressTextField;
	private JButton goButton;
	private JXplorer data;
	
	public JXAddressView()
	{
		addressLabel = new JLabel("Adress");
		addressTextField = new JTextField("", 20);
		goButton = new JButton("Go");
		goButton.addActionListener(this);
		
		this.add(addressLabel);
		this.add(addressTextField);
		this.add(goButton);
	}
	
	public JXplorer getData()
	{
		return data;
	}
	
	public void setData(JXplorer data)
	{
		this.data = data;
	}
	
	public void actionPerformed(ActionEvent e) //TODO: exceptions
	{
		String t = addressTextField.getText();
		JXploreFile file = new JXploreFile(t);
		data.setCurrentFile(file);
		data.updateGUI();
	}
}
