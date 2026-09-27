package com.example.myapp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class VehiculoService {

    @Autowired
    VehiculoRepository vehiculoRepository;

    private final Integer pageSize = 10;

    public List<Vehiculo> getVehiculosPaginados(Integer pageNum) {
        Pageable paging = PageRequest.of(pageNum, pageSize, Sort.by("modelo"));
        Page<Vehiculo> pagedResult = vehiculoRepository.findAll(paging);
        if (pagedResult.hasContent())
            return pagedResult.getContent();
        else
            return null;
    }

    public int getTotalPaginas() {
        Pageable paging = PageRequest.of(0, pageSize, Sort.by("modelo"));
        Page<Vehiculo> pagedResult = vehiculoRepository.findAll(paging);
        return pagedResult.getTotalPages();
    }

}
