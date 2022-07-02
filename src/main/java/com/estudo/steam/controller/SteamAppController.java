package com.estudo.steam.controller;

import com.estudo.steam.service.SteamAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/steam")
public class SteamAppController {

    @Autowired
    private SteamAppService steamAppService;
    @GetMapping("/")
    public String consummerSteam (){
        steamAppService.getSteamId();

        return "Teste";

    }
}
