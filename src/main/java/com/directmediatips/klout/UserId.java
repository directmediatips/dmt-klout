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

import org.json.JSONObject;

/**
 * Class that stores a {@link User}'s ID, and the network where this ID is used.
 */
public class UserId {

	/** The id on a specific network. */
	protected String id;
	
	/** The network value. */
	protected String network = "ks";
	
	/**
	 * Creates a new <code>UserId</code> instance.
	 * 
	 * @param id the Klout id
	 */
	public UserId(String id) {
		this.id = id;
	}
	
	/**
	 * Creates a new <code>UserId</code> instance from a JSON object.
	 *
	 * @param json the json response of a request that returns a user id
	 */
	public UserId(JSONObject json) {
		id = json.getString("id");
		network = json.getString("network");
	}
	
	/**
	 * Gets the user id on a specific network.
	 *
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Gets the network value.
	 *
	 * @return the network
	 */
	public String getNetwork() {
		if (isKloutId()) return "klout";
		return network;
	}
	
	/**
	 * Checks if the id is a Klout id.
	 * 
	 * @return true, if the network is "ks"
	 */
	public boolean isKloutId() {
		return "ks".equals(network);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return String.format("%s: %s", network, id);
	}
}
