public class enemy {
    private entity[] party = new entity[4];

    public enemy()
    {

    }

    public void addPartyMember(String name, int level, int healthStat)
    {
        party[party.length] = new entity(name, level, healthStat);
    }
}
