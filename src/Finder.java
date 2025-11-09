import java.io.BufferedReader;
import java.io.IOException;
/**
 * Finder
 * A puzzle written by Zach Blick
 * for Adventures in Algorithms
 * At Menlo School in Atherton, CA
 *
 * Completed by: Hannah
 **/

public class Finder {
    //TST TST = new TST();
    hMap map;
    public Finder() {
        map = new hMap();
    }

    public void buildTable(BufferedReader br, int keyCol, int valCol) throws IOException {
        // HashTable implementation
        String line;
        // Reads in the data
        while ((line = br.readLine()) != null) {
            // Creates an array of strings that consists of the elements of the line utilizing the split function.
            String[] elements = line.split(",");
            // Goes through and adds each element to the map.
            map.add(elements[keyCol], elements[valCol]);
        }
        br.close();
    }

    public String query(String key){
        return map.get(key);
    }
}