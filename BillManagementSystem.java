import data.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.sql.*;
class BillManagementSystem extends JFrame
{
String use;
String pas;
JFrame frame1;
int cec, cec1;
Calendar calen = new GregorianCalendar();
int day = calen.get(Calendar.DAY_OF_MONTH);
int month = calen.get(Calendar.MONTH);
int month1 = month + 1;
int year = calen.get(Calendar.YEAR);

int sec = calen.get(Calendar.SECOND);
int min = calen.get(Calendar.MINUTE);
int hr = calen.get(Calendar.HOUR);

String time = hr + ":" + min + ":" + sec;
String date = day + "/" + month1 + "/" + year;

BillManagementSystem()
{
setSize(1366,768);
setTitle("Bill Management System");
setLayout(null);
JLabel unm=new JLabel("User Name:");
unm.setForeground(Color.WHITE);
JLabel pass=new JLabel("Password :");
pass.setForeground(Color.WHITE);
JTextField u=new JTextField(200);
JPasswordField p=new JPasswordField(200);
JCheckBox c1=new JCheckBox("Show Password");
JButton ln=new JButton("Login");
JButton forge=new JButton("Forget Password");
JButton signup=new JButton("Sign UP");
JButton close=new JButton("Close");

//add Image icon on page
ImageIcon ic=new ImageIcon("bill.png");
JLabel ico=new JLabel("",ic,JLabel.LEFT);
ico.setBounds(80,150,1000,500);
add(ico);

//add super market label
ImageIcon b=new ImageIcon("b.gif");
JLabel b1=new JLabel("",b,JLabel.CENTER);
b1.setBounds(180,50,1000,100);
add(b1);

//Login Label
ImageIcon img=new ImageIcon("login ani.gif");
JLabel login=new JLabel("",img,JLabel.CENTER);
login.setBounds(780,230,550,100);
add(login);
//Username Label
unm.setFont(new Font("Times New Roman",1,30));
unm.setBounds(850,250,400,200);
add(unm);
//Username TextField
u.setFont(new Font("Times New Roman",1,20));
u.setBounds(1010,340,200,30);
add(u);
//Password TextField
p.setFont(new Font("Times New Roman",1,20));
p.setBounds(1010,380,200,30);
add(p);
//Checkbox Item
c1.setBounds(1010,420,150,20);
add(c1);
c1.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent ec)
{
if(c1.isSelected())
{
p.setEchoChar((char)0);
}
else
{
p.setEchoChar('.');
}
}
});
//Password Label
pass.setFont(new Font("Times New Roman",1,30));
pass.setBounds(850,290,400,200);
add(pass);
//Login button
ImageIcon limg=new ImageIcon("login.png");
ln.setIcon(limg);
ln.setFont(new Font("Times New Roman",1,18));
ln.setBounds(950,465,120,30);
add(ln);

//Forgot Password
ImageIcon lim=new ImageIcon("login.png");
forge.setIcon(lim);
forge.setFont(new Font("Times New Roman",1,18));
forge.setBounds(980,500,200,30);
add(forge);

//sign up
ImageIcon sign=new ImageIcon("login.png");
signup.setIcon(sign);
signup.setFont(new Font("Times New Roman",1,18));
signup.setBounds(1010,540,150,30);
add(signup);

