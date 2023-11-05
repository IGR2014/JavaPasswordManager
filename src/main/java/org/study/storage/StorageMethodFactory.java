package org.study.storage;


// Credentials
import org.study.credentials.CredentialLoginPassword;


//
public final class StorageMethodFactory {


	//
	private static IStorageMethod mInstance;


	//
	public static synchronized IStorageMethod getInstance(CredentialLoginPassword credential) {
		//
		if (null == mInstance) {
			//
			mInstance = new StorageMethodDatabase(credential);
		}
		//
		return mInstance;
	}


}

