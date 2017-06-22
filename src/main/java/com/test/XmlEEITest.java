package com.test;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;

/**
 * Created by sichoon.kwon on 2017-06-22.
 */
public class XmlEEITest {
    public void xmlParseData(String xmlData) throws Exception {
            // xml가공 처리(xml Document생성)
            InputSource is = new InputSource(new StringReader(xmlData));

            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

            try {
//                dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
                // XML Entity Expansion Injection 공격 대응
//                dbf.setFeature("http://javax.xml.XMLConstants/feature/secure-processing", true);
//                dbf.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
                dbf.setFeature("http://xml.org/sax/features/external-general-entities", false);
                dbf.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
            } catch (Throwable throwable) {
            }

            DocumentBuilder dBuilder = dbf.newDocumentBuilder();

            Document doc = dBuilder.parse(is);

            NodeList nodeList = doc.getElementsByTagName("node");

        System.out.println(nodeList.item(0));
    }

    public static void main(String[] args) {
        try {
            XmlEEITest xet = new XmlEEITest();
            xet.xmlParseData("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                    "<system>\n" +
                    "  <node>\n" +
                    "    <count>1</count>\n" +
                    "    <name>Red Hat, Inc SCSI storage controller 0 channel(s)</name>\n" +
                    "    <type>raid</type>\n" +
                    "  </node>\n" +
                    "  <node>\n" +
                    "    <count>1</count>\n" +
                    "    <name>DIMM RAM 1024MB</name>\n" +
                    "    <type>mem</type>\n" +
                    "  </node>\n" +
                    "  <node>\n" +
                    "    <count>1</count>\n" +
                    "    <name>Intel Core Processor (Broadwell) 1 core(s)</name>\n" +
                    "    <type>cpu</type>\n" +
                    "  </node>\n" +
                    "</system>");
        } catch (Exception e) {

        }
    }
}
