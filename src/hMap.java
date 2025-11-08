public class hMap {
    final int DEFAULT_TABLE_SIZE = 997;
    final int RADIX = 256;
    final String INVALID = "INVALID KEY";
    int tableSize;
    int numEntries;
    int loadFactor;
    String[] keys;
    String[] values;



    public hMap() {
        tableSize = DEFAULT_TABLE_SIZE;
        numEntries = 0;
        keys = new String[tableSize];
        values = new String[tableSize];
        loadFactor = numEntries / tableSize;
    }

    public void add(String key, String value) {
        // Check load factor.
        if (loadFactor >= .5) {
            resize();
        }

        int index = hash(key);

        // Check next index until empty spot is found.
        while (keys[index] != null) {
            index = (index + 1) % tableSize;
        }

        keys[index] = key;
        values[index] = value;
    }

    public String get(String key) {
        int index = hash(key);

        // Loop through to find where you actually put this key (could have been a collision).
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
        int hash = -1;

        for (int i = 0; i < key.length(); i++) {

        }

    }

    public void resize() {
        tableSize *= 2;

        // Create new arrays that are doubled in size.
        String[] keysOld = keys;
        String[] valsOld = values;
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
