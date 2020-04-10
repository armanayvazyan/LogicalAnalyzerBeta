package com.company;

import java.util.ArrayList;

public class Analizer {

    //    public static int size;
    private static double[][] array2D;


//    public static void setSize(int size) {
//        Analizer.size = size;
//    }

    static public double[] AnaliseWithGivenParameters(ArrayList<Companie> companies, Attribute attribute) {
        int size = companies.size();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int first = companies.get(i).getAttribute(attribute);
                int second = companies.get(j).getAttribute(attribute);

                array2D[i][j] = first >= second ? (first == second ? 1 : 1.5) : 0.5;

                double[] P = new double[array2D.length];
                double[] result = new double[array2D.length];
                double total;
                for (int m = 0; m < array2D.length; m++) {
                    total = 0;
                    for (int n = 0; n < array2D.length; n++)
                        total += array2D[m][n];
                    result[m] = total;
                }
                int x = 0, y = 0, z = 0;
                P[z] = array2D[x][y] * result[0] + array2D[x][y + 1] * result[1] + array2D[x][y + 2] * result[2];
                z++;
                P[z] = array2D[x + 1][y] * result[0] + array2D[x + 1][y + 1] * result[1] + array2D[x + 1][y + 2] * result[2];
                z++;
                P[z] = array2D[x + 2][y] * result[0] + array2D[x + 2][y + 1] * result[1] + array2D[x + 2][y + 2] * result[2];

                double s = 0;
                for (int q = 0; q < P.length; q++) {
                    s = s + P[q];
                }
                double[] PNRelative = new double[P.length];
                for (int u = 0; u < P.length; u++) {
                    PNRelative[u] = P[u] / s;
                }
                return PNRelative;
            }

            public double[][] getArray2D () {
                return array2D;
            }

        }
    }
}