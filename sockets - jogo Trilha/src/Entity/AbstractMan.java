package src.Entity;

import src.Model.TrilhaGame;

public abstract class AbstractMan {
    protected House house = null;
    protected TrilhaGame.Color color = null;
    public boolean isOut;

    public abstract char getToken();

    public House getHouse() {return house;}
    public TrilhaGame.Color getColor(){return color;}

}