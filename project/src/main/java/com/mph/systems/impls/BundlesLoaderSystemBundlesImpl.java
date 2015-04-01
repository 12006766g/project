package com.mph.systems.impls;

import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mph.models.dtos.BundlesDto;
import com.mph.models.dtos.impls.BundlesDtoImpl;
import com.mph.systems.BundlesLoader;
import com.mph.systems.utils.PropertiesUtils;

public class BundlesLoaderSystemBundlesImpl implements BundlesLoader<BundlesDto> {
	private static final Logger log = LoggerFactory.getLogger(BundlesLoaderSystemBundlesImpl.class);
	private static final String PROPERTIES_JAVA_RUNTIME = "system.properties";
	private static final String PROPERTIES_SYSTEM_RESOURCE = "system.properties";
	private static Properties properties;
	private static BundlesDto bundlesDto;
	private void loadInstanceOfSystemProperties(){
		try{
			if (properties == null){
//				log.debug("BundlesLoaderSystemBundlesImpl.loadInstanceOfSystemProperties() - debug: getResourceAsStream()");
				properties = new Properties();
				properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(PROPERTIES_SYSTEM_RESOURCE));
			}
			if (properties == null){
//				log.debug("BundlesLoaderSystemBundlesImpl.loadInstanceOfSystemProperties() - debug: getResourceAsJavaRunTime()");
				properties = PropertiesUtils.readPropertiesByJavaRuntimeVariable(PROPERTIES_JAVA_RUNTIME);
			}
			if (properties == null){
//				log.debug("BundlesLoaderSystemBundlesImpl.loadInstanceOfSystemProperties() - debug: getSystemResource()");
				properties = PropertiesUtils.readPropertiesBySystemResource(PROPERTIES_SYSTEM_RESOURCE);
			}
		} catch (Exception e){
			log.error("BundlesLoaderSystemBundlesImpl.loadInstanceOfSystemProperties()", e);
		}
	}

	public BundlesDto getBundlesDto() {
		if (bundlesDto == null){
			loadInstanceOfSystemProperties();
			if (properties != null){
				bundlesDto = new BundlesDtoImpl();
				String flavorColumnHeader = properties.getProperty("com.mph.systems.impls.BundlesLoaderSystemBundlesImpl.FLAVOR_COLUMN_HEADER_TEXT", "ICE-CREAM Flavor");
				bundlesDto.setFlavorColumnHeader(flavorColumnHeader);
				String decoratorColumnHeader = properties.getProperty("com.mph.systems.impls.BundlesLoaderSystemBundlesImpl.DECORATOR_COLUMN_HEADER_TEXT", "Decorator");
				bundlesDto.setDecoratorColumnHeader(decoratorColumnHeader);
				String newButton = properties.getProperty("com.mph.systems.impls.BundlesLoaderSystemBundlesImpl.NEW_BUTTON_TEXT", "[New IceCream]");
				bundlesDto.setNewButton(newButton);
				String systemAdministrator = properties.getProperty("com.mph.systems.impls.BundlesLoaderSystemBundlesImpl.SYSTEM_ADMINISTRATOR_BUTTON_TEXT", "[System Administrator]");
				bundlesDto.setSystemAdministratorButton(systemAdministrator);
				String total = properties.getProperty("com.mph.systems.impls.BundlesLoaderSystemBundlesImpl.TOTAL_LABEL_TEXT", "Total:");
				bundlesDto.setTotalLabel(total);

				String posMainScreenTitle = properties.getProperty("com.mph.systems.impls.BundlesLoaderSystemBundlesImpl.POS_MAIN_SCREEN_TITLE", "POS Main Screen");
				bundlesDto.setPosMainScreenTitle(posMainScreenTitle);
				
				String posSystemAdminScreenTitle = properties.getProperty("com.mph.systems.impls.BundlesLoaderSystemBundlesImpl.POS_SYSTEM_ADMIN_SCREEN_TITLE", "System Administrator Screen");
				bundlesDto.setPosSystemAdminScreenTitle(posSystemAdminScreenTitle);
				
				String tblColumnNameId = properties.getProperty("com.mph.systems.impls.BundlesLoaderSystemBundlesImpl.TBL_COLUMN_NAME_ID", "ID");
				bundlesDto.setTableColumnNameId(tblColumnNameId);

				String tblColumnNameName = properties.getProperty("com.mph.systems.impls.BundlesLoaderSystemBundlesImpl.TBL_COLUMN_NAME_NAME", "Name");
				bundlesDto.setTableColumnNameName(tblColumnNameName);
				
				String tblColumnNamePrice = properties.getProperty("com.mph.systems.impls.BundlesLoaderSystemBundlesImpl.TBL_COLUMN_NAME_PRICE", "Price");
				bundlesDto.setTableColumnNamePrice(tblColumnNamePrice);
				
				String tblColumnNameType = properties.getProperty("com.mph.systems.impls.BundlesLoaderSystemBundlesImpl.TBL_COLUMN_NAME_TYPE", "Type");
				bundlesDto.setTableColumnNameType(tblColumnNameType);

				
				String sysAdmDeleteButton = properties.getProperty("com.mph.systems.impls.BundlesLoaderSystemBundlesImpl.SYS_ADM_DELETE_BUTTON_TEXT", "Delete");
				bundlesDto.setSysAdmDeleteButton(sysAdmDeleteButton);
				
				String sysAdmNewButton = properties.getProperty("com.mph.systems.impls.BundlesLoaderSystemBundlesImpl.SYS_ADM_NEW_BUTTON_TEXT", "New");
				bundlesDto.setSysAdmNewButton(sysAdmNewButton);
				
				String sysAdmGoBackToMainScreenButton = properties.getProperty("com.mph.systems.impls.BundlesLoaderSystemBundlesImpl.SYS_ADM_GO_BACK_TO_MAIN_SCREEN_BUTTON_TEXT", "Go back to Main Screen");
				bundlesDto.setSysAdmGoBackToMainScreenButton(sysAdmGoBackToMainScreenButton);
				
			}
		}
		return bundlesDto;
	}
}
