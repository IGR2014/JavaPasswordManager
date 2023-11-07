package org.study.login;


// Credentials
import org.study.credentials.CredentialHardwareToken;
import org.study.credentials.ICredential;


//
public class LoginMethodHardwareToken implements ILoginMethod {

	// Метод входу у додаток доступний ?
	public boolean isAvailable() {
		// Ні
		return false;
	}

	// Перевірка даних входу
	public boolean validate(ICredential credential) throws Exception {
		//
		if (!(credential instanceof CredentialHardwareToken)) {
			//
			throw new Exception("Wrong credential type!");
		}
		//
		throw new Exception("Login method not supported yet!");
	}

}
