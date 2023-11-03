package org.study.ui;


// JavaFX
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;


// Головне вікно додатку
public class MainWindow extends Stage {


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

	}

	
}

