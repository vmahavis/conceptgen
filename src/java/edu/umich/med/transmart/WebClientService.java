package edu.umich.med.transmart;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class WebClientService {

	public String getHttpResponse(String url) {
		try {
			StringBuffer sb = new StringBuffer();
			int kar;
			char ch;
			URL href = new URL(url);
			HttpURLConnection hc = (HttpURLConnection) href.openConnection();
			hc.setRequestMethod("GET");
			hc.connect();

			InputStream ins = hc.getInputStream();

			while ((kar = ins.read()) != -1) {
				ch = (char) kar;
				sb.append(ch);
			}
			ins.close();
			hc.disconnect();
			return sb.toString();
		} catch (Exception e) {

			System.out.println(e);
			return null;
		}

	}
}
