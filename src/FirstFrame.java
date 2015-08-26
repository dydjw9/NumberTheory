import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FirstFrame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable()
				{
			public void run()
			{
				SimpleFrame frame=new SimpleFrame();
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				frame.setVisible(true);				//to set the frame can be seen
				frame.setResizable(true);			//to set the frame can be resized
				frame.setTitle("Monitor 1.0");
				
				frame.addWindowListener(new WindowAdapter()
						{
					public void windowClosing(WindowEvent e)
					{
						//if (user agrees)
							System.exit(0);
					}
						});
				//frame.setBackground(Color.pink);
				
			}
				});
	}

}
class SimpleFrame extends JFrame
	{
	private static final int DEFAULT_WIDTH=1000;
	private static final int DEFAULT_HEIGHT=700;
	private double frameratio=0.6;
	public int screenWidth;
	public int screenHeight;
	private JPanel buttonPanel;
	public SimpleFrame()
	{
		GetScreenSize();
		buttonPanel=new JPanel();
		UIManager.LookAndFeelInfo[] infos=UIManager.getInstalledLookAndFeels(); //to get the UI themes
		
		for(UIManager.LookAndFeelInfo info:infos)
			makeButton(info.getName(),info.getClassName());
		
		//setSize((int)Math.round(screenWidth*frameratio),(int)Math.round(screenHeight*frameratio));
		//add(new FirstComponent());
		add(buttonPanel);
		//pack();
		setSize((int)Math.round(screenWidth*frameratio),(int)Math.round(screenHeight*frameratio));
	}
	
	public void GetScreenSize()
	{
		Toolkit kit=Toolkit.getDefaultToolkit();
		Dimension screensize=kit.getScreenSize();
		screenWidth=screensize.width;
		screenHeight=screensize.height;
	}
	public void setRatio(double ratio)
	{
		frameratio=ratio;
	}
	public double getRatio()
	{
		return frameratio;
	}
	void makeButton(String name, final String plafName)
	{
		System.out.println(name);
		System.out.println(plafName);
		JButton button=new JButton(name);
		buttonPanel.add(button);
		button.addActionListener(new ActionListener()
				{public void actionPerformed(ActionEvent event)
				{
			try 
			{
				UIManager.setLookAndFeel(plafName);
				
				
				SwingUtilities.updateComponentTreeUI(SimpleFrame.this);
				setSize((int)Math.round(screenWidth*frameratio),(int)Math.round(screenHeight*frameratio));
				//setSize(1000,800);
				//pack();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
				}}
		);
	}
	}

class FirstComponent extends JComponent
{
	private int message_X=100;
	private int message_Y=100;
	private int width=1000;
	private int height=800;
	
	public void paintComponent(Graphics g)
	{
		g.drawString("try it", message_X, message_Y);
		
	}
	public Dimension getPreferredSize(){return new Dimension(width,height);}
	
	
}

