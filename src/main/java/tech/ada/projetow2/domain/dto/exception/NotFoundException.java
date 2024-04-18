package tech.ada.projetow2.domain.dto.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class NotFoundException extends Throwable {
    private final Class clazz;
    private final String id;
}
