/*******************************************************************************
 * Copyright 2017 Viridian Software Limited
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package com.elefana.esqs;

public class EsQueryTerm implements EsQueryExpression {
	private final boolean phrase;
	private final String term;

	public EsQueryTerm(boolean phrase, String term) {
		super();
		this.phrase = phrase;

		if(phrase) {
			this.term = term.substring(1, term.length() - 1);
		} else {
			this.term = term;
		}
	}

	public boolean isPhrase() {
		return phrase;
	}

	public String getTerm() {
		return term;
	}

	@Override
	public void walk(EsFieldQuery field, EsQueryStringWalker walker) {
		walker.append(field, phrase, term);
	}
}
