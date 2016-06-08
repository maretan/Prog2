package nl.hz.ict.kals0001.jxplorer;
import javax.swing.JPanel;

abstract class JXploreView extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private JXplorer data;
	
	public JXploreView() {
		
	}

	//Getters and setters
	protected JXplorer getData()
	{
		return data;
	}
	
	protected void setData(JXplorer data)
	{
		this.data = data;
	}
	
	//Defining method to update the views
	abstract void update();
}
