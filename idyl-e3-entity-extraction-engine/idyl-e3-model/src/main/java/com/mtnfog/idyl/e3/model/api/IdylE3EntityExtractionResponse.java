/*******************************************************************************
 * Copyright 2019 Mountain Fog, Inc.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License.  You may obtain a copy
 * of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations under
 * the License.
 ******************************************************************************/
package com.mtnfog.idyl.e3.model.api;

import java.util.Set;

import ai.idylnlp.model.entity.Entity;

/**
 * A response to an entity extraction request.
 * 
 * @author Mountain Fog, Inc.
 *
 */
public class IdylE3EntityExtractionResponse {
	
	private Set<Entity> entities;
	private long extractionTime;
		
	/**
	 * Creates a response to a request to extract entities.
	 * @param entities A collection of {@link Entity} objects.
	 * @param extractionTime The extraction time in milliseconds.
	 */
	public IdylE3EntityExtractionResponse(Set<Entity> entities, long extractionTime) {
		
		this.entities = entities;	
		this.extractionTime = extractionTime;
		
	}
	
	/**
	 * Gets the extracted entities.
	 * @return A collection of extracted entities.
	 */
	public Set<Entity> getEntities() {
		return entities;
	}

	/**
	 * Gets the time spent in milliseconds extracting the entities. This
	 * value can be monitored to maintain a certain performance level.
	 * @return The time spent in milliseconds to extract the entities.
	 */
	public long getExtractionTime() {
		return extractionTime;
	}
	
}
