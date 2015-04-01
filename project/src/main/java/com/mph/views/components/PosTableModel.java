package com.mph.views.components;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.mph.models.dtos.PosTableDataDto;



public class PosTableModel extends AbstractTableModel {
	List<PosTableDataDto> tableData = new ArrayList<PosTableDataDto>();
	
	public PosTableModel() {
		
	}
	
	public void setData(List<PosTableDataDto> data) {
		this.tableData = data;
		this.fireTableDataChanged();
	}
	
	public void addData(PosTableDataDto data) {
		tableData.add(data);
		this.fireTableDataChanged();
	}
	
	public void clearData() {
		tableData.clear();
		this.fireTableDataChanged();
	}

	public int getRowCount() {
		return tableData.size();
	}

	public int getColumnCount() {
		return 4;
	}
	

	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
			case 0:
				return tableData.get(rowIndex).getCol1();
			case 1:
				return tableData.get(rowIndex).getCol2();
			case 2:
				return tableData.get(rowIndex).getCol3();
			case 3:
				return tableData.get(rowIndex).getCol4();
		}
		return null;
	}

}
