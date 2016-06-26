/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

import com.mycompany.model.Gender;
import com.mycompany.model.Student;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

/**
 *
 * @author Petra
 */
public class StudentServiceDaoImpl implements StudentServiceDao {

    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) throws DataAccessException {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public void addStudent(Student student) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        String sql = "INSERT INTO USERS(NAME, SURNAME, BIRTHDAY, GENDER) "
                + "VALUES ( :name, :surname, :birthday, :gender)";

        //namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(student), keyHolder);
        student.setId(keyHolder.getKey().intValue());
    }

    @Override
    public void deleteStudent(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateStudent(Student student) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Student findStudentById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Student> getAllStudents() {
        String sql = "SELECT * FROM users";
        List<Student> result = namedParameterJdbcTemplate.query(sql, new StudentMapper());

        return result;
    }

    private static final class StudentMapper implements RowMapper<Student> {

        SimpleDateFormat formatter = new SimpleDateFormat("dd.mm.yyyy");

        @Override
        public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
            Student student = new Student();
            student.setId(rs.getInt("id"));
            student.setName(rs.getString("name"));
            student.setSurname(rs.getString("surname"));
            try {
                student.setBirthday(formatter.parse(rs.getString("birthday")));
            } catch (ParseException ex) {
                Logger.getLogger(StudentServiceDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
            Gender gender = Gender.valueOf(rs.getString("gender"));
            student.setGender(gender);

            return student;
        }
    }

}
