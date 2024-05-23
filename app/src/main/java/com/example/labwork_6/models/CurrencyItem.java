package com.example.labwork_6.models;

public class CurrencyItem {

    private  String value;
    private String name;



    public CurrencyItem(String value,
                        String name) {


        this.value = value;
        this.name = name;

    }



    public String getValue() {
        return value;
    }

    public String getName() {
        return name;
    }



    public void setValue(String value) {
        this.value = value;
    }

    public void setName(String name) {
        this.name = name;
    }

}
