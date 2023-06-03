package com.dcankayrak.OnlineClub.service;

import com.dcankayrak.OnlineClub.model.Member;
import com.dcankayrak.OnlineClub.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    private MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    public Member createMember(Member theMember) {
        return this.memberRepository.save(theMember);
    }

    public void deleteMember(Long id) {
        this.memberRepository.deleteById(id);
    }

    public Member updateMember(Long id, Member theMember) {
        Member member = this.memberRepository.findById(id).orElse(null);

        if(member != null){
            return this.memberRepository.save(Member
                    .builder()
                    .id(id)
                    .firstName(theMember.getFirstName())
                    .lastName(theMember.getLastName())
                    .email(theMember.getEmail())
                    .password(theMember.getPassword())
                    .build());
        }
        return null;
    }
}
