package com.example.music_album.monitoring;

import com.example.music_album.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Instant;

@Data
@Service
public class LogService {
    @Autowired
    private UserService userService;
    public void writeToLogFileBeforeProcessing(HttpServletRequest request) throws IOException {
        File file = new File("log.txt");
        BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
        try {
            if(request.getRequestURI().contains("login")) {
                writer.write("API::: " + request.getRequestURI() + " with method::: " +
                        "[" + request.getMethod() + "]" + " login detected: " +
                        " at " + Instant.now()
                );
            } else if (request.getRequestURI().equalsIgnoreCase("/api/user")) {
                writer.write("API::: " + request.getRequestURI() + " with method::: " +
                        "[" + request.getMethod() + "]" + " new user registered: " +
                        " at " + Instant.now()
                );
            }else {
                writer.write("API::: " + request.getRequestURI() + " with method::: " +
                        "[" + request.getMethod() + "]" + " invoked by user: " +
                        userService.getUserByToken(request).getUserName() +
                        " at " + Instant.now()
                );
            }
            writer.flush();
            writer.newLine();
        }catch (Exception e){
            writer.write("Error at "+ Instant.now());
            writer.flush();
            writer.newLine();
        }finally {
            writer.close();
        }
    }
    
}
