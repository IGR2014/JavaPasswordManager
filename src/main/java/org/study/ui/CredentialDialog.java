package org.study.ui;


// JavaFX
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
// Credential
import org.study.credentials.*;
// Storage
import org.study.storage.*;


// Ділог даних акаунту
public class CredentialDialog extends Stage {


	// Кнопка відображення пароля
	final Button passShow	= new Button("Показати пароль");
	// Кнопка збереження даних
	final Button accSave	= new Button("Зберегти");

	// Поле редагування з ключем
	final TextField		keyFld		= new TextField();
	// Поле редагування з логіном користувача
	final TextField		userNameFld	= new TextField();
	// Поле редагування з паролем користувача
	final PasswordField	passwordFld	= new PasswordField();
	// Текстове поле з паролем користувача
	final Label		passwordLbl2	= new Label();


	// Конструктор
	public CredentialDialog(Stage owner) {

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
		setTitle(owner.getTitle() + ": Облікові дані");

		// Створення інтерфейсу діалога
		createUI(owner, null);

	}


	// Конструктор
	public CredentialDialog(Stage owner, ICredential credential) {

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
		setTitle(owner.getTitle() + ": Облікові дані \"" + ((CredentialBase)credential).mKey + "\"");

		// Створення інтерфейсу діалога
		createUI(owner, credential);

	}


	// Метод встановлення дії показу паролю
	public void onPasswordShow(EventHandler<ActionEvent> buttonHandler) {
		// Дія по натисканню на кнопку
		passShow.setOnAction(buttonHandler);
	}


	// Метод створення інтерфейсу діалога
	private void createUI(Stage owner, ICredential credential) {

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

		// Текстове поле з ключем
		final Label keyLbl = new Label("Ключ: ");
		// Текстове поле додається в клітинку (0, 0)
		gridpane.add(keyLbl, 0, 0);

		// Текстове поле додається в клітинку (1, 0)
		gridpane.add(keyFld, 1, 0);
		// Поле займає 2 клітини завширшки
		GridPane.setColumnSpan(keyFld, 2);

		// Кнопка додається в клітинку (0, 1)
		gridpane.add(passShow, 0, 1);
		// Кнопка розташовується по лівій стороні
		GridPane.setHalignment(passShow, HPos.LEFT);

		// Текстове поле з логіном користувача
		final Label userNameLbl = new Label("Логін: ");
		// Текстове поле додається в клітинку (0, 2)
		gridpane.add(userNameLbl, 0, 2);

		// Текстове поле з паролем користувача
		final Label passwordLbl = new Label("Пароль: ");
		// Текстове поле додається в клітинку (0, 3)
		gridpane.add(passwordLbl, 0, 3);

		// Текстове поле додається в клітинку (1, 2)
		gridpane.add(userNameFld, 1, 2);
		// Поле займає 2 клітини завширшки
		GridPane.setColumnSpan(userNameFld, 2);

		// Текстове поле додається в клітинку (1, 3)
		gridpane.add(passwordFld, 1, 3);
		// Поле займає 2 клітини завширшки
		GridPane.setColumnSpan(passwordFld, 2);

		// Текстове поле додається в клітинку (1, 4)
		gridpane.add(passwordLbl2, 1, 4);
		// Поле займає 2 клітини завширшки
		GridPane.setColumnSpan(passwordLbl2, 2);

		// Нема даних акаунту - створення нового
		if (null == credential) {
			// Кнопка додається в клітинку (1, 6)
			gridpane.add(accSave, 1, 6);
			// Кнопка розташовується по правый стороні
			GridPane.setHalignment(accSave, HPos.RIGHT);
		}

		// Дії при натисканні кнопки відображення паролю
		// Обробник
		passShow.setOnAction(
				event -> {
					// Якщо строка порожня
					if (passwordLbl2.getText().isEmpty()) {
						// Відобразити поточний пароль
						passwordLbl2.setText(passwordFld.getText());
					} else {
						// Инакше порожня строка
						passwordLbl2.setText("");
					}
				}
		);

		// Дії при натисканні кнопки збереження даних
		// Обробник
		accSave.setOnAction(
				event -> {
					// Try
					try {
						// Збереження нових даних
						StorageMethodFactory.getInstance(null).store(new CredentialLoginPassword(keyFld.getText(), userNameFld.getText(), passwordFld.getText()));
					} catch (Exception e) {
						// Відображення помилки у лог
						e.printStackTrace();
					}
					// Закриття діалогу
					close();
				}
		);

		// Макет розподілу елементів додається у макет вікна
		root.getChildren().add(gridpane);

	}


}

