package lab04;

/**
 * This program searches a folder for a file by name
 * 
 * @author Nolan Taylor
 * @version 9/21/2021
 */

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class FileLocator
{
	
	/**
	 * This function prompts the user for a file name
	 * and returns the user's input
	 * 
	 * @return String name of file
	 */
	public static String getTargetName()
	{
		String input = JOptionPane.showInputDialog("Enter a search term:");
		
		if (input == null) { throw new IllegalArgumentException(); }
		if (input.length() == 0)
		{
			System.out.println("The search term cannot be empty.");
			throw new IllegalArgumentException();
		}
		
		return input;
	}
	
	/**
	 * This function prompts the user for a folder
	 * and returns the user selected folder
	 * 
	 * @return File starting folder
	 */
	public static File getStartingFolder()
	{
		JFileChooser chooser = new JFileChooser("C:/JavaJazz/cs_1420_fall_2021");
		chooser.setDialogTitle("Select a folder to search:);");
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		
		int result;
		result = chooser.showOpenDialog(null);
		        
		if (result == JFileChooser.CANCEL_OPTION)
		{
		    System.out.println("The file chooser was cancelled.");
		    throw new IllegalArgumentException();
		}
		
		File folder = chooser.getSelectedFile();
		
		return folder;
	}
	
	/**
	 * This function searches a folder for any files of a given
	 * name, it also searches any subfolders any layer deep for
	 * that file name. It returns the filename if it is found
	 * 
	 * @param folder
	 * @param target
	 */
	public static void searchFolder(File folder, String target)
	{
		System.out.println("Searching: " + folder + " for filenames containing '" + target + "'.");
		
		File[] files;
		files = folder.listFiles();
		
		if (files != null)
		{
		    for (File file : files)
			{
			    String filename = file.getName();
			    if (filename.contains(target))
			        System.out.println("Found: " + filename);
			    
			    if (file.isDirectory())
			        searchFolder(file, target);
			}
		}
	}

	public static void main(String[] args)
	{
		try
		{
			File startingFolder;
			
			// asking the user for a name and folder
			System.out.println("File locator tool has started.");
			String target = getTargetName();
			System.out.println("You selected this as the search target: " + target);
			
			startingFolder = getStartingFolder();
			System.out.println("Your search will start in: " + startingFolder);
			
			searchFolder(startingFolder, target);
		}
		catch (IllegalArgumentException e)
		{
			System.out.println("The search has been cancelled.");
		}
	}

}
