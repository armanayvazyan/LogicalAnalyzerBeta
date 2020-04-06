package com.company;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;


import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class  JsonParser{
        private ArrayList<String> objectsList,attributeList;
        private ArrayList<Companies> companiesList;
        private int revenue;
        private int paidusers;
        private int mau;
        private int urr;
        private int test;


        public void convertToJson() throws IOException {
        FileReader reader = new FileReader("C:\\Users\\37441\\IdeaProjects\\LogicalAnalyzerBeta\\src\\main\\resources\\logicalAnalizer.json");
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node =  mapper.readTree(reader);

        JsonNode attributeComparing = node.path("attribute_comparing");

        revenue =  attributeComparing.path("revenue").asInt();
        paidusers =  attributeComparing.path("paidusers").asInt();
        mau =  attributeComparing.path("mau").asInt();
        urr =  attributeComparing.path("urr").asInt();
        test =  attributeComparing.path("test").asInt();

        objectsList = new ArrayList<String>();
        for (int i = 0; i < node.path("objects").size(); i++) {
           objectsList.add(node.path("objects").get(i).asText());
        }

        attributeList = new ArrayList<String>();
        for (int i = 0; i < node.path("attributes").size(); i++) {
                attributeList.add(node.path("attributes").get(i).asText());
        }

        companiesList = new ArrayList<Companies>();
        for (int i = 0; i < node.path("companies").size(); i++) {
                String name  =  node.path("companies").get(i).path("name").asText();
                int revenue = node.path("companies").get(i).path("revenue").asInt();
                int paidusers = node.path("companies").get(i).path("paidusers").asInt();
                int mau = node.path("companies").get(i).path("mau").asInt();
                int urr = node.path("companies").get(i).path("urr").asInt();
                int test = node.path("companies").get(i).path("test").asInt();
                companiesList.add(new Companies(name,i+1,revenue,paidusers,mau,urr,test));
        }


        }



        public ArrayList<String> getObjectsList() {
                return objectsList;
        }

        public void setObjectsList(ArrayList<String> objectsList) {
                this.objectsList = objectsList;
        }

        public ArrayList<String> getAttributeList() {
                return attributeList;
        }

        public void setAttributeList(ArrayList<String> attributeList) {
                this.attributeList = attributeList;
        }

        public ArrayList<Companies> getCompaniesList() {
                return companiesList;
        }

        public void setCompaniesList(ArrayList<Companies> companiesList) {
                this.companiesList = companiesList;
        }
}