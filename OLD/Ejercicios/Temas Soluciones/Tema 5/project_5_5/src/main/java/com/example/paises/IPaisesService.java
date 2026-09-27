package com.example.paises;

import java.util.List;

public interface IPaisesService {
    void setPaises(List<Pais> paises);
    void setNombrePaises(List<String> nombrePaises);
    List<String> getPaises();
    Pais getPais(String nombre) throws PaisNotFoundException;
}
