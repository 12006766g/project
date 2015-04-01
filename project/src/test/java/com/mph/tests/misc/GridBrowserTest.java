package com.mph.tests.misc;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.EventObject;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;

public class GridBrowserTest extends JFrame {
	/*
	JPanel pnlContainer;
	JPanel pnlTop;
	JTable tblMain;
	GridBrowserTest gridBrowser = null;
	
	MainTableModel tableModel = new MainTableModel();
	
	public GridBrowserTest() {
		gridBrowser = this;
		initUI();
	}
	
	private void initUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800, 600);
		
		pnlTop = new JPanel();
		pnlTop.setSize(800, 150);
		pnlTop.setLayout(new BorderLayout());
		pnlTop.setPreferredSize(new Dimension(800, 150));
		pnlTop.add(new JLabel("Hi hi this is top panel"), BorderLayout.CENTER);
		pnlContainer = new JPanel();
		pnlContainer.setLayout(new BorderLayout());
		
		tblMain = new JTable() ;
//		{
//			public TableCellRenderer getCellRenderer(int row, int column) {
//		        if (column == TableData.BUTTON_COL) {
//		            return new ButtonRenderer();
//		        }
//
//		        return super.getCellRenderer(row, column);
//		    }
//		};
		tblMain.setModel(tableModel);

		tblMain.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		tblMain.getTableHeader().setReorderingAllowed(false);
		tblMain.getColumnModel().getColumn(TableData.BUTTON_COL).setCellEditor(new ButtonEditor());
		
		tblMain.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		tblMain.getColumnModel().getColumn(TableData.COL_1).setHeaderValue("Col 1");
		tblMain.getColumnModel().getColumn(TableData.COL_2).setHeaderValue("Col 2");
		tblMain.getColumnModel().getColumn(TableData.BUTTON_COL).setHeaderValue("Clear Data");
		tblMain.getColumnModel().getColumn(TableData.BUTTON_COL).setHeaderRenderer(new ButtonHeaderRenderer());
//		tblMain.getTableHeader().getColumnModel().getColumn(TableData.BUTTON_COL).setCellEditor(new ButtonHeaderEditor());
//		tblMain.getTableHeader().getColumnModel().getColumn(TableData.BUTTON_COL).setCellRenderer(new ButtonHeaderRenderer());
		
		setColumWidth();
		
		tblMain.setRowHeight(50);
		tblMain.getTableHeader().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int col = tblMain.getColumnModel().getColumnIndexAtX(e.getX());
				if (col == 2) {
					tableModel.clearData();
					setColumWidth();
				}
			}
		});
		
		JScrollPane sclPanel = new JScrollPane(tblMain);
		pnlContainer.add(sclPanel, BorderLayout.CENTER);

		this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().add(pnlTop, BorderLayout.NORTH);
		this.getContentPane().add(pnlContainer, BorderLayout.CENTER);
		
		for (int i=1; i<=20; i++) {
			TableData data = new TableData("Test " + i, "Test col " + i, "Button " + i);
			tableModel.addData(data);
		}
		
		setVisible(true);
	}
	
	private void setColumWidth() {
		tblMain.getColumnModel().getColumn(TableData.COL_1).setPreferredWidth(300);
		tblMain.getColumnModel().getColumn(TableData.COL_1).setWidth(300);
		tblMain.getColumnModel().getColumn(TableData.COL_2).setPreferredWidth(300);
		tblMain.getColumnModel().getColumn(TableData.COL_2).setWidth(300);
		tblMain.getColumnModel().getColumn(TableData.BUTTON_COL).setPreferredWidth(200);
		tblMain.getColumnModel().getColumn(TableData.BUTTON_COL).setWidth(200);
	}
	
	private class TableData {
		public static final int COL_1 = 0;
		public static final int COL_2 = 1;
		public static final int BUTTON_COL = 2;
		
		String col1;
		String col2;
		String col3;
		
		public TableData() {
			
		}

		public TableData(String col1, String col2, String col3) {
			super();
			this.col1 = col1;
			this.col2 = col2;
			this.col3 = col3;
		}

		public String getCol1() {
			return col1;
		}

		public void setCol1(String col1) {
			this.col1 = col1;
		}

		public String getCol2() {
			return col2;
		}

		public void setCol2(String col2) {
			this.col2 = col2;
		}

		public String getCol3() {
			return col3;
		}

		public void setCol3(String col3) {
			this.col3 = col3;
		}
	}
	private class MainTableModel extends AbstractTableModel {
		ArrayList <TableData> tableData = new ArrayList<TableData>();
		
		public MainTableModel() {
			
		}
		
		public void setData(ArrayList <TableData> data) {
			this.tableData = data;
			this.fireTableDataChanged();
		}
		
		public void addData(TableData data) {
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
				return tableData;
			}
			
			return null;
		}
	}
	
	private class ButtonRenderer extends JButton implements TableCellRenderer {
		
		public ButtonRenderer()  {
			setOpaque(true);
		}
		
		public Component getTableCellRendererComponent(JTable table,
				Object value, boolean isSelected, boolean hasFocus, int row,
				int column) {
			
			final TableData data = ((ArrayList<TableData>) value).get(row);
			JButton button = new JButton(data.getCol3());
			
			if (isSelected) {
				button.setBackground(table.getSelectionBackground());
				button.setForeground(table.getSelectionForeground());
			} else {
				button.setBackground(table.getBackground());
				button.setForeground(table.getForeground());
			}

			return button;
		}
	}

	
	private class ButtonEditor extends DefaultCellEditor {
		JButton button = new JButton();
		TableData data = null;
		
		public ButtonEditor()  {
			super(new JCheckBox());
			
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					TableData data = (TableData) getCellEditorValue();
					System.out.println("-- Data : " + data.getCol1() + ", " + data.getCol2());
					stopCellEditing();
				}
			});		
		}
		
		public Object getCellEditorValue() {
			return data;
		}

		public boolean isCellEditable(EventObject anEvent) {
			return true;
		}

		public Component getTableCellEditorComponent(JTable table,
				Object value, boolean isSelected, int row, int column) {
			// TODO Auto-generated method stub
			
			data = ((ArrayList<TableData>) value).get(row);
			button.setText(data.getCol3());
			
			if (isSelected) {
				button.setBackground(table.getSelectionBackground());
				button.setForeground(table.getSelectionForeground());
			} else {
				button.setBackground(table.getBackground());
				button.setForeground(table.getForeground());
			}
			
			return button;
		}
	}
	
	private class ButtonHeaderRenderer extends JButton implements TableCellRenderer {
		
		public ButtonHeaderRenderer()  {
			setOpaque(true);
		}
		
		public Component getTableCellRendererComponent(JTable table,
				Object value, boolean isSelected, boolean hasFocus, int row,
				int column) {
			
			JButton button = new JButton((String) value);
			
			if (isSelected) {
				button.setBackground(table.getSelectionBackground());
				button.setForeground(table.getSelectionForeground());
			} else {
				button.setBackground(table.getBackground());
				button.setForeground(table.getForeground());
			}

			return button;
		}
	}
	
	private class ButtonHeaderEditor extends DefaultCellEditor {
		JButton button = new JButton();
		
		public ButtonHeaderEditor()  {
			super(new JCheckBox());
			
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					stopCellEditing();
				}
			});		
		}
		
		public Object getCellEditorValue() {
			return null;
		}

		public boolean isCellEditable(EventObject anEvent) {
			return true;
		}

		public Component getTableCellEditorComponent(JTable table,
				Object value, boolean isSelected, int row, int column) {
			// TODO Auto-generated method stub
			
			button.setText((String) value);
			
			if (isSelected) {
				button.setBackground(table.getSelectionBackground());
				button.setForeground(table.getSelectionForeground());
			} else {
				button.setBackground(table.getBackground());
				button.setForeground(table.getForeground());
			}
			
			return button;
		}
	}
	public static void main(String [] argc) {
		GridBrowserTest gridBrowser = new GridBrowserTest();
	}
	*/
}
