package org.dmytro.crudapp.controller;

import org.dmytro.crudapp.model.Label;
import org.dmytro.crudapp.repository.LabelRepository;

import java.util.List;

public class LabelController {
    private final LabelRepository labelRepository;

    public LabelController(LabelRepository labelRepository) {
        this.labelRepository = labelRepository;
    }

    public Label createWriter(Label label) {
        return labelRepository.save(label);
    }

    public Label getById(int id) {
        return labelRepository.getById(id);
    }

    public List<Label> getAllLabel() {
        return labelRepository.getAll();
    }

    public Label updatedLabel(Label updatedLabel) {
        return labelRepository.update(updatedLabel);
    }

    public void deleteLabelById(int id) {
        labelRepository.deleteById(id);
    }
}
