package de.linksideal.shelfie;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest()
@ActiveProfiles("development")
@AutoConfigureMockMvc
public class WebSecuritySpringBootIntegrationTest {

    @Autowired
    private MockMvc mockMvc;
    @Test
    public void whenGetProtectedViaWeb_thenForbidden() throws Exception {
        mockMvc.perform(get("/")).andExpect(status().isUnauthorized());
    }

    @Test
    @WithMockUser
    public void whenGetProtectedViaWebWithUser_thenOk() throws Exception {
        mockMvc.perform(get("/")).andExpect(status().isOk());
    }
}
