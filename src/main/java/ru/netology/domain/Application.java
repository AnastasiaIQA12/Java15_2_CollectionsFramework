package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Application implements Comparable<Application> {
    private String title;

    @Override
    public int compareTo(Application o) {
        return title.compareTo(o.title);
    }
}
