package com.company;

import java.util.Scanner;

public class Criteria
{
    public static void main(String[] args) {
        AHP ahp = new AHP();

        int n;
        int NUMBER_COMPARISON;
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Enter the number of criteria");
        System.out.println("n=");
        n = keyboard.nextInt();
        NUMBER_COMPARISON = (n * n - n) / 2;

        double[][] a = new double[n][n];
        String[] criteria = new String[n];
        double[] p = new double[NUMBER_COMPARISON];//used to hold the values of comparisons

        System.out.println("Enter the criteria:");
        for (int i = 0; i < n; i++) {
            System.out.print("Criterion " + (i + 1) + ":");
            criteria[i] = keyboard.next();
        }

        System.out.println("Enter the comparison");
        int m = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                System.out.println("Compare " + criteria[i] + " with " + criteria[j] + ":");
                p[m] = keyboard.nextDouble();
                m++;
            }
        }

        a = ahp.initialize_matrix(p);
        ahp.show_matrix(a);
    }
}
