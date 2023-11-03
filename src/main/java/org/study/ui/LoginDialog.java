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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


// Ділог входу у додаток
public class LoginDialog extends Stage {


	// Кнопка входу у додаток
	Button signIn = new Button("Sign In");

	// Кнопка реєстрації у додатку
	Button signUp = new Button("Sign Up");


	// Конструктор
	public LoginDialog(Stage owner) {

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
		setTitle(owner.getTitle() + ": Вхід у додаток");

		// Макет вікна
		final Group root = new Group();
		// Вміст вікна
		final Scene scene = new Scene(root);
		// Встановлення вмісту вікна
		setScene(scene);

		// Фіксована ширина вікна від змісту
		owner.setWidth(scene.getWidth());
		// Фіксована висота вікна від змісту
		owner.setHeight(scene.getHeight());

		// Макет розподілу елементів
		final GridPane gridpane = new GridPane();
		// Поля навколо елементів макету
		gridpane.setPadding(new Insets(10));
		// Горизонтальні поля між елементами
		gridpane.setHgap(10);
		// Вертикальні поля між елементами
		gridpane.setVgap(10);

		// Текстове поле з логіном користувача
		final Label userNameLbl = new Label("Логін: ");
		// Текстове поле додається в клітинку (0, 0)
		gridpane.add(userNameLbl, 0, 0);

		// Текстове поле з паролем користувача
		final Label passwordLbl = new Label("Пароль: ");
		// Текстове поле додається в клітинку (0, 1)
		gridpane.add(passwordLbl, 0, 1);

		// Поле редагування з логіном користувача
		final TextField userNameFld = new TextField();
		// Текстове поле додається в клітинку (1, 0)
		gridpane.add(userNameFld, 1, 0);
		// Поле займає 2 клітини завширшки
		GridPane.setColumnSpan(userNameFld, 2);

		// Поле редагування з паролем користувача
		final PasswordField passwordFld = new PasswordField();
		// Текстове поле додається в клітинку (1, 1)
		gridpane.add(passwordFld, 1, 1);
		// Поле займає 2 клітини завширшки
		GridPane.setColumnSpan(passwordFld, 2);

		// Кнопка додається в клітинку (1, 2)
		gridpane.add(signIn, 1, 2);
		// Кнопка розташовується по правій стороні
		GridPane.setHalignment(signIn, HPos.RIGHT);

		// Кнопка додається в клітинку (2, 2)
		gridpane.add(signUp, 2, 2);
		// Кнопка розташовується по правій стороні
		GridPane.setHalignment(signUp, HPos.RIGHT);

		// Макет розподілу елементів додається у макет вікна
		root.getChildren().add(gridpane);

	}


	// Метод встановлення дії входу у додаток
	public void onSignIn(EventHandler<ActionEvent> buttonHandler) {
		// Дія по натисканню на кнопку
		signIn.setOnAction(buttonHandler);
	}


	// Метод встановлення дії реєстрації у додатку
	public void onSignUp(EventHandler<ActionEvent> buttonHandler) {
		// Дія по натисканню на кнопку
		signUp.setOnAction(buttonHandler);
	}


}

