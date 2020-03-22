package com.kvkserver.megalogger.services.validators;

import com.jeeasy.engine.services.validators.AbstractCRUDValidator;
import com.kvkserver.megalogger.database.entities.Server;
import com.kvkserver.megalogger.translations.EnumMLPhrasesTranslations;

public class ServerValidator extends AbstractCRUDValidator<Server> {
	@Override
	public void validateRequiredFields(Server entity) {
		checkField(entity.getName(), getTranslator().translateForContextLanguage(EnumMLPhrasesTranslations.SERVER_NAME));
		checkField(entity.getUser(), getTranslator().translateForContextLanguage(EnumMLPhrasesTranslations.SERVER_USER));
	}
}
