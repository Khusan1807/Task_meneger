package uz.nb.simple_trello.controller.base;
import uz.nb.simple_trello.services.base.BaseService;


public abstract class AbstractController<S extends BaseService> {
    protected final S service;

    public AbstractController(S service) {
        this.service = service;
    }
}
