package org.Dmytro.controller;

import org.Dmytro.model.Writer;
import org.Dmytro.repository.WriterRepository;

import java.util.List;

public class WriterController {
    private final WriterRepository writerRepository;

    public WriterController(WriterRepository writerRepository) {
        this.writerRepository = writerRepository;
    }

    public Writer createWriter(Writer writer) {
        return writerRepository.save(writer);
    }

    public Writer getById(int id) {
        return writerRepository.getById(id);
    }

    public List<Writer> getAllWriters() {
        return writerRepository.getAll();
    }

    public Writer updatedWriter(Writer updatedWriter) {
        return writerRepository.update(updatedWriter);
    }

    public void deleteWriterById(int id) {
        writerRepository.deleteById(id);
    }
}
