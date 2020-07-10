package com.sms3;

import java.awt.BorderLayout; 
import java.awt.Frame; 
import java.awt.GridLayout; 
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 
 
import javax.swing.JButton; 
import javax.swing.JDialog; 
import javax.swing.JLabel; 
import javax.swing.JOptionPane; 
import javax.swing.JPanel; 
import javax.swing.JTextField; 
import javax.swing.table.AbstractTableModel; 
 
public class StuUpdateDialogg extends JDialog implements ActionListener{ 
  //=========���ؼ� 
  //......�������� 
  private JLabel idLab,nameLab,sexLab,ageLab,jgLab,deptLab; 
  //......�Ҳ���Ϣѡ����д�� 
  private JTextField idTxt,nameTxt,sexTxt,ageTxt,jgTxt,deptTxt; 
  //......��Ӻ�ȡ����ť 
  private JButton addBtn,cancelBtn; 
  //......���ֿؼ� 
  private JPanel left,center,bottom; 
   
  //���캯�� 
  public StuUpdateDialogg(Frame owner, String title, boolean modal, StuModell sm1, int rowNum)  
  { 
    //========��д���෽�� 
    super(owner, title, modal); 
    //========����ǩ�� 
    idLab = new JLabel("���: "); 
    nameLab = new JLabel("����: "); 
    sexLab = new JLabel("������: "); 
    ageLab = new JLabel("����: "); 
    jgLab = new JLabel("���: "); 
    deptLab = new JLabel("ʣ��: "); 
    //========�Ҳ���Ϣ��д�� 
    idTxt = new JTextField();   
    idTxt.setText((String)sm1.getValueAt(rowNum, 0)); 
    idTxt.setEditable(false); 
    nameTxt = new JTextField(); 
    nameTxt.setText((String)sm1.getValueAt(rowNum, 1)); 
    sexTxt = new JTextField(); 
    sexTxt.setText((String)sm1.getValueAt(rowNum, 2)); 
    ageTxt = new JTextField(); 
    ageTxt.setText((String)sm1.getValueAt(rowNum, 3)); 
    jgTxt = new JTextField(); 
    jgTxt.setText((String)sm1.getValueAt(rowNum, 4)); 
    deptTxt = new JTextField(); 
    deptTxt.setText((String)sm1.getValueAt(rowNum, 5)); 
    //========��Ӻ�ȡ����ť 
    addBtn = new JButton("�޸�"); 
    cancelBtn = new JButton("ȡ��"); 
    //......��Ӽ��� 
    addBtn.addActionListener(this); 
    addBtn.setActionCommand("update"); 
    cancelBtn.addActionListener(this); 
    cancelBtn.setActionCommand("cancel"); 
    //========�������� 
    //......��������� 
    left = new JPanel(); 
    left.setLayout(new GridLayout(6, 1)); 
    left.add(idLab); left.add(nameLab);  
    left.add(sexLab); left.add(ageLab);  
    left.add(jgLab); left.add(deptLab);  
    //......�����ұ��� 
    center = new JPanel(); 
    center.setLayout(new GridLayout(6, 1)); 
    center.add(idTxt); center.add(nameTxt); 
    center.add(sexTxt); center.add(ageTxt); 
    center.add(jgTxt); center.add(deptTxt); 
    //========�ײ���Ӻ�ȡ����ť 
    bottom = new JPanel(); 
    bottom.add(addBtn); 
    bottom.add(cancelBtn); 
    //========���岼�� 
    this.add(left,BorderLayout.WEST); 
    this.add(center,BorderLayout.CENTER); 
    this.add(bottom,BorderLayout.SOUTH); 
    //========���ô������� 
     
    this.setSize(300, 250); 
    this.setResizable(false); 
    this.setVisible(true); 
  } 
 
  @Override 
  public void actionPerformed(ActionEvent e) { 
    // TODO Auto-generated method stub 
    if(e.getActionCommand().equals("update")) { 
    /***********************�޸���Ϣ**************************/ 
      StuModell tmp = new StuModell(); 
      String sqll = "update stuu set stuName=?,stuSex=?,stuAge=?,stuJg=?,stuDept=? where stuId=?"; 
      String []paras = {nameTxt.getText(),sexTxt.getText(),ageTxt.getText(), 
              jgTxt.getText(),deptTxt.getText(),idTxt.getText()}; 
      if(!tmp.cudStuu(sqll, paras)) 
        JOptionPane.showMessageDialog(this, "�޸���Ϣʧ��"); 
      //========�رմ��� 
      this.dispose(); 
    } else if(e.getActionCommand().equals("cancel")) { 
      //========�رմ��� 
      this.dispose(); 
    } 
  } 
}
