package org.study.storage;


// Credentials
import org.study.credentials.*;


// Фабрика-сінглтон створення даних входу у додаток
public final class StorageMethodFactory {


	// Об'єкт зберігача даних
	private static IStorageMethod mInstance;


	// Доступ до об'єкта зберігача даних
	public static synchronized IStorageMethod getInstance(ICredential credential) {
		// Об'єкт зберігача даних ще не створений ?
		if (null == mInstance) {
			// Перевірка типу переданих даних
			if (credential instanceof CredentialLoginPassword) {
				// Створення об'єкта зберігача даних
				mInstance = new StorageMethodDatabase((CredentialLoginPassword)credential);
			}
			// Перевірка типу переданих даних
			else if (credential instanceof CredentialHardwareToken) {
				// Створення об'єкта зберігача даних
			}
			// Перевірка типу переданих даних
			else if (credential instanceof CredentialSoftwareToken) {
				// Створення об'єкта зберігача даних
			}
		}
		// Повернення об'єкта зберігача даних
		return mInstance;
	}


}

