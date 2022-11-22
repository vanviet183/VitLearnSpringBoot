package com.vitvn183.demouploadfile.controllers;

import com.vitvn183.demouploadfile.base.VsResponseUtil;
import com.vitvn183.demouploadfile.entities.Document;
import com.vitvn183.demouploadfile.services.DocumentService;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/files")
//@CrossOrigin("http://localhost:8081")
public class DocumentController {

    @Autowired
    private DocumentService documentService;



    @GetMapping("")
    public ResponseEntity<?> getListFiles() {
        List<Document> files = documentService.getAllFiles();
        return ResponseEntity.status(HttpStatus.OK).body(files);
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<byte[]> getFile(@PathVariable Long id) {
//        Document file = documentService.getFile(id);
//        return ResponseEntity.ok()
//                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFileName() + "\"")
//                .body(file.getData());
//    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getFile(@PathVariable Long id) {
        Document file = documentService.getFile(id);
        return ResponseEntity.ok(VsResponseUtil.ok(documentService.getFile(id)));
    }

    @PostMapping("/upload")
    public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile multipartFile) throws IOException, JAXBException, Docx4JException {
        return ResponseEntity.ok(VsResponseUtil.ok(documentService.uploadFile(multipartFile)));
    }

//    @PostMapping("/upload")
//    public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file) {
//        String message = "";
//        try {
//            file.store(file);
//            message = "Uploaded the file successfully: " + file.getOriginalFilename();
//            try (XWPFDocument doc = new XWPFDocument(
//                    Files.newInputStream(Paths.get(Objects.requireNonNull(file.getOriginalFilename()))))) {
//
//                XWPFWordExtractor xwpfWordExtractor = new XWPFWordExtractor(doc);
//                String docText = xwpfWordExtractor.getText();
//                System.out.println(docText);
//
//                // find number of words in the document
//                long count = Arrays.stream(docText.split("\\s+")).count();
//                System.out.println("Total words: " + count);
//
//            }
//            return ResponseEntity.ok().body(file);
//        } catch (Exception e) {
//            message = "Could not upload the file: " + file.getOriginalFilename() + "!";
//            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
//        }
//    }


}
