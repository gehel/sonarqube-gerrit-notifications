package org.wikimedia.ci.sonarqube.notifications.entities.sonar;

import java.util.List;

import lombok.Data;

@Data
public class QualityGate {
    private final List<Condition> conditions;
    private final String name;
    private final String status;

    @Data
    public static class Condition {
        private final String errorThreshold;
        private final String metric;
        private final boolean onLeakPeriod;
        private final String operator;
        private final String status;
        private final String value;
    }
}
