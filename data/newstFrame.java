package data;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class newstFrame extends JFrame
{
public newstFrame()
{
//JFrame newbFrame=new JFrame();
setBounds(390,200,600,450);
 setLayout(null);
setUndecorated(true);
setResizable(false);
setVisible(true);
//new buyer label
//ImageIcon newblimg=new ImageIcon("New buyer ani.gif");
JLabel newsp=new JLabel("New Staff");
newsp.setFont(new Font("Times New Roman",1,40));
newsp.setBounds(210,-20,350,110);
add(newsp);
//new buyer logo
ImageIcon newblgimg = new ImageIcon("new buyer.png");
JLabel newblg=new JLabel(newblgimg);
newblg.setBounds(120,-10,100,100);
add(newblg);
JSeparator s=new JSeparator();
s.setBounds(1,80,1000,50);
s.setBackground(new Color(255,200,100));
add(s);
//New Buyer info labels
JLabel buyernamel = new JLabel("Name");
JLabel buyercontactl = new JLabel("Contact_No");
JLabel buyeremaill = new JLabel("Email");
JLabel buyeraddressl = new JLabel("Address");
JLabel buyergenderl = new JLabel("Gender");
//labels font
buyernamel.setFont(new Font("Times New Roman",1,18));
buyercontactl.setFont(new Font("Times New Roman",1,18));
buyeremaill.setFont(new Font("Times New Roman",1,18));
buyeraddressl.setFont(new Font("Times New Roman",1,18));
buyergenderl.setFont(new Font("Times New Roman",1,18));
//textfield for buyer info
JTextField buyernamet = new JTextField(200);
JTextField buyercontactt = new JTextField(200);
JTextField buyeremailt = new JTextField(200);
JTextField buyeraddresst = new JTextField(200);
String genderstr[] = {"Select Gender","Male", "Female"};
JComboBox nbgender = new JComboBox(genderstr);
//textfield fonts
nbgender.setFont(new Font("Times New Roman",1,18));
buyernamet.setFont(new Font("Times New Roman",1,18));
buyercontactt.setFont(new Font("Times New Roman",1,18));
buyeremailt.setFont(new Font("Times New Roman",1,18));
buyeraddresst.setFont(new Font("Times New Roman",1,18));
//adding labels on frame
buyernamel.setBounds(100,90,50,50);
add(buyernamel);
buyercontactl.setBounds(100,140,100,50);
add(buyercontactl);
buyeremaill.setBounds(100,190,80,50);
add(buyeremaill);
buyeraddressl.setBounds(100,240,80,50);
add(buyeraddressl);
buyergenderl.setBounds(100,290,80,50);
add(buyergenderl);
//adding textfields on frame
buyernamet.setBounds(210,100,300,30);
add(buyernamet);
buyercontactt.setBounds(210,150,300,30);
add(buyercontactt);
buyeremailt.setBounds(210,200,300,30);
add(buyeremailt);
buyeraddresst.setBounds(210,250,300,30);
add(buyeraddresst);
nbgender.setBounds(210,300,300,30);
add(nbgender);
JSeparator s1=new JSeparator();
s1.setBounds(1,350,1000,50);
s1.setBackground(new Color(255,200,100));
add(s1);
//Close button
ImageIcon buyercloseimg = new ImageIcon("close Jframe.png");
JButton buyerclosebtn = new JButton("Close",buyercloseimg);
buyerclosebtn.setFont(new Font("Times New Roman",1,15));
buyerclosebtn.setBounds(400,380,100,30);
add(buyerclosebtn);
buyerclosebtn.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent be)
{
int x = JOptionPane.showConfirmDialog(null,"Do you realy want to close buyer","confirm",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
if(x==0)
{
setVisible(false);
}
}
});
//Reset button
ImageIcon buyerresetimg = new ImageIcon("Reset.png");
JButton buyerresetbtn = new JButton("Reset",buyerresetimg);
buyerresetbtn.setFont(new Font("Times New Roman",1,15));
buyerresetbtn.setBounds(250,380,100,30);
add(buyerresetbtn);
buyerresetbtn.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent bre)
{
setVisible(false);
new newstFrame().setVisible(true);
}
});
//save button
ImageIcon buyersaveimg = new ImageIcon("Save.png");
JButton buyersavebtn = new JButton("Save",buyersaveimg);
buyersavebtn.setFont(new Font("Times New Roman",1,15));
buyersavebtn.setBounds(100,380,100,30);
add(buyersavebtn);
buyersavebtn.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent bre)
{
String bName = buyernamet.getText();
String bContact_no = buyercontactt.getText();
String bEmail = buyeremailt.getText();
String bAddress = buyeraddresst.getText();
String bGender = (String)nbgender.getSelectedItem();
if(bName.equals("") || bContact_no.equals("") || bEmail.equals("") || bAddress.equals(""))
{
JOptionPane.showMessageDialog(null,"Enter Details of staff","Message",JOptionPane.INFORMATION_MESSAGE);
}
else
{
try
{
Connection conn;
 Statement stmt;
Class.forName("com.mysql.cj.jdbc.Driver");
System.out.println("Driver is register");
conn =
DriverManager.getConnection("jdbc:mysql://localhost:3306/billmanagementproject","Hemangi","hemangi456");
stmt = conn.createStatement();
String sqls="Insert into staff values('"+bName+"','"+bContact_no+"','"+bEmail+"','"+bAddress+"','"+bGender+"');";
System.out.println(sqls);
stmt.executeUpdate(sqls);
JOptionPane.showMessageDialog(null,"Successfully saved","Message",JOptionPane.INFORMATION_MESSAGE);
setVisible(false);
new newstFrame().setVisible(true);
}
catch(Exception e)
{
System.out.println(e);
JOptionPane.showMessageDialog(null,"Mobile no is already exist","Message",JOptionPane.INFORMATION_MESSAGE);
}
}
}
});
ImageIcon newbuyerbackimg = new ImageIcon("all page background image.png");
JLabel newbbackimg = new JLabel(newbuyerbackimg);
newbbackimg.setBounds(0,0,600,450);
add(newbbackimg);
}
}
