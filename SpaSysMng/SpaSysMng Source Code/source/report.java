import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.*;
import java.io.*;
import java.sql.*;
import java.util.*;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;

public class report extends JFrame implements ActionListener,ItemListener,FocusListener
{
	
	JLabel lbl=new JLabel(new ImageIcon("../Images/bg1.jpeg"));
	
	JLabel ltype=new JLabel("Report On");
	JLabel lsearch=new JLabel("Report");
	JLabel lsby=new JLabel("Report By");
	JLabel ldate=new JLabel("Date");
	
	
	JTextField tsearch=new JTextField();
	JTextField tdate=new JTextField();
	
	JRadioButton rpbook=new JRadioButton("Booking");
	JRadioButton rpcan=new JRadioButton("Cancellatin");
	ButtonGroup bg=new ButtonGroup();
	
	JComboBox mtype=new JComboBox();
	JComboBox month=new JComboBox();
	
	JButton brefresh=new JButton("Refresh");
	JButton bprint=new JButton("Print");
	JButton bcan=new JButton("Cancel");

	///Table for Booking
	JTable tbl;
	String []col={"S.No.","Booking Date","Booking ID","Customer/Member ID","Total Cost"};
	String bno,bdt,bid,bcmid,bcost;
	Object[][]data={{bno,bdt,bid,bcmid,bcost}};
	DefaultTableModel model=new DefaultTableModel(col,0);
	
	///Table for Cancelellation
	JTable tbl1;
	String []col1={"S.No.","Cancellation Date","Cancellation ID","Booking ID","Customer/Member ID","Total Cost"};
	String cno,cdt,cid,cbid,ccmid,ccost;
	Object[][]data1={{cno,cdt,cid,cbid,ccmid,ccost}};
	DefaultTableModel model1=new DefaultTableModel(col1,0);
	
	JScrollPane bpnl=new JScrollPane();
	JScrollPane cpnl=new JScrollPane();
		
	Calendar cal=Calendar.getInstance();
	
	int flg,ctr;
	String strchk="";
	Dimension di=Toolkit.getDefaultToolkit().getScreenSize();	

	///Fonts......
	Font btfnt=new Font("Consolas",Font.BOLD,15);
	Font lblfnt=new Font("Bookman Old Style",Font.BOLD,15);
	Font txtfnt=new Font("Bookman Old Style",Font.BOLD,12);
	
