package com.mph.factories;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mph.models.dtos.BundlesDto;
import com.mph.systems.BundlesLoader;
import com.mph.systems.impls.BundlesLoaderSystemBundlesImpl;

public class BundlesFactory {
	private static final Logger log = LoggerFactory.getLogger(BundlesFactory.class);
	private static BundlesDto bundlesDto;

	
	public static BundlesDto getBundlesInstance(){
		try{
			if (bundlesDto == null){
				BundlesLoader <BundlesDto> bundlesLoader = new BundlesLoaderSystemBundlesImpl();
				bundlesDto = bundlesLoader.getBundlesDto();
			}
		} catch (Exception e){
			log.error("BundlesFactory.getDbBundlesInstance() - Exception: ", e);
		}
		return bundlesDto;
	}
	

}
