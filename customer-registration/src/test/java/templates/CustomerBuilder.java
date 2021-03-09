package templates;

import com.angelina.customerregistration.dto.ClienteDTO;

public class CustomerBuilder {
    public static ClienteDTO getCliente(){
        return new ClienteDTO(1,"Angelina", 19, "angelina@cadmus.com.br", "47397074898");
    }
}
