import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.*;
import java.sql.*;
import java.util.Date;
import java.util.*;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableModel;
public class booking extends JFrame implements ActionListener,FocusListener,ItemListener,MouseListener,MouseMotionListener
{
	JLabel lbl=new JLabel(new ImageIcon("../Images/trac.jpg"));	

	String strtype="";
	String strdis="";
	String strgen="";
	String strpay="";
	Double rt=0.0;
	int sflg=0;
	JLabel bid=new JLabel("Booking ID");
	JLabel bctype=new JLabel("User Type");
	JLabel bcid=new JLabel("Customer/Member ID");
	JLabel bname=new JLabel("Name");
	JLabel bgen=new JLabel("Gender");
	JLabel bcont=new JLabel("Contact");
	JLabel bmob=new JLabel("Mobile");
	JLabel bemail=new JLabel("E-Mail");
	JLabel bhead=new JLabel("BOOKING INFORMATION");
	JLabel bdate=new JLabel("Date");
	JLabel bapdate=new JLabel("Appointment Date");
	JLabel btreat=new JLabel("Treatment Type");
	JLabel btname=new JLabel("Treatment Name");
	JLabel bdisp=new JLabel("Display");
	JLabel luser=new JLabel("USER DETAIL");
	JLabel lfaci=new JLabel("FACILITY DETAILS");
	
	
	JLabel lpack=new JLabel("Package Name");
	JLabel lpackid=new JLabel("Package ID");
	JLabel loff=new JLabel("Discount");
	JLabel lrtotal=new JLabel("Real Cost");
	JLabel ltotal=new JLabel("Total Cost");
	JLabel lmass=new JLabel("Massager Name");
	JLabel lmassf=new JLabel("Select Massager");
	JLabel lmas=new JLabel("ID...");
	JLabel ldur=new JLabel("Duration");
	JLabel lendt=new JLabel("End Time");
	JLabel lstart=new JLabel("Start Time");
	JLabel lbdt=new JLabel("Booking Date");
	JLabel ltype=new JLabel("Type");
	JLabel ldis=new JLabel("");
	JLabel ltax=new JLabel("Service Tax");
	JLabel ldiet=new JLabel("Diet Name");

	JTextField tdate=new JTextField();
	JTextField tid=new JTextField();
	JTextField tcid=new JTextField();
	JTextField tname=new JTextField();
	JTextField tcont=new JTextField();
	JTextField tmob=new JTextField();
	JTextField temail=new JTextField();
	JTextField tapdate=new JTextField();
	JTextField tpackid=new JTextField();
	JTextField toff=new JTextField();
	JTextField ttotal=new JTextField();
	JTextField trtotal=new JTextField();
	JTextField tend=new JTextField();
	JTextField tstart=new JTextField();
	JTextField tbdt=new JTextField();
	JTextField ttype=new JTextField();
	JTextField ttax=new JTextField();

	JComboBox ctype=new JComboBox();
	JComboBox cname=new JComboBox();
	JComboBox cpack=new JComboBox();
	JComboBox cmas=new JComboBox();
	JComboBox cdiet=new JComboBox();

	JRadioButton rtreat=new JRadioButton("Treatment");
	JRadioButton rpack=new JRadioButton("Packages");
	ButtonGroup bd=new ButtonGroup();

	JRadioButton rcust=new JRadioButton("Customer");
	JRadioButton rmem=new JRadioButton("Member");
	ButtonGroup bt=new ButtonGroup();

	JRadioButton rmale=new JRadioButton("Male");
	JRadioButton rfemale=new JRadioButton("Female");
	ButtonGroup bg=new ButtonGroup();

	JScrollPane pnl=new JScrollPane();
	JScrollPane pnl1=new JScrollPane();
	JScrollPane pnl2=new JScrollPane();

	JButton bnew=new JButton("New",new ImageIcon("../Images/nbt.jpg"));
	JButton bsave=new JButton("Save",new ImageIcon("../Images/sbt.jpg"));
	JButton bsearch=new JButton("Search",new ImageIcon("../Images/sbtn.jpg"));
	JButton bedit=new JButton("Edit",new ImageIcon("../Images/ebt.jpg"));
	JButton bcancel=new JButton("Cancel",new ImageIcon("../Images/cbt.jpg"));
	JButton bpay=new JButton("Payment",new ImageIcon("../Images/pbt.jpg"));
	JButton bremove=new JButton("Removen",new ImageIcon("../Images/rbt.jpg"));
	JButton bchk=new JButton("Check");
	JCheckBox bcfrm=new JCheckBox("Confirm");

	JTable tbl;

	String []col={"Treatment ID","Type","Name","Cost"};
	String pid,ptyp,pnm,pcost;
	Object[][]data={{pid,ptyp,pnm,pcost}};
	DefaultTableModel model=new DefaultTableModel(col,0);

	JScrollPane pnl3=new JScrollPane();
	JTable tbl1;

	String []col1={"Treatment ID","Treatment Name","Cost","Duration"};
	String ttid,ttyp,tnm,tcost;
	Object [][]data1={{ttid,ttyp,tnm,tcost}};
	DefaultTableModel model1=new DefaultTableModel(col1,0);

	Calendar cal=Calendar.getInstance();
	String strchk="";
	String tmdis="";
	String strdiet="";
	String strdname="";
	Dimension di=Toolkit.getDefaultToolkit().getScreenSize();

	///Fonts......
	Font btfnt=new Font("Consolas",Font.BOLD,15);
	Font lblfnt=new Font("Bookman Old Style",4,20);
	Font txtfnt=new Font("Bookman Old Style",4,15);
	