//Developer information
JLabel mam = new JLabel("Guided By: Mrs.S.D.Patil",JLabel.CENTER);
mam.setForeground(Color.WHITE);
mam.setFont(new Font("Times New Roman",3,25));
mam.setBounds(650,640,550,30);
add(mam);
JLabel dev = new JLabel("Developed By:\t\t\t\t\t\t\t\t",JLabel.CENTER);
dev.setForeground(Color.WHITE);
dev.setFont(new Font("Times New Roman",3,25));
dev.setBounds(230,680,250,30);
add(dev);
JLabel std = new JLabel("1. Hemangi Nehete ",JLabel.CENTER);
std.setForeground(Color.WHITE);
std.setFont(new Font("Times New Roman",3,25));
std.setBounds(420,680,250,30);
add(std);
JLabel std1 = new JLabel("2.Jayashri Barhate ",JLabel.CENTER);
std1.setForeground(Color.WHITE);
std1.setFont(new Font("Times New Roman",3,25));
std1.setBounds(650,680,250,30);
add(std1);
JLabel std2 = new JLabel("3. Mansi Chaudhari ",JLabel.CENTER);
std2.setForeground(Color.WHITE);
std2.setFont(new Font("Times New Roman",3,25));
std2.setBounds(850,680,300,30);
add(std2);
JLabel std3 = new JLabel("4.Sakshi Mahajan",JLabel.CENTER);
std3.setForeground(Color.WHITE);
std3.setFont(new Font("Times New Roman",3,25));
std3.setBounds(1100,680,250,30);
add(std3);

signup.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent ea)
{
	u.setText("");
	p.setText("");
	setVisible(false);
	frame1=new JFrame();
	frame1.setVisible(true);
	frame1.setSize(1366,768);
	//JFrame newbFrame=new JFrame();


	//new supplier
	ImageIcon simg=new ImageIcon("new buyer.png");
	JButton sbt=new JButton("",simg);
	sbt.setBounds(10,10,80,80);
	frame1.add(sbt);
	//label
	JLabel sl1=new JLabel("Set",JLabel.CENTER);
	sl1.setFont(new Font("Times New Roman",1,20));
	sl1.setForeground(Color.WHITE);
	sl1.setBounds(5,70,95,70);
	frame1.add(sl1);
	JLabel sl2=new JLabel("Password",JLabel.CENTER);
	sl2.setFont(new Font("Times New Roman",1,20));
	sl2.setForeground(Color.WHITE);
	sl2.setBounds(0,82,95,95);
	frame1.add(sl2);
	sbt.addActionListener(new ActionListener()
	{
	public void actionPerformed(ActionEvent e)
	{
	Forget forg=new Forget();
	}
	});


	//logout button
	ImageIcon lgimg=new ImageIcon("logout.png");
	JButton lgbuyerbt=new JButton("",lgimg);
	lgbuyerbt.setBounds(105,10,80,80);
	 frame1.add(lgbuyerbt);
	JLabel lgbuyerl=new JLabel("Logout",JLabel.CENTER);
	lgbuyerl.setFont(new Font("Times New Roman",1,20));
	lgbuyerl.setForeground(Color.WHITE);
	lgbuyerl.setBounds(90,60,100,100);
	frame1.add(lgbuyerl);
	lgbuyerbt.addActionListener(new ActionListener()
	{
	public void actionPerformed(ActionEvent e)
	{
	int x
	=JOptionPane.showConfirmDialog(null,"Do you realy want to close","confirm",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
	 if(x==0)
	{
	frame1.setVisible(false);
	setVisible(true);
	} }
	});

	ImageIcon backimg=new ImageIcon("home.PNG");
	JLabel lbackimg=new JLabel("",backimg,JLabel.CENTER);
	lbackimg.setBounds(0,0,1366,768);
	frame1.add(lbackimg);

}
});

