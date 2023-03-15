package it.olly.librarytest;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import it.olly.mvnlibrary.OllyLib;

@SpringBootTest
class MvnJavaLibraryTestApplicationTests {

    @Test
    void contextLoads() {
        System.out.println("> " + OllyLib.testMethod("here"));
    }

}
