package com.example.ClothsStore.userModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class loginResponsemodel {
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private Data data;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public class Data {

        @SerializedName("user")
        @Expose
        private User user;

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }

        public class User {

            @SerializedName("id")
            @Expose
            private Integer id;
            @SerializedName("first_name")
            @Expose
            private String firstName;
            @SerializedName("last_name")
            @Expose
            private String lastName;
            @SerializedName("email")
            @Expose
            private String email;
            @SerializedName("phone")
            @Expose
            private Object phone;
            @SerializedName("email_verified_at")
            @Expose
            private Object emailVerifiedAt;
            @SerializedName("address")
            @Expose
            private Object address;
            @SerializedName("city")
            @Expose
            private Object city;
            @SerializedName("country")
            @Expose
            private Object country;
            @SerializedName("postal")
            @Expose
            private Object postal;
            @SerializedName("about")
            @Expose
            private Object about;
            @SerializedName("created_at")
            @Expose
            private String createdAt;
            @SerializedName("updated_at")
            @Expose
            private String updatedAt;
            @SerializedName("avatar")
            @Expose
            private Object avatar;

            public Integer getId() {
                return id;
            }

            public void setId(Integer id) {
                this.id = id;
            }

            public String getFirstName() {
                return firstName;
            }

            public void setFirstName(String firstName) {
                this.firstName = firstName;
            }

            public String getLastName() {
                return lastName;
            }

            public void setLastName(String lastName) {
                this.lastName = lastName;
            }

            public String getEmail() {
                return email;
            }

            public void setEmail(String email) {
                this.email = email;
            }

            public Object getPhone() {
                return phone;
            }

            public void setPhone(Object phone) {
                this.phone = phone;
            }

            public Object getEmailVerifiedAt() {
                return emailVerifiedAt;
            }

            public void setEmailVerifiedAt(Object emailVerifiedAt) {
                this.emailVerifiedAt = emailVerifiedAt;
            }

            public Object getAddress() {
                return address;
            }

            public void setAddress(Object address) {
                this.address = address;
            }

            public Object getCity() {
                return city;
            }

            public void setCity(Object city) {
                this.city = city;
            }

            public Object getCountry() {
                return country;
            }

            public void setCountry(Object country) {
                this.country = country;
            }

            public Object getPostal() {
                return postal;
            }

            public void setPostal(Object postal) {
                this.postal = postal;
            }

            public Object getAbout() {
                return about;
            }

            public void setAbout(Object about) {
                this.about = about;
            }

            public String getCreatedAt() {
                return createdAt;
            }

            public void setCreatedAt(String createdAt) {
                this.createdAt = createdAt;
            }

            public String getUpdatedAt() {
                return updatedAt;
            }

            public void setUpdatedAt(String updatedAt) {
                this.updatedAt = updatedAt;
            }

            public Object getAvatar() {
                return avatar;
            }

            public void setAvatar(Object avatar) {
                this.avatar = avatar;
            }

        }

    }
}







  /*  @SerializedName("data")
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
    public class CustomerRecover {

        @SerializedName("customerUserErrors")
        @Expose
        private List<Object> customerUserErrors;

        public List<Object> getCustomerUserErrors() {
            return customerUserErrors;
        }

        public void setCustomerUserErrors(List<Object> customerUserErrors) {
            this.customerUserErrors = customerUserErrors;
        }
    }*/