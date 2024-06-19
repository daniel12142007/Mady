package com.example.mady.api.user;

import com.example.mady.dto.response.AboutCityResponse;
import com.example.mady.service.AboutCityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/about/city/user")
public class AboutCityUserApi {
    private final AboutCityService aboutCityService;

    @GetMapping("find")
    public AboutCityResponse find() {
        return aboutCityService.find();
    }
}