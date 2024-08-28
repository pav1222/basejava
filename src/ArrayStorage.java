import java.util.Arrays;


/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    final int STORAGE_LIMIT = 10000;
    protected final Resume[] storage = new Resume[STORAGE_LIMIT];

    int size = 0;

   protected int getIndex(String uuid) {
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
        if (storage.length < size) {
            System.out.println("Error: Array overflow");
        } else if (getIndex(resume.uuid) != -1) {
            System.out.println("Error: This resume already exist, try to update it");
        } else {
            storage[++size] = resume;
        }
    }

   public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index != -1) {
            return storage[index];
        } else {
            System.out.println("Element not found");
        }
        return null;
   }



    void delete(String uuid) {
        int index = getIndex(uuid);
        if (index == -1) {
            System.out.println("Resume not found");
            return;
        } else if (index != size) {
            storage[index] = storage[size];
        } else {
            storage[size] = null;
        }
        size--;
    }



    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

   protected int size() {
        return size;
    }
}