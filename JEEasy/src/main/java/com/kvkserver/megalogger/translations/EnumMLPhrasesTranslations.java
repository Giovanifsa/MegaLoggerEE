package com.kvkserver.megalogger.translations;

import com.jeeasy.engine.translations.IEnumTranslations;

public enum EnumMLPhrasesTranslations implements IEnumTranslations {
	SERVER_NAME("SERVER_NAME", "Server name"), 
	SERVER_USER("SERVER_USER", "Server user"),
	;
	
	private String translationUnit;
	private String englishTranslation;

	private EnumMLPhrasesTranslations(String translationUnit, String englishTranslation) {
		this.translationUnit = translationUnit;
		this.englishTranslation = englishTranslation;
	}

	@Override
	public String getTranslationUnit() {
		return "#PHRASE_" + translationUnit;
	}

	@Override
	public String getDefaultTranslation() {
		return englishTranslation;
	}
}
