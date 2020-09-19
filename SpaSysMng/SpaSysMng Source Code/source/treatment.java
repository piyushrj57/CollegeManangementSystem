import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.io.*;
import javax.swing.*;
import java.sql.*;
public class treatment extends JFrame implements ActionListener,FocusListener,ItemListener
{
	JLabel lbl=new JLabel(new ImageIcon("../Images/mas.jpg"));
	
	
	String strgen,strpen,dt;
	int sflg=0;
	JLabel lid=new JLabel("Treatment id");
	JLabel ltype=new JLabel("Treatment Type");
	JLabel ltname=new JLabel("Treatment Name");
	JLabel lcost=new JLabel("Cost");

	JLabel ldur=new JLabel("Duration(in mins)");

	JLabel lh=new JLabel("Treatment Information");
	JLabel lsup=new JLabel("Suppliments");
	JLabel ldiettype=new JLabel("Diet Type");
	JLabel lnalw=new JLabel("Not Allowed");
	JLabel lalw=new JLabel("Allowed");
	JLabel llist=new JLabel("Food List");
	
	JButton tnew=new JButton("New",new ImageIcon("../Images/mnbt.jpg"));
	JButton tsave=new JButton("Save",new ImageIcon("../Images/msbt.jpg"));
	JButton tsearch=new JButton("Search",new ImageIcon("../Images/mssbt.jpg"));
	JButton tedit=new JButton("Edit",new ImageIcon("../Images/mebt.jpg"));
	JButton tcancel=new JButton("Cancel",new ImageIcon("../Images/mcbt.jpg"));
	JButton tadd=new JButton("New Diet");
	
	JTextField tid=new JTextField();
	JTextField ttname=new JTextField();
	JTextField tcost=new JTextField();
	JTextField tdur=new JTextField();
	
	JTextArea tlist=new JTextArea();
	JTextArea tnalw=new JTextArea();
	JTextArea talw=new JTextArea();
	
	JComboBox cdtype=new JComboBox();
	JComboBox ctype=new JComboBox();
	String strchk="";

	Dimension di=Toolkit.getDefaultToolkit().getScreenSize();	

	JTextField txline=new JTextField();
	///Fonts....
	Font btfnt=new Font("Consolas",Font.BOLD,15);
	Font lblfnt=new Font("Bookman Old Style",Font.BOLD,15);
	Font txtfnt=new Font("Bookman Old Style",Font.BOLD,12);
	
