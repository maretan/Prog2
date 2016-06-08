package nl.hz.ict.kals0001.jxplorer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class JXAddressView extends JXploreView implements ActionListener
{

	private static final long serialVersionUID = 1L;
	private JLabel addressLabel;
	private JTextField addressTextField;
	private JButton goButton;
	
	public JXAddressView(JXplorer data)
	{
		setData(data);
		addressLabel = new JLabel("Adress");
		addressTextField = new JTextField("", 30);
		goButton = new JButton("Go");
		goButton.addActionListener(this);
		
		this.add(addressLabel);
		this.add(addressTextField);
		this.add(goButton);
	}
	
	//ActionListener
	public void actionPerformed(ActionEvent e)
	{
		String t = addressTextField.getText();
		JXploreFile file = new JXploreFile(t);
		getData().setCurrentFile(file);
	}
	
	//Updating the view
	@Override
	public void update(){
		addressTextField.setText(getData().getCurrentFile().getPath());
	}
}
