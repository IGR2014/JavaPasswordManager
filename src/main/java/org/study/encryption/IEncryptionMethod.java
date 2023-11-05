package org.study.encryption;


// Базовий інтерфейс шифрування даних за методом Base64
public interface IEncryptionMethod {


	// Метод розрахунку хешу даних
	public byte[] hash(byte[] data);


}

