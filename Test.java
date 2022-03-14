package HashMap.com;

public class Test {
    public static void main(String[] args) {
        // @TODO: we need an int hash to place value in the map

        CustomHashMap customHashMap = new CustomHashMap(10); // fix about capacity 1


       customHashMap.put(12,"Hridoy");
       customHashMap.put(2358,"Mahmud.v");
       customHashMap.put(757,"Mother");
       customHashMap.put(22,"Ahsan");
       customHashMap.put(3358,"Masud");

        System.out.println(customHashMap.get(22));
        System.out.println(customHashMap.get(3358));


    }
}
