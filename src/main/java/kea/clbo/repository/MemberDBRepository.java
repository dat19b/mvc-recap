package kea.clbo.repository;

import kea.clbo.controller.MemberController;
import kea.clbo.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MemberDBRepository implements IMemberRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;
    SqlRowSet sqlRowSet;

    /*public MemberDBRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }*/

    @Override
    public boolean create(Member m) {
        return false;
    }

    @Override
    public Member read(String email) {

        String sql = "SELECT * FROM member WHERE email ='" + email + "'";
        sqlRowSet = jdbcTemplate.queryForRowSet(sql);

        while(sqlRowSet.next()){
            return new Member(sqlRowSet.getString("email"), sqlRowSet.getString("password"));
        }
        return null;
    }

    @Override
    public List<Member> readAll() {
        List<Member> members = new ArrayList<>();

        String sql = "SELECT * FROM member";
        sqlRowSet = jdbcTemplate.queryForRowSet(sql);

        while(sqlRowSet.next()){
            members.add(new Member(sqlRowSet.getString("email"), sqlRowSet.getString("password")));
        }
        return members;
    }
}
