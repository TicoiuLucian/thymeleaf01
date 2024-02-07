package ro.itschool.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ro.itschool.controller.model.AuthorDTO;
import ro.itschool.controller.model.JokeDTO;
import ro.itschool.service.AuthorService;
import ro.itschool.service.JokeService;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller
@RequiredArgsConstructor
@RequestMapping("/jokes")
public class JokeController {

  private final JokeService jokeService;
  private final AuthorService authorService;

  // Redirecting automatically to /all
  @GetMapping
  public String redirectToAllJokes() {
    return "redirect:/jokes/all";
  }

  // List all jokes
  @GetMapping("/all")
  public String listJokes(Model model) {
    List<JokeDTO> jokes = jokeService.getJokes();
    model.addAttribute("jokesTotalList", Objects.requireNonNullElseGet(jokes, ArrayList::new));
    return "jokes"; // maps to jokes.html
  }

  // Show form to add a new joke
  @GetMapping(value = "/add")
  public String showAddJokeForm(Model model) {
    model.addAttribute("joke", new JokeDTO());
    model.addAttribute("authors", authorService.getAllAuthors());
    return "jokes-add"; // maps to jokes-add.html
  }

  @GetMapping(value = "/search")
  public String searchJokes(Model model, @RequestParam(required = false) String searchQuery) {
    if (searchQuery != null) {
      List<JokeDTO> searchResults = jokeService.findByKeyword(searchQuery.trim());
      model.addAttribute("jokeSearchResults", searchResults);
      model.addAttribute("searchPerformed", true);
    } else {
       return "redirect:/jokes/all";
    }
    model.addAttribute("searchQuery", searchQuery);
    return "jokes";
  }


  // Process the form for adding a new joke
  @PostMapping("/add")
  public String processAddJokeForm(
          @ModelAttribute("joke") JokeDTO jokeDTO,
          @RequestParam("authorId") Integer authorId
  ) {
    AuthorDTO authorDTO = authorService.findById(authorId)
            .orElseThrow(() -> new IllegalArgumentException("Invalid Author ID: " + authorId));
    jokeDTO.setAuthor(authorDTO);
    jokeService.save(jokeDTO);
    return "redirect:/jokes/all";
  }


  // Show form to edit an existing joke
  @GetMapping(value = "/edit/{id}")
  public String showEditJokeForm(@PathVariable Integer id, Model model) {
    model.addAttribute("jokeToBeEdited", jokeService.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Invalid joke Id:" + id)));
    model.addAttribute("authors", authorService.getAllAuthors());
    return "jokes-edit";
  }

  // Process the form for editing an existing joke
  @PostMapping("/edit/{id}")
  public String processEditJokeForm(
          @PathVariable Integer id,
          @ModelAttribute("joke") JokeDTO jokeDTO,
          @RequestParam("authorId") Integer authorId
  ) {
    AuthorDTO authorDTO = authorService.findById(authorId)
            .orElseThrow(() -> new IllegalArgumentException("Invalid Author ID"));
    jokeDTO.setAuthor(authorDTO);
    jokeDTO.setId(id);
    jokeService.save(jokeDTO);
    return "redirect:/jokes/all";
  }

  // Delete a joke
  @GetMapping("/delete/{id}")
  public String deleteJoke(@PathVariable Integer id) {
    jokeService.deleteJoke(id);
    return "redirect:/jokes/all";
  }

  @GetMapping("/populate-db")
  public String populateDB() {
    jokeService.getJokes(55);
    return "redirect:/jokes/all";
  }
}