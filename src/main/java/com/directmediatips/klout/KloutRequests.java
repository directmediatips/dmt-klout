package com.directmediatips.klout;

/*
 * Copyright 2017, Bruno Lowagie, Wil-Low BVBA
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License. You may obtain
 * a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the  * specific language governing permissions and
 * limitations under the License.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Class that bundles all the possible request templates, along with a method
 * to execute these requests with a JSON response as return value.
 */
public class KloutRequests {

	/** Template for a request to get an ID based on a Twitter screen name. */
	public static final String ID_FROM_TWITTER_SCREENNAME =
			"http://api.klout.com/v2/identity.json/twitter?screenName=%s&key=%s";
	
	/** Template for a request to get an ID based on a Klout id. */
	public static final String ID_FROM_KLOUT_TO_NETWORK =
			"http://api.klout.com/v2/identity.json/%s/%s/%s?key=%s";
	
	/** Template for a request to get a Klout ID based on any network id. */
	public static final String ID_FROM_NETWORK_TO_KLOUT =
			"http://api.klout.com/v2/identity.json/%s/%s?key=%s";

	/** Template for a request to get a score based on a Klout id. */
	public static final String SCORE_FROM_KLOUT_ID =
			"http://api.klout.com/v2/user.json/%s?key=%s";
	
	/** Template for a request to get a score based on a Klout id. */
	public static final String INFLUENCE_FROM_KLOUT_ID =
			"http://api.klout.com/v2/user.json/%s/influence?key=%s";
	
	/** Template for a request to get a score based on a Klout id. */
	public static final String TOPICS_FROM_KLOUT_ID =
			"http://api.klout.com/v2/user.json/%s/topics?key=%s";
	
	/**
	 * Sends a request to Klout, and returns a JSON response.
	 *
	 * @param request the request
	 * @return a JSON object
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static String sendRequest(String request) throws IOException {
		URL url = new URL(request);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");
		connection.setUseCaches(false);
		BufferedReader in = new BufferedReader(
				new InputStreamReader(connection.getInputStream()));
		String line;
		StringBuilder response = new StringBuilder();
		while ((line = in.readLine()) != null) {
			response.append(line);
		}
		in.close();
		return response.toString();
	}
	
}
