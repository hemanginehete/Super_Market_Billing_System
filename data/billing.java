package data;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;
import java.time.format.*;
import java.time.LocalDateTime.*;
import java.lang.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
public class billing extends JFrame
{
JFrame billprint;
JTextArea billta;
public int finalTotal=0;
JTextArea ta = new JTextArea();
TextArea texta;
JLabel l1 = new JLabel("Date & Time : ");
JLabel t1 = new JLabel("");
JTextField tnm = new JTextField(100);
JTextField tc = new JTextField(100);
JTextField tmail = new JTextField(100);
JTextField tadd = new JTextField(100);
JTextField tt = new JTextField(20);
void dis()
{
Date date = new Date();
String s1 = date.toString();
t1.setText(s1);
}
public billing()
{
dis();
setBounds(100,200,1164,510);
setLayout(null);
setUndecorated(true);
setResizable(false);
setVisible(true);
l1.setFont(new Font("Times New Roman",1,20));
t1.setFont(new Font("Times New Roman",1,20));
l1.setBounds(600,20,150,30);
t1.setBounds(750,20,500,30);
add(l1);
add(t1);
JLabel namel = new JLabel("Name");
namel.setFont(new Font("Times New Roman",1,20));
JLabel c_nol = new JLabel("Contact No");
c_nol.setFont(new Font("Times New Roman",1,20));
JLabel maill = new JLabel("Email");
maill.setFont(new Font("Times New Roman",1,20));
JLabel addl = new JLabel("Address");
addl.setFont(new Font("Times New Roman",1,20));
//JTextField tnm = new JTextField(100);
tnm.setFont(new Font("Times New Roman",1,20));
//JTextField tc = new JTextField(100);
tc.setFont(new Font("Times New Roman",1,20));
//JTextField tmail = new JTextField(100);
tmail.setFont(new Font("Times New Roman",1,20));
//JTextField tadd = new JTextField(100);
tadd.setFont(new Font("Times New Roman",1,20));
JLabel buyer = new JLabel("Buyer Details:");
buyer.setFont(new Font("Times New Roman",1,25));
buyer.setBounds(5,70,200,80);
add(buyer);
namel.setBounds(10,130,80,30);
add(namel);
tnm.setBounds(70,130,180,30);
add(tnm);
tnm.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent ea)
{
String name = tnm.getText();
try{
Class.forName("com.mysql.cj.jdbc.Driver");
System.out.println("Driver is register");
Connection connm =
DriverManager.getConnection("jdbc:mysql://localhost:3306/billmanagementproject","Hemangi","hemangi456");
Statement stmtm = connm.createStatement();
ResultSet rs = stmtm.executeQuery(" Select * from buyer where name = '"+name+"';");
if(rs.next())
{
tc.setText(rs.getString(2));
tmail.setText(rs.getString(3));
tadd.setText(rs.getString(4));
tc.setEditable(false);
tmail.setEditable(false);
tadd.setEditable(false);
}
else
{
tc.setText("");
tmail.setText("");
tadd.setText("");
}
}
catch(Exception exn)
{
System.out.println(exn);
}
}
});
c_nol.setBounds(270,130,100,30);
add(c_nol);
tc.setBounds(380,130,180,30);
add(tc);
tc.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent ee){
String cno = tc.getText();
try{
Class.forName("com.mysql.cj.jdbc.Driver");
System.out.println("Driver is register");
Connection connm =
DriverManager.getConnection("jdbc:mysql://localhost:3306/billmanagementproject","Hemangi","hemangi456");
Statement stmtm = connm.createStatement();
ResultSet rs = stmtm.executeQuery(" Select * from buyer where contact_no = '"+cno+"';");
if(rs.next())
{
tnm.setText(rs.getString(1));
tmail.setText(rs.getString(3));
tadd.setText(rs.getString(4));
tnm.setEditable(false);
//tc.setEditable(false);
tmail.setEditable(false);
tadd.setEditable(false);
}
else
{
tnm.setText("");
tmail.setText("");
tadd.setText("");
}
}
catch(Exception exn)
{
System.out.println(exn);
}
}
});
maill.setBounds(580,130,80,30);
add(maill);
tmail.setBounds(630,130,200,30);
add(tmail);
addl.setBounds(840,130,80,30);
add(addl);
tadd.setBounds(910,130,180,30);
add(tadd);
JSeparator s2=new JSeparator();
s2.setBounds(1,165,1500,80);
s2.setBackground(new Color(255,200,100));
add(s2);
JLabel pd = new JLabel("Product Details:");
pd.setFont(new Font("Times New Roman",1,25));
pd.setBounds(5,160,200,40);
add(pd);
JLabel lid = new JLabel("Product Id");
lid.setFont(new Font("Times New Roman",1,20));
lid.setBounds(5,200,150,30);
add(lid);
JLabel lpnm = new JLabel("Product Name");
lpnm.setFont(new Font("Times New Roman",1,20));
lpnm.setBounds(300,200,150,30);
add(lpnm);
JLabel lr = new JLabel("Rate");
lr.setFont(new Font("Times New Roman",1,20));
lr.setBounds(620,200,80,30);
add(lr);
JLabel lq = new JLabel("Quantity");
lq.setFont(new Font("Times New Roman",1,20));
lq.setBounds(870,200,80,30);
add(lq);
JTextField tid = new JTextField(100);
tid.setFont(new Font("Times New Roman",1,20));
tid.setBounds(100,200,180,30);
add(tid);
JTextField tpnm = new JTextField(100);
tpnm.setFont(new Font("Times New Roman",1,20));
tpnm.setBounds(420,200,180,30);
add(tpnm);
JTextField tr = new JTextField(100);
tr.setFont(new Font("Times New Roman",1,20));
tr.setBounds(670,200,180,30);
add(tr);
JTextField tq = new JTextField(100);
tq.setFont(new Font("Times New Roman",1,20));
tq.setBounds(950,200,180,30);
add(tq);
//Product searching
tid.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent de)
{
String id = tid.getText();
try{
Class.forName("com.mysql.cj.jdbc.Driver");
System.out.println("Driver is register");
Connection connm =
DriverManager.getConnection("jdbc:mysql://localhost:3306/billmanagementproject","Hemangi","hemangi456");
Statement stmtm =
connm.createStatement();
ResultSet rs = stmtm.executeQuery(" Select * from product where pid = "+id+";");
if(rs.next())
{
tpnm.setText(rs.getString(2));
tr.setText(""+rs.getInt(3));
tq.setText("1");
tpnm.setEditable(false);
tr.setEditable(false);
}
else
{
tpnm.setText("");
tr.setText("");
tq.setText("");
}
}
catch(Exception exn)
{
System.out.println(exn);
}
}
});
ImageIcon addimg = new ImageIcon("add.png");
JButton add1 = new JButton("Add",addimg);
add1.setBounds(1000,235,80,25);
add(add1);
JSeparator s4=new JSeparator();
s4.setBounds(1,265,1500,80);
s4.setBackground(new Color(255,200,100));
add(s4);
ta.setBounds(10,270,500,240);
ta.setFont(new Font("Time and new Romon",1,14));
add(ta);
ta.setEditable(false);
JLabel dt = new JLabel("Calculation Details:");
dt.setFont(new Font("Time and new Romon",1,30));
dt.setBounds(550,270,300,40);
add(dt);
JLabel t = new JLabel("Total:");
t.setFont(new Font("time and new romon",1,25));
tt.setFont(new Font("time and new romon",1,25));
t.setBounds(550,300,100,100);
add(t);
tt.setBounds(650,335,100,30);
add(tt);
tt.setEditable(false);
//ta.setText("");
ta.append("_______________________________________________________________\n\r");
ta.setText("\tName\tRate\tQuantity\tTotal\n\r");
ta.append("_______________________________________________________________\n\r");
ta.append("===============================================================\n\r");
add1.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent ae)
{
int price = Integer.parseInt(tr.getText());
int qnt = Integer.parseInt(tq.getText());
int total = price*qnt;
String n = tpnm.getText();
finalTotal = finalTotal + total;
tt.setText(""+finalTotal);
ta.append("\t"+n+"\t"+price+"\t"+qnt+"\t "+total+"\n");
ta.append("===============================================================\n\r");
tid.setText("");
tpnm.setText("");
tr.setText("");
tq.setText("");
}
});
ImageIcon bimg = new ImageIcon("login.png");
ImageIcon cimg = new ImageIcon("close jframe.png");
ImageIcon rimg = new ImageIcon("reset.png");
JButton bill = new JButton("Bill",bimg);
JButton close = new JButton("Close",cimg);
JButton reset = new JButton("Reset",rimg);
bill.setBounds(600,450,100,40);
billta = new JTextArea();
billta.setText("");
billta.setEditable(false);
bill.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent fa){
if(tt.getText().equals(""))
{
JOptionPane.showMessageDialog(null,"Select Products","Message",JOptionPane.INFORMATION_MESSAGE);
}
else
{
JOptionPane.showMessageDialog(null,"Bill Generated","Message",JOptionPane.INFORMATION_MESSAGE);
setVisible(false);
billprint = new JFrame();
billprint.setLayout(null);
billprint.setBounds(100,200,1164,510);
billprint.setUndecorated(true);
billprint.setResizable(false);
billprint.setVisible(true);
billta.setFont(new Font("Time and new Romon",1,14));
billta.setBounds(250,10,650,450);
billprint.add(billta);
billta.setText(" \t\tBILLING MANAGEMENT SYSTEM\n");
billta.append("____________________________________________________________________________________________________\n\r");
billta.append("\t\t\tContact No:9764291880\n");
billta.append("\t\t\tDate & Time : "+t1.getText()+"\n");
billta.append("Buyer Details:-\n\tName:"+tnm.getText()+"\n\tContact No:"+tc.getText()+"\n\tEmail:"+tmail.getText()+"\n\tAddress:"+tadd.getText());
billta.append("\nProduct Details:-\n"+ta.getText()+"\n");
billta.append("\nTotal="+tt.getText()+"\n");
billta.append("\n\t\tThank you!! for visiting :) Please come again");
ImageIcon pimg = new ImageIcon("print.png");
JButton print1 = new JButton("Print",pimg);
//Buttons
print1.setBounds(520,480,100,30);
billprint.add(print1);
print1.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent eeee)
{
JFileChooser j = new JFileChooser();
j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
try{
billta.print();}
catch(Exception p)
{System.out.println(p);
}
}
});
 }
