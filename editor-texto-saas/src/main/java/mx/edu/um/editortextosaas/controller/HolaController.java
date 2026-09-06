package mx.edu.um.editortextosaas.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolaController {

    @GetMapping("/api/status")
    public String estado() {
        return "Editor de texto SaaS funcionando correctamente";
    }
}
