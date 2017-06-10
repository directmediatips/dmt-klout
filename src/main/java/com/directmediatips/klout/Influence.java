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

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Class with lists of Klout influencers and influencees.
 */
public class Influence {
	
	/** A {@link User} list of influencers. */
	protected List<User> myInfluencers = new ArrayList<User>();
	
	/** A {@link User} list of influencees. */
	protected List<User> myInfluencees = new ArrayList<User>();
	
	/**
	 * Creates a new {@link Influence} instance.
	 * 
	 * @param	json	a JSON object containing influencers and influencees.
	 */
	public Influence(JSONObject json) {
		parseInfluence(json.getJSONArray("myInfluencers"), myInfluencers);
		parseInfluence(json.getJSONArray("myInfluencees"), myInfluencees);
	}

	/**
	 * Parses a JSON array, and adds the {@link User} objects found in that array
	 * to a list.
	 * 
	 * @param	array	the JSON array that needs to be parsed
	 * @param	list	the list to which the {@link User} objects need to be added
	 */
	private void parseInfluence(JSONArray array, List<User> list) {
		int count = array.length();
		for (int i = 0; i < count; i++) {
			list.add(new User(array.getJSONObject(i).getJSONObject("entity").getJSONObject("payload")));
		}
	}
	
	/**
	 * Gets the list of {@link User}s that are influencers.
	 * @return the influencers
	 */
	public List<User> getMyInfluencers() {
		return myInfluencers;
	}

	/**
	 * Gets the list of {@link User}s that are influencees.
	 * @return the influencees
	 */
	public List<User> getMyInfluencees() {
		return myInfluencees;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder("Influencers:\n\n");
		for (User user : myInfluencers) {
			sb.append(user);
			sb.append("\n");
		}
		sb.append("\nInfluencees:\n\n");
		for (User user : myInfluencees) {
			sb.append(user);
			sb.append("\n");
		}
		return sb.toString();
	}
}
