package nl.hz.ict.kals0001.jxplorer;
import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;


public class JXplorer {
	
	private JXploreFile currentFile;
	private JFrame mainFrame;
	private JPanel contentPanel;
	private JSplitPane splitPane;
	
	public JXplorer()
	{
		currentFile = new JXploreFile();
	}
	
	public JXplorer(JXploreFile file)
	{
		currentFile = file;
	}
	
	public static void main(String[] args)
	{
		JXplorer jxplorer = new JXplorer();
		jxplorer.buildGUI();
	}	

	public JXploreFile getCurrentFile()
	{
		return currentFile;
	}
		
	public void setCurrentFile(JXploreFile newFile) 
	{
		currentFile = newFile;
	}
	
	public void buildGUI()
	{
		mainFrame = new JFrame();
		//mainFrame.setIconImage();
		updateGUI();
	}
	
	public void updateGUI()
	{
		contentPanel = new JPanel();
		contentPanel.setLayout(new BorderLayout());
		
		//Getting the AdressViewGui + Data
		JXAddressView adress = new JXAddressView();
		adress.setData(this);
		
		//Getting the ListViewGui + Data
		JXListView list = new JXListView();
		list.setData(this);
		list.createList();
		
		//Getting the TreeviewGui + Data
		JXTreeView tree = new JXTreeView();
		tree.setData(this);
		tree.createTree();
		//todo add methods to create tree.
		
		//Getting the StatusViewGUI + Data
		JXStatusView status = new JXStatusView();
		status.setData(this);
		status.createStatus();
				
		//Adding the Panels in the BorderLayout
		contentPanel.add(adress, BorderLayout.NORTH);
		contentPanel.add(status, BorderLayout.SOUTH);
		splitPane = new JSplitPane(1, tree, list);
		contentPanel.add(splitPane, BorderLayout.CENTER);
		
		//Finishing the GUI
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setContentPane(contentPanel);
		mainFrame.pack();
		mainFrame.setVisible(true);
	}
	
	public void printName(JXploreFile file)
	{
		System.out.println(currentFile.getName());
	}
	
	public void printSubFiles(JXploreFile file)
	{
		JXploreFile[] subFiles = currentFile.getSubFiles();
		if (subFiles.length == 0)
		{
			System.out.println("this file is not a directory or doesnt contain any files");
		}
		else
		{
			String files = "the files in this directory are: ";
			for(JXploreFile f : subFiles)
			{
				files += f.getName()+ "\n";
			}
			System.out.println(files);
		}
	}
	
	public void printSubFolders(JXploreFile file)
	{
		JXploreFile[] subFolders = currentFile.getSubFolders();
		if (subFolders.length == 0)
		{
			System.out.println("this file is not a directory or doesnt contain any folders");
		}
		else
		{
			String folders = "the folders in this directory are: ";
			for(JXploreFile f : subFolders)
			{
				folders += f.getName()+ "\n";
			}
			System.out.println(folders);
		}
	}
}
