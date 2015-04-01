package com.mph.views.components;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.mph.models.dtos.impls.PosTableDataDtoImpl;

public class PosMainTableModel extends AbstractTableModel {
	List <PosTableDataDtoImpl> tableData = new ArrayList<PosTableDataDtoImpl>();
	public PosMainTableModel() {
		
	}
	
	public void setData(ArrayList <PosTableDataDtoImpl> data) {
		this.tableData = data;
		this.fireTableDataChanged();
	}
	
	public void addData(PosTableDataDtoImpl data) {
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
		return 3;
	}
	
	public boolean isCellEditable(int row, int col) {
		if (col == 2) {
			return true;
		}
		
		return false;
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return tableData.get(rowIndex).getCol1();
		case 1:
			return tableData.get(rowIndex).getCol2();
		case 2:
			return tableData.get(rowIndex).getCol3();
		}
		
		return null;
	}
}
