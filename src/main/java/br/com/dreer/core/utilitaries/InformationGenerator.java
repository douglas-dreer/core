package br.com.dreer.core.utilitaries;

import br.com.dreer.core.entities.Address;
import br.com.dreer.core.entities.Document;
import br.com.dreer.core.enums.AddressType;
import br.com.dreer.core.enums.DocumentType;
import br.com.dreer.core.models.AddressDTO;
import br.com.dreer.core.models.DocumentDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
public class InformationGenerator {
    public DocumentDTO createDocumentDTO() {
        return DocumentDTO.builder()
                .id(UUID.randomUUID())
                .documentType(DocumentType.CPF)
                .number("12345678900")
                .createdAt(LocalDateTime.now().minusDays(1))
                .modifiedAt(LocalDateTime.now().plusHours(1))
                .build();
    }

    public Document createDocument() {
        return createDocumentDTO().toEntity();
    }

    public AddressDTO createAddressDTO() {
        return AddressDTO.builder()
                .id(UUID.randomUUID())
                .addressType(AddressType.RESIDENTIAL)
                .street("Avenida Brasil")
                .number(1500)
                .complement("n/a")
                .neighborhood("Centro")
                .city("São Paulo")
                .state("SP")
                .zipCode("0000000")
                .country("Brasil")
                .isMain(true)
                .createdAt(LocalDateTime.now().minusDays(1))
                .modifiedAt(LocalDateTime.now().plusDays(1))
                .build();
    }

    public Address createAddress() {
        return createAddressDTO().toEntity();
    }
}
