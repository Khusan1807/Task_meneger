package uz.nb.simple_trello.controller.project;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uz.nb.simple_trello.controller.base.AbstractController;
import uz.nb.simple_trello.criteria.GenericCriteria;
import uz.nb.simple_trello.dto.project.ProjectMemberCreateDto;
import uz.nb.simple_trello.services.project.ProjectMemberService;

@Controller
@RequestMapping("/project_member/*")
public class ProjectMemberController extends AbstractController<ProjectMemberService> {


    public ProjectMemberController(ProjectMemberService service) {
        super(service);
    }

    @PreAuthorize("hasAnyRole('SUPER_USER', 'ADMIN')")
    @RequestMapping(value = "create_member/{id}", method = RequestMethod.GET)
    public String createPage() {
        return "project_member/create_member";
    }

    @RequestMapping(value = "create_member/{id}", method = RequestMethod.POST)
    public String create(@ModelAttribute ProjectMemberCreateDto dto) {
        service.create(dto);
        return "redirect:/index/index";
    }

    @RequestMapping(value = "get/{id}", method = RequestMethod.GET)
    public String get(@PathVariable Long id, Model model) {
        model.addAttribute("projectMember", service.get(id));
        return "redirect:/index/index";
    }


    @RequestMapping(value = "getAll", method = RequestMethod.GET)
    public String getAll(Model model) {
        model.addAttribute("tasks", service.getAll(new GenericCriteria()));
        return "redirect:/index/index";
    }
}
