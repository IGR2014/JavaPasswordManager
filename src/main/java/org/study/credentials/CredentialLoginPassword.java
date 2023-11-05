package org.study.credentials;


// Клас збереження даних реєстрації у форматі Логін/Пароль
public class CredentialLoginPassword implements ICredential {


	// Логін користувача
	String	mLogin		= null;
	// Пароль користувача
	String	mPassword	= null;


	// Конструктор
	public CredentialLoginPassword(String login, String password) {
		// Збереження логіну
		mLogin		= login;
		// Збереження паролю
		mPassword	= password;
	}


	// Метод валідації даних реєстрації
	@Override
	public boolean isValid() {
		// Дані вірні коли і логін, і пароль не порожні
		return	(null != mLogin)	&&
			(null != mPassword)	&&
			!mLogin.isEmpty()	&&
			!mPassword.isEmpty();
	}


}

