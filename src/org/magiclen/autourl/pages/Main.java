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
package org.magiclen.autourl.pages;

import java.util.Scanner;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

/**
 * 主頁面。
 *
 * @author Magic Len
 */
public class Main extends VBox {

    // -----類別常數-----
    private static final int GAP = 5;

    // -----類別初始-----
    // -----類別變數-----
    // -----物件變數-----
    private final Insets insets;
    private final TextArea taPure, taHTML;
    private final Button bCopy;

    // -----建構子-----
    /**
     * 建構子，初始化容器。
     */
    public Main() {
	insets = new Insets(GAP, GAP, GAP, GAP);

	// GUI元件
	taPure = new TextArea();
	taHTML = new TextArea();
	bCopy = new Button("Copy");
	bCopy.setMaxWidth(Integer.MAX_VALUE);

	taPure.textProperty().addListener((e) -> {
	    final Scanner sc = new Scanner(taPure.getText().trim());
	    final StringBuilder sb = new StringBuilder();

	    while (sc.hasNext()) {
		if (sb.length() > 0) {
		    sb.append("<br />\n");
		}
		String s = sc.nextLine().trim();
		if (s.equals("")) {
		    continue;
		}
		sb.append("<a href=\"").append(s).append("\">").append(s).append("</a>"); //Output format
	    }
	    taHTML.setText(sb.toString());
	});
	taHTML.setEditable(false);
	bCopy.setOnAction((e) -> {
	    // 複製結果到剪貼簿
	    final Clipboard clipboard = Clipboard.getSystemClipboard();
	    final ClipboardContent content = new ClipboardContent();
	    content.putString(taHTML.getText());
	    clipboard.setContent(content);
	});

	VBox.setMargin(taPure, insets);
	VBox.setMargin(taHTML, insets);
	VBox.setMargin(bCopy, insets);
	VBox.setVgrow(taPure, Priority.ALWAYS);
	VBox.setVgrow(taHTML, Priority.ALWAYS);
	VBox.setVgrow(bCopy, Priority.SOMETIMES);
	final ObservableList<Node> children = getChildren();
	children.addAll(taPure, taHTML, bCopy);
    }

}
