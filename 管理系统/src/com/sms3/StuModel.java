package com.sms3; 
 
import java.sql.ResultSet; 
import java.util.Vector; 
import javax.swing.table.AbstractTableModel; 
 
public class StuModel extends AbstractTableModel{ 
  private Vector columnNames; 
  private Vector rowDates; 
   
  // 
  public StuModel() 
  { 
    String sql = "select * from stu1"; 
    String []paras = {}; 
     
  } 
   
  //========��ɾ��ѧ�� 
  public boolean cudStu(String sql, String []paras) 
  { 
    return new SqlHelper().cudExecute(sql, paras); 
  } 
   
  //========��ѯѧ�� 
  public void queryStu(String sql, String []paras) 
  { 
    SqlHelper sqlHelper = null; 
    //========��ʼ��JTable��Ϣ 
    columnNames = new Vector(); 
    rowDates = new Vector(); 
    columnNames.add("���"); columnNames.add("����"); 
    columnNames.add("������"); columnNames.add("����"); 
    columnNames.add("���"); columnNames.add("ʣ��"); 
     
    try { 
      sqlHelper = new SqlHelper(); 
      ResultSet rs = sqlHelper.queryExecute(sql, paras); 
      while(rs.next()) { 
        Vector row = new Vector(); 
        row.add(rs.getString(1)); 
        row.add(rs.getString(2)); 
        row.add(rs.getString(3)); 
        row.add(rs.getString(4)); 
        row.add(rs.getString(5)); 
        row.add(rs.getString(6)); 
        rowDates.add(row); 
      } 
    } catch (Exception e) { 
      // TODO: handle exception 
    } finally { 
      sqlHelper.close(); 
    } 
     
  } 
 
  @Override 
  public int getColumnCount() { 
    // TODO Auto-generated method stub 
    return this.columnNames.size(); 
  } 
 
  @Override 
  public int getRowCount() { 
    // TODO Auto-generated method stub 
    return this.rowDates.size(); 
  } 
 
  @Override 
  public Object getValueAt(int row, int col) { 
    // TODO Auto-generated method stub 
    if(!rowDates.isEmpty()) 
      return ((Vector)this.rowDates.get(row)).get(col); 
    else 
      return null; 
  } 
 
   
  @Override 
  public String getColumnName(int column) { 
    // TODO Auto-generated method stub 
    return (String)this.columnNames.get(column); 
  } 
 
   
} 

