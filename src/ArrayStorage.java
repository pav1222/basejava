import java.util.Arrays;



/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    int pointer = 0;

    void clear() {
        Arrays.fill(storage,0,size()+1,null);

    }

    void save(Resume resume) {
        storage[pointer] = resume;
        pointer++;
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
        Resume [] resumeCopy = new Resume[pointer];
        for (int i = 0; i < pointer; i++) {
            if (storage[i] != null) {
               resumeCopy[i] = storage[i];
            } else {
               break;
            }
        }
        return resumeCopy;
    }

    int size() {
        return pointer;
    }
}