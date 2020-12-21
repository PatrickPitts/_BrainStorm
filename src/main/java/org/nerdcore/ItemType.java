package org.nerdcore;

public enum ItemType{
    COMMON("cheap"), UNCOMMON("reasonable"), RARE("expensive"), LEGENDARY("one of a kind"),
    ARTIFACT("priceless");

    private String averageValue;
    private ItemType(String avgValue){
        averageValue = avgValue;
    }

    public String getAverageValue() {
        return averageValue;
    }

    public void setAverageValue(String averageValue) {
        this.averageValue = averageValue;
    }
}
