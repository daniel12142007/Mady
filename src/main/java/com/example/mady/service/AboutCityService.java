package com.example.mady.service;

import com.example.mady.dto.response.AboutCityResponse;
import com.example.mady.model.AboutCity;
import com.example.mady.repository.AboutCityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AboutCityService {
    private final AboutCityRepository aboutCityRepository;

    public AboutCityResponse find() {
        return aboutCityRepository.findAllResponse().get(0);
    }

    public AboutCityResponse updateAbout(String about) {
        AboutCity aboutCity = aboutCityRepository.findAll().get(0);
        aboutCity.setAbout(about);
        aboutCityRepository.save(aboutCity);
        return aboutCityRepository.findAllResponse().get(0);
    }

    public AboutCityResponse updateDescription(String description) {
        AboutCity aboutCity = aboutCityRepository.findAll().get(0);
        aboutCity.setDescription(description);
        aboutCityRepository.save(aboutCity);
        return aboutCityRepository.findAllResponse().get(0);
    }

    public AboutCityResponse updateVideo(String video) {
        AboutCity aboutCity = aboutCityRepository.findAll().get(0);
        aboutCity.setVideo(video);
        aboutCityRepository.save(aboutCity);
        return aboutCityRepository.findAllResponse().get(0);
    }
}