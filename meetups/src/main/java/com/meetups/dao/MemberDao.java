package com.meetups.dao;

import java.util.List;

import com.meetups.model.Member;


public interface MemberDao {
 
 public void addMember(Member member);

 public List<Member> listMembers();
 
 public Member getMember(String email);
 
 public void deleteMember(Member member);
}


