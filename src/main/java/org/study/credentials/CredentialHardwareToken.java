package org.study.credentials;


// Клас збереження даних реєстрації у форматі апаратного токена
public class CredentialHardwareToken implements ICredential {


	// Значення апаратного токена
	public byte[] mToken = null;


	// Конструктор
	public CredentialHardwareToken(byte[] token) {
		// Збереження апаратного токена
		mToken = token;
	}


	// Метод валідації даних реєстрації
	@Override
	public boolean isValid() {
		// Дані вірні коли токен не порожній
		return null != mToken;
	}


}

