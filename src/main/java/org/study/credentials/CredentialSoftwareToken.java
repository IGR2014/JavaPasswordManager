package org.study.credentials;


// Клас збереження даних реєстрації у форматі програмного токена
public class CredentialSoftwareToken extends CredentialBase {


	// Значення програмного токена
	public byte[] mToken = null;


	// Конструктор
	public CredentialSoftwareToken(String key, byte[] token) {
		// Базовий конструктор
		super(key);
		// Збереження програмного токена
		mToken = token;
	}


	// Метод валідації даних реєстрації
	@Override
	public boolean isValid() {
		// Дані вірні коли токен не порожній
		return null != mToken;
	}


}

