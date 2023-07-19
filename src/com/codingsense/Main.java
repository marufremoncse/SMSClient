package com.codingsense;

import com.codingsense.sms.SMSClient;

public class Main {
	public static void main(String[] args) {
		SMSClient smsClient = new SMSClient();
		smsClient.send();
	}
}
