/*******************************************************************************
 * Copyright 2018 Mountain Fog, Inc.
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
package com.mtnfog.renku.services;

import java.io.IOException;
import java.io.InputStream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import ai.idylnlp.model.nlp.language.LanguageDetectionException;
import ai.idylnlp.model.nlp.language.LanguageDetectionResponse;
import ai.idylnlp.nlp.language.opennlp.OpenNLPLanguageDetector;
import com.mtnfog.renku.model.LanguageDetectionRequest;
import com.mtnfog.renku.model.services.LanguageDetectionService;

@Component
public class OpenNLPLanguageDetectionService implements LanguageDetectionService {
	
	private static final Logger LOGGER = LogManager.getLogger(OpenNLPLanguageDetectionService.class);
	
	private OpenNLPLanguageDetector detector;
	
	public OpenNLPLanguageDetectionService() throws IOException {
		
		final InputStream in = new ClassPathResource("langdetect-183.bin").getInputStream();
		
		detector = new OpenNLPLanguageDetector(in);
		
		in.close();
		
	}
	
	@Override
	public LanguageDetectionResponse detect(LanguageDetectionRequest request) throws LanguageDetectionException {

		return detector.detectLanguage(request.getText(), request.getLimit());

	}

	@Override
	public String[] languages() {

		final String[] languages = new String[]{"afr", "ara", "ast", "aze", "bak", "bel", "ben", "bos", "bre", "bul", "cat", "ceb", "ces", "che", "cmn", "cym", "dan", "deu", "ekk", "ell", "eng", "epo", "est", "eus", "fao", "fas", "fin", "fra", "fry", "gle", "glg", "gsw", "guj", "heb", "hin", "hrv", "hun", "hye", "ind", "isl", "ita", "jav", "jpn", "kan", "kat", "kaz", "kir", "kor", "lat", "lav", "lim", "lit", "ltz", "lvs", "mal", "mar", "min", "mkd", "mlt", "mon", "mri", "msa", "nan", "nds", "nep", "nld", "nno", "nob", "oci", "pan", "pes", "plt", "pnb", "pol", "por", "pus", "ron", "rus", "san", "sin", "slk", "slv", "som", "spa", "sqi", "srp", "sun", "swa", "swe", "tam", "tat", "tel", "tgk", "tgl", "tha", "tur", "ukr", "urd", "uzb", "vie", "vol", "war", "zul"};
		
		return languages;
		
	}

}
