/*
 *
 * Copyright 2015 magiclen.org
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package org.magiclen.autourl;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;
import org.magiclen.autourl.pages.Main;

/**
 * 可將網址以HTML超連結表示。
 *
 * @author Magic Len
 */
public class AutoURL extends Application {

    // -----類別常數-----
    private final static int WIDTH = 500;
    private final static int HEIGHT = 350;

    // -----類別變數-----
    private static Stage primaryStage;
    private static Scene primaryScene;
    private static Main main;

    // -----物件方法-----
    /**
     * 當應用程式執行的時候。
     *
     * @param primaryStage 傳入主要的舞台
     */
    @Override
    public void start(final Stage primaryStage) {
	main = new Main();
	AutoURL.primaryScene = new Scene(main, WIDTH, HEIGHT, Color.WHITESMOKE);
	AutoURL.primaryStage = primaryStage;

	primaryStage.setResizable(true);
	primaryStage.setTitle("AutoURL to HTML");
	primaryStage.setScene(AutoURL.primaryScene);

	//螢幕置中
	final Rectangle2D screen = Screen.getPrimary().getVisualBounds();
	primaryStage.setX((screen.getWidth() - WIDTH) / 2);
	primaryStage.setY((screen.getHeight() - HEIGHT) / 2);

	primaryStage.show();
    }

    /**
     * 程式進入點。
     *
     * @param args 傳入參數(用不到)
     */
    public static void main(final String[] args) {
	launch(args);
    }

}
