import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.*;
import java.sql.*;
import java.util.Date;
import java.util.*;
import java.text.SimpleDateFormat;
public class cancellation extends JFrame implements ActionListener,FocusListener,ItemListener
{
	JLabel lbl=new JLabel(new ImageIcon("../Images/trac.jpg"));		
	
	long nday;
	JLabel canid=new JLabel("Cancellation id");
	JLabel cbookid=new JLabel("Booking id");
	JLabel ccmid=new JLabel("Customer/Member id");
	JLabel cptid=new JLabel("Treatment/Package id");
	JLabel cbookdt=new JLabel("Booking Date");
	JLabel capdate=new JLabel("Appointment Date");
	JLabel ctcost=new JLabel("Total Cost");
	JLabel cpayst=new JLabel("Payment Status");
	JLabel cdate=new JLabel("Date");
	JLabel lhead=new JLabel("CANCELLATION");
	JLabel cdeduct=new JLabel("Deduction Percentage");
	JLabel cdeductf=new JLabel("Deduction Fund");
	JLabel crefund=new JLabel("Refund");
	JLabel cnday=new JLabel("Cancel Days");
	JLabel ccandt=new JLabel("Cancellation Date");
	JLabel cpaid=new JLabel("Paid Money");	
	
	JTextField tcanid=new JTextField();
	JTextField tbookid=new JTextField();
	JTextField tcmid=new JTextField();
	JTextArea tptid=new JTextArea();
	JTextField tbookdt=new JTextField();
	JTextField tapdate=new JTextField();
	JTextField ttcost=new JTextField();
	JTextField tdate=new JTextField();
	JTextField tdeduct=new JTextField();
	JTextField tdeductf=new JTextField();
	JTextField trefund=new JTextField();
	JTextField tnday=new JTextField();
	JTextField tcandt=new JTextField();
	JTextField tpaid=new JTextField();
	
	JRadioButton rpay=new JRadioButton("Paid");
	JRadioButton rnpay=new JRadioButton("Not Paid");
	ButtonGroup bp=new ButtonGroup();
	
	JButton cnew=new JButton("New",new ImageIcon("../Images/nbt.jpg"));
	JButton ccanb=new JButton("Cancel Booking",new ImageIcon("../Images/cbbt.jpg"));
	JButton csearch=new JButton("Search",new ImageIcon("../Images/sbtn.jpg"));
	JButton ccancel=new JButton("Cancel",new ImageIcon("../Images/cbt.jpg"));
	
	Calendar cal=Calendar.getInstance();
	int cflg=0;
	String strchk="";

	Dimension di=Toolkit.getDefaultToolkit().getScreenSize();

	///Fonts......
	Font btfnt=new Font("Consolas",Font.BOLD,15);
	Font lblfnt=new Font("Bookman Old Style",Font.BOLD,15);
	Font txtfnt=new Font("Bookman Old Style",Font.BOLD,12);

