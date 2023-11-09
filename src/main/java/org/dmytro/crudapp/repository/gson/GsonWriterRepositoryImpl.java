package org.dmytro.crudapp.repository.gson;

import org.dmytro.crudapp.model.Post;
import org.dmytro.crudapp.model.Writer;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.dmytro.crudapp.repository.WriterRepository;

import java.io.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class GsonWriterRepositoryImpl implements WriterRepository {
    private final String filePath = "writers.json";
    private final Gson gson = new Gson();

    @Override
    public Writer getById(Integer id) {
        List<Writer> writers = readAll();
        for (Writer writer: writers) {
            if (writer.getId() == id) {
                return writer;
            }
        }
        return null;
    }

    @Override
    public List<Writer> getAll() {
        return readAll();
    }

    @Override
    public Writer save(Writer writer) {
        List<Writer> writers = readAll();
        writers.add(writer);
        writeAll(writers);

        return writer;
    }

    @Override
    public Writer update(Writer updatedWriter) {
        List<Writer> writers = readAll();
        for (int i =0; i < writers.size(); i++) {
            if (writers.get(i).getId() == updatedWriter.getId()) {
                writers.set(i, updatedWriter);
                writeAll(writers);
                return  updatedWriter;
            }
        }
        return null;
    }

    @Override
    public Post deleteById(Integer id) {
        List<Writer> writers = readAll();
        writers.removeIf(writer -> writer.getId() == id);
        writeAll(writers);
        return null;
    }

    private List<Writer> readAll() {
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

    private void writeAll(List<Writer> writers) {
        try(FileWriter fileWriter = new FileWriter(filePath)) {
//            System.out.println("Content of writers list before writing to file:");
//            for (Writer writer1 : writers) {
//                System.out.println(writer1); // Предполагается, что у класса Writer определен toString()
//            }
            gson.toJson(writers, fileWriter);
            System.out.println("Write operation successful. Writers  saved to file.");
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла");
            e.printStackTrace();
        }
    }
}
