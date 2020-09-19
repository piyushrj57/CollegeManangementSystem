import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.*;
import java.io.*;
import java.sql.*;
import java.util.*;
import java.util.Date;
import java.text.SimpleDateFormat;
public class member extends JFrame implements ActionListener,FocusListener
{
	JLabel lbl=new JLabel(new ImageIcon("../Images/mas.jpg"));
		
	int sflg=0;
	JLabel lhead=new JLabel("Member");
	JLabel lmember_id=new JLabel("Id");
	JLabel ldate=new JLabel("Date");
	JLabel lmember_name=new JLabel("Name");
	JLabel lmember_catagory=new JLabel("Category");
	JLabel lmember_add=new JLabel("Address");
	JLabel lmember_gender=new JLabel("Gender");
	JLabel lmember_contact=new JLabel("Contact");
	JLabel lmember_mob=new JLabel("Mobile");
	JLabel lmember_email=new JLabel("E-Mail");
	JLabel lmember_val=new JLabel("Validity of Membership");
	JLabel lmember_join=new JLabel("Date of Join");
	JLabel lmember_end=new JLabel("Date of End");
	JLabel lmember_adhar=new JLabel("Adhar Card");
	
	JLabel lmember_weight=new JLabel("Weight");
	JLabel lmember_sugar=new JLabel("Sugar");
	JLabel lmember_allergy=new JLabel("Allergy");

	JButton member_new=new JButton("NEW",new ImageIcon("../Images/mnbt.jpg"));
	JButton member_save=new JButton("SAVE",new ImageIcon("../Images/msbt.jpg"));
	JButton member_search=new JButton("SEARCH",new ImageIcon("../Images/mssbt.jpg"));
	JButton member_cancel=new JButton("CANCEL",new ImageIcon("../Images/mcbt.jpg"));
	JButton member_edit=new JButton("EDIT",new ImageIcon("../Images/mebt.jpg"));

	JComboBox cate=new JComboBox();

	JTextField txmember_id=new JTextField();
	JTextField txdate=new JTextField();
	JTextField txmember_name=new JTextField();
	JTextArea txmember_add=new JTextArea();
	JTextField txmember_mob=new JTextField();
	JTextField txmember_email=new JTextField();
	JTextField txmember_join=new JTextField();
	JTextField txmember_end=new JTextField();
	JTextField txmember_adhar=new JTextField();

	JTextField txmember_weight=new JTextField();
	JTextField txmember_sugar=new JTextField();
	JTextField txmember_allergy=new JTextField();

	JRadioButton rmale =new JRadioButton("Male");
	JRadioButton rfemale=new JRadioButton("Female");
	ButtonGroup bg=new ButtonGroup();
	String strgen="";

	Calendar cal=Calendar.getInstance();

	String strchk="";

	Dimension di=Toolkit.getDefaultToolkit().getScreenSize();	

	JTextField txline=new JTextField();

	///Fonts.....
	Font btfnt=new Font("Consolas",Font.BOLD,15);
	Font lblfnt=new Font("Bookman Old Style",Font.BOLD,15);
	Font txtfnt=new Font("Bookman Old Style",Font.BOLD,12);