	JScrollPane srptid=new JScrollPane(tptid,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	
	public cancellation()
	{
		setLayout(null);
		setVisible(true);
		this.getContentPane().setBackground(Color.WHITE);
		setSize((int)di.getWidth(),(int)di.getHeight());
		setResizable(false);
		getContentPane().setBackground(Color.WHITE);

		lbl.setBounds(0,0,getWidth(),getHeight());
		
		lhead.setBounds(500,50,300,30);
		lhead.setFont(new Font("castellar",1,25));
		lhead.setForeground(new Color(181,230,29));
		
		cdate.setBounds(900,100,100,30);
		cdate.setFont(lblfnt);
		tdate.setBounds(980,100,100,30);
		tdate.setFont(txtfnt);
		
		canid.setBounds(300,150,150,30);
		canid.setFont(lblfnt);
		tcanid.setBounds(470,150,100,30);
		tcanid.setFont(txtfnt);
		
		ccandt.setBounds(300,200,150,30);
		ccandt.setFont(lblfnt);
		tcandt.setBounds(470,200,100,30);
		tcandt.setFont(txtfnt);
		
		cbookid.setBounds(300,250,150,30);
		cbookid.setFont(lblfnt);
		tbookid.setBounds(470,250,100,30);
		tbookid.setFont(txtfnt);
		
		ccmid.setBounds(300,300,180,30);
		ccmid.setFont(lblfnt);
		tcmid.setBounds(500,300,100,30);
		tcmid.setFont(txtfnt);
		
		cptid.setBounds(300,350,180,30);
		cptid.setFont(lblfnt);
		srptid.setBounds(500,350,100,90);
		tptid.setFont(txtfnt);
		
		cbookdt.setBounds(300,450,150,30);
		cbookdt.setFont(lblfnt);
		tbookdt.setBounds(470,450,100,30);
		tbookdt.setFont(txtfnt);
		
		capdate.setBounds(300,500,150,30);
		capdate.setFont(lblfnt);
		tapdate.setBounds(470,500,100,30);
		tapdate.setFont(txtfnt);
		
		ctcost.setBounds(300,550,150,30);
		ctcost.setFont(lblfnt);
		ttcost.setBounds(470,550,100,30);
		ttcost.setFont(txtfnt);
		
		cpayst.setBounds(300,600,150,30);
		cpayst.setFont(lblfnt);
		rpay.setBounds(470,600,100,30);
		rpay.setFont(lblfnt);
		rnpay.setBounds(590,600,100,30);
		rnpay.setFont(lblfnt);
		
		cpaid.setBounds(700,150,150,30);
		tpaid.setBounds(870,150,100,30);

		cnday.setBounds(700,200,150,30);
		cnday.setFont(lblfnt);
		tnday.setBounds(870,200,100,30);
		tnday.setFont(txtfnt);
		
		cdeduct.setBounds(700,250,180,30);
		cdeduct.setFont(lblfnt);
		tdeduct.setBounds(880,250,100,30);
		tdeduct.setFont(txtfnt);
		
		cdeductf.setBounds(700,300,150,30);
		tdeductf.setBounds(870,300,100,30);

		crefund.setBounds(700,350,150,30);
		crefund.setFont(lblfnt);
		trefund.setBounds(870,350,100,30);
		trefund.setFont(txtfnt);
	
		add(cpaid);
		add(tpaid);
		add(ccandt);
		add(tcandt);
		add(crefund);
		add(trefund);
		add(cdeductf);
		add(tdeductf);
		add(cdeduct);
		add(tdeduct);
		add(lhead);
		add(cdate);
		add(tdate);
		add(canid);
		add(tcanid);
		add(cbookid);
		add(tbookid);
		add(ccmid);
		add(tcmid);
		add(cptid);
		add(srptid);
		add(cbookdt);
		add(tbookdt);
		add(capdate);
		add(tapdate);
		add(ctcost);
		add(ttcost);
		add(cpayst);
		add(rpay);
		add(rnpay);
		bp.add(rpay);
		bp.add(rnpay);
		add(cnew);
		add(ccanb);
		add(csearch);
		add(ccancel);
		add(cnday);
		add(tnday);
		
		cnew.setBounds(230,650,120,30);
		cnew.setFont(btfnt);
		ccanb.setBounds(370,650,180,30);
		ccanb.setFont(btfnt);
		csearch.setBounds(570,650,120,30);
		csearch.setFont(btfnt);
		ccancel.setBounds(710,650,120,30);	
		ccancel.setFont(btfnt);
		
		tdate.setText(""+cal.get(Calendar.DATE)+"/"+(cal.get(Calendar.MONTH)+1)+"/"+cal.get(Calendar.YEAR));
	
		add(lbl);
		repaint();
		
		cnew.addActionListener(this);
		ccanb.addActionListener(this);
		csearch.addActionListener(this);
		ccancel.addActionListener(this);
		rpay.addActionListener(this);
		rnpay.addActionListener(this);
		tbookid.addFocusListener(this);
		rpay.addItemListener(this);
		rnpay.addItemListener(this);
		
		cnday.setVisible(false);
		tnday.setVisible(false);
		cdeduct.setVisible(false);
		tdeduct.setVisible(false);
		tdeductf.setVisible(false);
		cdeductf.setVisible(false);
		crefund.setVisible(false);
		trefund.setVisible(false);
		cpaid.setVisible(false);
		tpaid.setVisible(false);


		//Validation....
			ccanb.setEnabled(false);
			tcanid.setEditable(false);
			tcmid.setEditable(false);
			tptid.setEditable(false);
			tbookdt.setEditable(false);
			tapdate.setEditable(false);
			tdate.setEditable(false);
			ttcost.setEditable(false);
			tpaid.setEditable(false);
			tnday.setEditable(false);
			tdeduct.setEditable(false);
			tdeductf.setEditable(false);
			trefund.setEditable(false);
			tcandt.addFocusListener(this);
	}
	public void display()
	{
		if(rpay.isSelected()==true)
		{
			cnday.setVisible(true);
			tnday.setVisible(true);
			cdeduct.setVisible(true);
			tdeduct.setVisible(true);
			tdeductf.setVisible(true);
			cdeductf.setVisible(true);
			crefund.setVisible(true);
			trefund.setVisible(true);
			cpaid.setVisible(true);
			tpaid.setVisible(true);	
		}
		else
		{
			cnday.setVisible(false);
			tnday.setVisible(false);
			cdeduct.setVisible(false);
			tdeduct.setVisible(false);
			tdeductf.setVisible(false);
			cdeductf.setVisible(false);
			crefund.setVisible(false);
			trefund.setVisible(false);
			cpaid.setVisible(false);
			tpaid.setVisible(false);
		}
	}
	public void itemStateChanged(ItemEvent ie)
	{
		if(ie.getSource()==rpay||ie.getSource()==rnpay)
		{
			if(ie.getStateChange()==ItemEvent.SELECTED)
			{
				display();
			}
		}
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==cnew)
		{
			cflg=0;
			int ctr=0;
			tcanid.setText("");
			tbookid.setText("");
			tcmid.setText("");
			tptid.setText("");
			tbookdt.setText("");
			tapdate.setText("");
			ttcost.setText("");
			bp.clearSelection();
			tdeduct.setText("");
			tdeductf.setText("");
			trefund.setText("");
			tpaid.setText("");
			display();
			try
			{
				Connection con=DriverManager.getConnection("jdbc:odbc:SpaSystemdsn");
				Statement st=con.createStatement();
				String str="select * from keytbl";
				ResultSet res=st.executeQuery(str);
				while(res.next())
				{
					ctr=Integer.parseInt(res.getString(11));
				}
				if(ctr<10)
					tcanid.setText("CN00"+ctr);
				if(ctr<100&&ctr>9)
					tcanid.setText("CN0"+ctr);
				if(ctr<1000&&ctr>99)
					tcanid.setText("CN"+ctr);
				
				ccanb.setEnabled(true);
				tcandt.setText(tdate.getText());
			}
			catch(Exception ee)
			{
				System.out.println(ee);
			}
		}

		if(e.getSource()==ccanb)
		{
			int flg=0;
			try
			{
				Connection con=DriverManager.getConnection("jdbc:odbc:SpaSystemdsn");
				String str="insert into canceltbl(canceldate,bookdate,canid,bookid,cust_mem_id,appointdate,treat_pack_id,totalcost,paystat,ndays,deductfund,refund,pyamt,staffid,stime,etime) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				PreparedStatement ps=con.prepareStatement(str);
				
				if(tcanid.getText().length()==0||tcandt.getText().length()==0||tbookid.getText().length()==0||tcmid.getText().length()==0||tptid.getText().length()==0||tbookdt.getText().length()==0||tapdate.getText().length()==0||ttcost.getText().length()==0||bp.getSelection()==null)
				{
					JOptionPane.showMessageDialog(null,"Empty Fields!!");
					flg=1;
				}
				else
				{
					if(rpay.isSelected())
					{
						if(tpaid.getText().length()==0||tnday.getText().length()==0||tdeduct.getText().length()==0||tdeductf.getText().length()==0||trefund.getText().length()==0)
						{
							JOptionPane.showMessageDialog(null,"Empty Fields!!");
							flg=1;					
						}
						else
						{
							if(cflg==1)
							{
								JOptionPane.showMessageDialog(null,"Date for Cancellation Expired!!");
								flg=1;
							}														
						}
					}
					else
					{
						if(cflg==1)
						{
							JOptionPane.showMessageDialog(null,"Date for Cancellation Expired!!");
							flg=1;
						}							
					}
					
				}
				if(flg==0)
				{			
					ps.setString(1,tdate.getText());
					ps.setString(2,tbookdt.getText());
					ps.setString(3,tcanid.getText());
					ps.setString(4,tbookid.getText());
					ps.setString(5,tcmid.getText());
					ps.setString(6,tapdate.getText());
					ps.setString(7,tptid.getText());
					ps.setString(8,ttcost.getText());
					String tmp="";
					if(rpay.isSelected()==true)
					{
						tmp="Paid";
						ps.setString(9,tmp);
						ps.setString(10,tnday.getText());
						ps.setString(11,tdeductf.getText());
						ps.setString(12,trefund.getText());
						ps.setString(13,tpaid.getText());
					}
					else
					{
						tmp="Not Paid";
						ps.setString(9,tmp);
						ps.setString(10,"");
						ps.setString(11,"");
						ps.setString(12,"");
						ps.setString(13,"");
					}
					
					String start="",end="",strs="";
					Statement st=con.createStatement();
					ResultSet res=st.executeQuery("select * from bookingtbl where bookid='"+tbookid.getText()+"'");
					while(res.next())
					{
						strs=res.getString(11);
						start=res.getString(13);
						end=res.getString(14);
					}
					res.close();
					
					ps.setString(14,strs);
					ps.setString(15,start);
					ps.setString(16,end);
					ps.executeUpdate();
					
					st=con.createStatement();
					str="update keytbl set cancelid=cancelid+1";
					st.executeUpdate(str);
					
					
					st=con.createStatement();
					st.executeUpdate("delete * from scheduletbl where staffid='"+strs+"' and bookid='"+tbookid.getText()+"'");
					
					st=con.createStatement();
					str="delete * from bookingtbl where bookid='"+tbookid.getText()+"'";
					st.executeUpdate(str);
					if(tptid.getText().charAt(0)=='p'||tptid.getText().charAt(0)=='P')
					{
					}
					else
					{
						str="delete * from booktbl where bookid='"+tbookid.getText()+"'";
						st.executeUpdate(str);
					}
					
					JOptionPane.showMessageDialog(null,"Booking Cancelled Successfully!!");

					tcanid.setText("");
					tbookid.setText("");
					tcmid.setText("");
					tptid.setText("");
					tbookdt.setText("");
					tapdate.setText("");
					ttcost.setText("");
					bp.clearSelection();
					tdeduct.setText("");		
					tdeductf.setText("");
					trefund.setText("");
					tcandt.setText("");
					tpaid.setText("");
			
					cnday.setVisible(false);
					tnday.setVisible(false);
					cdeduct.setVisible(false);
					tdeduct.setVisible(false);
					tdeductf.setVisible(false);
					cdeductf.setVisible(false);
					crefund.setVisible(false);
					trefund.setVisible(false);
					ccanb.setEnabled(false);
				}
			}
			catch(Exception ee)
			{
				System.out.println(ee);
			}
		}
		if(e.getSource()==csearch)
		{
			String tm="";
			int flg=0;
			ccanb.setEnabled(false);
			try
			{
				tm=JOptionPane.showInputDialog("Enter Cancellation ID: ");
				Connection con=DriverManager.getConnection("jdbc:odbc:SpaSystemdsn");
				Statement st=con.createStatement();
				String str="select * from canceltbl where canid='"+tm+"'";
				ResultSet res=st.executeQuery(str);
				String s="";
				while(res.next())
				{
					flg=1;
					tcandt.setText(res.getString(1));
					tbookdt.setText(res.getString(2));
					tbookid.setText(res.getString(4));
					tcanid.setText(res.getString(3));
					tcmid.setText(res.getString(5));
					tapdate.setText(res.getString(6));
					tptid.setText(res.getString(7));
					ttcost.setText(res.getString(8));
					s=res.getString(9);
					if(s.equals("Paid"))
					{
						rpay.setSelected(true);
						display();
					}
					else
					{
						rnpay.setSelected(true);
						display();
					}
					
					tnday.setText(res.getString(10));
					tdeductf.setText(res.getString(11));
					trefund.setText(res.getString(12));
					tpaid.setText(res.getString(13));
					nday=Integer.parseInt(tnday.getText());
					int n=0;
					if(nday>=1 && nday<=10)
					{
						n=30;
						tdeduct.setText("30%");
					}
					else if(nday>=11 && nday<=15)
					{
						n=20;
						tdeduct.setText("20%");
					}
					else if(nday<=20)
					{
						n=15;
						tdeduct.setText("15%");
					}
					else
					{
						n=5;
						tdeduct.setText("5%");
					}
				}
				if(flg==0)
				{
						JOptionPane.showMessageDialog(null,"Data Not Found");
						tcandt.setText("");
						tcanid.setText("");
						tbookid.setText("");
						tcmid.setText("");
						tptid.setText("");
						tbookdt.setText("");
						tapdate.setText("");
						ttcost.setText("");
						bp.clearSelection();
						tpaid.setText("");
						tnday.setText("");
						tdeduct.setText("");
						tdeductf.setText("");
						trefund.setText("");
						tpaid.setText("");
						display();
					}
			}
			catch(Exception ee)
			{
				System.out.println(ee);
			}
		}
		
		if(e.getSource()==ccancel)
		{
			this.dispose();
		}
	}
	public void focusGained(FocusEvent fe)
	{
	}
	public void focusLost(FocusEvent fe)
	{
		if(fe.getComponent()==tbookid)
		{
			int flg=0;
			cflg=0;
			String tmp="";
			tcmid.setText("");
			tptid.setText("");
			tbookdt.setText("");
			tapdate.setText("");
			ttcost.setText("");
			bp.clearSelection();
			tdeduct.setText("");
			tdeductf.setText("");
			trefund.setText("");
			tnday.setText("");
			String tmpid="",tm="",ttr="",ttp;
			try
			{
				Connection con=DriverManager.getConnection("jdbc:odbc:SpaSystemdsn");
				Statement st=con.createStatement();
				String str="select * from bookingtbl where bookid='"+tbookid.getText()+"'";
				ResultSet res=st.executeQuery(str);
				while(res.next())
				{
					flg=1;
					tbookid.setText(res.getString(2));
					tcmid.setText(res.getString(4));
					tmp=res.getString(6);
					tmpid=res.getString(7);
					tbookdt.setText(res.getString(1));
					tapdate.setText(res.getString(5));
					ttcost.setText(res.getString(10));
					tm=res.getString(15);
					if(tm.equals("Paid"))
					{
						rpay.setSelected(true);
					}
					else
					{
						rnpay.setSelected(true);
					}
				}

				if(flg==1)
				{
					Double pamt=0.0;
					ResultSet res1=st.executeQuery("select * from paymenttbl where bookid='"+tbookid.getText()+"'");
					while(res1.next())
					{
						pamt=pamt+Double.parseDouble(res1.getString(5));
					}
					tpaid.setText(""+pamt);
					
					///Comma validation
					String stt="";
					if(tmp.equals("Treatment"))
					{
						res1=st.executeQuery("select * from booktbl where bookid='"+tbookid.getText()+"'" );
						while(res1.next())
						{
							stt=stt+res1.getString(2)+"\n";
						
						}
						tptid.setText(stt);
					}
					if(tmp.equals("Package"))
					{
						tptid.setText(tmpid);
					}
					
					SimpleDateFormat formatter=new SimpleDateFormat("dd/MM/yyyy");
					Date ndate=formatter.parse(tdate.getText());
					Date napdate=formatter.parse(tapdate.getText());
					long x=napdate.getTime()-ndate.getTime();
					nday=x/86400000;
					if(nday>0)
					{
						tnday.setText(""+nday);
						int n=0;
						if(nday>=1 && nday<=10)
						{
							n=30;
							tdeduct.setText("30%");
						}
						else if(nday>=11 && nday<=15)
						{
							n=20;
							tdeduct.setText("20%");
						}
						else if(nday<=20)
						{
							n=15;
							tdeduct.setText("15%");
						}
						else
						{
							n=5;
							tdeduct.setText("5%");
						}
						Double db=Double.parseDouble(tpaid.getText())*((double)n/100);
						tdeductf.setText(""+db);
						trefund.setText(""+(Double.parseDouble(tpaid.getText())-db));
					}
					else
					{
						cflg=1;
						tnday.setText("0");
						tdeduct.setText("0");
						tdeductf.setText("0");
						trefund.setText("0");
					}
				}
				else
				{
					if(tbookid.getText().length()!=0)
					{
						JOptionPane.showMessageDialog(null,"Invalid Booking ID!!");
						tbookid.setText("");
					}
				}
			}
			catch(Exception ee)
			{
				System.out.println(ee);
			}			
		}

		if(fe.getComponent()==tcandt)
		{
			strchk=tcandt.getText();
			
			if(tcandt.getText().length()!=0)
			{ 	
				try
				{
					SimpleDateFormat cdf = new SimpleDateFormat("dd/MM/yyyy");
					Date dat = cdf.parse(strchk);
					if (!strchk.equals(cdf.format(dat)))
					{
						JOptionPane.showMessageDialog(null,"Invalid Date Format!!");
						tcandt.setText("");
					}
				}
				catch(Exception ee)
				{
					JOptionPane.showMessageDialog(null,"Invalid Date Format!!");
					tcandt.setText("");
				}		
			}
		}
		
	}
	public static void main(String argv[])
	throws IOException
	{
		cancellation obj=new cancellation();
	}
}

