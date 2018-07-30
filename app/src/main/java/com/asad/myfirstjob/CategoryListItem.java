package com.asad.myfirstjob;

public class CategoryListItem {

    private String ServiceCatID;
    private String ServiceCatDesc;
    private String CatImg;
    private String fromTime;
    private String toTime;

    public CategoryListItem(String serviceCatID, String serviceCatDesc, String catImg, String fromTime, String toTime) {
        ServiceCatID = serviceCatID;
        ServiceCatDesc = serviceCatDesc;
        CatImg = catImg;
        this.fromTime = fromTime;
        this.toTime = toTime;
    }

    public String getServiceCatID() {
        return ServiceCatID;
    }

    public String getServiceCatDesc() {
        return ServiceCatDesc;
    }

    public String getCatImg() {
        return CatImg;
    }

    public String getFromTime() {
        return fromTime;
    }

    public String getToTime() {
        return toTime;
    }
}
