package com.example.common;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class IdResponse<T> {

    private T id;

    private IdResponse(T id) {
        this.id = id;
    }

    public static <T> IdResponse<T> of(T id) {
        return new IdResponse<>(id);
    }
}
