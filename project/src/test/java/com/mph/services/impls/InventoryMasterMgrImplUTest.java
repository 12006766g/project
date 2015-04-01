/**
 * 
 */
package com.mph.services.impls;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.mph.criteria.IngredientCriteria;
import com.mph.factories.InventoryMasterRepositoryFactory;
import com.mph.helpers.InventoryMasterMgrHelper;
import com.mph.models.eos.DecoratorEo;
import com.mph.models.eos.FlavorEo;
import com.mph.models.eos.InventoryMasterEo;
import com.mph.services.InventoryMasterMgr;

/**
 * @author Dave Man
 *
 */
public class InventoryMasterMgrImplUTest {
	private InventoryMasterMgr inventoryMasterMgr;
	private InventoryMasterMgrHelper inventoryMasterMgrHelper;
	private InventoryMasterEo inventoryMasterEo;
	private Map<Integer, FlavorEo> flavorMap;
	private Map<Integer, DecoratorEo> decoratorMap;
	
	
	public InventoryMasterMgrImplUTest(){

	}
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {

	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		init();
	}

	private void init() {
		try {
			inventoryMasterEo = InventoryMasterRepositoryFactory.getInstance();
			flavorMap = inventoryMasterEo.getFlavorMap();
			decoratorMap = inventoryMasterEo.getDecoratorMap();
			inventoryMasterMgr = new InventoryMasterMgrImpl();
			inventoryMasterMgrHelper = new InventoryMasterMgrHelper();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		try{
			removeAllIngredient();
			inventoryMasterMgr = null;
			inventoryMasterMgrHelper = null;
			inventoryMasterEo = null;
		} catch (Exception e){
			e.printStackTrace();
		}
	}

	private void addDefaultRecords() {
		List<FlavorEo> flavorEoList = inventoryMasterMgrHelper.getDefaultFlavorList();
		List<DecoratorEo> decoratorEoList = inventoryMasterMgrHelper.getDefaultDecoratorList();

		if (flavorEoList != null && !flavorEoList.isEmpty()) {
			for (FlavorEo flavorEo : flavorEoList) {
				inventoryMasterMgr.addIngredient(flavorEo);
			}
		}

		if (decoratorEoList != null && !decoratorEoList.isEmpty()) {
			for (DecoratorEo decoratorEo : decoratorEoList) {
				inventoryMasterMgr.addIngredient(decoratorEo);
			}
		}

	}

	/**
	 * Test method for
	 * {@link com.mph.services.impls.InventoryMasterMgrImpl#addIngredient(com.mph.models.eos.IngredientEo)}
	 * .
	 */
	@Test
	public void testAddIngredient() {
		
		addDefaultRecords();
		
		assert (flavorMap.size() == 2 && decoratorMap.size() == 2);
	}

	private void removeAllIngredient(){
		flavorMap = inventoryMasterEo.getFlavorMap();
		decoratorMap = inventoryMasterEo.getDecoratorMap();

		if (flavorMap != null){
			Iterator<Entry<Integer, FlavorEo>> iterFlavorMap = flavorMap.entrySet()
					.iterator();
	
	
			while (iterFlavorMap.hasNext()) {
				Map.Entry<Integer, FlavorEo> pair = (Map.Entry<Integer, FlavorEo>) iterFlavorMap
						.next();
				inventoryMasterMgr.removeIngredient(pair.getValue());
			}
		}
		if (decoratorMap != null){
			Iterator<Entry<Integer, DecoratorEo>> iterDecoratorMap = decoratorMap
					.entrySet().iterator();
			
			while (iterDecoratorMap.hasNext()) {
				Map.Entry<Integer, DecoratorEo> pair = (Map.Entry<Integer, DecoratorEo>) iterDecoratorMap
						.next();
				inventoryMasterMgr.removeIngredient(pair.getValue());
			}
		}
	}
	/**
	 * Test method for
	 * {@link com.mph.services.impls.InventoryMasterMgrImpl#removeIngredient(com.mph.models.eos.IngredientEo)}
	 * .
	 */
	@Test
	public void testRemoveIngredient() {

		addDefaultRecords();
		removeAllIngredient();
		assert (flavorMap.size() == 0 && decoratorMap.size() == 0);
	}

	@Test
	public void testFindDecoratorList() {

		addDefaultRecords();

		IngredientCriteria decoratorCriteria = new IngredientCriteria();
		List<DecoratorEo> decoratorEoList = inventoryMasterMgr
				.findDecoratorList(decoratorCriteria);
		IngredientCriteria flavorCriteria = new IngredientCriteria();
		List<FlavorEo> flavorEoList = inventoryMasterMgr
				.findFlavorList(flavorCriteria);

		assert (decoratorEoList.size() > 0 && flavorEoList.size() > 0);
	}

}
