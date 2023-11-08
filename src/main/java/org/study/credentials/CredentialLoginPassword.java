package org.study.credentials;


// Клас збереження даних реєстрації у форматі Логін/Пароль
public class CredentialLoginPassword extends CredentialBase {


	// Логін користувача
	public String	mLogin;
	// Пароль користувача
	public String	mPassword;


	// Конструктор
	public CredentialLoginPassword(String key, String login, String password) {
		// Базовий конструктор
		super(key);
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

