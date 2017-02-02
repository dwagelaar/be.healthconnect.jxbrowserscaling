package be.healthconnect.be.healthconnect.jxbrowserscaling;

import com.teamdev.jxbrowser.chromium.Browser;
import com.teamdev.jxbrowser.chromium.BrowserCore;
import com.teamdev.jxbrowser.chromium.internal.Environment;
import com.teamdev.jxbrowser.chromium.javafx.BrowserView;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * Main JavaFX application.
 */
public class App extends Application {

	/**
	 * Main method.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Application.launch(App.class, args);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void start(final Stage primaryStage) throws Exception {
		final Browser browser = new Browser();
		final BrowserView browserView = new BrowserView(browser);
		browserView.setStyle("-fx-border-style: solid;");

		final HBox buttonRow = new HBox(new Button("button 1"), new Button("button 2"));
		buttonRow.setPadding(new Insets(10.0));
		buttonRow.setSpacing(10.0);
		buttonRow.setStyle("-fx-border-style: solid;");

		final BorderPane pane = new BorderPane();
		pane.setCenter(browserView);
		pane.setBottom(buttonRow);
		pane.setPrefSize(1024.0, 768.0);

		final Scene scene = new Scene(pane);
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.toFront();

		browser.loadURL("https://www.teamdev.com/jxbrowser");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void init() throws Exception {
		if (Environment.isMac()) {
			BrowserCore.initialize();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void stop() throws Exception {
		BrowserCore.shutdown();
	}

}
