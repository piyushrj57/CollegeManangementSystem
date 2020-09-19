import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.*;
import java.io.*;
import java.sql.*;
public class diet extends JFrame implements ActionListener,FocusListener
{
	JLabel lbl=new JLabel(new ImageIcon("../Images/mas.jpg"));
	
	int sflg=0;
	JLabel did=new JLabel("Diet ID");
	JLabel dtype=new JLabel("Diet Type");
	JLabel dalw=new JLabel("Food Allowed");
	JLabel dnalw=new JLabel("Food Not Allowed");
	JLabel dhead=new JLabel("Diet Form");
	JLabel dlist=new JLabel("Food List");
	
	JTextField dtid=new JTextField();
	JTextField dttype=new JTextField();
	JTextArea dtalw=new JTextArea();
	JTextArea dtnalw=new JTextArea();
	JTextArea dtlist=new JTextArea();
	
	JButton dnew=new JButton("New",new ImageIcon("../Images/mnbt.jpg"));
	JButton dsave=new JButton("Save",new ImageIcon("../Images/msbt.jpg"));
	JButton dedit=new JButton("Edit",new ImageIcon("../Images/mebt.jpg"));
	JButton dsearch=new JButton("Search",new ImageIcon("../Images/mssbt.jpg"));
	JButton dcan=new JButton("Cancel",new ImageIcon("../Images/mcbt.jpg"));

	Dimension di=Toolkit.getDefaultToolkit().getScreenSize();	

	JTextField txline=new JTextField();
	///Fonts....
	Font btfnt=new Font("Consolas",Font.BOLD,15);
	Font lblfnt=new Font("Bookman Old Style",Font.BOLD,15);
	Font txtfnt=new Font("Bookman Old Style",Font.BOLD,12);
	
