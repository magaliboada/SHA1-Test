/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hash;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
/**
 *
 * @author Magali
 */
public class Hash {

    public static Scanner lectura = new Scanner (System.in);
    public static void main(String[] args) {
		
	MessageDigest md = null;
        
	String password = "";
        int opcio=0;
        try {
            
            do{
                
                System.out.println();
                
                
                opcio=menu();
                switch(opcio)
                {
                    
                    case 1:
                   System.out.print("Introduce la contrasenya: ");
                   password = lectura.next();
                    md= MessageDigest.getInstance("SHA-1");
                    md.update(password.getBytes());
                    byte[] mb = md.digest();
                    System.out.println(convertirHexa(mb));
                        break;
                    case 2:
                    System.out.print("Introduce la contrasenya: ");
                    password = lectura.next();
                    md= MessageDigest.getInstance("MD5");
                    md.update(password.getBytes());
                    mb = md.digest();
                    System.out.println(convertirHexa(mb));
                    break;
                 }   
            }while(opcio!=0);
            } 
        catch (NoSuchAlgorithmException e) {
            //Error
        
            
            //SHA-512
            
            }
            }
        public static String convertirHexa(byte[] datos) {
		String resultado = "";
		for (int i = 0; i < datos.length; i++) {
			resultado += String.format("%02X", datos[i]) + " ";
			if ((i != 0) && (i % 16 == 0)) resultado += "\n"; 
		}
		return resultado;
	}

    private static int menu() {
        int opcio=0;
        System.out.println("1. Convertir contrasenya a sha1");
        System.out.println("2. Convertir contrasenya a md5");
        System.out.println("0. Salir");
        System.out.print("Selecciona una opcion: ");
        opcio = lectura.nextInt();
        return opcio;
     }
 
}

