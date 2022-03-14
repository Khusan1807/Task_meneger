package uz.nb.simple_trello.config.annotations;

import org.springframework.security.access.prepost.PreAuthorize;

@PreAuthorize("hasRole('ADMIN')")
public @interface HasAdminRole {
}
