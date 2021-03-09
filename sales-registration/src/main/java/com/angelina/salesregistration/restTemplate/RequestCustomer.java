package com.angelina.salesregistration.restTemplate;

import com.angelina.salesregistration.dto.ClienteDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Component
public class RequestCustomer {
    public ClienteDTO consultarClienteById(Integer id)
    {
        final String uri = "http://localhost:9090/cliente/id/{id}";
        RestTemplate restTemplate = new RestTemplate();
        Map<String, String> params = new HashMap<String, String>();
        params.put("id", id.toString());
        return restTemplate.getForObject(uri, ClienteDTO.class, params);
        //Use the result
    }
}
