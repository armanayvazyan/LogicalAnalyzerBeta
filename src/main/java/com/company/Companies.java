package com.company;

public class Companies {
    private String name;
    private int id;
    private int revenue ;
    private  int paidusers;
    private  int mau;
    private  int urr;
    private  int test;

    public Companies(String name, int id, int revenue, int paidusers, int mau, int urr, int test) {
        this.name = name;
        this.id = id;
        this.revenue = revenue;
        this.paidusers = paidusers;
        this.mau = mau;
        this.urr = urr;
        this.test = test;
    }

    @Override
    public String toString() {
        return "Companies{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", revenue=" + revenue +
                ", paidusers=" + paidusers +
                ", mau=" + mau +
                ", urr=" + urr +
                ", test=" + test +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRevenue() {
        return revenue;
    }

    public void setRevenue(int revenue) {
        this.revenue = revenue;
    }

    public int getPaidusers() {
        return paidusers;
    }

    public void setPaidusers(int paidusers) {
        this.paidusers = paidusers;
    }

    public int getMau() {
        return mau;
    }

    public void setMau(int mau) {
        this.mau = mau;
    }

    public int getTest() {
        return test;
    }

    public void setTest(int test) {
        this.test = test;
    }
}

