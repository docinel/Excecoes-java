/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import model.entities.Reservation;

/**
 *
 * @author docinel
 */
public class Program {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Room Number:");
        int number = sc.nextInt();
        System.out.print("CheckIn date (dd/MM/yyyy): ");
        Date checkIn = sdf.parse(sc.next());
        System.out.print("CheckOut date (dd/MM/yyyy): ");
        Date checkOut = sdf.parse(sc.next());
        
        if(!checkOut.after(checkIn)){
            System.out.println("Erro na Reserva: Saída precisa ser depois da Entrada");
        }
        else{
            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println("Reserva: " + reservation);
            
            System.out.println("-----------------------------");
            System.out.println("Entre com as novas Datas:");
            System.out.print("CheckIn date (dd/MM/yyyy): ");
            checkIn = sdf.parse(sc.next());
            System.out.print("CheckOut date (dd/MM/yyyy): ");
            checkOut = sdf.parse(sc.next());
            
            String error = reservation.updateDates(checkIn, checkOut);
            if(error !=null){
                System.out.println("Erro na reserva: " + error);
            }
            else{
            System.out.println("Reserva: " + reservation);
            }
        }
        sc.close();
    }
    
}
