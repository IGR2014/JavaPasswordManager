package org.study.login;


// Credentials
import org.study.credentials.ICredential;


// Інтерфейс методів входу у додаток
public interface ILoginMethod {

	// Метод входу у додаток доступний ?
	public boolean isAvailable();

	// Перевірка даних входу
	public boolean validate(ICredential credential) throws Exception;


}
