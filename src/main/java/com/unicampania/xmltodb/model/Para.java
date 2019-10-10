package com.unicampania.xmltodb.model;

import lombok.Getter;

import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlMixed;
import java.util.ArrayList;
import java.util.List;

public class Para {

    @Getter
    @XmlAttribute(name = "type")
    private String type;

    @Getter
    @XmlAttribute(name = "id")
    private String id = "";

    @Getter
    @XmlElement(name = "xref")
    private List<Xref> xrefs = new ArrayList<>();

    @Getter
    @XmlMixed
    private List<String> value = new ArrayList<>();

    @Getter
    @XmlElement(name = "list")
    private List<Lists> lists = new ArrayList<>();


    @Getter
    @XmlElement(name = "italic")
    private List<Italic> italics = new ArrayList<>();

    private List<String> combo = new ArrayList<>();

    public List<String> getCombo() {
        return merge(value, xrefs, italics);
    }


    @Override
    public String toString() {
        return "type= " + type + '\'' +
                "idi= " + id + '\'' +
                "combo= " + getCombo();
    }


    public static List<String> merge(List<String> a, List<Xref> b, List<Italic> c) {

        List<String> res = new ArrayList<>();
        for (int i = 0; i < a.size(); i++) {

            res.add(a.get(i).replaceAll("\r\n", " ").trim());
            if (b.size() != i && b.size() != 0) {
                res.add(b.get(i).toString().replace("[", "").replace("]", "").replaceAll("\r\n", " ").trim());
            }
            res.add(a.get(i).replaceAll("\r\n", " ").trim());
            if (c.size() != i && c.size() != 0) {
                res.add(c.get(i).toString().replace("[", "").replace("]", "").replaceAll("\r\n", " ").trim());
            }
        }
            return res;

    }
}
