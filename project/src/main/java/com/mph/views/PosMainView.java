package com.mph.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mph.factories.BundlesFactory;
import com.mph.models.dtos.BundlesDto;
import com.mph.models.eos.DecoratorEo;
import com.mph.models.eos.FlavorEo;
import com.mph.models.eos.InventoryMasterEo;
import com.mph.models.vos.IcecreamVo;
import com.mph.models.vos.impls.IcecreamVoImpl;
import com.mph.systems.utils.SystemUtils;
import com.mph.views.components.PosFrame;
import com.mph.views.components.PosIngredientButton;
import com.mph.views.components.PosLabel;
import com.mph.views.components.PosNewIcecreamButton;
import com.mph.views.listeners.PosIngredientButtonListener;
import com.mph.views.listeners.PosNewIcecreamButtonListener;
import com.mph.views.listeners.PosSystemAdminButtonListener;

public class PosMainView{
	private static final Logger logger = LoggerFactory.getLogger(PosMainView.class);
	private JFrame posFrame;
	private Map<Integer, Component> posFlavorColumnMap;
	private Map<Integer, Component> posDecoratorColumnMap;
//	private Map<Integer, Component> posOtherColumnMap;
	
	private Dimension desktopDimension;
	private int frameWidth;
	private int frameHeight;
	private JPanel posMenuPanel;
	private JPanel posInnerPanel;
	private JPanel posInnerLeftPanel;
	private JPanel posInnerMiddlePanel;
	private JPanel posInnerRightPanel;
	private JPanel posContentPanel;
	private BundlesDto bundlesDto;
	JLabel jRightTotal;
	private InventoryMasterEo inventoryMasterEo;
	private IcecreamVo icecreamVo;
	
	public void unloadComponents(){
		posFrame.setVisible(false);
		posFrame.dispose();
		posFrame = null;
		posMenuPanel = null;
		posInnerPanel = null;
		posInnerLeftPanel = null;
		posInnerMiddlePanel = null;
		posInnerRightPanel = null;
		posContentPanel = null;
		jRightTotal = null;
	}
	
	public void reload(){
		unloadComponents();
		init();
		initUi();
		bindComponents();
	}
	public PosMainView(InventoryMasterEo inventoryMasterEo){
		this.inventoryMasterEo = inventoryMasterEo;
		init();
		initUi();
		bindComponents();
	}
	private void init(){
		posFlavorColumnMap = new HashMap<Integer, Component>();
		posDecoratorColumnMap = new HashMap<Integer, Component>();
//		posOtherColumnMap = new HashMap<Integer, Component>();
		icecreamVo = new IcecreamVoImpl();
		bundlesDto = BundlesFactory.getBundlesInstance();
		jRightTotal = new PosLabel();
	}
	
	private void initUi(){
		desktopDimension = SystemUtils.getScreenSize();
		frameWidth = (int) (desktopDimension.getWidth() * 0.8);
		frameHeight = (int) (desktopDimension.getHeight() * 0.8);
		initMenuPanel();
		initInnerLeftPanel();
		initInnerMiddlePanel();
		initInnerRightPanel();
		initInnerPanel();
		initPosContentPanel();
		initPosFrame();
		initPosButtons();
	
	}
	private void bindComponents(){
		// set header field
		Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
		
		Box box1 = Box.createVerticalBox();
		box1.setBorder(border);
		JLabel iceCreamFlavorLabel = new PosLabel();
		iceCreamFlavorLabel.setText(bundlesDto.getFlavorColumnHeader());
		iceCreamFlavorLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		iceCreamFlavorLabel.setVerticalAlignment(JLabel.CENTER);
		iceCreamFlavorLabel.setVerticalTextPosition(JLabel.CENTER);
		box1.add(iceCreamFlavorLabel);
		
		Box box2 = Box.createVerticalBox();
		box2.setBorder(border);
		JLabel decoratorLabel = new PosLabel();
		decoratorLabel.setText(bundlesDto.getDecoratorColumnHeader());
		box2.add(decoratorLabel);
		
		JButton newIceCreamButton = new PosNewIcecreamButton();
		newIceCreamButton.setText(bundlesDto.getNewButton());
		PosNewIcecreamButtonListener posNewIcecreamButtonListener = new PosNewIcecreamButtonListener(this);
		newIceCreamButton.addActionListener(posNewIcecreamButtonListener);
		posMenuPanel.add(box1);
		posMenuPanel.add(box2);
		posMenuPanel.add(newIceCreamButton);
		
		Iterator<Entry<Integer, Component>> flavorIterator = posFlavorColumnMap.entrySet().iterator();
		Iterator<Entry<Integer, Component>> decoratorIterator = posDecoratorColumnMap.entrySet().iterator();
		while (flavorIterator.hasNext()){
			Map.Entry<Integer, Component> pair = (Map.Entry<Integer, Component>) flavorIterator.next();
			posInnerLeftPanel.add(pair.getValue());		
		}
		JLabel jLabel = new PosLabel();
		posInnerLeftPanel.add(jLabel);
		
		JButton systemAdminButton = new PosIngredientButton();
		systemAdminButton.setText(bundlesDto.getSystemAdministratorButton());
		PosSystemAdminButtonListener posSystemAdminButtonListener = new PosSystemAdminButtonListener(this);
		systemAdminButton.addActionListener(posSystemAdminButtonListener);
		
		posInnerLeftPanel.add(systemAdminButton);
		
		while (decoratorIterator.hasNext()){
			Map.Entry<Integer, Component> pair = (Map.Entry<Integer, Component>) decoratorIterator.next();
			posInnerMiddlePanel.add(pair.getValue());
			
			JLabel jRightLabel = new PosLabel();
			posInnerRightPanel.add(jRightLabel);
			
		}
		
		jRightTotal.setText(bundlesDto.getTotalLabel() + " " + icecreamVo.getTotal());
		posInnerRightPanel.add(jRightTotal);
		
		posFrame.setVisible(true);	
	}
	
