package com.asad.myfirstjob;

public class ListItem {

    private String ServiceCatID;
    private String ServiceCatDesc;
    private String CatImg;

    public ListItem(String serviceCatID, String serviceCatDesc, String catImg) {
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

    /*private String id;
    private String name;
    private String email;
    private String address;
    private String gender;

    public ListItem(String id, String name, String email, String address, String gender) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getGender() {
        return gender;
    }*/
}
