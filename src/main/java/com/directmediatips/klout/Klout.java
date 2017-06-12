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

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Class that allows access to the Klout API.
 */
public class Klout {
	
	/** The api key you registered with Klout. */
	private String apiKey;
	
	/**
	 * Creates a new {@link Klout} instance.
	 *
	 * @param apiKey an api key registered with Klout
	 */
	public Klout(String apiKey) {
		this.apiKey = apiKey;
	}
	
	/**
	 * Gets a {@link User} object based on a {@link UserId}.
	 *
	 * @param id the {@link UserId}
	 * @return a {@link User} object
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public User getUser(UserId id) throws IOException {
		return new User(new JSONObject(KloutRequests.sendRequest(String.format(
				KloutRequests.SCORE_FROM_KLOUT_ID, getUserId(id).getId(), apiKey))));
	}
	
	/**
	 * Gets an {@link Influence} object based on a {@link UserId}.
	 *
	 * @param id the id
	 * @return an {@link Influence} object
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public Influence getInfluence(UserId id) throws IOException {
		return new Influence(new JSONObject(KloutRequests.sendRequest(String.format(
				KloutRequests.INFLUENCE_FROM_KLOUT_ID, getUserId(id).getId(), apiKey))));
	}
	
	/**
	 * Gets a list of {@link Topic} objects based on a {@link UserId}.
	 *
	 * @param id the id
	 * @return a list of {@link Topic} objects
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public List<Topic> getTopics(UserId id) throws IOException {
		List<Topic> topics = new ArrayList<Topic>();
		JSONArray array = new JSONArray(KloutRequests.sendRequest(String.format(
				KloutRequests.TOPICS_FROM_KLOUT_ID, getUserId(id).getId(), apiKey)));
		int n = array.length();
		for (int i = 0; i < n; i++) {
			topics.add(new Topic(array.getJSONObject(i)));
		}
		return topics;
	}
	
	/**
	 * Gets a {@link UserId} for a specific network, given a {@link UserId} on another network.
	 *
	 * @param id a {@link UserId} of another network
	 * @param network the specific network
	 * @return the {@link UserId} on the specific network
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public UserId getUserId(UserId id, Network network) throws IOException {
		return new UserId(new JSONObject(KloutRequests.sendRequest(String.format(
				KloutRequests.ID_FROM_KLOUT_TO_NETWORK, id.getNetwork(), id.getId(), network.network(), apiKey))));
	}
	
	/**
	 * Gets the {@link UserId} on Klout.
	 *
	 * @param id the {@link UserId} on another network
	 * @return the {@link UserId} on the Klout network
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public UserId getUserId(UserId id) throws IOException {
		if (id.isKloutId()) {
			return id;
		}
		return new UserId(new JSONObject(KloutRequests.sendRequest(String.format(
				KloutRequests.ID_FROM_NETWORK_TO_KLOUT, id.getNetwork(), id.getId(), apiKey))));
	}
	
	/**
	 * Gets the {@link UserId} of a Klout user, given a Twitter screen name.
	 *
	 * @param screenName the twitter screen name
	 * @return the {@link UserId}
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public UserId getUserIdFromTwitterScreenName(String screenName) throws IOException {
		return new UserId(new JSONObject(KloutRequests.sendRequest(String.format(
				KloutRequests.ID_FROM_TWITTER_SCREENNAME, screenName, apiKey))));
	}

}
