package data;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
public class Signup extends JFrame
{
public Signup()
{
	//JFrame newbFrame=new JFrame();
		setBounds(390,200,600,450);
		setLayout(null);
		setUndecorated(true);
		setResizable(false);
		setVisible(true);
		//new buyer label
		ImageIcon newblimg=new ImageIcon("pass.gif");
		JLabel newblb=new JLabel(newblimg);
		newblb.setBounds(210,-40,165,165);
		add(newblb);
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
		JLabel buyernamel = new JLabel("Username");
		JLabel buyercontactl = new JLabel("Name");
		JLabel buyeremaill = new JLabel("Your Question");
		JLabel buyeraddressl = new JLabel("Answer");
		JLabel buyergenderl = new JLabel("Password");
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
		JTextField genderstr = new JTextField(200);

		//textfield fonts
		genderstr.setFont(new Font("Times New Roman",1,18));
		buyernamet.setFont(new Font("Times New Roman",1,18));
		buyercontactt.setFont(new Font("Times New Roman",1,18));
		buyeremailt.setFont(new Font("Times New Roman",1,18));
		buyeraddresst.setFont(new Font("Times New Roman",1,18));
		//adding labels on frame
		buyernamel.setBounds(100,90,80,50);
		add(buyernamel);
		buyercontactl.setBounds(100,140,100,50);
		add(buyercontactl);
		buyeremaill.setBounds(50,190,200,50);
		add(buyeremaill);
		buyeraddressl.setBounds(100,240,100,50);
		add(buyeraddressl);
		buyergenderl.setBounds(100,290,80,50);
		add(buyergenderl);
		//adding textfields on frame
		buyernamet.setBounds(210,100,300,30);
		add(buyernamet);
		buyercontactt.setBounds(210,150,300,30);
		add(buyercontactt);
		genderstr.setBounds(210,200,300,30);
		add(genderstr);
		buyeraddresst.setBounds(210,250,300,30);
		add(buyeraddresst);
		buyeremailt.setBounds(210,300,300,30);
		add(buyeremailt);
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

		//Retrive button
		ImageIcon buyersaveimg = new ImageIcon("Save.png");
		JButton buyersavebtn = new JButton("Retrive",buyersaveimg);
		buyersavebtn.setFont(new Font("Times New Roman",1,15));
		buyersavebtn.setBounds(100,380,125,30);
		add(buyersavebtn);
		buyersavebtn.addActionListener(new ActionListener()
		{
		public void actionPerformed(ActionEvent bre)
		{
		if(buyeraddresst.equals(""))
		{
		JOptionPane.showMessageDialog(null,"Enter Answer","Message",JOptionPane.INFORMATION_MESSAGE);
		}
		else
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
			st=conn.prepareStatement("select * from account where sec_ans=?");
			st.setString(1,buyeraddresst.getText());
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
			     buyeremailt.setText(rs.getString("password"));
			}

			JOptionPane.showMessageDialog(null,"get Successfully ","Message",JOptionPane.INFORMATION_MESSAGE);
			}
			catch(Exception e)
			{
			System.out.println(e);
			JOptionPane.showMessageDialog(null,"Username does not exist","Message",JOptionPane.INFORMATION_MESSAGE);
		}
		}
		}
		});

		//Search button

		ImageIcon buyerresetimg = new ImageIcon("Reset.png");
		JButton buyerresetbtn = new JButton("Search",buyerresetimg);
		buyerresetbtn.setFont(new Font("Times New Roman",1,15));
		buyerresetbtn.setBounds(250,380,125,30);
		add(buyerresetbtn);
		buyerresetbtn.addActionListener(new ActionListener()
		{
		public void actionPerformed(ActionEvent bre)
		{
		String bName = buyernamet.getText();
		if(bName.equals(""))
		{
		JOptionPane.showMessageDialog(null,"Enter Username","Message",JOptionPane.INFORMATION_MESSAGE);
		}
		else
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
		st=conn.prepareStatement("select * from account where username=?");
		st.setString(1,buyernamet.getText());
		ResultSet rs = st.executeQuery();
		while (rs.next()) {
		       buyercontactt.setText(rs.getString("name"));
		       genderstr.setText(rs.getString("sec_q"));
		}

		JOptionPane.showMessageDialog(null,"get Successfully ","Message",JOptionPane.INFORMATION_MESSAGE);
		}
		catch(Exception e)
		{
		System.out.println(e);
		JOptionPane.showMessageDialog(null,"Username does not exist","Message",JOptionPane.INFORMATION_MESSAGE);
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