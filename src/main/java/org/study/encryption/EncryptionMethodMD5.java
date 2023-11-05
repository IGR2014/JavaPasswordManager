package org.study.encryption;


// MD5
import java.security.MessageDigest;


// Клас шифрування даних за методом MD5
public class EncryptionMethodMD5 implements IEncryptionMethod {


	// Метод розрахунку хешу даних
	@Override
	public byte[] hash(byte[] data) {
		// Try
		try {
			// Використання стандартної утіліти MD5 з пакету java
			return MessageDigest.getInstance("MD5").digest(data);
		}
		// Catch
		catch(Exception e) {
			// Порожній масив у випадку проблем
			return new byte[] {};
		}
	}


}

