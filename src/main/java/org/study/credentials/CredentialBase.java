package org.study.credentials;


// Базовий клас даних акаунта з спільним полем
public abstract class CredentialBase implements ICredential {


	// Ключ даних
	public String mKey = "";


	// Конструктор
	public CredentialBase(String key) {
		// Збереження ключа
		mKey = key;
	}


}

