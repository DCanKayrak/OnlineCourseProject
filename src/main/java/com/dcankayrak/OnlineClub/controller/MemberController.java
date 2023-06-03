package com.dcankayrak.OnlineClub.controller;

import com.dcankayrak.OnlineClub.model.Member;
import com.dcankayrak.OnlineClub.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/members")
public class MemberController {

    private MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping
    public ResponseEntity<List<Member>> getAllMembers(){
        return ResponseEntity.ok(this.memberService.getAllMembers());
    }

    @PostMapping
    public ResponseEntity<Member> createMember(@RequestBody Member theMember){
        return ResponseEntity.ok(this.memberService.createMember(theMember));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Member> updateMember(@PathVariable Long id,@RequestBody Member theMember){
        return ResponseEntity.ok(this.memberService.updateMember(id,theMember));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMember(@PathVariable Long id){
        this.memberService.deleteMember(id);
        return ResponseEntity.ok("Silindi!");
    }


}
