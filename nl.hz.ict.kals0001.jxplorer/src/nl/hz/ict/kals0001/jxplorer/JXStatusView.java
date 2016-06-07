package nl.hz.ict.kals0001.jxplorer;
import javax.swing.JLabel;

public class JXStatusView extends JXploreView
{

	private static final long serialVersionUID = 1L;
	private JLabel statusLabel;
	private String text;
	
	public JXStatusView(JXplorer data)
	{
		setData(data);
		statusLabel = new JLabel("");
		this.add(statusLabel);
		createStatus();
	}
	
	public void createStatus()
	{
		text = "Map: "+ getData().getCurrentFile().getName();
		text += ". Number of files: " + getData().getCurrentFile().getChildCount();
		statusLabel.setText(text);
	}
	
	@Override
	public void update(){
		createStatus();
	}
	

}
