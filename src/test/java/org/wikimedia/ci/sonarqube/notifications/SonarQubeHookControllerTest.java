package org.wikimedia.ci.sonarqube.notifications;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.wikimedia.ci.sonarqube.notifications.entities.sonar.WebHook;

import com.google.common.io.ByteStreams;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SonarqubeGerritNotificationsApplication.class)
@WebAppConfiguration
public class SonarQubeHookControllerTest {

    protected MockMvc mvc;

    @Autowired
    WebApplicationContext webApplicationContext;

    @Before
    public void initMvc() {
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void hookReceived() throws Exception {
        MvcResult mvcResult = mvc.perform(post("/hooks/sonarqube")
                .content(loadJson())
                .contentType(APPLICATION_JSON)
                .accept(APPLICATION_JSON)
        ).andReturn();
        assertThat(mvcResult.getResponse().getStatus()).isEqualTo(200);
    }

    private byte[] loadJson() throws IOException {
        ClassPathResource resource = new ClassPathResource("sonar-webhook.json", WebHook.class);
        return ByteStreams.toByteArray(resource.getInputStream());
    }

}
