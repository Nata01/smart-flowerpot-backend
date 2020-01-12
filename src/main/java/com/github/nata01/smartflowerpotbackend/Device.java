package com.github.nata01.smartflowerpotbackend;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String mac;

    @OneToMany(mappedBy = "device", cascade = CascadeType.ALL)
    private List<Action> actions = new ArrayList<>();
}
