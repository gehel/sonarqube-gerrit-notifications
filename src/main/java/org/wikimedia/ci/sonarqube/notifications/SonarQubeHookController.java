package org.wikimedia.ci.sonarqube.notifications;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.wikimedia.ci.sonarqube.notifications.entities.sonar.WebHook;

@RestController
public class SonarQubeHookController {

    @PostMapping("/hooks/sonarqube")
    public void hook(@RequestBody WebHook notification) {
        System.out.println(notification);
    }

}
