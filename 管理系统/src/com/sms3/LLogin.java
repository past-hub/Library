package com.sms3;

import java.sql.*;  

import javax.swing.*;  

import java.awt.*;  

import java.awt.event.*;  

import java.awt.Color; 

 

public class LLogin {

	 public static void main(String[] args) {  

	        new loginFrame();   

	    }  	  

	} 

	class loginFrame extends JFrame implements ActionListener{  

	    Box box1,box2,box3,baseBox;  

	    JLabel userName,userPwd,tubiao;  

	    JTextField nameField;  

	    JPasswordField pwdField;  

	    JButton button,button1;  

	    JTabbedPane choose;  

	    JPanel panel1,panel2;  

	    loginFrame(){  

	        tubiao=new JLabel(new ImageIcon("2e0f5a0fd9f9d72afb8f5129d62a2834359bbbda.png"));  //ͼƬ��ԭ�л�����Ҫ������С
	        
	    	        
	        add(tubiao,BorderLayout.NORTH  );  

	        userName=new JLabel("�˺�",JLabel.CENTER);  

	        userPwd=new JLabel("����",JLabel.CENTER);  

	        nameField=new JTextField(4);  

	        pwdField=new JPasswordField(4);  

	        panel1=new JPanel();  

	        panel2=new JPanel();  

	        choose=new JTabbedPane();  

	        choose.add("��¼����",panel1);  

	        panel1.setLayout(new GridLayout(1,2));  

	        panel1.add(userName);panel1.add(nameField);  

	        panel1.add(userPwd);panel1.add(pwdField);  

	        add(choose,BorderLayout.CENTER);  

	        button=new JButton("��½");
	        
	        button1=new JButton("ȡ��");
	        
	        panel2.add(button);
	        
	        panel2.add(button1);

	        add(panel2,BorderLayout.SOUTH);
	        
	        

	        button.addActionListener(this);
	        button.setActionCommand("denglu");
	        button1.addActionListener(this);
	        button1.setActionCommand("quxiao");
	        
	        

	        //Сͼ��

	        ImageIcon tubiao=new ImageIcon("2e0f5a0fd9f9d72afb8f5129d62a2834359bbbda.png"); 

	        setIconImage(tubiao.getImage());  

	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  

	        setVisible(true);
	        this.setResizable(false);
	        
	        

	        setSize(400,348);  

	        setTitle("������ϵͳ");  

	        validate();  

	    }  

 

 

	    public void actionPerformed(ActionEvent e){
	    	
	    	if(e.getActionCommand().equals("denglu")) {

	        String name,pwd;  

	        name=nameField.getText();  

	        pwd=pwdField.getText();  

	        try{  

	          Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); //�������ݿ����� 

	           

	        }  

	        catch(ClassNotFoundException ex){  

	        System.out.println(ex);  

	        }  

	        try{  

	            Connection con;  

	            Statement sql;  

	            ResultSet rs;  

	            String url,userName,userPwd;  

	             // �������ݿ�����

	            url="jdbc:sqlserver://localhost:1433;DatabaseName=studentMan";

	        

	            userName="sa";  

	            userPwd="123";  

	            con=DriverManager.getConnection(url,userName,userPwd);  

	            sql=con.createStatement();  

	            rs=sql.executeQuery("select * from login where name ='"+name+"' and pwd='"+pwd+"'");//��Ӧ�Լ����ݿ⽨�ı���д  

	            int q=0;  

	            while(rs.next()){  

	                q++;  

	            }  

	            if(q>0){  

	                JOptionPane.showMessageDialog(this, "��½�ɹ���","��Ϣ�Ի���",JOptionPane.WARNING_MESSAGE);  

	                this.dispose();  

	                new Face();    

	                  

	            }  

	            else  

	                JOptionPane.showMessageDialog(this, "�˺Ż����������!","��Ϣ�Ի���",JOptionPane.WARNING_MESSAGE);  

	        }  

	        catch(SQLException exp){  

	            System.out.println(exp);  

	        }
		    	
		 }else if(e.getActionCommand().equals("quxiao")) {
	        	
	        	this.dispose();
	        
	        

	        

	    }  

}}
