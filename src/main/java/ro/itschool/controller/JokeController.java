package ro.itschool.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ro.itschool.controller.model.AuthorDTO;
import ro.itschool.controller.model.JokeDTO;
import ro.itschool.entity.Joke;
import ro.itschool.service.AuthorService;
import ro.itschool.service.JokeService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller
@RequiredArgsConstructor
@RequestMapping("/joke")
public class JokeController {

  private final JokeService jokeService;
  private final AuthorService authorService;

  //------------Add new joke to database--------------------------------
  @GetMapping(value = "/add")
  public String addJoke(Model model) {
    Joke joke = new Joke();
    model.addAttribute("joke", joke);
    return "add-joke.html";
  }

  @PostMapping(value = "/add")
  public String processForm(@ModelAttribute(value = "joke") JokeDTO joke) {
    jokeService.save(joke);
    return "redirect:/joke/all";
  }
  //----------------------------------------------------------------

  //--------------------Edit joke by id----------------------------
  @RequestMapping(value = "/edit/{id}")
  public String editJoke(@PathVariable Integer id, Model model) {
    model.addAttribute("jokeToBeEdited", jokeService.findById(id));
    return "edit-joke";
  }

  @RequestMapping(value = "/edit")
  public String editAndSaveEditedJoke(@ModelAttribute(value = "joke") JokeDTO jokeDTO, AuthorDTO authorDTO) {
    jokeService.save(jokeDTO);
    authorService.save(authorDTO);
    return "redirect:/joke/all";
  }
  //----------------------------------------------------------------

  @GetMapping("/all")
  public String getJokes(Model model) {
    List<JokeDTO> jokes = jokeService.getJokes();
    model.addAttribute("jokesThymeleaf", Objects.requireNonNullElseGet(jokes, ArrayList::new));
    return "index";
  }

  @RequestMapping("/delete/{id}")
  public String deleteJoke(@PathVariable Integer id) {
    jokeService.deleteJoke(id);
    return "redirect:/joke/all";
  }

  @GetMapping("/populate-db")
  public String populateDB() {
    jokeService.getJokes(55);
    return "redirect:/joke/all";
  }

}
