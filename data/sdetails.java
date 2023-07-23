package data;
import java.awt.*;
import java.lang.*;
import net.proteanit.sql.*;
import javax.swing.*;
import javax.swing.JTable.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.sql.*;
public class sdetails extends JFrame
{
JTable table = new JTable();
public sdetails(){
addComponentListener(new ComponentListener()
{
public void componentShown(ComponentEvent e){
System.out.println("hii");
try{
Class.forName("com.mysql.cj.jdbc.Driver");
System.out.println("Driver is register");
Connection con =
DriverManager.getConnection("jdbc:mysql://localhost:3306/billmanagementproject","Hemangi","hemangi456");
Statement st = con.createStatement();
ResultSet rs = st.executeQuery("Select * from suppliers");
table.setModel(DbUtils.resultSetToTableModel(rs));
} catch(Exception ex){
System.out.println(ex);
}
}
public void componentHidden(ComponentEvent eew){}
public void componentMoved(ComponentEvent er){}
public void componentResized(ComponentEvent ee){}
});
setBounds(390,200,600,450);
setLayout(null);
setUndecorated(true);
setResizable(false);
setVisible(true);
JLabel newprblb=new JLabel("Supplier Details");
newprblb.setFont(new Font("Times New Roman",1,40));
newprblb.setBounds(210,-20,350,110);
add(newprblb);
//new product logo
ImageIcon newplgimg = new ImageIcon("details product.png");
JLabel newplg=new JLabel(newplgimg);
newplg.setBounds(120,-10,100,100);
add(newplg);
JSeparator s1=new JSeparator();
s1.setBounds(1,90,1000,80);
s1.setBackground(new Color(255,200,100));
add(s1);
table.setBounds(5,95,590,300);
table.setFont(new Font("Times New Roman",1,18));
add(table);
ImageIcon closeimg = new ImageIcon("close Jframe.png");
JButton close = new JButton("Close",closeimg);
close.setBounds(250,400,100,30);
add(close);
close.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent ee)
{
setVisible(false);
}
});
ImageIcon newbuyerbackimg = new ImageIcon("all page background image.png");
JLabel newbbackimg = new JLabel(newbuyerbackimg);
newbbackimg.setBounds(0,0,600,450);
add(newbbackimg);
}
}
