package com.example.patika.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.util.DigestUtils;

import javax.validation.constraints.NotNull;
import java.util.Objects;

@Getter
@Setter
@RequiredArgsConstructor
public class User {

    @NotNull
    private String name;

    @NotNull
    private String tc;

    @NotNull
    private String password;
    private Double balance;

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof User) {
            if (((User) obj).tc.equals(this.tc))
                return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.tc);
    }
}
