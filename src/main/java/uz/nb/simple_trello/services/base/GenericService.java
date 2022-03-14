package uz.nb.simple_trello.services.base;

import uz.nb.simple_trello.criteria.GenericCriteria;
import uz.nb.simple_trello.dto.base.GenericDto;

import java.io.Serializable;
import java.util.List;


/**
 * @param <D> -> Dto
 * @param <K> -> class that defines the primary key for your pojo class
 * @param <C> -> Criteria (For Filtering Request)
 */
public interface GenericService<
        D extends GenericDto,
        C extends GenericCriteria,
        K extends Serializable> extends BaseService {

    List<D> getAll(C criteria);

    D get(K id);

    Long totalCount(C criteria);
}
