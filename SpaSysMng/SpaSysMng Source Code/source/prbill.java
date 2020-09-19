import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;
public class prbill
{
	Calendar cal=Calendar.getInstance();
	public prbill(String t)
	{
		prt(t);
	}
	public void prt(String t)
	{
		try
		{
		
			
			Connection con=DriverManager.getConnection("jdbc:odbc:SpaSystemdsn");
			PrintWriter pw=new PrintWriter("reciept.txt");

			String tmp="",tmp1="",tname="",tphone="",tmpc="";
			String ch="";
			int i;
			String tm=(""+cal.get(Calendar.DATE)+"/"+(cal.get(Calendar.MONTH)+1)+"/"+cal.get(Calendar.YEAR));
			Statement st=con.createStatement();

			ResultSet res=st.executeQuery("select * from bookingtbl where bookid='"+t+"'");
			while(res.next())
			{
				tmp1=res.getString(4);			//cust_member_id
				tmp=res.getString(7);			//package_id
				tmpc=res.getString(10);			//total cost
			}
			res.close();
			ch=tmp1.substring(0,1);
			if(ch.equals("m")||ch.equals("M"))
			{
				res=st.executeQuery("select * from membertbl where mem_id='"+tmp1+"'");
				while(res.next())
				{
					tname=res.getString(3);
					tphone=res.getString(8);
				}
			}
			if(ch.equals("c")||ch.equals("C"))
			{
				res=st.executeQuery("select * from customertbl where custid='"+tmp1+"'");
				while(res.next())
				{
					tname=res.getString(3);
					tphone=res.getString(5);
				}
			}

			int ctr=0;
			String tmp5="";				//package_name
			res=st.executeQuery("select pack_name from packagetbl where pack_id='"+tmp+"'");
			while(res.next())
				tmp5=res.getString(1);

			pw.println("\t\t\t Aamya Beauty Care Center  ");
			pw.println("\t\t\t   Kalimati Road-8331001");
			pw.println("\t\t\t     Ph.No.:-8603100915");
			pw.println("\t\t\t\t\t\t Date:"+tm);

			res=st.executeQuery("select recno from keytbl");
			while(res.next())
			{
				ctr=Integer.parseInt(res.getString(1));
			}
			if(ctr<10)
				pw.println("\t\t\t\t\t\t Reciept: RPT00"+ctr);
			if(ctr>=10&&ctr<100)
				pw.println("\t\t\t\t\t\t Reciept: RPT0"+ctr);
			if(ctr>=100&&ctr<1000)
				pw.println("\t\t\t\t\t\t Reciept: RPT"+ctr);

			pw.println("\t____________________________________________________________________");
			pw.println("\t\t\t\t User Details");
			pw.println("\t\t\t\t-----------------");
			pw.println("\tCustomer/Member Name:-"+tname+"\t\t\t Phone No.:-"+tphone);
			pw.println("\t____________________________________________________________________");
			pw.println("\tPackage:- "+tmp5);
			pw.println();
			pw.println("\tTreatment Name \t\t\t\t\t\t Price\t");
			pw.println("\t____________________________________________________________________");


			String tmp3="";				//treatment_name
			String tmp4="";				//treatment_cost

			String tmp2="";				//treatment id

			ResultSet res2;

			Statement st1=con.createStatement();
			if(tmp.length()==0)
			{
				res=st.executeQuery("select * from booktbl where bookid='"+t+"'");
				while(res.next())
				{
					tmp2=res.getString(2);
					res2=st1.executeQuery("select treat_name,t_cost from treatmenttbl where treat_id='"+tmp2+"'");
					while(res2.next())
					{
						tmp3=res2.getString(1);
						tmp4=res2.getString(2);
					}
					pw.println("\t"+tmp3+"\t\t\t\t\t\t"+tmp4+" Rs.");
				}
			}

			if(tmp.length()>0)
			{
				res=st.executeQuery("select * from packagetbl where pack_id='"+tmp+"'");

					while(res.next())
					{
						tmp5=res.getString(2);
						for(i=3;i<=7;i++)
						{
							tmp2=res.getString(i);
							if(tmp2.length()>0)
							{
						res2=st1.executeQuery("select treat_name,t_cost from treatmenttbl where treat_id='"+tmp2+"'");
						while(res2.next())
						{
							tmp3=res2.getString(1);
							tmp4=res2.getString(2);
						}
						pw.println("\t"+tmp3+"\t\t\t\t\t\t"+tmp4+" Rs.");
							}

						}
					}
			}

			pw.println("");
			pw.println("");
			pw.println("");

			pw.println("\t____________________________________________________________________");
			pw.println("\tTotal \t\t\t\t\t\t "+tmpc+" Rs.");
			pw.close();

			st.executeUpdate("update keytbl set recno=recno+1");

			Runtime rt=Runtime.getRuntime();
			Process pr=rt.exec("notepad reciept.txt");
		}
		catch(Exception ee)
		{
			System.out.println(ee);
		}
	}
	public static void main(String argv[])
	throws IOException
	{
		prbill obj=new prbill("");
	}
}
