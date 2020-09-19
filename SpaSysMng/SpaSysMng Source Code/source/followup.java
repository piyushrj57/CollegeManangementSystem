import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;
import javax.swing.table.DefaultTableModel;
public class followup extends JFrame implements ActionListener,FocusListener
{

	JLabel lbl=new JLabel(new ImageIcon("../Images/trac.jpg"));	

	JLabel fdate=new JLabel("Date");
	JLabel feid=new JLabel("Enuiry ID");
	JLabel fid=new JLabel("Followup ID");
	JLabel fstatus=new JLabel("Status");
	JLabel fhead=new JLabel("Followup");

	JLabel fname=new JLabel("Name");
	JLabel fph=new JLabel("Phone No.");
	JLabel fmail=new JLabel("E-Mail");

	JTextField tdate=new JTextField();
	JTextField teid=new JTextField();
	JTextField tfid=new JTextField();

	JTextField tname=new JTextField();
	JTextField tph=new JTextField();
	JTextField tmail=new JTextField();

	JRadioButton rcon=new JRadioButton("Confirm");
	JRadioButton rpend=new JRadioButton("Pending");
	JRadioButton rrej=new JRadioButton("Rejected");
	ButtonGroup bs=new ButtonGroup();

	JButton fnew=new JButton("New",new ImageIcon("../Images/nbt.jpg"));
	JButton fsave=new JButton("Save",new ImageIcon("../Images/sbt.jpg"));
	JButton fsearch=new JButton("Search",new ImageIcon("../Images/sbtn.jpg"));
	JButton fcancel=new JButton("Cancel",new ImageIcon("../Images/cbt.jpg"));

	Calendar cal=Calendar.getInstance();
	JScrollPane pnl=new JScrollPane();
	JTable tbl;
	String []col={"FollowUp ID","Follow Date","Status","Phone No.","E-Mail"};
	String foid,fdat,sts,phno,email;
	Object [][]data={{foid,fdat,sts,phno,email}};
	DefaultTableModel model=new DefaultTableModel(col,0);
	int flg=0;

	Dimension di=Toolkit.getDefaultToolkit().getScreenSize();

	///Fonts......
	Font btfnt=new Font("Consolas",Font.BOLD,15);
	Font lblfnt=new Font("Bookman Old Style",Font.BOLD,15);
	Font txtfnt=new Font("Bookman Old Style",Font.BOLD,12);

