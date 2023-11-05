package org.study.encryption;


// Base64
import java.util.Base64;


// Клас шифрування даних за методом Base64
public class EncryptionMethodBASE64 implements IEncryptionMethod {


	// Метод розрахунку хешу даних
	@Override
	public byte[] hash(byte[] data) {
		// Використання стандартної утіліти Base64 з пакету java
		return Base64.getEncoder().encode(data);
	}


}

