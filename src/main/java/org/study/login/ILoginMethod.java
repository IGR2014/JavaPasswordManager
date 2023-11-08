package org.study.login;


// Credentials
import org.study.credentials.ICredential;


// Інтерфейс методів входу у додаток
public interface ILoginMethod {

	// Метод входу у додаток доступний ?
	boolean isAvailable();

	// Перевірка даних входу
	boolean validate(ICredential credential) throws Exception;


}
