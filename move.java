import java.util.ArrayList;
import java.util.*;

public class move {
    private String name;
    private int damage;
    private type moveType;
    private static ArrayList<type> typeList = new ArrayList<type>(List.of(new type("Fire"), new type("Grass"), new type("Water")));
    
    public move(type moveType, String name, int damage) 
    {
        this.moveType = moveType;
        this.damage = damage;
        this.name = name;
    }
    
    public int getDamage()
    {
        return damage;
    }

    public String getName()
    {
        return name;
    }

    public type getMoveType()
    {
        return moveType;
    }

    public static type getType(int index)
    {
        return typeList.get(index);
    }
    
    

}