forge.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent ea)
{
	u.setText("");
		p.setText("");
		setVisible(false);
		frame1=new JFrame();
		frame1.setVisible(true);
		frame1.setSize(1366,768);
		//JFrame newbFrame=new JFrame();


		//new supplier
		ImageIcon simg=new ImageIcon("new buyer.png");
		JButton sbt=new JButton("",simg);
		sbt.setBounds(10,10,80,80);
		frame1.add(sbt);
		//label
		JLabel sl1=new JLabel("Forget",JLabel.CENTER);
		sl1.setFont(new Font("Times New Roman",1,20));
		sl1.setForeground(Color.WHITE);
		sl1.setBounds(5,70,95,70);
		frame1.add(sl1);
		JLabel sl2=new JLabel("Password",JLabel.CENTER);
		sl2.setFont(new Font("Times New Roman",1,20));
		sl2.setForeground(Color.WHITE);
		sl2.setBounds(0,82,95,95);
		frame1.add(sl2);
		sbt.addActionListener(new ActionListener()
		{
		public void actionPerformed(ActionEvent e)
		{
		Signup si=new Signup();
		}
		});


		//logout button
		ImageIcon lgimg=new ImageIcon("logout.png");
		JButton lgbuyerbt=new JButton("",lgimg);
		lgbuyerbt.setBounds(105,10,80,80);
		 frame1.add(lgbuyerbt);
		JLabel lgbuyerl=new JLabel("Logout",JLabel.CENTER);
		lgbuyerl.setFont(new Font("Times New Roman",1,20));
		lgbuyerl.setForeground(Color.WHITE);
		lgbuyerl.setBounds(90,60,100,100);
		frame1.add(lgbuyerl);
		lgbuyerbt.addActionListener(new ActionListener()
		{
		public void actionPerformed(ActionEvent e)
		{
		int x
		=JOptionPane.showConfirmDialog(null,"Do you realy want to close","confirm",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
		 if(x==0)
		{
		frame1.setVisible(false);
		setVisible(true);
		} }
		});

		ImageIcon backimg=new ImageIcon("home.PNG");
		JLabel lbackimg=new JLabel("",backimg,JLabel.CENTER);
		lbackimg.setBounds(0,0,1366,768);
		frame1.add(lbackimg);

}
});


//admin login
ln.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent ea)
{
	try
	{
		Connection conn;
		Statement stmt;
		PreparedStatement st=null;
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver is register");
		conn =
		DriverManager.getConnection("jdbc:mysql://localhost:3306/billmanagementproject","Hemangi","hemangi456");
		st=conn.prepareStatement("select * from account where username=? and password=?");

		st.setString(1,u.getText());
		st.setString(2,p.getText());
		ResultSet rs = st.executeQuery();

		while (rs.next()) {
		   use=rs.getString("username");
		   pas=rs.getString("password");

		}


		}
		catch(Exception e)
		{
			System.out.println(e);
			JOptionPane.showMessageDialog(null,"Username does not exist","Message",JOptionPane.INFORMATION_MESSAGE);
		}

if(u.getText().equals("Admin") && p.getText().equals("Admin"))
{

	u.setText("");
	p.setText("");
setVisible(false);
frame1=new JFrame();
frame1.setVisible(true);
frame1.setSize(1366,768);
//JFrame newbFrame=new JFrame();
JFrame mbFrame=new JFrame();
JFrame pFrame=new JFrame();
JFrame mpFrame=new JFrame();
JFrame pdFrame=new JFrame();
JFrame billFrame=new JFrame();


//new supplier
ImageIcon simg=new ImageIcon("new buyer.png");
JButton sbt=new JButton("",simg);
sbt.setBounds(10,10,80,80);
frame1.add(sbt);
//label
JLabel sl=new JLabel("New",JLabel.CENTER);
sl.setFont(new Font("Times New Roman",1,20));
sl.setForeground(Color.WHITE);
sl.setBounds(5,70,95,70);
frame1.add(sl);
JLabel sl2=new JLabel("Supplier",JLabel.CENTER);
sl2.setFont(new Font("Times New Roman",1,20));
sl2.setForeground(Color.WHITE);
sl2.setBounds(0,82,95,95);
frame1.add(sl2);

sbt.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent e)
{
suplFrame sFrame = new suplFrame();
}
});

//modify supplier
ImageIcon msimg=new ImageIcon("Update buyer.png");
JButton msbtn=new JButton("",msimg);
msbtn.setBounds(105,10,80,80);
frame1.add(msbtn);
JLabel msl=new JLabel("Modify",JLabel.CENTER);
msl.setFont(new Font("Times New Roman",1,20));
msl.setForeground(Color.WHITE);
msl.setBounds(90,60,100,100);
frame1.add(msl);
JLabel msl2=new JLabel("Supplier",JLabel.CENTER);
msl2.setFont(new Font("Times New Roman",1,20));
msl2.setForeground(Color.WHITE);
msl2.setBounds(90,80,100,100);
frame1.add(msl2);

