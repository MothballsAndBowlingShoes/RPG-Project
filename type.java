public class type {
    
    public static String[] typeNames = {"Fire", "Grass", "Water"};
    
    public static type[] typeList = new type[3];
    
    private String name;

    public type(String name) 
    {
        this.name = name;
    }
    
    public static void fillTypes()
    {
        for(int i = 0; i < typeNames.length; i++)
        {
            typeList[i] = new type(typeNames[i]);
        }
    }
    
    public static type[] getTypeList()
    {
        return typeList.clone();
    }

    public static void listNames()
    {
        for(int i = 0; i < typeList.length; i++)
        {
            System.out.println(typeList[i].getName());
        }
    }

    private String getName() {
        return name;
    }
}