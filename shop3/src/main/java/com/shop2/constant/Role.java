package com.shop2.constant;

public enum Role {
 ADMIN("ROLE_ADMIN"),
 USER("ROLE_USER");

 Role(String value){
  this.value = value;
 }

 private String value;
}
