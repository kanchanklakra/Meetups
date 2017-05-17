package com.meetups.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.meetups.dao.MemberDao;
import com.meetups.model.Member;


@Service("memberService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class MemberServiceImpl implements MemberService {

 @Autowired
 private MemberDao memberDao;
 
 @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
 public void addMember(Member member) {
  memberDao.addMember(member);
 }
 
 public List<Member> listMembers() {
  return memberDao.listMembers();
 }

 public Member getMember(String email) {
  return memberDao.getMember(email);
 }
 
 public void deleteMember(Member member) {
  memberDao.deleteMember(member);
 }

}