msbtn.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent e)
{
modifysFrame msFrame = new modifysFrame();
}
});

//Supplier Details
ImageIcon sdimg=new ImageIcon("details product.png");
JButton sdbt=new JButton("",sdimg);
sdbt.setBounds(200,10,80,80);
frame1.add(sdbt);
JLabel sdbuyerl=new JLabel("Supplier",JLabel.CENTER);
sdbuyerl.setFont(new Font("Times New Roman",1,20));
sdbuyerl.setForeground(Color.WHITE);
sdbuyerl.setBounds(192,60,100,100);
frame1.add(sdbuyerl);
JLabel sdbuyer2=new JLabel("Details",JLabel.CENTER);
sdbuyer2.setFont(new Font("Times New Roman",1,20));
sdbuyer2.setForeground(Color.WHITE);
sdbuyer2.setBounds(191,80,100,100);
frame1.add(sdbuyer2);
 sdbt.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent e){
sdetails sdt = new sdetails();
}
});

//new staff
ImageIcon stimg=new ImageIcon("new buyer.png");
JButton nsbt=new JButton("",stimg);
nsbt.setBounds(295,10,80,80);
frame1.add(nsbt);
//label
JLabel stl=new JLabel("New",JLabel.CENTER);
stl.setFont(new Font("Times New Roman",1,20));
stl.setForeground(Color.WHITE);
stl.setBounds(290,60,100,100);
frame1.add(stl);
JLabel stl2=new JLabel("Staff",JLabel.CENTER);
stl2.setFont(new Font("Times New Roman",1,20));
stl2.setForeground(Color.WHITE);
stl2.setBounds(280,80,100,100);
frame1.add(stl2);
nsbt.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent e)
{
newstFrame stFrame = new newstFrame();
}
});

//Modify Staff
ImageIcon mstimg=new ImageIcon("Update buyer.png");
JButton mstbtn=new JButton("",mstimg);
mstbtn.setBounds(390,10,80,80);
frame1.add(mstbtn);
JLabel mstl=new JLabel("Modify",JLabel.CENTER);
mstl.setFont(new Font("Times New Roman",1,20));
mstl.setForeground(Color.WHITE);
mstl.setBounds(360,30,150,150);
frame1.add(mstl);
JLabel mstl2=new JLabel("Staff",JLabel.CENTER);
mstl2.setFont(new Font("Times New Roman",1,20));
mstl2.setBounds(360,50,150,150);
mstl2.setForeground(Color.WHITE);
frame1.add(mstl2);
mstbtn.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent e) {
modifystFrame mstFrame = new modifystFrame();
}
});
//Staff details
ImageIcon stdimg=new ImageIcon("details product.png");
JButton stdbt=new JButton("",stdimg);
stdbt.setBounds(485,10,80,80);
frame1.add(stdbt);
JLabel stdbuyerl=new JLabel("Staff",JLabel.CENTER);
stdbuyerl.setFont(new Font("Times New Roman",1,20));
stdbuyerl.setForeground(Color.WHITE);
stdbuyerl.setBounds(470,55,100,100);
frame1.add(stdbuyerl);
JLabel stdbuyer2=new JLabel("Details",JLabel.CENTER);
stdbuyer2.setFont(new Font("Times New Roman",1,20));
stdbuyer2.setForeground(Color.WHITE);
stdbuyer2.setBounds(470,75,100,100);
frame1.add(stdbuyer2);
 stdbt.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent e){
stfdetails stdt = new stfdetails();
}
});

