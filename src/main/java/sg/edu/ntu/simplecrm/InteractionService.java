package sg.edu.ntu.simplecrm;

import java.util.ArrayList;

public interface InteractionService {
  // CREATE
  Interaction saveInteraction(Interaction interaction);

  // READ
  Interaction getInteraction(Long id);

  ArrayList<Interaction> getAllInteractions();

  // UPDATE
  Interaction updateInteraction(Long id, Interaction interaction);

  // DELETE
  void deleteInteraction(Long id);

}
