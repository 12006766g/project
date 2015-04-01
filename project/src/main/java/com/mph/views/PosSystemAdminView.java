package com.mph.views;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mph.criteria.IngredientCriteria;
import com.mph.factories.BundlesFactory;
import com.mph.helpers.PosSystemAdminViewHelper;
import com.mph.models.dtos.BundlesDto;
import com.mph.models.dtos.PosTableDataDto;
import com.mph.models.eos.DecoratorEo;
import com.mph.models.eos.FlavorEo;
import com.mph.models.eos.IngredientEo;
import com.mph.models.eos.impls.DecoratorEoImpl;
import com.mph.services.InventoryMasterMgr;
import com.mph.services.impls.InventoryMasterMgrImpl;
import com.mph.systems.utils.SystemUtils;
import com.mph.views.components.PosFrame;
import com.mph.views.components.PosSysAdmFormPanel;
import com.mph.views.components.PosTable;
import com.mph.views.listeners.PosIngredientRowListener;
import com.mph.views.listeners.PosSystemBack2MainScreenButtonListener;

public class PosSystemAdminView {
	private static final Logger logger = LoggerFactory.getLogger(PosSystemAdminView.class);
	
	private PosMainView posMainView;
	
	private JFrame posFrame;
	private JPanel posContentPanel;
	private PosTable posFlavorTable;
	private PosTable posDecoratorTable;
	private JScrollPane posFlavorScrollPane;
	private JScrollPane posDecoratorScrollPane;
	private JPanel posInnerLeftPanel;
	private JPanel posInnerRightPanel;
	private JPanel posBack2MainScreenPanel;
	private PosSysAdmFormPanel formPanel;

	
	private PosSystemAdminViewHelper posSystemAdminViewHelper;
	private InventoryMasterMgr inventoryMasterMgr;
	private List<DecoratorEo> decoratorList;
	private List<FlavorEo> flavorList;
	private Dimension desktopDimension;
	private int frameWidth;
	private int frameHeight;
	private BundlesDto bundlesDto;
	private IngredientEo ingredientEoCurrentOperation;
	
	
	public IngredientEo getIngredientEoCurrentOperation() {
		return ingredientEoCurrentOperation;
	}
	public void setIngredientEoCurrentOperation(
			IngredientEo ingredientEoCurrentOperation) {
		this.ingredientEoCurrentOperation = ingredientEoCurrentOperation;
	}
	public PosSystemAdminView(PosMainView posMainView){
		this.posMainView = posMainView;
		init();
		initUi();
		bindComponents();
	}
	public PosSystemAdminView(){
		init();
		initUi();
		bindComponents();
	}
	public void unloadComponents(){
		if (posBack2MainScreenPanel != null){
			posBack2MainScreenPanel = null;
		}
		
		if (posFlavorTable != null){
			posFlavorTable = null;
		}
		if (posDecoratorTable != null){
			posDecoratorTable = null;
		}
		if (formPanel != null){
			formPanel = null;
		}
		if (posInnerLeftPanel != null){
			posInnerLeftPanel = null;
		}
		if (posInnerRightPanel != null){
			posInnerRightPanel = null;
		}
		if (posContentPanel != null){
			posContentPanel = null;
		}
		if (posFrame != null){
			posFrame.setVisible(false);
			posFrame = null;
		}
	}
	private void bindComponents(){		
		
		posInnerLeftPanel.add(posDecoratorScrollPane);
		posInnerLeftPanel.add(formPanel);
		posContentPanel.add(posInnerLeftPanel);

		posInnerRightPanel.add(posFlavorScrollPane);
		posInnerRightPanel.add(posBack2MainScreenPanel);
		posContentPanel.add(posInnerRightPanel);
		
		posFrame.add(posContentPanel);
		posFrame.setVisible(true);	
	}
	
