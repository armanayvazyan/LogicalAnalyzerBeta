package com.company;

import java.io.IOException;
import java.util.ArrayList;

import static com.company.Analyser.AnaliseWithGivenParameters;

public class Main {
    public static void main(String[] args) throws IOException {
        JsonParser parser = new JsonParser();
        parser.convertToJson();

        ArrayList<Company> companiesList = parser.getCompaniesList();
        companiesList.removeIf(company -> !company.isChecked());

        ArrayList<Attribute> attributeList = parser.getAttributeList();
        attributeList.removeIf(attribute -> !attribute.isChecked());

        double[][] p = new double[attributeList.size()][companiesList.size()];
        int k = 0;
        for (Attribute attribute : attributeList) {
            p[k++] = AnaliseWithGivenParameters(companiesList, attribute);
        }

        System.out.println("ATTRIBUTES");
        double[] pp = AnaliseWithGivenParameters(attributeList);

        double[] finalResults = new double[companiesList.size()];
        for (int i = 0; i < companiesList.size(); i++) {
            finalResults[i] = 0;
            for (int j = 0; j < attributeList.size(); j++) {
                finalResults[i] += pp[j] * p[i][j];
            }
        }

        System.out.println();
        for (double q : finalResults) {
            System.out.print(q + " ");
        }
    }
}









