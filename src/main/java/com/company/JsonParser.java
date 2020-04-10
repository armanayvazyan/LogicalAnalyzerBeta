package com.company;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class JsonParser {
    private ArrayList<Attribute> attributeList;
    private ArrayList<Companie> companieList;

    public void convertToJson() throws IOException {
        FileReader reader = new FileReader("/Users/artomaranjyan/IdeaProjects/LogicalAnalyzerBeta/src/main/resources/logicalAnalizer.json");
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(reader);

        attributeList = new ArrayList<Attribute>();
        for (int i = 0; i < node.path("attribute_comparing").size(); i++) {
            attributeList.add(new Attribute(node.path("attribute_comparing").get(i).asText()));
        }

        companieList = new ArrayList<Companie>();
        for (int i = 0; i < node.path("companies").size(); i++) {
            String name = node.path("companies").get(i).path("name").asText();
            Attribute revenue = new Attribute("revenue", node.path("companies").get(i).path("revenue").asInt());
            Attribute paidusers = new Attribute("paidusers", node.path("companies").get(i).path("paidusers").asInt());
            Attribute mau = new Attribute("mau", node.path("companies").get(i).path("mau").asInt());
            Attribute urr = new Attribute("urr", node.path("companies").get(i).path("urr").asInt());
            Attribute test = new Attribute("test", node.path("companies").get(i).path("test").asInt());
            ArrayList<Attribute> attributes = new ArrayList<Attribute>();
            Collections.addAll(attributes, revenue, paidusers, mau, urr, test);

            companieList.add(new Companie(name, i + 1, attributes);
        }
    }

    public ArrayList<Attribute> getAttributeList() {
        return attributeList;
    }

    public ArrayList<Companie> getCompanieList() {
        return companieList;
    }
}