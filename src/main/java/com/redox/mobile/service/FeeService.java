package com.redox.mobile.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.redox.mobile.service.model.FeeSlipResponse;
import com.redox.notification.util.MobileServiceUtil;

public class FeeService {
	private static Logger LOG = Logger.getLogger(FeeService.class.getName());

	public FeeSlipResponse feeSlipService(String studentId, String iCode, String amount, String months) {

		LOG.info("FeeService  : feeSlipService studentId :" + studentId + "  iCode: " + iCode + " amount:" + amount);
		FeeSlipResponse feeSlipResponse = new FeeSlipResponse();

		try {
			String schoolId = MobileServiceUtil.getProperty("schoolId");
			String query = "schoolId=" + schoolId + "&studentId=" + studentId + "&iCode=" + iCode;
			URL url = new URL(MobileServiceUtil.getProperty("url") + "/feeSlip?" + query);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-Type", "application/json");
			if (conn.getResponseCode() != 200) {
				LOG.info("FeeSlipResponse  : feeSlipService failed  status code: " + conn.getResponseCode());
			} else {
				BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

				String output;
				String response = "";
				LOG.info("Output from Server .... \n");
				while ((output = br.readLine()) != null) {
					LOG.info(output);
					response += output;
				}
				ObjectMapper mapper = new ObjectMapper();
				feeSlipResponse = mapper.readValue(response, FeeSlipResponse.class);
				feeSlipResponse.setMonths(months);
				feeSlipResponse.setTotal(amount);
				LOG.info("FeeSlipResponse  : feeSlipService sent  status code: " + conn.getResponseCode());
			}
			conn.disconnect();

		} catch (Exception e) {

			LOG.info("FeeSlipResponse  : feeSlipService fail :   Exception: " + e);
		}
		LOG.info("Reponse " + feeSlipResponse);
		return feeSlipResponse;
	}

}
