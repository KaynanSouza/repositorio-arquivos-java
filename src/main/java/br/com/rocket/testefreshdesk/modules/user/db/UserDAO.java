package br.com.rocket.testefreshdesk.modules.user.db;

import br.com.rocket.testefreshdesk.modules.user.UserEntity;
import org.springframework.stereotype.Repository;

@Repository
public abstract interface UserDAO  {

    public abstract void createUser(UserEntity user);

    public void updateUser(UserEntity user);

    public void deleteUser(Integer userId);

    public UserEntity getUserByEmail(String username);
}
