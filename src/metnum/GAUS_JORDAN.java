/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metnum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;
/**
 *
 * @author Us
 */
public class GAUS_JORDAN extends SUPERCLASS {
    static int M = 10; 
    static int Hitung(float a[][], int n){ 
        int i, j, k = 0, c, t = 0, m = 0; 
        float pro = 0; 
        for (i = 0; i < n; i++){
            if (a[i][i] == 0){
                c = 1; 
                while (a[i + c][i] == 0 && (i + c) < n)  
                    c++;          
                    if ((i + c) == n){ 
                        t = 1; 
                        break; 
                    }
                    for (j = i, k = 0; k <= n; k++){ 
                        float temp =a[j][k]; 
                        a[j][k] = a[j+c][k]; 
                        a[j+c][k] = temp; 
                    } 
                }
                for (j = 0; j < n; j++){
                    if (i != j){
                        float p = a[j][i] / a[i][i]; 
                        for (k = 0; k <= n; k++)                  
                        a[j][k] = a[j][k] - (a[i][k]) * p;            
                    } 
                } 
        }
    return t; 
    }
    
    static void HasilMatrix(float a[][], int n) 
    { 
        for (int i = 0; i < n; i++)  
        { 
            for (int j = 0; j <= n; j++)  
            System.out.printf("%.3f ", a[i][j]); 
            System.out.println(); 
        } 
    }
    static void Hasil(float a[][], int n, int t) 
    {
        System.out.println("X: "); 
        if (t == 2)    
        System.out.println("Ada solusi tak terhingga");  
        else if (t == 3)   
        System.out.println("Tidak ada solusi!"); 
      
        // print dengan membagi konstanta dari masing
        // masing element diagonal 
        else { 
                for (int i = 0; i < n; i++){
                    System.out.println("\nX" + (i+1) + " : ");
                    System.out.printf("%.3f ", a[i][n] / a[i][i]);
                }
                System.out.println("");
            } 
    }
    static int CekKonsisten(float a[][], int n, int t) 
    {
        int i, j; 
        float sum;
        t = 3; 
        for (i = 0; i < n; i++)  
        { 
            sum = 0; 
            for (j = 0; j < n; j++)   
                sum = sum + a[i][j]; 
                if (sum == a[i][j])  
                t = 2;     
        } 
    return t; 
    }

    @Override
    void main() throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.print("Tentukan Ordo Matriks (baris): ");
        int b = input.nextInt();

        System.out.print("Tentukan Ordo Matriks (kolom): ");
        int k = input.nextInt();
        
        float a[][] = new float[b][k];
        for (int brs = 0; brs < b; brs++) {
            int brss=brs+1;
        for (int klm = 0; klm < k; klm++) {
            int klmm=klm+1;
        System.out.print("Nilai matrik ordo [" + brss + "][" + klmm + "] = ");
        a[brs][klm] = input.nextFloat();        
        }
        }

        System.out.print("Matrik yang anda inputkan adalah = \n");
        for (int brs = 0; brs < b; brs++) {
        for (int klm = 0; klm < k; klm++) {
        System.out.print(a[brs][klm] + "\t");
        }
        System.out.println();
        }
        // Order of Matrix(n) 
        int n = b, t = 0; 

        // Performing Matrix transformation 
        t = Hitung(a, n); 
      
        if (t == 1)    
            t = CekKonsisten(a, n, t);  
  
        // Printing Final Matrix 
        System.out.println("Hasil akhir matrix nya adalah : "); 
        HasilMatrix(a, n); 
        System.out.println(""); 
      
        // Printing Solutions(if exist) 
        Hasil(a, n, t);
    }
}