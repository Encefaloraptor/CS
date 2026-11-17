package com.Greg.VotarPeli;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

//this is the envelop that holds the data during each request
//Holds	one email + one film choice, Lives	one request
//Rules	format: not empty, valid email, film chosen

@Getter 
@Setter 
public class FormVoto {
    
    @Email(message = "{voto.email.formato}")
    @NotBlank(message = "{voto.email.vacio}")
    private String email;

    @NotNull(message = "{voto.pelicula.vacia}")
    @Min(value = 0, message="{voto.pelicula.rango}") 
    @Max(value = 2, message="{voto.pelicula.rango}") 
    private Integer movieIndex; 

}