	private void init(){
		bundlesDto = BundlesFactory.getBundlesInstance();
		inventoryMasterMgr = new InventoryMasterMgrImpl();
		IngredientCriteria decoratorCriteria = new IngredientCriteria();
		decoratorList = inventoryMasterMgr.findDecoratorList(decoratorCriteria);
		posSystemAdminViewHelper = new PosSystemAdminViewHelper();
		IngredientCriteria flavorCriteria = new IngredientCriteria();
		flavorList = inventoryMasterMgr.findFlavorList(flavorCriteria);
		
		ingredientEoCurrentOperation = new DecoratorEoImpl();
		
	}
	private void initUi(){
		desktopDimension = SystemUtils.getScreenSize();
		frameWidth = (int) (desktopDimension.getWidth() * 0.8);
		frameHeight = (int) (desktopDimension.getHeight() * 0.8);
		initBack2MainScreenPanel();
		initFormPanel();
		initInnerLeftPanel();
		initInnerRightPanel();
		initDecoratorTableAndScrollPane();
		initFlavorTableAndScrollPane();
		initPosContentPanel();
		initPosFrame();

	}
	private void initBack2MainScreenPanel(){
		FlowLayout layout = new FlowLayout();
		posBack2MainScreenPanel = new JPanel();
		posBack2MainScreenPanel.setLayout(layout);
		JButton jBackToMain = new JButton(bundlesDto.getSysAdmGoBackToMainScreenButton());
		PosSystemBack2MainScreenButtonListener listener = new PosSystemBack2MainScreenButtonListener(this, this.posMainView);
		posBack2MainScreenPanel.add(jBackToMain);
		jBackToMain.addActionListener(listener);
	}
	private void initFormPanel(){
		formPanel = new PosSysAdmFormPanel(this);
		
	}
	private void initInnerLeftPanel(){
		posInnerLeftPanel = new JPanel();
		GridLayout posGridLayout = new GridLayout(2,1);
//		BoxLayout posBoxLayout = new BoxLayout(posInnerPanel, BoxLayout.Y_AXIS);
		posInnerLeftPanel.setLayout(posGridLayout);
	}
	private void initInnerRightPanel(){
		posInnerRightPanel = new JPanel();
		GridLayout posGridLayout = new GridLayout(2,1);
//		BoxLayout posBoxLayout = new BoxLayout(posInnerPanel, BoxLayout.Y_AXIS);
		posInnerRightPanel.setLayout(posGridLayout);
	}
	
	private void initPosContentPanel(){
		GridLayout layout = new GridLayout(1, 2);
		posContentPanel = new JPanel();
		posContentPanel.setBounds(10, 10, frameWidth, frameHeight);
		posContentPanel.setLayout(layout);
	}
	private void initPosFrame(){
		posFrame = new PosFrame("POS Frame");
		posFrame.setTitle(bundlesDto.getPosSystemAdminScreenTitle());
		Dimension dimension = SystemUtils.getScreenSize();
		if (dimension != null){
			posFrame.setSize(frameWidth, frameHeight);
		} else {
			posFrame.setSize(1024, 768);
		}
		posFrame.setLocationRelativeTo(null);
		posFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		posFrame.getContentPane().add(posContentPanel);
//		posFrame.pack();
	}
	private void initFlavorTableAndScrollPane(){
		try{
			
			List<PosTableDataDto> posTableDataList = new ArrayList<PosTableDataDto>();
			if (flavorList != null){
				Collections.sort(flavorList);
				posTableDataList = posSystemAdminViewHelper.convertFlavorEoList2PosTableDataDtoList(flavorList);
				
				if (posFlavorTable == null){
					posFlavorTable = new PosTable();
					PosIngredientRowListener listener = new PosIngredientRowListener(ingredientEoCurrentOperation, posFlavorTable, formPanel); 
					ListSelectionModel selectionModel = posFlavorTable.getSelectionModel();
					selectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					selectionModel.addListSelectionListener(listener);
					if (posFlavorScrollPane == null){
						posFlavorScrollPane = new JScrollPane(posFlavorTable);
					}
				}

			}
			posFlavorTable.setData(posTableDataList);
			posFlavorScrollPane.repaint();
//			posFlavorScrollPane.paint(posFrame.getGraphics());
		} catch (Exception e){
			logger.error("PosSystemAdminView.initPosTable() - Exception:", e);
		}		
	}
	
	private void initDecoratorTableAndScrollPane(){
		try{
			List<PosTableDataDto> posTableDataList = new ArrayList<PosTableDataDto>();
			if (decoratorList != null){
				Collections.sort(decoratorList);
				posTableDataList = posSystemAdminViewHelper.convertDecoratorEoList2PosTableDataDtoList(decoratorList);
				
				if (posDecoratorTable == null){
					posDecoratorTable = new PosTable();
					
					PosIngredientRowListener listener = new PosIngredientRowListener(ingredientEoCurrentOperation, posDecoratorTable, formPanel); 
					ListSelectionModel selectionModel = posDecoratorTable.getSelectionModel();
					selectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					selectionModel.addListSelectionListener(listener);

					if (posDecoratorScrollPane == null){
						posDecoratorScrollPane = new JScrollPane(posDecoratorTable);
					}
					
				}
			}
			posDecoratorTable.setData(posTableDataList);
			posDecoratorScrollPane.repaint();
//			posDecoratorScrollPane.paint(posFrame.getGraphics());
		} catch (Exception e){
			logger.error("PosSystemAdminView.initPosTable() - Exception:", e);
		}
	}
	
	public void refresh(){
//		unloadComponents();
//		init();
//		initUi();
//		bindComponents();
		init();

		initFlavorTableAndScrollPane();
		initDecoratorTableAndScrollPane();
	}
}
