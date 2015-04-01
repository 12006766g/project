package com.mph.views.components;

import java.util.List;

import javax.swing.JTable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mph.factories.BundlesFactory;
import com.mph.models.dtos.BundlesDto;
import com.mph.models.dtos.PosTableDataDto;
import com.mph.models.dtos.impls.PosTableDataDtoImpl;
import com.mph.views.PosSystemAdminView;

public class PosTable extends JTable {
	private static final Logger logger = LoggerFactory.getLogger(PosSystemAdminView.class);
	private PosTableModel model;
	private BundlesDto bundlesDto;
	public PosTable(){
		super();
		init();
		initColumnModel();
	}
	private void init(){
		bundlesDto = BundlesFactory.getBundlesInstance();
		model = new PosTableModel();
		this.setModel(model);
	}
	private void initColumnModel(){
		String idColumn = bundlesDto.getTableColumnNameId();
		String nameColumn = bundlesDto.getTableColumnNameName();
		String priceColumn = bundlesDto.getTableColumnNamePrice();
		String typeColumn = bundlesDto.getTableColumnNameType();
		setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		getTableHeader().setReorderingAllowed(false);		
		getColumnModel().getColumn(PosTableDataDtoImpl.COL_1).setHeaderValue(idColumn);
		getColumnModel().getColumn(PosTableDataDtoImpl.COL_2).setHeaderValue(nameColumn);
		getColumnModel().getColumn(PosTableDataDtoImpl.COL_3).setHeaderValue(priceColumn);
		getColumnModel().getColumn(PosTableDataDtoImpl.COL_4).setHeaderValue(typeColumn);
		setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
	}
	public void setData(List<PosTableDataDto> data){
		try{
			this.clearSelection();
			model.setData(data);
			
//			this.revalidate();
			model.fireTableDataChanged();
//			this.repaint();
		} catch (Exception e){
			logger.error("PosTable.setDataColumn() - Exception:", e);
		}
	}

}
