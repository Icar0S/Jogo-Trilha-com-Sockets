package src.Entity;

import src.Model.TrilhaGame;

public class Take extends AbstractMove {

    //verifique se o movimento é válido.
    public boolean check(int src){
        if ( Board.getInstance().minHouseId <= src && src <= Board.getInstance().maxHouseId){
            //se a casa escolhida estiver vazia ou se o homem escolhido for igual ao jogador
            if (Board.getInstance().getHouses().get(src).getMan() == Board.getInstance().nullman){
                System.out.println("A casa escolhida está vazia. Escolha outro.");
                return false;
            }

            if (Board.getInstance().getHouses().get(src).getMan().getColor() == TrilhaGame.getInstance().currentTurn.getColour()){
                System.out.println("A casa escolhida contém seu próprio homem. Escolha outro.");
                return false;
            }
            //se estão todos em moinhos, então o homem pode ser removido
            if(!allmills() && Mills.checkMills(src)){
                System.out.println("A casa escolhida contém um homem que já está em um moinho."
                        + "\nVocê não pode remover isso. Escolha outro");
                return false;
            }
            source = Board.getInstance().getHouses().get(src);
            man = (Man) source.getMan();
            return true;
        }
        else
            System.out.println("O destino escolhido não está no quadro. Escolha outro");
        return false;
    }

    //Execute o movimento. Retire o man
    public void exec(){
        man.isOut=true;
        man.setHouse(null);
        //definir a casa para nullman
        source.setMan(Board.getInstance().nullman);
    }

    public boolean allmills(){
        //Tambem deve verificar se todos estao no Moinho, remova do Moinho
        if(TrilhaGame.getInstance().currentTurn.getColour() == TrilhaGame.Color.values()[0]){
            int counter = 0;
            int howmany = 0;
            for(Man m:Board.getInstance().blue){
                //se o man ainda não foi removido
                if(m.getHouse()!=null){
                    if(Mills.checkMills(m.getHouse().getId()))
                        counter++;
                    howmany++;
                }
            }
            if (counter < howmany)
                return false;
        }
        else{
            int counter = 0;
            int howmany = 0;

            for(Man m:Board.getInstance().red){
                if(m.getHouse()!=null){
                    if(Mills.checkMills(m.getHouse().getId()))
                        counter++;
                }
                howmany++;
            }
            if (counter < howmany)
                return false;
        }
        return true;
    }
}
