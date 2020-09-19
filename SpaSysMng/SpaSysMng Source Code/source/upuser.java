import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.*;
import java.sql.*;
public class upuser extends JFrame implements ActionListener
{
	JLabel lbl=new JLabel(new ImageIcon("../Images/upuser.jpg"));
	
	String str="";
	JLabel cname= new JLabel("User Name");
	JLabel coldpswd= new JLabel("Old Password");
	JLabel cpswd= new JLabel("Password");
	JLabel ccpswd= new JLabel("Confirm Password");
	
	JTextField tname=new JTextField();
	JPasswordField toldpswd=new JPasswordField();
	JPasswordField tpswd=new JPasswordField();
	JPasswordField tcpswd=new JPasswordField();
	
	JButton bupdate=new JButton("Update");
	JButton breset=new JButton("Reset");

	Dimension di=Toolkit.getDefaultToolkit().getScreenSize();

	///Fonts......
	Font btfnt=new Font("Calibri",Font.BOLD,18);
	Font lblfnt=new Font("Bookman Old Style",Font.BOLD,15);
	Font txtfnt=new Font("Bookman Old Style",Font.BOLD,15);
		
	public upuser()
	{
		int x,y;
		setLayout(null);
		setVisible(true);
		setSize(800,700);
		setResizable(false);
		getContentPane().setBackground(Color.WHITE);
		
		x=((int)di.getWidth()-(int)getWidth())/2;
		y=((int)di.getHeight()-(int)getHeight())/2;
		setLocation(x,y);

		lbl.setBounds(0,0,getWidth(),getHeight());
		
		//cname.setBounds(120,50,100,30);
		//cname.setFont(lblfnt);
		tname.setBounds(550,155,180,40);
		tname.setFont(txtfnt);
		
		//coldpswd.setBounds(120,110,100,30);
		//coldpswd.setFont(lblfnt);
		toldpswd.setBounds(550,242,180,35);
		toldpswd.setFont(txtfnt);
		
		//cpswd.setBounds(120,170,100,30);
		//cpswd.setFont(lblfnt);
		tpswd.setBounds(550,330,180,35);
		tpswd.setFont(txtfnt);
		
		//ccpswd.setBounds(120,230,120,30);
		//ccpswd.setFont(lblfnt);
		tcpswd.setBounds(550,410,180,35);
		tcpswd.setFont(txtfnt);
		
		bupdate.setBounds(330,530,180,50);
		bupdate.setFont(btfnt);
		breset.setBounds(540,530,180,50);
		breset.setFont(btfnt);
		
	//	add(cname);
		add(tname);
	//	add(cpswd);
		add(tpswd);
		//add(ccpswd);
		add(tcpswd);
		//add(coldpswd);
		add(toldpswd);
		add(bupdate);
		add(breset);
		add(lbl);
		bupdate.addActionListener(this);
		breset.addActionListener(this);
	}
	public void upd(String usr,String psd)
	{
		try
		{
			Connection con=DriverManager.getConnection("jdbc:odbc:SpaSystemdsn");
			Statement st=con.createStatement();
			String str="update logintbl set password='"+psd+"' where username='"+usr+"'";
			st.executeUpdate(str);
			JOptionPane.showMessageDialog(null,"Account Updated!!");
			tname.setText("");
			toldpswd.setText("");
			tpswd.setText("");
			tcpswd.setText("");	
		}
		catch(Exception ee)
		{
			System.out.println(ee);
		}
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==bupdate)
		{
			int flg=0;
			String stname=tname.getText();
			String stpswd=toldpswd.getText();
			try
			{
				Connection con=DriverManager.getConnection("jdbc:odbc:SpaSystemdsn");
				String str="select * from logintbl";
				Statement st=con.createStatement();
				ResultSet res=st.executeQuery(str);
				p:{while(res.next())
				{
					if(stname.equals(res.getString(1))&&stpswd.equals(res.getString(2)))
					{
						if(tpswd.getText().length()==0||tcpswd.getText().length()==0)
						{
							JOptionPane.showMessageDialog(null,"Empty Field!!!");
							break p;
						}
						if(tpswd.getText().equals(tcpswd.getText()))
						{
							flg=1;
							break p;
						}
						else
						{
							JOptionPane.showMessageDialog(null,"Password didn't Matched!!");
							tpswd.setText("");
							tcpswd.setText("");
							break p;
						}
					}
					else
					{
							JOptionPane.showMessageDialog(null,"Invalid Username & Password!!");
							tname.setText("");
							toldpswd.setText("");
							tpswd.setText("");
							tcpswd.setText("");	
							break p;
					}
				}
				}
				if(flg==1)
				{
					upd(stname,tpswd.getText());					
				}
			}
			catch(Exception ee)
			{
				System.out.println(ee);
			}
		}
		if(e.getSource()==breset)
		{
			tname.setText("");
			toldpswd.setText("");
			tpswd.setText("");
			tcpswd.setText("");	
		}
	}
	public static void main(String argv[])throws IOException
	{
		upuser obj=new upuser();
	}
}