package org.study.login;


//
import org.study.credentials.ICredential;


//
public class LoginMethodHardwareToken implements ILoginMethod {

	//
	public boolean isAvailable() {
		//
		return false;
	}

	//
	public boolean validate(ICredential credential) throws Exception {
		//
		throw new Exception("Login method not supported yet!");
	}

}
