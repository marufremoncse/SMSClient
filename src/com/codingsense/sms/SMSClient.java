package com.codingsense.sms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class SMSClient {
	public String send() {
		String mobile = "xxxx";
		String msg = "xxxx";
		String apiKey = "xxxx";
		String sender = "xxxx";
		String msisdn = "xxxx";
		String response = "";

		try {
			String url = "https://labapi.smartlabsms.com/smsapiv3?" + "apikey=" + URLEncoder.encode(apiKey, "UTF-8")
					+ "&sender=" + URLEncoder.encode(sender, "UTF-8") + "&msisdn=" + URLEncoder.encode(msisdn, "UTF-8")
					+ "&smstext=" + URLEncoder.encode(msg, "UTF-8");

			URL obj = new URL(url);
			HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
			connection.setRequestMethod("POST");
			connection.setReadTimeout(30000);
			connection.setInstanceFollowRedirects(true);
			connection.setRequestProperty("Accept-Encoding", "");

			int responseCode = connection.getResponseCode();
			if (responseCode == HttpURLConnection.HTTP_OK) {
				BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				String inputLine;
				StringBuilder responseStringBuilder = new StringBuilder();

				while ((inputLine = in.readLine()) != null) {
					responseStringBuilder.append(inputLine);
				}
				in.close();

				response = responseStringBuilder.toString();
			} else {
				response = "HTTP Error: " + responseCode;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return response;
	}
}