package com.mph.utils;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommonUtils {
	private static final Logger logger = LoggerFactory.getLogger(CommonUtils.class);

	public static boolean isNumeric(String str){
		try{
			Double.parseDouble(str);
		} catch (NumberFormatException e){
			return false;
		}
		return true;
	}
	public static BigDecimal number2BigDecimal(Number number){
		BigDecimal rtnBigDecimal = null;
		if (number != null){
			rtnBigDecimal = new BigDecimal(number.intValue());
		}
		return rtnBigDecimal;
	}
	public static Integer number2Integer(Number number){
		Integer rtnInteger = null;
		if (number != null){
			rtnInteger = number.intValue();
		}
		return rtnInteger;
	}
	
	public static Long number2Long(Number number){
		Long rtnLong = null;
		if (number != null){
			rtnLong = number.longValue();
		}
		return rtnLong;
	}
	public static String genTimestampString(){
		Date now = new Date();
		String rtnStr = "";
		try{
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
			rtnStr = format.format(now);
		} catch (Exception e){
			logger.error("CommonUtils.genTimestampString() - Exception: ", e);
		}
		return rtnStr;
	}

	public static List<String> regMatch(String sourceString, String patternString){
		List<String> matchStrList = new ArrayList<String>();
		Pattern pattern = Pattern.compile(patternString);
		Matcher matcher = pattern.matcher(sourceString);
		while(matcher.find()){
			matchStrList.add(matcher.group());
		}
		return matchStrList;
	}
	
	public static boolean isInteger(String str){
		try{
			Integer.parseInt(str);
		} catch (Exception e){
			if (e instanceof NumberFormatException){
				return false;
			} else {
				return false;
			}
		}
		return true;
	}
	
	public static int safeLongToInt(long l) {
		try{
		    if (l < Integer.MIN_VALUE || l > Integer.MAX_VALUE) {
		        throw new IllegalArgumentException
		            (l + " cannot be cast to int without changing its value.");
		    }
		} catch (Exception e){
			if (logger.isDebugEnabled()){
				logger.debug("CommonUtils.safeLongToInt() - cannot be cast to int without changing its value.");
			}
		}
	    return (int) l;
	}
	public static float safeDoubleToFloat(double d) {
		try{
		    if (d < Float.MIN_VALUE || d > Float.MAX_VALUE) {
		        throw new IllegalArgumentException
		            (d + " cannot be cast to float without changing its value.");
		    }
		} catch (Exception e){
			if (logger.isDebugEnabled()){
				logger.debug("CommonUtils.safeDoubleToFloat() - cannot be cast to float without changing its value.");
			}
		}
	    return (float) d;
	}
}
