package by.nesterenok.testyourself.domain;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@javax.persistence.Entity
@Table(name = "group_task")
public class Task extends Entity {

    private static final long serialVersionUID = -2173586575475381715L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = Group.class)
    @JoinColumn(name = "party")
    private Group group;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = Test.class)
    @JoinColumn(name = "test")
    private Test test;

    @Column(name = "finish_to")
    private Date finishTo;

    public Task(int id) {
        super(id);
    }
}
