package br.com.avanade.decolatech.barbershopbackend.controllers;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.avanade.decolatech.barbershopbackend.controllers.requests.SaveClientRequest;
import br.com.avanade.decolatech.barbershopbackend.controllers.requests.UpdateClientRequest;
import br.com.avanade.decolatech.barbershopbackend.controllers.responses.ClientDetailResponse;
import br.com.avanade.decolatech.barbershopbackend.controllers.responses.ListClientResponse;
import br.com.avanade.decolatech.barbershopbackend.controllers.responses.SaveClientResponse;
import br.com.avanade.decolatech.barbershopbackend.controllers.responses.UpdateClientResponse;
import br.com.avanade.decolatech.barbershopbackend.mappers.IClientMapper;
import br.com.avanade.decolatech.barbershopbackend.services.IClientService;
import br.com.avanade.decolatech.barbershopbackend.services.queries.IClientQueryService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("clients")
@AllArgsConstructor
public class ClientController {

    private final IClientService service;
    private final IClientQueryService queryService;
    private final IClientMapper mapper;

    @PostMapping
    @ResponseStatus(CREATED)
    SaveClientResponse save(@RequestBody @Valid final SaveClientRequest request) {
        var entity = mapper.toEntity(request);
        service.save(entity);
        return mapper.toSaveResponse(entity);
    }

    @PutMapping("{id}")
    UpdateClientResponse update(@PathVariable final long id, @RequestBody @Valid final UpdateClientRequest request) {
        var entity = mapper.toEntity(id, request);
        service.update(entity);
        return mapper.toUpdateResponse(entity);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    void delete(@PathVariable final long id) {
        service.delete(id);
    }

    @GetMapping("{id}")
    ClientDetailResponse findById(@PathVariable final long id) {
        var entity = queryService.findById(id);
        return mapper.toDetailResponse(entity);
    }

    @GetMapping
    List<ListClientResponse> list() {
        var entities = queryService.list();
        return mapper.toListResponse(entities);
    }

}
