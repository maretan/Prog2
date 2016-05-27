package nl.hz.ict.kals0001.jxplorer;
import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeNode;


public class JXTreeView extends JPanel implements MouseListener{

	private static final long serialVersionUID = 1L;
	private JTree fileTree;
	private JXplorer data;
	private JScrollPane scrollPane;
	private JXTreeRenderer renderer;
	
	public JXTreeView(){
		
	}
	
	public JXplorer getData()
	{
		return data;
	}
	
	public void setData(JXplorer data)
	{
		this.data = data;
	}
	
	public void createTree() {
		JXploreFile root = new JXploreFile();
		fileTree = new JTree(root);
		scrollPane = new JScrollPane(fileTree);
		renderer = new JXTreeRenderer();
		this.add(scrollPane);
		fileTree.setCellRenderer(renderer);
		fileTree.addMouseListener(this);
	}

	//Mouselistenerevents
	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getClickCount() == 2)	
		{
			//data.setCurrentFile(fileList.getSelectedValue());
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
	
	 public class JXTreeRenderer extends DefaultTreeCellRenderer {

		  private static final long serialVersionUID = 1L;
		  
		  @Override
			public Component getTreeCellRendererComponent(JTree tree, Object value,boolean selected, 
					boolean expanded, boolean leaf, int row,boolean hasFocus) {
				TreeNode entry = (TreeNode) value;
				JXploreFile file = (JXploreFile) entry;
				
			    this.setIcon(file.getIcon());
				this.setText(file.getName());
				 
				return this;
			}

		 }


	
}
