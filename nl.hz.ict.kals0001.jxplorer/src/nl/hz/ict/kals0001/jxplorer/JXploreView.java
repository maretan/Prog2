package nl.hz.ict.kals0001.jxplorer;
import javax.swing.JPanel;

abstract class JXploreView extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private JXplorer data;
	
	public JXploreView() {
		
	}

	protected JXplorer getData()
	{
		return data;
	}
	
	protected void setData(JXplorer data)
	{
		this.data = data;
	}
	
	abstract void update();
}
