package com.nttdata.cardservice.api;

import com.nttdata.cardservice.model.document.Card;
import com.nttdata.cardservice.model.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Clase controller.
 */
@RestController
@RequestMapping("/cards")
public class CardController {

  @Autowired
  private CardService cardService;

  @GetMapping
  public Flux<Card> getAll() {
    return cardService.getAll();
  }

  /**
   * Card Find by Id.
   *
   * @param id String.
   * @returns Mono Card
   */
  @GetMapping("/{id}")
  public Mono<ResponseEntity<Card>> findById(@PathVariable String id) {
    return cardService.findById(id).map(c -> ResponseEntity.ok()
            .contentType(MediaType.APPLICATION_JSON)
            .body(c))
        .defaultIfEmpty(ResponseEntity.notFound().build());
  }

  @PostMapping
  public Mono<Card> register(@RequestBody Card card) {
    return cardService.save(card);
  }
}
