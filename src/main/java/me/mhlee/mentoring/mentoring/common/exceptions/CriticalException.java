package me.mhlee.mentoring.mentoring.common.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class CriticalException extends RuntimeException {
    private String message;
}
