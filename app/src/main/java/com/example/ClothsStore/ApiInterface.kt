package com.example.ClothsStore

import com.example.ClothsStore.activity.productListModel
import com.example.ClothsStore.ViewAdapter.ProductDetailedModel1
import com.example.ClothsStore.userModel.Datalogin
import com.example.ClothsStore.userModel.MySignupmodel
import com.example.ClothsStore.userModel.forgetResponsemodel
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface ApiInterface {
    //@Headers("Content-Type: application/json")
    @FormUrlEncoded
    @POST("register")
    @Headers("Content-Type:application/x-www-form-urlencoded; charset=utf-8")
    fun registerUser(
        @Field("first_name") etFirstName: String,
        @Field("last_name") etLastName: String,
        @Field(encoded = true, value = "email") etEmail: String,
        @Field("password") etPassword: String,
        @Field("password_confirmation") C_Password: String): Call<MySignupmodel>

    @FormUrlEncoded
    @POST("login")
    fun loginUser(
        @Field("email") email: String,
        @Field("password") password: String): Call<Datalogin>

    @FormUrlEncoded
    @POST("resetpassword")
    fun loginResponsemodel(
        @Field("image") email: String, ): Call<forgetResponsemodel>

   /* @FormUrlEncoded
    @GET("products")
    fun productsdata(): Call<productsdata>*/

    @GET("products")
    fun productsdata() : Call<productListModel>

    @FormUrlEncoded
    @POST("productdetail")
    fun ProductDetailed(@Field("id") anyvalue: String,): Call<ProductDetailedModel1>

}