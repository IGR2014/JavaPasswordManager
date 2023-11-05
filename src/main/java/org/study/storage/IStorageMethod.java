package org.study.storage;


//
import org.study.credentials.ICredential;


//
public interface IStorageMethod {


	//
	public boolean isAvailable();


	//
	public String[] keys();


	//
	public ICredential load(String key) throws Exception;

	//
	public boolean store(String key, ICredential credentials) throws Exception;


}

