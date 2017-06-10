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
 * Class that bundles all available information about a Klout topic.
 */
public class Topic {

	/** The topic's id. */
	protected long id;
	
	/** The name of the topic. */
	protected String name;
	
	/** The display name of the topic. */
	protected String displayName;
	
	/** Helper to build an URL for the topic. */
	protected String slug;
	
	/** The display type. */
	protected String displayType;
	
	/** The image URL. */
	protected String imageUrl;
	
	/**
	 * Creates a new {@link Topic} instance.
	 *
	 * @param json JSON object containing the topic's data
	 */
	public Topic(JSONObject json) {
		id = json.getLong("id");
		name = json.getString("name");
		displayName = json.getString("displayName");
		slug = json.getString("slug");
		displayType = json.getString("displayType");
		imageUrl = json.getString("imageUrl");
	}
	
	/**
	 * Gets the id of the topic.
	 *
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * Gets the name of the topic.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gets the display name of the topic.
	 *
	 * @return the display name
	 */
	public String getDisplayName() {
		return displayName;
	}

	/**
	 * Gets a helper name to construct an URL for the topic.
	 *
	 * @return the slug
	 */
	public String getSlug() {
		return slug;
	}

	/**
	 * Gets the display type of the topic.
	 *
	 * @return the display type
	 */
	public String getDisplayType() {
		return displayType;
	}

	/**
	 * Gets the image URL.
	 *
	 * @return the image URL
	 */
	public String getImageUrl() {
		return imageUrl;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder(displayName);
		sb.append(String.format("\nid: %s\n", id));
		sb.append(name);
		sb.append(" (");
		sb.append(slug);
		sb.append(")\n");
		sb.append(displayType);
		sb.append("\n");
		sb.append(imageUrl);
		return sb.toString();
	}
}
