package com.example.mady.service;

import com.example.mady.dto.response.MadyModelResponse;
import com.example.mady.model.MadyModel;
import com.example.mady.model.enums.FormatModel;
import com.example.mady.repository.MadyModelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MadyModelService {
    private final MadyModelRepository madyModelRepository;

    public MadyModelResponse save(String image,
                                  String title,
                                  String description,
                                  FormatModel format) {
        MadyModel madyModel = MadyModel.builder()
                .image(image)
                .title(title)
                .description(description)
                .dateCreated(LocalDateTime.now())
                .formatModel(format)
                .build();
        madyModelRepository.save(madyModel);
        return findById(madyModel.getId());
    }

    public MadyModelResponse updateById(Long id,
                                        String image,
                                        String title,
                                        String description) {
        MadyModel madyModel = madyModelRepository.findById(id).orElseThrow();
        madyModel.setImage(image);
        madyModel.setTitle(title);
        madyModel.setDescription(description);
        madyModelRepository.save(madyModel);
        return findById(madyModel.getId());
    }

    public List<MadyModelResponse> deleteById(Long id) {
        MadyModel madyModel = madyModelRepository.findById(id).orElseThrow();
        FormatModel formatModel = madyModel.getFormatModel();
        madyModelRepository.delete(madyModel);
        return findAll(6, formatModel);
    }

    public MadyModelResponse findById(Long id) {
        return madyModelRepository.findByIdResponse(id).orElseThrow();
    }

    public List<MadyModelResponse> findAll(int count, FormatModel format) {
        return madyModelRepository.findWithLimitResponse(format, Pageable.ofSize(count));
    }
}