//new product
ImageIcon npimg=new ImageIcon("new product.png");
JButton npbuyerbt=new JButton("",npimg);
npbuyerbt.setBounds(583,10,80,80);
frame1.add(npbuyerbt);
JLabel npbuyerl=new JLabel("New",JLabel.CENTER);
npbuyerl.setFont(new Font("Times New Roman",1,20));
npbuyerl.setForeground(Color.WHITE);
npbuyerl.setBounds(570,55,100,100);
frame1.add(npbuyerl);
JLabel npbuyer2=new JLabel("Product",JLabel.CENTER);
npbuyer2.setFont(new Font("Times New Roman",1,20));
npbuyer2.setForeground(Color.WHITE);
npbuyer2.setBounds(570,75,100,100);
frame1.add(npbuyer2);
npbuyerbt.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent e)
{
newpFrame npf = new newpFrame();
}
});

//modify product
ImageIcon mpimg=new ImageIcon("update product.png");
JButton mpbuyerbt=new JButton("",mpimg);
mpbuyerbt.setBounds(680,10,80,80);
frame1.add(mpbuyerbt);
JLabel mpbuyerl=new JLabel("Modify",JLabel.CENTER);
mpbuyerl.setFont(new Font("Times New Roman",1,20));
mpbuyerl.setForeground(Color.WHITE);
mpbuyerl.setBounds(650,32,150,150);
frame1.add(mpbuyerl);
JLabel mpbuyer2=new JLabel("Product",JLabel.CENTER);
mpbuyer2.setFont(new Font("Times New Roman",1,20));
mpbuyer2.setForeground(Color.WHITE);
mpbuyer2.setBounds(649,48,150,150);
frame1.add(mpbuyer2);
mpbuyerbt.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent e)
{
modifypFrame mpf = new modifypFrame();
}
});

//Product Details
ImageIcon pdimg=new ImageIcon("details product.png");
JButton pdbuyerbt=new JButton("",pdimg);
pdbuyerbt.setBounds(775,10,80,80);
frame1.add(pdbuyerbt);
JLabel pdbuyerl=new JLabel("Product",JLabel.CENTER);
pdbuyerl.setFont(new Font("Times New Roman",1,20));
pdbuyerl.setForeground(Color.WHITE);
pdbuyerl.setBounds(740,30,150,150);
 frame1.add(pdbuyerl);
 JLabel pdbuyer2=new JLabel("Details",JLabel.CENTER);
pdbuyer2.setFont(new Font("Times New Roman",1,20));
pdbuyer2.setForeground(Color.WHITE);
pdbuyer2.setBounds(740,50,150,150);
 frame1.add(pdbuyer2);
 pdbuyerbt.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent e)
{
pdetails pdt = new pdetails();
}
});

//Login Details
ImageIcon pdim=new ImageIcon("details product.png");
JButton pdbuyerb=new JButton("",pdim);
pdbuyerb.setBounds(870,10,80,80);
frame1.add(pdbuyerb);
JLabel pdbuyer=new JLabel("Login",JLabel.CENTER);
pdbuyer.setFont(new Font("Times New Roman",1,20));
pdbuyer.setForeground(Color.WHITE);
pdbuyer.setBounds(830,30,150,150);
frame1.add(pdbuyer);
JLabel pdbuye=new JLabel("Details",JLabel.CENTER);
pdbuye.setFont(new Font("Times New Roman",1,20));
pdbuye.setForeground(Color.WHITE);
pdbuye.setBounds(830,50,150,150);
 frame1.add(pdbuye);
 pdbuyerb.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent e)
{
	Loginuser login=new Loginuser();
}
});

//close tab
ImageIcon climg=new ImageIcon("Close.png");
JButton clsbuyerbt=new JButton("",climg);
clsbuyerbt.setBounds(965,10,80,80);
 frame1.add(clsbuyerbt);
 JLabel clsbuyerl=new JLabel("Close",JLabel.CENTER);
clsbuyerl.setFont(new Font("Times New Roman",1,20));
clsbuyerl.setForeground(Color.WHITE);
clsbuyerl.setBounds(931,30,150,150);
frame1.add(clsbuyerl);
clsbuyerbt.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent e)
{
int x
=JOptionPane.showConfirmDialog(null,"Do you realy want to close","confirm",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
 if(x==0)
{
System.exit(0);
}
}
});
//logout button
ImageIcon lgimg=new ImageIcon("logout.png");
JButton lgbuyerbt=new JButton("",lgimg);
lgbuyerbt.setBounds(1060,10,80,80);
 frame1.add(lgbuyerbt);
