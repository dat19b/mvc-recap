package kea.clbo.repository;

import kea.clbo.model.Member;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MemberRepository implements IMemberRepository {

    List<Member> members;

    public MemberRepository(){
        this.members = new ArrayList<>();
        this.members.add(new Member("Clao@kea.dk", "1234"));
        this.members.add(new Member("ib@kea.dk", "1234705987056"));
        this.members.add(new Member("kl@kea.dk", "1234fshsdkjf"));


    }

    @Override
    public boolean create(Member m) {
        return this.members.add(m);
    }

    @Override
    public Member read(String email) {
        for (Member m : members ) {
            if (m.getEmail().equals(email)){
                return m;
            }
        }
        return null;
    }

    @Override
    public List<Member> readAll() {
        return this.members;
    }
}
