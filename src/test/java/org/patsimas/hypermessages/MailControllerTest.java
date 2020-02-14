package org.patsimas.hypermessages;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@TestPropertySource(properties = {"spring.application.name=MailControllerTest",
        "spring.jmx.default-domain=MailControllerTest"})
public class MailControllerTest extends BasicWiremockTest {

    private static final String SUBJECT = "ARIS";

    private static final String TEXT = "ARIS FOREVER";

    @Test
    public void sendEmail() throws Exception {

        this.mockMvc.perform(get("/mail/{subject}/{text}", SUBJECT, TEXT))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
