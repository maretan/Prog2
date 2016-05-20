package nl.hz.ict.kals0001.jxplorer;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JXStatusView extends JPanel
{

	private static final long serialVersionUID = 1L;
	private JLabel statusLabel;
	private JXplorer data;
	private String text;
	
	public JXStatusView()
	{
		statusLabel = new JLabel("");
		this.add(statusLabel);
	}
	
	public void createStatus()
	{
		text = "Map: "+ data.getCurrentFile().getName();
		text += ". Number of files: " + data.getCurrentFile().getChildCount();
		statusLabel.setText(text);
	}
	
	
	public JXplorer getData()
	{
		return data;
	}
	
	public void setData(JXplorer data)
	{
		this.data = data;
	}
}
