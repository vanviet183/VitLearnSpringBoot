package com.vitvn183.demouploadfile.services.impl;

import com.vitvn183.demouploadfile.repositories.SegmentRepository;
import com.vitvn183.demouploadfile.services.DocumentService;
import com.vitvn183.demouploadfile.services.SegmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SegmentServiceImpl implements SegmentService {

    @Autowired
    private SegmentRepository segmentRepository;

//    public File store(MultipartFile file) throws IOException {
//        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
//        File file1 = new File(fileName, file.getContentType(), file.getBytes());
//        return fileRepository.save(File);
//    }


}
