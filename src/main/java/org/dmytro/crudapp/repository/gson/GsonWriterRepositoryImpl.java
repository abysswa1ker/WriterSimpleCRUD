package org.dmytro.crudapp.repository.gson;

import org.dmytro.crudapp.model.Label;
import org.dmytro.crudapp.model.Post;
import org.dmytro.crudapp.model.Writer;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.dmytro.crudapp.repository.WriterRepository;

import java.io.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GsonWriterRepositoryImpl implements WriterRepository {
    private final String filePath = "writers.json";
    private final Gson gson = new Gson();


    private List<Writer> loadWriters() {
        List<Writer> fileWriters = new ArrayList<>();
        try(Reader reader = new FileReader(filePath)) {
            Type type = new TypeToken<List<Writer>>(){}.getType();
            fileWriters = gson.fromJson(reader, type);
            System.out.println("Read operation successful. Retrieved writers from file.");
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла");
            e.printStackTrace();
        }
        return fileWriters;
    }

    private void saveWriters(List<Writer> writers) {
        try(FileWriter fileWriter = new FileWriter(filePath)) {
            gson.toJson(writers, fileWriter);
            System.out.println("Write operation successful. Writers  saved to file.");
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла");
            e.printStackTrace();
        }
    }
    @Override
    public Writer getById(Integer id) {
        List<Writer> writers = loadWriters();
        for (Writer writer: writers) {
            if (writer.getId() == id) {
                return writer;
            }
        }
        return null;
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
