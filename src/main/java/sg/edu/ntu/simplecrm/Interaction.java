package sg.edu.ntu.simplecrm;

import java.time.LocalDate;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "interaction")
public class Interaction {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;
  @Column(name = "remarks")
  private String remarks;
  @Column(name = "interaction_date")
  private LocalDate interactionDate;

  @ManyToOne(optional = false)
  @JoinColumn(name = "customer_id", referencedColumnName = "id")
  private Customer customer;

}
