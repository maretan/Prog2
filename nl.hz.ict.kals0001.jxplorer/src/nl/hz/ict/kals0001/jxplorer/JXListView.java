package nl.hz.ict.kals0001.jxplorer;
import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.DefaultListCellRenderer;
import java.awt.Component;


public class JXListView {

	private JPanel viewPanel;
	private JList<JXploreFile> fileList;
	private JXplorer data;
	private JScrollPane scrollPane;
	private JXListCellRenderer renderer;
	
	public JXListView(){
		viewPanel = new JPanel();
		fileList = new JList<JXploreFile>();
		scrollPane = new JScrollPane(fileList);
		renderer = new JXListCellRenderer();
		viewPanel.add(scrollPane);
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
	
	public void createList() {
		fileList.setListData(data.getCurrentFile().getSubFiles());
		fileList.setCellRenderer(renderer);
	}
	
	
	 public class JXListCellRenderer extends DefaultListCellRenderer {

		  private static final long serialVersionUID = 1L;

		  @Override
		  public Component getListCellRendererComponent(JList<?> list,
		    Object value, int index, boolean isSelected, boolean cellHasFocus) {
		   Component result = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
		   
		   JLabel label = (JLabel) result;
		   
		   if (value instanceof JXploreFile) {
		    JXploreFile data = (JXploreFile) value;
		    
		    label.setText(data.getName());
		    label.setIcon(data.getIcon());
		   }
		   return result;
		  }

		 }
}
