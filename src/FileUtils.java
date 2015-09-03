import java.io.*;
import java.math.*;

public class FileUtils {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RsaEncryption Rsa=new RsaEncryption(1024);
		FileInputStream input=null;
		FileOutputStream out=null,dec=null;
		File Source=FileChooser.FilePicker();
		File Encry=FileChooser.FilePicker();
		File Decry=FileChooser.FilePicker();
		  byte[] buffer=new byte[128]; 
		  byte[] outbuffer;
		  
		  
		  try {  
		    	int numberRead;
		    	BigInteger a=null;
		        input=new FileInputStream(Source);  
		    	
		       
		       out=new FileOutputStream(Encry); //如果文件不存在会自动创建  
		       dec=new FileOutputStream(Decry);
		        while ((numberRead=input.read(buffer))!=-1) {  //numberRead的目的在于防止最后一次读取的字节小于buffer长度，  
		         a=new BigInteger(buffer);
		         System.out.println("a is "+a);
		         a=Rsa.Encryption(a);
		         outbuffer=a.toByteArray();
		         System.out.println("out length is "+outbuffer.length);
		        	out.write(outbuffer, 0, numberRead);       //否则会自动被填充0  
		        	  a=Rsa.Decryption(a);
				        System.out.println("a is "+a);
				        outbuffer=a.toByteArray();
				        System.out.println("out length is "+outbuffer.length);
				        dec.write(outbuffer, 0, numberRead); 

		        }  
		      
		        out.flush();
		        dec.flush();
		     } catch (final IOException e) {  
		        // TODO自动生成的 catch 块  
		        e.printStackTrace();  
		     }finally{  
		        try {  
		           input.close();  
		          out.close();  
		          dec.close();
		        } catch (IOException e) {  
		           // TODO自动生成的 catch 块  
		           e.printStackTrace();  
		        }  
		         
		     }  
	}

}
