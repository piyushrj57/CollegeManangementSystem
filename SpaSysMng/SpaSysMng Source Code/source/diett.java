import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.*;
import java.io.*;
import java.sql.*;
import java.util.*;
import javax.swing.table.DefaultTableModel;
public class diett extends JFrame implements ActionListener,FocusListener
{
	JLabel lbl=new JLabel(new ImageIcon("../Images/trac.jpg"));		
	
	JLabel ddate=new JLabel("Date");
	JLabel dcmid=new JLabel("Customer/Member ID");
	JLabel dname=new JLabel("Name");
	JLabel dddate=new JLabel("Diet Date");
	JLabel dtype=new JLabel("Diet Type");
	JLabel did=new JLabel("Diet ID");
	JLabel dalw=new JLabel("Allowed");
	JLabel dnalw=new JLabel("Not Allowed");
	JLabel dlist=new JLabel("Food List");
	JLabel drmk=new JLabel("Remarks");
	JLabel dhead=new JLabel("Diet Schedule");
	
	JTextField dtdate=new JTextField();
	JTextField dtcmid=new JTextField();
	JTextField dtname=new JTextField();
	JTextField ddtdate=new JTextField();
	JTextField dtid=new JTextField();

	JTextArea dtalw=new JTextArea();
	JTextArea dtnalw=new JTextArea();
	JTextArea dtlist=new JTextArea();

	JTextField dtrmk=new JTextField();
	
	JComboBox dctype=new JComboBox();
	
	JButton dnew=new JButton("New",new ImageIcon("../Images/nbt.jpg"));
	JButton dsave=new JButton("Save",new ImageIcon("../Images/sbt.jpg"));
	JButton dsearch=new JButton("Search",new ImageIcon("../Images/sbtn.jpg"));
	JButton dcan=new JButton("Cancel",new ImageIcon("../Images/cbt.jpg"));

	Calendar cal=Calendar.getInstance();
	
	JScrollPane pnl=new JScrollPane();
	JTable tbl;
	String []col={"Si. no.","Diet Name","Diet Date","Remarks"};
	String tsi,tname,tddt,trmk;
	Object [][]data={{tsi,tname,tddt,trmk}};
	DefaultTableModel model=new DefaultTableModel(col,0);

	Dimension di=Toolkit.getDefaultToolkit().getScreenSize();

	///Fonts......
	Font btfnt=new Font("Consolas",Font.BOLD,15);
	Font lblfnt=new Font("Bookman Old Style",Font.BOLD,15);
	Font txtfnt=new Font("Bookman Old Style",Font.BOLD,12);
	
