package com.mph.views.components;

import java.awt.Component;
import java.util.EventObject;
import java.util.List;

import javax.swing.AbstractCellEditor;
import javax.swing.JTable;
import javax.swing.event.CellEditorListener;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

public class PosTableCellRenderer extends AbstractCellEditor implements TableCellRenderer, TableCellEditor {
	private static final long serialVersionUID = 1L;
	private PosTableCellPanel renderer = new PosTableCellPanel();
	private PosTableCellPanel editor = new PosTableCellPanel();


	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column) {
		renderer.setValue(((String)value));
		return renderer;
	}


	public Component getTableCellEditorComponent(JTable table, Object value,
			boolean isSelected, int row, int column) {
		editor.setValue(((String)value));
		return editor;
	}


	public Object getCellEditorValue() {
		return editor.getValue();
	}

	@Override
	public boolean isCellEditable(EventObject anEvent) {
		return true;
	}

	@Override
	public boolean shouldSelectCell(EventObject anEvent) {
		return false;
	}

	@Override
	public boolean stopCellEditing() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void cancelCellEditing() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addCellEditorListener(CellEditorListener l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeCellEditorListener(CellEditorListener l) {
		// TODO Auto-generated method stub
		
	}
}
