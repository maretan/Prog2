package nl.hz.ict.kals0001.jxplorer;
import java.io.File;
import java.util.Enumeration;

import javax.swing.Icon;
import javax.swing.filechooser.FileSystemView;
import javax.swing.tree.TreeNode;

public class JXploreFile implements TreeNode {
	
	private File file;
	private JXploreFile[] foldersCache;
	
	public JXploreFile()
	{
		file = FileSystemView.getFileSystemView().getHomeDirectory();
	}
	
	public JXploreFile(String s)
	{
		file = new File(s);
	}
	
	public JXploreFile(File file)
	{
		this.file = file;
	}
	
	
	//Getters and Setters
	public File getFile() {
		return file;
	}
	
	public JXploreFile[] getCache() {
		return foldersCache;
	}
	
	public String getName()
	{
		return file.getName();
	}
	
	public String getPath()
	{
		return file.getPath();
	}
	
	public Icon getIcon()
	{
		Icon i = FileSystemView.getFileSystemView().getSystemIcon(file);
		return i;
	}
	
	//Get all the files from a Folder
	public JXploreFile[] getSubFiles()
	{
		JXploreFile[] subFiles;
		if(file.listFiles() == null)
		{
			subFiles = new JXploreFile[0];
		}
		else
		{
			File[] files = file.listFiles();
			subFiles = new JXploreFile[files.length];
			int i = 0;
			for(File f : files)
			{
				subFiles[i] = new JXploreFile(f);
				i++;
			}
		}
		return subFiles;
	}
	
	//Get all the folders from a folder
	public JXploreFile[] getSubFolders()
	{
		JXploreFile[] subFolders;
		if(file.listFiles() == null)
		{
			subFolders = new JXploreFile[0];
		}
		else
		{
			File[] files = file.listFiles();
			int n = 0;
			for(File f : files)
			{
				if(f.isDirectory())
				{
					n++;
				}
			}
			subFolders = new JXploreFile[n];
			int i = 0;
			for(File f : files)
			{
				if(f.isDirectory())
				{
					subFolders[i] = new JXploreFile(f);
					i++;
				}
			}
		}
		return subFolders;	
	}
	
	//Initialise the cache
	private void initCache() {
		foldersCache = makeFiles(FileSystemView.getFileSystemView().getFiles(file, false));
	}
	
	private JXploreFile[] makeFiles(File[] input) {
		JXploreFile[] output = new JXploreFile[input.length];
		for (int i = 0; i < input.length; i++) {
			output[i] = new JXploreFile(input[i]);
		}
		return output;
	}

	//Treenode Implementation
	@Override
	public Enumeration<?> children() {
		return new Enumeration<JXploreFile>() {

			int index = 0;

			@Override
			public boolean hasMoreElements() {
				return index < getSubFolders().length;
			}

			@Override
			public JXploreFile nextElement() {
				return getSubFolders()[index++];
			}

		};
	}

	@Override
	public boolean getAllowsChildren() {
			return !this.isFile();
	}

		public boolean isFile() {
			return file.isFile();
	}

	@Override
	public TreeNode getChildAt(int arg0) {
		return getSubFolders()[arg0];
	}

	@Override
	public int getChildCount() {
		if (foldersCache == null){
			initCache();
		}
		return getSubFolders().length;
	}

	@Override
	public int getIndex(TreeNode arg0) {
		JXploreFile[] folders = getSubFolders();
		for (int n = 0; n < folders.length; n++) {
			if (folders[n].equals(arg0)){
				return n;
			}
		}
		return -1;
	}

	@Override
	public TreeNode getParent() {
		if (file.getParentFile() == null)
			return null;
		return new JXploreFile(file.getParentFile());
	}

	@Override
	public boolean isLeaf() {
		if (getSubFiles().length == 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}	
}
