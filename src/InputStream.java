import java.io.*;  
import java.math.*;
public class InputStream {

	public static void main(String[] args) {  
	     // TODO自动生成的方法存根  
	     byte[] buffer=new byte[12];   //一次取出的字节数大小,缓冲区大小  
	     int numberRead=0;  
	     FileInputStream input=null;  
	     FileOutputStream out =null;  
	     BigInteger big;
	     File file=FileChooser.FilePicker();
		 String path=file.getPath();
	     
	

	     
	     try {  
	    	// File file=new File(path);
	        input=new FileInputStream(path);  
	    	// input=new FileInputStream(file);
	        path=FileChooser.FilePicker().getPath();
	       out=new FileOutputStream(path); //如果文件不存在会自动创建  
	        // input.re
	        
	     //  int a=input.read(buffer);
	      //  System.out.println(a);
	        System.out.println(buffer[0]);
	        while ((numberRead=input.read(buffer))!=-1) {  //numberRead的目的在于防止最后一次读取的字节小于buffer长度，  
	         System.out.println(numberRead);
	        	out.write(buffer, 0, numberRead);       //否则会自动被填充0  
	   
	        	
	        }  
	        out.flush();
	     } catch (final IOException e) {  
	        // TODO自动生成的 catch 块  
	        e.printStackTrace();  
	     }finally{  
	        try {  
	           input.close();  
	          // out.close();  
	        } catch (IOException e) {  
	           // TODO自动生成的 catch 块  
	           e.printStackTrace();  
	        }  
	         
	     }  
	  }  
	
	
}
