package NicholasSacayanPersonal.SpringCRUD;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/api/adventurer")
public class AdventurerController {
    @Autowired
    private AdventurerRepository adventurerRepository;

    @PostMapping(path="/add") // Map ONLY POST Requests
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
    public String deleteCharacter (@RequestParam String name) {

        return "Deleted";
    }

    @PatchMapping
    public String patchCharacter (@RequestParam String name, @RequestParam String newName) {

        return "Patched";
    }

    @GetMapping(path="/all")
    public Iterable<Adventurer> getAllCharacters() {
        // This returns a JSON or XML with the users
        return adventurerRepository.findAll();
    }

}
