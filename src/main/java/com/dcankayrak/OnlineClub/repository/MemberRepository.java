package com.dcankayrak.OnlineClub.repository;

import com.dcankayrak.OnlineClub.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,Long> {

}
