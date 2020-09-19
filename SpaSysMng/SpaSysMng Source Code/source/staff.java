import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.io.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;
import java.util.Date;
import java.text.SimpleDateFormat;
public class staff extends JFrame implements ActionListener,FocusListener
{
	JLabel lbl=new JLabel(new ImageIcon("../Images/mas.jpg"));

	int sflg=0;
	String strgen="";
	String stravail="";
	JLabel head=new JLabel("STAFF INFORMATION");
	JLabel sdate=new JLabel("Date");
	JLabel sid=new JLabel("Staff ID");
	JLabel sname=new JLabel("Name");
	JLabel sgen=new JLabel("Gender");
	JLabel stype=new JLabel("Speciality In");
	JLabel sadd=new JLabel("Address");
	JLabel scont=new JLabel("Contact");
	JLabel smob=new JLabel("Mobile");
	JLabel smail=new JLabel("E-mail");
	JLabel sstat=new JLabel("Status");
	JLabel ssal=new JLabel("Salary");
	JLabel sjoin=new JLabel("Date of Join");
	JLabel sprework=new JLabel("Previous Work");
	
	JTextField tdate=new JTextField();
	JTextField tsid=new JTextField();
	JTextField tsname=new JTextField();
	JTextArea tsadd=new JTextArea();
	JTextField tsmob=new JTextField();
	JTextField tsmail=new JTextField();
	JTextField tssal=new JTextField();
	JTextField tsjoin=new JTextField();
	JTextArea tsprework=new JTextArea();
	
	JButton snew=new JButton("New",new ImageIcon("../Images/mnbt.jpg"));
	JButton ssave=new JButton("Save",new ImageIcon("../Images/msbt.jpg"));
	JButton ssearch=new JButton("Search",new ImageIcon("../Images/mssbt.jpg"));
	JButton sedit=new JButton("Edit",new ImageIcon("../Images/mebt.jpg"));
	JButton scancel=new JButton("Cancel",new ImageIcon("../Images/mcbt.jpg"));
	
	JRadioButton rmale=new JRadioButton("Male");
	JRadioButton rfemale=new JRadioButton("Female");
	ButtonGroup bg=new ButtonGroup();
	
	JComboBox ctype=new JComboBox();
	
	Calendar cal=Calendar.getInstance();
	String strchk="";
	Dimension di=Toolkit.getDefaultToolkit().getScreenSize();	

	JTextField txline=new JTextField();
	///Fonts....
	Font btfnt=new Font("Consolas",Font.BOLD,15);
	Font lblfnt=new Font("Bookman Old Style",Font.BOLD,15);
	Font txtfnt=new Font("Bookman Old Style",Font.BOLD,12);
	
