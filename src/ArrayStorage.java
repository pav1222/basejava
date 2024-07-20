import java.util.Arrays;


/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    int size = 0;

    void clear() {
        Arrays.fill(storage, 0, size() + 1, null);

    }

    void save(Resume resume) {
        storage[size] = resume;
        size++;
    }

    Resume get(String uuid) {
        for (Resume resume : storage) {
            if (resume.uuid.equals(uuid)) {
                return resume;
            }
        }
        return null;
    }

    void delete(String uuid) {
        int pointerToDeletedResume = 0;
        for (int i = 0; i < storage.length; i++) {
            if (storage[i].uuid.equals(uuid)) {
                storage[i] = null;
                pointerToDeletedResume = i;
                break;
            }
        }
        for (int i = pointerToDeletedResume; i < size; i++) {
            storage[i] = storage[i + 1];
        }
        size--;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    int size() {
        return size;
    }
}