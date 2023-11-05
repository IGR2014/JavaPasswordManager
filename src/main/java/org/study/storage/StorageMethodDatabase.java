package org.study.storage;


// SQL
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
// Java IO
import java.nio.file.Files;
import java.nio.file.Paths;
// Java utils
import java.util.*;
// Credentials
import org.study.credentials.CredentialHardwareToken;
import org.study.credentials.CredentialLoginPassword;
import org.study.credentials.CredentialSoftwareToken;
import org.study.credentials.ICredential;


// Інтерфейс шо описує методі збереження паролів
public class StorageMethodDatabase implements IStorageMethod, AutoCloseable {


	// Директорія розташування БД
	private final String	DATABASE_DIR		= "storage/database/";
	// Адреса підключення до БД
	private final String	DATABASE_ADDRESS	= "jdbc:sqlite:" + DATABASE_DIR + "secret.s3db";

	// З'єднання з БД
	private Connection	mConnection		= null;
	// Звернення до БД
	private Statement	mStatement		= null;


	// Конструктор
	public StorageMethodDatabase(CredentialLoginPassword credentials) {
		// Try
		try {
			// Якщо директорії для бази даних немає - створити!
			Files.createDirectories(Paths.get(DATABASE_DIR));
			// Потрібно для роботи з БД
			Class.forName("org.sqlite.JDBC");
			// Відкриття з'єднання з БД
			mConnection	= DriverManager.getConnection(DATABASE_ADDRESS, credentials.mLogin, credentials.mPassword);
			// Створення звернення до БД
			mStatement 	= mConnection.createStatement();
			// Створення таблиці користувачів у БД
			mStatement.executeUpdate("CREATE TABLE IF NOT EXISTS 'Users' ('ID' INTEGER PRIMARY KEY AUTOINCREMENT, 'Login' TEXT, 'Password' TEXT, 'TokenSw' TEXT, 'TokenHw' TEXT);");
			// Створення таблиці збережених паролів у БД
			mStatement.executeUpdate("CREATE TABLE IF NOT EXISTS 'Credentials' ('ID' INTEGER PRIMARY KEY AUTOINCREMENT, 'Key' TEXT, 'Login' TEXT, 'Password' TEXT, 'TokenSw' TEXT, 'TokenHw' TEXT, 'Phone' TEXT);");
		}
		// Catch
		catch (Exception e) {
			// Відображення помилки у лог
			e.printStackTrace();
		}
	}

	// Метод що спрацьовую під час знищення об'єкту
	@Override
	public void close() {
		// Try
		try {
			// Закриття з'єднання з БД
			mConnection.close();
			// Закриття звернення до БД
			mStatement.close();
		}
		// Catch
		catch (Exception e) {
			// Відображення помилки у лог
			e.printStackTrace();
		}
	}


	// Метод доступний для використання ?
	public boolean isAvailable() {
		// Так
		return true;
	}


	// Перелік ключів що зберігаються
	public List<String> keys() {
		// Try
		try {
			// Масив для збереження результатів
			List<String> keys = new ArrayList<String>();
			// Збір усіх ключів з таблиці паролів у БД
			final ResultSet result = mStatement.executeQuery("SELECT 'Keys' FROM 'Credentials';");
			// Прохід по списку результатів
			while (result.next()) {
				// Додання ключа до масиву
				keys.add(result.getString("Keys"));
			}
			// Завершення роботи з результатом
			result.close();
			// Повернення масиву ключів
			return keys;
		}
		// Catch
		catch (Exception e) {
			// Відображення помилки у лог
			e.printStackTrace();
			// Повернення порожнього масиву
			return new ArrayList<String>();
		}
	}


	// Дістати дані що зберігаються за потрібним ключем
	public List<ICredential> load(String key) throws Exception {
		// Масив для збереження результатів
		final List<ICredential> credentials = new ArrayList<ICredential>();
		// Збір усіх даних з таблиці паролів у БД
		final ResultSet result = mStatement.executeQuery("SELECT * FROM 'Credentials' WHERE 'Keys' = " + key +";");
		// Прохід по списку результатів
		while (result.next()) {
			// Зчитування апаратного токена з БД
			final byte[] tokenHw	= result.getBytes("TokenHw");
			// Зчитування програмного токена з БД
			final byte[] tokenSw	= result.getBytes("TokenSw");
			// Зчитування логіну з БД
			final String login	= result.getString("Login");
			// Зчитування паролю з БД
			final String password	= result.getString("Password");
			// Апаратний токен ?
			if (0 != tokenHw.length) {
				// Додання ключа до масиву
				credentials.add(new CredentialHardwareToken(tokenHw));
			// Програмний токен ?
			} else if (0 != tokenSw.length) {
				// Додання ключа до масиву
				credentials.add(new CredentialSoftwareToken(tokenSw));
			// Логін та пароль
			} else {
				// Додання ключа до масиву
				credentials.add(new CredentialLoginPassword(login, password));
			}
		}
		// Завершення роботи з результатом
		result.close();
		// Усі зібрані дані
		return credentials;
	}

	// Зберегти дані за відповідним ключем
	public void store(String key, ICredential credentials) throws Exception {
		// Значення апаратного токена для БД
		byte[] tokenHw	= new byte[] {};
		// Значення програмного токена для БД
		byte[] tokenSw	= new byte[] {};
		// Значення логіну для БД
		String login	= "";
		// Значення паролю для БД
		String password	= "";
		// Це апаратний токен ?
		if (credentials instanceof CredentialHardwareToken) {
			// Отримання значення апаратного токена
			tokenHw		= ((CredentialHardwareToken)credentials).mToken;
		// Це програмний токен ?
		} else if (credentials instanceof CredentialSoftwareToken) {
			// Отримання значення програмного токена
			tokenSw		= ((CredentialHardwareToken)credentials).mToken;
		// Це логін/пароль токен ?
		} else if (credentials instanceof CredentialLoginPassword) {
			// Отримання значення логіну
			login		= ((CredentialLoginPassword)credentials).mLogin;
			// Отримання значення паролю
			password	= ((CredentialLoginPassword)credentials).mPassword;
		// Це щось невідоме
		} else {
			// Виключення
			throw new Exception("Unknown credentials");
		}
		// Додання у таблицю
		mStatement.executeUpdate("INSERT INTO 'Credentials' ('TokenHw', 'TokenSw', 'Login', 'Password') VALUES (" + tokenHw + ", " + tokenSw + ", " + login + ", " + password + ");");
	}


}

