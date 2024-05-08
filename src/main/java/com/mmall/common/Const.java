package com.mmall.common;

import com.google.common.collect.Sets;

import java.util.Set;

/**
 * Created by kexi955 on 4/25/2024.
 */
public class Const {

    public static final String CURRENT_USER = "currentUser";

    public static final String EMAIL = "email";
    public static final String USERNAME = "username";


    public interface ProductListOrerBy{
        Set<String> PRICE_ASC_DESC = Sets.newHashSet("price_desc", "price_asc");
    }

    public interface Role{
        int ROLE_CUSTOMER = 0; // normal user
        int ROLE_ADMIN = 1; // admin user
    }

    public enum ProductStatusEnum{
        ON_SALE(1,"ONLINE");
        private String value;
        private int code;
        ProductStatusEnum(int code, String value){
            this.code = code;
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public int getCode() {
            return code;
        }
    }



}