	private void initMenuPanel(){
		posMenuPanel = new JPanel();
		GridLayout posGridLayout = new GridLayout(1, 3);
		int height = (int) (Math.round(frameHeight * 0.10));
		int width = frameWidth;
		posMenuPanel.setPreferredSize(new Dimension(width, height));
		posMenuPanel.setLayout(posGridLayout);
	}
	private void initInnerPanel(){
		posInnerPanel = new JPanel();
		GridLayout layout = new GridLayout(1,3);
//		BoxLayout posBoxLayout = new BoxLayout(posInnerPanel, BoxLayout.Y_AXIS);
	
//		posInnerPanel.setBounds(0, 0, (int) desktopDimension.getWidth(), (int)desktopDimension.getHeight());
		int height = (int) (Math.round(frameHeight * 0.90));
		int width = frameWidth;
		posInnerPanel.setPreferredSize(new Dimension(width, height));
		
		posInnerPanel.setLayout(layout);			

		posInnerPanel.add(posInnerLeftPanel);
		posInnerPanel.add(posInnerMiddlePanel);
		posInnerPanel.add(posInnerRightPanel);
	}
	private void initInnerLeftPanel(){
		posInnerLeftPanel = new JPanel();
		GridLayout posGridLayout = new GridLayout(0,1);
//		BoxLayout posBoxLayout = new BoxLayout(posInnerPanel, BoxLayout.Y_AXIS);
		posInnerLeftPanel.setLayout(posGridLayout);
	}
	private void initInnerMiddlePanel(){
		posInnerMiddlePanel = new JPanel();
		GridLayout posGridLayout = new GridLayout(0,1);
//		BoxLayout posBoxLayout = new BoxLayout(posInnerPanel, BoxLayout.Y_AXIS);
		posInnerMiddlePanel.setLayout(posGridLayout);
	}
	private void initInnerRightPanel(){
		posInnerRightPanel = new JPanel();
		GridLayout posGridLayout = new GridLayout(0,1);
//		BoxLayout posBoxLayout = new BoxLayout(posInnerPanel, BoxLayout.Y_AXIS);
		posInnerRightPanel.setLayout(posGridLayout);
	}
	private void initPosContentPanel(){
		posContentPanel = new JPanel();
		BorderLayout layout = new BorderLayout();
		//posContentPanel.setBounds(10, 10, frameWidth, frameHeight);
		posContentPanel.setLayout(layout);
		posContentPanel.add(posMenuPanel, BorderLayout.NORTH);
		posContentPanel.add(posInnerPanel, BorderLayout.CENTER);
	}
	private void initPosFrame(){
		posFrame = new PosFrame("POS Frame");
		posFrame.setTitle(bundlesDto.getPosMainScreenTitle());
		Dimension dimension = SystemUtils.getScreenSize();
		if (dimension != null){
			posFrame.setSize(frameWidth, frameHeight);
		} else {
			posFrame.setSize(1024, 768);
		}
		posFrame.setLocationRelativeTo(null);
		posFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		posFrame.getContentPane().add(posContentPanel);
//		posFrame.pack();
	}
	private void initPosButtons(){
		
		if (inventoryMasterEo != null){
			Map<Integer, FlavorEo> flavorEoMap = inventoryMasterEo.getFlavorMap();
			Map<Integer, DecoratorEo> decoratorEoMap = inventoryMasterEo.getDecoratorMap();
			
			Iterator<Entry<Integer, FlavorEo>> flavorIterator = flavorEoMap.entrySet().iterator();
			Iterator<Entry<Integer, DecoratorEo>> decoratorIterator = decoratorEoMap.entrySet().iterator();
			
			while (flavorIterator.hasNext()){
				Map.Entry<Integer, FlavorEo> pair = (Map.Entry<Integer, FlavorEo>) flavorIterator.next();
				FlavorEo flavorEo = pair.getValue();
				JButton ingredientButton = new PosIngredientButton();
				String buttonText = "[" + flavorEo.getName() +", $" + flavorEo.getPrice() + "]";
				ingredientButton.setText(buttonText);
				PosIngredientButtonListener listener = new PosIngredientButtonListener(posFrame, flavorEo, icecreamVo, jRightTotal);
				ingredientButton.addActionListener(listener);    
				posFlavorColumnMap.put(flavorEo.getId(), ingredientButton);
			}
			

			while(decoratorIterator.hasNext()){
				Map.Entry<Integer, DecoratorEo> pair = (Map.Entry<Integer, DecoratorEo>) decoratorIterator.next();
				DecoratorEo decoratorEo = pair.getValue();
				JButton ingredientButton = new PosIngredientButton();
				String buttonText = "[" + decoratorEo.getName() +", $" + decoratorEo.getPrice() + "]";
				ingredientButton.setText(buttonText);		
				PosIngredientButtonListener listener = new PosIngredientButtonListener(posFrame, decoratorEo, icecreamVo, jRightTotal);
				ingredientButton.addActionListener(listener);    
				posDecoratorColumnMap.put(decoratorEo.getId(), ingredientButton);
			}
			
		}
	}
	
}
