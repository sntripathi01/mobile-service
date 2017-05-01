/**
 * 
 */
package com.redox.notification.service.connector;

import org.junit.Ignore;
import org.junit.Test;

import com.redox.mobile.service.NotificationService;

/**
 * @author HP
 *
 */
public class NotificationServiceConnectorTest {

	/**
	 * Test method for
	 * {@link com.redox.mobile.service.NotificationService#sendNotification(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)}
	 * .
	 */
	@Ignore
	@Test
	public void testSendNotification() {
		NotificationService notificationServiceConnector = new NotificationService();
		notificationServiceConnector.sendNotificationToClassWithSection( "CLASS", "SECTION", "TITLE", "BODY");
	}

}
