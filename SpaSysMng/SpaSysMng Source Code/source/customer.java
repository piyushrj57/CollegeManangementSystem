import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.*;
import java.io.*;
import java.sql.*;
import java.util.*;
import java.util.Date;
import java.text.SimpleDateFormat;
public class customer extends JFrame implements ActionListener,FocusListener
{
	JLabel lbl=new JLabel(new ImageIcon("../Images/mas.jpg"));
	
	int sflg=0;
	JLabel lcustid=new JLabel("Id");
	JLabel lcustname=new JLabel("Name");
	JLabel lcustaddress=new JLabel("Address");
	JLabel lcustcontact=new JLabel("Contact");
	JLabel lcustmob=new JLabel("Mobile No.");
	JLabel lcustemail=new JLabel("E-Mail");
	JLabel lcustgender=new JLabel("Gender");
	JLabel ldate=new JLabel("Date");
	JLabel lendate=new JLabel("Entry Date");
	JLabel lhead=new JLabel("Customer");
	
	JButton custnew=new JButton(new ImageIcon("../Images/mnbt.jpg"));
	JButton custsave=new JButton(new ImageIcon("../Images/msbt.jpg"));
	JButton custsearch=new JButton(new ImageIcon("../Images/mssbt.jpg"));
	JButton custedit=new JButton(new ImageIcon("../Images/mebt.jpg"));
	JButton custcancel=new JButton(new ImageIcon("../Images/mcbt.jpg"));
	
	JTextField txdate=new JTextField();
	JTextField txendate=new JTextField();
	JTextField txid=new JTextField();
	JTextField txname=new JTextField();
	JTextArea txaddress=new JTextArea();
	JTextField txemail=new JTextField();
	JTextField txmob=new JTextField();
	
	JRadioButton rmale =new JRadioButton("Male");
	JRadioButton rfemale=new JRadioButton("Female");
	ButtonGroup bg=new ButtonGroup();
	
	String strgen="";
	String strchk="";
	Calendar cal=Calendar.getInstance();
	
	JTextField txline=new JTextField();
	Dimension di=Toolkit.getDefaultToolkit().getScreenSize();

	///Fonts......
	Font btfnt=new Font("Consolas",Font.BOLD,15);
	Font lblfnt=new Font("Bookman Old Style",Font.BOLD,18);
	Font txtfnt=new Font("Bookman Old Style",Font.BOLD,15);


