import java.awt.event.*;
import java.applet.*;
import java.awt.*;
import java.io.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;
import javax.swing.table.DefaultTableModel;
public class  packagef extends JFrame implements ActionListener,FocusListener
{	
	JLabel lbl=new JLabel(new ImageIcon("../Images/mas.jpg"));

	int sflg=0;
	String tmp,strgen,strpen;
	JLabel lpack_id=new JLabel("Package Id");
	JLabel lpack_name=new JLabel("Package Name");
	JLabel lctype=new JLabel("Treatment Type");

	JLabel lpack_rcost=new JLabel("Real Cost");
	JLabel lpack_dis=new JLabel("Discount");
	JLabel lpack_cost=new JLabel("Cost");
	JLabel lpack_head=new JLabel("PACKAGE");
	JLabel lpack_type1=new JLabel("Treatment");
	JLabel lpack_tax=new JLabel("Service Tax");
	
	JTextField txpack_id=new JTextField();
	JTextField txpack_name=new JTextField();
	JTextField txpack_rcost=new JTextField();
	JTextField txpack_cost=new JTextField();
	JTextField txpack_dis=new JTextField();
	JTextField txpack_tax=new JTextField();
	
	JButton padd=new JButton("Add");
	JButton premove=new JButton("Remove");
	JButton psave=new JButton("Save",new ImageIcon("../Images/msbt.jpg"));
	JButton psearch=new JButton("Search",new ImageIcon("../Images/mssbt.jpg"));
	JButton pnew=new JButton("New",new ImageIcon("../Images/mnbt.jpg"));
	JButton pedit=new JButton("Edit",new ImageIcon("../Images/mebt.jpg"));
	JButton pcancel=new JButton("Cancel",new ImageIcon("../Images/mcbt.jpg"));
	
	JComboBox ctype1=new JComboBox();	
	JComboBox ctreat1=new JComboBox();
	double fcost=0.0;
	
	JScrollPane pnl=new JScrollPane();
	JTable tbl;

	String []col={"Treatment ID","Type","Name","Cost"};
	String tid,ttyp,tnm,tcost;
	Object[][]data={{tid,ttyp,tnm,tcost}};
	DefaultTableModel model=new DefaultTableModel(col,0);
	int pctr=1;
	int ctr=1;
	String trt="";
	double cost=0.0;
	int flg=0;
	double c=0.0;
	
	String strchk="";

	Dimension di=Toolkit.getDefaultToolkit().getScreenSize();	

	JTextField txline=new JTextField();

	///Fonts....
	Font btfnt=new Font("Consolas",Font.BOLD,15);
	Font lblfnt=new Font("Bookman Old Style",Font.BOLD,15);
	Font txtfnt=new Font("Bookman Old Style",Font.BOLD,12);
		
