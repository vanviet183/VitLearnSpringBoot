package com.vitvn183.demouploadfile.services;

import com.vitvn183.demouploadfile.entities.Document;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.List;

@Service
public interface DocumentService {

    Document getFile(Long id);

    List<Document> getAllFiles();

    Document uploadFile(MultipartFile multipartFile) throws IOException, Docx4JException, JAXBException;

    Document deleteDocument(Long id);

}
