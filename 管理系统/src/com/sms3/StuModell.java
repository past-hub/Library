package com.sms3;

import java.sql.ResultSet; 
import java.util.Vector; 
import javax.swing.table.AbstractTableModel; 
 
public class StuModell extends AbstractTableModel{ 
  private Vector columnNames; 
  private Vector rowDates; 
   
  // 
  public StuModell() 
  { 
    String sqll = "select * from stuu"; 
    String []paras = {}; 
     
  } 
   
  //========��ɾ��ѧ�� 
  public boolean cudStuu(String sqll, String []paras) 
  { 
    return new SqlHelper().cudExecute(sqll, paras); 
  } 
   
  //========��ѯѧ�� 
  public void queryStu(String sqll, String []paras) 
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
      ResultSet rs = sqlHelper.queryExecute(sqll, paras); 
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
