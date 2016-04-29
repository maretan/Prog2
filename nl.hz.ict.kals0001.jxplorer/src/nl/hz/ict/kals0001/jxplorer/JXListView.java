package nl.hz.ict.kals0001.jxplorer;
import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.DefaultListCellRenderer;
import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class JXListView  implements MouseListener{

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
		fileList.addMouseListener(this);
	}
	
	//Mouselistenerevents
	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getClickCount() == 2)	
		{
			data.setCurrentFile(fileList.getSelectedValue());
			data.updateGUI();
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
		   return label;
		  }

		 }


	
}