	public report()
	{
		flg=0;
		setLayout(null);
		setVisible(true);
		this.getContentPane().setBackground(Color.WHITE);
		setSize((int)di.getWidth(),(int)di.getHeight());
		setResizable(false);
		getContentPane().setBackground(Color.WHITE);
			
		lbl.setBounds(0,0,getWidth(),getHeight());
		
		ldate.setBounds(900,100,100,30);
		ldate.setFont(lblfnt);
		tdate.setBounds(1010,100,100,30);
		tdate.setFont(txtfnt);
		
		ltype.setBounds(220,200,100,30);
		ltype.setFont(lblfnt);
		rpbook.setBounds(330,200,100,30);
		rpbook.setFont(lblfnt);
		rpbook.setOpaque(false);
		rpcan.setBounds(440,200,120,30);
		rpcan.setFont(lblfnt);
		rpcan.setOpaque(false);
		
		lsby.setBounds(220,250,100,30);
		lsby.setFont(lblfnt);
		mtype.setBounds(330,250,100,30);
		mtype.setFont(txtfnt);
		
		lsearch.setBounds(220,300,150,30);
		lsearch.setFont(lblfnt);
		tsearch.setBounds(380,300,180,30);
		tsearch.setFont(txtfnt);
		month.setBounds(380,300,180,30);
		
		brefresh.setBounds(200,350,120,30);
		bprint.setBounds(330,350,120,30);
		bcan.setBounds(460,350,120,30);
		
		add(ldate);
		add(tdate);
		add(ltype);
		add(rpbook);
		add(rpcan);
		bg.add(rpbook);
		bg.add(rpcan);
		add(lsby);
		add(mtype);
		mtype.addItem("All");
		mtype.addItem("Today");
		mtype.addItem("Monthly");
		mtype.addItem("Date");
		
		add(month);
		month.addItem("January");
		month.addItem("Feburary");
		month.addItem("March");
		month.addItem("April");
		month.addItem("May");
		month.addItem("June");
		month.addItem("July");
		month.addItem("August");
		month.addItem("September");
		month.addItem("October");
		month.addItem("November");
		month.addItem("December");
		add(lsearch);
		add(tsearch);
		add(brefresh);
		add(bprint);
		add(bcan);
		
		tbl=new JTable(data,col);
		bpnl=new JScrollPane(tbl);
		tbl.setModel(model);
		bpnl.setBounds(620,200,700,300);		
		add(bpnl);		

		tbl1=new JTable(data1,col1);
		cpnl=new JScrollPane(tbl1);
		tbl1.setModel(model1);
		cpnl.setBounds(620,200,700,300);		
		add(cpnl);		
				
		String sm="",sd="";
		if((cal.get(Calendar.DATE))<10)
		{
			sd="0"+cal.get(Calendar.DATE);
		}
		else
		{
			sd=""+cal.get(Calendar.DATE);
		}
		
		if((cal.get(Calendar.MONTH)+1)<10)
		{
			sm="0"+(cal.get(Calendar.MONTH)+1);
		}
		else
		{
			sm=""+(cal.get(Calendar.MONTH)+1);
		}
		tdate.setText(""+sd+"/"+sm+"/"+cal.get(Calendar.YEAR));
		
		tdate.setEditable(false);
		bpnl.setVisible(false);
		cpnl.setVisible(false);
		lsby.setVisible(false);
		mtype.setVisible(false);
		lsearch.setVisible(false);
		tsearch.setVisible(false);
		month.setVisible(false);
		bprint.setEnabled(false);
		
		add(lbl);
		repaint();

		rpbook.addItemListener(this);
		rpcan.addItemListener(this);
		brefresh.addActionListener(this);
		bprint.addActionListener(this);
		bcan.addActionListener(this);
		mtype.addActionListener(this);
		tsearch.addFocusListener(this);
	}
	public void display()
	{
		if(rpbook.isSelected()||rpcan.isSelected())
		{
			mtype.setSelectedIndex(0);
			lsby.setVisible(true);
			mtype.setVisible(true);
			if(rpbook.isSelected())
			{
				flg=1;
				bpnl.setVisible(true);
				model.setRowCount(0);
				cpnl.setVisible(false);				
			}
			else
			{
				flg=2;
				bpnl.setVisible(false);
				cpnl.setVisible(true);
				model1.setRowCount(0);
			}
		}
		if(rpbook.isSelected()==false&&rpcan.isSelected()==false)
		{
			flg=0;
			lsby.setVisible(false);
			mtype.setVisible(false);
			cpnl.setVisible(false);
			bpnl.setVisible(false);
		}		
	}
	public void bsearch()
	{
		String str="";
		model.setRowCount(0);
		try
		{
			Connection con=DriverManager.getConnection("jdbc:odbc:SpaSystemdsn");
			Statement st=con.createStatement();
			Vector v=null;
			ResultSet res=null;
			if(mtype.getSelectedItem().toString().equals("All"))
			{
				str="select * from bookingtbl";
			}
			if(mtype.getSelectedItem().toString().equals("Today"))
			{
				str="select * from bookingtbl where bookdate='"+tdate.getText()+"'";
			}
			if(str.length()!=0)
			{
				res=st.executeQuery(str);
				while(res.next())
				{
					v=new Vector();
					v.add(tbl.getRowCount()+1);
					v.add(res.getString(1));
					v.add(res.getString(2));
					v.add(res.getString(4));
					v.add(res.getString(10));
					model.addRow(v);
				}
			}
			
			if(mtype.getSelectedItem().toString().equals("Monthly"))
			{
				String t="";
				SimpleDateFormat formatter=new SimpleDateFormat("dd/MM/yyyy");
				Date sdate=formatter.parse("1/"+(month.getSelectedIndex()+1)+"/"+tdate.getText().substring(6,tdate.getText().length()));
				Date edate=formatter.parse("31/"+(month.getSelectedIndex()+1)+"/"+tdate.getText().substring(6,tdate.getText().length()));
				Date tdt;
				res=st.executeQuery("select * from bookingtbl");
				while(res.next())
				{
					t=res.getString(1);
					tdt=formatter.parse(t);					
					if(tdt.after(sdate)&&tdt.before(edate)||tdt.equals(sdate)||tdt.equals(edate))
					{	
						v=new Vector();
						v.add(tbl.getRowCount()+1);
						v.add(t);
						v.add(res.getString(2));
						v.add(res.getString(4));
						v.add(res.getString(10));
						model.addRow(v);
					}
				}
			}
			if(mtype.getSelectedItem().toString().equals("Date"))
			{
				if(tsearch.getText().length()!=0)
				{
					String t="";
					SimpleDateFormat formatter=new SimpleDateFormat("dd/MM/yyyy");
					Date cdt=formatter.parse(tsearch.getText());
					Date tdt;
					res=st.executeQuery("select * from bookingtbl");
					while(res.next())
					{
						t=res.getString(1);
						tdt=formatter.parse(t);					
						if(tdt.equals(cdt))
						{		
							v=new Vector();
							v.add(tbl.getRowCount()+1);
							v.add(t);
							v.add(res.getString(2));
							v.add(res.getString(4));
							v.add(res.getString(10));
							model.addRow(v);
						}
					}
				}
			}
		}
		catch(Exception ee)
		{
			System.out.println(ee);
		}
	}
	public void csearch()
	{	
		String str="";
		model1.setRowCount(0);
		try
		{
			Connection con=DriverManager.getConnection("jdbc:odbc:SpaSystemdsn");
			Statement st=con.createStatement();
			Vector v=null;
			ResultSet res=null;
			if(mtype.getSelectedItem().toString().equals("All"))
			{
				str="select * from canceltbl";
			}
			if(mtype.getSelectedItem().toString().equals("Today"))
			{
				str="select * from canceltbl where canceldate='"+tdate.getText()+"'";
			}
			if(str.length()!=0)
			{
				res=st.executeQuery(str);			
				while(res.next())
				{	
					v=new Vector();
					v.add(tbl1.getRowCount()+1);
					v.add(res.getString(1));
					v.add(res.getString(3));
					v.add(res.getString(4));
					v.add(res.getString(5));
					v.add(res.getString(8));
					model1.addRow(v);
				}
			}
			if(mtype.getSelectedItem().toString().equals("Monthly"))
			{
				String t="";
				SimpleDateFormat formatter=new SimpleDateFormat("dd/MM/yyyy");
				Date sdate=formatter.parse("1/"+(month.getSelectedIndex()+1)+"/"+tdate.getText().substring(6,tdate.getText().length()));
				Date edate=formatter.parse("31/"+(month.getSelectedIndex()+1)+"/"+tdate.getText().substring(6,tdate.getText().length()));
				Date tdt;
				res=st.executeQuery("select * from canceltbl");
				while(res.next())
				{
					t=res.getString(1);
					tdt=formatter.parse(t);					
					if(tdt.after(sdate)&&tdt.before(edate)||tdt.equals(sdate)||tdt.equals(edate))
					{	
						v=new Vector();
						v.add(tbl1.getRowCount()+1);
						v.add(t);
						v.add(res.getString(3));
						v.add(res.getString(4));
						v.add(res.getString(5));
						v.add(res.getString(8));
						model1.addRow(v);
					}
				}
			}
			if(mtype.getSelectedItem().toString().equals("Date"))
			{
				if(tsearch.getText().length()!=0)
				{
					String t="";
					SimpleDateFormat formatter=new SimpleDateFormat("dd/MM/yyyy");
					Date cdt=formatter.parse(tsearch.getText());
					Date tdt;
					res=st.executeQuery("select * from canceltbl");
					while(res.next())
					{
						t=res.getString(1);
						tdt=formatter.parse(t);					
						if(tdt.equals(cdt))
						{		
							v=new Vector();
							v.add(tbl1.getRowCount()+1);
							v.add(t);
							v.add(res.getString(3));
							v.add(res.getString(4));
							v.add(res.getString(5));
							v.add(res.getString(8));
							model1.addRow(v);
						}
					}
				}
			}
		}
		catch(Exception ee)
		{
			System.out.println(ee);
		}
	}
	
