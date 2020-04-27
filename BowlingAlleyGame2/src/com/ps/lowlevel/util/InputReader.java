package com.ps.lowlevel.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class InputReader implements AutoCloseable {
    private BufferedReader br;

    public InputReader() {
        InputStream in;
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public int getValue() {
        Integer value = 0;
        try {
            value = Integer.valueOf(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return value;
    }

    @Override public void close() throws Exception {
        if (br != null)
            br.close();
    }
}
