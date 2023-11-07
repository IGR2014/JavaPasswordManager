package org.study.storage;


// Java
import java.util.*;
// Credentials
import org.study.credentials.ICredential;


// Інтерфейс шо описує методі збереження паролів
public interface IStorageMethod {


	// Метод доступний для використання ?
	public boolean isAvailable();


	// Перелік ключів що зберігаються
	public List<String> keys();


	// Дістати дані що зберігаються за потрібним ключем
	public List<ICredential> load(String key) throws Exception;

	// Зберегти дані за відповідним ключем
	public void store(ICredential credentials) throws Exception;

	// Видалити дані за відповідним ключем
	public void remove(String key) throws Exception;


}

