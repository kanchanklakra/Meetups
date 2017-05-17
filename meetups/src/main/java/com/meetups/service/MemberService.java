package com.meetups.service;

import java.util.List;

import com.meetups.model.Member;


public interface MemberService {
 
 public void addMember(Member member);

 public List<Member> listMembers();
 
 public Member getMember(String email);
 
 public void deleteMember(Member member);
 
}
