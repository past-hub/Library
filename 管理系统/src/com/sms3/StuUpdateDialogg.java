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
  //=========面板控件 
  //......左侧标题栏 
  private JLabel idLab,nameLab,sexLab,ageLab,jgLab,deptLab; 
  //......右侧信息选择填写栏 
  private JTextField idTxt,nameTxt,sexTxt,ageTxt,jgTxt,deptTxt; 
  //......添加和取消按钮 
  private JButton addBtn,cancelBtn; 
  //......布局控件 
  private JPanel left,center,bottom; 
   
  //构造函数 
  public StuUpdateDialogg(Frame owner, String title, boolean modal, StuModell sm1, int rowNum)  
  { 
    //========重写父类方法 
    super(owner, title, modal); 
    //========左侧标签栏 
    idLab = new JLabel("书号: "); 
    nameLab = new JLabel("书名: "); 
    sexLab = new JLabel("出版社: "); 
    ageLab = new JLabel("作者: "); 
    jgLab = new JLabel("库存: "); 
    deptLab = new JLabel("剩余: "); 
    //========右侧信息填写栏 
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
    //========添加和取消按钮 
    addBtn = new JButton("修改"); 
    cancelBtn = new JButton("取消"); 
    //......添加监听 
    addBtn.addActionListener(this); 
    addBtn.setActionCommand("update"); 
    cancelBtn.addActionListener(this); 
    cancelBtn.setActionCommand("cancel"); 
    //========创建布局 
    //......创建左边栏 
    left = new JPanel(); 
    left.setLayout(new GridLayout(6, 1)); 
    left.add(idLab); left.add(nameLab);  
    left.add(sexLab); left.add(ageLab);  
    left.add(jgLab); left.add(deptLab);  
    //......创建右边栏 
    center = new JPanel(); 
    center.setLayout(new GridLayout(6, 1)); 
    center.add(idTxt); center.add(nameTxt); 
    center.add(sexTxt); center.add(ageTxt); 
    center.add(jgTxt); center.add(deptTxt); 
    //========底层添加和取消按钮 
    bottom = new JPanel(); 
    bottom.add(addBtn); 
    bottom.add(cancelBtn); 
    //========整体布局 
    this.add(left,BorderLayout.WEST); 
    this.add(center,BorderLayout.CENTER); 
    this.add(bottom,BorderLayout.SOUTH); 
    //========设置窗口属性 
     
    this.setSize(300, 250); 
    this.setResizable(false); 
    this.setVisible(true); 
  } 
 
  @Override 
  public void actionPerformed(ActionEvent e) { 
    // TODO Auto-generated method stub 
    if(e.getActionCommand().equals("update")) { 
    /***********************修改信息**************************/ 
      StuModell tmp = new StuModell(); 
      String sqll = "update stuu set stuName=?,stuSex=?,stuAge=?,stuJg=?,stuDept=? where stuId=?"; 
      String []paras = {nameTxt.getText(),sexTxt.getText(),ageTxt.getText(), 
              jgTxt.getText(),deptTxt.getText(),idTxt.getText()}; 
      if(!tmp.cudStuu(sqll, paras)) 
        JOptionPane.showMessageDialog(this, "修改信息失败"); 
      //========关闭窗口 
      this.dispose(); 
    } else if(e.getActionCommand().equals("cancel")) { 
      //========关闭窗口 
      this.dispose(); 
    } 
  } 
}
