package src.Entity;

import src.Entity.AbstractMove;
import src.Entity.Board;
import src.Entity.Man;

public class Place extends AbstractMove {

    public boolean check(int adrs, Man m){
        if ( Board.getInstance().minHouseId <= adrs && adrs <= Board.getInstance().maxHouseId){
            if(Board.getInstance().getHouses().get(adrs).getMan().getColor()==null){
                destination = Board.getInstance().getHouses().get(adrs);
                man = m;
                return true;
            }
            else{
                System.out.println("A casa que você está escolhendo já foi preenchida."
                        + "\nEscolha uma casa diferente.");
                return false;
            }
        }
        else
            System.out.println("O destino escolhido não está no tabuleiro.");
        return false;
    }

    public void exec(){
        destination.setMan(man);
        man.setHouse(destination);
    }
}
