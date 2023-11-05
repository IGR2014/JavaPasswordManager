package org.study;


// JavaFX
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.stage.Stage;
// UI
import org.study.ui.LoginDialog;
import org.study.ui.MainWindow;


// Головний клас додатку
public class Main extends Application {

	// Запуск додатку
	@Override
	public void start(Stage stage) throws Exception {

		// Іконка головного вікна додатку
		stage.getIcons().add(new Image(Main.class.getResourceAsStream("/icon.png")));
		// Заголовок головного вікна
		stage.setTitle("Супер Менеджер Паролів");

		// Ділог входу у додаток
		final LoginDialog loginDialog = new LoginDialog(stage);
		// Ділог по розміру вікна
		loginDialog.sizeToScene();
		// Розмір діалогу не можна змінювати
		loginDialog.setResizable(false);
		// Показати ділог входу
		loginDialog.show();

		// Дії при натисканні кнопки входу у додаток
		loginDialog.onSignIn(
			// Екземпляр обробника дій
			new EventHandler<ActionEvent>() {
				// Обробник
				@Override
				public void handle(ActionEvent event) {
					// Закрити логін діалог
					loginDialog.close();
					// Головне вікно додатку
					final MainWindow mainWindow = new MainWindow(stage);
					// Головне вікно по розміру вікна
					mainWindow.sizeToScene();
					// Розмір головного вікна не можна змінювати
					mainWindow.setResizable(false);
					// Показати головне вікно
					mainWindow.show();
				}
			}
		);

		// Дії при натисканні кнопки реєстрації у додатку
		loginDialog.onSignUp(
			// Екземпляр обробника дій
			new EventHandler<ActionEvent>() {
				// Обробник
				@Override
				public void handle(ActionEvent event) {
					// Закриття усіх вікон
					Platform.exit();
					// Вихід з програми
					System.exit(0);
				}
			}
		);

	}

	// Головна функція додатку
	public static void main(String[] args) {
		// Запуск UI
		launch(args);
	}

}

