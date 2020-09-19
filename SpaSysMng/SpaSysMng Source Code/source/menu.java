import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.io.*;
import javax.swing.*;

public class menu extends JFrame implements ActionListener
{
	JLabel lbl=new JLabel(new ImageIcon("../Images/mnnp.jpg"));
	JMenuBar mb=new JMenuBar();
	JMenu mnumaster=new JMenu("Master");
	JMenu mnutransaction=new JMenu("Transaction");
	JMenu mnupayment=new JMenu("Payment");
	JMenu mnureport=new JMenu("Report");
	JMenu mnuexit=new JMenu("Exit");
	
JMenuItem micust=new JMenuItem("Customer",new ImageIcon("../Images/cust.png"));
	JMenuItem mimem=new JMenuItem("Member",new ImageIcon("../Images/mem1.png"));
	JMenuItem mistaff=new JMenuItem("Staff",new ImageIcon("../Images/staff.png"));
	JMenuItem mitreat=new JMenuItem("Treatment",new ImageIcon("../Images/treatments.png"));
	JMenuItem midiet=new JMenuItem("Diet",new ImageIcon("../Images/deit.png"));
	JMenuItem mipack=new JMenuItem("Package",new ImageIcon("../Images/menupack.png"));
	
	JMenuItem mienquiry=new JMenuItem("Enquiry",new ImageIcon("../Images/menuenq.png"));
	JMenuItem mifollow=new JMenuItem("Follow Up",new ImageIcon("../Images/followup.png"));
	JMenuItem mibook=new JMenuItem("Booking",new ImageIcon("../Images/booking.png"));
	JMenuItem misdiet=new JMenuItem("Diet Transaction",new ImageIcon("../Images/menudiett.png"));
	JMenuItem mican=new JMenuItem("Cancel Booking",new ImageIcon("../Images/menubcan.png"));

	JMenuItem mipay=new JMenuItem("Payment",new ImageIcon("../Images/payment.jpg"));
	JMenuItem mireciept=new JMenuItem("Print Reciept",new ImageIcon("../Images/menupr.png"));
	
	JMenuItem mireport=new JMenuItem("Report...",new ImageIcon("../Images/menupr.png"));
		
	//JMenuItem miex=new JMenuItem("Exiting",new ImageIcon("../Images/menuexit.png"));

	//JMenuItem mireport=new JMenuItem("Report...",new ImageIcon("../Images/menupr.png"));
	
	JMenuItem miex=new JMenuItem("Exiting",new ImageIcon("../Images/ex.jpg"));
	JMenuItem milg=new JMenuItem("Logout",new ImageIcon("../Images/log.jpg"));

	
	
	Dimension di=Toolkit.getDefaultToolkit().getScreenSize();
	public menu()
	{
		setLayout(null);
		setVisible(true);
		setSize((int)di.getWidth(),(int)di.getHeight());
		setResizable(false);
		getContentPane().setBackground(Color.WHITE);
		
		lbl.setBounds(0,0,1500,1000);
		add(lbl);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		mnumaster.add(micust);
		mnumaster.addSeparator();
		mnumaster.add(mimem);
		mnumaster.addSeparator();
		mnumaster.add(mistaff);
		mnumaster.addSeparator();
		mnumaster.add(mitreat);
		mnumaster.addSeparator();
		mnumaster.add(midiet);
		mnumaster.addSeparator();
		mnumaster.add(mipack);
		
		mnutransaction.add(mienquiry);
		mnutransaction.addSeparator();
		mnutransaction.add(mifollow);
		mnutransaction.addSeparator();
		mnutransaction.add(mibook);
		mnutransaction.addSeparator();
		mnutransaction.add(misdiet);
		mnutransaction.addSeparator();
		mnutransaction.add(mican);
		
		mnupayment.add(mipay);
		mnupayment.addSeparator();
		mnupayment.add(mireciept);
		
		mnureport.add(mireport);
		
		mnuexit.add(miex);
		mnuexit.add(milg);

		mb.add(mnumaster);
		mb.add(mnutransaction);
		mb.add(mnupayment);
		mb.add(mnureport);
		mb.add(mnuexit);

		this.setJMenuBar(mb);
		micust.addActionListener(this);
		mimem.addActionListener(this);
		mistaff.addActionListener(this);
		mitreat.addActionListener(this);
		mipack.addActionListener(this);
		midiet.addActionListener(this);

		mienquiry.addActionListener(this);
		mifollow.addActionListener(this);
		mibook.addActionListener(this);
		misdiet.addActionListener(this);
		mican.addActionListener(this);
		
		mipay.addActionListener(this);
		
		mireciept.addActionListener(this);
		mireport.addActionListener(this);
		
		milg.addActionListener(this);
		miex.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==micust)
		{
			customer cus=new customer();
		}
		if(e.getSource()==mimem)
		{
			member mem=new member();
		}
		if(e.getSource()==mistaff)
		{
			staff ostaff=new staff();
		}

		if(e.getSource()==mitreat)
		{
			treatment treat=new treatment();
		}
		if(e.getSource()==mipack)
		{
			packagef pack=new packagef();
		}
		if(e.getSource()==midiet)
		{
			diet odiet=new diet();
		}
		if(e.getSource()==mienquiry)
		{
			enquiry enq=new enquiry();
		}
		if(e.getSource()==mifollow)
		{
			followup fol=new followup();
		}
		if(e.getSource()==mibook)
		{
			booking bobj=new booking();
		}
		if(e.getSource()==misdiet)
		{
			diett odiett=new diett();
		}
		if(e.getSource()==mican)
		{
			cancellation cobj=new cancellation();
		}
		
		if(e.getSource()==mipay)
		{
			payment pobj=new payment();
		}
		if(e.getSource()==mireciept)
		{
			prreciept probj=new prreciept();
		}
		if(e.getSource()==mireport)
		{
			report robj=new report();
		}
		if(e.getSource()==miex)
		{
			System.exit(0);
		}
		if(e.getSource()==milg)
		{
			login lg=new login();
		}
	}
	public static void main(String argv[])
	throws IOException
	{
		menu obj=new menu();
	}
}
