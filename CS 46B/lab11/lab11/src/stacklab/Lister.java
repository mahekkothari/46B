package stacklab;

import java.io.*;
import java.util.Stack;


public class Lister {
	
	private File file;
	private boolean showHidden;
	
	public Lister(File f, boolean showH) {
		file = f;
		showHidden = showH;
	}
	
	public void list() {
		listFilesRecurse(file);
		//listFilesStack(file);
	}
    
	private void listFilesRecurse(File f) { 
		if(f.isDirectory()) { // Checks if the current file object 'f' is a directory
			File[] files = f.listFiles(); // Gets the list of all files and directories in the current directory
			for(File file:files) { // Loops through each file and directory in the list
				listFilesRecurse(file);	// Recursively calls the listFilesRecurse for each file and directory
			}
		}
		else { // "else" if it's not a directory 
			if(showHidden || !f.isHidden()) { // Checks if we should show hidden files or if the file is not hidden
				System.out.println(f.getName()); // Prints the name of the file
			}
		}
			
	}
    
    //fill this in
    private void listFilesStack(File f) {
		Stack<File> stack = new Stack<>();
		stack.push(f);

		while (!stack.isEmpty()) {
			File current = stack.pop();

			if (current.isDirectory()) {
				File[] files = current.listFiles();

				if(files != null) {
					for(int i = files.length - 1; i>=0; i--) {
						stack.push(files[i]);
				}
			}
		} else {
			if (showHidden || !current.isHidden()) {
				System.out.println(current.getName());
			}
		}
    }
}
	
	public static void main(String[] args) {
        //replace with a directory of your own
        String directory = "/Users/agc/eclipse-workspace/homework5";
		File dir = new File(directory);
		Lister l = new Lister(dir,true);
		l.list();
	}

}



