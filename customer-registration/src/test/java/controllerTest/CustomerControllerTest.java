package controllerTest;

import com.angelina.customerregistration.CustomerRegistrationApplication;
import com.angelina.customerregistration.controller.ClienteController;
import com.angelina.customerregistration.dto.ClienteDTO;
import com.angelina.customerregistration.repository.ClienteRepository;
import com.angelina.customerregistration.service.ClienteService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import templates.CustomerBuilder;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes= CustomerRegistrationApplication.class)
@WebMvcTest(ClienteController.class)
public class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private ClienteService clienteService;

    @MockBean
    private ClienteRepository clienteRepository;

    @Test
    private void deveCriarUmNovoCliente() throws Exception {
        ClienteDTO clienteDTO = CustomerBuilder.getCliente();
        mockMvc.perform(MockMvcRequestBuilders.post("/cliente/save")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(clienteDTO)))
                .andExpect(status().isCreated());
    }
}
