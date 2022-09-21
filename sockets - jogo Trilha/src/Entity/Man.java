package src.Entity;

import src.Model.TrilhaGame;

public class Man extends AbstractMan {
    public boolean isOut=false;

    public char getToken(){
        return color.toString().charAt(0);
    }
    public void setHouse(House h) { house = h; }

    public Man(TrilhaGame.Color c){ color = c; }
}
