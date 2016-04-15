package nl.hz.ict.kals0001.jxplorer;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JXAddressView implements ActionListener
{

	private JPanel viewPanel;
	private JLabel addressLabel;
	private JTextField addressTextField;
	private JButton goButton;
	private JXplorer data;
	
	public JXAddressView()
	{
		viewPanel = new JPanel();
		addressLabel = new JLabel("Adress");
		addressTextField = new JTextField("", 20);
		goButton = new JButton("Go");
		goButton.addActionListener(this);
		
		viewPanel.add(addressLabel);
		viewPanel.add(addressTextField);
		viewPanel.add(goButton);
	}
	
	public JPanel getViewPanel()
	{
		return viewPanel;
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
