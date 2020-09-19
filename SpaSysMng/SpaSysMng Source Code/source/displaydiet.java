import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.*;
import java.io.*;
import java.sql.*;
public class displaydiet extends JFrame implements ActionListener
{
	JLabel lbl=new JLabel(new ImageIcon("../Images/bg.jpg"));
	
	JLabel did=new JLabel("Diet ID");
	JLabel dtype=new JLabel("Diet Type");
	JLabel dalw=new JLabel("Food Allowed");
	JLabel dnalw=new JLabel("Food Not Allowed");
	JLabel dhead=new JLabel("Diet Details");
	JLabel dlist=new JLabel("Food List");
	
	JTextField dtid=new JTextField();
	JTextField dttype=new JTextField();
	JTextArea dtalw=new JTextArea();
	JTextArea dtnalw=new JTextArea();
	JTextArea dtlist=new JTextArea();
	
	JButton dcan=new JButton("Back",new ImageIcon("../Images/btcan.png"));

	Dimension di=Toolkit.getDefaultToolkit().getScreenSize();	

	///Fonts....
	Font btfnt=new Font("Consolas",Font.BOLD,15);
	Font lblfnt=new Font("Bookman Old Style",Font.BOLD,15);
	Font txtfnt=new Font("Bookman Old Style",Font.BOLD,12);
	
	JScrollPane srlist=new JScrollPane(dtlist,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	JScrollPane srnalw=new JScrollPane(dtnalw,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	JScrollPane sralw=new JScrollPane(dtalw,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	
	public displaydiet(String sdiet)
	{
		int x,y;
		setUndecorated(true);
		setLayout(null);
		setVisible(true);
		this.getContentPane().setBackground(Color.WHITE);
		setSize(650,500);
		setResizable(false);

		x=((int)di.getWidth()-(int)getWidth())/2;
		y=((int)di.getHeight()-(int)getHeight())/2;
		setLocation(x,y);

		lbl.setBounds(0,0,getWidth(),getHeight());
		
		dhead.setBounds(200,30,160,30);
		dhead.setFont(new Font("Algerian",4,25));
		
		did.setFont(lblfnt);
		did.setBounds(100,130,150,30);
		dtid.setBounds(240,130,100,30);
		dtid.setFont(txtfnt);
		
		dtype.setFont(lblfnt);
		dtype.setBounds(70,180,150,30);
		dttype.setBounds(240,180,140,30);
		dttype.setFont(txtfnt);
		
		dalw.setFont(lblfnt);
		dalw.setBounds(80,230,120,30);
		sralw.setBounds(70,270,150,150);
		dtalw.setFont(txtfnt);
		
		dnalw.setFont(lblfnt);
		dnalw.setBounds(240,230,140,30);
		srnalw.setBounds(230,270,150,150);
		dtnalw.setFont(txtfnt);
		
		dlist.setFont(lblfnt);
		dlist.setBounds(420,230,140,30);
		srlist.setBounds(390,270,150,150);
		dtlist.setFont(txtfnt);
		
		dcan.setFont(btfnt);
		dcan.setBounds(200,440,200,25);

		add(dcan);
		add(dnalw);
		add(srnalw);
		add(dalw);
		add(sralw);
		add(dtype);
		add(dttype);
		add(did);
		add(dtid);
		add(dhead);
		add(dlist);
		add(srlist);

		add(lbl);
		repaint();
		
		dcan.addActionListener(this);
		
		dtid.setEditable(false);
		dttype.setEditable(false);
		dtalw.setEditable(false);
		dtnalw.setEditable(false);
		dtlist.setEditable(false);
		
			String t1="";
			String t2="";
			String t3="";
			int i;			
			String t=sdiet;
			try
			{
				Connection con=DriverManager.getConnection("jdbc:odbc:SpaSystemdsn");
				ResultSet res;
				Statement st=con.createStatement();
				res=st.executeQuery("select * from diettbl where diettype='"+t+"'");
				while(res.next())
				{
					dtid.setText(res.getString(1));
					dttype.setText(res.getString(2));
					t1=res.getString(3);
					t2=res.getString(4);
					t3=res.getString(5);
				}
					for(i=0;i<t1.length();i++)
					{
						if(t1.charAt(i)==',')
						{
							dtalw.setText(dtalw.getText()+"\n");
						}
						else
						{
							dtalw.setText(""+dtalw.getText()+t1.charAt(i));
						}
					}
					for(i=0;i<t2.length();i++)
					{
						if(t2.charAt(i)==',')
						{
							dtnalw.setText(dtnalw.getText()+"\n");
						}
						else
						{
							dtnalw.setText(""+dtnalw.getText()+t2.charAt(i));
						}
					}
					for(i=0;i<t3.length();i++)
					{
						if(t3.charAt(i)==',')
						{
							dtlist.setText(dtlist.getText()+"\n");
						}
						else
						{
							dtlist.setText(""+dtlist.getText()+t3.charAt(i));
						}
					}
			}
			catch(Exception ee)
			{
				System.out.println(ee);
			}
}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==dcan)
		{
			this.dispose();
		}
	}
	public static void main(String argv[])
	{
		displaydiet obj=new displaydiet("");
	}
}
