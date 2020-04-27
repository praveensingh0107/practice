package com.ps.lowlevel.util;

public class ConsoleOutputWriter implements OutputWriter {
    public void println(Object txt) {
        System.out.println(txt);
    }
}
