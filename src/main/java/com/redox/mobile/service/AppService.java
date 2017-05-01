package com.redox.mobile.service;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Logger;

import com.redox.notification.util.MobileServiceUtil;

public class AppService {
	private static Logger LOG = Logger.getLogger(AppService.class.getName());

	public void sendLinkAndOtp(String admissionNO, String mobileNo, String emailId) {

		LOG.info("AppService  : sendLinkAndOtp admissionNO :" + admissionNO

				+ " mobileNo: " + mobileNo + " email: " + emailId);

		try {
			String schoolId = MobileServiceUtil.getProperty("schoolId");
			String link = MobileServiceUtil.getProperty("link");
			URL url = new URL(MobileServiceUtil.getProperty("url") + "/createOtp");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setRequestProperty("key", "value");
			String input = "{\"schoolId\": \"" + schoolId + "\",\"admissionNo\": \"" + admissionNO
					+ "\",\"mobileNo\":\"" + mobileNo + "\",\"emailId\":\"" + emailId + "\",\"link\":\"" + link + "\"}";
			LOG.info("AppService  : sendLinkAndOtp data :" + input);

			OutputStream os = conn.getOutputStream();
			os.write(input.getBytes());
			os.flush();

			if (conn.getResponseCode() != 200) {
				LOG.info("AppService  : sendLinkAndOtp faild for schoolId " + schoolId + " status code: "
						+ conn.getResponseCode());
			} else {
				LOG.info("AppService  : sendLinkAndOtp  for schoolId " + schoolId + " status code: "
						+ conn.getResponseCode());
			}
			conn.disconnect();

		} catch (Exception e) {

			LOG.info("AppService  : sendLinkAndOtp faild Exception: " + e);
		}
	}

}
