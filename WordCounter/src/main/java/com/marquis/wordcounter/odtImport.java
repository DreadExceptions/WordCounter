/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
        
package com.marquis.wordcounter;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.odf.OpenDocumentParser;
import org.apache.tika.sax.BodyContentHandler;
//import org.xml.sax.SAXException;

/**
 *
 * @author marquis
 */
public class odtImport {
    
    String location;
    BodyContentHandler handler;
    Metadata metadata;
    FileInputStream inputStream;
    ParseContext pcontext;
    OpenDocumentParser openParser;
    
    public odtImport (String url) throws Exception {
        this.location = url;
        this.handler = new BodyContentHandler();
        this.metadata = new Metadata();
        this.inputStream = new FileInputStream(new File(url));
        this.pcontext = new ParseContext();
        this.openParser = new OpenDocumentParser();
    }
    
    public String fullString() throws Exception {
        openParser.parse(inputStream, handler, metadata, pcontext);
        return this.handler.toString();
    }
    
}
