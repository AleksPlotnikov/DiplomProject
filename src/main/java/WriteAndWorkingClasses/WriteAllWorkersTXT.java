package WriteAndWorkingClasses;

import com.example.demo.Workers;

import java.io.*;

import static com.example.demo.TableViewController.*;

public class WriteAllWorkersTXT implements Serializable {

    public static void writeAllWorkers() {


        File file;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            file = new File("AllWorkerList.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            fos = new FileOutputStream(file);
            oos = new ObjectOutputStream(fos);
            for (Workers workers : workersList)
                oos.writeObject(workers.getNameWorker().concat(" ")
                        + workers.getYearWorker().concat(" ")
                        + workers.getPostWorker().concat(" ")
                        + workers.getWorkShop().concat("\n"));

            oos.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                fos.close();
                oos.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
