package com.sms3; 
 

import java.awt.*; 
import javax.swing.*; 
import java.awt.event.*; 
 
public class StudentManage extends JFrame implements ActionListener  
{ 
  
  
 
  //========面板控件 
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
   
  //构造函数 
  public StudentManage(Face face, String string, boolean b) 
  { 
    /***************************初始化面板控件***********************/ 
    //========查询栏 
    queryLab = new JLabel("请输入书名:"); 
    queryTxt = new JTextField(10); 
    queryBtn = new JButton("查询"); 
    allBtn = new JButton("全部"); 
    //......添加查询栏监听 
    queryBtn.addActionListener(this); 
    queryBtn.setActionCommand("query"); 
    allBtn.addActionListener(this); 
    allBtn.setActionCommand("all"); 
    //========增删改栏 
    addBtn = new JButton("添加"); 
    deleteBtn = new JButton("删除"); 
    updateBtn = new JButton("修改"); 
    //......添加增删改栏监听 
    addBtn.addActionListener(this); 
    addBtn.setActionCommand("add"); 
    deleteBtn.addActionListener(this); 
    deleteBtn.setActionCommand("delete"); 
    updateBtn.addActionListener(this); 
    updateBtn.setActionCommand("update"); 
    //========创建窗口整体布局 
    //......顶层查询栏 
    top = new JPanel(); 
    top.add(queryLab); 
    top.add(queryTxt); 
    top.add(queryBtn); 
    top.add(allBtn); 
    //......底层增删改栏 
    bottom = new JPanel(); 
    bottom.add(addBtn); 
    bottom.add(deleteBtn); 
    bottom.add(updateBtn); 
    //......中间层显示栏 
    sm = new StuModel(); 
    String sql = "select * from stu1"; 
    sm.queryStu(sql, null); 
    resultTb = new JTable(sm); 
    jsp = new JScrollPane(resultTb); 
    //......构建整体布局 
    this.add(top,BorderLayout.NORTH); 
    this.add(jsp,BorderLayout.CENTER); 
    this.add(bottom,BorderLayout.SOUTH); 
    //========设置窗口属性 
    this.setSize(600, 500); 
    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    this.setTitle("库一");
    this.setVisible(true); 
    this.setResizable(false);
    
  } 
   
  //监听 
  @Override 
  public void actionPerformed(ActionEvent e) 
  { 
    // TODO Auto-generated method stub 
    if(e.getActionCommand().equals("query")) { 
      /*********************查询***********************/ 
      //========获取输入学生的姓名 
      String name = queryTxt.getText().trim(); 
      if(name.length() != 0) { 
        //========姓名输入有效时，执行查询 
        //......定义参数 
        String sql = "select * from stu1 where stuName=?"; 
        String []paras = {name}; 
        //......更新模型 
        jtableUpdate(sql, paras); 
      } else { 
        //========姓名为空时，设置提醒 
        JOptionPane.showMessageDialog(this, "书名输入不能为空"); 
      } 
    } else if(e.getActionCommand().equals("add")) { 
      /*********************添加***********************/ 
      new StuAddDialog(this, "添加信息", true); 
      String sql = "select * from stu1"; 
      jtableUpdate(sql, null); 
    } else if(e.getActionCommand().equals("all")) { 
      /*********************全部显示***********************/ 
      String sql = "select * from stu1"; 
      jtableUpdate(sql, null); 
    } else if(e.getActionCommand().equals("delete")) { 
      /*********************删除***********************/ 
      //========获取选择行号 
      int rowNum = this.resultTb.getSelectedRow(); 
      if(rowNum == -1) { 
        JOptionPane.showMessageDialog(this, "请选择一行"); 
        return ; 
      } 
      //========获取学生ID号 
      String stuId = (String)sm.getValueAt(rowNum, 0); 
      //========删除学生 
      String sql = "delete from stu1 where stuId=?"; 
      String []paras = {stuId}; 
      StuModel tmp = new StuModel(); 
      tmp.cudStu(sql, paras); 
      //========更新模型 
      sql = "select * from stu1"; 
      jtableUpdate(sql, null); 
    } else if(e.getActionCommand().equals("update")) { 
      /*********************修改***********************/ 
      //========获取选择行号 
      int rowNum = this.resultTb.getSelectedRow(); 
      if(rowNum == -1) { 
        JOptionPane.showMessageDialog(this, "请选择一行"); 
        return ; 
      } 
      new StuUpdateDialog(this, "修改信息", true, sm, rowNum); 
      String sql = "select * from stu1"; 
      jtableUpdate(sql, null); 
    } 
  } 
   
  //========更新JTable内数据 
  public void jtableUpdate(String sql, String[] paras) 
  { 
    //......创建模型 
    sm = new StuModel(); 
    sm.queryStu(sql, paras); 
    //......更新显示 
    resultTb.setModel(sm);
    
  } 
 
} 

