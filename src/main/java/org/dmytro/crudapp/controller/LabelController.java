package org.dmytro.crudapp.controller;

import lombok.RequiredArgsConstructor;
import org.dmytro.crudapp.model.Label;
import org.dmytro.crudapp.repository.LabelRepository;

import java.util.List;

@RequiredArgsConstructor
public class LabelController {
    private final LabelRepository labelRepository;

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