ImageIcon newbuyerbackimg = new ImageIcon("billingbackground.png");
JLabel newbbackimg = new JLabel(newbuyerbackimg);
newbbackimg.setBounds(0,0,1164,510);
billprint.add(newbbackimg);
}});
close.setBounds(780,450,130,40);
close.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent a){int x =JOptionPane.showConfirmDialog(null,"Do you realy want to close", "confirm",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
 if(x==0)
{
System.exit(0);
}}});
reset.setBounds(980,450,130,40);
reset.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent aa){
setVisible(false);
new billing().setVisible(true);}});
add(bill);
bill.setFont(new Font("Time and new Romon",1,20));
reset.setFont(new Font("Time and new Romon",1,20));
close.setFont(new Font("Time and new Romon",1,20));
add(close);
add(reset);
//new product logo
ImageIcon bllimg = new ImageIcon("billing frame.png");
JLabel newplg=new JLabel(bllimg);
newplg.setBounds(10,8,100,100);
add(newplg);
ImageIcon blimg=new ImageIcon("Billing ani.gif");
JLabel billbt=new JLabel(blimg);
billbt.setBounds(130,10,260,85);
add(billbt);
JSeparator s1=new JSeparator();
s1.setBounds(1,95,1500,80);
s1.setBackground(new Color(255,200,100));
add(s1);
ImageIcon newbuyerbackimg1= new ImageIcon("billing background.png");
JLabel newbbackimg1 = new JLabel(newbuyerbackimg1);
newbbackimg1.setBounds(0,0,1164,510);
add(newbbackimg1);
}

}
