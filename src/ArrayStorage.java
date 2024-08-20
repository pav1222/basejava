import java.util.Arrays;


/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    final int STORAGE_LIMIT = 10000;
    private final Resume[] storage = new Resume[STORAGE_LIMIT];

    int size = 0;

    int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(uuid)) {
                return i;
            }
        }
        return -1;
    }
    public void update(Resume resume) {
        int index = getIndex(resume.uuid);
        if (index != -1) {
            storage[index] = resume;
        } else {
            System.out.println("Error.Resume not found");
            }
        }


    void clear() {
        Arrays.fill(storage, 0, size, null);
    }

    void save(Resume resume) {
        int index = getIndex(resume.uuid);
        if (storage.length > size) {
            System.out.println("Error.Array overflow");
        }
        storage[index] = resume;
        size++;
    }

    Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index != -1) {
            return storage[index];
            }
        return null;
        }



    void delete(String uuid) {
        int index = getIndex(uuid);
            if (index == -1) {
                System.out.println("Resume not found");
                return;
            }

            size--;
            if (index == size) {
                storage[index] = null;
            } else {
                storage[index] = storage[size];
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