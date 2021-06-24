/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metnum;
import java.util.*;
/**
 *
 * @author Us
 */
public class MSAMSB extends SUPERCLASS{
      
    static int MAX = 100;
    static String s = "";
    
    static void DekMS(double[][] mat, int n, double b[]){
        double[][] bwh = new double[n][n];
        double[][] ats = new double[n][n];
        for (int i = 0; i < n; i++){
            for (int k = i; k < n; k++){
                int sum = 0;
                for (int j = 0; j < i; j++)
                    sum += (bwh[i][j] * ats[j][k]);
                ats[i][k] = mat[i][k] - sum;
            }
            for (int k = i; k < n; k++){
                if (i == k)
                    bwh[i][i] = 1;
                else{
                    int sum = 0;
                    for (int j = 0; j < i; j++)
                        sum += (bwh[k][j] * ats[j][i]);
                    bwh[k][i]=(mat[k][i] - sum) / ats[i][i];
                }
            }
        }
          
        double soly[] =new double[n];
        double solx[] =new double[n];
        //SOLUSI Y
        for (int r=0;r<n; r++){
            double val =0;   
            for (int c=0;c<r; c++){
                val =val +  soly[c] * bwh[r][c];     
     }    
        val = b[r] - val;
        soly[r] = val/bwh[r][r];
        }
        //SOLUSI X
        for(int r=n-1; r>=0; r--){
        double val =0;
        for(int c=n-1;c>r;c--) {
           val =val +  solx[c] *ats[r][c];  
        }
        val = soly[r] - val;
        solx[r] = val/ats[r][r]; 
      }  
        System.out.println("MSA (Matriks Segitiga Atas):");
            for(int i=0; i<n; i++)
            {
                for(int j=0; j<n; j++)
                    System.out.print(" "+bwh[i][j] +"\t");
                System.out.println();
            }
        System.out.println("MSB (Matriks Segitiga Bawah)::");
            for(int i=0; i<n; i++)
            {
                for(int j=0; j<n; j++)
                    System.out.print(" "+ats[i][j]+ "\t");
                System.out.println();
            }
            
        System.out.println("\nY: ");
        for (int i = 0; i < n; i++) {
            System.out.print("Y" + (i+1) + " = ");
            System.out.printf("%.3f ", soly[i]);
        };
        System.out.println("\nX: ");
        for (int i = 0; i < n; i++) {
            System.out.print("X" + (i+1) + " = ");
            System.out.printf("%.3f ", solx[i]);
        }
        System.out.println();   
        }
    
    
        
    @Override
    void main()
    {
        System.out.println("Masukkan ordo dari matriks nya (cth 3x3 masukkan angka 3):");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double [][]mat = new double[n][n];
        for(int i=0; i<n; i++){
            int b=i+1;
            for(int j=0; j<n; j++){
                int k=j+1;
                System.out.print("Nilai matrik ordo [" + b + "][" + k + "] = ");
                mat[i][j] = sc.nextDouble();
            }
        }
        double[] b = new double[n];
        for (int i = 0; i < n; i++){
            int ii= i+1;
            System.out.println("Masukkan Solusi persamaan baris ke "+ ii +" : ");
            b[i] = sc.nextDouble();
        }
        DekMS(mat, n, b);
    }
}
     
