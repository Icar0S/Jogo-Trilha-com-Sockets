package src.Entity;

import src.Model.TrilhaGame;

public abstract class AbstractPlayer {
    protected TrilhaGame.Color color;

    public abstract int readInt();
    public abstract boolean readYN();
    public TrilhaGame.Color getColour() {return this.color;}

}
