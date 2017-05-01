package com.redox.mobile.service;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Logger;

import com.redox.notification.util.MobileServiceUtil;

public class NotificationService {

	private static Logger LOG = Logger.getLogger(NotificationService.class.getName());

	public void sendNotificationToStudent(String admissionNo, String title, String body) {
		sendNotification(admissionNo, null, null, title, body);
	}

	public void sendNotificationToClassWithSection(String studentClass, String section, String title, String body) {
		sendNotification(null, studentClass, section, title, body);
	}

	public void sendNotificationToClass(String studentClass, String title, String body) {
		sendNotification(null, studentClass, null, title, body);
	}

	public void sendNotificationToAll(String studentClass, String title, String body) {
		sendNotification(null, null, null, title, body);
	}

	private void sendNotification(String admissionNo, String studentClass, String section, String title, String body) {

		LOG.info("NotificationService  : sendNotification title :" + title + " schoolId: " + "  scetion: " + section
				+ " admissionNo:" + admissionNo + "studentClass:" + studentClass + " message:" + body);

		try {
			String schoolId = MobileServiceUtil.getProperty("schoolId");
			URL url = new URL(MobileServiceUtil.getProperty("url" + "/notification"));
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");

			String input = "{\"schoolId\": \"" + schoolId + "\",\"admissionNo\": \"" + admissionNo
					+ "\",\"studentClass\":\"" + studentClass + "\",\"section\":\"" + section + "\",\"title\":\""
					+ title + "\",\"body\":\"" + body + "\"}";

			OutputStream os = conn.getOutputStream();
			os.write(input.getBytes());
			os.flush();

			if (conn.getResponseCode() != 200) {
				LOG.info("NotificationService  : sendNotification failed " + title + " for schoolId " + schoolId
						+ " status code: " + conn.getResponseCode());
			} else {
				LOG.info("NotificationService  : sendNotification sent " + title + " for schoolId " + schoolId
						+ " status code: " + conn.getResponseCode());
			}
			conn.disconnect();

		} catch (Exception e) {

			LOG.info("NotificationService  : sendNotification fail :  " + title + " Exception: " + e);
		}
	}
}
