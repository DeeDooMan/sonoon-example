package de.logicline.swapp.controller;

import de.logicline.swapp.model.Person;
import de.logicline.swapp.service.ArticleService;
import de.logicline.swapp.service.CategoryService;
import de.logicline.swapp.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.Map;

/**
 * The http controller handles http client interaction
 * <ul>
 *    <li>delegates to the proper service (business logic)</li>
 *    <li>delegates to the proper directs to the correct response page</li>
 * </ul>
 *  
 *  (The C in MVC)
 *  
 * @author logicline
 *
 */
@Controller
@RequestMapping("/people")
public class PersonController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private CategoryService categoryService;

   @Autowired
    private PersonService personService;

    @RequestMapping("/")
    public String listPeople(Map<String, Object> map) {

        map.put("person", new Person());
        map.put("peopleList", personService.listPeople());

        return "people";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addPerson(@ModelAttribute("person") Person person, BindingResult result) {

        personService.addPerson(person);

        return "redirect:/people/";
    }

    @RequestMapping("/delete/{personId}")
    public String deletePerson(@PathVariable("personId") Integer personId) {

        personService.removePerson(personId);

        return "redirect:/people/";
    }

    //Frontpage, shows latest 5 news
    @GetMapping("/news")
    public String getLatestNews(Model model) {
        return "news";
    }

    //Creates a new news article
    @Transactional
    @PostMapping("/news")
    public String create(@RequestParam String heading, @RequestParam String lead, @RequestParam String article,
                         @RequestParam("file") MultipartFile file, @RequestParam String authors,
                         @RequestParam String categories, Model model) throws IOException {

        return "redirect:/news";
    }

    //Returns a specific news article
    @GetMapping("/news/{id}")
    public String getArticle(Model model, @PathVariable Long id) {

        return "article";
    }

    //Returns a page where you can edit chosen news article
    @GetMapping("/news/{id}/edit")
    public String editArticle(Model model, @PathVariable Long id) {

        return "edit";
    }

    //Edits a single piece of news, only params that that are not null are edited
    @Transactional
    @PostMapping("/news/{id}/edit")
    public String editNewsArticle(@PathVariable Long id, @RequestParam String heading,
                                  @RequestParam String lead, @RequestParam String article,
                                  @RequestParam("file") MultipartFile file, @RequestParam String authors,
                                  @RequestParam String categories, Model model) throws IOException {

        return "redirect:/news";
    }


    //Returns all news sorted by release date
    @GetMapping("/news/all")
    public String getAllNews(Model model) {
        return "allNews";
    }

    //Returns top five news sorted by amount of views
    @GetMapping("/news/trending")
    public String getTrending(Model model) {
        return "trending";
    }

    //Returns a page with a list of all categories
    @GetMapping("/news/categories")
    public String getCategories(Model model) {
        return "categories";
    }

    //Returns a single category
    @GetMapping("/news/categories/{id}")
    public String getCategory(Model model, @PathVariable Long id) {
        return "category";
    }
}
