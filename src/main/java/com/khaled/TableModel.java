package com.khaled;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public class TableModel extends AbstractTableModel{
	 private List<Food> rowData; 
	 private final String[] columnNames = new String[]  {
			 "mealType","Food Type","FoodServings","Calories", "Protein","Carbohydrate","Fats","Cholesterol","Sodium","Dietary Fiber","Sugars","Vitamin A","Vitamin C","Calcium","Iron"
	};
	 public TableModel(List<Food> data)
	 {
	 this.rowData = data;
	 }
	 
	 public boolean isCellEditable(int row,int cols)
	 {
		 return true;
	 }
	 public List<Food> getRowData() {
		return rowData;
	}
	 public void deleteData() {
		    rowData.clear();
		    fireTableChanged(null);
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
	else if(7 == columnIndex) {
		return row.getFood_cholesterol();
	}
	else if(8 == columnIndex) {
		return row.getFood_sodium();
	}
	else if(9 == columnIndex) {
		return row.getFood_dietary_fiber();
	}
	else if(10 == columnIndex) {
		return row.getFood_sugars();
	}
	else if(11 == columnIndex) {
		return row.getFood_vitamin_a();
	}
	else if(12 == columnIndex) {
		return row.getFood_vitamin_c();
	}
	else if(13 == columnIndex) {
		return row.getFood_calcium();
	}
	else if(14 == columnIndex) {
		return row.getFood_iron();
	}
	return null;
    }

}
