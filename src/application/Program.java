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
import model.exceptions.DomainException;

/**
 *
 * @author docinel
 */
public class Program {

    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Room Number:");
            int number = sc.nextInt();
            System.out.print("CheckIn date (dd/MM/yyyy): ");
            Date checkIn = sdf.parse(sc.next());
            System.out.print("CheckOut date (dd/MM/yyyy): ");
            Date checkOut = sdf.parse(sc.next());

            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println("Reserva: " + reservation);

            System.out.println("-----------------------------");
            System.out.println("Entre com as novas Datas:");
            System.out.print("CheckIn date (dd/MM/yyyy): ");
            checkIn = sdf.parse(sc.next());
            System.out.print("CheckOut date (dd/MM/yyyy): ");
            checkOut = sdf.parse(sc.next());    

            reservation.updateDates(checkIn, checkOut);
            System.out.println("Reserva: " + reservation);

            sc.close();
        } catch (ParseException e) {
            System.out.println("Formato da Data inválido");
        } catch (DomainException e) {
            System.out.println("Erro na Reserva: " + e.getMessage());
        }
        catch(RuntimeException e){
            System.out.println("Erro inesperado!");
        }

    }
}
