package com.mmittal.jwtSecurity;

import com.mmittal.jwtSecurity.dao.UserRepository;
import com.mmittal.jwtSecurity.entity.Role;
import com.mmittal.jwtSecurity.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
class JwtSecurityApplicationTests {

    @Autowired
    private UserRepository repo;

    @Test
    public void testCreateUser() {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = passwordEncoder.encode("nam2020");

        User newUser = new User("nam@codejava2.net", password);
        User savedUser = repo.save(newUser);

        assertThat(savedUser).isNotNull();
        assertThat(savedUser.getId()).isGreaterThan(0);
    }

    @Test
    public void testAssignRoleToUser() {
        Integer userId = 1;
        Integer roleId = 3;
        User user = repo.findById(userId).get();
        user.addRole(new Role(3));
//        user.addRole(new Role(2));

        User updatedUser = repo.save(user);
        assertThat(updatedUser.getRoles()).hasSize(1);

    }


}
