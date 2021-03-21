package com.rafarodrigues.hroauth.entities;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Role implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    @EqualsAndHashCode.Include
    private String roleName;
}
