import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.io.*;
import javax.swing.*;
public class splash extends JFrame
{
	int cflg;	
	Dimension di=Toolkit.getDefaultToolkit().getScreenSize();	
	
	JLabel lbl[]=new JLabel[15];
	public splash(int flg)
	{
		setLayout(null);
		setVisible(true);
		Dimension di=Toolkit.getDefaultToolkit().getScreenSize();
		setSize((int)di.getWidth(),(int)di.getHeight());
		setResizable(false);
		getContentPane().setBackground(Color.WHITE);
		
		cflg=flg;
		int l=100;
		try
		{
		for(JLabel label:lbl)
		{
			label=new JLabel();
			label.setBackground(Color.BLUE);
			add(label);
			label.setBounds(l,350,20,20);
			l=l+30;
			Thread.sleep(600);
		}
		open();
		}
		catch(Exception ee)
		{
			System.out.println(ee);
		}
	}
	public void open()
	{
		if(cflg==1)
		{
			menu1 obj=new menu1();
		}
		else
		{
			menu obj=new menu();
		}
		this.dispose();
	}
	public static void main(String argv[])
	throws IOException
	{
		splash obj=new splash(1);
	}
}
