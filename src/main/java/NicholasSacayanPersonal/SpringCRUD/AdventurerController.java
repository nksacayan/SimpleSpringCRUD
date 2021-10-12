package NicholasSacayanPersonal.SpringCRUD;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path="/api/adventurer")
public class AdventurerController {
    @Autowired
    private AdventurerRepository adventurerRepository;

    @PostMapping // Map ONLY POST Requests
    public String addNewCharacter (@RequestParam String name
            , @RequestParam String job) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        Adventurer c = new Adventurer();
        c.setName(name);
        c.setJob(job);
        adventurerRepository.save(c);
        return "Saved";
    }

    @DeleteMapping
    public String deleteAdventurer(@RequestParam Integer id) {
        adventurerRepository.deleteById(id);
        return "Deleted";
    }

    @PatchMapping
    public String patchAdventurer(@RequestParam Integer id, @RequestParam String newName) {
        Optional<Adventurer> adventurer = adventurerRepository.findById(id);
        adventurer.get().setName(newName);
        adventurerRepository.save(adventurer.get());
        return "Patched";
    }

    @GetMapping("/all")
    public Iterable<Adventurer> getAllAdventurers() {
        // This returns a JSON or XML with the users
        return adventurerRepository.findAll();
    }

}
