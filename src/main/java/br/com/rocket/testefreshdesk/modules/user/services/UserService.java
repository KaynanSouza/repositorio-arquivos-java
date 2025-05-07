package br.com.rocket.testefreshdesk.modules.user.services;

import br.com.rocket.testefreshdesk.modules.user.UserEntity;
import br.com.rocket.testefreshdesk.modules.user.db.UserDAO;
import br.com.rocket.testefreshdesk.modules.user.db.UserDatabase;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class UserService implements UserDAO {
    private Connection connection;

    public UserService() {
        UserDatabase.conect();
        this.connection = UserDatabase.getConnection();
    }

    @Override
    public void createUser(UserEntity user) {

        // 1️⃣ Hash da senha — nunca grave texto puro
        String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());

        final String sql = """
        INSERT INTO public.users (nome, email, senha)
        VALUES (?, ?, ?)
        ON CONFLICT (email) DO NOTHING
        """;

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, hashed);

            int rows = ps.executeUpdate();   // 1 = inseriu, 0 = já existia
            if (rows == 0) {
                throw new EmailAlreadyExistsException(user.getEmail());
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar usuário", e);
        }
    }


    public class EmailAlreadyExistsException extends RuntimeException {
        public EmailAlreadyExistsException(String email) {
            super("E-mail já cadastrado: " + email);
        }
    }



    @Override
    public UserEntity getUserByEmail(String username) {
        return null;
    }

    public void updateUser(UserEntity user){}

    public void deleteUser(Integer userId){}
}
