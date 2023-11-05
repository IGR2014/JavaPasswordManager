package org.study.login;


//
import org.study.credentials.CredentialLoginPassword;
import org.study.credentials.ICredential;


//
public class LoginMethodLoginPassword implements ILoginMethod {

	//
	public boolean isAvailable() {
		//
		return true;
	}

	//
	public boolean validate(ICredential credential) throws Exception {
		//
		if (!(credential instanceof CredentialLoginPassword)) {
			//
			throw new Exception("Wrong credential type!");
		}
		//
		throw new Exception("Login method not supported yet!");
	}

}
