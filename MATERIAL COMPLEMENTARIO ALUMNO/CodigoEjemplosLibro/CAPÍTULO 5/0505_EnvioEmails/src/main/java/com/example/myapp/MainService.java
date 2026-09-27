package com.example.myapp;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class MainService {
    private final String rootFolder = "uploadDir"; // carpeta para los archivos
    private final Path rootLocation = Paths.get(rootFolder);

    @Autowired
    private JavaMailSender sender;

    public String storeFile(MultipartFile file, FormInfo formInfo) {
        if (file.isEmpty())
            return null;
        String filename = StringUtils.cleanPath(file.getOriginalFilename());
        if (filename.contains(".."))
            return null;
        String extension = StringUtils.getFilenameExtension(filename);
        String storedFilename = System.currentTimeMillis() + "." + extension;
        try (InputStream inputStream = file.getInputStream()) {
            Files.copy(inputStream, this.rootLocation.resolve(storedFilename),
                    StandardCopyOption.REPLACE_EXISTING);
            return storedFilename;
        } catch (IOException ioe) {
            return null;
        }
    }

    public boolean enviarEmail(String destination, String subject, String textMessage, String archivo) {
        try {
            MimeMessage message = sender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setTo(destination);
            helper.setText(textMessage);
            helper.setSubject(subject);

            File archivoAdjunto = new File(rootFolder + "/" + archivo);
            helper.addAttachment(archivoAdjunto.getName(), archivoAdjunto);
            sender.send(message);
            return true;
        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        }
    }
}
