package test.oauh.cz.javafxaplikace;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class HelloController {
    Random rand = new Random();
    @FXML
    private TextArea console;
    @FXML
    private TextField cislo;
    @FXML
    private Label label;

    @FXML
    protected void onGenButtonClick() {
        console.setText(String.join("\n", String.valueOf(rand.nextInt(Integer.parseInt(cislo.getText()))), console.getText()) );
    }

    @FXML
    protected void ulozit() {
        try {
            PrintWriter wr = new PrintWriter(new BufferedWriter(new FileWriter("text.txt")));
            String[] s = console.getText().split("\n");
            for (String ss: s) {
                wr.println(ss + ";");
            }

            wr.flush();
            label.setText("uspěšně uloženo");
        }catch(IOException e){
            System.err.println("Se souborem se něco stalo nevím co XD");
            label.setText("nastala chyba");
        }
    }

    @FXML
    protected void nacist(){
        String s = "";
        try(Scanner sc = new Scanner(new BufferedReader(new FileReader("text.txt")))) {
            while(sc.hasNextLine()){
                String[] ss = sc.nextLine().split(";");
                s = s + ss[0] + "\n";
            }
            console.setText(s);
            label.setText("uspěšně načteno");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}