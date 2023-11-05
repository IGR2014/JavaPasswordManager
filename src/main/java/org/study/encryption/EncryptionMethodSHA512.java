package org.study.encryption;


// SHA-512
import java.security.MessageDigest;


// Клас шифрування даних за методом SHA-512
public class EncryptionMethodSHA512 implements IEncryptionMethod {


	// Метод розрахунку хешу даних
	@Override
	public byte[] hash(byte[] data) {
		// Try
		try {
			// Використання стандартної утіліти SHA-512 з пакету java
			return MessageDigest.getInstance("SHA-512").digest(data);
		}
		// Catch
		catch(Exception e) {
			// Порожній масив у випадку проблем
			return new byte[] {};
		}
	}


}

