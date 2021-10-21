package com.mobilestore.service;

import com.mobilestore.db.MobileUserDB;
import com.mobilestore.model.MobileUser;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MobileService {
    MobileUserDB userDb;

    public MobileService() {
        userDb = new MobileUserDB();
    }

    public boolean isAuthorized(MobileUser signup) {
        boolean isValidUser = false;

        if (signup != null && signup.getEmail() != null && signup.getPassword() != null) {
            Set entrySet = userDb.userProfile.entrySet();
            Iterator it = entrySet.iterator();

            while (it.hasNext()) {
                Map.Entry u = (Map.Entry) it.next();
                //System.out.println(u.getKey()+"\t"+u.getValue());
                if (u.getKey().equals(signup.getEmail())) {
                    isValidUser = true;
                }
            }
        }

        return isValidUser;
    }

    public boolean updatePassword(MobileUser user) {
        boolean isUpdated = false;
        if (user != null && user.getEmail() != null) {

            for (Map.Entry<String, MobileUser> entry : userDb.userProfile.entrySet()) {
                if (entry.getKey().equals(user.getEmail())) {
                    user.setFirstName(entry.getValue().getFirstName());
                    user.setLastName(entry.getValue().getLastName());
                    user.setEmail(entry.getValue().getEmail());
                    user.setPassword(user.getPassword());
                    entry.setValue(user);
                    isUpdated = true;
                    //System.out.println(user);
                }
            }
        }
        return isUpdated;

    }

    public boolean doRegistration(MobileUser user) {
        boolean isCreated = false;
        if (user != null && user.getEmail() != null) {
            userDb.userProfile.put(user.getEmail(), user);
            isCreated = true;
            System.out.println("Number of records available: " + userDb.userProfile.size());
        }
        return isCreated;
    }
}