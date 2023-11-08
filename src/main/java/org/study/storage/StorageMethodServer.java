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
	@Override
	public boolean isAvailable() {
		// Ні
		return false;
	}


	// Перелік ключів що зберігаються
	@Override
	public List<String> keys() {
		//
		return new ArrayList<> ();
	}


	// Дістати дані що зберігаються за потрібним ключем
	@Override
	public List<ICredential> load(String key) throws Exception {
		//
		throw new Exception("Server does not exists");
	}

	// Зберегти дані за відповідним ключем
	@Override
	public void store(ICredential credentials) throws Exception {
		//
		throw new Exception("Server does not exists");
	}

	// Видалити дані за відповідним ключем
	@Override
	public void remove(String key) throws Exception {
		//
		throw new Exception("Server does not exists");
	}


}