package NicholasSacayanPersonal.SpringCRUD;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/adventurer")
public class AdventurerController {
    @Autowired
    private AdventurerRepository adventurerRepository;

    @PostMapping(path="/add") // Map ONLY POST Requests
    public @ResponseBody String addNewCharacter (@RequestParam String name
            , @RequestParam String job) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        Adventurer c = new Adventurer();
        c.setName(name);
        c.setJob(job);
        adventurerRepository.save(c);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Adventurer> getAllCharacters() {
        // This returns a JSON or XML with the users
        return adventurerRepository.findAll();
    }

}
