package org.study.login;


// Фабрика-сінглтон створення методу входу у додаток
public final class LoginMethodFactory {


	// Об'єкт метода входу
	private static ILoginMethod mInstance;


	// Доступ до об'єкта методу входу
	public static synchronized ILoginMethod getInstance() {
		// Об'єкт метода входу ще не створений ?
		if (null == mInstance) {
			// Створення об'єкта метода входу
			mInstance = new LoginMethodLoginPassword();
		}
		// Повернення об'єкта метода входу
		return mInstance;
	}


}