	public followup()
	{
		setLayout(null);
		setVisible(true);
		this.getContentPane().setBackground(Color.WHITE);
		setSize((int)di.getWidth(),(int)di.getHeight());
		setResizable(false);
		getContentPane().setBackground(Color.WHITE);

		lbl.setBounds(0,0,getWidth(),getHeight());
				
		fid.setBounds(200,170,100,30);
		fid.setFont(lblfnt);
		tfid.setBounds(320,170,100,30);
		tfid.setFont(txtfnt);
		
		feid.setBounds(600,170,100,30);
		feid.setFont(lblfnt);
		teid.setBounds(710,170,100,30);
		teid.setFont(txtfnt);
		
		fname.setBounds(200,210,100,30);
		fname.setFont(lblfnt);
		tname.setBounds(320,210,180,30);
		tname.setFont(txtfnt);
		
		fph.setBounds(520,210,100,30);
		fph.setFont(lblfnt);
		tph.setBounds(620,210,120,30);
		tph.setFont(txtfnt);
		
		fmail.setBounds(760,210,100,30);
		fmail.setFont(lblfnt);
		tmail.setBounds(840,210,150,30);
		tmail.setFont(txtfnt);
		
		fhead.setBounds(400,50,200,30);
		fhead.setFont(new Font("castellar",1,25));
		fhead.setForeground(new Color(181,230,29));
		
		fstatus.setBounds(200,270,100,30);
		fstatus.setFont(lblfnt);
		rcon.setBounds(320,270,100,30);
		rcon.setFont(lblfnt);
		rpend.setBounds(420,270,100,30);
		rpend.setFont(lblfnt);
		rrej.setBounds(520,270,100,30);
		rrej.setFont(lblfnt);
		
		fdate.setBounds(600,100,100,30);
		fdate.setFont(lblfnt);
		tdate.setBounds(720,100,100,30);
		tdate.setFont(txtfnt);
		
		fnew.setBounds(320,600,120,30);
		fnew.setFont(btfnt);
		fsave.setBounds(450,600,120,30);
		fsave.setFont(btfnt);
		fsearch.setBounds(580,600,120,30);
		fsearch.setFont(btfnt);
		fcancel.setBounds(710,600,120,30);
		fcancel.setFont(btfnt);
		
		tdate.setText(""+cal.get(Calendar.DATE)+"/"+(cal.get(Calendar.MONTH)+1)+"/"+cal.get(Calendar.YEAR));

		tbl=new JTable(data,col);
		pnl=new JScrollPane(tbl);
		tbl.setModel(model);
		pnl.setBounds(200,320,950,250);
		add(pnl);

		
		add(fname);
		add(fph);
		add(fmail);
		add(tname);
		add(tph);
		add(tmail);
		add(fdate);
		add(tdate);
		bs.add(rcon);
		bs.add(rrej);
		bs.add(rpend);
		add(feid);
		add(teid);
		add(rcon);
		add(rrej);
		add(rpend);
		add(fstatus);
		add(fid);
		add(tfid);
		add(fhead);
		
		add(fcancel);
		add(fsearch);
		add(fsave);
		add(fnew);
		
		add(lbl);
		repaint();

		fnew.addActionListener(this);
		fsearch.addActionListener(this);
		fsave.addActionListener(this);
		fcancel.addActionListener(this);

		teid.addFocusListener(this);
		tdate.setEditable(false);
		tfid.setEditable(false);
		fsave.setEnabled(false);
		///Validation
		
		tname.setEditable(false);
		tph.setEditable(false);
		tmail.setEditable(false);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==fnew)
		{
			int ctr=0;
			try
			{
				Connection con=DriverManager.getConnection("jdbc:odbc:SpaSystemdsn");
				Statement st=con.createStatement();
				ResultSet res=st.executeQuery("select * from keytbl");
				while(res.next())
				{
					ctr=Integer.parseInt(res.getString(7));
				}
				if(ctr<10)
					tfid.setText("F00"+ctr);
				if(ctr>=10&&ctr<100)
					tfid.setText("F0"+ctr);
				if(ctr>=100&&ctr<1000)
					tfid.setText("F"+ctr);
				
				teid.setText("");
				tname.setText("");
				tph.setText("");
				tmail.setText("");
				bs.clearSelection();
				model.setRowCount(0);
				fsave.setEnabled(true);
			}
			catch(Exception ee)
			{
				System.out.println(ee);
			}
		}
	if(e.getSource()==fsave)
		{
			String strpen="";
			int qflg=0;
			if(flg==0&&tbl.getRowCount()>0)
			{
				try
				{
					Connection con=DriverManager.getConnection("jdbc:odbc:SpaSystemdsn");
					ResultSet res;
					Statement st=con.createStatement();
				if(feid.getText().length()==0)
				{
					JOptionPane.showMessageDialog(null,"Empty Fields!!!");
					qflg=1;
				}
				if(qflg==0)
				{
					res=st.executeQuery("select * from enquirytbl where enqid='"+teid.getText()+"'");
					String r="";
					String r1="";
					String r2="";
					while(res.next())
					{
						r=res.getString(2);
						r1=res.getString(7);
						r2=res.getString(8);
					}

					String str="insert into followtbl(enquiryid,followid,status,fdate) values(?,?,?,?)";
					PreparedStatement ps=con.prepareStatement(str);
					ps.setString(1,teid.getText());
					ps.setString(2,tfid.getText());
					if(rcon.isSelected())
					{
						strpen="Confirm";
					}
					else
					{
						if(rpend.isSelected())
						{
							strpen="Pending";
						}
						else
						{
							strpen="Rejected";
						}
					}
					ps.setString(3,strpen);
					ps.setString(4,tdate.getText());
					ps.executeUpdate();

					if(strpen.equals("Confirm")||strpen.equals("Rejected"))
					{
						String str2="update enquirytbl set enqstatus='"+strpen+"' where enqid='"+teid.getText()+"'";
						Statement st2=con.createStatement();
						st2.executeUpdate(str2);
					}
					String str1="update keytbl set followid=followid+1";
					Statement st1=con.createStatement();
					st1.executeUpdate(str1);
					flg=0;
					JOptionPane.showMessageDialog(null,"Data Saved!!!!");
					Vector v=new Vector();
					v.add(tfid.getText());
					v.add(teid.getText());
					v.add(r);
					v.add(tdate.getText());
					v.add(strpen);
					v.add(r1);
					v.add(r2);
					model.addRow(v);
					tfid.setText("");
					teid.setText("");
					tname.setText("");
					tph.setText("");
					tmail.setText("");
					
					bs.clearSelection();
				}	
			}
			catch(Exception ee)
			{
				System.out.println(ee);
			}
		}
			else
			{
				JOptionPane.showMessageDialog(null,"Can't Save!!");
			}
	}
	if(e.getSource()==fsearch)
			{
				int sflg=0;
				
				try
				{
					String m=JOptionPane.showInputDialog("Enter Enquiry ID to be search:");
					Connection con=DriverManager.getConnection("jdbc:odbc:SpaSystemdsn");
					Statement st=con.createStatement();
					String t="";
	
					model.setRowCount(0);
					ResultSet res1=st.executeQuery("select * from enquirytbl where enqid='"+m+"'");
					while(res1.next())
					{
						sflg=1;
						teid.setText(res1.getString(1));
						tname.setText(res1.getString(2));
						tph.setText(res1.getString(6));
						tmail.setText(res1.getString(7));
						t=res1.getString(9);
						if(t.equals("Confirm"))
						{
							rcon.setSelected(true);
						}
						else if(t.equals("Pending"))
						{
							rpend.setSelected(true);
						}
						else
						{
							rrej.setSelected(true);
						}
					}

					ResultSet res2=st.executeQuery("select * from followtbl where enquiryid='"+m+"'");
					Vector v;
					while(res2.next())
					{
						v=new Vector();
						v.add(res2.getString(2));
						v.add(res2.getString(4));
						v.add(res2.getString(3));
						v.add(res2.getString(5));
						v.add(res2.getString(6));
						model.addRow(v);
					}
					if(sflg==0)
					{
						JOptionPane.showMessageDialog(null,"No Such Record Found!!");
						teid.setText("");
						tfid.setText("");
						tname.setText("");
						tph.setText("");
						tmail.setText("");
						bs.clearSelection();
						model.setRowCount(0);
					}
				}
				catch(Exception ee)
				{
					System.out.println(ee);
				}
			}
			if(e.getSource()==fcancel)
			{
				this.dispose();
			}

	}
		public void focusLost(FocusEvent fe)
		{
			if(fe.getComponent()==teid)
			{
				flg=0;
				if(teid.getText().length()!=0)
				{
				model.setRowCount(0);
				try
				{
					Connection con=DriverManager.getConnection("jdbc:odbc:SpaSystemdsn");
					Statement st=con.createStatement();
					String t="";
					tname.setText("");
					tph.setText("");
					tmail.setText("");
					bs.clearSelection();
					ResultSet res1=st.executeQuery("select * from enquirytbl where enqid='"+teid.getText()+"'");
					while(res1.next())
					{
						tname.setText(res1.getString(2));		//Enquiry Name
						tmail.setText(res1.getString(7));		//Enquiry Email
						tph.setText(res1.getString(6));		//Phone no.
						t=res1.getString(9);		//Enquiry Status
						if(t.equals("Confirm"))
						{
							rcon.setSelected(true);
						}
						else if(t.equals("Pending"))
						{
							rpend.setSelected(true);
						}
						else
						{
							rrej.setSelected(true);
						}
					}

					ResultSet res2=st.executeQuery("select * from followtbl where enquiryid='"+teid.getText()+"'");
					Vector v;
					while(res2.next())
					{
						v=new Vector();
						v.add(res2.getString(2));
						v.add(res2.getString(4));
						v.add(res2.getString(3));
						v.add(res2.getString(5));
						v.add(res2.getString(6));
						model.addRow(v);
					}
					
					if(model.getRowCount()>0)
					{
						String s=""+tbl.getValueAt(tbl.getRowCount()-1,2);
						if(s.equals("Confirm")||s.equals("Rejected"))
						{
							flg=1;
						}
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
		public static void main(String argv[])throws IOException
		{
			followup obj=new followup();
		}
	}
