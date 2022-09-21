package src.Entity;

import src.Model.TrilhaGame;

public class Slide extends AbstractMove {
    //A numeração a seguir é baseada na localização dos números no teclado numérico.
    //Aumento do aspecto de qualidade de usabilidade.
    final int UP = 2;
    final int LEFT = 4;
    final int RIGHT = 6;
    final int DOWN = 8;

    //verifique se o slide é possível
    public boolean check(int src, int direction){
        if ( Board.getInstance().minHouseId <= src && src <= Board.getInstance().maxHouseId){
            source = Board.getInstance().getHouses().get(src);

            if (Board.getInstance().getHouses().get(src).getMan().getColor()
                    != TrilhaGame.getInstance().currentTurn.getColour()){
                System.out.println("Escolha uma casa que pertence a você.");
                return false;
            }
            man = (Man) source.getMan();
            //ou, mude para uma casa em um dos vizinhos id
            switch(direction){
                case UP:
                    destination = source.getUp();
                    break;
                case LEFT:
                    destination = source.getLeft();
                    break;
                case RIGHT:
                    destination = source.getRight();
                    break;
                case DOWN:
                    destination = source.getDown();
                    break;
                default:
                    //print.out algo errado
                    System.out.println("Insira uma direção válida\n.");
                    return false;
            }

            if (destination!= null)
                if (destination.getMan().equals(Board.getInstance().nullman))
                    return true;
                else
                    System.out.println("O destino escolhido não está vazio.");
            else
                System.out.println("Escolher um vizinho existente!");
            return false;
        }
        else
            System.out.println("O destino escolhido não está no tabuleiro.");
        return false;
    }

    //execute o movimento
    public void exec(){
        destination.setMan(man);
        man.setHouse(destination);
        source.setMan(Board.getInstance().nullman);
    }
}
