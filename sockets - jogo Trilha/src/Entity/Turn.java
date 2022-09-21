package src.Entity;

import src.Model.TrilhaGame;

import java.util.ArrayList;

public class Turn {
    ArrayList<AbstractMove> actions = new ArrayList<AbstractMove>();

    public Turn(Man man){
        makeMoveCommandsPhaseOne(man);
    }

    public Turn(ArrayList<Man> men){
        makeMoveCommandsPhaseTwo(men);
    }


    public void makeMoveCommandsPhaseTwo(ArrayList<Man> men){
        boolean success = false;
        while(success!=true){
            int menLeft = 0;
            if (TrilhaGame.getInstance().currentTurn.getColour() == TrilhaGame.Color.values()[0])
                menLeft= Board.getInstance().howManyMen(Board.getInstance().red);
            else
                menLeft=Board.getInstance().howManyMen(Board.getInstance().blue);

            if ( menLeft < TrilhaGame.MINMEN ){
                TrilhaGame.win = true;
                break;
            }

            System.out.println("Player "+TrilhaGame.getInstance().currentTurn.getColour()+", it is your turn.");
            //for more than 3, Slide
            if ( menLeft > TrilhaGame.MINMEN )
                success = makeSlideCommand(success);

            //when 3 left, can jump
            if ( menLeft == TrilhaGame.MINMEN )
                success = makeHopCommand(success);

        }
    }

    public void makeMoveCommandsPhaseOne(Man m){
        boolean success = false;
        while(success!=true){
            System.out.println("Escolha uma casa para "+TrilhaGame.getInstance().currentTurn.getColour()+" Man:");
            int destination = TrilhaGame.getInstance().currentTurn.readInt();
            Place move = new Place();
            if (move.check(destination,m)){
                move.exec();
                actions.add(move);
                makeTakeCommand(destination, actions);
                History.getInstance().save(actions);
                success=true;
            }
        }
    }

    void makeTakeCommand(int src, ArrayList<AbstractMove> actions){
        if(Mills.checkMills(src)){
            Display.getInstance().update();
            System.out.println("Você pode tirar um homem oponente. "
                    + "\nEscolha uma casa que contenha um homem oponente:");
            src = TrilhaGame.getInstance().currentTurn.readInt();
            Take move = new Take();
            while (!move.check(src)){
                src = TrilhaGame.getInstance().currentTurn.readInt();
            }
            move.exec();
            actions.add(move);
        }
    }

    boolean makeSlideCommand(boolean success){
        boolean checking = false;
        Slide move = new Slide();
        while(checking!=true){
            System.out.println("Mova uma de suas peças de sua casa."
                    + " Escolha uma casa que contenha seu homem e uma direção para deslizar:"
                    + "\n{Up:"+move.UP+", Down:"+move.DOWN+", Right:"+move.RIGHT+", left:"+move.LEFT+"}");
            int src = TrilhaGame.getInstance().currentTurn.readInt();
            int dir = TrilhaGame.getInstance().currentTurn.readInt();
            checking = move.check(src,dir);
        }
        move.exec();
        actions.add(move);
        makeTakeCommand(move.getDestination().getId(), actions);
        success=true;
        return success;
    }

    boolean makeHopCommand(boolean success){
        boolean checking = false;
        Hop move = new Hop();
        while(checking!=true){
            System.out.println("Você pode pular. "
                    + "Escolha uma casa que contenha seu homem e uma casa de destino:");
            int src = TrilhaGame.getInstance().currentTurn.readInt();
            int dst = TrilhaGame.getInstance().currentTurn.readInt();
            checking = move.check(src,dst);
        }
        move.exec();
        actions.add(move);
        makeTakeCommand(move.getDestination().getId(), actions);
        success=true;
        return success;
    }
}
