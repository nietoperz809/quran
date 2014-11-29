/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quran;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import misc.PathNames;

/**
 *
 * @author Administrator
 */
public class QuranMetadata implements PathNames
{
    private static QuranMetadata m_this;
    private final Document m_document;
    private final ArrayList<SuraInfo> m_suras = new ArrayList<>();

    public class SuraInfo
    {
        public int index;
        public int ayas;
        public int start;
        public String name;
        public String tname;
        public String ename;
        public String type;
        public int order;
        public int rukus;

        public SuraInfo ()
        {
            
        }
        
        public SuraInfo (SuraInfo src)
        {
            index = src.index;
            ayas = src.ayas;
            start = src.start;
            name = src.name;
            tname = src.tname;
            ename = src.ename;
            type = src.type;
            order = src.order;
            rukus = src.rukus;
        }
    }
    
    public SuraInfo getSuraInfo(int idx) throws CloneNotSupportedException
    {
        for (SuraInfo s : m_suras)
        {
            if (s.index == idx)
                return new SuraInfo(s);
        }
        return null;
    }
    
    private void iterate(NamedNodeMap attributesList)
    {
        for (int j = 0; j < attributesList.getLength(); j++)
        {
            System.out.println("Attribute: "
                    + attributesList.item(j).getNodeName() + " = "
                    + attributesList.item(j).getNodeValue());
        }
    }

    private void traverseXML(Node node)
    {
        // do something with the current node instead of System.out
        if ("sura".equals(node.getNodeName()))
        {
            NamedNodeMap attr = node.getAttributes();
            SuraInfo sura = new SuraInfo();
            sura.index = Integer.parseInt(attr.getNamedItem("index").getNodeValue());
            sura.ayas = Integer.parseInt(attr.getNamedItem("ayas").getNodeValue());
            sura.order = Integer.parseInt(attr.getNamedItem("order").getNodeValue());
            sura.rukus = Integer.parseInt(attr.getNamedItem("rukus").getNodeValue());
            sura.start = Integer.parseInt(attr.getNamedItem("start").getNodeValue());
            sura.ename = attr.getNamedItem("ename").getNodeValue();
            sura.name = attr.getNamedItem("name").getNodeValue();
            sura.tname = attr.getNamedItem("tname").getNodeValue();
            sura.type = attr.getNamedItem("type").getNodeValue();
            m_suras.add(sura);
        }

        NodeList nodeList = node.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++)
        {
            Node currentNode = nodeList.item(i);
            if (currentNode.getNodeType() == Node.ELEMENT_NODE)
            {
                traverseXML(currentNode);
            }
        }
    }

    private QuranMetadata() throws ParserConfigurationException, SAXException, IOException
    {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        m_document = builder.parse(new File(MetaDataPath));
        Node n = m_document.getFirstChild();
        traverseXML (n);
    }

    public static QuranMetadata get()
    {
        if (m_this == null)
        {
            try
            {
                m_this = new QuranMetadata();
            }
            catch (ParserConfigurationException | SAXException | IOException ex)
            {
                return null;
            }
        }
        return m_this;
    }
}

