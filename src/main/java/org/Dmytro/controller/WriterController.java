package org.Dmytro.controller;

import org.Dmytro.model.Writer;
import org.Dmytro.repository.WriterRepository;

public class WriterController {
    private final WriterRepository writerRepository;

    public WriterController(WriterRepository writerRepository) {
        this.writerRepository = writerRepository;
    }

    public Writer getById(int id) {
        return writerRepository.getById(id);
    }
}
