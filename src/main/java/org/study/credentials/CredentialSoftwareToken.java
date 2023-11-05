package org.study.credentials;


// Клас збереження даних реєстрації у форматі програмного токена
public class CredentialSoftwareToken implements ICredential {


	// Значення програмного токена
	public byte[] mToken = null;


	// Конструктор
	public CredentialSoftwareToken(byte[] token) {
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