	JScrollPane sradd=new JScrollPane(txaddress,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

	public customer()
	{
		setLayout(null);
		setVisible(true);
		this.getContentPane().setBackground(Color.WHITE);
		setSize((int)di.getWidth(),(int)di.getHeight());
		setResizable(false);
		getContentPane().setBackground(Color.WHITE);

		lbl.setBounds(0,0,getWidth(),getHeight());

		bg.add(rmale);
		bg.add(rfemale);
		setResizable(false);
		
		
		add(txemail);
		add(custcancel);
		add(custsearch);
		add(custsave);
		add(custedit);
		add(custnew);
		add(txmob);
		add(rmale);
		add(rfemale);
		add(lcustgender);
		add(lcustcontact);
		add(lcustmob);
		add(lcustemail);
		add(sradd);
		add(lcustaddress);
		add(txname);
		add(txid);
		
		txid.setEditable(false);
		txdate.setEditable(false);
		
		add(lcustid);
		add(lcustname);
		add(ldate);
		add(txdate);
		add(lendate);
		add(txendate);
		add(lhead);
		
		txdate.setOpaque(false);
		txendate.setOpaque(false);
		
		lhead.setFont(new Font("castellar",1,25));
		lhead.setForeground(new Color(163,73,164));
		
		lhead.setBounds(400,30,250,30);
		
		lcustid.setFont(lblfnt);
		lcustid.setBounds(200,130,100,30);
		txid.setBounds(320,130,80,30);
		txid.setFont(txtfnt);
		
		ldate.setFont(lblfnt);
		ldate.setBounds(700,80,100,30);
		txdate.setBounds(820,80,80,30);
		txdate.setFont(txtfnt);
		

		lendate.setFont(lblfnt);
		lendate.setBounds(920,80,120,30);
		txendate.setBounds(1060,80,80,30);	
		txendate.setFont(txtfnt);
		
		lcustname.setFont(lblfnt);
		lcustname.setBounds(200,180,100,30);
		txname.setBounds(320,180,180,30);
		txname.setFont(txtfnt);
		
		lcustaddress.setFont(lblfnt);
		lcustaddress.setBounds(200,230,100,30);
		sradd.setBounds(320,230,220,70);
		txaddress.setFont(txtfnt);
		
		lcustcontact.setFont(lblfnt);
		lcustcontact.setBounds(200,310,120,30);
		
		lcustmob.setFont(lblfnt);
		lcustmob.setBounds(250,350,120,30);
		txmob.setBounds(370,350,150,30);
		txmob.setFont(txtfnt);
		
		lcustemail.setFont(lblfnt);
		lcustemail.setBounds(250,390,120,30);
		txemail.setBounds(370,390,150,30);
		txemail.setFont(txtfnt);
		
		lcustgender.setFont(lblfnt);
		lcustgender.setBounds(200,440,100,30);
				
		rmale.setFont(lblfnt);
		rmale.setBounds(320,440,80,30);
		rmale.setBackground(Color.WHITE);
		rfemale.setFont(lblfnt);
		rfemale.setBounds(420,440,100,30);
		rfemale.setBackground(Color.WHITE);
		
		custnew.setFont(btfnt);
		custnew.setBounds(120,580,120,30);
		custsave.setFont(btfnt);
		custsave.setBounds(250,580,120,30);
		custedit.setBounds(380,580,120,30);
		custedit.setFont(btfnt);
		custsearch.setBounds(510,580,120,30);
		custsearch.setFont(btfnt);
		custcancel.setBounds(640,580,120,30);
		
		txdate.setText(""+cal.get(Calendar.DATE)+"/"+(cal.get(Calendar.MONTH)+1)+"/"+cal.get(Calendar.YEAR));
		
		custsave.setEnabled(false);
		custedit.setEnabled(false);
		
		add(lbl);		
		repaint();
		
		rmale.addActionListener(this);
		rfemale.addActionListener(this);
		custsave.addActionListener(this);
		custedit.addActionListener(this);
		custnew.addActionListener(this);
		custcancel.addActionListener(this);
		custsearch.addActionListener(this);
		
		
		///Validation
		txname.addFocusListener(this);
		txmob.addFocusListener(this);
		txemail.addFocusListener(this);
		txendate.addFocusListener(this);
	}
	public void focusLost(FocusEvent fe)
	{
		int i,tflg=0;
		if(fe.getComponent()==txname)
		{
			strchk=txname.getText();
			if(txname.getText().length()==0)
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
						txname.setText("");
						break;
					}
				}
			}
		}
		if(fe.getComponent()==txmob)
		{
			int tmflg=0;
			strchk=txmob.getText();
			if(txmob.getText().length()==0)
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
						txmob.setText("");
						break a;				
					}
					if(strchk.length()!=10)
					{
						JOptionPane.showMessageDialog(null,"Enter 10-digits Mobile Number!!");
						txmob.setText("");
						break a;
					}}
				}
			}
		}
		if(fe.getComponent()==txemail)
		{
			int canchor=0,cdot=0,flg=0,teflg=0;
			strchk=txemail.getText();
			if(txemail.getText().length()==0)
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
					txemail.setText("");
				}
			}
		}
		
		if(fe.getComponent()==txendate)
		{
			strchk=txendate.getText();
			if(txendate.getText().length()!=0)
			{ 	
				try
				{
					SimpleDateFormat cdf = new SimpleDateFormat("dd/MM/yyyy");
					Date dat = cdf.parse(strchk);
					if (!strchk.equals(cdf.format(dat)))
					{
						JOptionPane.showMessageDialog(null,"Invalid Date Format!!");
						txendate.setText("");
					}
				}
				catch(Exception ee)
				{
					JOptionPane.showMessageDialog(null,"Invalid Date Format!!");
					txendate.setText("");
				}
					
			}
		}
	}
	public void focusGained(FocusEvent fe)
	{
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==custnew)
		{
			int ctr=1;
			
			try
			{
				Connection con=DriverManager.getConnection("jdbc:odbc:SpaSystemdsn");
				Statement st=con.createStatement();
				ResultSet res=st.executeQuery("select * from keytbl");
				while(res.next())
				{
					ctr=Integer.parseInt(res.getString(1));
				}
				if(ctr<10)
					txid.setText("C00"+ctr);
				if(ctr>=10&&ctr<100)
					txid.setText("C0"+ctr);
				if(ctr>=100&&ctr<1000)
					txid.setText("C"+ctr);
				txname.setText("");
				txaddress.setText("");
				txemail.setText("");
				txmob.setText("");
				bg.clearSelection();
				txendate.setText(txdate.getText());
				custsave.setEnabled(true);
				custedit.setEnabled(false);
			}
			catch(Exception ee)
			{
				JOptionPane.showMessageDialog(null,ee);
			}
		}
			if(e.getSource()==custsave)
			{	
				int flg=0;
				custedit.setEnabled(false);
				try
				{
					Connection con=DriverManager.getConnection("jdbc:odbc:SpaSystemdsn");
					
					String str="insert into customertbl(custdate,custid,custname,custaddress,custmob,custemail,custgender)values(?,?,?,?,?,?,?)";
					PreparedStatement ps=con.prepareStatement(str);
					if(txmob.getText().length()==0||txemail.getText().equals("")||txname.getText().length()==0||txaddress.getText().length()==0||bg.getSelection()==null)
					{
						JOptionPane.showMessageDialog(null,"Empty Fields!!!");
						flg=1;
					}				
					if(flg==0)
					{	
						ps.setString(1,txendate.getText());
						ps.setString(2,txid.getText());
						ps.setString(3,txname.getText());
						ps.setString(4,txaddress.getText());
				
						if(rmale.isSelected())
							
						{
							strgen="Male";
						}
						if(rfemale.isSelected())
						{
							strgen="Female";
						}	
						ps.setString(7,strgen);
						ps.setString(5,txmob.getText());
						ps.setString(6,txemail.getText());
						ps.executeUpdate();
						
						String str1="update keytbl set custid=custid+1";
						Statement st=con.createStatement();
						st.executeUpdate(str1);
						
						JOptionPane.showMessageDialog(null,"SAVED...");
						txendate.setText("");
						txid.setText("");
						txname.setText("");
						txaddress.setText("");
						txemail.setText("");
						txmob.setText("");
						bg.clearSelection();
						custsave.setEnabled(false);
					}
			}
			catch(Exception ee)
			{
				System.out.print(ee);
			}
		}
		if(e.getSource()==custedit)
		{
		custsave.setEnabled(false);
		custedit.setEnabled(false);
			int flg=0,tflg=0;
			try
			{
				Connection con=DriverManager.getConnection("jdbc:odbc:SpaSystemdsn");
				Statement st=con.createStatement();
				if(txid.getText().length()!=0&&sflg==1)
				{
					
					if(rmale.isSelected())
					{
						strgen="Male";
					}
					if(rfemale.isSelected())
					{
						strgen="Female";
					}			
					if(txendate.getText().length()==0||txmob.getText().length()==0||txemail.getText().equals("")||txname.getText().length()==0||txaddress.getText().length()==0||bg.getSelection()==null)
					{
						JOptionPane.showMessageDialog(null,"Empty Fields!!!");
						flg=1;
					}
					if(flg==0)
					{
						String str="Update customertbl set custdate='"+txendate.getText()+"',custname='"+txname.getText()+"',custaddress='"+txaddress.getText()+"',custgender='"+strgen+"',custmob='"+txmob.getText()+"',custemail='"+txemail.getText()+"' where custid='"+txid.getText()+"'";
						st.executeUpdate(str);
						JOptionPane.showMessageDialog(null,"Updated");
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
		
		if(e.getSource()==custsearch)
		{
		custsave.setEnabled(false);
			sflg=1;
			int flg=0;
			String t=JOptionPane.showInputDialog("Enter Customer id to search");
		try
		{
			
			Connection con=DriverManager.getConnection("jdbc:odbc:SpaSystemdsn");
			ResultSet res;
			Statement st=con.createStatement();
			res=st.executeQuery("select * from customertbl where custid='"+t+"'");
				while(res.next())
				{
					custedit.setEnabled(true);
					flg=1;
					txendate.setText(res.getString(1));
					txname.setText(res.getString(3));
					txid.setText(res.getString(2));
					txaddress.setText(res.getString(4));
					txmob.setText(res.getString(5));
					txemail.setText(res.getString(6));

				if(res.getString(7).equals("Male"))
					{
						rmale.setSelected(true);
						rfemale.setSelected(false);
					}
					else
					{
						rmale.setSelected(false);
						rfemale.setSelected(true);
					}
				}
				if(flg==0&&t.length()!=0)
				{
					JOptionPane.showMessageDialog(null,"No Record Found!!");
					txendate.setText("");
					txid.setText("");
					txname.setText("");
					txaddress.setText("");
					txmob.setText("");
					txemail.setText("");
					bg.clearSelection();			
				}
		}
		catch(Exception ee)
		{
			System.out.print(ee);
		}
	}
	if(e.getSource()==custcancel)
	{
		this.dispose();
	}
	}
	public static void main(String argv[])
	throws IOException
	{
		customer obj=new customer();
		
	}
}
