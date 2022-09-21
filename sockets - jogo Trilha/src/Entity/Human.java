package src.Entity;

import src.Model.TrilhaGame;

import java.util.Scanner;

public class Human extends AbstractPlayer {
    private Scanner in = new Scanner(System.in);

    public Human(TrilhaGame.Color c){
        color = c;
    }

    public int readInt(){
        return in.nextInt();
    }

    public boolean readYN(){
        String response = in.next();
        if (response.charAt(0)=='Y'||response.charAt(0)=='y')
            return true;
        else if (response.charAt(0) == 'N'||response.charAt(0)=='n')
            return false;
        else{
            System.out.println("O que você digitou não fazia sentido."
                    + "\nDigite 'Y' e pressione enter ou pressione 'N' e pressione enter.");
            return readYN();
        }
    }
}
