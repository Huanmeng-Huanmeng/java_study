package com.study.doc.xml;

public class FaultCode {
    String code;
    String name;
    String source;
    String category;

    public FaultCode() {
    }

    public FaultCode(String code, String name, String source, String category) {
        this.code = code;
        this.name = name;
        this.source = source;
        this.category = category;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "FaultCode{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", source='" + source + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
