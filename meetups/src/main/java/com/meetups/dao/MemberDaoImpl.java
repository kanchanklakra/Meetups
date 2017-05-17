package com.meetups.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.meetups.model.Member;


@Repository("memberDao")
public class MemberDaoImpl implements MemberDao {

 @Autowired
 private SessionFactory sessionFactory;
 
 public void addMember(Member member) {
   sessionFactory.getCurrentSession().saveOrUpdate(member);
 }

 @SuppressWarnings("unchecked")
 public List<Member> listMembers() {
  return (List<Member>) sessionFactory.getCurrentSession().createCriteria(Member.class).list();
 }

 public Member getMember(String email) {
  return (Member) sessionFactory.getCurrentSession().get(Member.class, email);
 }

 public void deleteMember(Member member) {
  sessionFactory.getCurrentSession().createQuery("DELETE FROM Member WHERE empid = "+member.getEmail()).executeUpdate();
 }
}

