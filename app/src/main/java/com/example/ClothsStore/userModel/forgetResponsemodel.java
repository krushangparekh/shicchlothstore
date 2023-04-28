package com.example.ClothsStore.userModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class forgetResponsemodel {
    @SerializedName("data")
    @Expose
    private Data data;
    public Data getData() {
        return data;
    }
    public void setData(Data data) {
        this.data = data;
    }
    public class Data {
        @SerializedName("customerRecover")
        @Expose
        private CustomerRecover customerRecover;

        public CustomerRecover getCustomerRecover() {
            return customerRecover;
        }
        public void setCustomerRecover(CustomerRecover customerRecover) {
            this.customerRecover = customerRecover;
        }
    }
    public static class CustomerRecover {

        @SerializedName("customerUserErrors")
        @Expose
        private List<Object> customerUserErrors;

        public List<Object> getCustomerUserErrors() {
            return customerUserErrors;
        }

        public void setCustomerUserErrors(List<Object> customerUserErrors) {
            this.customerUserErrors = customerUserErrors;
        }
    }
}

