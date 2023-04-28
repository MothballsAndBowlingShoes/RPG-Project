public class move {
    private String name;
    private int damage;
    private type moveType;
    
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
    
    

}