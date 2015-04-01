package com.mph;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.mph.daos.impls.InventoryMasterDaoImplUTest;
import com.mph.services.impls.InventoryMasterMgrImplUTest;

@RunWith(Suite.class)
@SuiteClasses({InventoryMasterDaoImplUTest.class, InventoryMasterMgrImplUTest.class})
public class TestSuit {
	
}
