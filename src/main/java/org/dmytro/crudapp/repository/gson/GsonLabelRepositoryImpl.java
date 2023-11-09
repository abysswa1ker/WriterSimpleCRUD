package org.dmytro.crudapp.repository.gson;

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
import java.nio.file.FileSystemNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GsonLabelRepositoryImpl implements LabelRepository {
    private static final String FILE_PATH = "src/main/resources/labels.json";
    private final Gson gson = new Gson();

    //TODO: change name of method like loadLabels
    private List<Label> loadLabels() {
        List<Label> labelList = new ArrayList<>();
        try(Reader reader = new FileReader(FILE_PATH)) {
            Type type = new TypeToken<List<Label>>(){}.getType();
            labelList = gson.fromJson(reader, type);
            System.out.println("Read operation successful. Retrieved writers from file.");
            return labelList;

        } catch (IOException e) {
            return Collections.emptyList();
        }
    }

    private void saveLabels(List<Label> labels) {
        try(FileWriter fileLabels = new FileWriter(FILE_PATH)) {
            gson.toJson(labels, fileLabels);
            System.out.println("Write operation successful. Writers  saved to file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Label getById(Integer id) {
        return loadLabels().stream()
                .filter(label -> label.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new FileSystemNotFoundException("label not found with id: " + id));
    }

    @Override
    public List<Label> getAll() {
        return loadLabels();
    }

    @Override
    public Label save(Label label) {
        List<Label> labelList = loadLabels();
        labelList.add(label);
        saveLabels(labelList);
        return label;
    }

    @Override
    public Label update(Label updatedLabel) {
        List<Label> labelList = loadLabels();
        for (int i = 0; i < labelList.size(); i ++) {
            if (labelList.get(i).getId() == updatedLabel.getId()) {
                labelList.set(i, updatedLabel);
                saveLabels(labelList);
                return updatedLabel;
            }
        }
        return null;
    }

    @Override
    public Post deleteById(Integer id) {
        List<Label> labelList = loadLabels();
        labelList.removeIf(label -> label.getId() == id);
        saveLabels(labelList);
        return null;
    }
}
