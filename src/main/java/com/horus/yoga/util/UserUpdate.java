package com.horus.yoga.util;

import com.horus.yoga.entity.User;


public class UserUpdate {

    public static User update (User user, User existingUser ){

        return existingUser.setFirstName(user.getFirstName() != null ? user.getFirstName() : existingUser.getFirstName())
                .setEmail(user.getEmail() != null ? user.getEmail() : existingUser.getEmail())
                .setNationality(user.getNationality() != null ? user.getNationality() : existingUser.getNationality())
                .setPhone(user.getPhone() != null ? user.getPhone() : existingUser.getPhone())
                .setLastName(user.getLastName() != null ? user.getLastName() : existingUser.getLastName())
                .setDateOfBirth(user.getDateOfBirth() != null ? user.getDateOfBirth() : existingUser.getDateOfBirth());
    }
}
