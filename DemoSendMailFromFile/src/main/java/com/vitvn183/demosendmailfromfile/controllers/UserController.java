package com.vitvn183.demosendmailfromfile.controllers;

import com.vitvn183.demosendmailfromfile.entities.User;
import com.vitvn183.demosendmailfromfile.models.ReadFileExcel;
import com.vitvn183.demosendmailfromfile.models.UserExcelExporter;
import com.vitvn183.demosendmailfromfile.services.IUserService;
import com.vitvn183.demosendmailfromfile.utils.ConvertObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/users/export")
    public ResponseEntity<?> exportToExcel(HttpServletResponse res) throws IOException {
        res.setContentType("application/octet-stream");
        String headerKey = "Content-Disposition";
        String headerValue = "attachement; filename=user.xlsx";

        res.setHeader(headerKey, headerValue);

        //data
        List<User> users = userService.findAllUser();

        UserExcelExporter userExcelExporter = new UserExcelExporter(users);
        userExcelExporter.export(res);

        return ResponseEntity.ok("Export success");
    }

    @GetMapping("/users/import")
    public ResponseEntity<?> importExcelFile(@RequestParam(name = "file", required = true) MultipartFile file) throws IOException {
        List<User> users = ReadFileExcel.readFile(ConvertObject.convertMultipartToFile(file));

        return ResponseEntity.status(200).body(users);
    }

}
