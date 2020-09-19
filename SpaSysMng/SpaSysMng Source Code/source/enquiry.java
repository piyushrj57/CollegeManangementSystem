import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;
import java.util.Date;
import java.text.SimpleDateFormat;

public class enquiry extends JFrame implements ActionListener,FocusListener
{
	JLabel lbl=new JLabel(new ImageIcon("../Images/trac.jpg"));	
	
	JLabel eid=new JLabel("Enquiry ID");
	JLabel ename=new JLabel("Name");
	JLabel eadd=new JLabel("Address");
	JLabel egender=new JLabel("Gender");
	JLabel emob=new JLabel("Mobile");
	JLabel econtact=new JLabel("Contact");
	JLabel email=new JLabel("E-mail");
	JLabel epurpose=new JLabel("Purpose");
	JLabel estatus=new JLabel("Status");
	JLabel ehead=new JLabel("Enquiry Form");
	JLabel edate=new JLabel("Date");
	JLabel endate=new JLabel("Enquiry Date");	
	
	JTextField tid=new JTextField();
	JTextField tname=new JTextField();
	JTextArea tadd=new JTextArea();
	JTextField tmob=new JTextField();
	JTextField temail=new JTextField();
	JTextField tndate=new JTextField();
	JTextField tdate=new JTextField();
	JTextArea tpurpose=new JTextArea();
	
	JRadioButton rmale=new JRadioButton("Male");
	JRadioButton rfemale=new JRadioButton("Female");
	ButtonGroup bg=new ButtonGroup();
	
	Calendar cal=Calendar.getInstance();
	JRadioButton rcon=new JRadioButton("Confirm");
	JRadioButton rpend=new JRadioButton("Pending");
	JRadioButton rrej=new JRadioButton("Rejected");
	ButtonGroup bs=new ButtonGroup();
	
	JButton enew=new JButton("New",new ImageIcon("../Images/nbt.jpg"));
	JButton esave=new JButton("Save",new ImageIcon("../Images/sbt.jpg"));
	JButton esearch=new JButton("Search",new ImageIcon("../Images/sbtn.jpg"));
	JButton eedit=new JButton("Edit",new ImageIcon("../Images/ebt.jpg"));
	JButton ecancel=new JButton("Cancel",new ImageIcon("../Images/cbt.jpg"));
	String strgen,strpen;
	
	String strchk="";
	
	Dimension di=Toolkit.getDefaultToolkit().getScreenSize();

	///Fonts......
	Font btfnt=new Font("Consolas",Font.BOLD,15);
	Font lblfnt=new Font("Bookman Old Style",Font.BOLD,15);
	Font txtfnt=new Font("Bookman Old Style",Font.BOLD,12);
	
