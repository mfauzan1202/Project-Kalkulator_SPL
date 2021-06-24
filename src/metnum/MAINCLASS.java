
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metnum;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Us
 */
public class MAINCLASS {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        Balikan tr = new Balikan();
        SUPERCLASS utama = new SUPERCLASS();
        GAUSS ga = new GAUSS();
        GAUS_JORDAN gj = new GAUS_JORDAN();
        
        MSAMSB ab =new MSAMSB();
        System.out.println("==SELAMAT DATANG DI KALKULATOR MATRIX==");
        System.out.println("MAU METODE APA NICH :");
        System.out.println("1.GAUSS ");
        System.out.println("2.GAUSS JORDAN ");
        System.out.println("3.TRANSPOS ");
        System.out.println("4.MSA/MSB ");
        int pilih = input.nextInt();
        switch(pilih){
            case 1:
            ga.main();
            break;
            case 2:
            gj.main();
            break;
            case 3:
            tr.main();
            break;
            case 4:
            ab.main();
            break;
    }
}
}