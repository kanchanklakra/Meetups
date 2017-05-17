package com.meetups.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.meetups.bean.MemberBean;
import com.meetups.model.Member;
import com.meetups.service.MemberService;


@RestController
public class MemberController {
 
 @Autowired
 private MemberService memberService;
 
@RequestMapping(value = "/save", method = RequestMethod.POST)
public ModelAndView saveMember(@ModelAttribute("command")MemberBean memberBean, 
   BindingResult result) {
  Member member = prepareModel(memberBean);
  memberService.addMember(member);
  return new ModelAndView("redirect:/add.html");
 }

 @RequestMapping(value="/members", method = RequestMethod.GET)
 public ModelAndView listMembers() {
  Map<String, Object> model = new HashMap<String, Object>();
  model.put("members",  prepareListofBean(memberService.listMembers()));
  return new ModelAndView("membersList", model);
 }

 @RequestMapping(value = "/add", method = RequestMethod.GET)
 public ModelAndView addMember(@ModelAttribute("command")MemberBean memberBean,
   BindingResult result) {
  Map<String, Object> model = new HashMap<String, Object>();
  model.put("members",  prepareListofBean(memberService.listMembers()));
  return new ModelAndView("addMember", model);
 }
 
@RequestMapping(value = "/index", method = RequestMethod.GET)
public ModelAndView welcome() {
  return new ModelAndView("index");
 }

@RequestMapping(value = "/delete", method = RequestMethod.GET)
public ModelAndView deleteMember(@ModelAttribute("command")MemberBean memberBean,
   BindingResult result) {
  memberService.deleteMember(prepareModel(memberBean));
  Map<String, Object> model = new HashMap<String, Object>();
  model.put("member", null);
  model.put("members",  prepareListofBean(memberService.listMembers()));
  return new ModelAndView("addMember", model);
 }
 
@RequestMapping(value = "/edit", method = RequestMethod.GET)
public ModelAndView editMember(@ModelAttribute("command")MemberBean memberBean,
   BindingResult result) {
  Map<String, Object> model = new HashMap<String, Object>();
  model.put("member", prepareMemberBean(memberService.getMember(memberBean.getEmail())));
  model.put("members",  prepareListofBean(memberService.listMembers()));
  return new ModelAndView("addMember", model);
 }
 
 private Member prepareModel(MemberBean memberBean){
  Member member = new Member();
  member.setEmail(memberBean.getEmail());
  member.setPassword(memberBean.getPassword());
  member.setCompany(memberBean.getCompany());
  member.setCompanyAddress(memberBean.getCompanyAddress());
  member.setMobile(memberBean.getMobile());
  member.setCapabilities(memberBean.getCapabilities());
  member.setExperience(memberBean.getExperience());
  
  return member;
 }
 
 private List<MemberBean> prepareListofBean(List<Member> members){
  List<MemberBean> beans = null;
  if(members != null && !members.isEmpty()){
   beans = new ArrayList<MemberBean>();
   MemberBean bean = null;
   for(Member member : members){
    bean = new MemberBean();
    bean.setEmail(member.getEmail());
    bean.setPassword(member.getPassword());
    bean.setCompany(member.getCompany());
    bean.setCompanyAddress(member.getCompanyAddress());
    bean.setMobile(member.getMobile());
    bean.setCapabilities(member.getCapabilities());
    bean.setExperience(member.getExperience());
    beans.add(bean);
   }
  }
  return beans;
 }
 
 private MemberBean prepareMemberBean(Member member){
  MemberBean bean = new MemberBean();
  bean.setEmail(member.getEmail());
  bean.setPassword(member.getPassword());
  bean.setCompany(member.getCompany());
  bean.setCompanyAddress(member.getCompanyAddress());
  bean.setMobile(member.getMobile());
  bean.setCapabilities(member.getCapabilities());
  bean.setExperience(member.getExperience());
  return bean;
 }
}
