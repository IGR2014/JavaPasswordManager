package org.study.ui;


// JavaFX
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
// Credentials
import org.study.credentials.ICredential;
// Storage
import org.study.storage.*;


// Головне вікно додатку
public class MainWindow extends Stage {


	// Клас методу зберігання даних
	private IStorageMethod	mStorage;

	// Список ключів що зберігаються в базі даних
	ObservableList<String>	keys;

	// Кнопка додавання реєстраційних даних
	final Button		accountAdd		= new Button("Додати акаунт");
	// Кнопка видалення існуючих реєстраційних даних
	final Button		accountRemove		= new Button("Видалити акаунт");
	// Кнопка генерації надійного пароля
	final Button		passwordGenerate	= new Button("Згенерувати надійний пароль");


	// Конструктор
	public MainWindow(Stage owner, ICredential credential) {

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
		setTitle(owner.getTitle());

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
		gridpane.add(accountAdd, 0, 0);
		// Кнопка розташовується по лівій стороні
		GridPane.setHalignment(accountAdd, HPos.LEFT);

		// Кнопка додається в клітинку (1, 0)
		gridpane.add(accountRemove, 1, 0);
		// Кнопка розташовується по лівій стороні
		GridPane.setHalignment(accountRemove, HPos.LEFT);

		// Кнопка додається в клітинку (2, 0)
		gridpane.add(passwordGenerate, 2, 0);
		// Кнопка розташовується по лівій стороні
		GridPane.setHalignment(passwordGenerate, HPos.LEFT);

		// Клас методу зберігання даних
		mStorage = StorageMethodFactory.getInstance(credential);
		// Обновление
		keys = FXCollections.observableArrayList(mStorage.keys());

		// Список елементів для відображення
		final ListView<String> listView = new ListView<String>(keys);
		// Список додається в клітинку (0, 1)
		gridpane.add(listView, 0, 1);
		// Поле займає 4 клітини завширшки
		GridPane.setColumnSpan(listView, 4);

		// Дії при натисканні кнопки створення акаунту
		accountAdd.setOnAction(
			new EventHandler<ActionEvent>() {
				// Обробник
				@Override
				public void handle(ActionEvent event) {
					// Ділог входу у додаток
					final CredentialDialog credentialDialog = new CredentialDialog(owner);
					// Ділог по розміру вікна
					credentialDialog.sizeToScene();
					// Розмір діалогу не можна змінювати
					credentialDialog.setResizable(false);
					// Показати ділог входу
					credentialDialog.show();
					// Обновление
					keys = FXCollections.observableArrayList(mStorage.keys());
				}
			}
		);

		// Дії при натисканні кнопки видалення акаунту
		accountRemove.setOnAction(
			new EventHandler<ActionEvent>() {
				// Обробник
				@Override
				public void handle(ActionEvent event) {
					// Try
					try {
						// Отримання ключа
						String key = listView.getSelectionModel().getSelectedItem();
						// Видалення облікового запису за ключем
						mStorage.remove(key);
					}
					catch (Exception e) {
						// Відображення помилки у лог
						e.printStackTrace();
					}
					// Обновление
					keys = FXCollections.observableArrayList(mStorage.keys());
				}
			}
		);

		// Дії при натисканні кнопки генерації нового паролю
		passwordGenerate.setOnAction(
			new EventHandler<ActionEvent>() {
				// Обробник
				@Override
				public void handle(ActionEvent event) {
					// Ділог генерації паролю
					final PasswordGenerationDialog passGenDialog = new PasswordGenerationDialog(owner);
					// Ділог по розміру вікна
					passGenDialog.sizeToScene();
					// Розмір діалогу не можна змінювати
					passGenDialog.setResizable(false);
					// Показати ділог входу
					passGenDialog.show();
				}
			}
		);

		// Макет розподілу елементів додається у макет вікна
		root.getChildren().add(gridpane);

	}

	
}

