package com.example.myapp;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class RestClientService {

    private RestClient restClient;

    public RestClientService() {
        this.restClient = RestClient.create("https://jsonplaceholder.typicode.com");
    }

    public List<Todo> obtenerTodos() throws RuntimeException {
        String url = "/todos/";
        List<Todo> result = restClient.get()
                .uri(url)
                .retrieve()
                .body(new ParameterizedTypeReference<List<Todo>>() {
                });
        return result;
    }

    public Todo obtenerPorId(Integer id) throws RuntimeException {
        String url = "/todos/" + id;
        ResponseEntity<Todo> result = restClient.get()
                .uri(url)
                .retrieve()
                .toEntity(Todo.class);
        return result.getBody();
    }

    public void añadir(Todo todo) throws RuntimeException {
        String url = "/todos/";
        ResponseEntity<Void> result = restClient.post()
                .uri(url)
                .contentType(MediaType.APPLICATION_JSON)
                .body(todo)
                .retrieve()
                .toBodilessEntity();
    }
}
