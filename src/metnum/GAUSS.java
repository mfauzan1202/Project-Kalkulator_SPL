/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metnum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author Us
 */
class GAUSS extends SUPERCLASS {
    public void solve(double[][] A, double[] B){
        int N = B.length;
        for (int k = 0; k < N; k++){
            int max = k;
            for (int i = k + 1; i < N; i++) 
                if (Math.abs(A[i][k]) > Math.abs(A[max][k])) 
                    max = i;
  
                    double[] temp = A[k]; 
                    A[k] = A[max]; 
                    A[max] = temp;
 
                    double t = B[k]; 
                    B[k] = B[max]; 
                    B[max] = t;
 
                    
                    for (int i = k + 1; i < N; i++){
                        double factor = A[i][k] / A[k][k];
                        B[i] -= factor * B[k];
                        for (int j = k; j < N; j++) 
                        A[i][j] -= factor * A[k][j];
                        }
            }
        TampilEs(A, B);
 
        double[] solusi = new double[N];
        for (int i = N - 1; i >= 0; i--){
            double sum = 0.0;
            for (int j = i + 1; j < N; j++) 
                sum += A[i][j] * solusi[j];
                solusi[i] = (B[i] - sum) / A[i][i];
        }        
        Hasil(solusi);
    }

    public void TampilEs(double[][] A, double[] B)
    {
        int N = B.length;
        System.out.println("\nHasil matriks nya adalah : ");
        for (int i = 0; i < N; i++)
           {
               for (int j = 0; j < N; j++)
                   System.out.printf("%.3f ", A[i][j]);
               System.out.printf("| %.3f\n", B[i]);
           }
           System.out.println();
    }
    
    
    public void Hasil(double[] sol)
    {
        int N = sol.length;
        System.out.println("\nX: ");
        for (int i = 0; i < N; i++) {
            System.out.print("X" + (i+1) + " = ");
            System.out.printf("%.3f ", sol[i]);
        }
        System.out.println();     
    }
 
    @Override
    void main() throws IOException {
        GAUSS ge = new GAUSS();
        Scanner input = new Scanner(System.in);
        System.out.print("Tentukan Ordo Matriks (baris): ");
        int baris = input.nextInt();
        System.out.print("Tentukan Ordo Matriks (kolom): ");
        int kolom = input.nextInt();        
        double A[][] = new double[baris ][kolom ];
        for (int brs = 0; brs < baris; brs++) {
            int brss=brs+1;
        for (int klm = 0; klm < kolom; klm++) {
            int klmm=klm+1;
        System.out.print("Nilai matrik ordo [" + brss + "][" + klmm + "] = ");
        A[brs][klm] = input.nextFloat();        
        }
        }
        String txtSolusi[] = new String[baris ];
        double[] B = new double[baris];
        for (int i = 0; i < baris; i++){
            int ii= i+1;
            System.out.println("Masukkan Solusi persamaan baris ke "+ ii +" : ");
            B[i] = input.nextDouble();
        }
        ge.solve(A,B);
    }
    
    
}
