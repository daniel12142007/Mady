package com.example.mady.api.admin;

import com.example.mady.dto.response.MadyModelResponse;
import com.example.mady.model.enums.FormatModel;
import com.example.mady.service.MadyModelService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@PreAuthorize("hasAnyAuthority('ADMIN')")
@RequestMapping("api/v1/mady/model/admin")
public class MadyModelAdminApi {
    private final MadyModelService madyModelService;

    @GetMapping("find/all/{count}")
    public List<MadyModelResponse> findAll(@PathVariable int count,
                                           @RequestParam FormatModel format) {
        return madyModelService.findAll(count, format);
    }

    @GetMapping("find/by/{id}")
    public MadyModelResponse findById(@PathVariable Long id) {
        return madyModelService.findById(id);
    }

    @PostMapping("save")
    public MadyModelResponse save(@RequestParam String image,
                                  @RequestParam String title,
                                  @RequestParam String description,
                                  @RequestParam FormatModel format) {
        return madyModelService.save(image, title, description, format);
    }

    @DeleteMapping("delete/by/{id}")
    public List<MadyModelResponse> deleteById(@PathVariable Long id) {
        return madyModelService.deleteById(id);
    }

    @PutMapping("update/{id}")
    public MadyModelResponse updateById(@PathVariable Long id,
                                        @RequestParam String image,
                                        @RequestParam String title,
                                        @RequestParam String description) {
        return madyModelService.updateById(id, image, title, description);
    }
}