	JScrollPane srlist=new JScrollPane(tlist,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	JScrollPane srnalw=new JScrollPane(tnalw,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	JScrollPane sralw=new JScrollPane(talw,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	
	public treatment()
	{
		setLayout(null);
		setVisible(true);
		this.getContentPane().setBackground(Color.WHITE);
		setSize((int)di.getWidth(),(int)di.getHeight());
		setResizable(false);

		lbl.setBounds(0,0,getWidth(),getHeight());
		
		lh.setBounds(350,50,450,30);
		lh.setFont(new Font("Castellar",1,25));
		lh.setForeground(new Color(163,73,164));
		
		lid.setBounds(170,150,120,30);
		lid.setFont(lblfnt);
		tid.setBounds(300,150,80,30);
		tid.setFont(txtfnt);
		
		ltype.setBounds(170,200,140,30);
		ltype.setFont(lblfnt);
		ctype.setBounds(320,200,150,30);
		ctype.setFont(txtfnt);
		
		ltname.setBounds(170,250,140,30);
		ltname.setFont(lblfnt);
		ttname.setBounds(320,250,160,30);
		ttname.setFont(txtfnt);
		
		lcost.setBounds(170,300,100,30);
		lcost.setFont(lblfnt);
		tcost.setBounds(300,300,80,30);
		tcost.setFont(txtfnt);
		
		ldur.setBounds(400,300,140,30);
		ldur.setFont(lblfnt);
		tdur.setBounds(550,300,100,30);
		tdur.setFont(txtfnt);
		
		lsup.setBounds(350,330,100,30);
		lsup.setFont(lblfnt);
		
		ldiettype.setBounds(170,400,100,30);
		ldiettype.setFont(lblfnt);
		cdtype.setBounds(170,440,100,30);
		cdtype.setFont(txtfnt);
		
		tadd.setBounds(170,490,100,30);
		tadd.setFont(btfnt);
		
		lalw.setBounds(300,360,100,30);
		lalw.setFont(lblfnt);
		sralw.setBounds(290,400,140,150);
		talw.setFont(txtfnt);
		
		lnalw.setBounds(460,360,100,30);
		lnalw.setFont(lblfnt);
		srnalw.setBounds(450,400,140,150);
		tnalw.setFont(txtfnt);
		
		llist.setBounds(610,360,100,30);
		llist.setFont(lblfnt);
		srlist.setBounds(600,400,140,150);
		tlist.setFont(txtfnt);
		
		tnew.setBounds(120,600,120,30);
		tnew.setFont(btfnt);
		tsave.setBounds(250,600,120,30);
		tsave.setFont(btfnt);
		tsearch.setBounds(380,600,120,30);
		tsearch.setFont(btfnt);
		tedit.setBounds(510,600,120,30);
		tedit.setFont(btfnt);
		tcancel.setBounds(640,600,120,30);
		tcancel.setFont(btfnt);
		
		
		
		add(lsup);
		add(ldiettype);
		add(lalw);
		add(sralw);
		add(lnalw);
		add(srnalw);
		add(llist);
		add(srlist);
		
		add(ctype);
		add(cdtype);
		
		add(tcancel);
		add(tnew);
		add(tsave);
		add(tsearch);
		add(tedit);
		add(tadd);
		add(tdur);
		add(ldur);
		add(lh);
		add(tcost);
		add(lcost);
		add(ltname);
		add(ttname);
		add(ltype);
		add(lid);
		add(tid);
		
		lsup.setVisible(false);
		ldiettype.setVisible(false);
		cdtype.setVisible(false);
		lalw.setVisible(false);
		sralw.setVisible(false);
		lnalw.setVisible(false);
		srnalw.setVisible(false);
		llist.setVisible(false);
		srlist.setVisible(false);
		tadd.setVisible(false);
		
		cdtype.addItem("Select Type");
		try
		{
			Connection con=DriverManager.getConnection("jdbc:odbc:SpaSystemdsn");
			Statement st=con.createStatement();
			ResultSet res=st.executeQuery("select * from diettbl");
			while(res.next())
			{
				cdtype.addItem(res.getString(2));
			}
				ResultSet res1=st.executeQuery("select * from typetbl");
				ctype.addItem("Select Treatment Type");
				while(res1.next())
				{
					ctype.addItem(res1.getString(2));
				}
			}
		catch(Exception ee)
		{
			System.out.println(ee);
		}
		add(lbl);
		repaint();
		
		cdtype.addActionListener(this);
		tnew.addActionListener(this);
		tsave.addActionListener(this);
		tsearch.addActionListener(this);
		tcancel.addActionListener(this);
		tedit.addActionListener(this);
		ctype.addItemListener(this);
		tadd.addActionListener(this);
		//Validation....
			tid.setEditable(false);
			tsave.setEnabled(false);
			tcost.addFocusListener(this);
			tedit.setEnabled(false);
			
	}
	public void display()
	{
		if(ctype.getSelectedItem().equals("Weight Loss"))
		{	
			lsup.setVisible(true);
			ldiettype.setVisible(true);
			cdtype.setVisible(true);
			lalw.setVisible(true);
			sralw.setVisible(true);
			lnalw.setVisible(true);
			srnalw.setVisible(true);
			llist.setVisible(true);
			srlist.setVisible(true);
			tadd.setVisible(true);
		}
		else
		{
			lsup.setVisible(false);
			ldiettype.setVisible(false);
			cdtype.setVisible(false);
			lalw.setVisible(false);
			sralw.setVisible(false);
			lnalw.setVisible(false);
			srnalw.setVisible(false);
			llist.setVisible(false);
			srlist.setVisible(false);
			tadd.setVisible(false);
		}
	}
	public void itemStateChanged(ItemEvent ie)
	{
		if(ie.getSource()==ctype)
		{
			if(ie.getStateChange()==ItemEvent.SELECTED)
			{
					display();
			}
		}
	}
	
	public void focusLost(FocusEvent fe)
	{
		if(fe.getComponent()==tcost)
		{
			int i,tmflg=0,dflg=0;
			strchk=tcost.getText();
			if(tcost.getText().length()==0)
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
					if(strchk.charAt(i)>='a'&&strchk.charAt(i)<='z'||strchk.charAt(i)>='A'&&strchk.charAt(i)<='Z')
					{
						JOptionPane.showMessageDialog(null,"Enter Only Digits!!");
							tcost.setText("");
							break p;		
					}
					else
					{
						if(Character.getNumericValue(strchk.charAt(i))>=0&&Character.getNumericValue(strchk.charAt(i))<=9||dflg==0)
						{
							if(strchk.charAt(i)=='.')
								dflg=1;
						}
						else
						{
							JOptionPane.showMessageDialog(null,"Enter Only Digits!!");
							tcost.setText("");
							break p;				
						}
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
		if(e.getSource()==tsave)
		{	
			tedit.setEnabled(false);
			int flg=0;
			try
			{
				Connection con=DriverManager.getConnection("jdbc:odbc:SpaSystemdsn");
				String str="insert into treatmenttbl(treat_id,treat_type,treat_name,t_cost,t_duration,dietid)values(?,?,?,?,?,?)";
				PreparedStatement ps=con.prepareStatement(str);
				Statement st=con.createStatement();
				if(ctype.getSelectedIndex()==0||ttname.getText().length()==0||tcost.getText().length()==0||tdur.getText().length()==0||cdtype.getSelectedIndex()==0||talw.getText().length()==0||tnalw.getText().length()==0||tlist.getText().length()==0)
				{
					JOptionPane.showMessageDialog(null,"Empty Fields!!!");
					flg=1;
				}	
				if(flg==0)
				{
					ps.setString(1,tid.getText());
					ps.setString(2,ctype.getSelectedItem().toString());
					ps.setString(3,ttname.getText());
					ps.setString(4,tcost.getText());
					ps.setString(5,tdur.getText());
					if(ctype.getSelectedItem().equals("Weight Loss"))
					{
						ResultSet res=st.executeQuery("select * from diettbl where diettype='"+cdtype.getSelectedItem()+"'");
						while(res.next())
						{
							dt=res.getString(1);
						}
						ps.setString(6,dt);
					}
					else
					{
						dt="";
					}
					if(ctype.getSelectedIndex()!=0)
					{
						ps.executeUpdate();
						JOptionPane.showMessageDialog(null,"Saved");
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Select the Course Type!!");					
					}	
				
					String str1="update keytbl set treat_id=treat_id+1";
					st.executeUpdate(str1);
					tsave.setEnabled(false);
					tid.setText("");
				
					ttname.setText("");
					tcost.setText("");
					tdur.setText("");
					talw.setText("");
					tnalw.setText("");
					tlist.setText("");
					ctype.setSelectedIndex(0);
					cdtype.setSelectedIndex(0);
				}
			}
			catch(Exception ee)
			{
				System.out.print(ee);
			}
		}	
		if(e.getSource()==tnew)
		{
			tedit.setEnabled(false);
			int ctr=1;
			try
			{
				Connection con=DriverManager.getConnection("jdbc:odbc:SpaSystemdsn");
				Statement st=con.createStatement();
				ResultSet res=st.executeQuery("select * from keytbl");
				while(res.next())
				{
					ctr=Integer.parseInt(res.getString(3));
				}
				if(ctr<10)
					tid.setText("T00"+ctr);
				if(ctr>=10&&ctr<100)
					tid.setText("T0"+ctr);
				if(ctr>=100&&ctr<1000)
					tid.setText("T"+ctr);
				
				ctype.setSelectedIndex(0);
				ttname.setText("");
				tcost.setText("");
				tdur.setText("");
				tdur.setText("");
				talw.setText("");
				tnalw.setText("");
				tlist.setText("");
				cdtype.setSelectedIndex(0);
				tsave.setEnabled(true);
			}
			catch(Exception ee)
			{
				System.out.println(ee);
			}
		}
		if(e.getSource()==tsearch)
		{
			int flg=0;
			sflg=1;
			tsave.setEnabled(false);
			try
			{
				String dtyp="";
				Connection con=DriverManager.getConnection("jdbc:odbc:SpaSystemdsn");
				ResultSet res;
				Statement st=con.createStatement();
				String t=JOptionPane.showInputDialog("Enter Tid to search");
				res=st.executeQuery("select * from treatmenttbl where treat_id='"+t+"'");
				while(res.next())
				{
					tedit.setEnabled(true);
					flg=1;
					ctype.setSelectedItem(res.getString(2));
					ttname.setText(res.getString(3));
					tcost.setText(res.getString(4));
					tid.setText(res.getString(1));
					tdur.setText(res.getString(5));
					dtyp=res.getString(6);
				}
				ResultSet res2=st.executeQuery("select * from diettbl where dietid='"+dtyp+"'");
				while(res2.next())
				{
					cdtype.setSelectedItem(res2.getString(2));
					display();
					talw.setText(res2.getString(3));
					tnalw.setText(res2.getString(4));
					tlist.setText(res2.getString(5));
				}
				if(flg==0&&t.length()!=0)
				{
					JOptionPane.showMessageDialog(null,"No Record Found!!");
					tid.setText("");
					ttname.setText("");
					tcost.setText("");
					tdur.setText("");
					talw.setText("");
					tnalw.setText("");
					tlist.setText("");
					ctype.setSelectedIndex(0);
					cdtype.setSelectedIndex(0);
				}
			}
			catch(Exception ee)
			{
				System.out.print(ee);
			}			
		}
		if(e.getSource()==tedit)
		{
			String tmp="";
			int flg=0,tflg=0;
			tsave.setEnabled(false);
			tedit.setEnabled(false);
			try
			{
				
				if(tid.getText().length()!=0&&sflg==1)
				{
					Connection con=DriverManager.getConnection("jdbc:odbc:SpaSystemdsn");
					Statement st=con.createStatement();
					if(ctype.getSelectedIndex()==0||ttname.getText().length()==0||tcost.getText().length()==0||tdur.getText().length()==0||cdtype.getSelectedIndex()==0||talw.getText().length()==0||tnalw.getText().length()==0||tlist.getText().length()==0)
					{
						
						JOptionPane.showMessageDialog(null,"Empty Fields!!!");
						flg=1;
						tflg=1;
					}	
					if(flg==0)
					{
						if(cdtype.getSelectedItem().equals("Weight Loss"))
						{
							ResultSet res=st.executeQuery("select * from diettbl where diettype='"+cdtype.getSelectedItem().toString()+"'");
							while(res.next())
							{
								tmp=res.getString(1);
							}
						}
						else
						{
							tmp="N/A";
						}
						String str="update treatmenttbl set treat_type='"+ctype.getSelectedItem()+"',treat_name='"+ttname.getText()+"',t_cost='"+tcost.getText()+"',t_duration='"+tdur.getText()+"',dietid='"+tmp+"' where treat_id='"+tid.getText()+"'";
						st.executeUpdate(str);
						JOptionPane.showMessageDialog(null,"Edit Successfully");
						ctype.setSelectedIndex(0);
						tid.setText("");
						ttname.setText("");
						tcost.setText("");
						tdur.setText("");
						tdur.setText("");
						talw.setText("");
						tnalw.setText("");
						tlist.setText("");
						cdtype.setSelectedIndex(0);
				
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Search Record for Update");
				}
			}
			catch(Exception ee)
			{
				if(tflg==0)
				JOptionPane.showMessageDialog(null,""+ee);
			}
		}
		if(e.getSource()==cdtype)
		{
			String t1="";
			String t2="";
			String t3="";
			
			int i;
			try
			{
				Connection con=DriverManager.getConnection("jdbc:odbc:SpaSystemdsn");
				Statement st=con.createStatement();
				ResultSet res=st.executeQuery("select * from diettbl where diettype='"+cdtype.getSelectedItem()+"'");
				while(res.next())
				{
					t1=res.getString(3);
					t2=res.getString(4);
					t3=res.getString(5);
				}
				
				for(i=0;i<t1.length();i++)
				{
					if(t1.charAt(i)==',')
					{
						talw.setText(talw.getText()+"\n");
					}
					else
					{
						talw.setText(""+talw.getText()+t1.charAt(i));
					}
				}
				for(i=0;i<t2.length();i++)
				{
					if(t2.charAt(i)==',')
					{
						tnalw.setText(tnalw.getText()+"\n");
					}
					else
					{
						tnalw.setText(""+tnalw.getText()+t2.charAt(i));
					}
				}
				for(i=0;i<t3.length();i++)
				{
					if(t3.charAt(i)==',')
					{
						tlist.setText(tlist.getText()+"\n");
					}
					else
					{
						tlist.setText(""+tlist.getText()+t3.charAt(i));
					}
				}
			}
			catch(Exception ee)
			{
				System.out.println(ee);
			}
		}
		
		if(e.getSource()==tadd)
		{
			diet odiet=new diet();
		}
		if(e.getSource()==tcancel)
		{
			this.dispose();
		}
	}
	public static void main(String argv[])
	{
		treatment obj=new treatment();
	}
}
	
	