	public booking()
	{
		setLayout(null);
		setVisible(true);
		this.getContentPane().setBackground(Color.WHITE);
		setSize((int)di.getWidth(),(int)di.getHeight());
		setResizable(false);
		getContentPane().setBackground(Color.WHITE);

		lbl.setBounds(0,0,getWidth(),getHeight());

		bhead.setFont(new Font("Castellar",1,25));
		bhead.setBounds(400,30,380,30);
		bhead.setForeground(new Color(181,230,29));
		
		bdate.setBounds(950,80,80,30);
		bdate.setFont(lblfnt);
		tdate.setBounds(1040,80,100,30);
		tdate.setFont(txtfnt);
		
		bid.setBounds(100,80,120,30);
		bid.setFont(lblfnt);
		tid.setBounds(240,80,100,30);
		tid.setFont(txtfnt);
		
		luser.setBounds(150,130,170,30);
		luser.setFont(new Font("Times New Roman",4,25));
		luser.setForeground(new Color(181,230,29));
		
		bdisp.setBounds(600,130,80,30);
		bdisp.setFont(lblfnt);
		rtreat.setBounds(700,130,140,30);
		rtreat.setFont(lblfnt);
		rpack.setBounds(860,130,140,30);
		rpack.setFont(lblfnt);
		
		bctype.setBounds(100,180,120,30);
		bctype.setFont(lblfnt);
		rcust.setBounds(240,180,140,30);
		rcust.setFont(lblfnt);
		rmem.setBounds(390,180,120,30);
		rmem.setFont(lblfnt);
		
		bcid.setBounds(100,230,220,30);
		bcid.setFont(lblfnt);
		tcid.setBounds(340,230,80,30);
		tcid.setFont(txtfnt);
		
		ltype.setBounds(100,280,120,30);
		ltype.setFont(lblfnt);
		ttype.setBounds(240,280,100,30);
		ttype.setFont(txtfnt);
		
		bname.setBounds(100,330,120,30);
		bname.setFont(lblfnt);
		tname.setBounds(240,330,100,30);
		tname.setFont(txtfnt);
		
		bgen.setBounds(100,380,120,30);
		bgen.setFont(lblfnt);
		rmale.setBounds(240,380,100,30);
		rmale.setFont(lblfnt);
		rfemale.setBounds(350,380,120,30);
		rfemale.setFont(lblfnt);
		
		bcont.setBounds(100,430,120,30);
		bcont.setFont(lblfnt);
		
		bmob.setBounds(150,470,120,30);
		bmob.setFont(lblfnt);
		tmob.setBounds(280,470,120,30);
		tmob.setFont(txtfnt);
		
		bemail.setBounds(150,510,120,30);
		bemail.setFont(lblfnt);
		temail.setBounds(280,510,180,30);
		temail.setFont(txtfnt);
		
		bapdate.setBounds(100,560,200,30);
		bapdate.setFont(lblfnt);
		tapdate.setBounds(320,560,100,30);
		tapdate.setFont(txtfnt);
		
		lbdt.setBounds(100,610,150,30);
		lbdt.setFont(lblfnt);
		tbdt.setBounds(270,610,100,30);
		tbdt.setFont(txtfnt);
		
		ldis.setBounds(550,430,150,30);
		ldis.setFont(lblfnt);
		
		loff.setBounds(550,480,100,30);
		loff.setFont(lblfnt);
		toff.setBounds(660,480,80,30);
		toff.setFont(txtfnt);
		
		lrtotal.setBounds(750,480,100,30);
		lrtotal.setFont(lblfnt);
		trtotal.setBounds(860,480,80,30);
		trtotal.setFont(txtfnt);
		
		ltax.setBounds(950,480,120,30);
		ltax.setFont(lblfnt);
		ttax.setBounds(1080,480,60,30);
		ttax.setFont(txtfnt);
		
		ltotal.setBounds(1150,480,100,30);
		ltotal.setFont(lblfnt);
		ttotal.setBounds(1260,480,80,30);
		ttotal.setFont(txtfnt);
		

		lmass.setBounds(550,530,160,30);
		lmass.setFont(lblfnt);
		lmassf.setBounds(720,530,180,30);
		lmassf.setFont(lblfnt);
		lmas.setBounds(910,530,100,30);
		lmas.setFont(lblfnt);
		cmas.setBounds(1020,530,160,30);
		cmas.setFont(txtfnt);
		
		btreat.setBounds(550,180,160,30);
		btreat.setFont(lblfnt);
		ctype.setBounds(550,220,160,30);
		ctype.setFont(txtfnt);
		
		btname.setBounds(720,180,170,30);
		btname.setFont(lblfnt);
		cname.setBounds(720,220,160,30);
		cname.setFont(txtfnt);
		
		lpack.setBounds(870,180,160,30);
		lpack.setFont(lblfnt);
		cpack.setBounds(870,220,150,30);
		cpack.setFont(txtfnt);
		
		lpackid.setBounds(1030,180,120,30);
		lpackid.setFont(lblfnt);
		tpackid.setBounds(1140,180,100,30);
		tpackid.setFont(txtfnt);
		
		lstart.setBounds(550,580,120,30);
		lstart.setFont(lblfnt);
		tstart.setBounds(680,580,100,30);
		tstart.setFont(txtfnt);
		lendt.setBounds(790,580,120,30);
		lendt.setFont(lblfnt);
		tend.setBounds(920,580,100,30);
		tend.setFont(txtfnt);
		
		bnew.setBounds(320,680,120,30);
		bnew.setFont(btfnt);
		bsave.setBounds(450,680,120,30);
		bsave.setFont(btfnt);
		bsearch.setBounds(580,680,120,30);
		bsearch.setFont(btfnt);
		bedit.setBounds(710,680,120,30);
		bedit.setFont(btfnt);
		bcancel.setBounds(840,680,120,30);
		bcancel.setFont(btfnt);
		bpay.setBounds(970,680,140,30);
		bpay.setFont(btfnt);
		
	
		
		tbl=new JTable(data,col);
		pnl=new JScrollPane(tbl);
		tbl.setModel(model);
		add(pnl);
		pnl.setBounds(870,270,400,100);

		tbl1=new JTable(data1,col1);
		pnl3=new JScrollPane(tbl1);
		tbl1.setModel(model1);
		add(pnl3);
		pnl3.setBounds(550,270,400,100);
		
		ldiet.setBounds(550,376,100,30);
		cdiet.setBounds(620,380,100,20);
		bcfrm.setBounds(730,380,100,20);
		bchk.setBounds(840,380,100,20);
		bremove.setBounds(660,380,100,30);
		
		ldiet.setVisible(false);
		cdiet.setVisible(false);
		bcfrm.setVisible(false);
		bchk.setVisible(false);
		
		pnl3.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		add(ltax);
		add(ttax);
		add(ltype);
		add(ttype);
		add(ldis);
		add(lbdt);
		add(tbdt);
		add(ldiet);
		add(cdiet);
		add(bcfrm);
		add(bchk);
		add(bremove);
		add(lendt);
		add(tend);
		add(tstart);
		add(lstart);
		add(lmas);
		add(cmas);
		add(lmass);
		add(lmassf);
		add(loff);
		add(ltotal);
		add(toff);
		add(ttotal);
		add(lpackid);
		add(tpackid);
		add(lpack);
		add(cpack);
		add(btname);
		add(cname);
		add(ctype);
		add(btreat);
		add(bcid);
		add(tcid);
		add(bapdate);
		add(tapdate);
		add(bcont);
		add(bmob);
		add(tmob);
		add(bemail);
		add(temail);
		add(bgen);
		add(rmale);
		add(rfemale);
		bg.add(rfemale);
		bg.add(rmale);
		add(bdisp);
		add(rtreat);
		add(rpack);
		bd.add(rtreat);
		bd.add(rpack);
		add(bname);
		add(tname);
		add(bid);
		add(tid);
		add(luser);
		tid.setEditable(false);
		tdate.setEditable(false);
		tname.setEditable(false);
		tmob.setEditable(false);
		temail.setEditable(false);
		add(bdate);
		add(tdate);
		bt.add(rcust);
		bt.add(rmem);
		add(rcust);
		add(rmem);
		add(bhead);
		add(bctype);
		add(cpack);
		add(bnew);
		add(lrtotal);
		add(trtotal);
		add(bnew);
		add(bsave);
		add(bsearch);
		add(bedit);
		add(bcancel);
		add(bpay);
		
		cpack.setVisible(false);
		lpack.setVisible(false);
		lpackid.setVisible(false);
		tpackid.setVisible(false);
		pnl.setVisible(false);
		pnl3.setVisible(false);
		btreat.setVisible(false);
		btname.setVisible(false);
		ctype.setVisible(false);
		cname.setVisible(false);
		bremove.setVisible(false);
		tdate.setText(""+cal.get(Calendar.DATE)+"/"+(cal.get(Calendar.MONTH)+1)+"/"+cal.get(Calendar.YEAR));
		cpack.addItem("Select Package");

		add(lbl);
		repaint();

		bnew.addActionListener(this);
		bsave.addActionListener(this);
		bsearch.addActionListener(this);
		bedit.addActionListener(this);
		bcancel.addActionListener(this);
		bpay.addActionListener(this);
		ctype.addActionListener(this);
		cname.addActionListener(this);
		cpack.addActionListener(this);
		toff.addFocusListener(this);
		tcid.addFocusListener(this);
		rmem.addActionListener(this);
		rcust.addActionListener(this);
		rtreat.addItemListener(this);
		lmassf.addMouseListener(this);
		rpack.addItemListener(this);
		cmas.addActionListener(this);
		bremove.addActionListener(this);
		bcfrm.addMouseListener(this);
		bchk.addMouseListener(this);
		cmas.setVisible(false);
		lmas.setVisible(false);
		
		///Validation....
		bsave.setEnabled(false);
		bedit.setEnabled(false);
		tapdate.addFocusListener(this);
		tbdt.addFocusListener(this);
		trtotal.setEditable(false);
		ttotal.setEditable(false);
		ttype.setEditable(false);
		ttax.setEditable(false);
		
		
		try
		{
			cdiet.removeAllItems();
			Connection con=DriverManager.getConnection("jdbc:odbc:SpaSystemdsn");
			Statement st=con.createStatement();
			ResultSet res=st.executeQuery("Select * from diettbl");
			cdiet.addItem("Select Diet");
			while(res.next())
			{
				cdiet.addItem(res.getString(2));
			}
		}
		catch(Exception ee)
		{
			System.out.println(ee);
		}
		
	}
	public void mousePressed(MouseEvent me)
	{}
	public void mouseReleased(MouseEvent me)
	{}
	public void mouseExited(MouseEvent me)
	{}
	public void mouseDragged(MouseEvent me)
	{}
	public void mouseClicked(MouseEvent me)
	{
		if(me.getSource()==lmassf)
		{
			if(rtreat.isSelected()==true)
			{
				if(ctype.getSelectedIndex()==0||ctype.getItemCount()==0)
				{
					JOptionPane.showMessageDialog(null,"First Select Treatment Type!!!!");
				}
				else
				{
					cmas.setVisible(true);
					lmas.setVisible(true);
					String ts="";
					try
					{
						Connection con=DriverManager.getConnection("jdbc:odbc:SpaSystemdsn");
						Statement st=con.createStatement();
						
						if(cmas.getItemCount()!=0)
							cmas.removeAllItems();
						
						String str="select * from stafftbl";
						ResultSet res=st.executeQuery(str);
						cmas.addItem("Select Massager");
						while(res.next())
						{
							cmas.addItem(res.getString(2));
						}
					}
					catch(Exception ee)
					{
						System.out.println(ee);
					}
				}
			}
		}
		if(me.getComponent()==bchk)
		{
			if(me.getClickCount()==2)
			{
				if(cdiet.getSelectedItem().toString().equals("Select Diet"))
				{		
				}
				else
				{
					displaydiet disobj=new displaydiet(cdiet.getSelectedItem().toString());
				}
			}
		}
		if(me.getComponent()==bcfrm)
		{
			if(bcfrm.isSelected())
			{
				if(cdiet.getSelectedItem().toString().equals("Select Diet"))
				{
					JOptionPane.showMessageDialog(null,"First Select Diet!!");
					bcfrm.setSelected(false);
				}
				else
				{
					try
					{
						Connection con=DriverManager.getConnection("jdbc:odbc:SpaSystemdsn");
						Statement st=con.createStatement();
						ResultSet res=st.executeQuery("select * from diettbl where diettype='"+cdiet.getSelectedItem().toString()+"'");
						while(res.next())
						{
							strdiet=res.getString(1);
							strdname=res.getString(2);
						}
					}
					catch(Exception ee)
					{
						System.out.println(ee);
					}
				}
			}
			else
			{
				strdiet="";
				strdname="";
				cdiet.setSelectedIndex(0);
			}
		}
	}
	public void mouseMoved(MouseEvent me)
	{}
	public void mouseEntered(MouseEvent me)
	{}
	public void find(String t)
	{
		try
		{
			tid.setText("");
			bt.clearSelection();
			tcid.setText("");
			tname.setText("");
			bg.clearSelection();
			tmob.setText("");
			temail.setText("");
			tapdate.setText("");
			tbdt.setText("");
			toff.setText("");
			trtotal.setText("");
			ttotal.setText("");
			tstart.setText("");
			tend.setText("");
			ttax.setText("15");
			String tmp="";
			String tm="";
			String tp="";
			String strp="";
			int flg=0;
			String tn="";
			tmdis="15";
			String tnd="";
			Connection con= DriverManager.getConnection("jdbc:odbc:SpaSystemdsn");
			ResultSet res;
			Statement st=con.createStatement();
			res=st.executeQuery("select * from bookingtbl where bookid='"+t+"'");
			while(res.next())
			{
				bedit.setEnabled(true);
				flg=1;
				tid.setText(res.getString(2));
				if(res.getString(3).equals("Customer"))
				{
					rcust.setSelected(true);
				}
				else
				{
					rmem.setSelected(true);
				}
				tmp=res.getString(4);
				tcid.setText(tmp);
				tapdate.setText(res.getString(5));
				tbdt.setText(res.getString(1));
				if(res.getString(6).equals("Treatment"))
				{
					rtreat.setSelected(true);
				}
				else
				{
					rpack.setSelected(true);
				}
				tm=res.getString(7);
				tpackid.setText(tm);
				toff.setText(res.getString(8));
				trtotal.setText(res.getString(9));
				ttotal.setText(res.getString(10));

				lmassf.setText(res.getString(12));

				tstart.setText(res.getString(13));
				tend.setText(res.getString(14));
				tnd=res.getString(16);
				if(tnd.length()!=0)
				{
					ldiet.setVisible(true);
					cdiet.setVisible(true);
					bcfrm.setVisible(true);
					bchk.setVisible(true);
					Statement st5=con.createStatement();
					ResultSet res5;
					res5=st5.executeQuery("select * from diettbl where dietid='"+tnd+"'");
					while(res5.next())
					{
						cdiet.setSelectedItem(""+res5.getString(2));
						bcfrm.setSelected(true);
					}
				}
				else
				{
					ldiet.setVisible(false);
					cdiet.setVisible(false);
					bcfrm.setVisible(false);
					bchk.setVisible(false);					
				}
			}
			if(flg==0&&t.length()!=0)
			{
				JOptionPane.showMessageDialog(null,"No Record Found!!");
				bg.clearSelection();
				tid.setText("");
				bt.clearSelection();
				tcid.setText("");
				ttype.setText("");
				tname.setText("");
				bg.clearSelection();
				tmob.setText("");
				temail.setText("");
				tapdate.setText("");
				tbdt.setText("");
				toff.setText("");
				trtotal.setText("");
				ttax.setText("");
				ttotal.setText("");
				lmassf.setText("");
				tstart.setText("");
				tend.setText("");
				bd.clearSelection();
			}
			if(rcust.isSelected()==true)
			{
				ResultSet res1=st.executeQuery("select * from customertbl where custid='"+tmp+"'");
				while(res1.next())
				{
					tname.setText(res1.getString(3));
					if(res1.getString(7).equals("Male"))
					{
						rmale.setSelected(true);
					}
					else
					{
						rfemale.setSelected(true);
					}
					tmob.setText(res1.getString(5));
					temail.setText(res1.getString(6));

				}
			}
			if(rmem.isSelected()==true)
			{
				ResultSet res1=st.executeQuery("select * from membertbl where mem_id='"+tmp+"'");
				while(res1.next())
				{
					tname.setText(res1.getString(3));
					if(res1.getString(5).equals("Male"))
					{
						rmale.setSelected(true);
					}
					else
					{
						rfemale.setSelected(true);
					}
					ldis.setText("Elegible for "+res1.getString(15)+" discount");
					tmob.setText(res1.getString(8));
					temail.setText(res1.getString(9));
					ttype.setText(res1.getString(4));
				}
			}
			if(rtreat.isSelected()==true)
			{
				ResultSet res2=st.executeQuery("select * from booktbl where bookid='"+t+"'");
				Vector v;
				model1.setRowCount(0);
				while(res2.next())
				{
					v=new Vector();
					v.add(res2.getString(2));
					v.add(" ");
					v.add(" ");
					v.add(" ");
					model1.addRow(v);
				}

				for(int i=0;i<tbl1.getRowCount();i++)
				
				{
					res2=st.executeQuery("select * from treatmenttbl where treat_id='"+tbl1.getValueAt(i,0).toString()+"'");
					while(res2.next())
				
					{
						tbl1.setValueAt(res2.getString(3),i,1);
						tbl1.setValueAt(res2.getString(4),i,2);
						tbl1.setValueAt(res2.getString(5),i,3);
					}
				}
			}
				
			if(rpack.isSelected()==true)
			{
				System.out.println(tm);
				String str="select * from packagetbl where pack_id='"+tm+"'";
				ResultSet res2=st.executeQuery(str);
				String stp="";
				while(res2.next())
				{
					int j=0;
					stp=res2.getString(2);
					String s[]={res2.getString(3),res2.getString(4),res2.getString(5),res2.getString(6),res2.getString(7)};
					while(j<5)
					{
						str="select * from treatmenttbl where treat_id='"+s[j]+"'";
						Statement st1=con.createStatement();
						ResultSet res3=st1.executeQuery(str);
						Vector v=new Vector();
						while(res3.next())
						{
						v.add(res3.getString(1));
						v.add(res3.getString(2));
						v.add(res3.getString(3));
						v.add(res3.getString(4));
						model.addRow(v);
						}
						j++;
					}
				}

				if(cpack.getItemCount()==1)
				{
					res2=st.executeQuery("Select * from packagetbl");
					while (res2.next())
					{
							cpack.addItem(res2.getString(2));
					}
				}
				System.out.println(stp);
				cpack.setSelectedItem(stp);
				}

			}
				catch(Exception ee)
				{
					System.out.println(ee);

				}
	}
	public int checkmass(String tmid)
	{
		int cflg=1;
		try
		{
			Connection con=DriverManager.getConnection("jdbc:odbc:SpaSystemdsn");
			SimpleDateFormat pr=new SimpleDateFormat("hh:mm a");
			SimpleDateFormat pr1=new SimpleDateFormat("dd/MM/yyyy");
	
			Date tss=pr.parse(tstart.getText());
			Date tse=pr.parse(tend.getText());

			Date t=pr1.parse(tapdate.getText());
			Date tt;
			Date tstime,tetime;
			Statement st2=con.createStatement();
			ResultSet res2;
			res2=st2.executeQuery("select * from scheduletbl where staffid='"+tmid+"'");
			while(res2.next())
			{
				cflg=0;
				tstime=pr.parse(res2.getString(5));
				tetime=pr.parse(res2.getString(6));
				tt=pr1.parse(res2.getString(4));
				if(t.compareTo(tt)==0)
				{
					if(tse.after(tstime)&&tse.before(tetime)||tss.before(tetime)&&tss.after(tstime)||tss.compareTo(tstime)==0&&tse.compareTo(tetime)==0)
					{
						cflg=0;
					}
					else
					{
						cflg=1;
					}
				}
				else
				{
					cflg=1;
				}
			}
		}
		catch(Exception ee)
		{
			System.out.println(ee);
		}
		return cflg;
	}		
	
