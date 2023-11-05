package org.study.ui;


// JavaFX
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
// Credentials
import org.study.credentials.CredentialLoginPassword;
// Storage
import org.study.storage.*;


// Головне вікно додатку
public class MainWindow extends Stage {


	// Клас методу зберігання даних
	IStorageMethod mStorage = StorageMethodFactory.getInstance(new CredentialLoginPassword("admin", "admin"));


	// Кнопка додавання реєстраційних даних
	final Button accountAdd		= new Button("Додати акаунт");
	// Кнопка видалення існуючих реєстраційних даних
	final Button accountRemove	= new Button("Видалити акаунт");


	// Конструктор
	public MainWindow(Stage owner) {

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
		final Scene scene = new Scene(root, 800, 600);
		// Встановлення вмісту вікна
		setScene(scene);

		// Фіксована ширина вікна від змісту
		owner.setWidth(scene.getWidth());
		// Фіксована висота вікна від змісту
		owner.setHeight(scene.getHeight());

		// Макет розподілу елементів
		final GridPane gridpane = new GridPane();
		// Розмір макету під розмір вікна
		gridpane.setPrefSize(owner.getWidth(), owner.getHeight());
		// Поля навколо елементів макету
		gridpane.setPadding(new Insets(10));
		// Горизонтальні поля між елементами
		gridpane.setHgap(10);
		// Вертикальні поля між елементами
		gridpane.setVgap(10);

		// Кнопка додається в клітинку (0, 0)
		gridpane.add(accountAdd, 0, 0);
		// Кнопка розташовується по лівій стороні
		GridPane.setHalignment(accountAdd, HPos.LEFT);

		// Кнопка додається в клітинку (1, 0)
		gridpane.add(accountRemove, 1, 0);
		// Кнопка розташовується по лівій стороні
		GridPane.setHalignment(accountRemove, HPos.LEFT);

		// Список ключів що зберігаються в базі даних
		final ObservableList<String> keys = FXCollections.observableArrayList(mStorage.keys());
		// Список елементів для відображення
		final ListView<String> listView = new ListView<String>(keys);
		// Список додається в клітинку (0, 1)
		gridpane.add(listView, 0, 1);
		// Поле займає 4 клітини завширшки
		GridPane.setColumnSpan(listView, 4);

		// TODO:

		// Макет розподілу елементів додається у макет вікна
		root.getChildren().add(gridpane);

	}

	
}

