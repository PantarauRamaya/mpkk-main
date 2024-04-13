package com.bhrsb.mpkk.adm_menuscode;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "ADM_MENUSCODE") // oracle

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class ADM_MENUSCODE {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "MEN_SEQUENCES")
    private Long MEN_SEQUENCES;

    @Column(name = "MEN_MENUSCODE")
    private String MEN_MENUSCODE;

    @Column(name = "MEN_MENUSNAME")
    private String MEN_MENUSNAME;

    @Column(name = "MEN_ENTRYOPER")
    private String MEN_ENTRYOPER;

    @Column(name = "MEN_ENTRYDATE")
    private LocalDateTime MEN_ENTRYDATE;

    @Column(name = "MEN_MODFYOPER")
    private String MEN_MODFYOPER;

    @Column(name = "MEN_MODFYDATE")
    private LocalDateTime MEN_MODFYDATE;

}
