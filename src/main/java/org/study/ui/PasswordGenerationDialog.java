package org.study.ui;


// JavaFX
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
// Java
import java.time.LocalDateTime;
import java.util.Random;
// Encryption
import org.study.encryption.EncryptionMethodFactory;
import org.study.encryption.IEncryptionMethod;


// Ділог даних акаунту
public class PasswordGenerationDialog extends Stage {


	// Кнопка перегенерації пароля
	final Button	passRegen	= new Button("Згенерувати знов");
	// Кнопка копіювання пароля
	final Button	passCopy	= new Button("Скопіювати");

	// Поле редагування з логіном користувача
	final TextField	generatedFld	= new TextField();


	// Конструктор
	public PasswordGenerationDialog(Stage owner) {

		// Виклик конструктора базового класу
		super();
		// Вказівка на батьківський клас
		initOwner(owner);

		// Іконки діалогу беруться з батьківського вікна
		owner.getIcons().forEach(icon ->
			// Копіювання іконок
			getIcons().add(icon)
		);
		// Заголовок головного вікна додатку
		setTitle(owner.getTitle() + ": Генерація надійного пароля");

		// Макет вікна
		final Group root = new Group();
		// Вміст вікна
		final Scene scene = new Scene(root);
		// Встановлення вмісту вікна
		setScene(scene);

		// Макет розподілу елементів
		final GridPane gridpane = new GridPane();
		// Поля навколо елементів макету
		gridpane.setPadding(new Insets(10));
		// Горизонтальні поля між елементами
		gridpane.setHgap(10);
		// Вертикальні поля між елементами
		gridpane.setVgap(10);

		// Фіксована ширина вікна від змісту
		owner.setWidth(gridpane.getWidth());
		// Фіксована висота вікна від змісту
		owner.setHeight(gridpane.getHeight());

		// Кнопка додається в клітинку (0, 0)
		gridpane.add(passRegen, 0, 0);
		// Кнопка розташовується по лівій стороні
		GridPane.setHalignment(passRegen, HPos.LEFT);

		// Кнопка додається в клітинку (1, 0)
		gridpane.add(passCopy, 1, 0);
		// Кнопка розташовується по лівій стороні
		GridPane.setHalignment(passCopy, HPos.LEFT);

		// Текстове поле додається в клітинку (0, 1)
		gridpane.add(generatedFld, 0, 1);
		// Поле займає 2 клітини завширшки
		GridPane.setColumnSpan(generatedFld, 2);

		// Генерація паролю
		generatePass();

		// Дії при натисканні кнопки перегенерації паролю
		// Обробник
		passRegen.setOnAction(
				event -> {
					// Генерація паролю
					generatePass();
				}
		);

		// Дії при натисканні кнопки копіювання паролю
		// Обробник
		passCopy.setOnAction(
				event -> {
					// Отримання системного буферу обміну
					Clipboard clipboard = Clipboard.getSystemClipboard();
					// Ствоерння контексту буферу обміну
					ClipboardContent content = new ClipboardContent();
					// Копіювання паролю у контекст буферу обміну
					content.putString(generatedFld.getText());
					// Встановленн контексту буферу обміну
					clipboard.setContent(content);
				}
		);

		// Макет розподілу елементів додається у макет вікна
		root.getChildren().add(gridpane);

	}


	// Метод генерації паролю
	private void generatePass() {
		// Try
		try {
			// SHA-512
			final IEncryptionMethod encryptionSHA512 = EncryptionMethodFactory.getInstance("SHA512");
			// Base64
			final IEncryptionMethod encryptionBASE64 = EncryptionMethodFactory.getInstance("BASE64");
			// Випадкове число + поточні локальні дата та час
			final String salt = new Random().nextDouble() + " " + LocalDateTime.now().toString();
			// Генерація хєшу
			final byte[] hash = encryptionSHA512.hash(encryptionBASE64.hash(salt.getBytes()));
			// Згенерований пароль у HEX виді
			StringBuilder hexString = new StringBuilder(2 * hash.length);
			for (byte b : hash) {
				String hex = String.format("%02x", b);
				hexString.append(hex);
			}
			// Передача користувачу
			generatedFld.setText(hexString.toString());
		}
		catch (Exception e) {
			// Відображення помилки у лог
			e.printStackTrace();
		}
	}


}

