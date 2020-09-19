import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;

public class payment extends JFrame implements ActionListener,FocusListener,ItemListener
{
	JLabel lbl=new JLabel(new ImageIcon("../Images/pt.jpg"));		
	
	JLabel pid=new JLabel("Payment ID");
	JLabel pbid=new JLabel("Booking ID");
	JLabel puser=new JLabel("User Type");
	JLabel pcmid=new JLabel("Customer/Member ID");
	JLabel pname=new JLabel("Name");
	JLabel pcont=new JLabel("Contact");
	JLabel pmob=new JLabel("Mobile");
	JLabel pemail=new JLabel("Email");
	JLabel ptcost=new JLabel("Total Cost");
	JLabel pad=new JLabel("Previous Paid");
	JLabel pout=new JLabel("Outstanding Amount");
	JLabel paymode=new JLabel("Payment Mode");
	JLabel pbr=new JLabel("Branch Name");
	JLabel pch=new JLabel("Cheque No");
	JLabel pchdt=new JLabel("Cheque Date");
	JLabel pamt=new JLabel("Amount");
	JLabel phead=new JLabel("Payment Information");
	JLabel pdate=new JLabel("Date");
	JLabel ptreat=new JLabel("Treatment/Package ID");
	JLabel pbank=new JLabel("Bank Name");
	JLabel pdt=new JLabel("Payment Date");
	
	JTextField ptdate=new JTextField();
	JTextArea pttreat=new JTextArea();
	JTextField ptid=new JTextField();
	JTextField ptbid=new JTextField();
	JTextField ptcmid=new JTextField();
	JTextField ptname=new JTextField();
	JTextField ptcont=new JTextField();
	JTextField ptmob=new JTextField();
	JTextField ptemail=new JTextField();
	JTextField ptc=new JTextField();
	JTextField ptad=new JTextField();
	JTextField ptmode=new JTextField();
	JTextField ptbr=new JTextField();
	JTextField ptch=new JTextField();
	JTextField ptchdt=new JTextField();
	JTextField ptamt=new JTextField();
	JTextField ptout=new JTextField();
	JTextField ptbank=new JTextField();
	JTextField ptdt=new JTextField();
	
	JRadioButton rmem=new JRadioButton("Member");
	JRadioButton rcust=new JRadioButton("Customer");
	
	JRadioButton rch=new JRadioButton("Cheque");
	JRadioButton rcash=new JRadioButton("Cash");
	
	ButtonGroup bt=new ButtonGroup();
	ButtonGroup bm=new ButtonGroup();

	JButton  pnew=new JButton("New",new ImageIcon("../Images/pnbt.jpg"));
	JButton  psave=new JButton("Save",new ImageIcon("../Images/psbt.png"));
	JButton  pbill=new JButton("Print Bill",new ImageIcon("../Images/ppbt.jpg"));
	JButton  pcancel=new JButton("Cancel",new ImageIcon("../Images/pcbt.jpg"));
	
	Calendar cal=Calendar.getInstance();
	String strchk="";
	int sflg=0;

	Dimension di=Toolkit.getDefaultToolkit().getScreenSize();

	///Fonts......
	Font btfnt=new Font("Consolas",Font.BOLD,15);
	Font lblfnt=new Font("Bookman Old Style",Font.BOLD,15);
	Font txtfnt=new Font("Bookman Old Style",Font.BOLD,12);

