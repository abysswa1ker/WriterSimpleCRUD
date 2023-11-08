package org.dmytro.crudapp.repository.GsonRepository;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.dmytro.crudapp.model.Label;
import org.dmytro.crudapp.model.Post;
import org.dmytro.crudapp.repository.LabelRepository;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GsonLabelRepositoryImpl implements LabelRepository {
    private static final String FILE_PATH = "src/main/resources/labels.json";
    private final Gson gson = new Gson();

    //TODO: change name of method like loadLabels
    private List<Label> readAll() {
        List<Label> labelList = new ArrayList<>();
        try(Reader reader = new FileReader(FILE_PATH)) {
            Type type = new TypeToken<List<Label>>(){}.getType();
            labelList = gson.fromJson(reader, type);
            System.out.println("Read operation successful. Retrieved writers from file.");
            return labelList;

        } catch (IOException e) {
//            e.printStackTrace();
            //TODO: think about this
            return Collections.emptyList();
        }
    }

    private void writeAll(List<Label> labels) {
        try(FileWriter fileLabels = new FileWriter(FILE_PATH)) {
            gson.toJson(labels, fileLabels);
            System.out.println("Write operation successful. Writers  saved to file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Label getById(Integer id) {
        List<Label> labelList = readAll();
        for (Label label: labelList) {
            if (label.getId() == id){
                return label;
            }
        }
        return null;
    }

    @Override
    public List<Label> getAll() {
        return readAll();
    }

    @Override
    public Label save(Label label) {
        List<Label> labelList = readAll();
        labelList.add(label);
        writeAll(labelList);
        return label;
    }

    @Override
    public Label update(Label updatedLabel) {
        List<Label> labelList = readAll();
        for (int i = 0; i < labelList.size(); i ++) {
            if (labelList.get(i).getId() == updatedLabel.getId()) {
                labelList.set(i, updatedLabel);
                writeAll(labelList);
                return updatedLabel;
            }
        }
        return null;
    }

    @Override
    public Post deleteById(Integer id) {
        List<Label> labelList = readAll();
        labelList.removeIf(label -> label.getId() == id);
        writeAll(labelList);
        return null;
    }
}