	JScrollPane sradd=new JScrollPane(tadd,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	JScrollPane srpurpose=new JScrollPane(tpurpose,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	
	public enquiry()
	{
		setLayout(null);
		setVisible(true);
		this.getContentPane().setBackground(Color.WHITE);
		setSize((int)di.getWidth(),(int)di.getHeight());
		setResizable(false);
		getContentPane().setBackground(Color.WHITE);

		lbl.setBounds(0,0,getWidth(),getHeight());
		
		ehead.setFont(new Font("castellar",1,25));
		ehead.setForeground(new Color(181,230,29));
		ehead.setBounds(300,30,300,30);
		
		edate.setFont(lblfnt);
		edate.setBounds(960,90,50,30);
		tdate.setBounds(1030,90,100,30);
		tdate.setFont(txtfnt);
		
		eid.setFont(lblfnt);
		eid.setBounds(250,140,100,30);
		tid.setBounds(370,140,100,30);
		tid.setFont(txtfnt);
		
		ename.setFont(lblfnt);
		ename.setBounds(250,190,100,30);
		tname.setBounds(370,190,180,30);
		tname.setFont(txtfnt);
		
		eadd.setFont(lblfnt);
		eadd.setBounds(250,240,100,30);
		sradd.setBounds(370,240,170,90);
		tadd.setFont(txtfnt);
		
		egender.setFont(lblfnt);
		egender.setBounds(250,340,100,30);
		rmale.setFont(lblfnt);
		rmale.setBounds(370,340,80,30);
		rfemale.setFont(lblfnt);
		rfemale.setBounds(470,340,100,30);
		
		econtact.setFont(lblfnt);
		econtact.setBounds(250,390,100,30);
		
		emob.setFont(lblfnt);
		emob.setBounds(300,430,100,30);
		tmob.setBounds(420,430,120,30);
		tmob.setFont(txtfnt);
		
		email.setFont(lblfnt);
		email.setBounds(300,470,100,30);
		temail.setBounds(420,470,170,30);
		temail.setFont(txtfnt);
		
		epurpose.setFont(lblfnt);
		epurpose.setBounds(250,520,100,30);
		tpurpose.setFont(txtfnt);
		srpurpose.setBounds(370,520,150,60);
		
		endate.setFont(lblfnt);
		endate.setBounds(700,90,120,30);
		tndate.setBounds(840,90,100,30);
		tndate.setFont(txtfnt);
		
		estatus.setFont(lblfnt);
		estatus.setBounds(250,590,100,30);
		rcon.setFont(lblfnt);
		rcon.setBounds(360,590,100,30);
		rpend.setFont(lblfnt);
		rpend.setBounds(470,590,100,30);
		rrej.setFont(lblfnt);
		rrej.setBounds(580,590,100,30);
		
		enew.setFont(btfnt);
		enew.setBounds(150,650,120,30);
		esave.setFont(btfnt);
		esave.setBounds(280,650,120,30);
		esearch.setFont(btfnt);
		esearch.setBounds(410,650,120,30);
		eedit.setFont(btfnt);
		eedit.setBounds(540,650,120,30);
		ecancel.setFont(btfnt);
		ecancel.setBounds(670,650,120,30);
		
		add(epurpose);
		add(srpurpose);
		add(endate);
		add(tndate);
		add(email);
		add(temail);
		add(econtact);
		add(emob);
		add(tmob);
		add(egender);
		add(rmale);
		add(rfemale);
		bg.add(rmale);
		bg.add(rfemale);
		
		add(eid);
		add(tid);
		add(eadd);
		add(sradd);
		add(edate);
		add(tdate);
		add(ename);
		add(tname);
		add(ehead);
				
		tdate.setText(""+cal.get(Calendar.DATE)+"/"+(cal.get(Calendar.MONTH)+1)+"/"+cal.get(Calendar.YEAR));

		add(estatus);
		bs.add(rpend);
		bs.add(rrej);
		bs.add(rcon);
		add(rcon);
		add(rrej);
		add(rpend);
		
		add(enew);
		add(esave);
		add(esearch);
		add(eedit);
		add(ecancel);
		
		add(lbl);		
		repaint();
		
		enew.addActionListener(this);
		esave.addActionListener(this);
		esearch.addActionListener(this);
		eedit.addActionListener(this);
		ecancel.addActionListener(this);
		
		esave.setEnabled(false);
		tid.setEditable(false);
		tdate.setEditable(false);
		eedit.setEnabled(false);
		
		//Validation.....
		tname.addFocusListener(this);
		tmob.addFocusListener(this);
		temail.addFocusListener(this);
		tndate.addFocusListener(this);

	}	
	public void focusLost(FocusEvent fe)
	{
		int i,tflg=0;
		if(fe.getComponent()==tname)
		{
			strchk=tname.getText();
			if(tname.getText().length()==0)
			{
			}
			else
			{
				tflg=1;
			}
			if(tflg==1)
			{
				for(i=0;i<strchk.length();i++)
				{
					if(strchk.charAt(i)>='a'&&strchk.charAt(i)<='z'||strchk.charAt(i)>='A'&&strchk.charAt(i)<='Z'||strchk.charAt(i)==' ')
					{
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Invalid Name!!!");
						tname.setText("");
						break;
					}
				}
			}
		}	

		if(fe.getComponent()==tmob)
		{
			int tmflg=0;
			strchk=tmob.getText();
			if(tmob.getText().length()==0)
			{
			}
			else
			{
				tmflg=1;
			}
			if(tmflg==1)
			{
				a:{for(i=0;i<strchk.length();i++)
				{
					if(Character.getNumericValue(strchk.charAt(i))>=0&&Character.getNumericValue(strchk.charAt(i))<=9)
					{
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Enter Only Digits!!");
						tmob.setText("");
						break a;				
					}
					if(strchk.length()!=10)
					{
						JOptionPane.showMessageDialog(null,"Enter 10-digits Mobile Number!!");
						tmob.setText("");
						break a;				
					}}
				}
			}
		}

		if(fe.getComponent()==temail)
		{
			int canchor=0,cdot=0,flg=0,teflg=0;
			strchk=temail.getText();
			if(temail.getText().length()==0)
			{
			}
			else
			{
				teflg=1;
			}
			if(teflg==1)
			{
				for(i=0;i<strchk.length();i++)
				{
					if(strchk.charAt(i)=='@')
					{
						canchor++;
					}
					if(strchk.charAt(i)=='.')
					{
						cdot++;
					}
					if(strchk.charAt(i)>='a'&&strchk.charAt(i)<='z')
					{
						flg=1;
					}
				}
			
				if(canchor==1&&cdot>=1&&flg==1)
				{
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Invalid E-Mail ID!!!");
					temail.setText("");
				}
			}
		}
		if(fe.getComponent()==tndate)
		{
			strchk=tndate.getText();
			
			if(tndate.getText().length()!=0)
			{ 	
				try
				{
					SimpleDateFormat cdf = new SimpleDateFormat("dd/MM/yyyy");
					Date dat = cdf.parse(strchk);
					if (!strchk.equals(cdf.format(dat)))
					{
						JOptionPane.showMessageDialog(null,"Invalid Date Format!!");
						tndate.setText("");
					}
				}
				catch(Exception ee)
				{
					JOptionPane.showMessageDialog(null,"Invalid Date Format!!");
					tndate.setText("");
				}
			}
		}

	}
	public void focusGained(FocusEvent fe)
	{
		
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==enew)
		{
			eedit.setEnabled(false);
			int ctr=0;
			try
			{
				Connection con=DriverManager.getConnection("jdbc:odbc:SpaSystemdsn");
				Statement st=con.createStatement();
				ResultSet res=st.executeQuery("select * from keytbl");
				while(res.next())
				{
					ctr=Integer.parseInt(res.getString(6));
				}	
				if(ctr<10)
					tid.setText("E00"+ctr);
				if(ctr>=10&&ctr<100)
					tid.setText("E0"+ctr);
				if(ctr>=100&&ctr<1000)
					tid.setText("E"+ctr);
				
				tname.setText("");
				tadd.setText("");
				temail.setText("");
				tmob.setText("");
				
				tndate.setText(tdate.getText());
				bg.clearSelection();
				bs.clearSelection();
				tpurpose.setText("");
				esave.setEnabled(true);
			}
			catch(Exception ee)
			{
				System.out.println(ee);
			}
		}
		if(e.getSource()==esave)
		{
			eedit.setEnabled(false);
			int flg=0;
			try
			{
				Connection con=DriverManager.getConnection("jdbc:odbc:SpaSystemdsn");											
				String str1="insert into enquirytbl(enqid,enqname,enqdate,enqaddress,enqgender,enqmobno,enqmail,enqpurpose,enqstatus)values(?,?,?,?,?,?,?,?,?)";
				PreparedStatement ps=con.prepareStatement(str1);
				Statement st=con.createStatement();
				if(tndate.getText().length()==0||tname.getText().length()==0||tadd.getText().length()==0||bg.getSelection()==null||tmob.getText().length()==0||temail.getText().length()==0||tpurpose.getText().length()==0||bs.getSelection()==null)
				{
					JOptionPane.showMessageDialog(null,"Empty Fields!!!");
					flg=1;
				}
				if(flg==0)
				{
					
					ps.setString(1,tid.getText());
					ps.setString(2,tname.getText());
					ps.setString(3,tndate.getText());
					ps.setString(4,tadd.getText());
					
					if(rmale.isSelected())
					{
						strgen="Male";
					}
					if(rfemale.isSelected())
					{
						strgen="Female";
					}	
				
					ps.setString(5,strgen);
					ps.setString(6,tmob.getText());
					ps.setString(7,temail.getText());
					
					ps.setString(8,tpurpose.getText());
				
					if(rcon.isSelected())
					{
						strpen="Confirm";
					}
					else if(rpend.isSelected())
					{
						strpen="Pending";
					}
					else
					{
						strpen="Rejected";
					}
				
					ps.setString(9,strpen);
					ps.executeUpdate();	

						/////mine
					
						Statement st1=con.createStatement();
						ResultSet res=st1.executeQuery("select * from keytbl");
						String tmp="";
						while(res.next())
						{
							tmp="F00"+res.getString(6);
						}
					
						String str2="insert into followtbl(enquiryid,followid,status,fdate,fphone,fmail) values(?,?,?,?,?,?)";
						PreparedStatement ps1=con.prepareStatement(str2);
						ps1.setString(1,tid.getText());
						ps1.setString(2,tmp);
						ps1.setString(3,strpen);
						ps1.setString(4,tndate.getText());
						ps1.setString(5,tmob.getText());
						ps1.setString(6,temail.getText());
						
						ps1.executeUpdate();
					
						String str3="update keytbl set followid=followid+1";
						Statement st2=con.createStatement();
						st2.executeUpdate(str3);
					
					String str="update keytbl set enqid=enqid+1";
					st.executeUpdate(str);
					JOptionPane.showMessageDialog(null,"Saved");					
					tid.setText("");
					tndate.setText("");
					tname.setText("");
					tadd.setText("");
					bg.clearSelection();
					tmob.setText("");
					temail.setText("");
					tpurpose.setText("");
					bs.clearSelection();
					esave.setEnabled(false);
				}
			}
			catch(Exception ee)
			{
				System.out.println(ee);
			}
		}
		if(e.getSource()==esearch)
		{
			int flg=0;
			String tmp="";
			String t=JOptionPane.showInputDialog("Enter Enquiry id to search");
		
			try
			{	
				Connection con=DriverManager.getConnection("jdbc:odbc:SpaSystemdsn");
				ResultSet res;
				Statement st=con.createStatement();
				
				res=st.executeQuery("select * from enquirytbl where enqid='"+t+"'");
				while(res.next())
				{
					//eedit.setEnabled(false);
					flg=1;
					tid.setText(res.getString(1));
					tname.setText(res.getString(2));
					tndate.setText(res.getString(3));
					tadd.setText(res.getString(4));
					if(res.getString(5).equals("Male"))
					{
						rmale.setSelected(true);
						rfemale.setSelected(false);
					}
					else
					{
						rmale.setSelected(false);
						rfemale.setSelected(true);
					}
					tmob.setText(res.getString(6));
					temail.setText(res.getString(7));
					tpurpose.setText(res.getString(8));
					tmp=res.getString(9);
					if(tmp.equals("Confirm"))
					{
						rcon.setSelected(true);	
					}
					else if(tmp.equals("Pending"))
					{
						rpend.setSelected(true);
					}
					else
					{
						rrej.setSelected(true);
					}
				}
				if(flg==0&&t.length()!=0)
				{
					JOptionPane.showMessageDialog(null,"No Record Found!!");
					tid.setText("");
					tndate.setText("");
					tname.setText("");
					tadd.setText("");
					bg.clearSelection();
					tmob.setText("");
					temail.setText("");
					tpurpose.setText("");
					bs.clearSelection();
					esave.setEnabled(false);
					
				}
				eedit.setEnabled(true);	
			}
			catch(Exception ee)
			{
				System.out.print(ee);
			}
		}
		
		if(e.getSource()==eedit)
		{
			int flg=0,tflg=0;
			int ctr1=0;
			try
			{
				esave.setEnabled(false);
				if(tid.getText().length()!=0)
				{
					Connection con=DriverManager.getConnection("jdbc:odbc:SpaSystemdsn");
					Statement st=con.createStatement();

					if(rmale.isSelected())
					{
						strgen="Male";
					}
					if(rfemale.isSelected())
					{
						strgen="Female";
					}	

					if(rcon.isSelected())
					{
						strpen="Confirm";
					}
					else if(rpend.isSelected())
					{
						strpen="Pending";
					}
					else
					{
						strpen="Rejected";
					}
					if(tndate.getText().length()==0||tname.getText().length()==0||tadd.getText().length()==0||bg.getSelection()==null||tmob.getText().length()==0||temail.getText().length()==0||tpurpose.getText().length()==0||bs.getSelection()==null)
					{
						JOptionPane.showMessageDialog(null,"Empty Fields!!!");
						flg=1;
						tflg=1;
					}
					if(tflg==0)
					{
						ResultSet res=st.executeQuery("select * from followtbl where enquiryid='"+tid.getText()+"'");
						while(res.next())
						{
							ctr1++;
						}
						res.close();
						if(ctr1==1)
						{
							String str="update enquirytbl set enqname='"+tname.getText()+"',enqdate='"+tndate.getText()+"',enqaddress='"+tadd.getText()+"',enqgender='"+strgen+"',enqmobno='"+tmob.getText()+"',enqmail='"+temail.getText()+"',enqpurpose='"+tpurpose.getText()+"',enqstatus='"+strpen+"' where enqid='"+tid.getText()+"'";
							st.executeUpdate(str);
							
							st.executeUpdate("update followtbl set status='"+strpen+"' where enquiryid='"+tid.getText()+"'");
							JOptionPane.showMessageDialog(null,"Record Updated!!");
							eedit.setEnabled(false);
						}
						else
						{
							JOptionPane.showMessageDialog(null,"Data can't be updated!!");
						}
					}
				}
				else
				{
					if(tflg==0)
						JOptionPane.showMessageDialog(null,"Search Request For Update");
				}
			}
			catch(Exception ee)
			{
				System.out.println(ee);
			}
		}
		if(e.getSource()==ecancel)
		{
			this.dispose();
		}
	}
	public static void main(String argv[])
	throws IOException
	{
		enquiry obj=new enquiry();
	}
}