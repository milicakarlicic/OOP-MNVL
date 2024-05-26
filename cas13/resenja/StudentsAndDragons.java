package resenja;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

public class StudentsAndDragons extends Application {
    // VODITI RACUNA NA ISPITU O KLASNIM POLJIMA!
    // ako se ne inicijalizuju -> NullPointerException
    private List<Heroj> heroji = new LinkedList<>();
    private static boolean ucitano = false;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        HBox koren = new HBox(10);
        koren.setPadding(new Insets(10));

        VBox vbLevi = new VBox(10);
        VBox vbDesni = new VBox(10);
        koren.getChildren().addAll(vbLevi, vbDesni);

        // vbLevi
        Label lbIme = new Label("Ime");
        TextField tfIme = new TextField();
        Label lbKlasa = new Label("Klasa");

        RadioButton rbRatnik = new RadioButton("Ratnik");
        RadioButton rbMag = new RadioButton("Mag");
        ToggleGroup tg1 = new ToggleGroup();
        rbRatnik.setToggleGroup(tg1);
        rbMag.setToggleGroup(tg1);

        Label lbRasa = new Label("Rasa");
        RadioButton rbCovek = new RadioButton("Covek");
        RadioButton rbVilenjak = new RadioButton("Vilenjak");
        RadioButton rbPatuljak = new RadioButton("Patuljak");
        ToggleGroup tg2 = new ToggleGroup();
        rbCovek.setToggleGroup(tg2);
        rbVilenjak.setToggleGroup(tg2);
        rbPatuljak.setToggleGroup(tg2);

        Button btNapraviLika = new Button("Napravi lika");

        vbLevi.getChildren().addAll(
                lbIme, tfIme, lbKlasa,
                rbRatnik, rbMag, lbRasa,
                rbCovek, rbVilenjak, rbPatuljak, btNapraviLika
        );

        // vbDesni
        Button btUcitaj = new Button("Ucitaj likove");
        Button btNajjaci = new Button("Prikazi 3 najjacih");
        Button btVilenjaci = new Button("Prikazi samo vilenjake");
        Button btRatnici = new Button("Prikazi samo ratnike");
        TextArea taIspis = new TextArea();

        vbDesni.getChildren().addAll(
                btUcitaj, btNajjaci,
                btVilenjaci, btRatnici, taIspis
        );

        // akcije
        btUcitaj.setOnAction(x -> {
            taIspis.clear();
            if (!ucitano) {
                Path putanja = Paths.get("heroji.txt");

                // Scanner domaci
                try {
                    List<String> linije = Files.readAllLines(putanja);

                    for (String linija : linije) {
                        // razdvajamo liniju po zadatom stringu:
                        String[] niz = linija.split(",");

                        // r,Geralt,5050,covek,15,12,13,11,10,11
                        // Heroj
                        String ime = niz[1];
                        Nivo nivo = new Nivo(Integer.parseInt(niz[2]));
                        Rasa rasa = Rasa.napraviRasu(niz[3]);
                        int snaga = Integer.parseInt(niz[4]);
                        int spretnost = Integer.parseInt(niz[5]);
                        int konstitucija = Integer.parseInt(niz[6]);
                        int inteligencija = Integer.parseInt(niz[7]);
                        int mudrost = Integer.parseInt(niz[8]);
                        int harizma = Integer.parseInt(niz[9]);
                        AtributiHeroja atributiHeroja =
                                new AtributiHeroja(
                                        snaga, spretnost, inteligencija, konstitucija,
                                        mudrost, harizma
                                );

                        if (niz[0].equals("r")) {
                            // herojratnik
                            Heroj heroj = new HerojRatnik(
                                    ime, nivo, rasa, atributiHeroja
                            );
                            heroji.add(heroj);
                        } else {
                            // mag
                            Heroj heroj = new HerojMag(
                                    ime, nivo, rasa, atributiHeroja
                            );
                            heroji.add(heroj);
                        }
                    }
                } catch (IOException e) {
                    System.err.println(e.getMessage());
                }

                ucitano = true;

                heroji.sort(Heroj.komparator);
            }

            ispisiHeroje(taIspis);
        });

        btVilenjaci.setOnAction(x -> {
            taIspis.clear();
            if (!ucitano) {
                System.err.println("NIJE UCITANO");
                return;
            }

            for (Heroj heroj : heroji) {
                if (heroj.getRasa().equals(Rasa.Vilenjak)) {
                    taIspis.appendText(heroj.toString());
                }
            }
        });

        btRatnici.setOnAction(x -> {
            taIspis.clear();
            if (!ucitano) {
                System.err.println("NIJE UCITANO");
                return;
            }

            for (Heroj heroj : heroji) {
                if (heroj instanceof HerojRatnik) {
                    taIspis.appendText(heroj.toString());
                }
            }
        });

        btNapraviLika.setOnAction(x -> {
            String ime = tfIme.getText();
            Rasa rasa;
            if (rbCovek.isSelected()) {
                rasa = Rasa.Covek;
            } else if (rbPatuljak.isSelected()) {
                rasa = Rasa.Patuljak;
            } else {
                rasa = Rasa.Vilenjak;
            }

            if (rbRatnik.isSelected()) {
                Heroj heroj = new HerojRatnik(ime,
                        Nivo.napraviNivo1(), rasa,
                        AtributiHeroja.pocetniAtributiRatnik());
                heroji.add(heroj);
            } else {
                Heroj heroj = new HerojMag(ime,
                        Nivo.napraviNivo1(), rasa,
                        AtributiHeroja.pocetniAtributiMag());
                heroji.add(heroj);
            }


            heroji.sort(Heroj.komparator);
            ispisiHeroje(taIspis);
        });

        btNajjaci.setOnAction(x -> {
            taIspis.clear();
            if (!ucitano) {
                System.err.println("NIJE UCITANO");
                return;
            }

            // sortiramo opadajuce po snazi i ispisemo prva 3
            heroji.sort(Heroj.komparatorSnage);
            for (int i = 0; i < 3; i++) {
                taIspis.appendText(heroji.get(i).toString());
            }

            // vratimo poredjenje objekata u listi na staro
            heroji.sort(Heroj.komparator);

            // drugi nacin: linearno proci kroz listu i naci 3 najjaca
        });

        // scena
        Scene scena = new Scene(koren, 700, 500);
        stage.setScene(scena);
        stage.setTitle("Students and Dragons - S'n'D");
        stage.show();
    }

    private void ispisiHeroje(TextArea taIspis) {
        for (Heroj heroj : heroji) {
            taIspis.appendText(heroj.toString());
        }
    }
}
