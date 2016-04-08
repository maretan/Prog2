package nl.hz.ict.kals0001.jxplorer;
import java.io.File;

import javax.swing.Icon;
import javax.swing.filechooser.FileSystemView;

public class JXploreFile {
	
	private File file;
	
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
}
