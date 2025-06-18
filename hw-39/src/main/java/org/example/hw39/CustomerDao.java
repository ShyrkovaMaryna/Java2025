package org.example.hw39;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
@AllArgsConstructor
public class CustomerDao {

    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public void add(Customer customer) {
        jdbcTemplate.update("INSERT INTO customer (full_name, email, social_security_number) VALUES (?, ?, ?)",
                customer.getFullName(), customer.getEmail(), customer.getSocialSecurityNumber());
    }
    public void update(Customer customer) {
        jdbcTemplate.update("UPDATE customer SET full_name = ?, email = ?, social_security_number = ? WHERE id = ?",
                customer.getFullName(), customer.getEmail(), customer.getSocialSecurityNumber(), customer.getId());
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM customer WHERE id = ?", id);
    }

    public Customer getById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM customer WHERE id = ?",
                new CustomerMapper(), id);
    }

    public List<Customer> getAll() {
        return jdbcTemplate.query("SELECT * FROM customer",
                new BeanPropertyRowMapper<>(Customer.class));
    }

    public Customer getByIdAndName(int id, String fullName) {
        SqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("id", id)
                .addValue("fullName", fullName);

        return namedParameterJdbcTemplate.queryForObject("SELECT * FROM customer WHERE id = :id AND full_name = :fullName", parameters,
                new CustomerMapper());
    }
}