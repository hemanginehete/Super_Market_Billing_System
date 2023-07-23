package data;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class modifypFrame extends JFrame
{
public modifypFrame(){
setBounds(390,200,600,450);
 setLayout(null);
setUndecorated(true);
setResizable(false);
setVisible(true);
//product label
ImageIcon mpimg=new ImageIcon("update product ani.gif");
JLabel mprblb=new JLabel(mpimg);
mprblb.setBounds(220,-90,250,250);
add(mprblb);
//product logo
ImageIcon mplgimg = new ImageIcon("update product.png");
JLabel mplg=new JLabel(mplgimg);
mplg.setBounds(120,-10,100,100);
add(mplg);
//Labels
JLabel lpid = new JLabel("Product Id");
JLabel lpname = new JLabel("Product Name");
JLabel lprate = new JLabel("Rate");
JLabel lactive = new JLabel("Activation");
//labels font
lpid.setFont(new Font("Times New Roman",1,20));
lpname.setFont(new Font("Times New Roman",1,20));
lprate.setFont(new Font("Times New Roman",1,20));
lactive.setFont(new Font("Times New Roman",1,20));
//textfield
JTextField tpid = new JTextField(200);
JTextField tpname =new JTextField(200);
JTextField tprate =new JTextField(200);
JTextField tactive = new JTextField(200);
//textfield font
tactive.setFont(new Font("Times New Roman",1,20));
tprate.setFont(new Font("Times New Roman",1,20));
tpname.setFont(new Font("Times New Roman",1,20));
tpid.setFont(new Font("Times New Roman",1,20));
lpid.setBounds(100,50,150,150);
add(lpid);
tpid.setBounds(250,110,50,30);
add(tpid);
lpname.setBounds(100,110,150,150);
add(lpname);
tpname.setBounds(250,170,300,30);
add(tpname);
//rate
lprate.setBounds(100,160,150,150);
add(lprate);
tprate.setBounds(250,220,300,30);
add(tprate);
//activation
lactive.setBounds(100,210,150,150);
add(lactive);
tactive.setBounds(250,270,300,30);
add(tactive);
//Buttons
ImageIcon searchimg = new ImageIcon("search.png");
ImageIcon upimg = new ImageIcon("save.png");
ImageIcon delimg = new ImageIcon("delete.png");
ImageIcon resetimg = new ImageIcon("reset.png");
ImageIcon closeimg = new ImageIcon("close jframe.png");
JButton searchp = new JButton("Search",searchimg);
searchp.setBounds(450,110,100,30);
add(searchp);
searchp.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent ee)
{
System.out.println("Search");
String idp = tpid.getText();
try{
Class.forName("com.mysql.cj.jdbc.Driver");
System.out.println("Driver is register");
Connection connp =
DriverManager.getConnection("jdbc:mysql://localhost:3306/billmanagementproject","Hemangi","hemangi456");
Statement stmtm = connp.createStatement();
ResultSet rs = stmtm.executeQuery(" Select * from product where pid = "+idp+";");
if(rs.next())
{
tpid.setText(""+rs.getInt(1));
tpname.setText(rs.getString(2));
tprate.setText(""+rs.getInt(3));
tactive.setText(rs.getString(4));
tpid.setEditable(false);
}
else{
 JOptionPane.showMessageDialog(null,"Product is not available","Message",JOptionPane.INFORMATION_MESSAGE);
}
}
catch(Exception ex)
{
System.out.println(ex);
JOptionPane.showMessageDialog(null,ex,"Message",JOptionPane.INFORMATION_MESSAGE
);
}}
});
JButton updatep = new JButton("Update",upimg);
updatep.setBounds(30,380,100,30);
add(updatep);
updatep.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent ae)
{
System.out.println("update");
String p_pid = tpid.getText();
String p_name = tpname.getText();
String p_rate = tprate.getText();
String p_active = tactive.getText();
if(p_pid.equals("") || p_name.equals("") || p_rate.equals("") ||
p_active.equals(""))
{
JOptionPane.showMessageDialog(null,"Information does not exist","Message",JOptionPane.INFORMATION_MESSAGE);
}
else{
try{
Class.forName("com.mysql.cj.jdbc.Driver");
System.out.println("Driver is register");
Connection connp =
DriverManager.getConnection("jdbc:mysql://localhost:3306/billmanagementproject","Hemangi","hemangi456");
Statement stp = connp.createStatement();
String strup = " Update product set pid= "+p_pid+", p_name = '"+p_name+"', p_rate ="+p_rate+", p_active = '"+p_active+"' where pid = "+p_pid+";";
stp.executeUpdate(strup);
System.out.println(strup);
JOptionPane.showMessageDialog(null,"Updated successfully","Message",JOptionPane.INFORMATION_MESSAGE);
setVisible(false);
new modifypFrame().setVisible(true);
}
catch(Exception exp)
{
System.out.println(exp);
JOptionPane.showMessageDialog(null,exp,"Message",JOptionPane.INFORMATION_MESSAGE);
}
}}
});
JButton deletep = new JButton("Delete",delimg);
deletep.setBounds(180,380,100,30);
add(deletep);
deletep.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent ea)
{
int a = JOptionPane.showConfirmDialog(null,"Do you realy want to delete Product","confirm",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
if(a==0){
String p_pid = tpid.getText();
String p_name = tpname.getText();
String p_rate = tprate.getText();
 String p_active = tactive.getText();
if(p_pid.equals("") || p_name.equals("") || p_rate.equals("") ||
p_active.equals(""))
{
JOptionPane.showMessageDialog(null,"Information does not exist","Message",JOptionPane.INFORMATION_MESSAGE);
}
else{
try{
Connection connmu;
Statement stmtmu;
Class.forName("com.mysql.cj.jdbc.Driver");
System.out.println("Driver is register");
connmu =
DriverManager.getConnection("jdbc:mysql://localhost:3306/billmanagementproject","Hemangi","hemangi456");
stmtmu = connmu.createStatement();
String strdl = " delete from product where pid = "+p_pid+";";
stmtmu.executeUpdate(strdl);
System.out.println(strdl);
JOptionPane.showMessageDialog(null,"Product Deleted","Message",JOptionPane.INFORMATION_MESSAGE);
setVisible(false);
new modifypFrame().setVisible(true);
}
catch(Exception exp) {
System.out.println(exp);
JOptionPane.showMessageDialog(null,"Product not exist","Message",JOptionPane.INFORMATION_MESSAGE);
}
}}}
});
JButton resetp = new JButton("Reset",resetimg);
resetp.setBounds(330,380,100,30);
add(resetp);
resetp.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent te)
{
setVisible(false);
new modifypFrame().setVisible(true);
}
});
JButton closep = new JButton("Close",closeimg);
closep.setBounds(480,380,100,30);
add(closep);
closep.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent ec)
{
int
x = JOptionPane.showConfirmDialog(null,"Do you realy want to close","confirm",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
if(x==0)
{
setVisible(false);
}}
});
//Seperator
JSeparator s4=new JSeparator();
s4.setBounds(1,90,1000,50);
s4.setBackground(new Color(255,200,100));
add(s4);
JSeparator s3 =new JSeparator();
s3.setBounds(1,150,1000,50);
s3.setBackground(new Color(255,200,100));
add(s3);
JSeparator s2 =new JSeparator();
s2.setBounds(1,330,1000,50);
s2.setBackground(new Color(255,200,100));
add(s2);
ImageIcon modifybackimg = new ImageIcon("all page background image.png");
JLabel mbbackimg = new JLabel(modifybackimg);
mbbackimg.setBounds(0,0,600,450);
add(mbbackimg);
}
}