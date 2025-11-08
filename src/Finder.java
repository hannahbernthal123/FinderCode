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
    TST TST = new TST();
    final String INVALID = "INVALID KEY";

    // Make the table size a big prime number but under 1000.
    hMap map;
    public Finder() {
        map = new hMap();
    }
//

    public void buildTable(BufferedReader br, int keyCol, int valCol) throws IOException {
        // HashTable implementation
        String line;
        // Reads in the data
        while ((line = br.readLine()) != null) {
            String[] columns = line.split(",");
            map.add(columns[keyCol], columns[valCol]);
        }
        br.close();

    }

    public String query(String key){
        return map.get(key);
    }



}