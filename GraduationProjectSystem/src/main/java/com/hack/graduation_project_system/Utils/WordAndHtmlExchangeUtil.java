package com.hack.graduation_project_system.Utils;

import java.io.*;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.converter.WordToHtmlConverter;
import org.apache.poi.xwpf.converter.core.BasicURIResolver;
import org.apache.poi.xwpf.converter.core.FileImageExtractor;
import org.apache.poi.xwpf.converter.xhtml.XHTMLConverter;
import org.apache.poi.xwpf.converter.xhtml.XHTMLOptions;
import org.apache.poi.xwpf.usermodel.XWPFDocument;


public class WordAndHtmlExchangeUtil {

    public final static String UPLOAD_PATH_PREFIX = "static\\uploadFile\\";
    public final static String UPLOAD_PATH_TARGET = "target\\classes\\static\\uploadFile\\";

    /**
     * doc转换为html
     *
     * @param fileName
     * @param outPutFile
     * @throws TransformerException
     * @throws IOException
     * @throws ParserConfigurationException
     */
    public static String docToHtml(String fileName, String outPutFile, String userId) throws Exception {
        String path = new String("src\\main\\resources\\" + UPLOAD_PATH_PREFIX + "\\" + userId);
        String imagePathStr = path + "\\image\\";
        String sourceFileName = fileName;
        String targetFileName = path + "\\" + outPutFile;
        File file1 = new File(path);
        if (!file1.exists()) {
            file1.mkdirs();
        }
        File file2 = new File(imagePathStr);
        if (!file2.exists()) {
            file2.mkdirs();
        }

        HWPFDocument wordDocument = new HWPFDocument(new FileInputStream(sourceFileName));
        org.w3c.dom.Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        WordToHtmlConverter wordToHtmlConverter = new WordToHtmlConverter(document);
        //保存图片，并返回图片的相对路径
        wordToHtmlConverter.setPicturesManager((content, pictureType, name, width, height) -> {
            try (FileOutputStream out = new FileOutputStream(imagePathStr + name)) {
                out.write(content);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return "image/" + name;
        });
        wordToHtmlConverter.processDocument(wordDocument);
        org.w3c.dom.Document htmlDocument = wordToHtmlConverter.getDocument();
        DOMSource domSource = new DOMSource(htmlDocument);
        StreamResult streamResult = new StreamResult(new File(targetFileName));
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer serializer = tf.newTransformer();
        serializer.setOutputProperty(OutputKeys.ENCODING, "utf-8");
        serializer.setOutputProperty(OutputKeys.INDENT, "yes");
        serializer.setOutputProperty(OutputKeys.METHOD, "html");
        serializer.transform(domSource, streamResult);
        return targetFileName;
    }

    public static String docToHtmlToTarget(String fileName, String outPutFile, String userId) throws Exception {
        String path = UPLOAD_PATH_TARGET + "\\" + userId;
        String imagePathStr = path + "\\image\\";
        String sourceFileName = fileName;
        String targetFileName = path + "\\" + outPutFile;
        File file1 = new File(path);
        if (!file1.exists()) {
            file1.mkdirs();
        }
        File file2 = new File(imagePathStr);
        if (!file2.exists()) {
            file2.mkdirs();
        }

        HWPFDocument wordDocument = new HWPFDocument(new FileInputStream(sourceFileName));
        org.w3c.dom.Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        WordToHtmlConverter wordToHtmlConverter = new WordToHtmlConverter(document);
        //保存图片，并返回图片的相对路径
        wordToHtmlConverter.setPicturesManager((content, pictureType, name, width, height) -> {
            try (FileOutputStream out = new FileOutputStream(imagePathStr + name)) {
                out.write(content);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return "image/" + name;
        });
        wordToHtmlConverter.processDocument(wordDocument);
        org.w3c.dom.Document htmlDocument = wordToHtmlConverter.getDocument();
        DOMSource domSource = new DOMSource(htmlDocument);
        StreamResult streamResult = new StreamResult(new File(targetFileName));
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer serializer = tf.newTransformer();
        serializer.setOutputProperty(OutputKeys.ENCODING, "utf-8");
        serializer.setOutputProperty(OutputKeys.INDENT, "yes");
        serializer.setOutputProperty(OutputKeys.METHOD, "html");
        serializer.transform(domSource, streamResult);
        return targetFileName;
    }


    /**
     * 写文件
     *
     * @param content
     * @param path
     */
    public static void writeFile(String content, String path) {
        FileOutputStream fos = null;
        BufferedWriter bw = null;
        try {
            File file = new File(path);
            fos = new FileOutputStream(file);
            bw = new BufferedWriter(new OutputStreamWriter(fos, "utf-8"));
            bw.write(content);
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            try {
                if (bw != null)
                    bw.close();
                if (fos != null)
                    fos.close();
            } catch (IOException ie) {
            }
        }
    }

    /**
     * docx格式word转换为html
     *
     * @param fileName   docx文件路径
     * @param outPutFile html输出文件路径
     * @throws TransformerException
     * @throws IOException
     * @throws ParserConfigurationException
     */
    public static String docxToHtml(String fileName, String outPutFile, String userId) throws Exception {
        String path = new String("src\\main\\resources\\" + UPLOAD_PATH_PREFIX + "\\" + userId);
        String imagePath = path + "\\image\\";
        String sourceFileName = fileName;
        String targetFileName = path + "\\" + outPutFile;
        File file2 = new File(path);
        if (!file2.exists()) {
            file2.mkdirs();
        }
        File file1 = new File(imagePath);
        if (!file1.exists()) {
            file1.mkdirs();
        }

        OutputStreamWriter outputStreamWriter = null;
        try {
            XWPFDocument document = new XWPFDocument(new FileInputStream(sourceFileName));
            XHTMLOptions options = XHTMLOptions.create();
            // 存放图片的文件夹
            options.setExtractor(new FileImageExtractor(new File(imagePath)));
            // html中图片的路径
            options.URIResolver(new BasicURIResolver("image"));
            outputStreamWriter = new OutputStreamWriter(new FileOutputStream(targetFileName), "utf-8");
            XHTMLConverter xhtmlConverter = (XHTMLConverter) XHTMLConverter.getInstance();
            xhtmlConverter.convert(document, outputStreamWriter, options);
        } finally {
            if (outputStreamWriter != null) {
                outputStreamWriter.close();
            }
        }
        return targetFileName;
    }

    public static String docxToHtmlToTarget(String fileName, String outPutFile, String userId) throws Exception {
        String path = UPLOAD_PATH_TARGET + "\\" + userId;
        String imagePath = path + "\\image\\";
        String sourceFileName = fileName;
        String targetFileName = path + "\\" + outPutFile;
        File file2 = new File(path);
        if (!file2.exists()) {
            file2.mkdirs();
        }
        File file1 = new File(imagePath);
        if (!file1.exists()) {
            file1.mkdirs();
        }

        OutputStreamWriter outputStreamWriter = null;
        try {
            XWPFDocument document = new XWPFDocument(new FileInputStream(sourceFileName));
            XHTMLOptions options = XHTMLOptions.create();
            // 存放图片的文件夹
            options.setExtractor(new FileImageExtractor(new File(imagePath)));
            // html中图片的路径
            options.URIResolver(new BasicURIResolver("image"));
            outputStreamWriter = new OutputStreamWriter(new FileOutputStream(targetFileName), "utf-8");
            XHTMLConverter xhtmlConverter = (XHTMLConverter) XHTMLConverter.getInstance();
            xhtmlConverter.convert(document, outputStreamWriter, options);
        } finally {
            if (outputStreamWriter != null) {
                outputStreamWriter.close();
            }
        }
        return targetFileName;
    }
}
