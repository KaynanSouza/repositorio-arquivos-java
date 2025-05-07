package br.com.rocket.testefreshdesk.modules.user;

import jdk.jfr.Name;
import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.UUID;

@Data
@EntityScan
public class UserEntity {

    private UUID id;
    private String name;
    private String email;
    private String password;
}
