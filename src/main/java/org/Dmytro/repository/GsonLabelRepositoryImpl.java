package org.Dmytro.repository;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.Dmytro.model.Label;
import org.Dmytro.model.Writer;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class GsonLabelRepositoryImpl implements LabelRepository{
    private final String filePath = "Labels.json";
    private final Gson gson = new Gson();

    private List<Label> readAll() {
        List<Label> labelList = new ArrayList<>();
        try(Reader reader = new FileReader(filePath)) {
            Type type = new TypeToken<List<Writer>>(){}.getType();
            labelList = gson.fromJson(reader, type);
            System.out.println("Read operation successful. Retrieved writers from file.");

        } catch (IOException e) {
            e.printStackTrace();
        }
        return labelList;
    }

    private void writeAll(List<Label> labels) {
        try(FileWriter fileLabels = new FileWriter(filePath)) {
//            System.out.println("Content of writers list before writing to file:");
//            for (Writer writer1 : writers) {
//                System.out.println(writer1); // Предполагается, что у класса Writer определен toString()
//            }
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
        return null;
    }

    @Override
    public Label save(Label label) {
        return null;
    }

    @Override
    public Label update(Label label) {
        return null;
    }

    @Override
    public void deleteById(Integer integer) {

    }
}
