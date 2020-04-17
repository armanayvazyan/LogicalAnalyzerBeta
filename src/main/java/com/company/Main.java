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

        double[] pp = AnaliseWithGivenParameters(attributeList);

        double[] finalResults = new double[companiesList.size()];

        for (int i = 0; i < companiesList.size(); i++) {
            finalResults[i] = 0;
            for (int j = 0; j < attributeList.size(); j++) {
                finalResults[i] += pp[j] * p[j][i];
            }
        }
        System.out.println("WINNING COMPANY NAME");
        System.out.println();
        double max = finalResults[0];;
        for (int i = 0; i < finalResults.length; i++) {
            if(i>0){
                if(finalResults[i] > max)
                    max = finalResults[i];
            }
        }
        int index =0;
        for(double q : finalResults){
            if(q == max){
                System.out.println(companiesList.get(index).getName());
            } else
                index++;
        }
    }
}