	JScrollPane sradd=new JScrollPane(tsadd,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	JScrollPane srpwork=new JScrollPane(tsprework,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	
	public staff()
	{
		setLayout(null);
		setVisible(true);
		this.getContentPane().setBackground(Color.WHITE);
		setSize((int)di.getWidth(),(int)di.getHeight());
		setResizable(false);

		lbl.setBounds(0,0,getWidth(),getHeight());
		
		head.setFont(new Font("castaller",1,25));
		head.setForeground(new Color(163,73,164));
		head.setBounds(500,30,450,30);
		
		sdate.setFont(lblfnt);
		sdate.setBounds(750,80,100,30);
		tdate.setBounds(870,80,100,30);
		tdate.setFont(txtfnt);
		
		sid.setFont(lblfnt);
		sid.setBounds(130,130,100,30);
		tsid.setBounds(250,130,100,30);
		tsid.setFont(txtfnt);
		
		sname.setFont(lblfnt);
		sname.setBounds(130,180,100,30);
		tsname.setBounds(250,180,140,30);
		tsname.setFont(txtfnt);
		
		sgen.setFont(lblfnt);
		sgen.setBounds(130,230,100,30);
		rmale.setFont(lblfnt);
		rmale.setBackground(Color.WHITE);
		rmale.setBounds(250,230,80,30);
		rfemale.setFont(lblfnt);
		rfemale.setBackground(Color.WHITE);
		rfemale.setBounds(350,230,100,30);
		
		sadd.setFont(lblfnt);
		sadd.setBounds(130,280,100,30);
		sradd.setBounds(250,280,170,70);
		tsadd.setFont(txtfnt);
		
		scont.setFont(lblfnt);
		scont.setBounds(130,350,100,30);
		
		smob.setFont(lblfnt);
		smob.setBounds(180,390,100,30);
		tsmob.setFont(txtfnt);
		tsmob.setBounds(300,390,100,30);
		
		smail.setFont(lblfnt);
		smail.setBounds(180,430,100,30);
		tsmail.setBounds(300,430,150,30);
		tsmail.setFont(txtfnt);		
		
		sjoin.setFont(lblfnt);
		sjoin.setBounds(570,200,100,30);
		tsjoin.setBounds(680,200,100,30);
		tsjoin.setFont(txtfnt);
		tsjoin.setOpaque(false);
		
		stype.setFont(lblfnt);
		stype.setBounds(570,250,100,30);
		ctype.setBounds(680,250,120,30);
		ctype.setFont(txtfnt);
		ctype.setOpaque(false);

		
		sprework.setFont(lblfnt);
		sprework.setBounds(570,300,130,30);
		srpwork.setBounds(690,300,160,60);
		tsprework.setFont(txtfnt);
		
		ssal.setFont(lblfnt);
		ssal.setBounds(570,370,100,30);
		tssal.setBounds(680,370,100,30);
		tssal.setFont(txtfnt);
		tssal.setOpaque(false);
	
		snew.setFont(btfnt);
		snew.setBounds(120,600,120,30);
		ssave.setFont(btfnt);
		ssave.setBounds(250,600,120,30);
		ssearch.setFont(btfnt);
		ssearch.setBounds(380,600,120,30);
		sedit.setFont(btfnt);
		sedit.setBounds(510,600,120,30);
		scancel.setFont(btfnt);
		scancel.setBounds(640,600,120,30);

		
		add(ssal);
		add(tssal);
		add(scancel);
		add(ssearch);
		add(sedit);
		add(snew);
		add(ssave);
		
		add(tsjoin);
		add(sjoin);
		add(stype);
		add(ctype);
		
		add(scont);
		add(tsmob);
		add(smob);
		add(smail);
		add(tsmail);
		add(sadd);
		add(sradd);
		add(sgen);
		add(rmale);
		add(rfemale);
		bg.add(rfemale);
		bg.add(rmale);
		add(sname);
		add(tsname);
		add(tsid);
		add(sid);
		add(tdate);
		add(sdate);
		add(head);
		add(sprework);
		add(srpwork);

		ctype.addItem("Select Type");				
		snew.addActionListener(this);
		ssave.addActionListener(this);
		sedit.addActionListener(this);
		scancel.addActionListener(this);
		ssearch.addActionListener(this);
		
		tdate.setText(""+cal.get(Calendar.DATE)+"/"+(cal.get(Calendar.MONTH)+1)+"/"+cal.get(Calendar.YEAR));
		add(lbl);
		repaint();
		
		tsid.setEditable(false);
		tdate.setEditable(false);
		ssave.setEnabled(false);
		sedit.setEnabled(false);

		//Validation...
		tsname.addFocusListener(this);
		tsmob.addFocusListener(this);
		tsmail.addFocusListener(this);
		tsjoin.addFocusListener(this);
		tssal.addFocusListener(this);
	}
	public void focusLost(FocusEvent fe)
	{
		int i,tflg=0;
		if(fe.getComponent()==tsname)
		{
			strchk=tsname.getText();
			if(tsname.getText().length()==0)
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
						tsname.setText("");
						break;
					}
				}
			}
		}	

