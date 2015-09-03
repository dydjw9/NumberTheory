import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
public class FileChooser {

	public static void main(String[] args) {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.showSaveDialog(null);

		// TODO Auto-generated method stub
		
	}
public static File FilePicker()
	{
	JFileChooser fileChooser = new JFileChooser();
	try{
	fileChooser.showOpenDialog(null);

	}
	catch (Exception e) {  
       
        e.printStackTrace();  
     }
	return fileChooser.getSelectedFile();
	
	}
public static File FileSaver()

	{
	JFileChooser fileChooser = new JFileChooser();
	try{
	fileChooser.showSaveDialog(null);

	}
	catch (Exception e) {  
       
        e.printStackTrace();  
     }
	return fileChooser.getSelectedFile();
	}
}