	public void pack()
	{
		if(rpack.isSelected()==true)
		{
			tpackid.setText("");
			toff.setText("");
			trtotal.setText("");
			ttotal.setText("");
			if(cpack.getItemCount()!=0)
				cpack.setSelectedIndex(0);
			cpack.setVisible(true);
			lpack.setVisible(true);
			lpackid.setVisible(true);
			tpackid.setVisible(true);
			pnl.setVisible(true);
			lmassf.setText("N/A");
			lmas.setVisible(false);
			cmas.setVisible(false);
		}
		else
		{
			cpack.setVisible(false);
			lpack.setVisible(false);
			lpackid.setVisible(false);
			tpackid.setVisible(false);
			pnl.setVisible(false);
			lmassf.setText("Select Massager");
		}
	}
	public void treat()
	{
		if(rtreat.isSelected()==true)
		{

			if(ctype.getItemCount()!=0)
				ctype.setSelectedIndex(0);

			toff.setText("");
			trtotal.setText("");
			ttotal.setText("");
			btreat.setVisible(true);
			btname.setVisible(true);
			ctype.setVisible(true);
			cname.setVisible(true);
			pnl3.setVisible(true);
			model1.setRowCount(0);
			bremove.setVisible(true);
			lmassf.setText("N/A");
			lmas.setText("ID...");
			ttax.setText("15");
		}
		else
		{
			btreat.setVisible(false);
			btname.setVisible(false);
			ctype.setVisible(false);
			cname.setVisible(false);
			pnl3.setVisible(false);
			bremove.setVisible(false);
		}
	}
	public void itemStateChanged(ItemEvent ie)
	{
		if(ie.getSource()==rtreat||ie.getSource()==rpack)
		{
			if(ie.getStateChange()==ItemEvent.SELECTED)
			{
				treat();
				pack();
			}
		}
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==bremove)
		{
			String rn=JOptionPane.showInputDialog("Enter Row No.");
			if(tbl1.getRowCount()!=0)
			{
			if(Integer.parseInt(rn)>=1&&Integer.parseInt(rn)<=tbl1.getRowCount())
			{
				model1.removeRow(Integer.parseInt(rn)-1);
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Invalid Row Number!!");
			}
			}
		}
		if(e.getSource()==cmas)
		{
			try
			{
				if(cmas.getSelectedIndex()==0||cmas.getItemCount()==0)
				{
				}
				else
				{
					Connection con=DriverManager.getConnection("jdbc:odbc:SpaSystemdsn");
					Statement st=con.createStatement();
					String str="select * from stafftbl where sname='"+cmas.getSelectedItem().toString()+"'";
					ResultSet res=st.executeQuery(str);
					while(res.next())
					{
						lmassf.setText(res.getString(2));
						lmas.setText(res.getString(1));
					}
				}
			}
			catch(Exception ee)
			{
				System.out.println(ee);
			}
		}
		if(e.getSource()==bcancel)
		{
			this.dispose();
		}
		if(e.getSource()==rcust)
		{
				tcid.setText("");
				tname.setText("");
				tmob.setText("");
				temail.setText("");
				ttype.setText("");
				ldis.setText("");
				bg.clearSelection();
		}
		if(e.getSource()==rmem)
		{
				tcid.setText("");
				tname.setText("");
				tmob.setText("");
				temail.setText("");
				bg.clearSelection();
		}
		if(e.getSource()==bnew)
		{
			SimpleDateFormat pr=new SimpleDateFormat("dd/MM/yyyy");	
			bedit.setEnabled(false);
			bd.clearSelection();
			pack();
			treat();
			try
			{
				int ctr=0;
				Connection con=DriverManager.getConnection("jdbc:odbc:SpaSystemdsn");
				Statement st=con.createStatement();
				ResultSet res=st.executeQuery("select * from keytbl");
				while(res.next())
				{
					ctr=Integer.parseInt(res.getString(8));
				}
				if(ctr<10)
					tid.setText("B00"+ctr);
				if(ctr>=10&&ctr<100)
					tid.setText("B0"+ctr);
				if(ctr>=100&&ctr<1000)
					tid.setText("B"+ctr);
				
				tcid.setText("");
				tname.setText("");
				bg.clearSelection();
				tmob.setText("");
				temail.setText("");
				tapdate.setText("");
				Date t=pr.parse(tdate.getText());
				tbdt.setText(""+pr.format(t));
				if(ctype.getItemCount()==0)
				{
					ResultSet res1=st.executeQuery("select * from typetbl");
					ctype.addItem("Select Treatment Type");
					while(res1.next())
					{
						ctype.addItem(res1.getString(2));
					}
				}
				ttype.setText("");
				ldis.setText("");
				tpackid.setText("");
				toff.setText("");
				trtotal.setText("");
				ttotal.setText("");
				if(cpack.getItemCount()==1)
				{
					ResultSet res1=st.executeQuery("select * from packagetbl");
					while(res1.next())
					{
						cpack.addItem(res1.getString(2));
					}
				}
				else
				{
					cpack.setSelectedIndex(0);
				}
				bt.clearSelection();
				tend.setText("");
				tstart.setText("");
				bsave.setEnabled(true);
			}
			catch(Exception ee)
			{
				System.out.println(ee);
			}
			rt=0.0;
		}
		if(e.getSource()==ctype)
		{
			ttax.setText("15");
			String t=ctype.getSelectedItem().toString();
			if(t.equals("Weight Loss"))
			{
				ldiet.setVisible(true);
				cdiet.setVisible(true);
				bcfrm.setSelected(false);
				bcfrm.setVisible(true);
				bchk.setVisible(true);
			}
			else
			{
				ldiet.setVisible(false);
				cdiet.setVisible(false);
				bcfrm.setVisible(false);
				bchk.setVisible(false);				
			}
				try
				{
					Connection con=DriverManager.getConnection("jdbc:odbc:SpaSystemdsn");
					cname.removeAllItems();
					cname.addItem("Select Treatment Name");
					Statement st=con.createStatement();
					ResultSet res=st.executeQuery("select * from treatmenttbl where treat_type='"+t+"'");
					while(res.next())
					{
						cname.addItem(res.getString(3));
					}
				}
				catch(Exception ee)
				{
					System.out.println(ee);
				}
				if(lmassf.getText().equals("N/A"))
				{
					lmas.setText("ID...");
					lmas.setVisible(false);
					cmas.setVisible(false);
				}
		}
		if(e.getSource()==cname)
		{
			ttax.setText("15");
			String t="";
			int flg=0;
			String tmp="";
			if(cname.getItemCount()!=0)
				t=cname.getSelectedItem().toString();

				try
				{
					Connection con=DriverManager.getConnection("jdbc:odbc:SpaSystemdsn");
					Statement st=con.createStatement();
					ResultSet res=st.executeQuery("select * from treatmenttbl where treat_name='"+t+"'");
					while(res.next())
					{
						Vector vec=new Vector();
						String trt="";
						trt=res.getString(1);
						for(int i=0;i<tbl1.getRowCount();i++)
						{
							if(trt.equals(tbl1.getValueAt(i,0)))
							{
								flg=1;
							}

						}
						if(flg==1)
						{
							JOptionPane.showMessageDialog(null,"Already Entered!!!");
						}
						else
						{

							vec.add(trt);
							vec.add(res.getString(3));
							tmp=res.getString(4);
							vec.add(tmp);
							rt=rt+Double.parseDouble(tmp);
							vec.add(res.getString(5));
							model1.addRow(vec);
							toff.setText("0");
						}
					}
					trtotal.setText(""+rt);
					double m=Double.parseDouble(trtotal.getText());
					double ttx=Double.parseDouble(ttax.getText());
					ttotal.setText(trtotal.getText());
					if(rmem.isSelected()==true)
					{
						double tv=m-(m*(Double.parseDouble(tmdis)/100));
						double tm=tv+(tv*(ttx/100));
						ttotal.setText(""+tm);
					}
					if(rcust.isSelected()==true)
					{
						double tm=m+(m*(ttx/100));
						ttotal.setText(""+tm);
					}
					
				}
				catch(Exception ee)
				{
					System.out.println(ee);
				}
		}
		if(e.getSource()==bpay)
		{
			bedit.setEnabled(false);
			payment obj=new payment();
		}
		if(e.getSource()==bsearch)
		{
			bsave.setEnabled(false);
			sflg=1;
			String t=JOptionPane.showInputDialog("Enter Booking id:");
			find(t);
		}
		if(e.getSource()==cpack&&sflg!=1)
		{
			
			ttax.setText("15");
			String t=cpack.getSelectedItem().toString();
			String stn[]=new String[5];
			double tc=0,ts=0;
			toff.setText("");
			trtotal.setText("");
			model.setRowCount(0);
			try
			{
				Connection con=DriverManager.getConnection("jdbc:odbc:SpaSystemdsn");
				Statement st=con.createStatement();
				ResultSet res=st.executeQuery("select * from packagetbl where pack_name='"+t+"'");
				while(res.next())
				{
					tpackid.setText(res.getString(1));
					stn[0]=res.getString(3);
					stn[1]=res.getString(4);
					stn[2]=res.getString(5);
					stn[3]=res.getString(6);
					stn[4]=res.getString(7);
					toff.setText(res.getString(9));
					trtotal.setText(res.getString(8));
					tc=Double.parseDouble(res.getString(10));
				}
				ts=Double.parseDouble(ttax.getText());
				
				if(rmem.isSelected()==true)
				{
					double m=tc-(tc*(Double.parseDouble(tmdis)/100));
					double tv=m+(m*(ts/100));
					ttotal.setText(""+tv);
				}
				if(rcust.isSelected()==true)
				{
					double tv=tc+(tc*(ts/100));
					ttotal.setText(""+tv);
				}
				int p=0;
				while(p<5)
				{
					ResultSet res1=st.executeQuery("select * from treatmenttbl where treat_id='"+stn[p]+"'");
					Vector v=new Vector();
					while(res1.next())
					{
						v.add(res1.getString(1));
						v.add(res1.getString(2));
						v.add(res1.getString(3));
						v.add(res1.getString(4));
						model.addRow(v);
					}
					p++;
				}
			}
			catch(Exception ee)
			{
				System.out.println(ee);
			}
		}
		if(e.getSource()==bsave)
		{
			bedit.setEnabled(false);
			int flg=0;
			try
			{
					String tmid="",tmname="";	
				Connection con=DriverManager.getConnection("jdbc:odbc:SpaSystemdsn");
				String str="insert into bookingtbl(bookdate,bookid,usertype,cust_mem_id,appointdate,disptype,packid,discount,realcost,totalcost,massagerid,massagername,starttime,endtime,pystate,dietid)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				PreparedStatement ps=con.prepareStatement(str);
				if(tid.getText().length()==0||tcid.getText().length()==0||bt.getSelection()==null||tname.getText().length()==0||bg.getSelection()==null||tmob.getText().length()==0||temail.getText().length()==0||tapdate.getText().length()==0||tbdt.getText().length()==0||bd.getSelection()==null||trtotal.getText().length()==0||ttotal.getText().length()==0||toff.getText().length()==0)
				{
					flg=1;
					JOptionPane.showMessageDialog(null,"Empty Fields!!");
				}
				else
				{
					if(tstart.getText().length()==0||tend.getText().length()==0)
					{
						flg=1;
						JOptionPane.showMessageDialog(null,"Empty Timings!!");
					}
					else
					{
							if(rtreat.isSelected())
							{
								if(lmas.getText().equals("ID...")||lmassf.equals("N/A"))
								{
									Statement st1=con.createStatement();
									ResultSet res1;
									res1=st1.executeQuery("select * from stafftbl");
									n:{while(res1.next())
									{
										tmid=res1.getString(1);
										tmname=res1.getString(2);
										if(checkmass(tmid)==1)
										{
											lmas.setText(tmid);
											lmassf.setText(tmname);
											break n;											
										}
									}
									}
									if(lmas.getText().length()==0)
									{
										flg=1;
										JOptionPane.showMessageDialog(null,"Date is Not Available for Booking!!");
									}
								}
								else
								{
									if(checkmass(lmas.getText())==1)
									{
										tmid=lmas.getText();
										tmname=lmassf.getText();
									}
									else
									{
										flg=1;
										JOptionPane.showMessageDialog(null,"Massager is not available for booking!!");										
									}
								}
							}
							
					}
				}
				if(flg==0)
				{
					int i;
					int diflg=0;
					Statement st5=con.createStatement();
					ResultSet res5;
					String tstr="";
					if(rtreat.isSelected())
					{
						for(i=0;i<tbl1.getRowCount();i++)
						{
							tstr="select * from treatmenttbl where treat_type='Weight Loss' and treat_name='"+tbl1.getValueAt(i,1).toString()+"'";
							res5=st5.executeQuery(tstr);
							while(res5.next())
							{
								diflg=1;
							}
						}
					}
					if(diflg==0)
					{
						strdiet="";
						strdname="";
					}
					
					ps.setString(1,tbdt.getText());
					ps.setString(2,tid.getText());
					if(rcust.isSelected())
					{
						strtype="Customer";
					}
					else
					{
						strtype="Member";
					}
					ps.setString(3,strtype);
					ps.setString(4,tcid.getText());
					ps.setString(5,tapdate.getText());
					if(rtreat.isSelected())
					{
						strdis="Treatment";
					}
					else
					{
						strdis="Package";
					}
					ps.setString(6,strdis);
					ps.setString(7,tpackid.getText());
					ps.setString(8,toff.getText());
					ps.setString(9,trtotal.getText());
					ps.setString(10,ttotal.getText());
					ps.setString(11,tmid);
					ps.setString(12,tmname);
					ps.setString(13,tstart.getText());
					ps.setString(14,tend.getText());
					ps.setString(15,"Not Paid");
					ps.setString(16,strdiet);
					
					ps.executeUpdate();
					String str2="";
					Statement st=con.createStatement();
					for(i=0;i<tbl1.getRowCount();i++)
					{
						str2="insert into booktbl(bookid,treatid) values('"+tid.getText()+"','"+tbl1.getValueAt(i,0).toString()+"')";
						st.executeUpdate(str2);
					}
					String str1="update keytbl set bookingid=bookingid+1";
					Statement s1=con.createStatement();
					s1.executeUpdate(str1);
					
					str1="insert into scheduletbl(staffid,bookid,custmemid,apdate,starttime,endtime) values('"+lmas.getText()+"','"+tid.getText()+"','"+tcid.getText()+"','"+tapdate.getText()+"','"+tstart.getText()+"','"+tend.getText()+"')";
					st.executeUpdate(str1);
					JOptionPane.showMessageDialog(null,"Saved...");
					tcid.setText("");
					tid.setText("");
					tname.setText("");
					bg.clearSelection();
					tmob.setText("");
					temail.setText("");
					tapdate.setText("");
					tbdt.setText("");
					bd.clearSelection();
					cname.setVisible(false);
					ctype.setVisible(false);
					btreat.setVisible(false);
					btname.setVisible(false);
					cpack.setVisible(false);
					tpackid.setVisible(false);
					pnl.setVisible(false);
					pnl3.setVisible(false);
					lpack.setVisible(false);
					lpackid.setVisible(false);
					toff.setText("");
					ttotal.setText("");
					trtotal.setText("");
					tstart.setText("");
					tend.setText("");
					lmassf.setText("");
					lmas.setVisible(false);
					cmas.setVisible(false);
					bremove.setVisible(false);
					bt.clearSelection();
					bg.clearSelection();
					bsave.setEnabled(false);
					ldiet.setVisible(false);
					cdiet.setVisible(false);
					bcfrm.setVisible(false);
					bchk.setVisible(false);
				}
			}
			catch(Exception ee)
			{
				System.out.println(ee);
			}
		}
		if(e.getSource()==bedit)
		{
			int flg=0,tflg=0;
			bsave.setEnabled(false);
			try
			{
				Connection con=DriverManager.getConnection("jdbc:odbc:SpaSystemdsn");
				Statement st=con.createStatement();
				if(tid.getText().length()!=0&&sflg==1)
				{
					if(rcust.isSelected())
					{
						strtype="Customer";
					}
					else
					{
						strtype="Member";
					}
					if(rtreat.isSelected())
					{
						strdis="Treatment";
					}
					else
					{
						strdis="Package";
					}
					if(tid.getText().length()==0||tcid.getText().length()==0||bt.getSelection()==null||tapdate.getText().length()==0||bd.getSelection()==null||trtotal.getText().length()==0||ttotal.getText().length()==0)
					{
						flg=1;
						JOptionPane.showMessageDialog(null,"Empty Fields");
					}
					
					if(flg==0)
					{
						int i,diflg=0;
						Statement st5=con.createStatement();
						ResultSet res5;
						String tstr="";
						if(rtreat.isSelected())
						{
							for(i=0;i<tbl1.getRowCount();i++)
							{
								tstr="select * from treatmenttbl where treat_type='Weight Loss' and treat_name='"+tbl1.getValueAt(i,1).toString()+"'";
								res5=st5.executeQuery(tstr);
								while(res5.next())
								{
									diflg=1;
								}
							}
						}
						if(diflg==0)
						{
							strdiet="";
							strdname="";
						}
						String str="update bookingtbl set usertype='"+strtype+"',cust_mem_id='"+tcid.getText()+"',appointdate='"+tapdate.getText()+"',disptype='"+strdis+"',packid='"+tpackid.getText()+"',discount='"+toff.getText()+"',realcost='"+trtotal.getText()+"',totalcost='"+ttotal.getText()+"',massagerid='"+lmas.getText()+"',massagername='"+lmass.getText()+"',starttime='"+tstart.getText()+"',endtime='"+tend.getText()+"',dietid='"+strdiet+"' where bookid='"+tid.getText()+"'";
						st.executeUpdate(str);
						st.executeUpdate("delete * from booktbl where bookid='"+tid.getText()+"'");
						String str2="";
						for(i=0;i<tbl1.getRowCount();i++)
						{
							str2="insert into booktbl(bookid,treatid) values('"+tid.getText()+"','"+tbl1.getValueAt(i,0).toString()+"')";
							st.executeUpdate(str2);
						}
						JOptionPane.showMessageDialog(null,"Updated");
						bedit.setEnabled(false);
						tcid.setText("");
						tname.setText("");
						bg.clearSelection();
						tmob.setText("");
						temail.setText("");
						tapdate.setText("");
						bd.clearSelection();
						cname.setVisible(false);
						ctype.setVisible(false);
						btreat.setVisible(false);
						btname.setVisible(false);
						cpack.setVisible(false);
						tpackid.setVisible(false);
						pnl.setVisible(false);
						pnl3.setVisible(false);
						lpack.setVisible(false);
						lpackid.setVisible(false);
						toff.setText("");
						ttotal.setText("");
						trtotal.setText("");
						tstart.setText("");
						tend.setText("");
						lmassf.setText("");
						lmas.setVisible(false);
						cmas.setVisible(false);
						bremove.setVisible(false);
						bt.clearSelection();
						bg.clearSelection();
						ldiet.setVisible(false);
						cdiet.setVisible(false);
						bcfrm.setVisible(false);
						bchk.setVisible(false);
					}
				}
				else
				{
						
						JOptionPane.showMessageDialog(null,"Search Record for update!!");
				}
					
			}
			catch(Exception ee)
			{
				System.out.println(ee);
			}
		}
	}
	public void focusLost(FocusEvent fe)
	{
		if(fe.getComponent()==toff)
		{
			if(toff.getText().length()!=0)
			{
				int s=Integer.parseInt(toff.getText());
				double ttx=Double.parseDouble(ttax.getText());
				if(s<=100)
				{
					Double tc;
					tc=Double.parseDouble(trtotal.getText())-(Double.parseDouble(trtotal.getText())*(Double.parseDouble(toff.getText())/100));
					if(rmem.isSelected()==true)
					{
						double tv=tc-(tc*(Double.parseDouble(tmdis)/100));
						double m=tv+(tv*(ttx/100));
						ttotal.setText(""+m);
					}
					if(rcust.isSelected()==true)
					{
						double m=tc+(tc*(ttx/100));
						ttotal.setText(""+m);
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Invalid Discount");
				}
			}
		}
		if(fe.getComponent()==tcid)
		{
			String t=tcid.getText();
			if(tcid.getText().length()!=0)
			{
				try
				{
					if(rcust.isSelected()==true)
					{
						ttype.setText("");
						ldis.setText("");
						Connection con=DriverManager.getConnection("jdbc:odbc:SpaSystemdsn");
						Statement st=con.createStatement();
						ResultSet res=st.executeQuery("select * from customertbl where custid='"+t+"'");
						while(res.next())
						{
							tcid.setText(res.getString(2));
							tname.setText(res.getString(3));
							if(res.getString(7).equals("Male"))
							{
								rmale.setSelected(true);
							}
							else
							{
								rfemale.setSelected(true);
							}
							tmob.setText(res.getString(5));
							temail.setText(res.getString(6));
						}
						ttype.setText("N/A");
					}
					if(rmem.isSelected()==true)
					{
						Connection con=DriverManager.getConnection("jdbc:odbc:SpaSystemdsn");
						Statement st=con.createStatement();
						ResultSet res=st.executeQuery("select * from membertbl where mem_id='"+tcid.getText()+"'");
						while(res.next())
						{
							tcid.setText(res.getString(2));
							tname.setText(res.getString(3));
							if(res.getString(5).equals("Male"))
							{
								rmale.setSelected(true);
							}
							else
							{
								rfemale.setSelected(true);
							}
							tmob.setText(res.getString(8));
							temail.setText(res.getString(9));
							ttype.setText(res.getString(4));
							tmdis=res.getString(15);
							ldis.setText("Elegible for "+tmdis+" discount!!!");
						}
					}
				}
				catch(Exception ee)
				{
					System.out.println(ee);
				}
			}
		}

		if(fe.getComponent()==tapdate)
		{
			strchk=tapdate.getText();
			
			if(tapdate.getText().length()!=0)
			{ 	
				try
				{
					SimpleDateFormat cdf = new SimpleDateFormat("dd/MM/yyyy");
					Date dat = cdf.parse(strchk);
					if (!strchk.equals(cdf.format(dat)))
					{
						JOptionPane.showMessageDialog(null,"Invalid Date Format!!");
						tapdate.setText("");
					}
				}
				catch(Exception ee)
				{
					JOptionPane.showMessageDialog(null,"Invalid Date Format!!");
					tapdate.setText("");
				}	
			}
		}
		
		if(fe.getComponent()==tbdt)
		{
			strchk=tbdt.getText();
			
			if(tbdt.getText().length()!=0)
			{ 	
				try
				{
					SimpleDateFormat cdf = new SimpleDateFormat("dd/MM/yyyy");
					Date dat = cdf.parse(strchk);
					if (!strchk.equals(cdf.format(dat)))
					{
						JOptionPane.showMessageDialog(null,"Invalid Date Format!!");
						tbdt.setText("");
					}
				}
				catch(Exception ee)
				{
					JOptionPane.showMessageDialog(null,"Invalid Date Format!!");
					tbdt.setText("");
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
		booking obj=new booking();
	}
}
