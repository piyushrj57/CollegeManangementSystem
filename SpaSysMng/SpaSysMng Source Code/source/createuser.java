import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.*;
import java.sql.*;
public class createuser extends JFrame implements ActionListener
{
	JLabel lbl=new JLabel(new ImageIcon("../Images/crea.jpg"));
	
	String str="";
	JLabel ctype= new JLabel("User Type");
	JLabel cname= new JLabel("User Name");
	JLabel cpswd= new JLabel("Password");
	JLabel ccpswd= new JLabel("Confirm Password");
	
	JTextField ttype=new JTextField();
	JTextField tname=new JTextField();
	JPasswordField tpswd=new JPasswordField();
	JPasswordField tcpswd=new JPasswordField();
	
	JButton bsubmit=new JButton("CREATE ACCOUNT");
	JButton breset=new JButton("RESET");
	
	
	JRadioButton radmin=new JRadioButton("Admin");
	JRadioButton ruser=new JRadioButton("Employee");
	ButtonGroup bd=new ButtonGroup();

	Dimension di=Toolkit.getDefaultToolkit().getScreenSize();

	///Fonts......
	Font btfnt=new Font("Calibri",Font.BOLD,18);
	Font lblfnt=new Font("Bookman Old Style",Font.BOLD,20);
	Font txtfnt=new Font("Bookman Old Style",Font.BOLD,15);
	
	public createuser()
	{
		int x,y;
		setLayout(null);
		setVisible(true);
		//setSize(800,800);
		setSize(800,700);
		setResizable(false);
		getContentPane().setBackground(Color.WHITE);
		
		x=((int)di.getWidth()-(int)getWidth())/2;
		y=((int)di.getHeight()-(int)getHeight())/2;
		setLocation(x,y);

		lbl.setBounds(0,0,getWidth(),getHeight());
		
		//ctype.setBounds(100,50,100,30);
		//ctype.setFont(lblfnt);
        radmin.setBounds(330,450,100,30);
		radmin.setFont(lblfnt);
		radmin.setOpaque(false);
		ruser.setBounds(480,450,130,30);
		ruser.setFont(lblfnt);
		ruser.setOpaque(false);
		
		//cname.setBounds(120,110,100,30);
		//cname.setFont(lblfnt);
		tname.setBounds(530,155,180,35);
		tname.setFont(txtfnt);
		//cpswd.setBounds(120,170,100,30);
		//cpswd.setFont(lblfnt);
		tpswd.setBounds(530,255,180,35);
		tpswd.setFont(txtfnt);
		
		/*ccpswd.setBounds(120,230,150,30);
		ccpswd.setFont(lblfnt);*/
		tcpswd.setBounds(530,355,180,35);
		tcpswd.setFont(txtfnt);
		
		
		bsubmit.setBounds(270,549,200,50);
		bsubmit.setFont(btfnt);
		breset.setBounds(500,549,200,50);
		breset.setFont(btfnt);
		
	
		
		add(bsubmit);
		add(breset);
		
	
			add(tname);
			add(tpswd);
			add(tcpswd);
			bd.add(radmin);
			bd.add(ruser);
				add(radmin);
		add(ruser);
		add(lbl);
		repaint();
		bsubmit.addActionListener(this);
		breset.addActionListener(this);
	}
	public int check(String usr)
	{
		int flg=1;
		try
		{
			Connection con=DriverManager.getConnection("jdbc:odbc:SpaSystemdsn");
			Statement st=con.createStatement();
			ResultSet res=st.executeQuery("select * from logintbl where username='"+usr+"'");
			while(res.next())
			{
				flg=0;
			}
			if(flg==0)
			{
				JOptionPane.showMessageDialog(null,"Username already Exists!!");
			}
		}
		catch(Exception ee)
		{
			System.out.println(ee);
		}
		return flg;
	}
	public void actionPerformed(ActionEvent e)
	{
		int flg=0,tflg=0;
		String pswrd="";
		String cpswrd="";
		if(e.getSource()==bsubmit)
		{
			try
			{
				Connection con=DriverManager.getConnection("jdbc:odbc:SpaSystemdsn");
				str="insert into logintbl(username,password,usertype) values(?,?,?)";
				PreparedStatement ps=con.prepareStatement(str);
				if(tname.getText().length()==0||tcpswd.getText().length()==0||tpswd.getText().length()==0||bd.getSelection()==null)
				{
					flg=1;
					JOptionPane.showMessageDialog(null,"Empty Fields");
				}
				else
				{
					pswrd=tpswd.getText();
					cpswrd=tcpswd.getText();
					if(pswrd.equals(cpswrd))
					{
						tflg=1;
					}
				}
				if(tflg==0)
				{
					JOptionPane.showMessageDialog(null,"Password is not match");
				}				
				if(flg==0&&tflg==1&&check(tname.getText())==1)
				{
					if(radmin.isSelected()==true)
					{
						str="Admin";
					}
					else
					{
						str="Employee";
					}
					ps.setString(1,tname.getText());
					ps.setString(2,tcpswd.getText());
					ps.setString(3,str);
					ps.executeUpdate();
					JOptionPane.showMessageDialog(null,"Saved..");
					tname.setText("");
					tcpswd.setText("");
					tpswd.setText("");
					bd.clearSelection();
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
				tcpswd.setText("");
				tpswd.setText("");
				bd.clearSelection();
			}
		}
	public static void main(String argv[])throws IOException
	{
		createuser obj=new createuser();
		
	}
}