	JScrollPane sradd=new JScrollPane(txmember_add,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

	public member()
	{
		setLayout(null);
		setVisible(true);
		this.getContentPane().setBackground(Color.WHITE);
		setSize((int)di.getWidth(),(int)di.getHeight());
		setResizable(false);

		lbl.setBounds(0,0,getWidth(),getHeight());

		
		
		
        add(lhead);
		add(lmember_id);
		add(ldate);
		add(lmember_name);
		add(lmember_catagory);
		add(lmember_gender);
		add(lmember_add);
		add(lmember_contact);
		add(lmember_mob);
		add(lmember_email);
		add(lmember_val);
		add(lmember_join);
		add(lmember_end);
		add(lmember_adhar);
		add(lmember_weight);
		add(lmember_sugar);
		add(lmember_allergy);

		add(member_new);
		add(member_save);
		add(member_search);
		add(member_edit);
		add(member_cancel);

		add(cate);

		bg.add(rmale);
		bg.add(rfemale);
		add(rmale);
		add(rfemale);

		add(txmember_id);
		add(txdate);
		add(txmember_name);
		add(sradd);
		add(txmember_mob);
		add(txmember_email);
		add(txmember_join);
		add(txmember_end);
		add(txmember_adhar);
		add(txmember_weight);
		add(txmember_sugar);
		add(txmember_allergy);
        
		lhead.setFont(new Font("castellar",1,25));
		lhead.setForeground(new Color(163,73,164));
		lhead.setBounds(500,30,200,30);
		
		lmember_id.setFont(lblfnt);
		lmember_id.setBounds(130,130,100,30);
		txmember_id.setBounds(250,130,80,30);
		txmember_id.setFont(txtfnt);

		lmember_name.setFont(lblfnt);
		lmember_name.setBounds(130,180,100,30);
		txmember_name.setBounds(250,180,180,30);
		txmember_name.setFont(txtfnt);

		lmember_catagory.setFont(lblfnt);
		lmember_catagory.setBounds(130,230,100,30);
		cate.setFont(txtfnt);
		cate.setBounds(250,230,80,30);	
		cate.addItem("Silver");
		cate.addItem("Gold");
		cate.addItem("Platinum");

		lmember_gender.setFont(lblfnt);
		lmember_gender.setBounds(130,280,100,30);
		
		rmale.setFont(lblfnt);
		rmale.setBackground(Color.WHITE);
		rmale.setBounds(250,280,100,30);

		rfemale.setFont(lblfnt);
		rfemale.setBackground(Color.WHITE);
		rfemale.setBounds(370,280,100,30);

		lmember_add.setFont(lblfnt);
		lmember_add.setBounds(130,330,100,30);
		sradd.setBounds(250,330,200,70);
		txmember_add.setFont(txtfnt);

		lmember_adhar.setFont(lblfnt);
		lmember_adhar.setBounds(130,420,100,30);
		txmember_adhar.setBounds(250,420,200,30);
		txmember_adhar.setFont(txtfnt);

		lmember_contact.setFont(lblfnt);
		lmember_contact.setBounds(130,470,100,30);

		lmember_mob.setFont(lblfnt);
		lmember_mob.setBounds(180,510,100,30);
		txmember_mob.setBounds(300,510,120,30);
		txmember_mob.setFont(txtfnt);

		lmember_email.setFont(lblfnt);
		lmember_email.setBounds(180,550,100,30);
		txmember_email.setBounds(300,550,180,30);
		txmember_email.setFont(txtfnt);
				
		lmember_weight.setFont(lblfnt);
		lmember_weight.setBounds(600,300,100,30);
		txmember_weight.setBounds(700,300,100,30);
		txmember_weight.setFont(txtfnt);
		txmember_weight.setOpaque(false);

		lmember_sugar.setFont(lblfnt);
		lmember_sugar.setBounds(600,340,100,30);
		txmember_sugar.setBounds(700,340,100,30);
		txmember_sugar.setFont(txtfnt);
		txmember_sugar.setOpaque(false);

		lmember_allergy.setFont(lblfnt);
		lmember_allergy.setBounds(600,380,100,30);
		txmember_allergy.setBounds(700,380,100,30);
		txmember_allergy.setFont(txtfnt);
		txmember_allergy.setOpaque(false);

		lmember_val.setFont(lblfnt);
		lmember_val.setBounds(560,440,200,30);

		lmember_join.setFont(lblfnt);
		lmember_join.setBounds(600,480,100,30);
		txmember_join.setBounds(700,480,80,30);
		txmember_join.setFont(txtfnt);
		txmember_join.setOpaque(false);

		lmember_end.setFont(lblfnt);
		lmember_end.setBounds(600,520,100,30);
		txmember_end.setBounds(700,520,80,30);
		txmember_end.setFont(txtfnt);
		txmember_end.setOpaque(false);

		ldate.setFont(lblfnt);
		ldate.setBounds(700,80,80,30);
		txdate.setBounds(800,80,80,30);
		txdate.setFont(txtfnt);

		member_new.setFont(btfnt);
		member_new.setBounds(120,650,120,30);
		
		member_save.setFont(btfnt);
		member_save.setBounds(250,650,120,30);
		
		member_search.setFont(btfnt);
		member_search.setBounds(380,650,120,30);
		
		member_edit.setFont(btfnt);
		member_edit.setBounds(510,650,120,30);
		
		member_cancel.setFont(btfnt);
		member_cancel.setBounds(640,650,120,30);

		txdate.setText(""+cal.get(Calendar.DATE)+"/"+(cal.get(Calendar.MONTH)+1)+"/"+cal.get(Calendar.YEAR));

		add(lbl);		
		repaint();
		
		member_new.addActionListener(this);
		member_save.addActionListener(this);
		member_search.addActionListener(this);
		member_edit.addActionListener(this);
		member_cancel.addActionListener(this);

		rmale.addActionListener(this);
		rfemale.addActionListener(this);
		
		////Validation
		txmember_id.setEditable(false);
		txdate.setEditable(false);
		member_save.setEnabled(false);
		member_edit.setEnabled(false);
		
		txmember_name.addFocusListener(this);
		txmember_mob.addFocusListener(this);
		txmember_email.addFocusListener(this);
		txmember_adhar.addFocusListener(this);
		txmember_join.addFocusListener(this);
		txmember_end.addFocusListener(this);
	}
	public void focusLost(FocusEvent fe)
	{
		int i,tflg=0;
		if(fe.getComponent()==txmember_name)
		{
			strchk=txmember_name.getText();
			if(txmember_name.getText().length()==0)
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
						txmember_name.setText("");
						break;
					}
				}
			}
		}	

		if(fe.getComponent()==txmember_mob)
		{
			int tmflg=0;
			strchk=txmember_mob.getText();
			if(txmember_mob.getText().length()==0)
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
						txmember_mob.setText("");
						break a;				
					}
					if(strchk.length()!=10)
					{
						JOptionPane.showMessageDialog(null,"Enter 10-digits Mobile Number!!");
						txmember_mob.setText("");
						break a;				
					}}
				}
			}
		}
		
		if(fe.getComponent()==txmember_adhar)
		{
			int tmflg=0;
			strchk=txmember_adhar.getText();
			if(txmember_adhar.getText().length()==0)
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
					if(Character.getNumericValue(strchk.charAt(i))>=0&&Character.getNumericValue(strchk.charAt(i))<=9)
					{
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Enter Only Digits!!");
						txmember_adhar.setText("");
						break p;				
					}
					if(strchk.length()!=12)
					{
						JOptionPane.showMessageDialog(null,"Enter 12-digits Aadhar Number!!");
						txmember_adhar.setText("");
						break p;				
					}}
				}
			}
		}
		
		if(fe.getComponent()==txmember_email)
		{
			int canchor=0,cdot=0,flg=0,teflg=0;
			strchk=txmember_email.getText();
			if(txmember_email.getText().length()==0)
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
					txmember_email.setText("");
				}
			}
		}
		
		if(fe.getComponent()==txmember_join)
		{
			strchk=txmember_join.getText();
			
			if(txmember_join.getText().length()!=0)
			{ 	
				try
				{
					SimpleDateFormat cdf = new SimpleDateFormat("dd/MM/yyyy");
					Date dat = cdf.parse(strchk);
					if (!strchk.equals(cdf.format(dat)))
					{
						JOptionPane.showMessageDialog(null,"Invalid Date Format!!");
						txmember_join.setText("");
					}
					else
					{
						Calendar c=Calendar.getInstance();
						c.setTime(cdf.parse(txmember_join.getText()));
						c.add(Calendar.YEAR,1);
						txmember_end.setText(""+cdf.format(c.getTime()));
					}
				}
				catch(Exception ee)
				{
					JOptionPane.showMessageDialog(null,"Invalid Date Format!!");
					txmember_join.setText("");
				}
					
			}
		}
		
		
		if(fe.getComponent()==txmember_end)
		{
			strchk=txmember_end.getText();
			
			if(txmember_end.getText().length()!=0)
			{ 	
				try
				{
					SimpleDateFormat cdf = new SimpleDateFormat("dd/MM/yyyy");
					Date dat = cdf.parse(strchk);
					if (!strchk.equals(cdf.format(dat)))
					{
						JOptionPane.showMessageDialog(null,"Invalid Date Format!!");
						txmember_end.setText("");
					}
				}
				catch(Exception ee)
				{
					JOptionPane.showMessageDialog(null,"Invalid Date Format!!");
					txmember_end.setText("");
				}		
			}
		}
		
	}
	public void focusGained(FocusEvent fe)
	{
		
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==member_new)
		{
			try
			{
				int ctr=1;
				Connection con=DriverManager.getConnection("jdbc:odbc:SpaSystemdsn");
				Statement st=con.createStatement();
				ResultSet res=st.executeQuery("select * from keytbl");
				while(res.next())
				{
					ctr=Integer.parseInt(res.getString(2));
				}
				if(ctr<10)
					txmember_id.setText("M00"+ctr);
				if(ctr>=10&&ctr<100)
					txmember_id.setText("M0"+ctr);
				if(ctr>=100&&ctr<1000)
					txmember_id.setText("M"+ctr);
					
					txmember_name.setText("");
					bg.clearSelection();
					cate.setSelectedIndex(0);
					txmember_add.setText("");
					txmember_mob.setText("");
					txmember_email.setText("");
					txmember_adhar.setText("");
					txmember_weight.setText("");
					txmember_sugar.setText("");
					txmember_allergy.setText("");
					txmember_join.setText(""+txdate.getText());
					SimpleDateFormat formatter=new SimpleDateFormat("dd/MM/yyyy");
					Calendar c=Calendar.getInstance();

					c.setTime(formatter.parse(txmember_join.getText()));
					c.add(Calendar.YEAR,1);
					txmember_end.setText(""+formatter.format(c.getTime()));
					member_save.setEnabled(true);
					member_edit.setEnabled(false);
			}
			catch(Exception ee)
			{
				System.out.println(ee);
			}
		}
		if(e.getSource()==member_save)
		{ 
			int flg=0;
			String tdis="";
			member_edit.setEnabled(false);
			try
			{
				Connection con=DriverManager.getConnection("jdbc:odbc:SpaSystemdsn");

				String str="insert into membertbl(mem_date,mem_id,mem_name,mem_category,mem_gender,mem_address,mem_adhar,mem_mob,mem_email,mem_joindate,mem_enddate,mem_weight,mem_sugar,mem_allergy,mem_dis) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
				PreparedStatement ps=con.prepareStatement(str);
				
					if(txmember_name.getText().length()==0||bg.getSelection()==null||txmember_add.getText().length()==0||txmember_adhar.getText().length()==0||txmember_mob.getText().length()==0||txmember_email.getText().length()==0||txmember_join.getText().length()==0||txmember_end.getText().length()==0||txmember_weight.getText().length()==0||txmember_sugar.getText().length()==0)
					{
						JOptionPane.showMessageDialog(null,"Empty Fields!!!");
						flg=1;
					}
					if(flg==0)
					{
						ps.setString(1,txdate.getText());
						ps.setString(2,txmember_id.getText());
						ps.setString(3,txmember_name.getText());
						
						ps.setString(4,cate.getSelectedItem().toString());
						if(rmale.isSelected())
						{
							strgen="Male";
						}
						if(rfemale.isSelected())
						{
							strgen="Female";
						}
						ps.setString(5,strgen);
						ps.setString(6,txmember_add.getText());
						ps.setString(7,txmember_adhar.getText());
						ps.setString(8,txmember_mob.getText());
						ps.setString(9,txmember_email.getText());
						ps.setString(10,txmember_join.getText());
						ps.setString(11,txmember_end.getText());
						
						ps.setString(12,txmember_weight.getText());
						ps.setString(13,txmember_sugar.getText());
						if(txmember_allergy.getText().length()==0)
							ps.setString(14,"No");
						else
							ps.setString(14,txmember_allergy.getText());
						if(cate.getSelectedItem().equals("Silver"))
						{
							tdis=""+5;
						}							
						if(cate.getSelectedItem().equals("Gold"))
						{
							tdis=""+10;
						}							
						if(cate.getSelectedItem().equals("Platinum"))
						{
							tdis=""+15;
						}			
						ps.setString(15,tdis);
						ps.executeUpdate();
				
						Statement st=con.createStatement();
						st.executeUpdate("update keytbl set mem_id=mem_id+1");
						JOptionPane.showMessageDialog(null,"Record Saved!!");
				
						txmember_id.setText("");
					txmember_name.setText("");
					bg.clearSelection();
					cate.setSelectedIndex(0);
					txmember_adhar.setText("");
					txmember_weight.setText("");
					txmember_sugar.setText("");
					txmember_allergy.setText("");
					txmember_add.setText("");
					txmember_mob.setText("");
					txmember_email.setText("");
					txmember_join.setText("");
					txmember_end.setText("");
					member_save.setEnabled(false);				
				}
			}
			catch(Exception ee)
			{
				System.out.print(ee);
			}
		}
		if(e.getSource()==member_search)
		{
			sflg=1;
			int flg=0;
			String t=JOptionPane.showInputDialog("Enter Member id to search");
			try
			{
			Connection con=DriverManager.getConnection("jdbc:odbc:SpaSystemdsn");
			ResultSet res;
			Statement st=con.createStatement();
			res=st.executeQuery("select * from membertbl where mem_id='"+t+"'");
			while(res.next())
			{
				member_edit.setEnabled(true);
				flg=1;
				txmember_id.setText(res.getString(2));
				txmember_name.setText(res.getString(3));
				txdate.setText(res.getString(1));
				txmember_add.setText(res.getString(6));
				txmember_adhar.setText(res.getString(7));
				txmember_mob.setText(res.getString(8));
				txmember_email.setText(res.getString(9));
				txmember_join.setText(res.getString(10));
				txmember_end.setText(res.getString(11));
				txmember_weight.setText(res.getString(12));
				txmember_sugar.setText(res.getString(13));
				txmember_allergy.setText(res.getString(14));
				cate.setSelectedItem(res.getString(4));
				if(res.getString(5).equals("Male"))
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
			member_save.setEnabled(false);
			if(flg==0&&t.length()!=0)
			{
				JOptionPane.showMessageDialog(null,"No Record Found!!!");
				txmember_id.setText("");
				txmember_name.setText("");
				cate.setSelectedIndex(0);
				bg.clearSelection();
				txmember_add.setText("");
				txmember_mob.setText("");
				txmember_email.setText("");
				txmember_join.setText("");
				txmember_end.setText("");
				txmember_adhar.setText("");
				txmember_weight.setText("");
				txmember_sugar.setText("");
				txmember_allergy.setText("");
			}
			}
			catch(Exception ee)
			{
				System.out.print(ee);
			}
		}
		if(e.getSource()==member_edit)
		{
			member_edit.setEnabled(false);
			String tdis="";
			String tmp=txmember_allergy.getText();
					member_save.setEnabled(false);
					int flg=0,tflg=0;
			try
			{
				if(txmember_id.getText().length()!=0&&sflg==1)
				{
					Connection con=DriverManager.getConnection("jdbc:odbc:SpaSystemdsn");
					if(rmale.isSelected())
					{
						strgen="Male";
					}
					if(rfemale.isSelected())
					{
						strgen="Female";
					}
					if(tmp.length()==0)
						tmp="No";
					if(txmember_name.getText().length()==0||bg.getSelection()==null||txmember_add.getText().length()==0||txmember_adhar.getText().length()==0||txmember_mob.getText().length()==0||txmember_email.getText().length()==0||txmember_join.getText().length()==0||txmember_end.getText().length()==0||txmember_weight.getText().length()==0||txmember_sugar.getText().length()==0)
					{
						JOptionPane.showMessageDialog(null,"Empty Fields!!!");
						flg=1;
					}
					if(flg==0)
					{
						if(cate.getSelectedItem().equals("Silver"))
						{
							tdis=""+5;
						}							
						if(cate.getSelectedItem().equals("Gold"))
						{
							tdis=""+10;
						}							
						if(cate.getSelectedItem().equals("Platinum"))
						{
							tdis=""+15;
						}			
						String str="update membertbl set mem_date='"+txdate.getText()+"',mem_name='"+txmember_name.getText()+"',mem_category='"+cate.getSelectedItem()+"',mem_gender='"+strgen+"',mem_address='"+txmember_add.getText()+"',mem_adhar='"+txmember_adhar.getText()+"',mem_mob='"+txmember_mob.getText()+"',mem_email='"+txmember_email.getText()+"',mem_joindate='"+txmember_join.getText()+"',mem_enddate='"+txmember_end.getText()+"',mem_weight='"+txmember_weight.getText()+"',mem_sugar='"+txmember_sugar.getText()+"',mem_allergy='"+tmp+"',mem_dis='"+tdis+"' where mem_id='"+txmember_id.getText()+"'";
						Statement st=con.createStatement();
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
		if(e.getSource()==member_cancel)
		{
			this.dispose();
		}
	}
	public static void main(String argv[])
	throws IOException
	{
		member obj=new member();
	}
}
