package uz.nb.simple_trello.controller.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uz.nb.simple_trello.controller.base.AbstractController;
import uz.nb.simple_trello.criteria.GenericCriteria;
import uz.nb.simple_trello.dto.project.ProjectColumnCreateDto;
import uz.nb.simple_trello.dto.project.ProjectColumnUpdateDto;
import uz.nb.simple_trello.services.project.ProjectColumnService;

@RestController
@RequestMapping("/projectColumn/*")
public class ProjectColumnController extends AbstractController<ProjectColumnService> {

    @Autowired
    public ProjectColumnController(ProjectColumnService service) {
        super(service);
    }


    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String createPage() {
        return "project_column/create";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String create(@ModelAttribute ProjectColumnCreateDto dto) {
        service.create(dto);
        return "project_column/create";
    }

    @RequestMapping(value = "get/{id}", method = RequestMethod.GET)
    public String get(@PathVariable(name = "id") Long id, Model model) {
        model.addAttribute("project_column", service.get(id));
        return "project_column/create";
    }


    @RequestMapping(value = "get", method = RequestMethod.GET)
    public String getAll(Model model) {
        model.addAttribute("projects", service.getAll(new GenericCriteria()));
        return "project_column/create";
    }

    @RequestMapping(value = "update", method = RequestMethod.GET)
    public String updatePage() {
        return "project_column/create";
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String update(@ModelAttribute ProjectColumnUpdateDto dto) {
        service.update(dto);
        return "project_column/create";
    }


    @RequestMapping(value = "delete/{id}", method = RequestMethod.POST)
    public String update(@PathVariable Long id) {
        service.delete(id);
        return "project_column/create";
    }


    @RequestMapping(value = "list")
    public String homePage(Model model) {
        return "index/index";
    }

    @RequestMapping(value = "project", method = RequestMethod.GET)
    public String projectPage() {
        return "index/project_column";
    }

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String indexPage() {
        return "index/index";
    }


}
