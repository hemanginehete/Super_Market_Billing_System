package data;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class newpFrame extends JFrame implements ComponentListener
{
JLabel pidt = new JLabel();
public void componentHidden(ComponentEvent e) {}
 public void componentMoved(ComponentEvent e) { }
 public void componentResized(ComponentEvent e) {}
 public void componentShown(ComponentEvent e) {
 System.out.println("DONE");
try{
Class.forName("com.mysql.cj.jdbc.Driver");
Connection connm =
DriverManager.getConnection("jdbc:mysql://localhost:3306/billmanagementproject","Hemangi","hemangi456");
Statement stmtm = connm.createStatement();
ResultSet rs = stmtm.executeQuery(" select max(pid) from product ");
if(rs.first())
{
int id = rs.getInt(1);
id = id + 1;
String sr = String.valueOf(id);
pidt.setText(sr);
}
else
{
 pidt.setText("1");
 } }
catch(Exception ex)
{
//System.out.println(ex);
JOptionPane.showMessageDialog(null,ex,"Message",JOptionPane.INFORMATION_MESSAGE);
}}
public newpFrame()
{
addComponentListener(this);
setBounds(390,200,600,450);
 setLayout(null);
setUndecorated(true);
setResizable(false);
setVisible(true);
//new buyer label
ImageIcon newpimg=new ImageIcon("New Product ani.gif");
JLabel newprblb=new JLabel(newpimg);
newprblb.setBounds(210,-50,200,200);
add(newprblb);
//new product logo
ImageIcon newplgimg = new ImageIcon("new product.png");
JLabel newplg=new JLabel(newplgimg);
newplg.setBounds(120,-10,100,100);
add(newplg);
//Labels
JLabel lpid = new JLabel("Product Id");
JLabel lpname = new JLabel("Product Name");
JLabel lprate = new JLabel("Rate");
JLabel lactive = new JLabel("Active");
//labels font
lpid.setFont(new Font("Times New Roman",1,20));
pidt.setFont(new Font("Times New Roman",1,25));
lpname.setFont(new Font("Times New Roman",1,20));
lprate.setFont(new Font("Times New Roman",1,20));
lactive.setFont(new Font("Times New Roman",1,20));
//textfield
JTextField tpname =new JTextField(200);
JTextField tprate =new JTextField(200);
//textfield font
tprate.setFont(new Font("Times New Roman",1,20));
tpname.setFont(new Font("Times New Roman",1,20));
//pid label
lpid.setBounds(100,50,150,150);
add(lpid);
pidt.setBounds(250,110,50,30);
add(pidt);
//name
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
String activestr[] = {"","Yes","No"};
JComboBox activep = new JComboBox(activestr);
activep.setFont(new Font("Times New Roman",1,20));
activep.setBounds(250,270,300,30);
add(activep);
//Seperator
JSeparator s4=new JSeparator();
s4.setBounds(1,350,1000,50);
s4.setBackground(new Color(255,200,100));
add(s4);
//Buttons
ImageIcon saveimg = new ImageIcon("save.png");
JButton savep = new JButton("Save", saveimg);
savep.setBounds(100,370,100,30);
add(savep);
savep.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent bre)
{
String p_id = pidt.getText();
String p_name = tpname.getText();
String p_rate = tprate.getText();
String p_active = (String)activep.getSelectedItem();
if(p_name.equals("") || p_active.equals(""))
{
JOptionPane.showMessageDialog(null,"Enter Product details","Message",JOptionPane.INFORMATION_MESSAGE);
}
else{
try
{
Connection connp;
 Statement stmtp;
Class.forName("com.mysql.cj.jdbc.Driver");
System.out.println("Driver is register");
connp =
DriverManager.getConnection("jdbc:mysql://localhost:3306/billmanagementproject","Hemangi","hemangi456");
stmtp = connp.createStatement();
String sqlp="insert into product values("+ p_id +",'"+ p_name +"',"+p_rate+",'"+p_active+"');";
System.out.println(sqlp);
stmtp.executeUpdate(sqlp);
JOptionPane.showMessageDialog(null,"Successfully saved","Message",JOptionPane.INFORMATION_MESSAGE);
 setVisible(false);
 new newpFrame().setVisible(true);
 }
catch(Exception e)
{
System.out.println(e);
JOptionPane.showMessageDialog(null,e,"Message",JOptionPane.INFORMATION_MESSAGE);
}}}
});
ImageIcon resetimg = new ImageIcon("reset.png");
JButton resetp = new JButton("Reset" , resetimg);
resetp.setBounds(250,370,100,30);
add(resetp);
resetp.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent ee)
{
setVisible(false);
new newpFrame().setVisible(true);
}
});
ImageIcon closeimg = new ImageIcon("close Jframe.png");
JButton closep = new JButton("Close", closeimg);
closep.setBounds(400,370,100,30);
add(closep);
closep.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent ea)
{
int x = JOptionPane.showConfirmDialog(null,"Do you realy want to close","confirm",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
if(x==0)
{
setVisible(false);
}}
});
JSeparator s=new JSeparator();
s.setBounds(1,80,1000,50);
s.setBackground(new Color(255,200,100));
add(s);
//Background img
ImageIcon newbuyerbackimg = new ImageIcon("all page background image.png");
JLabel newbbackimg = new JLabel(newbuyerbackimg);
newbbackimg.setBounds(0,0,600,450);
add(newbbackimg);
}
}
