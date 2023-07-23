package data;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class modifysFrame extends JFrame
{
public modifysFrame()
{
//JFrame newbFrame=new JFrame();
setBounds(390,200,600,450);
 setLayout(null);
setUndecorated(true);
setResizable(false);
setVisible(true);
//new buyer label
//ImageIcon newblimg=new ImageIcon("update buyer ani.gif");
JLabel newblb=new JLabel("Update Supplier");
newblb.setFont(new Font("Times New Roman",1,40));
newblb.setBounds(210,-20,350,110);
add(newblb);
//new buyer logo
ImageIcon newblgimg = new ImageIcon("Update buyer.png");
JLabel newblg=new JLabel(newblgimg);
newblg.setBounds(120,-10,100,100);
add(newblg);
JSeparator s=new JSeparator();
s.setBounds(1,80,1000,50);
s.setBackground(new Color(255,200,100));
add(s);
//Labels for modify buyers
JLabel lname = new JLabel("Name");
JLabel lc_no = new JLabel("Contact No");
JLabel lco_no = new JLabel("Contact No");
JLabel lemail = new JLabel("Email");
JLabel laddress = new JLabel("Address");
JLabel lgender = new JLabel("Gender");
//labels Fonts
lname.setFont(new Font("Times New Roman",1,18));
lc_no .setFont(new Font("Times New Roman",1,18));
lco_no .setFont(new Font("Times New Roman",1,18));
lemail.setFont(new Font("Times New Roman",1,18));
laddress.setFont(new Font("Times New Roman",1,18));
lgender.setFont(new Font("Times New Roman",1,18));
//Textfields
JTextField tc_no = new JTextField(200);
JTextField tname = new JTextField(200);
JTextField tco_no = new JTextField(200);
JTextField temail = new JTextField(200);
JTextField taddress = new JTextField(200);
JTextField tgender = new JTextField(200);
//Textfields font
tname.setFont(new Font("Times New Roman",1,18));
tc_no .setFont(new Font("Times New Roman",1,18));
tco_no .setFont(new Font("Times New Roman",1,18));
temail.setFont(new Font("Times New Roman",1,18));
taddress.setFont(new Font("Times New Roman",1,18));
tgender.setFont(new Font("Times New Roman",1,18));
// update buttons
ImageIcon updateimg = new ImageIcon("save.png");
JButton updateb = new JButton("Update", updateimg);
updateb.setBounds(30,380,100,30);
add(updateb);
updateb.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent ae)
{
System.out.println("update");
String nameu = tname.getText();
String cont = tc_no.getText();
String contactu = tco_no.getText();
String emailu = temail.getText();
String addressu = taddress.getText();
String genderu = tgender.getText();
if(contactu.equals("") || nameu.equals("") || emailu.equals("") ||
cont.equals("") || genderu.equals("") || addressu.equals(""))
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
String strup = " Update suppliers set sname = '"+nameu+"', scontact_no = '"+contactu+"', semail = '"+emailu+"', saddress = '"+addressu+"', sgender = '"+genderu+"' where scontact_no = '"+cont+"';";
stmtmu.executeUpdate(strup);
System.out.println(strup);
JOptionPane.showMessageDialog(null,"Updated successfully","Message",JOptionPane.INFORMATION_MESSAGE);
setVisible(false);
new modifysFrame().setVisible(true);
}
catch(Exception exp)
{
System.out.println(exp);
JOptionPane.showMessageDialog(null,"Contact_no does not exist","Message",JOptionPane.INFORMATION_MESSAGE);
}
}
}
});
//delete button
ImageIcon deleteimg = new ImageIcon("delete.png");
JButton deleteb = new JButton("Delete" , deleteimg);
deleteb.setBounds(180,380,100,30);
add(deleteb);
deleteb.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent eea)
{
int a = JOptionPane.showConfirmDialog(null,"Do you realy want to delete supplier","confirm",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
if(a==0)
{
System.out.println("det");
String nameu = tname.getText();
String cont1 = tc_no.getText();
String contactu = tco_no.getText();
String emailu = temail.getText();
String addressu = taddress.getText();
String genderu = tgender.getText();
if(contactu.equals("") || nameu.equals("") || emailu.equals("") || cont1.equals("") || genderu.equals("") || addressu.equals(""))
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
String strdl = " delete from suppliers where scontact_no= '"+cont1+"';";
stmtmu.executeUpdate(strdl);
System.out.println(strdl);
JOptionPane.showMessageDialog(null,"Supplier Deleted","Message",JOptionPane.INFORMATION_MESSAGE);
setVisible(false);
new modifysFrame().setVisible(true);
}
catch(Exception exp) {
System.out.println(exp);
JOptionPane.showMessageDialog(null,"Contact_no does not exist","Message",JOptionPane.INFORMATION_MESSAGE);
}
}
}
}
});
//reset button
ImageIcon resetimg = new ImageIcon("Reset.png");
JButton resetb = new JButton("Reset", resetimg);
resetb.setBounds(330,380,100,30);
add(resetb);
resetb.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent ee)
{
setVisible(false);
new modifysFrame().setVisible(true);
}
});
//close button
ImageIcon closeimg = new ImageIcon("close Jframe.png");
JButton closeb = new JButton("Close" , closeimg);
closeb.setBounds(480,380,100,30);
add(closeb);
closeb.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent ea)
{
int x = JOptionPane.showConfirmDialog(null,"Do you realy want to close","confirm",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
if(x==0)
{
setVisible(false);
}
}
});
//search button
ImageIcon searchimg = new ImageIcon("search.png");
JButton searchb = new JButton("Search", searchimg);
searchb.setFont(new Font("Times New Roman",1,18));
//Adding components on frame (Search section)
lc_no.setBounds(100,30,150,150);
add(lc_no);
tc_no.setBounds(210,90,180,30);
add(tc_no);
searchb.setBounds(450,90,110,25);
add(searchb);
searchb.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent e)
{
System.out.println("Search");
String contact1 = tc_no.getText();
try
{
Connection connm;
Statement stmtm;
ResultSet rs;
Class.forName("com.mysql.cj.jdbc.Driver");
System.out.println("Driver is register");
connm =
DriverManager.getConnection("jdbc:mysql://localhost:3306/billmanagementproject","Hemangi","hemangi456");
stmtm = connm.createStatement();
rs = stmtm.executeQuery(" Select * from suppliers where scontact_no = "+contact1+";");
if(rs.next())
{
tname.setText(rs.getString(1));
tco_no.setText(rs.getString(2));
temail.setText(rs.getString(3));
taddress.setText(rs.getString(4));
tgender.setText(rs.getString(5));
tc_no.setEditable(false);
}
else
 JOptionPane.showMessageDialog(null,"Contact_no does not exist","Message",JOptionPane.INFORMATION_MESSAGE);
}
catch(Exception ex)
{
System.out.println(ex);
JOptionPane.showMessageDialog(null,"Contact does not exist","Message",JOptionPane.INFORMATION_MESSAGE);
}}
});
JSeparator s2=new JSeparator();
s2.setBounds(1,130,1000,50);
s2.setBackground(new Color(255,200,100));
add(s2);
//add component on frame
lname.setBounds(100,115,80,80 );
add(lname);
lco_no.setBounds(100,160,130,80);
add(lco_no);
lemail.setBounds(100,200,80,80);
add(lemail);
laddress.setBounds(100,245,100,80);
add(laddress);
lgender.setBounds(100,285,80,80);
add(lgender);
//add textfields on frame
tname.setBounds(215,135,300,30);
add(tname);
tco_no.setBounds(215,180,300,30);
add(tco_no);
temail.setBounds(215,225,300,30);
add(temail);
taddress.setBounds(215,270,300,30);
add(taddress);
tgender.setBounds(215,315,300,30);
add(tgender);
JSeparator s3=new JSeparator();
s3.setBounds(1,350,1000,50);
s3.setBackground(new Color(255,200,100));
add(s3);
ImageIcon modifybackimg = new ImageIcon("all page background image.png");
JLabel mbbackimg = new JLabel(modifybackimg);
mbbackimg.setBounds(0,0,600,450);
add(mbbackimg);
}
}
