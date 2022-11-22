package com.vitvn183.demouploadfile.utils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class Unzip {
    public Unzip()
    {

    }
    public InputStream getStreamDocumentXml(File docx) throws IOException {
        ZipFile zipFile = new ZipFile(docx);
        ZipEntry zipEntry = zipFile.getEntry("word/document.xml");
        return zipFile.getInputStream(zipEntry);
    }
}