JLabel lgbuyerl=new JLabel("Logout",JLabel.CENTER);
lgbuyerl.setFont(new Font("Times New Roman",1,20));
lgbuyerl.setForeground(Color.WHITE);
lgbuyerl.setBounds(1020,40,150,150);
frame1.add(lgbuyerl);
lgbuyerbt.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent e)
{
int x
=JOptionPane.showConfirmDialog(null,"Do you realy want to close","confirm",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
 if(x==0)
{
frame1.setVisible(false);
setVisible(true);
} }
});

ImageIcon backimg=new ImageIcon("home.PNG");
JLabel lbackimg=new JLabel("",backimg,JLabel.CENTER);
lbackimg.setBounds(0,0,1366,768);
frame1.add(lbackimg);
}
else if(u.getText().equals(use) && p.getText().equals(pas))
{
	try
		{
			Connection conn;
			Statement stmt;
			PreparedStatement st=null;
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver is register");
			conn =
			DriverManager.getConnection("jdbc:mysql://localhost:3306/billmanagementproject","Hemangi","hemangi456");
			st=conn.prepareStatement("select * from account where username=? and password=?");

			st.setString(1,u.getText());
			st.setString(2,p.getText());
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
			   use=rs.getString("username");
			   pas=rs.getString("password");

			}

		    rs = st.executeQuery("select s_no from cashierlogindata order by s_no");
		   	rs.afterLast();

		   	if (rs.previous()) {
		   		cec = rs.getInt(1);
		   	} else {
		   		cec = 0;
		   	}

		   	cec1 = ++cec;


			if(use==null||pas==null)
			{
			}
			else
			st.executeUpdate("insert into cashierlogindata values('" + cec1 + "','" + use + "','" + pas + "','"+ time + "','" + time + "','" + date + "')");



	//JOptionPane.showMessageDialog(null,"get Successfully ","Message",JOptionPane.INFORMATION_MESSAGE);
			}
			catch(Exception e)
			{
				System.out.println(e);
				JOptionPane.showMessageDialog(null,"Username does not exist","Message",JOptionPane.INFORMATION_MESSAGE);
			}


	u.setText("");
	p.setText("");
	setVisible(false);
	frame1=new JFrame();
	frame1.setVisible(true);
	frame1.setSize(1366,768);
	//JFrame newbFrame=new JFrame();
	JFrame mbFrame=new JFrame();
	JFrame pFrame=new JFrame();
	JFrame mpFrame=new JFrame();
	JFrame pdFrame=new JFrame();
	JFrame billFrame=new JFrame();
	//newbuyer button with label
	ImageIcon bimg=new ImageIcon("new buyer.png");
	JButton newbuyerbt=new JButton("",bimg);
	newbuyerbt.setBounds(10,10,80,80);
	frame1.add(newbuyerbt);
	JLabel newbuyerl=new JLabel("New",JLabel.CENTER);
	newbuyerl.setFont(new Font("Times New Roman",1,20));
	newbuyerl.setForeground(Color.WHITE);
	newbuyerl.setBounds(5,70,95,70);
	frame1.add(newbuyerl);
	JLabel newbuyer2=new JLabel("Buyer",JLabel.CENTER);
	newbuyer2.setFont(new Font("Times New Roman",1,20));
	newbuyer2.setBounds(0,82,95,95);
	newbuyer2.setForeground(Color.WHITE);
	frame1.add(newbuyer2);
	newbuyerbt.addActionListener(new ActionListener()
	{
	public void actionPerformed(ActionEvent e)
	{
	newbFrame newbuyerFramepk = new newbFrame();
	}
});
//modify button with label
ImageIcon uimg=new ImageIcon("Update buyer.png");
JButton upbuyerbt=new JButton("",uimg);
upbuyerbt.setBounds(105,10,80,80);
frame1.add(upbuyerbt);
JLabel upbuyerl=new JLabel("Modify",JLabel.CENTER);
upbuyerl.setFont(new Font("Times New Roman",1,20));
upbuyerl.setForeground(Color.WHITE);
upbuyerl.setBounds(90,60,100,100);
frame1.add(upbuyerl);
JLabel upbuyerl2=new JLabel("Buyer",JLabel.CENTER);
upbuyerl2.setFont(new Font("Times New Roman",1,20));
upbuyerl2.setForeground(Color.WHITE);
upbuyerl2.setBounds(90,80,100,100);
frame1.add(upbuyerl2);
upbuyerbt.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent e)
{
modifybFrame modifybuyerFrame = new
modifybFrame();
}
});
//billing
ImageIcon blimg=new ImageIcon("billing frame.png");
JButton blbuyerbt=new JButton("",blimg);
blbuyerbt.setBounds(200,10,80,80);
 frame1.add(blbuyerbt);
 JLabel blbuyerl=new JLabel("Billing",JLabel.CENTER);
