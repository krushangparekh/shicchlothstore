package com.example.ClothsStore.database;

public class UserModel {

    String ID,currentname,phone,email;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
    public String getcurrentname(String currentname) {
        return this.currentname; }

    public void setUsername(String username) {
        this.currentname = currentname;
    }
        public String getUserphone() {
            return currentname;
        }

        public void setUserphone(String phone) {
            this.phone = phone;
        }
        public String getUseremail() {
            return email;
        }

        public void setUseremail(String email) {
            this.email = email;
        }
    }