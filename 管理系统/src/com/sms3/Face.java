package com.sms3;


import javax.swing.*;



import java.awt.*;  

import java.awt.event.*;

@SuppressWarnings("serial")
public class Face extends JFrame implements ActionListener {
	
	
	
	
	private JButton bt=null;
	
	private JButton bt1=null;
	
	private JPanel jp=null;
	
	private JLabel jp1=null;
	
	public Face(){
		
		setBounds(100, 100, 350, 400);
		setLayout(new BorderLayout());
		
	
	bt=new JButton("库一");
	
	bt1=new JButton("库二");
	
	bt.addActionListener(this);
	
	bt.setActionCommand("biao");
	
	bt1.addActionListener(this);
	
	bt1.setActionCommand("biao2");
	jp=new JPanel();
	jp.add(bt);
	jp.add(bt1);
	this.add(jp,BorderLayout.NORTH);
	
	
	jp1=new JLabel(new ImageIcon("2e0f5a0fd9f9d72afb8f5129d62a2834359bbbda.png"));
	this.add(jp1,BorderLayout.SOUTH);
	this.setSize(400, 300);
	
	
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setVisible(true);
	this.setResizable(false);
}
	
	
	@Override
	public void actionPerformed(ActionEvent e){
		
		// TODO Auto-generated method stub 
	    if(e.getActionCommand().equals("biao")) {
	    	
	    	new StudentManage(this,"库一",true);
	    	
	    	
	    	
	    	
		
		
		
		
		
	}else if(e.getActionCommand().equals("biao2")) {
    	
    	new StudentManagee(this,"库二",true);
    	
	} 
	    
	    
	
}
	}

	 
    
	
    
    	
    
    
    
    