	JScrollPane srlist=new JScrollPane(dtlist,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	JScrollPane srnalw=new JScrollPane(dtnalw,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	JScrollPane sralw=new JScrollPane(dtalw,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	
	public diett()
	{
		setLayout(null);
		setVisible(true);
		this.getContentPane().setBackground(Color.WHITE);
		setSize((int)di.getWidth(),(int)di.getHeight());
		setResizable(false);
		getContentPane().setBackground(Color.WHITE);

		lbl.setBounds(0,0,getWidth(),getHeight());

		dhead.setBounds(500,30,250,30);
		dhead.setFont(new Font("castellar",1,25));
		dhead.setForeground(new Color(181,230,29));
		
		ddate.setBounds(700,80,150,30);
		ddate.setFont(lblfnt);
		dtdate.setBounds(870,80,100,30);
		dtdate.setFont(txtfnt);
		
		dcmid.setBounds(300,130,180,30);
		dcmid.setFont(lblfnt);
		dtcmid.setBounds(480,130,100,30);
		dtcmid.setFont(txtfnt);
		
		dname.setBounds(300,180,150,30);
		dname.setFont(lblfnt);
		dtname.setBounds(470,180,100,30);
		dtname.setFont(txtfnt);
		
		dddate.setBounds(300,230,150,30);
		dddate.setFont(lblfnt);
		ddtdate.setBounds(470,230,100,30);
		ddtdate.setFont(txtfnt);
		
		dtype.setBounds(300,280,150,30);
		dtype.setFont(lblfnt);
		dctype.setBounds(470,280,100,30);
		dctype.setFont(txtfnt);
		
		did.setBounds(600,280,100,30);
		did.setFont(lblfnt);
		dtid.setBounds(680,280,100,30);
		dtid.setFont(txtfnt);
		
		dalw.setBounds(300,330,150,30);
		dalw.setFont(lblfnt);
		sralw.setBounds(300,380,150,120);
		dtalw.setFont(txtfnt);
		
		dnalw.setBounds(470,330,150,30);
		dnalw.setFont(lblfnt);
		srnalw.setBounds(470,380,150,120);
		dtnalw.setFont(txtfnt);
		
		dlist.setBounds(640,330,150,30);
		dlist.setFont(lblfnt);
		srlist.setBounds(640,380,150,120);
		dtlist.setFont(txtfnt);
		
		drmk.setBounds(300,520,150,30);
		drmk.setFont(lblfnt);
		dtrmk.setBounds(470,520,200,50);
		dtrmk.setFont(txtfnt);

		tbl=new JTable(data,col);
		pnl=new JScrollPane(tbl);
		tbl.setModel(model);
		add(pnl);

		pnl.setBounds(800,150,500,250);
		tbl.getColumnModel().getColumn(0).setPreferredWidth(4);

		dnew.setBounds(270,600,120,30);
		dnew.setFont(btfnt);
		dsave.setBounds(400,600,120,30);
		dsave.setFont(btfnt);
		dsearch.setBounds(530,600,120,30);
		dsearch.setFont(btfnt);
		dcan.setBounds(660,600,120,30);
		dcan.setFont(btfnt);
		
		dctype.addItem("Select Type");
		try
		{
			Connection con=DriverManager.getConnection("jdbc:odbc:SpaSystemDsn");
			Statement st=con.createStatement();
			ResultSet res=st.executeQuery("select * from diettbl");
			while(res.next())
			{
				dctype.addItem(res.getString(2));
			}
		}
		catch(Exception ee)
		{
			System.out.println(ee);
		}
		add(dnew);
		add(dsave);
		add(dsearch);
		add(dcan);
		add(drmk);
		add(dtrmk);
		add(dlist);
		add(srlist);
		add(dnalw);
		add(srnalw);
		add(dalw);
		add(sralw);
		add(dtype);
		add(dctype);
		add(dhead);
		add(ddate);
		add(dtdate);
		add(dcmid);
		add(dtcmid);
		add(dname);
		add(dtname);
		add(dddate);
		add(ddtdate);
		add(did);
		add(dtid);
		
		add(lbl);
		repaint();
		
		dtname.setEditable(false);
		dtdate.setEditable(false);
		dtid.setEditable(false);
		dtalw.setEditable(false);
		dtnalw.setEditable(false);
		dtlist.setEditable(false);
		
		dtdate.setText(""+cal.get(Calendar.DATE)+"/"+(cal.get(Calendar.MONTH)+1)+"/"+cal.get(Calendar.YEAR));
		ddtdate.setText(dtdate.getText());
		
		
		pnl.setVisible(false);
		
		dnew.addActionListener(this);
		dsave.addActionListener(this);
		dsearch.addActionListener(this);
		dcan.addActionListener(this);
		
		dtcmid.addFocusListener(this);
		dctype.addActionListener(this);
		
		
		///Validation....
		dsave.setEnabled(false);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==dnew)
		{
			dtcmid.setText("");
			ddtdate.setText(dtdate.getText());
			dtname.setText("");
			dctype.setSelectedIndex(0);
			dtid.setText("");
			dtalw.setText("");
			dtnalw.setText("");
			dtlist.setText("");
			dtrmk.setText("");
			pnl.setVisible(false);
			dsave.setEnabled(true);
		}
		if(e.getSource()==dctype)
		{
			try
			{
				Connection con=DriverManager.getConnection("jdbc:odbc:SpaSystemDsn");
				Statement st=con.createStatement();
				ResultSet res=st.executeQuery("Select * from diettbl where diettype='"+dctype.getSelectedItem()+"'");
				while(res.next())
				{
					dtid.setText(res.getString(1));
					dtalw.setText(res.getString(3));
					dtnalw.setText(res.getString(4));
					dtlist.setText(res.getString(5));
				}
			}
			catch(Exception ee)
			{
				System.out.println(ee);
			}
		}
		if(e.getSource()==dsave)
		{
			int flg=0;
			try
			{
				Connection con=DriverManager.getConnection("jdbc:odbc:SpaSystemDsn");
				String str="insert into dietstbl(cust_mem_id,dietid,diettype,dietdate,remarks) values(?,?,?,?,?)";
				PreparedStatement ps=con.prepareStatement(str);
				if(dtcmid.getText().length()==0||ddtdate.getText().length()==0||did.getText().length()==0||dtalw.getText().length()==0||dtnalw.getText().length()==0||dtlist.getText().length()==0||dtrmk.getText().length()==0)
				{
					flg=1;
					JOptionPane.showMessageDialog(null,"Empty Fields");
				}
				if(flg==0)
				{
					ps.setString(1,dtcmid.getText());
					ps.setString(2,dtid.getText());
					ps.setString(3,dctype.getSelectedItem().toString());
					ps.setString(4,ddtdate.getText());
					ps.setString(5,dtrmk.getText());
					ps.executeUpdate();
					JOptionPane.showMessageDialog(null,"Saved...");
					dtcmid.setText("");
					ddtdate.setText("");
					dtname.setText("");
					dctype.setSelectedIndex(0);
					dtid.setText("");
					dtalw.setText("");
					dtnalw.setText("");
					dtlist.setText("");
					dtrmk.setText("");
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
			int flg=0;
			String tmp=JOptionPane.showInputDialog(null,"Enter Customer/Member ID: ");
			try
			{
				Connection con=DriverManager.getConnection("jdbc:odbc:Spasystemdsn");
				Statement st=con.createStatement();
				ResultSet res=st.executeQuery("select * from dietstbl where cust_mem_id='"+tmp+"'");
				Vector v;
				
				pnl.setVisible(true);
				model.setRowCount(0);
				while(res.next())
				{
					flg=1;
					v=new Vector();
					v.add(tbl.getRowCount()+1);
					dtcmid.setText(tmp);
					v.add(res.getString(3));
					v.add(res.getString(4));
					v.add(res.getString(5));
					model.addRow(v);
				}
				if(flg==0)
				{
					JOptionPane.showMessageDialog(null,"No Record Found!!!");
					ddtdate.setText("");
					dtname.setText("");
					dtcmid.setText("");
					dctype.setSelectedIndex(0);
					dtid.setText("");
					dtalw.setText("");
					dtnalw.setText("");
					dtlist.setText("");
					dtrmk.setText("");
					dsave.setEnabled(false);
				}
				else
				{
				ResultSet res1=null;
				if(tmp.charAt(0)=='M'||tmp.charAt(0)=='m')
				{
					res1=st.executeQuery("select * from membertbl where mem_id='"+tmp+"'");
				}
				if(tmp.charAt(0)=='C'||tmp.charAt(0)=='c')
				{
					res1=st.executeQuery("select * from customertbl where custid='"+tmp+"'");
				}
					while(res1.next())
					{
						dtname.setText(res1.getString(3));
					}
					
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
	public void focusLost(FocusEvent fe)
	{
		if(fe.getComponent()==dtcmid)
		{
			if(dtcmid.getText().length()!=0)
			{
				String tmp=dtcmid.getText();
				String ch=""+tmp.substring(0,1);
				try
				{
					Connection con=DriverManager.getConnection("jdbc:odbc:SpaSystemDsn");
					ResultSet res=null;
					Statement st=con.createStatement();
					if(ch.equals("m")||ch.equals("M"))
					{
						res=st.executeQuery("select * from membertbl where mem_id='"+tmp+"'");					
					}
					if(ch.equals("c")||ch.equals("C"))
					{
						res=st.executeQuery("select * from customertbl where custid='"+tmp+"'");
					}
					while(res.next())
					{
						dtcmid.setText(res.getString(2));
						dtname.setText(res.getString(3));
					}
				}
				catch(Exception ee)
				{
					System.out.println(ee);
				}
			}
		}
	}
	public void focusGained(FocusEvent fe)
	{
	}
	public static void main(String argv[])
	{
		diett obj=new diett();
	}
}
