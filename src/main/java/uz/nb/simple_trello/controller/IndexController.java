package uz.nb.simple_trello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uz.nb.simple_trello.controller.base.AbstractController;
import uz.nb.simple_trello.criteria.GenericCriteria;
import uz.nb.simple_trello.entity.base.AuditAwareImpl;
import uz.nb.simple_trello.services.auth.AuthUserService;
import uz.nb.simple_trello.services.organization.OrganizationService;
import uz.nb.simple_trello.services.project.ProjectService;
import uz.nb.simple_trello.services.task.TaskService;


@Controller
@RequestMapping("/index/*")
public class IndexController extends AbstractController<TaskService> {

    private final AuditAwareImpl auditAware;
    private final OrganizationService organizationService;
    private final ProjectService projectService;
    private final AuthUserService userService;

    public IndexController(TaskService service, AuditAwareImpl auditAware, OrganizationService organizationService, ProjectService projectService, AuthUserService userService) {
        super(service);
        this.auditAware = auditAware;
        this.organizationService = organizationService;
        this.projectService = projectService;
        this.userService = userService;
    }

    @RequestMapping(value = {"/index"}, method = RequestMethod.GET)
    public String homePage(Model model) {
        Long id = auditAware.getCredentials().getId();
        model.addAttribute("organizations", organizationService.getAll(new GenericCriteria()));
        Long orgId=auditAware.getCredentials().getOrganizationId();
        model.addAttribute("projects", projectService.getAllProjects(orgId));
        model.addAttribute("orgId", orgId);
        model.addAttribute("tasks", service.getAllTasksUserId(id));
        model.addAttribute("userId", id);
        model.addAttribute("AuthUser", userService.get(id));
        return "index/index";
    }


}
