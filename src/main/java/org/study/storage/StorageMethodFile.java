package org.study.storage;


//
import org.study.credentials.ICredential;


//
public class StorageMethodFile implements IStorageMethod {


	//
	public boolean isAvailable() {
		//
		return true;
	}


	//
	public String[] keys() {
		//
		return new String[] {};
	}


	//
	public ICredential load(String key) throws Exception {
		//
		throw new Exception("File does not exists");
	}

	//
	public boolean store(String key, ICredential credentials) throws Exception {
		//
		throw new Exception("File does not exists");
	}


}