	public packagef()
	{
		setLayout(null);
		setVisible(true);
		this.getContentPane().setBackground(Color.WHITE);
		setSize((int)di.getWidth(),(int)di.getHeight());
		setResizable(false);

		lbl.setBounds(0,0,getWidth(),getHeight());
		
		lpack_head.setBounds(300,50,150,30);
		lpack_head.setFont(new Font("castellar",1,25));
		lpack_head.setForeground(new Color(163,73,164));
		
		lpack_id.setBounds(130,130,100,30);
		lpack_id.setFont(lblfnt);
		txpack_id.setBounds(250,130,60,30);
		txpack_id.setFont(txtfnt);
		
		lpack_name.setBounds(130,180,120,30);
		lpack_name.setFont(lblfnt);
		txpack_name.setBounds(250,180,150,30);
		txpack_name.setFont(txtfnt);
		
		lpack_type1.setBounds(130,230,100,30);
		lpack_type1.setFont(lblfnt);
		ctype1.setBounds(130,270,150,30);
		ctype1.setFont(txtfnt);
		
		padd.setBounds(550,500,100,30);
		padd.setFont(btfnt);
		premove.setBounds(670,500,100,30);
		premove.setFont(btfnt);
		
		ctreat1.setBounds(300,270,150,30);
		ctreat1.setFont(txtfnt);
		
		lpack_rcost.setBounds(130,320,100,30);
		lpack_rcost.setFont(txtfnt);
		txpack_rcost.setBounds(250,320,100,30);
		txpack_rcost.setFont(txtfnt);
		
		lpack_dis.setBounds(130,370,100,30);
		lpack_dis.setFont(lblfnt);
		txpack_dis.setBounds(250,370,100,30);
		txpack_dis.setFont(txtfnt);
		
		lpack_tax.setBounds(130,420,100,30);
		lpack_tax.setFont(lblfnt);
		txpack_tax.setBounds(250,420,100,30);
		txpack_tax.setFont(txtfnt);
		
		lpack_cost.setBounds(130,470,100,30);
		lpack_cost.setFont(lblfnt);
		txpack_cost.setBounds(250,470,100,30);
		txpack_cost.setFont(txtfnt);
		
		pnew.setBounds(120,600,120,30);
		pnew.setFont(btfnt);
		psave.setBounds(250,600,120,30);
		psave.setFont(btfnt);
		pedit.setBounds(380,600,120,30);
		pedit.setFont(btfnt);
		psearch.setBounds(510,600,120,30);
		psearch.setFont(btfnt);
		pcancel.setBounds(640,600,120,30);
		pcancel.setFont(btfnt);
		
	
		add(lpack_head);
		add(lpack_id);
		add(txpack_id);
		add(lpack_tax);
		add(lpack_name);
		
		add(txpack_name);
		add(txpack_tax);
		add(ctreat1);
		add(premove);
		add(padd);
		
		ctreat1.addItem("");
		tbl=new JTable(data,col);
		pnl=new JScrollPane(tbl);
		tbl.setModel(model);
		add(pnl);
		add(lpack_rcost);
		add(txpack_cost);
		add(lpack_cost);
		add(txpack_rcost);
		add(lpack_dis);
		add(txpack_dis);
		add(psave);
		add(pedit);
		add(pcancel);
		add(psearch);
		add(pnew);
		pnl.setBounds(460,220,450,250);
		tbl.setBounds(470,220,450,100);
		
		add(ctype1);
		add(lpack_type1);

		add(lbl);
		repaint();
		
		padd.addActionListener(this);
		premove.addActionListener(this);
		pnew.addActionListener(this);
		psave.addActionListener(this);
		psearch.addActionListener(this);
		pedit.addActionListener(this);
		pcancel.addActionListener(this);
		ctreat1.addActionListener(this);
		ctype1.addActionListener(this);
		
		txpack_tax.setEditable(false);
		txpack_id.setEditable(false);
		psave.setEnabled(false);
		txpack_rcost.setEditable(false);
		txpack_cost.setEditable(false);
		//Validation....
		txpack_dis.addFocusListener(this);
	}
	
