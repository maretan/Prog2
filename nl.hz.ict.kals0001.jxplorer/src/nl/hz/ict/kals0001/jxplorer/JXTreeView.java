package nl.hz.ict.kals0001.jxplorer;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;


public class JXTreeView extends JXploreView implements MouseListener{

	private static final long serialVersionUID = 1L;
	private JTree fileTree;
	private JScrollPane scrollPane;
	private JXTreeRenderer renderer;
	
	public JXTreeView(JXplorer data){
		setData(data);
		createTree();
	}
	
	//Setting up the Treeview
	public void createTree() {
		fileTree = new JTree();
		fileTree.setModel(new DefaultTreeModel(getData().getCurrentFile()));
		scrollPane = new JScrollPane(fileTree);
		renderer = new JXTreeRenderer();
		this.setLayout(new BorderLayout());
		this.add(scrollPane);
		fileTree.setCellRenderer(renderer);
		fileTree.addMouseListener(this);
	}
	
	//Updating the view
	@Override
	public void update(){
		//There is no need to update the Treeview
	}

	//Mouselistenerevents
	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getClickCount() == 2)	
		{
			getData().setCurrentFile( (JXploreFile) fileTree.getLastSelectedPathComponent());
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}
	
	//TreeCellRenderer
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
