package com.bewareofraj.userlist.users.objects;

/**
 * This object represents a User
 */
public class User {

    private int id;
    private String name;
    private String username;
    private String email;
    private String addressStreet;
    private String addressSuite;
    private String addressCity;
    private String addressZipcode;
    private String geoLat;
    private String geoLng;
    private String phone;
    private String website;
    private String companyName;
    private String companyCatchphrase;
    private String companyBs;

    public int getId() {
        return id;
    }

    public User setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getAddressStreet() {
        return addressStreet;
    }

    public User setAddressStreet(String addressStreet) {
        this.addressStreet = addressStreet;
        return this;
    }

    public String getAddressSuite() {
        return addressSuite;
    }

    public User setAddressSuite(String addressSuite) {
        this.addressSuite = addressSuite;
        return this;
    }

    public String getAddressCity() {
        return addressCity;
    }

    public User setAddressCity(String addressCity) {
        this.addressCity = addressCity;
        return this;
    }

    public String getAddressZipcode() {
        return addressZipcode;
    }

    public User setAddressZipcode(String addressZipcode) {
        this.addressZipcode = addressZipcode;
        return this;
    }

    public String getGeoLat() {
        return geoLat;
    }

    public User setGeoLat(String geoLat) {
        this.geoLat = geoLat;
        return this;
    }

    public String getGeoLng() {
        return geoLng;
    }

    public User setGeoLng(String geoLng) {
        this.geoLng = geoLng;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public User setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getWebsite() {
        return website;
    }

    public User setWebsite(String website) {
        this.website = website;
        return this;
    }

    public String getCompanyName() {
        return companyName;
    }

    public User setCompanyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    public String getCompanyCatchphrase() {
        return companyCatchphrase;
    }

    public User setCompanyCatchphrase(String companyCatchphrase) {
        this.companyCatchphrase = companyCatchphrase;
        return this;
    }

    public String getCompanyBs() {
        return companyBs;
    }

    public User setCompanyBs(String companyBs) {
        this.companyBs = companyBs;
        return this;
    }



}
