package com.redox.notification.util;

import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Logger;

public class MobileServiceUtil {
	private static Logger LOG = Logger.getLogger(MobileServiceUtil.class.getName());

	public static String getProperty(String key) {
		InputStream is = null;
		String value = null;
		try {
			Properties prop = new Properties();
			LOG.info("MobileServiceUtil  : getProperty  loading ....." + key);
			is = new MobileServiceUtil().getClass().getResourceAsStream("/mobile-service.properties");
			prop.load(is);
			LOG.info("MobileServiceUtil  : getProperty property loaded ");
			value = prop.getProperty(key);
		} catch (Exception e) {
			LOG.info("MobileServiceUtil  : getProperty exception " + e);
		}
		LOG.info("MobileServiceUtil  : getProperty Value : " + value);
		return value;
	}

}
