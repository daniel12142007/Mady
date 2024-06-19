package com.example.mady.api.user;

import com.example.mady.dto.response.MadyModelResponse;
import com.example.mady.model.enums.FormatModel;
import com.example.mady.service.MadyModelService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/mady/model/user")
public class MadyModelUserApi {
    private final MadyModelService madyModelService;

    @GetMapping("find/by/{id}")
    public MadyModelResponse findById(@PathVariable Long id) {
        return madyModelService.findById(id);
    }

    @GetMapping("find/all/{count}")
    public List<MadyModelResponse> findAll(@PathVariable int count,
                                           @RequestParam FormatModel format) {
        return madyModelService.findAll(count, format);
    }
}