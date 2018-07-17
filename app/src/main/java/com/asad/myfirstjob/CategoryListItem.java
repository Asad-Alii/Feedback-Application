package com.asad.myfirstjob;

public class CategoryListItem {

    private String ServiceCatID;
    private String ServiceCatDesc;
    private String CatImg;

    public CategoryListItem(String serviceCatID, String serviceCatDesc, String catImg) {
        ServiceCatID = serviceCatID;
        ServiceCatDesc = serviceCatDesc;
        CatImg = catImg;
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

}
