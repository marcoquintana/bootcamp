package com.nttdata.cardservice.model.document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "cards")
public class Card {

  @Id
  private String id;
  private String numTarjeta;
  private String fecVencimiento;
  private String cvv;
  private String pinBlock;
  private String titular;
}
