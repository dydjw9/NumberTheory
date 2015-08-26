import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GuiFrame extends JFrame
{
	private StringBuilder content;
	private GuiPanel guipanel;
	public void setContent(StringBuilder a)
	{
		guipanel.textarea.setText(a.toString());
		
	}
	public void updatedisplay()
	{
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable()
				{
			public void run()
			{
				GuiFrame a=new GuiFrame("really");
				//new Thread(new simulation()).start();
				
			}});
	}
	public GuiFrame(String title)
	{
		
		this.setTitle(title);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(true);
		UIManager.LookAndFeelInfo[] infos=UIManager.getInstalledLookAndFeels();
		try {
		UIManager.setLookAndFeel(infos[3].getClassName());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		guipanel=new GuiPanel();
		add(guipanel);
		pack();
		this.setVisible(true);
	}
	class GuiPanel extends JPanel
	{
		private simulation simul;
		private JTextArea textarea;
		public GuiPanel()
		{
			setLayout(new BorderLayout());
		
			JPanel ButtonPanel=new JPanel();
			ButtonPanel.setLayout(new GridLayout(3,1));
			JButton RunButton=new JButton("Run");
			RunButton.addActionListener(new ActionListener()
					{public void actionPerformed(ActionEvent event)
				{
					//	new Thread(simul).startrun(GuiFrame.this,textarea);
						//simul.startrun(GuiFrame.this,textarea);
						//simul=new simulation(textarea);
						//simul.setRun(true);
						new Thread(simul).start();
						simul.setRun(true);
						
				}
				
					});
			ButtonPanel.add(RunButton);
			JButton StopButton=new JButton("Stop");
		StopButton.addActionListener(new ActionListener()
					{public void actionPerformed(ActionEvent event)
				{
						simul.setRun(false);
						
				}
				
					});
			ButtonPanel.add(StopButton);
			JButton HelpButton=new JButton("Help");
			HelpButton.addActionListener(new ActionListener()
					{public void actionPerformed(ActionEvent event)
				{
					
				}
				
					});
			ButtonPanel.add(HelpButton);
			add(ButtonPanel,BorderLayout.EAST);
			
			JPanel textPanel =new JPanel();
			textarea =new JTextArea(18,60);
			//textarea.setAutoscrolls(true);
			textarea.setLineWrap(true);
			textarea.setEditable(false);
			
			JScrollPane scrollpane=new JScrollPane(textarea);
			textPanel.add(textarea);
			textPanel.add(scrollpane);
			add(textPanel,BorderLayout.CENTER);
			simul=new simulation(textarea);
			
			
			
		}
		
	}
}
