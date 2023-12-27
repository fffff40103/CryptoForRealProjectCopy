package spring.mvc.crypto.model.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import spring.mvc.crypto.model.entity.User;

@Repository
public class CryptoDaoMySQL implements CryptoDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	// 使用者-User:

	// 1. 查詢所有使用者(多筆)
	@Override
	public List<User> findAllUsers() {
		String sql = "select userId,username,password from user";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));

	}

	// 2. 新增使用者
	@Override
	public void addUser(User user) {
		String sql = "insert into user(username, password) values(?, ?)";
		jdbcTemplate.update(sql, user.getUsername(), user.getPassword());

	}

	// 3. 修改密碼
	@Override
	public Boolean updateUserPassword(Integer userId, String newPassword) {
		// TODO Auto-generated method stub
		return null;
	}

	// 4. 根據使用者名稱查找使用者(登入用-單筆)
	@Override
	public Optional<User> findUserByUsername(String username) {
		String sql = "select userId,username,password from user where username=?";
		try {
			User user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), username);
			return Optional.ofNullable(user);
		} catch (EmptyResultDataAccessException e) {
			return Optional.empty();
		}
	}

	// 5. 根據使用者ID查找使用者(單筆)
	@Override
	public Optional<User> findUserById(Integer userId) {
		String sql = "select userId,username,password from user where userId=?";
		try {
			User user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), userId);
			return Optional.ofNullable(user);
		} catch (EmptyResultDataAccessException e) {
			return Optional.empty();
		}
	}

}
