package nl.hz.ict.kals0001.jxplorer;
import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;


public class JXListView extends JXploreView implements MouseListener{

	private static final long serialVersionUID = 1L;
	private JList<JXploreFile> fileList;
	private JScrollPane scrollPane;
	private JXListCellRenderer renderer;
	
	public JXListView(JXplorer data){
		setData(data);
		fileList = new JList<JXploreFile>();
		scrollPane = new JScrollPane(fileList);
		renderer = new JXListCellRenderer();
		this.add(scrollPane);
		createList();
	}
	
	public void createList() {
		fileList.setListData(getData().getCurrentFile().getSubFiles());
		fileList.setCellRenderer(renderer);
		fileList.addMouseListener(this);
	}
	
	@Override
	public void update(){
		createList();
	}
	
	//Mouselistenerevents
	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getClickCount() == 2)	
		{
			getData().setCurrentFile(fileList.getSelectedValue());
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
