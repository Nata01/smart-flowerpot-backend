package com.github.nata01.smartflowerpotbackend;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
@NoArgsConstructor
@ToString(exclude = "device")
public class Action {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private ActionType type;

    private String payload;

    @ManyToOne(optional = false)
    private Device device;

    @Column(nullable = false)
    private Timestamp sentAt;
}
