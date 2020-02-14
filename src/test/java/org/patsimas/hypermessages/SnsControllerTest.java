package org.patsimas.hypermessages;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@TestPropertySource(properties = {"spring.application.name=SnsControllerTest",
        "spring.jmx.default-domain=SnsControllerTest"})
public class SnsControllerTest extends BasicWiremockTest {

    private static final String SUBJECT = "ARIS";

    private static final String TEXT = "ARIS FOREVER";

    private static final String EMAIL = "andreas-patsim@hotmail.com";

    @Test
    public void sendMassiveEmail() throws Exception {

        this.mockMvc.perform(get("/sns/massive/mail/{subject}/{text}", SUBJECT, TEXT))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void addSubscriber() throws Exception {

        this.mockMvc.perform(get("/sns/add/subscriber/{email}", EMAIL))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
