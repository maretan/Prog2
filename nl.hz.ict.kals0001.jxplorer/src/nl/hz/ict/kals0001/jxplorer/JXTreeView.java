package nl.hz.ict.kals0001.jxplorer;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;


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
		//DefaultMutableTreeNode top = new DefaultMutableTreeNode(data);
		//createNodes(top);
		JXploreFile root = new JXploreFile();
		fileTree = new JTree(root);
		scrollPane = new JScrollPane(fileTree);
		renderer = new JXTreeRenderer();
		this.add(scrollPane);
		//fileTree.setCellRenderer(renderer);
		fileTree.addMouseListener(this);
	}
	
//	private void createNodes(DefaultMutableTreeNode top) {
//	    DefaultMutableTreeNode category = null;
//	    DefaultMutableTreeNode book = null;
//	    
//	    category = new DefaultMutableTreeNode("Books for Java Programmers");
//	    top.add(category);
//	    
//	    //original Tutorial
//	    book = new DefaultMutableTreeNode("The Java Tutorial: A Short Course on the Basics");
//	    category.add(book);
//	    
//	    //Tutorial Continued
//	    book = new DefaultMutableTreeNode("The Java Tutorial Continued: The Rest of the JDK");
//	    category.add(book);
//	    
//	    //Swing Tutorial
//	    book = new DefaultMutableTreeNode("The Swing Tutorial: A Guide to Constructing GUIs");
//	    category.add(book);
//
//	    //...add more books for programmers...
//
//	    category = new DefaultMutableTreeNode("Books for Java Implementers");
//	    top.add(category);
//
//	    //VM
//	    book = new DefaultMutableTreeNode("The Java Virtual Machine Specification");
//	    category.add(book);
//
//	    //Language Spec
//	    book = new DefaultMutableTreeNode("The Java Language Specification");
//	    category.add(book);
//	}
	
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

//		  @Override
//		  public Component getListCellRendererComponent(JList<?> list,
//		    Object value, int index, boolean isSelected, boolean cellHasFocus) {
//		   Component result = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
		   
		  // JLabel label = (JLabel) result;
		   
		   //if (value instanceof JXploreFile) {
		   // JXploreFile data = (JXploreFile) value;
		    
		   // label.setText(data.getName());
		   // label.setIcon(data.getIcon());
		  // }
		  // return label;
		 // }

		 }


	
}
