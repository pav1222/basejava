import java.util.Arrays;


/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    int size = 0;

    public void update(Resume resume) {
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(resume.uuid)) {
                storage[i] = resume;
            }
        }
    }

    void clear() {
        Arrays.fill(storage, 0, size, null);

    }

    void save(Resume resume) {
        if (storage.length > size) {
            System.out.println("Error.Array overflow");
        }
        storage[size] = resume;
        size++;
    }

    Resume get(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(uuid)) {
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {

        for (int i = 0; i < size; i++) {

            if (storage[i].uuid.equals(uuid)) {
                size--;
                if (i == size) {
                    storage[i] = null;
                } else {
                    storage[i] = storage[size];
                }
                break;
            }
        }
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