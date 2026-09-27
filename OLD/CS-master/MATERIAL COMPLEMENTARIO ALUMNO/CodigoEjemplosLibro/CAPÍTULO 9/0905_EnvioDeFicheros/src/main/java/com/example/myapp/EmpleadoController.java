package com.example.myapp;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class EmpleadoController {

    @Autowired
    public EmpleadoService empleadoService;

    @Autowired
    public FileStorageService fileStorageService;

    @GetMapping("/empleado")
    public ResponseEntity<?> getList() {
        List<Empleado> listaEmpleados = empleadoService.obtenerTodos();
        if (listaEmpleados == null)
            return ResponseEntity.notFound().build(); // cod 404
        else
            return ResponseEntity.ok(listaEmpleados); // cod 200
    }

    @GetMapping("/empleado/{id}")
    public ResponseEntity<?> getOneElement(@PathVariable Long id) {
        Empleado empleado = empleadoService.obtenerPorId(id);
        if (empleado == null)
            return ResponseEntity.notFound().build(); // cod 404
        else
            return ResponseEntity.ok(empleado); // cod 200
    }

    @PostMapping(value = "/empleado", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> newElement(@RequestPart("data") Empleado nuevoEmpleado,
            @RequestPart("file") MultipartFile file) { // imagen que se envía
        if (!file.isEmpty()) {
            try {
                nuevoEmpleado.setImagen(fileStorageService.store(file));
            } catch (Exception e) {
                nuevoEmpleado.setImagen(null);
            }
        } else
            nuevoEmpleado.setImagen(null);

        Empleado empleado = empleadoService.añadir(nuevoEmpleado);
        return ResponseEntity.status(HttpStatus.CREATED).body(empleado);
    }

    @PutMapping(value = "/empleado/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> editElement(@RequestPart("data") Empleado editEmpleado,
            @RequestPart("file") MultipartFile file,
            @PathVariable Long id) {

        Empleado empleado = empleadoService.obtenerPorId(id);
        if (empleado == null)
            return ResponseEntity.notFound().build(); // cod 404

        fileStorageService.delete(empleado.getImagen());
        if (!file.isEmpty()) {
            try {
                editEmpleado.setImagen(fileStorageService.store(file));
            } catch (Exception e) {
                editEmpleado.setImagen(null);
            }
        } else
            editEmpleado.setImagen(null);
        empleado = empleadoService.editar(editEmpleado);
        return ResponseEntity.ok(empleado);

    }

    @DeleteMapping("/empleado/{id}")
    public ResponseEntity<?> deleteElement(@PathVariable Long id) {
        Empleado empleado = empleadoService.obtenerPorId(id);
        if (empleado == null)
            return ResponseEntity.notFound().build(); // cod 404
        fileStorageService.delete(empleado.getImagen());
        empleadoService.borrar(id);
        return ResponseEntity.noContent().build(); // cod 204
    }

    @GetMapping(value = "/files/{filename:.+}")
    public ResponseEntity<Resource> serveFile(@PathVariable String filename, HttpServletRequest request) {
        Resource file = fileStorageService.loadAsResource(filename);
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(file.getFile().getAbsolutePath());
        } catch (IOException ex) {
            System.err.println("No se puede determinar el tipo de archivo.");
        }
        if (contentType == null) {
            contentType = "application/octet-stream";
        }
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .body(file);
    }

}
