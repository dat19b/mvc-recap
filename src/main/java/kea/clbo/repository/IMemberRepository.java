package kea.clbo.repository;

import kea.clbo.model.Member;

import java.util.List;

public interface IMemberRepository {

    boolean create(Member m);
    Member read(String email);
    List<Member> readAll();
}
