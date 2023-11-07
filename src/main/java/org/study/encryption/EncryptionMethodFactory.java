package org.study.encryption;


// Фабрика-сінглтон створення об'єкта шифрування
public final class EncryptionMethodFactory {


	// Об'єкт шифрування
	private static IEncryptionMethod mInstance;


	// Доступ до об'єкта шифрування
	public static synchronized IEncryptionMethod getInstance(String name) {
		// Об'єкт шифрування ще не створений ?
		if (null == mInstance) {
			// Перевірка типу переданих даних
			if (name == "BASE64") {
				// Створення об'єкта шифрування
				mInstance = new EncryptionMethodBASE64();
			}
			// Перевірка типу переданих даних
			else if (name == "SHA256") {
				// Створення об'єкта шифрування
				mInstance = new EncryptionMethodSHA256();
			}
			// Перевірка типу переданих даних
			else if (name == "SHA512") {
				// Створення об'єкта шифрування
				mInstance = new EncryptionMethodSHA512();
			}
			// Перевірка типу переданих даних
			else if (name == "MD5") {
				// Створення об'єкта шифрування
				mInstance = new EncryptionMethodMD5();
			}
			// Незнайомий метод
			else {
				// Створення об'єкта шифрування
				mInstance = null;
			}
		}
		// Повернення об'єкта шифрування
		return mInstance;
	}


}

