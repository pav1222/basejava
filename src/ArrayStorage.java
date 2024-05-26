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

    }

    Resume get(String uuid) {
        if(storage[0].uuid.equals(uuid)) {
            return storage[0];
        }
        return null;
    }

    void delete(String uuid) {
        storage[4] = null;
        for (int i = 2;i < storage.length;i++) {
            storage[i - 1] = storage[i];
            storage[i] = null;
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
