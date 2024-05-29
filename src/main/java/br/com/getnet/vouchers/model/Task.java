package br.com.getnet.vouchers.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@ToString
@Entity
public class Task {

    @Id
    public String id;

    public String description;

}
