package com.khaled;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public class TableModel extends AbstractTableModel{
	 private List<Food> rowData; 
	 private final String[] columnNames = new String[]  {
			 "mealType","Food Type","FoodServings","Calories", "Protein","Carbohydrate","Fats"
	};
	 public TableModel(List<Food> data)
	 {
	 this.rowData = data;
	 }
	 public List<Food> getRowData() {
		return rowData;
	}
	public void setRowData(List<Food> list) {
		this.rowData = list;
	}
	public void addRow(Food food)
    {
		this.rowData.add(food);
        fireTableRowsInserted(this.rowData.size() - 1, this.rowData.size() - 1);
   }
	
	 public void deleteRow(int rowNumber) {
		 this.rowData.remove(rowNumber);
		 fireTableRowsDeleted(rowNumber, rowNumber);
  }
	@Override
	public String getColumnName(int column)
	{
	     return columnNames[column];
	}

	@Override
	public int getColumnCount()
	{
	    return columnNames.length;
	}
	
	@Override
	public int getRowCount()
	{
		return rowData.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex)
    {
	Food row = rowData.get(rowIndex);
	if(0 == columnIndex) {
	    return row.getMealType();
	   }
	else if(1 == columnIndex) {
	    return row.getFood_type();
	   }
	else if(2 == columnIndex) {
	    return row.getFood_servings();
	   }
	 else if(3 == columnIndex) {
	    return row.getFood_calories();
	}
	 else if(4 == columnIndex) {
		 return row.getFood_protein();
	}
	else if(5 == columnIndex) {
		return row.getFood_carbohydrate();
	}
	else if(6 == columnIndex) {
		return row.getFood_fat();
	}
	return null;
    }

}
