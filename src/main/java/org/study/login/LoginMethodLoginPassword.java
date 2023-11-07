package org.study.login;


// Credentials
import org.study.credentials.CredentialLoginPassword;
import org.study.credentials.ICredential;
// Storage
import org.study.storage.StorageMethodFactory;


//
public class LoginMethodLoginPassword implements ILoginMethod {

	// Метод входу у додаток доступний ?
	public boolean isAvailable() {
		// Так
		return true;
	}

	// Перевірка даних входу
	public boolean validate(ICredential credential) throws Exception {
		// Неправильний тип вхідних даних ?
		if (!(credential instanceof CredentialLoginPassword)) {
			// Виклчюення
			throw new Exception("Wrong credential type!");
		}
		// Клас методу зберігання даних
		return null != StorageMethodFactory.getInstance(credential);
	}

}
