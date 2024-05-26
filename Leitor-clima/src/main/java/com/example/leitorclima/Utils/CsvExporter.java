package com.example.leitorclima.Utils;

import com.example.leitorclima.Models.Boxplot;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CsvExporter {

    public static void exportToCsv(List<Boxplot> data, Stage stage) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Salvar Arquivo CSV");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("CSV Files", "*.csv"));

        File file = fileChooser.showSaveDialog(stage);
        if (file != null) {
            try (FileWriter writer = new FileWriter(file)) {
                writer.append("Indice;Limite Superior;Q3;Mediana;Q1;Limite Inferior\n");
                for (Boxplot boxplot : data) {
                    writer.append(boxplot.getIndice()).append(';')
                            .append(String.valueOf(boxplot.getLimiteSuperior())).append(';')
                            .append(String.valueOf(boxplot.getQ3())).append(';')
                            .append(String.valueOf(boxplot.getMediana())).append(';')
                            .append(String.valueOf(boxplot.getQ1())).append(';')
                            .append(String.valueOf(boxplot.getLimiteInferior())).append('\n');
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}