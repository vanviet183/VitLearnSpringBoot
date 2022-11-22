package com.vitvn183.demosendmailfromfile.models;

import com.vitvn183.demosendmailfromfile.entities.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class UserExcelExporter {
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;

    private List<User> users;

    public void addUser(List<User> users) {
        users.add(new User(1, "vanviet1", "vanviet1", "nvv@gmail.com"));
        users.add(new User(2, "vanviet2", "vanviet2", "nvv@gmail.com"));
        users.add(new User(3, "vanviet3", "vanviet3", "nvv@gmail.com"));
        users.add(new User(4, "vanviet4", "vanviet4", "nvv@gmail.com"));
        users.add(new User(5, "vanviet5", "vanviet5", "nvv@gmail.com"));

    }

    public UserExcelExporter(List<User> users) {
        this.users = users;
        workbook = new XSSFWorkbook();
        sheet = workbook.createSheet("users");
    }

    private void writeHeader() {
        Row row = sheet.createRow(0);

        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);

        Cell cell = row.createCell(0);
        cell.setCellValue("id_user");
        cell.setCellStyle(style);
        sheet.autoSizeColumn(0);

        cell = row.createCell(1);
        cell.setCellValue("username");
        cell.setCellStyle(style);
        sheet.autoSizeColumn(1);

        cell = row.createCell(2);
        cell.setCellValue("password");
        cell.setCellStyle(style);
        sheet.autoSizeColumn(2);

        cell = row.createCell(3);
        cell.setCellValue("email");
        cell.setCellStyle(style);
        sheet.autoSizeColumn(3);
    }

    // style của data có thể làm như header
    private void writeData() {
        addUser(users);
        int cnt = 1;
        for(User user : users) {
            Row row = sheet.createRow(cnt);

            Cell cell = row.createCell(0);
            cell.setCellValue(user.getId());

            cell = row.createCell(1);
            cell.setCellValue(user.getUsername());

            cell = row.createCell(2);
            cell.setCellValue(user.getPassword());

            cell = row.createCell(3);
            cell.setCellValue(user.getEmail());

            cnt++;
        }
        try
        {
            //Write the workbook in file system
            FileOutputStream out = new FileOutputStream(new File("howtodoinjava_demo.xlsx"));
            workbook.write(out);
            out.close();
            System.out.println("howtodoinjava_demo.xlsx written successfully on disk.");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void export(HttpServletResponse res) throws IOException {
        writeHeader();
        writeData();

        ServletOutputStream outputStream = res.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }
}
