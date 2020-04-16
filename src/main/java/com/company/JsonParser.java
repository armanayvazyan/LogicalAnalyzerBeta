package com.company;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

class JsonParser {
    private ArrayList<Attribute> attributeList;
    private ArrayList<Company> companyList;

    void convertToJson() throws IOException {
        FileReader reader = new FileReader("/Users/artomaranjyan/IdeaProjects/LogicalAnalyzerBeta/src/main/resources/logicalAnalizer.json");
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(reader);

        attributeList = new ArrayList<>();
        Collections.addAll(attributeList,
                new Attribute("revenue", node.path("attribute_comparing").path("revenue").asInt()),
                new Attribute("paidusers", node.path("attribute_comparing").path("paidusers").asInt()),
                new Attribute("mau", node.path("attribute_comparing").path("mau").asInt()),
                new Attribute("urr", node.path("attribute_comparing").path("urr").asInt()),
                new Attribute("test", node.path("attribute_comparing").path("test").asInt()));

        companyList = new ArrayList<>();
        for (int i = 0; i < node.path("companies").size(); i++) {
            String name = node.path("companies").get(i).path("name").asText();
            Attribute revenue = new Attribute("revenue", node.path("companies").get(i).path("revenue").asInt());
            Attribute paidUsers = new Attribute("paidusers", node.path("companies").get(i).path("paidusers").asInt());
            Attribute mau = new Attribute("mau", node.path("companies").get(i).path("mau").asInt());
            Attribute urr = new Attribute("urr", node.path("companies").get(i).path("urr").asInt());
            Attribute test = new Attribute("test", node.path("companies").get(i).path("test").asInt());
            ArrayList<Attribute> attributes = new ArrayList<Attribute>();
            Collections.addAll(attributes, revenue, paidUsers, mau, urr, test);

            companyList.add(new Company(name, i + 1, attributes));
        }
    }

    ArrayList<Attribute> getAttributeList() {
        return attributeList;
    }

    ArrayList<Company> getCompaniesList() {
        return companyList;
    }
}