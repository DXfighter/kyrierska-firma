package bg.tu_varna.sit.example.presentation.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HelloModelTest {

    private HelloModel helloModel;

    @BeforeEach
    void setUp() {




    }

    @Test
    void getWelcomeMessage() {
        assertEquals("Hello, SIT, I am JavaFX Project", helloModel.getWelcomeMessage());
    }
}