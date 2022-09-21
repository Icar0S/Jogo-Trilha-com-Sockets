package src.Entity;

import src.Model.TrilhaGame;

import java.util.ArrayList;

public class Mills {

    //Verificando se Moinho aconteceu
    public static boolean checkMills(int id){
        House home =  Board.getInstance().getHouses().get(id);
        if (home==null)
            return false;
        House right = home.getRight();
        House farRight = null;
        if(right!=null)
            farRight = right.getRight();
        House left = home.getLeft();
        House farLeft=null;
        if (left!=null)
            farLeft= left.getLeft();
        House up = home.getUp();
        House farUp = null;
        if(up!=null)
            farUp = up.getUp();
        House down = home.getDown();
        House farDown = null;
        if(down!=null)
            farDown = down.getDown();

        if(right!=null && left!=null)
            if(home.getMan().getColor()==right.getMan().getColor()
                    && home.getMan().getColor()==left.getMan().getColor())
                return true;
        if(down!=null && up!=null)
            if(home.getMan().getColor()==up.getMan().getColor()
                    && home.getMan().getColor()==down.getMan().getColor())
                return true;
        if(down!=null && farDown!=null)
            if(home.getMan().getColor()==down.getMan().getColor()
                    && home.getMan().getColor()==farDown.getMan().getColor())
                return true;
        if(up!=null && farUp!=null)
            if(home.getMan().getColor()==up.getMan().getColor()
                    && home.getMan().getColor()==farUp.getMan().getColor())
                return true;
        if(right!=null && farRight!=null)
            if(home.getMan().getColor()==right.getMan().getColor()
                    && home.getMan().getColor()==farRight.getMan().getColor())
                return true;
        if(left!=null && farLeft!=null)
            if(home.getMan().getColor()==left.getMan().getColor()
                    && home.getMan().getColor()==farLeft.getMan().getColor())
                return true;
        return false;
    }

    //Verifique se há movimentos disponíveis
    public static boolean canMove(ArrayList<Man> men){
        int numberOfMen = Board.getInstance().howManyMen(men);
        int trappedMen = 0 ;
        for(int i=0; i<=Board.getInstance().maxHouseId; i++){
            House current = Board.getInstance().getHouses().get(i);

            //se a casa for tomada pelo homem da mesma cor
            if (current.getMan()!= Board.getInstance().nullman
                    && current.getMan().getColor() == men.get(0).getColor()){
                //System.out.println("current.id: "+current.getId()); //DEBUG
                //System.out.println("current.token: "+current.getMan().getToken()); //DEBUG
                //se os vizinhos estão livres
                if (   (current.getRight()!= null && current.getRight().getMan()== Board.getInstance().nullman)
                        || (current.getLeft() != null && current.getLeft().getMan() == Board.getInstance().nullman)
                        || (current.getUp()   != null && current.getUp().getMan()	== Board.getInstance().nullman)
                        || (current.getDown() != null && current.getDown().getMan() == Board.getInstance().nullman) )
                    continue;
                    //se nenhum vizinho estiver livre, portanto, não há espaço para se mover
                else
                    trappedMen++;
            }
        }
        //Verifique se o número de peças que não conseguem se mover é o mesmo que o total de peças (ou maior para evitar erros e falhas)
        //Considerando também que esta situação só se aplica ao slide, e não enquanto o salto está disponível.
        //System.out.println("trappedMen: "+trappedMen);//DEBUG
        if ((numberOfMen != TrilhaGame.MINMEN) && (trappedMen >= numberOfMen) ){
            TrilhaGame.win = true;
            return false;
        }
        return true;
    }

}