		if(fe.getComponent()==tsmob)
		{
			int tmflg=0;
			strchk=tsmob.getText();
			if(tsmob.getText().length()==0)
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
						tsmob.setText("");
						break a;				
					}
					if(strchk.length()!=10)
					{
						JOptionPane.showMessageDialog(null,"Enter 10-digits Mobile Number!!");
						tsmob.setText("");
						break a;				
					}}
				}
			}
		}
		if(fe.getComponent()==tsmail)
		{
			int canchor=0,cdot=0,flg=0,teflg=0;
			strchk=tsmail.getText();
			if(tsmail.getText().length()==0)
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
					tsmail.setText("");
				}
			}
		}
		if(fe.getComponent()==tsjoin)
		{
			strchk=tsjoin.getText();
			
			if(tsjoin.getText().length()!=0)
			{ 	
				try
				{
					SimpleDateFormat cdf = new SimpleDateFormat("dd/MM/yyyy");
					Date dat = cdf.parse(strchk);
					if (!strchk.equals(cdf.format(dat)))
					{
						JOptionPane.showMessageDialog(null,"Invalid Date Format!!");
						tsjoin.setText("");
					}
				}
				catch(Exception ee)
				{
					JOptionPane.showMessageDialog(null,"Invalid Date Format!!");
					tsjoin.setText("");
				}
					
			}
		}
		if(fe.getComponent()==tssal)
		{
			int tmflg=0,dflg=0;
			strchk=tssal.getText();
			if(tssal.getText().length()==0)
			{
			}
			else
			{
				tmflg=1;
			}
			if(tmflg==1)
			{
				p:{for(i=0;i<strchk.length();i++)
				{
					if(Character.getNumericValue(strchk.charAt(i))>=0&&Character.getNumericValue(strchk.charAt(i))<=9||dflg==0)
					{
						if(strchk.charAt(i)=='.')
							dflg=1;
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Enter Only Digits!!");
						tssal.setText("");
						break p;				
					}
				 }
				}
			}
		}
				
	}
	public void focusGained(FocusEvent fe)
	{	
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==snew)
		{ 
			sedit.setEnabled(false);
			int ctr=0;
			try
			{
				Connection con=DriverManager.getConnection("jdbc:odbc:SpaSystemdsn");
				Statement st=con.createStatement();
				ResultSet res=st.executeQuery("select * from Keytbl");
				while(res.next())
				{
				  ctr=Integer.parseInt(res.getString(10));
				}	
				if(ctr<10)
					tsid.setText("S00"+ctr);
				if(ctr>=10&&ctr<100)
					tsid.setText("S0"+ctr);
				if(ctr>=100&&ctr<1000)
					tsid.setText("S"+ctr);
				
				tsname.setText("");
				 tsadd.setText("");
				 tsmob.setText("");
				 tsmail.setText("");
				 tsjoin.setText("");
				 tssal.setText("");
				 bg.clearSelection();
				 tsprework.setText("");
					tsjoin.setText(tdate.getText());
				
					ssave.setEnabled(true);
				
					ctype.removeAllItems();
					res=st.executeQuery("select * from typetbl");
					ctype.addItem("Select Type");
					while(res.next())
					{
						ctype.addItem(res.getString(2));
					}
									
			}
			catch(Exception ee)
			{
				System.out.println(ee);
			}
		}
		if(e.getSource()==ssave)
		{
			sedit.setEnabled(false);
			int flg=0;
			try
			{
				Connection con=DriverManager.getConnection("jdbc:odbc:SpaSystemdsn");
				String str="insert into stafftbl(staffid,sname,sgender,address,mobile,email,joindate,speciality,previouswork,salary)values(?,?,?,?,?,?,?,?,?,?)";
				PreparedStatement ps=con.prepareStatement(str);
				if(tsname.getText().length()==0||bg.getSelection()==null||tsadd.getText().length()==0||tsmob.getText().length()==0||tsmail.getText().length()==0||tsjoin.getText().length()==0||tsprework.getText().length()==0||tssal.getText().length()==0)
				{
					JOptionPane.showMessageDialog(null,"Empty Fields!!!");
					flg=1;
				}
				if(flg==0)
				{
					ps.setString(1,tsid.getText());
					ps.setString(2,tsname.getText());
					if(rmale.isSelected())
					{
						strgen="Male";
					}
					else
					{
						strgen="Female";
					}
					ps.setString(3,strgen);
					ps.setString(4,tsadd.getText());
					ps.setString(5,tsmob.getText());
					ps.setString(6,tsmail.getText());
					ps.setString(7,tsjoin.getText());
				
					String tid="";
					Statement st1=con.createStatement();
					ResultSet res=st1.executeQuery("select * from typetbl where typename='"+ctype.getSelectedItem().toString()+"'");
					while(res.next())
					{
						tid=res.getString(1);
					}
					if(tid.length()==0)
					{
						tid="N/A";
					}
					ps.setString(8,tid);
					ps.setString(9,tsprework.getText());
					ps.setString(10,tssal.getText());
					ps.executeUpdate();
					Statement st=con.createStatement();
					String str1="update keytbl set staffid=staffid+1";
					st.executeUpdate(str1);
					JOptionPane.showMessageDialog(null,"Saved...");
						ssave.setEnabled(false);
					ctype.removeAllItems();
					tsid.setText("");
					tsname.setText("");
					tsadd.setText("");
					tsmob.setText("");
					tsmail.setText("");
					tsjoin.setText("");
					tssal.setText("");
					tsprework.setText("");
					bg.clearSelection();
					tsjoin.setText("");
				}
			}
			catch(Exception ee)
			{
				System.out.println(ee);
			}
		}
		if(e.getSource()==ssearch)
		{
			sflg=1;
			ssave.setEnabled(false);			
			String tpid="";
			String tname="";
			String tmp="";
			String t=JOptionPane.showInputDialog("Enter Id");
			try
			{
				int flg=0;
				Connection con=DriverManager.getConnection("jdbc:odbc:SpaSystemdsn");
				Statement st=con.createStatement();
				ResultSet res=st.executeQuery("select * from stafftbl where staffid='"+t+"'");
				while(res.next())
				{
					sedit.setEnabled(true);
					flg=1;
					tsid.setText(res.getString(1));
					tsname.setText(res.getString(2));
					if(res.getString(3).equals("Male"))
					{
						rmale.setSelected(true);
					}
					else
					{
						rfemale.setSelected(true);
					}
					tsadd.setText(res.getString(4));
					tsmob.setText(res.getString(5));
					tsmail.setText(res.getString(6));
					tsjoin.setText(res.getString(7));
					tpid=res.getString(8);
					ctype.removeAllItems();
					Statement st1=con.createStatement();
					ResultSet res1=st1.executeQuery("select * from typetbl");
					ctype.addItem("Select Type");					
					while(res1.next())
					{
						tname=res1.getString(2);
						if(tpid.equals(res1.getString(1)))
								tmp=tname;
						ctype.addItem(tname);
					}
					ctype.setSelectedItem(tmp);
					tsprework.setText(res.getString(9));
					tssal.setText(res.getString(10));
				}
				if(flg==0&&t.length()!=0)
				{
					JOptionPane.showMessageDialog(null,"No Record Found!!");
					ctype.setSelectedIndex(0);
					tsid.setText("");
					tsname.setText("");
					tsadd.setText("");
					tsmob.setText("");
					tsmail.setText("");
					tsjoin.setText("");
					tssal.setText("");
					tsprework.setText("");
					bg.clearSelection();
				}
			}
			catch(Exception ee)
			{
				System.out.println(ee);
			}
		}
		if(e.getSource()==scancel)
		{
				this.dispose();
		}
		if(e.getSource()==sedit)
		{
			ssave.setEnabled(false);
			sedit.setEnabled(false);
			int flg=0;
			try
			{
					Connection con=DriverManager.getConnection("jdbc:odbc:SpaSystemdsn");
					Statement st=con.createStatement();
				
				if(tsid.getText().length()!=0&&sflg==1)
				{
					String tpid="";
					String tname="";
					String tmp="";
					if(rmale.isSelected())
					{
						strgen="Male";
					}
					if(rfemale.isSelected())
					{
						strgen="Female";
					}
					
					Statement st1=con.createStatement();
					ResultSet res1=st1.executeQuery("select * from typetbl where typename='"+ctype.getSelectedItem().toString()+"'");					
						while(res1.next())
						{	
								tmp=res1.getString(1);
						}
						if(tmp.length()==0)
							tmp="N/A";
					if(tsname.getText().length()==0||bg.getSelection()==null||tsadd.getText().length()==0||tsmob.getText().length()==0||tsmail.getText().length()==0||tsjoin.getText().length()==0||tsprework.getText().length()==0||tssal.getText().length()==0)
					{
						JOptionPane.showMessageDialog(null,"Empty Fields!!!");
						flg=1;
						
					}
					if(flg==0)
					{
						String str="update stafftbl set sname='"+tsname.getText()+"',sgender='"+strgen+"',address='"+tsadd.getText()+"',mobile='"+tsmob.getText()+"',email='"+tsmail.getText()+"',joindate='"+tsjoin.getText()+"',speciality='"+tmp+"',previouswork='"+tsprework.getText()+"',salary='"+tssal.getText()+"' where staffid='"+tsid.getText()+"'";
						st.executeUpdate(str);
						JOptionPane.showMessageDialog(null,"updated...");
						tsid.setText("");
						ctype.setSelectedIndex(0);
						tsname.setText("");
						bg.clearSelection();
						tsadd.setText("");
						tsmob.setText("");
						tsmail.setText("");
						tsprework.setText("");
						tssal.setText("");
					}
					
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Search Record for update!!");
									
				}
			}
			catch(Exception ee)
			{
				System.out.print(ee);
			}
		}
	}
	public static void main(String argv[])
	throws IOException
	{
		staff obj=new staff();
	}
}
