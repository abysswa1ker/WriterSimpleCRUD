package org.dmytro.crudapp.controller;

import lombok.RequiredArgsConstructor;
import org.dmytro.crudapp.enams.LabelStatus;
import org.dmytro.crudapp.enams.PostStatus;
import org.dmytro.crudapp.model.Label;
import org.dmytro.crudapp.repository.LabelRepository;

import java.util.List;

@RequiredArgsConstructor
public class LabelController {
    private final LabelRepository labelRepository;

    public Label createLabel(String name, LabelStatus labelStatus) {
        Label newLabel = new Label(name, labelStatus);
        return labelRepository.save(newLabel);
    }

    public Label getLabelById(Integer id) {
        return labelRepository.getById(id);
    }

    public List<Label> getAllLabels() {
        return labelRepository.getAll();
    }

    public Label updatedLabel(Integer id, String name, LabelStatus labelStatus) {
        Label updateLabel = new Label(name, labelStatus);
        updateLabel.setId(id);

        return labelRepository.update(updateLabel);
    }


    public void deleteLabelById(Integer id) {
        labelRepository.deleteById(id);
    }
}
