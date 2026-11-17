package ru.banklab.system;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/** Проверяет только запуск каркаса и технический endpoint, не банковские функции. */
@SpringBootTest
@AutoConfigureMockMvc
class SystemStatusTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void applicationStartsAndReturnsTechnicalStatus() throws Exception {
        mockMvc.perform(get("/api/v1/system/status"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.application").value("bank-lab"))
                .andExpect(jsonPath("$.status").value("UP"));
    }
}
