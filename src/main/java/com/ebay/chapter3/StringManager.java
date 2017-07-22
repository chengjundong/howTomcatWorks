package com.ebay.chapter3;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class StringManager {

	private static final Map<String, StringManager> MGRS = new HashMap<>();
	
	private ResourceBundle res;
	
	private StringManager(String packageName) {
		res = ResourceBundle.getBundle(packageName+".LocalStrings");
	}
	
	public String getString(String key) {
		return res.getString(key);
	}
	
	public static StringManager getStringMananger(String packageName) {
		StringManager stringManager = MGRS.get(packageName);
		if(null == stringManager) {
			synchronized (StringManager.class) {
				stringManager = MGRS.get(packageName);
				if(null == stringManager) {
					stringManager = new StringManager(packageName);
					MGRS.put(packageName, stringManager);
					return stringManager;
				} else {
					return stringManager;
				}
			}
		} else {
			return stringManager;
		}
	}
}
