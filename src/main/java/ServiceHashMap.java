import exceptions.ExceptionPairExist;
import exceptions.ExceptionPairNotExist;
import java.util.LinkedList;


public class ServiceHashMap implements HashMap {
    private Integer maxValue;
    //max value table length
    LinkedList<Pair>[] table;
    //table contains linked-list data structure  of Pair class

    public ServiceHashMap(Integer maxValue) {
        this.maxValue = maxValue;
        table = new LinkedList[maxValue];
    }

    @Override
    public void addElement(Pair pair) {
        if (isExist(pair))
            //we don't add a pair exists before
            throw new ExceptionPairExist("this pair exist in the table");
        int key = hashValue(pair.getIdentification());
        //get key of pair using its identification
        if (table[key] == null) {
            // if the object of linked-list pair doesn't exist
            LinkedList linkedList = new LinkedList();
            linkedList.add(pair);
            table[key] = linkedList;
        } else {
            // the object of linked-list was created before
            // we add just the pair object to the list
            table[key].add(pair);
        }

    }

    @Override
    public void deleteElement(Pair pair) {
        if (!isExist(pair))
            throw new ExceptionPairNotExist(" pair not exist in the table");
        int key = hashValue(pair.getIdentification());
        LinkedList<Pair> linkedList = table[key];
        for (int i = 0; i < linkedList.size(); i++) {
            if (linkedList.get(i).getDescription()
                    .equalsIgnoreCase(pair.getDescription()))
                linkedList.remove(i);
        }

    }

    @Override
    public Boolean isExist(Pair pair) {
        // checking from the key and the description pair if exists
        int key = hashValue(pair.getIdentification());
        if (table[key] == null)
            return false;
            //if the key doesn't exist
        LinkedList<Pair> linkedList = table[key];
        for (int i = 0; i < linkedList.size(); i++) {
            if (linkedList.get(i).getDescription()
                    .equalsIgnoreCase(pair.getDescription()))
                return true;
            //if the pair exist (means the key and the description)
        }
        return false;
    }

    @Override
    public void printHashMap() {
        for (int i = 0; i < table.length; i++) {
            // printing just the occupied value of table
            if (table[i] != null)
                System.out.println("index " + i + " " + table[i]);
        }
    }

    @Override
    public int getEmptySlot() {
       // counting the empty slot of the table
        int count=maxValue;
        for (LinkedList<Pair>p:table) {
            if(p!=null )
                count--;

        }
   return count; }

    private Integer hashValue(String identification) {
        int order_a = 'a';
        //get the ASCII code of small letter a
        int sum = 0;
        String lowerCase = identification.toLowerCase();
        for (char ch : lowerCase.toCharArray()) {
            sum += ch - order_a;
           // summing the order of each letter
           // starting with order a which is 0
        }
        return sum % maxValue;
        //assuming each pair within the interval 0 and max-value
    }
}
