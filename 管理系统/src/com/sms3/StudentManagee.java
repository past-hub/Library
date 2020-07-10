package com.sms3;

import java.awt.*; 
import javax.swing.*; 
import java.awt.event.*; 
 
@SuppressWarnings("serial")
public class StudentManagee extends JFrame implements ActionListener  
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
  private StuModell sm1 = null; 
   
  //���캯�� 
  public StudentManagee(Face face, String string, boolean b) 
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
    sm1 = new StuModell(); 
    String sqll = "select * from stuu"; 
    sm1.queryStu(sqll, null); 
    resultTb = new JTable(sm1); 
    jsp = new JScrollPane(resultTb); 
    //......�������岼�� 
    this.add(top,BorderLayout.NORTH); 
    this.add(jsp,BorderLayout.CENTER); 
    this.add(bottom,BorderLayout.SOUTH); 
    //========���ô������� 
    this.setSize(600, 500); 
    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    this.setTitle("���");
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
        String sqll = "select * from stuu where stuName=?"; 
        String []paras = {name}; 
        //......����ģ�� 
        jtableUpdate(sqll, paras); 
      } else { 
        //========����Ϊ��ʱ���������� 
        JOptionPane.showMessageDialog(this, "�������벻��Ϊ��"); 
      } 
    } else if(e.getActionCommand().equals("add")) { 
      /*********************���***********************/ 
      new StuAddDialogg(this, "�����Ϣ", true); 
      String sqll = "select * from stuu"; 
      jtableUpdate(sqll, null); 
    } else if(e.getActionCommand().equals("all")) { 
      /*********************ȫ����ʾ***********************/ 
      String sqll = "select * from stuu"; 
      jtableUpdate(sqll, null); 
    } else if(e.getActionCommand().equals("delete")) { 
      /*********************ɾ��***********************/ 
      //========��ȡѡ���к� 
      int rowNum = this.resultTb.getSelectedRow(); 
      if(rowNum == -1) { 
        JOptionPane.showMessageDialog(this, "��ѡ��һ��"); 
        return ; 
      } 
      //========��ȡѧ��ID�� 
      String stuId = (String)sm1.getValueAt(rowNum, 0); 
      //========ɾ��ѧ�� 
      String sqll = "delete from stuu where stuId=?"; 
      String []paras = {stuId}; 
      StuModell sm1 = new StuModell(); 
      sm1.cudStuu(sqll, paras); 
      //========����ģ�� 
      sqll= "select * from stuu"; 
      jtableUpdate(sqll, null); 
    } else if(e.getActionCommand().equals("update")) { 
      /*********************�޸�***********************/ 
      //========��ȡѡ���к� 
      int rowNum = this.resultTb.getSelectedRow(); 
      if(rowNum == -1) { 
        JOptionPane.showMessageDialog(this, "��ѡ��һ��"); 
        return ; 
      } 
      new StuUpdateDialogg(this, "�޸���Ϣ", true, sm1, rowNum); 
      String sqll = "select * from stuu"; 
      jtableUpdate(sqll, null); 
    } 
  } 
   
  //========����JTable������ 
  public void jtableUpdate(String sqll, String[] paras) 
  { 
    //......����ģ�� 
    sm1 = new StuModell(); 
    sm1.queryStu(sqll, paras); 
    //......������ʾ 
    resultTb.setModel(sm1);
    
  } 
 
}
