package com.caihong.javathinking.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OSExecute {
    public static void command(String command) {
        boolean isError = false;
        try {
            ProcessBuilder pro = new ProcessBuilder(command.split(" "));
            Process process = pro.start();
            BufferedReader result = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = result.readLine()) != null) {
                System.out.println(line);
            }
            BufferedReader error = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            String errorInfo;
            while ((errorInfo = error.readLine()) != null) {
                System.out.println(errorInfo);
                isError = true;
            }
        } catch (IOException e) {
            if (!command.startsWith("CMD /C")) {
                command("CMD /C " + command);
            } else {
                throw new RuntimeException(e);
            }
        }
        if (isError) {
            throw new RuntimeException("OSExecute command:" + command);
        }
    }
}
