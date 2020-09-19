import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.*;
import java.io.*;
import java.sql.*;
import java.awt.image.*;
import javax.imageio.*;
public class login extends JFrame implements ActionListener
{
	//Global Variables.....
	int c;
	
	//Objects Used......
	JTextField tuser=new JTextField();
	JPasswordField tpswrd=new JPasswordField();

	JButton sub=new JButton(new ImageIcon("../Images/loginbt.png"));
	JButton cancel=new JButton(new ImageIcon("../Images/cancelbt.png"));

	Dimension di=Toolkit.getDefaultToolkit().getScreenSize();	
	
	JLabel lbl=new JLabel(new ImageIcon("../Images/login.jpg"));
	JPanel pnl=new JPanel();
	
	public login()
	{
		setUndecorated(true);
		c=0;		
		setLayout(null);
		setVisible(true);
		setSize(514,605);
		getContentPane().setBackground(Color.WHITE);
		int x=(int)(di.getWidth()-this.getWidth())/2;
		int y=(int)(di.getHeight()-this.getHeight())/2;
		this.setLocation(x,y);
		setResizable(false);
		
		tpswrd.setEchoChar('*');
		getContentPane().add(pnl);
		pnl.add(lbl);
		add(tpswrd);
		add(tuser);
		add(sub);
		add(cancel);
		pnl.setBackground(Color.WHITE);
		pnl.setBounds(-13,-9,540,620);
		
		lbl.setBounds(0,0,540,620);
		
		tuser.setBounds(294,245,190,35);
		
		tpswrd.setBounds(294,299,190,35);
	
		sub.setBounds(317,358,104,27);
		cancel.setBounds(480,2,27,27);
		
		sub.addActionListener(this);
		cancel.addActionListener(this);
	}
	public void splash(int flg)
	{	
		this.dispose();
		if(flg==1)
		{
			menu1 obj=new menu1();
		}
		else
		{
			menu obj=new menu();
		}
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==cancel)
		{
			System.exit(0);
		}
		if(e.getSource()==sub)
		{
			int ctr=0;
			int flg;
			try
			{
				String type="";
				
				Connection con=DriverManager.getConnection("jdbc:odbc:SpaSystemdsn");
				ResultSet res;
				Statement st=con.createStatement();
				String str="select * from logintbl where username='"+tuser.getText()+"' and password='"+tpswrd.getText()+"'";
				res=st.executeQuery(str);
				p:{while(res.next())
				{
					ctr++;
					type=res.getString(3);
				}
					if(ctr==1)
					{
						if(type.equals("Admin"))
						{
							flg=1;
						}
						else
						{
							flg=0;
						}
						splash(flg);
						break p;
					}				
				else
				{
					JOptionPane.showMessageDialog(null,"Wrong UserName or Password");
					c++;
				}
				if(c>=3)
				{
					JOptionPane.showMessageDialog(null,"Login limit exceeds!!");
					System.exit(0);
				}}
				
			}
			catch(Exception ee)
			{
				System.out.println(ee);
			}
		}
	}
	public static void main(String argv[])
	{
		login obj=new login();
	}
}
