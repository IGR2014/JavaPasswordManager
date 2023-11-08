package org.study.storage;


// Java IO
import java.nio.file.Files;
import java.nio.file.Paths;
// Java
import java.util.*;
// Credentials
import org.study.credentials.ICredential;


// Інтерфейс шо описує методі збереження паролів
public class StorageMethodFile implements IStorageMethod {


	// Конструктор
	public StorageMethodFile() {
		// Try
		try {
			// Якщо директорії для бази даних немає - створити!
			Files.createDirectories(Paths.get("storage/files/"));
		}
		// Catch
		catch (Exception e) {
			// Відображення помилки у лог
			e.printStackTrace();
		}
	}


	// Метод доступний для використання ?
	@Override
	public boolean isAvailable() {
		// Так
		return true;
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
		throw new Exception("File does not exists");
	}

	// Зберегти дані за відповідним ключем
	@Override
	public void store(ICredential credentials) throws Exception {
		//
		throw new Exception("File does not exists");
	}

	// Видалити дані за відповідним ключем
	@Override
	public void remove(String key) throws Exception {
		//
		throw new Exception("File does not exists");
	}


}