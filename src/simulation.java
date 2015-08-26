import javax.swing.*;


public class simulation implements Runnable {
	public boolean runkey=true;
	private StringBuilder b=new StringBuilder();
	private JTextArea textarea;
	public simulation(JTextArea a )
	{
		this.textarea=a;
	}
	public void setRun(boolean a)
	{
		runkey=a;
	}
	private int i=0;
	public void run()
	{
		//int i=0;
		
		do
		{
			//runkey=false;
			b.append("this is");
			b.append(Integer.toString(i));
			b.append(Boolean.toString(runkey));
			b.append("\n");
			i++;
			//a.setContent(b);
			textarea.setText(b.toString());
			//a.updatedisplay();
			try{
			Thread.sleep(1000);
			//a.updatedisplay();
			//textarea.setText(b.toString());
			}
			catch (InterruptedException e) {
				e.printStackTrace();
				}
		}while(runkey);
		
	}
	

}
