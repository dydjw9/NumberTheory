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
        // TODO自动生成的 catch 块  
        e.printStackTrace();  
     }
	return fileChooser.getSelectedFile();
	
	}
}
