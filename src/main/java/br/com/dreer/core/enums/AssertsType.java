package br.com.dreer.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum AssertsType {
    NOT_NULL("%s doesn't match"),
    DOESNT_MATCH("%s doesn't match"),
    NOT_EMPTY("%s doesn't be null"),
    ISNT_INSTANCE("%s is not an instance of %s");
    private String message;
}
