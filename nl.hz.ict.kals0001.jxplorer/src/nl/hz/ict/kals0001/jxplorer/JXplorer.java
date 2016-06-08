package nl.hz.ict.kals0001.jxplorer;
import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;


public class JXplorer {
	
	private JXploreFile currentFile;
	private JFrame mainFrame;
	private JPanel contentPanel;
	private JSplitPane splitPane;
	private ArrayList<JXploreView> views = new ArrayList<JXploreView>();
	
	public JXplorer()
	{
		currentFile = new JXploreFile();
	}
	
	public JXplorer(JXploreFile file)
	{
		currentFile = file;
	}
	
	//Starting te application
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
		if (newFile != null && newFile!= currentFile){
			currentFile = newFile;
			updateGUI();
		}
	}
	
	//Initialising the GUI
	public void buildGUI()
	{
		mainFrame = new JFrame("JXplorer, find your files");
		ImageIcon img = new ImageIcon("C:/Users/Willemijn/Dropbox/persoonlijk/Programmeren 2/Nieuwe map/nl.hz.ict.kals0001.jxplorer/src/nl/hz/ict/kals0001/jxplorer/search.jpg");
		mainFrame.setIconImage(img.getImage());
		
		contentPanel = new JPanel();
		contentPanel.setLayout(new BorderLayout());
		
		//Creating the views
		views.add(new JXAddressView(this));
		views.add(new JXTreeView(this));
		views.add(new JXListView(this));
		views.add(new JXStatusView(this));
		
		updateGUI();
		
		//Adding the Panels in the BorderLayout
		contentPanel.add(views.get(0), BorderLayout.NORTH);
		contentPanel.add(views.get(3), BorderLayout.SOUTH);
		splitPane = new JSplitPane(1, views.get(1), views.get(2));
		contentPanel.add(splitPane, BorderLayout.CENTER);
		
		//Finishing the GUI
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setContentPane(contentPanel);
		mainFrame.pack();
		mainFrame.setVisible(true);
	}
	
	//Updating the GUI
	private void updateGUI()
	{
		for  (JXploreView view:views){
			view.update();			
		}	
	}
	
	//Getting all the files in a folder
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
	
	//Getting all the folders in a folder
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