blbuyerl.setFont(new Font("Times New Roman",1,20));
blbuyerl.setForeground(Color.WHITE);
blbuyerl.setBounds(192,60,100,100);
frame1.add(blbuyerl);
blbuyerbt.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent e)
{
billing bil = new billing();
}
});
//close tab
ImageIcon climg=new ImageIcon("Close.png");
JButton clsbuyerbt=new JButton("",climg);
clsbuyerbt.setBounds(295,10,80,80);
 frame1.add(clsbuyerbt);
 JLabel clsbuyerl=new JLabel("Close",JLabel.CENTER);
clsbuyerl.setFont(new Font("Times New Roman",1,20));
clsbuyerl.setForeground(Color.WHITE);
clsbuyerl.setBounds(290,60,100,100);
frame1.add(clsbuyerl);
clsbuyerbt.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent e)
{
int x
=JOptionPane.showConfirmDialog(null,"Do you realy want to close","confirm",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
 if(x==0)
{
System.exit(0);
}
}
});
//logout button
ImageIcon lgimg=new ImageIcon("logout.png");
JButton lgbuyerbt=new JButton("",lgimg);
lgbuyerbt.setBounds(390,10,80,80);
 frame1.add(lgbuyerbt);
JLabel lgbuyerl=new JLabel("Logout",JLabel.CENTER);
lgbuyerl.setFont(new Font("Times New Roman",1,20));
lgbuyerl.setForeground(Color.WHITE);
lgbuyerl.setBounds(360,30,150,150);
frame1.add(lgbuyerl);
lgbuyerbt.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent e)
{

int x
=JOptionPane.showConfirmDialog(null,"Do you realy want to close","confirm",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
 if(x==0)
{
frame1.setVisible(false);
setVisible(true);
} }
});

ImageIcon backimg=new ImageIcon("home.PNG");
JLabel lbackimg=new JLabel("",backimg,JLabel.CENTER);
lbackimg.setBounds(0,0,1366,768);
frame1.add(lbackimg);
}
else
{
JOptionPane.showMessageDialog(null,"Incorrect User name and password","Message",JOptionPane.INFORMATION_MESSAGE);
}
}
});
//Close Button
ImageIcon cimg=new ImageIcon("close Jframe.png");
close.setIcon(cimg);
close.setFont(new Font("Times New Roman",1,18));
close.setBounds(1080,465,120,30);
add(close);
 close.addActionListener(new ActionListener()
 {
public void actionPerformed(ActionEvent e)
{
int x =JOptionPane.showConfirmDialog(null,"Do you realy want toclose Application","confirm",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
if(x==0)
{
System.exit(0);
}
}
});
 //Background Image
ImageIcon back=new ImageIcon("login background.PNG");
JLabel bimg=new JLabel("",back,JLabel.CENTER);
bimg.setBounds(0,0,1366,768);
add(bimg);
}
public static void main(String []args)
{
BillManagementSystem bms=new BillManagementSystem();
bms.setVisible(true);
}
}