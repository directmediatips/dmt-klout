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

/**
 * The Enumeration of the supported networks, other than Klout itself.
 */
public enum Network {

	/** The twitter network. */
	TWITTER("tw"),
	
	/** The Google+ network. */
	GOOGLEPLUS("gp");
	
	/** The network value. */
	private String network;
	
	/**
	 * Creates a new <code>Network</code> instance.
	 *
	 * @param network the network
	 */
	Network(String network) {
		this.network = network;
	}
	
	/**
	 * Returns the Network value.
	 *
	 * @return the network value
	 */
	public String network() {
		return network;
	}
}
