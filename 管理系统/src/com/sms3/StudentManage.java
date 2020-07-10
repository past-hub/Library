package com.sms3; 
 

import java.awt.*; 
import javax.swing.*; 
import java.awt.event.*; 
 
public class StudentManage extends JFrame implements ActionListener  
{ 
  
  
 
  //========���ؼ� 
  private JLabel queryLab = null; 
  private JTextField queryTxt = null; 
  private JButton queryBtn = null; 
  private JButton allBtn = null; 
  private JTable resultTb = null; 
  private JScrollPane jsp = null; 
  private JButton addBtn = null; 
  private JButton deleteBtn = null; 
  private JButton updateBtn = null; 
  private JPanel top = null; 
  private JPanel bottom = null; 
  //======== 
  private StuModel sm = null; 
   
  //���캯�� 
  public StudentManage(Face face, String string, boolean b) 
  { 
    /***************************��ʼ�����ؼ�***********************/ 
    //========��ѯ�� 
    queryLab = new JLabel("����������:"); 
    queryTxt = new JTextField(10); 
    queryBtn = new JButton("��ѯ"); 
    allBtn = new JButton("ȫ��"); 
    //......��Ӳ�ѯ������ 
    queryBtn.addActionListener(this); 
    queryBtn.setActionCommand("query"); 
    allBtn.addActionListener(this); 
    allBtn.setActionCommand("all"); 
    //========��ɾ���� 
    addBtn = new JButton("���"); 
    deleteBtn = new JButton("ɾ��"); 
    updateBtn = new JButton("�޸�"); 
    //......�����ɾ�������� 
    addBtn.addActionListener(this); 
    addBtn.setActionCommand("add"); 
    deleteBtn.addActionListener(this); 
    deleteBtn.setActionCommand("delete"); 
    updateBtn.addActionListener(this); 
    updateBtn.setActionCommand("update"); 
    //========�����������岼�� 
    //......�����ѯ�� 
    top = new JPanel(); 
    top.add(queryLab); 
    top.add(queryTxt); 
    top.add(queryBtn); 
    top.add(allBtn); 
    //......�ײ���ɾ���� 
    bottom = new JPanel(); 
    bottom.add(addBtn); 
    bottom.add(deleteBtn); 
    bottom.add(updateBtn); 
    //......�м����ʾ�� 
    sm = new StuModel(); 
    String sql = "select * from stu1"; 
    sm.queryStu(sql, null); 
    resultTb = new JTable(sm); 
    jsp = new JScrollPane(resultTb); 
    //......�������岼�� 
    this.add(top,BorderLayout.NORTH); 
    this.add(jsp,BorderLayout.CENTER); 
    this.add(bottom,BorderLayout.SOUTH); 
    //========���ô������� 
    this.setSize(600, 500); 
    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    this.setTitle("��һ");
    this.setVisible(true); 
    this.setResizable(false);
    
  } 
   
  //���� 
  @Override 
  public void actionPerformed(ActionEvent e) 
  { 
    // TODO Auto-generated method stub 
    if(e.getActionCommand().equals("query")) { 
      /*********************��ѯ***********************/ 
      //========��ȡ����ѧ�������� 
      String name = queryTxt.getText().trim(); 
      if(name.length() != 0) { 
        //========����������Чʱ��ִ�в�ѯ 
        //......������� 
        String sql = "select * from stu1 where stuName=?"; 
        String []paras = {name}; 
        //......����ģ�� 
        jtableUpdate(sql, paras); 
      } else { 
        //========����Ϊ��ʱ���������� 
        JOptionPane.showMessageDialog(this, "�������벻��Ϊ��"); 
      } 
    } else if(e.getActionCommand().equals("add")) { 
      /*********************���***********************/ 
      new StuAddDialog(this, "�����Ϣ", true); 
      String sql = "select * from stu1"; 
      jtableUpdate(sql, null); 
    } else if(e.getActionCommand().equals("all")) { 
      /*********************ȫ����ʾ***********************/ 
      String sql = "select * from stu1"; 
      jtableUpdate(sql, null); 
    } else if(e.getActionCommand().equals("delete")) { 
      /*********************ɾ��***********************/ 
      //========��ȡѡ���к� 
      int rowNum = this.resultTb.getSelectedRow(); 
      if(rowNum == -1) { 
        JOptionPane.showMessageDialog(this, "��ѡ��һ��"); 
        return ; 
      } 
      //========��ȡѧ��ID�� 
      String stuId = (String)sm.getValueAt(rowNum, 0); 
      //========ɾ��ѧ�� 
      String sql = "delete from stu1 where stuId=?"; 
      String []paras = {stuId}; 
      StuModel tmp = new StuModel(); 
      tmp.cudStu(sql, paras); 
      //========����ģ�� 
      sql = "select * from stu1"; 
      jtableUpdate(sql, null); 
    } else if(e.getActionCommand().equals("update")) { 
      /*********************�޸�***********************/ 
      //========��ȡѡ���к� 
      int rowNum = this.resultTb.getSelectedRow(); 
      if(rowNum == -1) { 
        JOptionPane.showMessageDialog(this, "��ѡ��һ��"); 
        return ; 
      } 
      new StuUpdateDialog(this, "�޸���Ϣ", true, sm, rowNum); 
      String sql = "select * from stu1"; 
      jtableUpdate(sql, null); 
    } 
  } 
   
  //========����JTable������ 
  public void jtableUpdate(String sql, String[] paras) 
  { 
    //......����ģ�� 
    sm = new StuModel(); 
    sm.queryStu(sql, paras); 
    //......������ʾ 
    resultTb.setModel(sm);
    
  } 
 
} 

