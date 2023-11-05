package org.study.encryption;


// SHA-256
import java.security.MessageDigest;


// Клас шифрування даних за методом SHA-256
public class EncryptionMethodSHA256 implements IEncryptionMethod {


	// Метод розрахунку хешу даних
	@Override
	public byte[] hash(byte[] data) {
		// Try
		try {
			// Використання стандартної утіліти SHA-256 з пакету java
			return MessageDigest.getInstance("SHA-256").digest(data);
		}
		// Catch
		catch(Exception e) {
			// Порожній масив у випадку проблем
			return new byte[] {};
		}
	}


}

