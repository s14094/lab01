package pl.pawellakomiec.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.pawellakomiec.domain.Transmiter;
import pl.pawellakomiec.repository.TransmiterRepository;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * Simple web api demo -- try implementning post method
 *
 * Created by tp on 24.04.17.
 */
@RestController
public class TransmiterApi {

    @Autowired
    TransmiterRepository transmiterRepository;

    @RequestMapping("/")
    public String index() {
        return "This is non rest, just checking if everything works.";
    }

    @RequestMapping(value = "/transmiter/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Transmiter getTransmiter(@PathVariable("id") int id) throws SQLException {
        return transmiterRepository.getById(id);
    }

    @RequestMapping(value = "/transmiters", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Transmiter> getTransmiters(@RequestParam(value = "filter", required = false) String f) throws SQLException {
        List<Transmiter> transmiters = new LinkedList<Transmiter>();
        for (Transmiter p : transmiterRepository.getAll()) {
            if (f == null) {
                transmiters.add(p);
            } else if (p.getName().contains(f)) {
                transmiters.add(p);
            }
        }
        return transmiters;
    }

    @RequestMapping(value = "/transmiter",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Transmiter addTransmiter(@RequestBody Transmiter p) {
        if (transmiterRepository.addTransmiter(p) < 1) return null;
        return p;
    }

    @RequestMapping(value = "/transmiter/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public int deleteTransmiter(@PathVariable("id") int id) throws SQLException {
        return new Integer(transmiterRepository.deleteTransmiter(transmiterRepository.getById(id)));
    }

}