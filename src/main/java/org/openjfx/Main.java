package org.openjfx;


// JavaFX
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import org.study.credentials.ICredential;
// Logins
import org.study.login.ILoginMethod;
import org.study.login.LoginMethodFactory;
// UI
import org.study.ui.LoginDialog;
import org.study.ui.MainWindow;


// Головний клас додатку
public class Main extends Application {


	// Клас методу входу у додаток
	ILoginMethod mLogin = LoginMethodFactory.getInstance();


	// Запуск додатку
	@Override
	public void start(Stage stage) {

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
		// Обробник
		loginDialog.onSignIn(
			// Екземпляр обробника дій
				event -> {
					// Try
					try {
						// Користувацькі дані
						final ICredential credential = loginDialog.getCredentials();
						// Перевірка даних користувача
						if (mLogin.validate(credential)) {
							// Головне вікно додатку
							final MainWindow mainWindow = new MainWindow(stage, credential);
							// Головне вікно по розміру вікна
							mainWindow.sizeToScene();
							// Розмір головного вікна не можна змінювати
							mainWindow.setResizable(false);
							// Показати головне вікно
							mainWindow.show();
						}
					}
					catch (Exception e) {
						// Відображення помилки у лог
						e.printStackTrace();
					}
					// Закрити логін діалог
					loginDialog.close();
				}
		);

		// Дії при натисканні кнопки реєстрації у додатку
		// Обробник
		loginDialog.onSignUp(
			// Екземпляр обробника дій
				event -> {
					// Закриття усіх вікон
					Platform.exit();
					// Вихід з програми
					System.exit(0);
				}
		);

	}


	// Головна функція додатку
	public static void main(String[] args) {
		// Запуск UI
		launch(args);
	}


}

