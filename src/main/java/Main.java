import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Pair> listPair = List.of(
                new Pair("abc", "desc of abc"),
                new Pair("ade", "desc of ade"),
                new Pair("acb", "desc of acb"),
                new Pair("aed", "desc of aed"),
                new Pair("def", "desc of def"),
                new Pair("cba", "desc of cba"));

        int maxValue = 6;
        ServiceHashMap serviceHashMap = new ServiceHashMap(maxValue);
        for (int i = 0; i < listPair.size(); i++) {
            serviceHashMap.addElement(listPair.get(i));
        }
        System.out.println("\n\t\t___result after adding elements____");
        serviceHashMap.printHashMap();

        Pair pairToDelete=listPair.get(2);
        serviceHashMap.deleteElement(pairToDelete);
        System.out.println("\n\t\t___ deleting a pair element "+pairToDelete);
        serviceHashMap.printHashMap();

        int getEmptySlot= serviceHashMap.getEmptySlot();
        System.out.println("\n\t\t___ get empty slot "+getEmptySlot);

    }
}
