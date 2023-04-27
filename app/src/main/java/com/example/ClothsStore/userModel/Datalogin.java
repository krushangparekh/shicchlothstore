package com.example.ClothsStore.userModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Datalogin {
    @SerializedName("data")
    @Expose
    private com.example.ClothsStore.userModel.loginResponsemodel.Data data;

    public com.example.ClothsStore.userModel.loginResponsemodel.Data getData() {
        return data;
    }

    public void setData(com.example.ClothsStore.userModel.loginResponsemodel.Data data) {
        this.data = data;
    }

    @SerializedName("customerAccessTokenCreate")
    @Expose
    private CustomerAccessTokenCreate customerAccessTokenCreate;

    public CustomerAccessTokenCreate getCustomerAccessTokenCreate() {
        return customerAccessTokenCreate;
    }

    public void setCustomerAccessTokenCreate(CustomerAccessTokenCreate customerAccessTokenCreate) {
        this.customerAccessTokenCreate = customerAccessTokenCreate;
    }

}

class CustomerAccessToken {

    @SerializedName("accessToken")
    @Expose
    private String accessToken;
    @SerializedName("expiresAt")
    @Expose
    private String expiresAt;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(String expiresAt) {
        this.expiresAt = expiresAt;
    }

}

class CustomerAccessTokenCreate {

    @SerializedName("customerAccessToken")
    @Expose
    private CustomerAccessToken customerAccessToken;
    @SerializedName("customerUserErrors")
    @Expose
    private List<Object> customerUserErrors;

    public CustomerAccessToken getCustomerAccessToken() {
        return customerAccessToken;
    }

    public void setCustomerAccessToken(CustomerAccessToken customerAccessToken) {
        this.customerAccessToken = customerAccessToken;
    }

    public List<Object> getCustomerUserErrors() {
        return customerUserErrors;
    }

    public void setCustomerUserErrors(List<Object> customerUserErrors) {
        this.customerUserErrors = customerUserErrors;
    }
}






