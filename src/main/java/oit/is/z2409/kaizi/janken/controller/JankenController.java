package oit.is.z2409.kaizi.janken.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import oit.is.z2409.kaizi.janken.model.Janken;

@Controller
public class JankenController {

  private String username;

  @PostMapping("/janken")
  public String enterRoom(@RequestParam String username, Model model) {
    this.username = username;
    model.addAttribute("username", username);
    return "janken";
  }

  @GetMapping("/jankengame")
  public String playGame(@RequestParam String hand, Model model) {
    model.addAttribute("username", this.username);

    Janken janken = new Janken();
    String result = janken.play(hand);
    model.addAttribute("userHand", hand);
    model.addAttribute("cpuHand", janken.getCpuHand());
    model.addAttribute("result", result);

    return "janken";
  }
}
