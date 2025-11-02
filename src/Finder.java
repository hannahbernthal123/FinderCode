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
    public static int RADIX = 256;
    public static final long P = 29245776433644439L;
    TST TST = new TST();
    private static final String INVALID = "INVALID KEY";

    public Finder() {}

    public void buildTable(BufferedReader br, int keyCol, int valCol) throws IOException {
        String line;
        String[] elements = {};
        long hash;
        while((line = br.readLine()) != null) {
            elements = line.split(",");
            hash = hash(elements[keyCol]);
            String hashAsString = Long.toString(hash);
            TST.insert(hashAsString, elements[valCol]);
        }


        br.close();
    }

    public static long hash(String s) {
        int length = s.length();
        long h = 0;
        // Preform Horner's Method
        for (int i = 0; i < length; i++) {
            h = (h * RADIX + s.charAt(i)) % P;
        }
        return h;
    }


    public String query(String key){
        if (TST.find(Long.toString(hash(key))).equals("invalid")) {
            return INVALID;
        }
        return TST.find(Long.toString(hash(key)));
    }


}