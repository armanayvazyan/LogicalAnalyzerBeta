package com.company;

import java.util.ArrayList;

class Analyser {

    static double[] AnaliseWithGivenParameters(ArrayList<Company> companies, Attribute attribute) {
        int size = companies.size();
        double[][] array2D = new double[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int first = companies.get(i).getAttribute(attribute);
                int second = companies.get(j).getAttribute(attribute);

                array2D[i][j] = first >= second ? (first == second ? 1 : 1.5) : 0.5;
            }
        }

        double[] result = new double[size];
        for (int m = 0; m < array2D.length; m++) {
            double total = 0;
            for (int n = 0; n < array2D.length; n++)
                total += array2D[m][n];
            result[m] = total;
        }

        double[] p = new double[size];

        for (int i = 0; i < size; i++) {
            p[i] = 0;
            for (int j = 0; j < size; j++) {
                p[i] += result[j] * array2D[i][j];
            }
        }

        double sum = 0;
        for (int i = 0; i < size; i++) {
            sum += p[i];
        }

        double[] PNRelative = new double[size];

        for (int i = 0; i < size; i++) {
            PNRelative[i] = p[i] / sum;
        }

        System.out.println();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(array2D[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        for (int i = 0; i < size; i++) {
            System.out.print(result[i] + " ");
        }

        System.out.println();
        for (int i = 0; i < size; i++) {
            System.out.print(p[i] + " ");
        }

        System.out.println();
        for (int i = 0; i < size; i++) {
            System.out.print(PNRelative[i] + " ");
        }
        System.out.println();
        return PNRelative;
    }
}

