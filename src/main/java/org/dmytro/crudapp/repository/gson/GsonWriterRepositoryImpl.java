package org.dmytro.crudapp.repository.gson;

import org.dmytro.crudapp.model.Writer;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.dmytro.crudapp.repository.WriterRepository;

import java.io.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class GsonWriterRepositoryImpl implements WriterRepository {
    private static final String FILE_PATH = "src/main/resources/labels.json";
    private final Gson gson = new Gson();


    private List<Writer> loadWriters() {
        List<Writer> fileWriters = new ArrayList<>();
        try(Reader reader = new FileReader(FILE_PATH)) {
            Type type = new TypeToken<List<Writer>>(){}.getType();
            fileWriters = gson.fromJson(reader, type);
            if (fileWriters== null) {
                fileWriters = new ArrayList<>();
            }
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла");
            e.printStackTrace();
        }
        return fileWriters;
    }

    private void saveWriters(List<Writer> writers) {
        try(FileWriter fileLabels = new FileWriter(FILE_PATH)) {
            gson.toJson(writers, fileLabels);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public Writer getById(Integer id) throws FileNotFoundException {
        return loadWriters().stream()
                .filter(writer -> writer.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new FileNotFoundException("Writer not found with id " + id) );
    }

    @Override
    public List<Writer> getAll() {
        return loadWriters();
    }

    @Override
    public Writer save(Writer writer) {
        List<Writer> currentWriters = loadWriters();
        Integer nextId = currentWriters.stream()
                        .mapToInt(Writer::getId).max().orElse(0)+1;

        writer.setId(nextId);
        currentWriters.add(writer);
        saveWriters(currentWriters);

        return writer;
    }

    @Override
    public Writer update(Writer updateWriter) {
        List<Writer> currentWriters = loadWriters();
        List<Writer> updatedWriters = currentWriters.stream()
                .map(existingWriter -> {
                    if (existingWriter.getId().equals(updateWriter.getId())) {
                        return updateWriter;
                    }
                    return existingWriter;
                }).toList();
        saveWriters(updatedWriters);
        return updateWriter;
    }

    @Override
    public void deleteById(Integer id) {
        List<Writer> writers = loadWriters();
        writers.removeIf(writer -> writer.getId() == id);
        saveWriters(writers);
    }
}
