package com.mobilestore.db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mobilestore.model.MobileUser;

public class MobileUserDB {

    public static String[][] users;
    public static List<MobileUser> usersData;

    public static Map<String, MobileUser> userProfile = new HashMap<String, MobileUser>();

    public MobileUserDB() {

        MobileUser u1 = new MobileUser("Shanawaz", "Syed", "12345", "syed@gmail");
        MobileUser u2 = new MobileUser("P", "R", "abcd", "p.r@devops.com");
        MobileUser u3 = new MobileUser("R", "S", "pqrs", "r.s@devops.com");

        userProfile.put(u1.getEmail(), u1);
        userProfile.put(u2.getEmail(), u2);
        userProfile.put(u3.getEmail(), u3);
    }
}
