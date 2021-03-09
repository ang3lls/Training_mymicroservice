package com.angelina.salesregistration.restTemplate;

import com.angelina.salesregistration.dto.ClienteDTO;
import com.angelina.salesregistration.dto.ProdutoDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Component
public class RequestProduct {
    public ProdutoDTO consultarProdutoById(Integer id)
    {
        final String uri = "http://localhost:9091/Produto/id/{id}";
        RestTemplate restTemplate = new RestTemplate();
        Map<String, String> params = new HashMap<String, String>();
        params.put("id", id.toString());
        return restTemplate.getForObject(uri, ProdutoDTO.class, params);
        //Use the result
    }
}
