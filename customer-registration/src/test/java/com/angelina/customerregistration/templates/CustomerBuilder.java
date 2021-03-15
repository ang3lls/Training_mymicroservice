package com.angelina.customerregistration.templates;

import com.angelina.customerregistration.dto.ClienteDTO;

import java.util.Arrays;
import java.util.List;

public class CustomerBuilder {
    public static ClienteDTO getCliente(){
        return new ClienteDTO(1,"Angelina", 19, "angelina@cadmus.com.br", "47397074898");
    }

    public static List<ClienteDTO> getClientes(){
        return Arrays.asList(
                new ClienteDTO(1,"Angelina", 19, "angelina@cadmus.com.br", "47397074898"),
                new ClienteDTO(2,"Maria", 40, "maria@cadmus.com.br", "27114585802"));
    }
}

