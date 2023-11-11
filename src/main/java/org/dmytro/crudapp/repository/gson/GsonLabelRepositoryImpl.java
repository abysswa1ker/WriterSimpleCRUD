package org.dmytro.crudapp.repository.gson;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.dmytro.crudapp.model.Label;
import org.dmytro.crudapp.repository.LabelRepository;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.nio.file.FileSystemNotFoundException;
import java.util.Collections;
import java.util.List;

public class GsonLabelRepositoryImpl implements LabelRepository {
    private static final String FILE_PATH = "src/main/resources/labels.json";
    private final Gson gson = new Gson();

    private List<Label> loadLabels() {
        List<Label> labelList;
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
    public Label save(Label newLabel) {
        List<Label> labelList = loadLabels();
        Integer nextId = labelList.stream()
                        .mapToInt(Label::getId).max().orElse(0)+1;
        newLabel.setId(nextId);
        labelList.add(newLabel);
        saveLabels(labelList);
        return newLabel;
    }

    @Override
    public Label update(Label updatedLabel) {
        List<Label> currentLabels = loadLabels();
        List<Label> updatedLabels = currentLabels.stream()
                .map(existingLabel -> {
                    if (existingLabel.getId().equals(updatedLabel.getId())) {
                        return updatedLabel;
                    }
                    return existingLabel;
                }).toList();
        saveLabels(updatedLabels);
        return updatedLabel;
    }

    //TODO: think about this realization
    @Override
    public void deleteById(Integer id) {
        List<Label> labelList = loadLabels();
        labelList.removeIf(label -> label.getId().equals(id));
        saveLabels(labelList);
    }
}
