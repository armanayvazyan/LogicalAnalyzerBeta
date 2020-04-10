package com.company;

import java.io.IOException;
import java.util.ArrayList;

import static com.company.Analizer.AnaliseWithGivenParameters;
import static com.company.Analizer.setSize;

public class Main {


    public static void main(String[] args) throws IOException {

        JsonParser parser = new JsonParser();
        parser.convertToJson();

        Analizer analizer = new Analizer();

        ArrayList<Companie> companiesList = parser.getCompanieList();
        for (Companie company : companiesList) {
            if (!company.isChecked()) {
                companiesList.remove(company);
            }
        }

        ArrayList<Attribute> attributeList = parser.getAttributeList();
        for (Attribute attribute : attributeList) {
            if (!attribute.isChecked()) {
                attributeList.remove(attribute);
            }
        }

//        setSize(companiesList.size());

        double[][] p = new double[attributeList.size()][companiesList.size()];
        int k = 0;
        for (Attribute attribute : attributeList) {
            p[k++] = AnaliseWithGivenParameters(companiesList, attribute);
        }
    }
}









