package VacantList;

import com.example.demo.Workers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import static com.example.demo.TableViewController.workerVacantList;


public class WorkerVacantWrite {
    public static void WorkerVacantWriterList() {

        File file = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try{
            file = new File("WorkerVacantFile");
            if(!file.exists()){
                file.createNewFile();
            }
            fos = new FileOutputStream(file);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(new ArrayList<Workers>(VacantListController.vacantList));
            oos.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        finally {
            try {
                fos.close();
                oos.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

