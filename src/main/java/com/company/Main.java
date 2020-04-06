package com.company;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) throws IOException {

        JsonParser parser = new JsonParser();
        parser.convertToJson();

        double[][] array2D = new double[parser.getCompaniesList().size()][parser.getCompaniesList().size()];

        for (int i = 0; i < array2D.length; i++) {
            for (int j = 0; j < array2D.length; j++) {

                for (Companies a : parser.getCompaniesList()) {
                    for (Companies b : parser.getCompaniesList()) {
                        for (Companies c : parser.getCompaniesList()) {

                            if (a.getId() == 1 && b.getId() == 2 && c.getId() == 3) {

                                if(i==j){
                                    array2D[i][j] = 1;
                                }
                                else {
                                    if (a.getRevenue() > b.getRevenue() || a.getRevenue() > c.getRevenue() || b.getRevenue() > c.getRevenue()){
                                        array2D[i][j] = 1.5;
                                        array2D[j][i] = 0.5;
                                    }
                                    if (a.getRevenue() < b.getRevenue() || a.getRevenue() < c.getRevenue() || b.getRevenue() < c.getRevenue()){
                                        array2D[i][j] = 0.5;
                                        array2D[j][i] = 1.5;
                                    }
                                    if (a.getRevenue() == b.getRevenue() || a.getRevenue() == c.getRevenue() || c.getRevenue() == b.getRevenue()){
                                        array2D[i][j] = 1;
                                    }
                                }
                            }

                        }
                    }
                }
            }

        }
        for (int i = 0; i < array2D.length ; i++) {
            for (int j = 0; j < array2D.length ; j++) {
                System.out.print(array2D[i][j] + " ");
            }
            System.out.println();
        }

        double[] result = new double[array2D.length];
        double total;

        for (int i = 0; i < array2D.length; i++) {
                total = 0;
                for (int j = 0; j < array2D.length; j++)
                    total += array2D[i][j];
                result[i] = total;
                System.out.println(result[i]);
            }

        double[] P1 = new double[array2D.length];

        int i = 0,j = 0, k= 0;

        P1[k] = array2D[i][j] * result[0] + array2D[i][j + 1] *result[1] + array2D[i][j + 2] * result[2];
        k++;
        P1[k] = array2D[i + 1][j] * result[0] + array2D[i + 1][j + 1] * result[1] + array2D[i + 1][j + 2] * result[2];
        k++;
        P1[k] = array2D[i + 2][j] * result[0] + array2D[i + 2][j + 1] * result[1] + array2D[i + 2][j + 2] * result[2];

        double s = 0;
        for (int q=0; q<P1.length; q++) {
            s = s + P1[q];
            System.out.print(P1[q]);
            System.out.print(" ");
        }
        System.out.println("");

        double[] P2 = new double[P1.length];
        for (int a = 0; a<P1.length; a++) {
            P2[a] = P1[a] / s;
        }
        for (int b = 0; b<P2.length; b++) {
            System.out.print(P2[b]);
            System.out.print(" ");
        }



    }

}









