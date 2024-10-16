 package com.example.demo.DTO;

 public class AuthResponseDTO {
     private String token;

     public AuthResponseDTO(String token) {
         this.token = token;
     }

     public String getToken() {
         return token;
     }

     public void setToken(String token) {
         this.token = token;
     }
 }


