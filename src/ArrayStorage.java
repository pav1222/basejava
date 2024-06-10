import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

     void clear() {
        Arrays.fill(storage, null);
    }

    void save(Resume resume) {
        storage[9999] = resume;
    }

    Resume get(String uuid) {
         if (storage[1].uuid.equals(uuid)) {
             return storage[1];
         }
         return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i].uuid.equals(uuid)) {
                storage[i] = null;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOf(storage,storage.length);
    }

    int size() {
        return storage.length;
    }
}
