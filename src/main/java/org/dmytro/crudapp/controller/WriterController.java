package org.dmytro.crudapp.controller;

import org.dmytro.crudapp.enams.WriterStatus;
import org.dmytro.crudapp.model.Writer;
import org.dmytro.crudapp.repository.WriterRepository;

import java.io.FileNotFoundException;
import java.util.List;

public class WriterController {
    private final WriterRepository writerRepository;

    public WriterController(WriterRepository writerRepository) {
        this.writerRepository = writerRepository;
    }

    public Writer createWriter(String firstName, String lastName, WriterStatus writerStatus) {
        Writer newWriter = new Writer(firstName, lastName, writerStatus);
        return writerRepository.save(newWriter);

    }

    public Writer getById(Integer id) throws FileNotFoundException {
        return writerRepository.getById(id);
    }

    public List<Writer> getAllWriters() {
        return writerRepository.getAll();
    }

    public Writer updatedWriter(Integer id, String firstName, String lastName) {
        Writer updateWriter = new Writer(firstName,lastName);
        updateWriter.setId(id);
        return writerRepository.save(updateWriter);
    }

    public void deleteWriterById(int id) {
        writerRepository.deleteById(id);
    }
}
