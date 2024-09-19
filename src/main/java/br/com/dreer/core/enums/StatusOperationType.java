package br.com.dreer.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum StatusOperationType {
    OK("SUCCESS", "Operation executed successfully"),
    ERROR("ERROR", "The operation could not be performed."),
    NOT_FOUND("NOT_FOUND", "The operation could found results."),
    INFO("INFORMATION", ""),
    WARNING("WARNING", "");

    private String code;
    private String text;
}
