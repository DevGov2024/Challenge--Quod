package br.com.fiap.Quod.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Face")
public class Facial {



    @GetMapping
    public String getOla(){

    return "Olá, FIAP!";
    }



}
