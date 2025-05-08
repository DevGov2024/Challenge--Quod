package br.com.fiap.Quod.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Biometria {
@GetMapping
    public String SayBiometria() {

    return "Biometria";
    }
   @GetMapping("/biometria2")
    public String SayBiometria2() {
        return "Biometria2";
    }
}


