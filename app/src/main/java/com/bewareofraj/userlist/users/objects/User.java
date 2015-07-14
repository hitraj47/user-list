package com.bewareofraj.userlist.users.objects;

import org.json.JSONException;
import org.json.JSONObject;

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
    private JSONObject userObject;

    public User(JSONObject object) throws JSONException {
        this.userObject = object;
        parseJsonObject(object);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddressStreet() {
        return addressStreet;
    }

    public void setAddressStreet(String addressStreet) {
        this.addressStreet = addressStreet;
    }

    public String getAddressSuite() {
        return addressSuite;
    }

    public void setAddressSuite(String addressSuite) {
        this.addressSuite = addressSuite;
    }

    public String getAddressCity() {
        return addressCity;
    }

    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity;
    }

    public String getAddressZipcode() {
        return addressZipcode;
    }

    public void setAddressZipcode(String addressZipcode) {
        this.addressZipcode = addressZipcode;
    }

    public String getGeoLat() {
        return geoLat;
    }

    public void setGeoLat(String geoLat) {
        this.geoLat = geoLat;
    }

    public String getGeoLng() {
        return geoLng;
    }

    public void setGeoLng(String geoLng) {
        this.geoLng = geoLng;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyCatchphrase() {
        return companyCatchphrase;
    }

    public void setCompanyCatchphrase(String companyCatchphrase) {
        this.companyCatchphrase = companyCatchphrase;
    }

    public String getCompanyBs() {
        return companyBs;
    }

    public void setCompanyBs(String companyBs) {
        this.companyBs = companyBs;
    }

    /**
     * This method parses a JSON Object and sets the fields to the User properties
     * @param object
     */
    public void parseJsonObject(JSONObject object) throws JSONException {
        this.userObject = object;

        setId(object.getInt("id"));
        setName(object.getString("name"));
        setUsername(object.getString("username"));
        setEmail(object.getString("email"));

        JSONObject addressObject = object.getJSONObject("address");
        setAddressStreet(addressObject.getString("street"));
        setAddressSuite(addressObject.getString("suite"));
        setAddressCity(addressObject.getString("city"));
        setAddressZipcode(addressObject.getString("zipcode"));

        JSONObject geoObject = addressObject.getJSONObject("geo");
        setGeoLat(geoObject.getString("lat"));
        setGeoLng(geoObject.getString("lng"));

        setPhone(object.getString("phone"));
        setWebsite(object.getString("website"));

        JSONObject companyObject = object.getJSONObject("company");
        setCompanyName(companyObject.getString("name"));
        setCompanyCatchphrase(companyObject.getString("catchPhrase"));
        setCompanyBs(companyObject.getString("bs"));
    }

    @Override
    public String toString() {
        return this.userObject.toString();
    }


}
