package com.example.mady.api.admin;

import com.example.mady.dto.response.AboutCityResponse;
import com.example.mady.service.AboutCityService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@PreAuthorize("hasAnyAuthority('ADMIN')")
@RequestMapping("api/v1/about/city/admin")
public class AboutCityAdminApi {
    private final AboutCityService aboutCityService;

    @GetMapping("find")
    public AboutCityResponse find() {
        return aboutCityService.find();
    }

    @PutMapping("update/about")
    public AboutCityResponse updateAbout(@RequestParam String about) {
        return aboutCityService.updateAbout(about);
    }

    @PutMapping("update/description")
    public AboutCityResponse updateDescription(@RequestParam String description) {
        return aboutCityService.updateDescription(description);
    }

    @PutMapping("update/video")
    public AboutCityResponse updateVideo(@RequestParam String video) {
        return aboutCityService.updateVideo(video);
    }
}