	JScrollPane srptid=new JScrollPane(pttreat,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

	public payment()
	{
		setLayout(null);
		setVisible(true);
		this.getContentPane().setBackground(Color.WHITE);
		setSize((int)di.getWidth(),(int)di.getHeight());
		setResizable(false);
		getContentPane().setBackground(Color.WHITE);

		lbl.setBounds(0,0,getWidth(),getHeight());
		
		phead.setBounds(400,30,380,30);
		phead.setFont(new Font("castellar",1,25));
		phead.setForeground(new Color(207,58,88));
		
		pdate.setBounds(900,80,100,30);
		pdate.setFont(lblfnt);
		ptdate.setBounds(1020,80,100,30);
		ptdate.setFont(txtfnt);
		
		pid.setBounds(200,130,100,30);
		pid.setFont(lblfnt);
		ptid.setBounds(320,130,100,30);
		ptid.setFont(txtfnt);
		
		pbid.setBounds(200,180,100,30);
		pbid.setFont(lblfnt);
		ptbid.setBounds(320,180,100,30);
		ptbid.setFont(txtfnt);
		
		puser.setBounds(200,230,100,30);
		puser.setFont(lblfnt);
		
		rcust.setBounds(310,230,110,30);
		rcust.setFont(lblfnt);
		rmem.setBounds(420,230,100,30);
		rmem.setFont(lblfnt);
		
		pcmid.setBounds(200,280,190,30);
		pcmid.setFont(lblfnt);
		ptcmid.setBounds(390,280,100,30);
		ptcmid.setFont(txtfnt);
		
		pname.setBounds(200,330,100,30);
		pname.setFont(lblfnt);
		ptname.setBounds(320,330,150,30);
		ptname.setFont(txtfnt);
		
		pcont.setBounds(200,380,100,30);
		pcont.setFont(lblfnt);
		
		pmob.setBounds(230,430,100,30);
		pmob.setFont(lblfnt);
		ptmob.setBounds(340,430,100,30);
		ptmob.setFont(txtfnt);
		
		pemail.setBounds(230,470,100,30);
		pemail.setFont(lblfnt);
		ptemail.setBounds(340,470,180,30);
		ptemail.setFont(txtfnt);
		
		ptreat.setBounds(200,520,180,30);
		ptreat.setFont(lblfnt);
		srptid.setBounds(390,520,120,80);
		pttreat.setFont(txtfnt);
		
		ptcost.setBounds(600,130,100,30);
		ptcost.setFont(lblfnt);
		ptc.setBounds(720,130,100,30);
		ptc.setFont(txtfnt);
		
		pad.setBounds(600,180,120,30);
		pad.setFont(lblfnt);
		ptad.setBounds(720,180,100,30);
		ptad.setFont(txtfnt);
		
		pout.setBounds(600,230,170,30);
		pout.setFont(lblfnt);
		ptout.setBounds(770,230,100,30);
		ptout.setFont(txtfnt);
		
		paymode.setBounds(600,280,120,30);
		paymode.setFont(lblfnt);
		rch.setBounds(720,280,100,30);
		rch.setFont(lblfnt);
		rcash.setBounds(840,280,100,30);
		rcash.setFont(lblfnt);
	
		pamt.setBounds(600,320,100,30);
		pamt.setFont(lblfnt);
		ptamt.setBounds(720,320,100,30);
		ptamt.setFont(txtfnt);
		
		pbank.setBounds(600,370,100,30);
		pbank.setFont(lblfnt);
		ptbank.setBounds(720,370,120,30);
		ptbank.setFont(txtfnt);
		
		pbr.setBounds(600,420,120,30);
		pbr.setFont(lblfnt);
		ptbr.setBounds(720,420,150,30);
		ptbr.setFont(txtfnt);
		
		pch.setBounds(600,470,100,30);
		pch.setFont(lblfnt);
		ptch.setBounds(720,470,120,30);
		ptch.setFont(txtfnt);
		
		pchdt.setBounds(600,520,120,30);
		pchdt.setFont(lblfnt);
		ptchdt.setBounds(720,520,100,30);
		ptchdt.setFont(txtfnt);
		
		pdt.setBounds(600,570,120,30);
		pdt.setFont(lblfnt);
		ptdt.setBounds(720,570,100,30);
		ptdt.setFont(txtfnt);
		
		pnew.setBounds(180,650,120,30);
		pnew.setFont(btfnt);
		psave.setBounds(320,650,120,30);
		psave.setFont(btfnt);
		pbill.setBounds(460,650,150,30);
		pbill.setFont(btfnt);
		pcancel.setBounds(630,650,120,30);
		pcancel.setFont(btfnt);
	
		add(pdt);
		add(ptdt);
		bt.add(rcust);
		bt.add(rmem);
		bm.add(rch);
		bm.add(rcash);
		add(ptbid);
		add(pbank);
		add(ptbank);
		add(pbill);
		add(pbid);
		add(pamt);
		add(ptreat);
		add(srptid);
		add(ptamt);
		add(pchdt);
		add(ptchdt);
		add(pch);
		add(ptch);
		add(pbr);
		add(ptbr);
		add(paymode);
		add(rch);
		add(rcash);
		add(pout);
		add(ptout);
		add(ptcost);
		add(pad);
		add(ptad);
		add(pnew);
		add(psave);
		add(pcancel);
		add(ptc);
		add(pcont);
		add(pmob);
		add(ptmob);
		add(pemail);
		add(ptemail);
		add(pcmid);
		add(ptcmid);
		add(pname);
		add(ptname);
		add(puser);
		add(rcust);
		add(rmem);
		add(pid);
		add(ptid);
		add(ptdate);
		add(pdate);
		add(phead);
		
		add(lbl);
		repaint();
		
		pnew.addActionListener(this);
		psave.addActionListener(this);
		pcancel.addActionListener(this);
		pbill.addActionListener(this);
		rch.addItemListener(this);
		rcash.addItemListener(this);
		ptbid.addFocusListener(this);
		ptad.addFocusListener(this);
		ptamt.addFocusListener(this);
		pbr.setVisible(false);
		ptbr.setVisible(false);
		pamt.setVisible(false);
		ptamt.setVisible(false);
		pch.setVisible(false);
		ptch.setVisible(false);
		ptchdt.setVisible(false);
		pchdt.setVisible(false);
		pbank.setVisible(false);
		ptbank.setVisible(false);
		ptdt.setVisible(false);
		pdt.setVisible(false);
		ptdate.setText(""+cal.get(Calendar.DATE)+"/"+(cal.get(Calendar.MONTH)+1)+"/"+cal.get(Calendar.YEAR));
		
		///Validation
		ptid.setEditable(false);
		ptcmid.setEditable(false);
		ptname.setEditable(false);
		ptmob.setEditable(false);
		ptemail.setEditable(false);
		pttreat.setEditable(false);
		ptc.setEditable(false);
		ptad.setEditable(false);
		ptout.setEditable(false);
		ptdate.setEditable(false);
		
		psave.setEnabled(false);
		ptdt.addFocusListener(this);
		ptchdt.addFocusListener(this);
	}
	public void cheque()
	{
		if(rch.isSelected()==true)
		{
			pbr.setVisible(true);
			ptbr.setVisible(true);
			pamt.setVisible(true);
			ptamt.setVisible(true);
			pch.setVisible(true);
			ptch.setVisible(true);
			ptchdt.setVisible(true);
			pchdt.setVisible(true);
			pbank.setVisible(true);
			ptbank.setVisible(true);
			ptdt.setVisible(true);
			pdt.setVisible(true);
		}
		else
		{
			pbr.setVisible(false);
			ptbr.setVisible(false);
			pamt.setVisible(true);
			ptamt.setVisible(true);
			pch.setVisible(false);
			ptch.setVisible(false);
			ptchdt.setVisible(false);
			pchdt.setVisible(false);
			pbank.setVisible(false);
			ptbank.setVisible(false);
			ptdt.setVisible(false);
			pdt.setVisible(false);
		}
	}
	public void cash()
	{
		if(rcash.isSelected()==true)
		{
			pamt.setVisible(true);
			ptamt.setVisible(true);
			pbr.setVisible(false);
			ptbr.setVisible(false);
			pch.setVisible(false);
			ptch.setVisible(false);
			ptchdt.setVisible(false);
			pchdt.setVisible(false);
			pbank.setVisible(false);
			ptbank.setVisible(false);
			ptdt.setVisible(false);
			pdt.setVisible(false);
		}
		else
		{
			pbr.setVisible(true);
			ptbr.setVisible(true);
			pamt.setVisible(true);
			ptamt.setVisible(true);
			pch.setVisible(true);
			ptch.setVisible(true);
			ptchdt.setVisible(true);
			pchdt.setVisible(true);
			ptbank.setVisible(true);
			pbank.setVisible(true);
			ptdt.setVisible(true);
			pdt.setVisible(true);
		}
	}
	public void itemStateChanged(ItemEvent ie)
	{
		if(ie.getSource()==rch||ie.getSource()==rcash)
		{
			if(ie.getStateChange()==ItemEvent.SELECTED)
			{
				cheque();
				cash();
			}
		}
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==pnew)
		{
			int ctr=0;
			try
			{
				Connection con=DriverManager.getConnection("jdbc:odbc:SpaSystemdsn");
				Statement st=con.createStatement();
				ResultSet res=st.executeQuery("Select * from keytbl");
				while(res.next())
				{
					ctr=Integer.parseInt(res.getString(12));
				}
				if(ctr<10)
					ptid.setText("Py00"+ctr);
				if(ctr>9&&ctr<100)
					ptid.setText("Py0"+ctr);
				
				bt.clearSelection();
				ptcmid.setText("");
				ptname.setText("");
				ptmob.setText("");
				ptemail.setText("");
				pttreat.setText("");
				ptc.setText("");
				ptad.setText("");
				ptout.setText("");
				bm.clearSelection();
				ptbid.setText("");
				ptamt.setText("");
				ptbank.setText("");
				ptbr.setText("");
				ptch.setText("");
				ptchdt.setText("");
				ptdt.setText(ptdate.getText());
				
				pbank.setVisible(false);
				ptbank.setVisible(false);
				pamt.setVisible(false);
				ptamt.setVisible(false);
				pbr.setVisible(false);
				ptbr.setVisible(false);
				pch.setVisible(false);
				ptch.setVisible(false);
				ptchdt.setVisible(false);
				pchdt.setVisible(false);
				psave.setEnabled(true);
			}
			catch(Exception ee)
			{
				System.out.println(ee);
			}
		}
		if(e.getSource()==psave)
		{
			int flg=0;
			String tam="";
			try
			{
				Connection con=DriverManager.getConnection("jdbc:odbc:SpaSystemdsn");
				String str="insert into paymenttbl(payid,bookid,cust_mem_id,treatid,pamount,tamount,dop,chequeno,chequedt,bankname,branch)values(?,?,?,?,?,?,?,?,?,?,?)";				
				PreparedStatement ps=con.prepareStatement(str);
				if(ptid.getText().length()==0||ptbid.getText().length()==0||bt.getSelection()==null||ptcmid.getText().length()==0||ptname.getText().length()==0||ptmob.getText().length()==0||ptemail.getText().length()==0||pttreat.getText().length()==0||ptdt.getText().length()==0||ptc.getText().length()==0||bm.getSelection()==null||ptamt.getText().length()==0)
				{
					JOptionPane.showMessageDialog(null,"Empty Fields!!!");
					flg=1;
				}		
				else
				{
					if(rmem.isSelected())
					{
						if(ptad.getText().length()==0||ptout.getText().length()==0)
						{
							JOptionPane.showMessageDialog(null,"Empty Fields!!!");
							flg=1;
						}
					}
					if(rch.isSelected())
					{
						if(ptbank.getText().length()==0||ptbr.getText().length()==0||ptch.getText().length()==0||ptchdt.getText().length()==0)
						{
							JOptionPane.showMessageDialog(null,"Empty Fields!!!");
							flg=1;							
						}	
					}
				try
				{
					double ad=Double.parseDouble(ptc.getText());
					double m=Double.parseDouble(ptamt.getText());
					if(rmem.isSelected()==true)
					{
						double t=Double.parseDouble(ptout.getText());
						if(m<=0)
						{
						
							throw new Exception("InvalidAmt");							
						}
						if(m>t)
						{
						flg=1;						
						JOptionPane.showMessageDialog(null,"Amount Exceeds!!!");
							ptamt.setText("");
						}
					}
					if(rcust.isSelected()==true)
					{
						if(m<=0)
						{
							throw new Exception("InvalidAmt");							
						}
						if(m>ad)
						{
									flg=1;							
							JOptionPane.showMessageDialog(null,"Amount Exceeds!!");
							ptamt.setText("");
						}
						else
						{
							if(Double.parseDouble(ptc.getText())==Double.parseDouble(ptamt.getText()))
							{
							}
							else
							{
								throw new Exception("NotValidAmt");
							}
						}
					}						
				}
				catch(Exception ee)
				{
								flg=1;						
					if(ee.getMessage().equals("InvalidAmt"))
						JOptionPane.showMessageDialog(null,"Invalid Amount Entered!!");
					if(ee.getMessage().equals("NotValidAmt"))
						JOptionPane.showMessageDialog(null,"Not Eligible for Half Payment!!");
					ptamt.setText("");					
				}					
				}
				if(flg==0)
				{	
					ps.setString(1,ptid.getText());
					ps.setString(2,ptbid.getText());
					ps.setString(3,ptcmid.getText());
					ps.setString(4,pttreat.getText());
					ps.setString(5,ptamt.getText());
					if(rcust.isSelected())
					{
						tam=""+Double.parseDouble(ptamt.getText());
					}
					else
					{
						tam=""+(Double.parseDouble(ptad.getText())+Double.parseDouble(ptamt.getText()));
					}
					ps.setString(6,tam);
					ps.setString(7,ptdt.getText());
					ps.setString(8,ptch.getText());
					ps.setString(9,ptchdt.getText());
					ps.setString(10,ptbank.getText());
					ps.setString(11,ptbr.getText());
					ps.executeUpdate();
				
					Statement st=con.createStatement();
					String str1="update keytbl set paymentid=paymentid+1";
					st.executeUpdate(str1);
					
					st.executeUpdate("update bookingtbl set pystate='Paid' where bookid='"+ptbid.getText()+"'");
					JOptionPane.showMessageDialog(null,"Saved..");
					bt.clearSelection();
					ptid.setText("");
					ptcmid.setText("");
					ptname.setText("");
					ptmob.setText("");
					ptemail.setText("");
					pttreat.setText("");
					ptc.setText("");
					ptad.setText("");
					ptout.setText("");
					bm.clearSelection();	
					ptbid.setText("");
					ptamt.setText("");
					ptbank.setText("");
					ptbr.setText("");
					ptch.setText("");
					ptchdt.setText("");
					ptdt.setText("");
					psave.setEnabled(false);
				}
			}
			catch(Exception ee)
			{
				System.out.println(ee);
			}
		}
		if(e.getSource()==pcancel)
		{
			this.dispose();
		}
		if(e.getSource()==pbill)
		{
			int t=0;
			String tt="",t1="";
			try
			{
				Connection con=DriverManager.getConnection("jdbc:odbc:SpaSystemdsn");
				Statement st=con.createStatement();
				ResultSet res=st.executeQuery("select * from keytbl");
				while(res.next())
				{
					t=Integer.parseInt(res.getString(12))-1;
				}
				res.close();
				p:{
					while(t>1)
					{
						if(t<10)
							tt="Py00"+t;
						if(t>=10&&t<100)
							tt="Py0"+t;
						if(t>=100)
							tt="Py"+t;
				
						res=st.executeQuery("select * from paymenttbl");					
						while(res.next())
						{
							if(tt.equals(res.getString(1)))
							{
								t1=res.getString(2);
								break p;
							}
						}
						t--;
					}
				}
				prbill probj=new prbill(t1);
			}
			catch(Exception ee)
			{
				System.out.println(ee);
			}
		}
	}
	public void focusLost(FocusEvent fe)
	{
		if(fe.getComponent()==ptbid)
		{
			int flg=0;
			bt.clearSelection();
			ptcmid.setText("");
			ptname.setText("");
			ptmob.setText("");
			ptemail.setText("");
			pttreat.setText("");
			ptad.setText("");
			ptout.setText("");
			ptc.setText("");
			String str1="";
			String str2="";
			try
			{
				if(ptbid.getText().length()!=0)
				{
					Connection con=DriverManager.getConnection("jdbc:odbc:SpaSystemdsn");
					Statement st= con.createStatement();
					ResultSet res=st.executeQuery("select * from bookingtbl where bookid='"+ptbid.getText()+"'");
					while(res.next())
					{
						flg=1;
						if(res.getString(3).equals("Customer"))
						{
							rcust.setSelected(true);
						}
						else
						{
							rmem.setSelected(true);
						}
						ptcmid.setText(res.getString(4));
						str1=res.getString(6);
						str2=res.getString(7);
						ptc.setText(res.getString(10));
					}
					if(rcust.isSelected()==true)
					{
						pad.setVisible(false);
						ptad.setVisible(false);
						
						ptout.setVisible(false);
						pout.setVisible(false);
						ResultSet res1=st.executeQuery("select * from customertbl where custid='"+ptcmid.getText()+"'");
						while(res1.next())
						{
							ptname.setText(res1.getString(3));
							ptmob.setText(res1.getString(5));
							ptemail.setText(res1.getString(6));
						}
					}
					if(rmem.isSelected()==true)
					{
						ptad.setVisible(true);
						ptout.setVisible(true);
						pad.setVisible(true);
						pout.setVisible(true);
						
						ResultSet res2=st.executeQuery("select * from membertbl where mem_id='"+ptcmid.getText()+"'");
						while(res2.next())
						{
							ptname.setText(res2.getString(3));
							ptmob.setText(res2.getString(8));
							ptemail.setText(res2.getString(9));
						}
							String tp="";
						res=st.executeQuery("select * from paymenttbl where bookid='"+ptbid.getText()+"'");
						while(res.next())
						{
							tp=res.getString(6);
						}
						ptad.setText(tp);
						if(ptad.getText().length()==0)
							ptad.setText("0.0");
						double ad=Double.parseDouble(ptad.getText());
						double ts=Double.parseDouble(ptc.getText());
						double t=ts-ad;
						ptout.setText(""+t);
						
						
					}
					
					if(flg==0)
					{
						JOptionPane.showMessageDialog(null,"Invalid Booking ID..");
						ptbid.setText("");
					}
					else
					{
						if(str1.charAt(0)=='p'||str1.charAt(0)=='P')
						{
							pttreat.setText(str2);
						}
						if(str1.charAt(0)=='T'||str1.charAt(0)=='t')
						{
							String stt="";
							ResultSet res1=st.executeQuery("select * from booktbl where bookid='"+ptbid.getText()+"'" );
							while(res1.next())
							{
								stt=stt+res1.getString(2)+"\n";
							}
							pttreat.setText(stt);	
						}
						
					}
				}
				ptamt.setText("");
				ptch.setText("");
				ptchdt.setText("");
				ptbank.setText("");
				ptbr.setText("");
			}
			catch(Exception ee)
			{
				System.out.println(ee);
			}
		}
		if(fe.getComponent()==ptad)
		{
			if(ptad.getText().length()==0)
			{
			}
			else
			{
				double ad=Double.parseDouble(ptad.getText());
				double ts=Double.parseDouble(ptc.getText());
				double t=ts-ad;
				ptout.setText(""+t);
			}
		}
		if(fe.getComponent()==ptamt)
		{
			if(ptamt.getText().length()==0)
			{
			}
			else
			{
				try
				{
					double ad=Double.parseDouble(ptc.getText());
					double m=Double.parseDouble(ptamt.getText());
					if(rmem.isSelected()==true)
					{
						double t=Double.parseDouble(ptout.getText());
						if(m<=0)
						{
							throw new Exception("InvalidAmt");							
						}
						if(m>t)
						{
							JOptionPane.showMessageDialog(null,"Amount Exceeds!!!");
							ptamt.setText("");
						}
					}
					if(rcust.isSelected()==true)
					{
						if(m<=0)
						{
							throw new Exception("InvalidAmt");							
						}
						if(m>ad)
						{
							JOptionPane.showMessageDialog(null,"Amount Exceeds!!");
							ptamt.setText("");
						}
						else
						{
							if(Double.parseDouble(ptc.getText())==Double.parseDouble(ptamt.getText()))
							{
							}
							else
							{
								throw new Exception("NotValidAmt");
							}
						}
					}						
				}
				catch(Exception ee)
				{
					if(ee.getMessage().equals("InvalidAmt"))
						JOptionPane.showMessageDialog(null,"Invalid Amount Entered!!");
					if(ee.getMessage().equals("NotValidAmt"))
						JOptionPane.showMessageDialog(null,"Not Eligible for Half Payment!!");
					ptamt.setText("");					
				}
			}
		}
		
		if(fe.getComponent()==ptdt)
		{
			strchk=ptdt.getText();
			
			if(ptdt.getText().length()!=0)
			{ 	
				try
				{
					SimpleDateFormat cdf = new SimpleDateFormat("dd/MM/yyyy");
					Date dat = cdf.parse(strchk);
					if (!strchk.equals(cdf.format(dat)))
					{
						JOptionPane.showMessageDialog(null,"Invalid Date Format!!");
						ptdt.setText("");
					}
				}
				catch(Exception ee)
				{
					JOptionPane.showMessageDialog(null,"Invalid Date Format!!");
					ptdt.setText("");
				}
					
			}
		}

		if(fe.getComponent()==ptchdt)
		{
			strchk=ptchdt.getText();
			
			if(ptchdt.getText().length()!=0)
			{ 	
				try
				{
					SimpleDateFormat cdf = new SimpleDateFormat("dd/MM/yyyy");
					Date dat = cdf.parse(strchk);
					if (!strchk.equals(cdf.format(dat)))
					{
						JOptionPane.showMessageDialog(null,"Invalid Date Format!!");
						ptchdt.setText("");
					}
				}
				catch(Exception ee)
				{
					JOptionPane.showMessageDialog(null,"Invalid Date Format!!");
					ptchdt.setText("");
				}
			}
		}
						
	}
	public void focusGained(FocusEvent fe)
	{
	}
	public static void main(String argv[])
	throws IOException
	{
		payment obj=new payment();
	}
}