	public void bcopy()
	{
		int i,j=10;
		try
		{
			PrintWriter pw=new PrintWriter("bookingReport.txt");
			pw.println("\t\t\t Aamya Beauty Care Center  ");
			pw.println("\t\t\t   Kalimati Road-8331001");
			pw.println("\t\t\t     Ph.No.:-8603100915");
			pw.println("\t\t\t\t\t\t Date:"+tdate.getText());
			pw.println("\t_________________________________________________________________________");
			pw.println("\tS.No. Booking Date\tBooking ID\tCustomer/Member ID\tTotal\t");
			pw.println("\t_________________________________________________________________________");
			for(i=0;i<tbl.getRowCount();i++)
			{
				pw.println("\t"+tbl.getValueAt(i,0)+"\t"+tbl.getValueAt(i,1)+"\t    "+tbl.getValueAt(i,2)+"\t     "+tbl.getValueAt(i,3)+"\t\t"+tbl.getValueAt(i,4));
				j--;
			}
			for(;j>0;j--)
				pw.println();
			
			pw.println("\t_________________________________________________________________________");	
			
			pw.close();
			Runtime rt=Runtime.getRuntime();
			Process pr=rt.exec("notepad bookingReport.txt");	
		}
		catch(Exception ee)
		{
			System.out.println(ee);
		}
	}
	public void ccopy()
	{
		int i,j=10;
		try
		{
			PrintWriter pw=new PrintWriter("bookingReport.txt");
			pw.println("\t\t\t Aamya Beauty Care Center  ");
			pw.println("\t\t\t   Kalimati Road-8331001");
			pw.println("\t\t\t     Ph.No.:-8603100915");
			pw.println("\t\t\t\t\t\t Date:"+tdate.getText());
			pw.println("\t______________________________________________________________________________________");
			pw.println("\tS.No. Cancellatin Date\tCancellation ID\t  Booking ID\tCustomer/Member ID\tTotal\t");
			pw.println("\t______________________________________________________________________________________");
			for(i=0;i<tbl1.getRowCount();i++)
			{
				pw.println("\t"+tbl1.getValueAt(i,0)+"\t"+tbl1.getValueAt(i,1)+"\t    "+tbl1.getValueAt(i,2)+"\t     "+tbl1.getValueAt(i,3)+"\t\t"+tbl1.getValueAt(i,4)+"\t\t"+tbl1.getValueAt(i,5));
			}
			for(;j>0;j--)
				pw.println();
			
			pw.println("\t______________________________________________________________________________________");		
			pw.close();
			Runtime rt=Runtime.getRuntime();
			Process pr=rt.exec("notepad bookingReport.txt");	
		}
		catch(Exception ee)
		{
			System.out.println(ee);
		}		
	}
	public void itemStateChanged(ItemEvent ie)
	{
		if(ie.getSource()==rpbook||ie.getSource()==rpcan)
		{
			if(ie.getStateChange()==ItemEvent.SELECTED)
			{
				display();
			}
		}
	}
	public void focusLost(FocusEvent fe)
	{
		if(fe.getComponent()==tdate)
		{
			strchk=tdate.getText();
			if(tdate.getText().length()!=0)
			{ 	
				try
				{
					SimpleDateFormat cdf = new SimpleDateFormat("dd/MM/yyyy");
					Date dat = cdf.parse(strchk);
					if (!strchk.equals(cdf.format(dat)))
					{
						JOptionPane.showMessageDialog(null,"Invalid Date Format!!");
						tdate.setText("");
					}
				}
				catch(Exception ee)
				{
					JOptionPane.showMessageDialog(null,"Invalid Date Format!!");
					tdate.setText("");
				}
					
			}
		}
		
	}
	public void focusGained(FocusEvent fe)
	{
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==mtype)
		{
			lsearch.setVisible(false);
			tsearch.setVisible(false);
			month.setVisible(false);
			if(mtype.getSelectedItem().toString().equals("Monthly"))
			{
				lsearch.setText("Select Month");
				lsearch.setVisible(true);
				month.setSelectedIndex(0);
				month.setVisible(true);
			}
			if(mtype.getSelectedItem().toString().equals("Date"))
			{
				lsearch.setText("Enter Date");
				lsearch.setVisible(true);
				tsearch.setText("");
				tsearch.setVisible(true);
			}
		}
		if(e.getSource()==brefresh)
		{
			if(flg==1)
			{
				bsearch();
				bprint.setEnabled(true);
			}
			if(flg==2)
			{
				csearch();
				bprint.setEnabled(true);
			}
		}
		if(e.getSource()==bprint)
		{
			bprint.setEnabled(false);
			if(tbl.getRowCount()!=0||tbl1.getRowCount()!=0)
			{
				if(flg==1)
				{
					bcopy();
				}
				if(flg==2)
				{
					ccopy();
				}
			}
			else
			{
				JOptionPane.showMessageDialog(null,"No Record Available!!");
			}
		}
		if(e.getSource()==bcan)
		{
			this.dispose();
		}
	}
	public static void main(String argv[])
	throws IOException
	{
		report obj=new report();
		
	}
}