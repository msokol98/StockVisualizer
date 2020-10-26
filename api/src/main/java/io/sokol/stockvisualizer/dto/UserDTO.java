package io.sokol.stockvisualizer.dto;

import io.sokol.stockvisualizer.entity.User;

public class UserDTO {

    private User user;

    public UserDTO(User user) {
        this.user = user;
    }

    public String getName() {
        return user.getFirstName() + "" + user.getLastName();
    }

    public String getEmail() {
        return user.getEmail();
    }

}
