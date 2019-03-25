package org.wikimedia.ci.sonarqube.notifications.entities.sonar;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.Properties;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data()
public class WebHook {
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssZ", timezone = "UTC")
    private final LocalDateTime analysedAt;
    private final Project project;
    private final Properties properties;
    private final QualityGate qualityGate;
    private final URL serverUrl;
    private final String status;
    private final String taskId;
}
