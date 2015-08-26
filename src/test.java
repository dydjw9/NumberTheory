import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.*;
import java.util.Calendar;
import java.util.Date;

public class test
{
	public static void main(String[] args)
	{
		//Boolean.toString(run)
		JFrame f=new JFrame("test");
		f.setVisible(true);
		JLabel L=new JLabel("fsdfs");
		//f.setLayout(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		new Thread(new Time(L)).start();
		L.setBounds(300,300,100,30);
		JTextArea area=new JTextArea("dsada");
		JPanel panel =new JPanel();
		panel.add(area);
		//f.add(panel);
		f.add(L);
		//f.add(area);
		f.setSize(300, 300);
		//f.validate();
		//f.pack();
		//new Thread(new Time(L)).start();
	}
}
class Time implements Runnable
{
	JLabel L;
	public Time(JLabel L)
	{
		this.L=L;
	}
	
	public void run()
	{
		while(true)
		{
			Calendar C=Calendar.getInstance();
			C.setTime(new Date());
			int h=C.get(Calendar.HOUR);
			int m=C.get(Calendar.MINUTE);
			int s=C.get(Calendar.SECOND);
			L.setText(""+h+"/"+m+"/"+s);
			try
			{
				Thread.sleep(1000);
			}
			catch(Exception e)
			{}			
		}
	}
}