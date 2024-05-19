package com.example.cas12;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.Random;

public class Zadatak02 extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        VBox koren = new VBox(10);
        koren.setPadding(new Insets(10));

        HBox hBoxGornji = new HBox(30);
        Label lbIspis = new Label("Ispis:");
        lbIspis.setFont(Font.font(40));
        TextArea taIspis = new TextArea();
        koren.getChildren().addAll(hBoxGornji, lbIspis, taIspis);

        // hboxgornji:
        // vb1
        VBox vBoxLevi = new VBox(10);
        Label lbIme = new Label("Unesite ime:");
        TextField tfIme = new TextField();
        Label lbGreska = new Label();
        vBoxLevi.getChildren().addAll(lbIme, tfIme, lbGreska);

        // vb2
        VBox vBoxSrednji = new VBox(10);
        Label lbPol = new Label("Pol:");
        RadioButton rbZenski = new RadioButton("zenski");
        RadioButton rbMuski = new RadioButton("muski");
        vBoxSrednji.getChildren().addAll(lbPol, rbZenski, rbMuski);

        ToggleGroup tg = new ToggleGroup();
        rbZenski.setToggleGroup(tg);
        rbMuski.setToggleGroup(tg);

        //vb3
        VBox vBoxDesni = new VBox(10);
        Button btPotvrdi = new Button("Potvrdi");
        Button btOcisti = new Button("Ocisti");
        Button btIzadji = new Button("Izadji");
        vBoxDesni.getChildren().addAll(btPotvrdi, btOcisti, btIzadji);

        hBoxGornji.getChildren().addAll(vBoxLevi, vBoxSrednji, vBoxDesni);

        // akcije
        btPotvrdi.setOnAction(e -> {
        	lbGreska.setText("");

            if (rbZenski.isSelected()) {
                lbIspis.setTextFill(Color.HOTPINK); 
            } else if (rbMuski.isSelected()) {
                lbIspis.setTextFill(Color.BLUE);
            } else {
            	lbGreska.setText("UNESITE POL!!!");
                lbGreska.setTextFill(Color.RED);
                return;
            }
            
            String ime = tfIme.getText();

            if (ime.isEmpty()) {
                lbGreska.setText("UNESITE IME!!!");
                lbGreska.setTextFill(Color.RED);
                return;
            } 
            
            String anagramZaIme = anagram(ime);
            taIspis.appendText(anagramZaIme + "\n");
            
        });

        btOcisti.setOnAction(e -> {
            tfIme.clear();
            taIspis.clear();
            lbGreska.setText("");
            lbIspis.setTextFill(Color.BLACK);

            rbZenski.setSelected(false);
            rbMuski.setSelected(false);
        });

        btIzadji.setOnAction(e -> Platform.exit());

        Scene scena = new Scene(koren, 400, 400);
        stage.setScene(scena);
        stage.setTitle("Anagrami");
        stage.show();
    }

    private String anagram(String ime) {
        char[] niz = ime.toCharArray();

        Random random = new Random();
        for (int i = 0; i < niz.length; i++) {
            int j = random.nextInt(niz.length);

            char pom = niz[i];
            niz[i] = niz[j];
            niz[j] = pom;
        }

        return String.valueOf(niz);
    }
}
