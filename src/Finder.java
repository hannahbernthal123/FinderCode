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


//    public static int hash(String str, int len, int p, keys) {
//        // Modifies a string to a unique number utilizing hash functions (Horner's method)
//        int hashed = 0;
//        for(int i = 0; i < len; i++) {
//            hashed = (RADIX * hashed + str.charAt(i)) % p;
//        }
//        hashed %= p;
//
//        // Keep moving to the next item in the array until you find a blank spot, but make sure to wrap if it overflows
//        if (keys != null) {
//            while (array[hashed] != null) {
//                hashed = (hashed + 1) % p;
//            }
//        }
//        return hashed;
//    }
//
//    public static long hash(String s) {
//        int length = s.length();
//        long h = 0;
//        // Preform Horner's Method
//        for (int i = 0; i < length; i++) {
//            h = (h * RADIX + s.charAt(i)) % P;
//        }
//        return h;
//    }


}