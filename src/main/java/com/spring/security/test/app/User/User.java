package com.spring.security.test.app.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Collection;

@Entity
@Table(name = "t_user")
@NoArgsConstructor
@Getter
@Setter
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min=5, message = "Логин должен содержат больше 5 символов")
    private String username;
    @Size(min=8, message = "Пароль должен содержат больше 8 символов")
    private String password;
    @Pattern(regexp = "\\+\\d{1}\\d{3}-\\d{3}-\\d{2}-\\d{2}", message = "Неверный формат телефона")
    private String phoneNumber;
    @Pattern(regexp = "[\\w.]+@[\\w\\.]+.(com|ru)", message = "Неверный формат email")
    private String email;
    @Transient
    private String passwordConfirm;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
