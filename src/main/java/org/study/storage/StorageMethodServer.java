package org.study.storage;


// Java
import java.util.*;
// Credentials
import org.study.credentials.ICredential;


// Інтерфейс шо описує методі збереження паролів
public class StorageMethodServer implements IStorageMethod {


	// Конструктор
	public StorageMethodServer(ICredential credentials) {
		// TODO:
	}


	// Метод доступний для використання ?
	public boolean isAvailable() {
		// Ні
		return false;
	}


	// Перелік ключів що зберігаються
	public List<String> keys() {
		//
		return new ArrayList<String> ();
	}


	// Дістати дані що зберігаються за потрібним ключем
	public List<ICredential> load(String key) throws Exception {
		//
		throw new Exception("Server does not exists");
	}

	// Зберегти дані за відповідним ключем
	public void store(String key, ICredential credentials) throws Exception {
		//
		throw new Exception("Server does not exists");
	}


}