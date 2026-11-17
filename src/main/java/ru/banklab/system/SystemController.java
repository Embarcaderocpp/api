package ru.banklab.system;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** Технический пример Controller → JSON. Банковскую логику сюда не добавлять. */
@RestController
@RequestMapping("/api/v1/system")
public class SystemController {

    @GetMapping("/status")
    public SystemStatus status() {
        return new SystemStatus("bank-lab", "UP");
    }

    public record SystemStatus(String application, String status) {
    }
}
