package com.vitvn183.demouploadfile.services.impl;

import com.vitvn183.demouploadfile.entities.Document;
import com.vitvn183.demouploadfile.repositories.DocumentRepository;
import com.vitvn183.demouploadfile.services.DocumentService;
import com.vitvn183.demouploadfile.utils.ReadFile;
import org.docx4j.XmlUtils;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.WordprocessingML.MainDocumentPart;
import org.docx4j.wml.P;
import org.docx4j.wml.PPr;
import org.docx4j.wml.Text;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

@Service
public class DocumentServiceImpl implements DocumentService {

    @Autowired
    private DocumentRepository documentRepository;

    public Document getFile(Long id) {
        return documentRepository.findById(id).get();
    }

    public List<Document> getAllFiles() {          // thực hiện song song code với sự trợ giúp của stream.
        return documentRepository.findAll();
    }

    @Override
    public Document uploadFile(MultipartFile multipartFile) throws IOException, Docx4JException, JAXBException {
        String sourceFile = "E:\\Self_Learning\\VitLearnSpringBoot\\DemoUploadFile\\" + multipartFile.getOriginalFilename();

        File file = new File(sourceFile);
        WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage.load(file);
        MainDocumentPart mainDocumentPart = wordMLPackage.getMainDocumentPart();
        String textNodesXPath = "//w:t";
        List<Object> textNodes= mainDocumentPart.getJAXBNodesViaXPath(textNodesXPath, true);
        for (Object obj : textNodes) {
            Text t = (Text) ((JAXBElement) obj).getValue();
            String textValue = t.getValue();
            System.out.println(textValue);
        }
        return null;
    }


    @Override
    public Document deleteDocument(Long id) {
        return null;
    }
}
