package sg.edu.ntu.simplecrm;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InteractionServiceImpl implements InteractionService {

  private InteractionRepository interactionRepository;

  @Autowired
  public InteractionServiceImpl(InteractionRepository interactionRepository) {
    this.interactionRepository = interactionRepository;
  }

  @Override
  public Interaction saveInteraction(Interaction interaction) {
    return interactionRepository.save(interaction);
  }

  @Override
  public Interaction getInteraction(Long id) {
    return interactionRepository.findById(id).get();
  }

  @Override
  public ArrayList<Interaction> getAllInteractions() {
    return (ArrayList<Interaction>) interactionRepository.findAll();
  }

  @Override
  public Interaction updateInteraction(Long id, Interaction interaction) {
    // Load the interaction
    Interaction interactionToUpdate = interactionRepository.findById(id).get();
    interactionToUpdate.setRemarks(interaction.getRemarks());
    interactionToUpdate.setInteractionDate(interaction.getInteractionDate());
    return interactionRepository.save(interactionToUpdate);
  }

  @Override
  public void deleteInteraction(Long id) {
    interactionRepository.deleteById(id);
  }

}
