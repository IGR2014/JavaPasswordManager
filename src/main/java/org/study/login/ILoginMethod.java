package org.study.login;


//
import org.study.credentials.ICredential;


//
public interface ILoginMethod {

	//
	public boolean isAvailable();

	//
	public boolean validate(ICredential credential) throws Exception;

}
