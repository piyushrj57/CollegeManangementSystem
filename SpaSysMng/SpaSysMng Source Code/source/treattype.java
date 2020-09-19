import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.io.*;
import javax.swing.*;
import java.sql.*;
public class treattype extends JFrame implements ActionListener,FocusListener
{
	JLabel lbl=new JLabel(new ImageIcon("../Images/"));
	
	JLabel ltypeid=new JLabel("Treatment Type ID:");
	JLabel ltname=new JLabel("Treatment Type Name:");
	JTextField ttypeid=new JTextField();
	JTextField ttname=new JTextField();
	
	JButton bnew=new JButton("New");
	JButton bsave=new JButton("Save");
	JButton bsearch=new JButton("Search");
	JButton bmod=new JButton("Modify");
	JButton bcan=new JButton("Cancel");
	int flg=0;
	String strchk="";
	Dimension di=Toolkit.getDefaultToolkit().getScreenSize();

	///Fonts......
	Font btfnt=new Font("Consolas",Font.BOLD,15);
	Font lblfnt=new Font("Bookman Old Style",Font.BOLD,15);
	Font txtfnt=new Font("Bookman Old Style",Font.BOLD,12);

	public treattype()
	{
		int x,y;
		setLayout(null);
		setVisible(true);
		setSize(750,400);
		setResizable(false);
		getContentPane().setBackground(Color.WHITE);
		
		x=((int)di.getWidth()-(int)getWidth())/2;
		y=((int)di.getHeight()-(int)getHeight())/2;
		setLocation(x,y);

		lbl.setBounds(0,0,getWidth(),getHeight());
		
		add(ltypeid);
		add(ltname);
		add(ttypeid);
		add(ttname);
		add(bnew);
		add(bsave);
		add(bmod);
		add(bsearch);
		add(bcan);
		
		ltypeid.setBounds(200,130,200,30);
		ltypeid.setFont(lblfnt);
		ttypeid.setBounds(420,130,120,30);
		ttypeid.setFont(txtfnt);
		
		ltname.setBounds(200,180,200,30);
		ltname.setFont(lblfnt);
		ttname.setBounds(420,180,200,30);
		ttname.setFont(txtfnt);
		
		bnew.setBounds(50,250,120,30);
		bnew.setFont(btfnt);
		bsave.setBounds(180,250,120,30);
		bsave.setFont(btfnt);
		bsearch.setBounds(310,250,120,30);
		bsearch.setFont(btfnt);
		bmod.setBounds(440,250,120,30);
		bmod.setFont(btfnt);
		bcan.setBounds(580,250,120,30);
		bcan.setFont(btfnt);
		
		add(lbl);
		repaint();
		
		ttypeid.setEditable(false);
		bsave.setEnabled(false);
		bmod.setEnabled(false);
		
		bnew.addActionListener(this);
		bsave.addActionListener(this);
		bmod.addActionListener(this);
		bcan.addActionListener(this);
		bsearch.addActionListener(this);
		ttname.addFocusListener(this);
	}
	public void focusGained(FocusEvent fe)
	{
	}
	public void focusLost(FocusEvent fe)
	{
		int i,tflg=0;
		if(fe.getComponent()==ttname)
		{
			strchk=ttname.getText();
			if(ttname.getText().length()==0)
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
						ttname.setText("");
						break;
					}
				}
			}
		}
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==bnew)
		{
			int ctr=0;
			try
			{
				Connection con=DriverManager.getConnection("jdbc:odbc:SpaSystemdsn");
				Statement st=con.createStatement();
				ResultSet res=st.executeQuery("select * from keytbl");	
				while(res.next())
				{
					ctr=Integer.parseInt(res.getString(9));
				}
				if(ctr<10)
					ttypeid.setText("TY00"+ctr);
				if(ctr>9 && ctr<100)
					ttypeid.setText("TY0"+ctr);
				    ttname.setText("");
					
				bsave.setEnabled(true);
				bmod.setEnabled(false);
			}
			catch(Exception ee)
			{
				System.out.println(ee);
			}
		}
		if(e.getSource()==bsearch)
		{				
			try
			{
				int flg=0;
				Connection con=DriverManager.getConnection("jdbc:odbc:SpaSystemdsn");
				Statement st=con.createStatement();
				
				String t=JOptionPane.showInputDialog("Enter treatment id to be modify:");					
					ResultSet res=st.executeQuery("select * from typetbl where typeid='"+t+"'");
					while(res.next())
					{
						bmod.setEnabled(false);
						flg=1;
						ttypeid.setText(res.getString(1));
						ttname.setText(res.getString(2));
					}
					if(flg==0&&t.length()!=0)
					{
						JOptionPane.showMessageDialog(null,"No Record Found!!");
						ttypeid.setText("");
						ttname.setText("");
					}
			}
			catch(Exception ee)
			{
				System.out.println(ee);
			}
		}
		if(e.getSource()==bmod)
		{	
			try
			{
				Connection con=DriverManager.getConnection("jdbc:odbc:SpaSystemdsn");
				Statement st=con.createStatement();				
					String str="update typetbl set typename='"+ttname.getText()+"' where typeid='"+ttypeid.getText()+"'";
					st.executeUpdate(str);
				JOptionPane.showMessageDialog(null,"Data Updated!!");	
				bmod.setEnabled(false);
			}
			catch(Exception ee)
			{
				System.out.println(ee);
			}
			
		}
		if(e.getSource()==bcan)
		{
			this.dispose();
		}
		if(e.getSource()==bsave)
		{
			try
			{
				Connection con=DriverManager.getConnection("jdbc:odbc:SpaSystemdsn");
				if(ttname.getText().length()!=0)
				{
					String str="insert into typetbl(typeid,typename)values(?,?)";
					PreparedStatement ps=con.prepareStatement(str);
					ps.setString(1,ttypeid.getText());
					ps.setString(2,ttname.getText());
					ps.executeUpdate();
					Statement st=con.createStatement();
					String str1="update keytbl set typeid=typeid+1";
					st.executeUpdate(str1);
					JOptionPane.showMessageDialog(null,"Saved..");
					ttypeid.setText("");
					ttname.setText("");
					bsave.setEnabled(false);
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Empty Fields!!!");
				}
			}
			catch(Exception ee)
			{
				System.out.println(ee);	
			}
		}
	}
	public static void main(String argv[])
	{
		treattype obj=new treattype();
	}
}
	
	