package it.olly.mvnlibrary;

public class OllyLib {
    public static String testMethod(String base) {
        return base + "." + System.currentTimeMillis();
    }
}