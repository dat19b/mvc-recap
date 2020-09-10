package kea.clbo.controller;

import kea.clbo.model.Member;
import kea.clbo.repository.IMemberRepository;
import kea.clbo.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {

    @Autowired
    IMemberRepository memberRepository;


    @GetMapping("/")
    public String index(){
        return "index";
    }

    @PostMapping("/")
    public String login(@ModelAttribute Member member, Model model){

        model.addAttribute("members", memberRepository.readAll());
        //System.out.println(member.getEmail());
        //System.out.println(member.getPassword());
        return "secret";
    }
}
