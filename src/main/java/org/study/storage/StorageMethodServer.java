package org.study.storage;


//
import org.study.credentials.ICredential;


//
public class StorageMethodServer implements IStorageMethod {


	//
	public boolean isAvailable() {
		//
		return false;
	}


	//
	public boolean connectToServer(ICredential credentials) throws Exception {
		//
		throw new Exception("Server does not exists");
	}


	//
	public String[] keys() {
		//
		return new String[] {};
	}


	//
	public ICredential load(String key) throws Exception {
		//
		throw new Exception("Server does not exists");
	}

	//
	public boolean store(String key, ICredential credentials) throws Exception {
		//
		throw new Exception("Server does not exists");
	}


}