	public void treat(String ttmp,int i)
	{
			try	
			{
				Connection con=DriverManager.getConnection("jdbc:odbc:SpaSystemdsn");
				String str="select * from treatmenttbl where treat_type='"+ttmp+"'";
				Statement st=con.createStatement();
				ResultSet res=st.executeQuery(str);
				if(i==1)
				{
					ctreat1.removeAllItems();
					ctreat1.addItem("");
				}
				while(res.next())
				{
					if(i==1)
							ctreat1.addItem(res.getString(3).toString());
				}
			}	
			catch(Exception ee)
			{
				System.out.println(ee);
			}
	}
	public void focusLost(FocusEvent fe)
	{
		int i;
		if(fe.getComponent()==txpack_dis)
		{
			int lflg=0,dflg=0;
			double t=0,t1=0;	
			strchk=txpack_dis.getText();
			if(txpack_dis.getText().length()!=0&&txpack_rcost.getText().length()!=0)
			{
				p:{for(i=0;i<strchk.length();i++)
				{
					if(strchk.charAt(i)>='a'&&strchk.charAt(i)<='z'||strchk.charAt(i)>='A'&&strchk.charAt(i)<='Z')
					{
						JOptionPane.showMessageDialog(null,"Enter Only Digits!!");
						txpack_dis.setText("");
						break p;																
					}	
					else
					{		
						if(Character.getNumericValue(strchk.charAt(i))>=0&&Character.getNumericValue(strchk.charAt(i))<=9||dflg==0)
						{	
							if(strchk.charAt(i)=='.')
							{	
								dflg=1;
							}
							if(i==strchk.length()-1)
							{
								t=(Double.parseDouble(txpack_rcost.getText())-(Double.parseDouble(txpack_rcost.getText())*Double.parseDouble(txpack_dis.getText()))/100);
								txpack_cost.setText(""+t);			
							}
						}
						else
						{
							JOptionPane.showMessageDialog(null,"Invalid Discount Format!!");
							txpack_dis.setText("");
							break p;				
						}
					}
				}}
			}
			else
			{
				txpack_cost.setText(txpack_rcost.getText());
			}
		}
	}
	public void focusGained(FocusEvent fe)
	{
	}
	public void actionPerformed(ActionEvent e)
	{	
		if(e.getSource()==pnew)
		{
			try
			{
				c=0.0;
				Connection con=DriverManager.getConnection("jdbc:odbc:SpaSystemdsn");
				Statement st=con.createStatement();
				ResultSet res=st.executeQuery("select * from keytbl");
				while(res.next())
				{
					ctr=Integer.parseInt(res.getString(4));
				}
				if(ctr<10)
					txpack_id.setText("P00"+ctr);
				if(ctr>=10&&ctr<100)
					txpack_id.setText("P0"+ctr);
				if(ctr>=100&&ctr<1000)
					txpack_id.setText("P"+ctr);
				
				txpack_name.setText("");
				txpack_rcost.setText("");
					txpack_cost.setText("");
				txpack_dis.setText("");
				txpack_tax.setText("");
				ctreat1.removeAllItems();
				model.setRowCount(0);
				if(ctype1.getItemCount()==0)
				{
					ResultSet res1=st.executeQuery("select * from typetbl");
					ctype1.addItem("Select Treatment Type");
					while(res1.next())
					{
						ctype1.addItem(res1.getString(2));
					}
				}
				else
				{
					ctype1.setSelectedIndex(0);
				}
				psave.setEnabled(true);
				txpack_tax.setText("15");
			}
			catch(Exception ee)
			{
				JOptionPane.showMessageDialog(null,ee.getMessage());
			}	
		}
		if(e.getSource()==psave)
		{
			int flg=0;
			try
			{
				Connection con=DriverManager.getConnection("jdbc:odbc:SpaSystemdsn");
				String str="insert into packagetbl(pack_id,pack_name,treat1_id,treat2_id,treat3_id,treat4_id,treat5_id,realcost,discount,tcost,ttax) values(?,?,?,?,?,?,?,?,?,?,?)";
				PreparedStatement ps=con.prepareStatement(str);
				Statement st=con.createStatement();
				if(txpack_name.getText().length()==0||tbl.getRowCount()==0||txpack_dis.getText().length()==0||txpack_tax.getText().length()==0)
				{
					JOptionPane.showMessageDialog(null,"Empty Fields!!!");
					flg=1;
				}
				else
				{
					if(tbl.getRowCount()==1)
					{
						JOptionPane.showMessageDialog(null,"Select Treatments more than one!!");
						flg=1;
					}
				}
				if(flg==0)
				{
					ps.setString(1,txpack_id.getText());
					ps.setString(2,txpack_name.getText());
					ps.setString(3,tbl.getValueAt(0,0).toString());
					ps.setString(4,""+tbl.getValueAt(1,0).toString());
					if(tbl.getRowCount()==2)
					{
						ps.setString(5,"");
						ps.setString(6,"");
						ps.setString(7,"");						
					}
					if(tbl.getRowCount()==3)
					{
						ps.setString(5,""+tbl.getValueAt(2,0).toString());
						ps.setString(6,"");
						ps.setString(7,"");
					}
					if(tbl.getRowCount()==4)
					{
						ps.setString(5,""+tbl.getValueAt(2,0).toString());
						ps.setString(6,""+tbl.getValueAt(3,0).toString());
						ps.setString(7,"");
					}
					if(tbl.getRowCount()==5)
					{
						ps.setString(5,""+tbl.getValueAt(2,0).toString());
						ps.setString(6,""+tbl.getValueAt(3,0).toString());
						ps.setString(7,""+tbl.getValueAt(4,0).toString());
					}
					ps.setString(8,txpack_rcost.getText());
					ps.setString(9,txpack_dis.getText());
					ps.setString(10,txpack_cost.getText());
					ps.setString(11,txpack_tax.getText());
					ps.executeUpdate();
				
					st.executeUpdate("update keytbl set pack_id=pack_id+1");
					
					JOptionPane.showMessageDialog(null,"Saved");
					txpack_id.setText("");
					txpack_name.setText("");
					if(ctype1.getItemCount()!=0)
						ctype1.setSelectedIndex(0);
					if(ctreat1.getItemCount()!=0)
						ctreat1.setSelectedIndex(0);
					txpack_cost.setText("");
					txpack_dis.setText("");
					txpack_rcost.setText("");
					txpack_tax.setText("");
					model.setRowCount(0);
					psave.setEnabled(false);
				}
			}
			catch(Exception ee)
			{
				System.out.println(ee);
			}
		}
		if(e.getSource()==ctype1)
		{
			tmp=ctype1.getSelectedItem().toString();
			treat(tmp,1);
		}
		if(e.getSource()==padd)
		{
			int flg=0;
			txpack_dis.setText("0");
			try
			{
				if(tbl.getRowCount()<5)
				{	
					Connection con=DriverManager.getConnection("jdbc:odbc:SpaSystemdsn");
					ResultSet res;
					Statement st=con.createStatement();
					String str="select * from treatmenttbl where treat_name='"+ctreat1.getSelectedItem()+"'";
					res=st.executeQuery(str);
					
					while(res.next())
					{
						Vector vec=new Vector();
						trt=res.getString(1).toString();
						for(int i=0;i<tbl.getRowCount();i++)
						{
							if(trt.equals(tbl.getValueAt(i,0)))
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
							vec.add(res.getString(2));
							vec.add(res.getString(3));
							String tm=res.getString(4);
							c=c+Double.parseDouble(tm);
							txpack_rcost.setText(""+c);
							txpack_cost.setText(""+c);
							vec.add(tm);						
							model.addRow(vec);
						}
					}
				} 
				else
				{
				JOptionPane.showMessageDialog(null,"Only 5 Treatments can be placed!!!");						
				}
			}
			
			catch(Exception ee)
			{
				System.out.print(ee);
			}
		}
		if(e.getSource()==psearch)
		{
			sflg=1;	
			psave.setEnabled(false);
			String t=JOptionPane.showInputDialog("Enter Package id to search");
			int flg=0,i;
			try
			{
				Connection con=DriverManager.getConnection("jdbc:odbc:SpaSystemdsn");
				ResultSet res;
				String str="select * from packagetbl where pack_id='"+t+"'";
				Statement st=con.createStatement();
				res=st.executeQuery(str);
				model.setRowCount(0);
				String s[]=new String[5];
				while(res.next())
				{
					flg=1;
					txpack_id.setText(res.getString(1));
					txpack_name.setText(res.getString(2));
					txpack_rcost.setText(res.getString(8));
					c=Double.parseDouble(txpack_rcost.getText());
					txpack_dis.setText(res.getString(9));
					txpack_cost.setText(res.getString(10));
					txpack_tax.setText(res.getString(11));
					s[0]=res.getString(3);
					s[1]=res.getString(4);
					s[2]=res.getString(5);
					s[3]=res.getString(6);
					s[4]=res.getString(7);
				}
				if(flg==1)
				{
					int j=0;
					while(j<5)
					{
						str="select * from treatmenttbl where treat_id='"+s[j]+"'";
						Statement st1=con.createStatement();
						ResultSet res1=st.executeQuery(str);
						Vector v=new Vector();
						while(res1.next())
						{
						v.add(res1.getString(1));
						v.add(res1.getString(2));
						v.add(res1.getString(3));
						v.add(res1.getString(4));
						model.addRow(v);
						}
						j++;
					}										
				}
				if(flg==0)
				{
					JOptionPane.showMessageDialog(null,"No Record Found!!");
					txpack_id.setText("");
					txpack_name.setText("");
					if(ctype1.getItemCount()!=0)
						ctype1.setSelectedIndex(0);
					if(ctreat1.getItemCount()!=0)
						ctreat1.setSelectedIndex(0);
					txpack_cost.setText("");
					txpack_dis.setText("");
					txpack_rcost.setText("");
					txpack_tax.setText("");
					model.setRowCount(0);
				}
				else
				{
					ctreat1.removeAllItems();
					if(ctype1.getItemCount()==0)
					{
						ResultSet res2=st.executeQuery("select * from typetbl");
						ctype1.addItem("Select Treatment Type");
						while(res2.next())
						{
							ctype1.addItem(res2.getString(2));
						}
					}
					else
					{
						ctype1.setSelectedIndex(0);
					}
				}
			}
			catch(Exception ee)
			{
				System.out.print(ee);
			}
		}
		if(e.getSource()==pedit)
		{
			psave.setEnabled(false);
			int tflg=0,flg=0;
			try
			{
				Connection con=DriverManager.getConnection("jdbc:odbc:SpaSystemdsn");
				Statement st=con.createStatement();
			
					String strm[]=new String[5];
					int n=tbl.getRowCount();
					
					for(int i=0;i<5;i++)
					{
						if(i<n)
							strm[i]=tbl.getValueAt(i,0).toString();
						else
							strm[i]="";
						
					}
					
				if(txpack_id.getText().length()!=0&&sflg==1)
				{	
					if(txpack_name.getText().length()==0||tbl.getRowCount()==0||txpack_dis.getText().length()==0||txpack_tax.getText().length()==0)
					{
						JOptionPane.showMessageDialog(null,"Empty Fields!!!");
						flg=1;
					}
					if(flg==0)
					{
						String str="update packagetbl set pack_name='"+txpack_name.getText()+"',treat1_id='"+strm[0]+"',treat2_id='"+strm[1]+"',treat3_id='"+strm[2]+"',treat4_id='"+strm[3]+"',treat5_id='"+strm[4]+"',realcost='"+txpack_rcost.getText()+"',discount='"+txpack_dis.getText()+"',tcost='"+txpack_cost.getText()+"' where pack_id='"+txpack_id.getText()+"'";
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
					System.out.println(ee);
				}
		}		
		if(e.getSource()==premove)
		{
			int i;
			try
			{
				if(tbl.getRowCount()>0)
				{
					String t=JOptionPane.showInputDialog("Enter Row Number to Remove");
					for(i=0;i<=tbl.getRowCount();i++)
					{
						if(i==Integer.parseInt(t))
						{
							String tm=""+tbl.getValueAt(Integer.parseInt(t)-1,3);
							
							model.removeRow(Integer.parseInt(t)-1);
							
							c=Double.parseDouble(txpack_rcost.getText());
							c=c-Double.parseDouble(tm);
							txpack_rcost.setText(""+c);
						}
					}
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
	}
	public static void main(String argv[])
	{
		packagef obj=new packagef();
	}
}