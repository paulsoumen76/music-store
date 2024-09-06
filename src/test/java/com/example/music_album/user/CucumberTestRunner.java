package com.example.music_album.user;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/com/example/music_album/user/create_user.feature", // Path to your feature files
        glue = {"com.example.music_album.user", "com.example.music_album.configuration"}, // Path to step definitions and config
        plugin = {"pretty", "html:target/cucumber-reports.html"} // Optional: output plugins
)
public class CucumberTestRunner {
}
