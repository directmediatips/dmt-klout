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
 * Class that bundles all the user data available on Klout, except influence and topics.
 */
public class User {

	/** The screen name on Klout. */
	protected String nick;
	
	/** The {@link UserId} on Klout. */
	protected UserId id;
	
	/** The Klout score bucket. */
	protected String bucket;
	
	/** The Klout score. */
	protected double score;
	
	/** The day delta. */
	protected double dayChange;
	
	/** The week deltq. */
	protected double weekChange;
	
	/** The month delta. */
	protected double monthChange;
	
	/**
	 * Creates a new {@link User} instance.
	 *
	 * @param json a JSON object obtained from the Klout API
	 */
	public User(JSONObject json) {
		nick = json.getString("nick");
		id = new UserId(json.getString("kloutId"));
		JSONObject scores = json.getJSONObject("score");
		bucket = scores.getString("bucket");
		score = scores.getDouble("score");
		JSONObject scoreDeltas = json.getJSONObject("scoreDeltas");
		dayChange = scoreDeltas.getDouble("dayChange");
		weekChange = scoreDeltas.getDouble("weekChange");
		monthChange = scoreDeltas.getDouble("monthChange");
	}
	
	/**
	 * Gets the screen name on the Klout network.
	 * @return the nick
	 */
	public String getNick() {
		return nick;
	}

	/**
	 * Gets the id on the Klout network.
	 * @return the id
	 */
	public UserId getId() {
		return id;
	}

	/**
	 * Gets the range of the Klout score.
	 * @return the bucket
	 */
	public String getBucket() {
		return bucket;
	}

	/**
	 * Gets the Klout score.
	 * @return the score
	 */
	public double getScore() {
		return score;
	}

	/**
	 * Gets the score delta over the last day.
	 * @return the dayChange
	 */
	public double getDayChange() {
		return dayChange;
	}

	/**
	 * Gets the score delta over the last week.
	 * @return the weekChange
	 */
	public double getWeekChange() {
		return weekChange;
	}

	/**
	 * Gets the score delta over the last month.
	 * @return the monthChange
	 */
	public double getMonthChange() {
		return monthChange;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder(nick);
		sb.append("\n");
		sb.append(id);
		sb.append("\nBucket: ");
		sb.append(bucket);
		sb.append("; ");
		sb.append(score);
		sb.append("\nChange: day: ");
		sb.append(dayChange);
		sb.append("; week: ");
		sb.append(weekChange);
		sb.append("; month: ");
		sb.append(monthChange);
		return sb.toString();
	}
}
