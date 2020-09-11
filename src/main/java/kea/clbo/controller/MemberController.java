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

import javax.servlet.http.HttpSession;

@Controller
public class MemberController {


    @Autowired
    IMemberRepository memberRepository;

    /*public MemberController(IMemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }*/

    @GetMapping("/")
    public String index(HttpSession session){

        if(session.getAttribute("isLogIn") != null){
            return "secret";
        }
        return "index";
    }

    @PostMapping("/")
    public String login(@ModelAttribute Member member, Model model, HttpSession session){
        // check if crediatials is in the arraylist
        Member m = memberRepository.read(member.getEmail());
        if (m != null){
            session.setAttribute("isLogIn", "yes");

            model.addAttribute("members", memberRepository.readAll());
            return "secret";
        }

        return "index";

    }

    @GetMapping("/logud")
    public String logout(HttpSession session){
        session.removeAttribute("isLogIn");
        if(session.getAttribute("isLogIn") != null){
            return "secret";
        }
        return "index";
    }
}