	JScrollPane srlist=new JScrollPane(dtlist,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	JScrollPane srnalw=new JScrollPane(dtnalw,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	JScrollPane sralw=new JScrollPane(dtalw,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	
	public diet()
	{
		setLayout(null);
		setVisible(true);
		this.getContentPane().setBackground(Color.WHITE);
		setSize((int)di.getWidth(),(int)di.getHeight());
		setResizable(false);

		lbl.setBounds(0,0,getWidth(),getHeight());
		
		dhead.setBounds(500,30,200,30);
		dhead.setFont(new Font("castellar",1,25));
		dhead.setForeground(new Color(163,73,164));
		
		did.setFont(lblfnt);
		did.setBounds(170,130,150,30);
		dtid.setBounds(340,130,100,30);
		dtid.setFont(txtfnt);
		
		dtype.setFont(lblfnt);
		dtype.setBounds(170,180,150,30);
		dttype.setBounds(340,180,140,30);
		dttype.setFont(txtfnt);
		
		dalw.setFont(lblfnt);
		dalw.setBounds(180,230,120,30);
		sralw.setBounds(170,270,150,150);
		dtalw.setFont(txtfnt);
		
		dnalw.setFont(lblfnt);
		dnalw.setBounds(340,230,140,30);
		srnalw.setBounds(330,270,150,150);
		dtnalw.setFont(txtfnt);
		
		dlist.setFont(lblfnt);
		dlist.setBounds(520,230,140,30);
		srlist.setBounds(490,270,150,150);
		dtlist.setFont(txtfnt);
		
		dnew.setFont(btfnt);
		dnew.setBounds(120,500,120,30);
		dsave.setFont(btfnt);
		dsave.setBounds(250,500,120,30);
		dsearch.setFont(btfnt);
		dsearch.setBounds(380,500,120,30);
		dedit.setFont(btfnt);
		dedit.setBounds(510,500,120,30);
		dcan.setFont(btfnt);
		dcan.setBounds(640,500,120,30);

		
		add(dcan);
		add(dedit);
		add(dsave);
		add(dsearch);
		add(dnew);
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
		
		dnew.addActionListener(this);
		dsave.addActionListener(this);
		dsearch.addActionListener(this);
		dedit.addActionListener(this);
		dcan.addActionListener(this);
		
		dtid.setEditable(false);
		dsave.setEnabled(false);
		dedit.setEnabled(false);
		//Validation....
		
	}
	public void focusLost(FocusEvent fe)
	{
		
	}
	public void focusGained(FocusEvent fe)
	{
		
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==dnew)
		{
			dsave.setEnabled(true);
			dedit.setEnabled(false);
			int ctr=0;
			try
			{
				Connection con=DriverManager.getConnection("jdbc:odbc:SpaSystemdsn");
				Statement st=con.createStatement();
				ResultSet res=st.executeQuery("select * from keytbl");
				while(res.next())
				{
					ctr=Integer.parseInt(res.getString(5));	
				}
				if(ctr<10)
				{
					dtid.setText("D00"+ctr);
				}
				if(ctr>9&&ctr<100)
					dtid.setText("D0"+ctr);
				dtalw.setText("");
				dtnalw.setText("");
				dttype.setText("");
				dtlist.setText("");
				
			}
			catch(Exception ee)
			{
				System.out.println(ee);
			}
		}
		if(e.getSource()==dsave)
		{
			dedit.setEnabled(false);
			int flg=0;
			try
			{
				Connection con=DriverManager.getConnection("jdbc:odbc:SpaSystemdsn");
				if(dtid.getText().length()==0||dttype.getText().length()==0||dtalw.getText().length()==0||dtnalw.getText().length()==0||dtlist.getText().length()==0)
				{
					flg=1;
					JOptionPane.showMessageDialog(null,"Empty Fields");
				}
				if(flg==0)
				{
					String str1="update keytbl set dietid=dietid+1";
					Statement st=con.createStatement();
					st.executeUpdate(str1);
					String str="insert into diettbl(dietid,diettype,foodallowed,foodnotallowed,foodlist)values(?,?,?,?,?)";				
					PreparedStatement ps=con.prepareStatement(str);
					ps.setString(1,dtid.getText());
					ps.setString(2,dttype.getText());
					ps.setString(3,dtalw.getText());
					ps.setString(4,dtnalw.getText());
					ps.setString(5,dtlist.getText());
					ps.executeUpdate();
					JOptionPane.showMessageDialog(null,"Saved...");
					dtalw.setText("");
					dtid.setText("");
					dtnalw.setText("");
					dttype.setText("");
					dtlist.setText("");
					dsave.setEnabled(false);
				}
			}
			catch(Exception ee)
			{
				System.out.println(ee);
			}
		}
		if(e.getSource()==dsearch)
		{
			dsave.setEnabled(false);
			sflg=1;
			String t1="";
			String t2="";
			String t3="";
			int flg=0,i;			
			String t=JOptionPane.showInputDialog("Enter diet ID:");
			try
			{
				Connection con=DriverManager.getConnection("jdbc:odbc:SpaSystemdsn");
				ResultSet res;
				Statement st=con.createStatement();
				res=st.executeQuery("select * from diettbl where dietid='"+t+"'");
				while(res.next())
				{
					dedit.setEnabled(true);
					flg=1;
					dtid.setText(res.getString(1));
					dttype.setText(res.getString(2));
					t1=res.getString(3);
					t2=res.getString(4);
					t3=res.getString(5);
				}
				if(flg==0)
				{
					JOptionPane.showMessageDialog(null,"No Record Found!!");
					dtid.setText("");
					dtalw.setText("");
					dtnalw.setText("");
					dttype.setText("");
					dtlist.setText("");
				}
				else
				{
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
			}
			catch(Exception ee)
			{
				System.out.println(ee);
			}
		}
		if(e.getSource()==dedit)
		{
			dsave.setEnabled(false);
			int flg=0;
			try
			{
				if(dtid.getText().length()!=0&&sflg==1)
				{
					if(dtid.getText().length()==0||dttype.getText().length()==0||dtalw.getText().length()==0||dtnalw.getText().length()==0||dtlist.getText().length()==0)
					{
						flg=1;
						JOptionPane.showMessageDialog(null,"Empty Fields");
					}
					if(flg==0)
					{
						Connection con=DriverManager.getConnection("jdbc:odbc:SpaSystemdsn");
						String str="update diettbl set diettype='"+dttype.getText()+"',foodallowed='"+dtalw.getText()+"',foodnotallowed='"+dtnalw.getText()+"',foodlist='"+dtlist.getText()+"' where dietid='"+dtid.getText()+"'";
						Statement st=con.createStatement();
						st.executeUpdate(str);
						JOptionPane.showMessageDialog(null,"Updated");
						dtid.setText("");
						dttype.setText("");
						dtalw.setText("");
						dtnalw.setText("");
						dtlist.setText("");
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Search Record For update!!");
				}
			}
			catch(Exception ee)
			{
				System.out.println(ee);
			}
		}
		if(e.getSource()==dcan)
		{
			this.dispose();
		}
	}
	public static void main(String argv[])
	{
		diet obj=new diet();
	}
}
