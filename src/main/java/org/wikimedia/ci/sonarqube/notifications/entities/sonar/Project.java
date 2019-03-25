package org.wikimedia.ci.sonarqube.notifications.entities.sonar;

import lombok.Data;

@Data
public class Project {
    private final String key;
    private final String name;
}
