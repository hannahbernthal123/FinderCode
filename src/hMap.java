public class hMap {
    // Want a number that is large and prime.
    final int DEFAULT_TABLE_SIZE = 997;
    static final int RADIX = 256;
    final String INVALID = "INVALID KEY";
    int tableSize;
    int numEntries;
    String[] keys;
    String[] values;

    public hMap() {
        tableSize = DEFAULT_TABLE_SIZE;
        numEntries = 0;

        // Associative arrays of keys and values.
        keys = new String[tableSize];
        values = new String[tableSize];
    }

    public void add(String key, String value) {
        // Check load factor. If more than half of table is filled, resize.
        if (numEntries / tableSize >= .5) {
            resize();
        }

        int index = hash(key);

        // Check next index until empty spot is found.
        while (keys[index] != null) {
            index = (index + 1) % tableSize;
        }

        keys[index] = key;
        values[index] = value;
        // Index numEntries because something was added to the table.
        numEntries++;
    }

    public String get(String key) {
        int index = hash(key);

        // Loop through to find where you actually put this key (could have been a collision that moved it).
        while (keys[index] != null) {
            if (keys[index].equals(key)) {
                return values[index];
            }

            // Updates index, accounts for wrap around if needed.
            index = (index + 1) % tableSize;
        }

        // If there is no spot where the keys match, return that it is an invalid query.
        return INVALID;
    }

    public int hash(String key) {
        // Hash using Horner's method.
        int hash = 0;
        for (int i = 0; i < key.length(); i++) {
            // Mod by the tableSize to make sure values stay in size range as table gets bigger.
            hash = (RADIX * hash + key.charAt(i)) % tableSize;
        }

        return hash;
    }

    public void resize() {
        // Double tableSize so that you can resize array.
        tableSize *= 2;

        // Store old arrays to assist in transfering data.
        String[] keysOld = keys;
        String[] valsOld = values;

        // Create new arrays that are doubled in size.
        keys = new String[tableSize * 2];
        values = new String[tableSize * 2];

        // Transfers existing pairs over to new table.
        for (int i = 0; i < tableSize/2; i++) {
            if(keysOld[i] != null) {
                this.add(keysOld[i], valsOld[i]);
            }
        }
    }

}
