package pl.pawellakomiec.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.pawellakomiec.domain.Transmiter;
import pl.pawellakomiec.repository.TransmiterRepository;

import java.sql.SQLException;
import java.util.List;

@RestController
public class TransmiterApi {

    @Autowired
    TransmiterRepository transmiterRepository;

    @RequestMapping("/")
    public String index() {
        return "Everything works. ;)";
    }


    @RequestMapping(value = "/transmiter/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Transmiter getTransmiter(@PathVariable("id") int id) throws SQLException {
        return transmiterRepository.getById(id);
    }

    @RequestMapping(value ="/transmiters", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Transmiter> getTransmiters() throws SQLException {
        return transmiterRepository.getAll();
    }

    @RequestMapping(value = "/transmiter",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Transmiter addTransmiter(@RequestBody Transmiter p) {
        if (transmiterRepository.addTransmiter(p) < 1) return null;
        return p;
    }

    @RequestMapping(value = "/transmiterDelete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public int deleteTransmiter(@PathVariable("id") int id) throws SQLException {
        Transmiter transmiterToDelete = new Transmiter();
        transmiterToDelete.setId(id);
        return new Integer(transmiterRepository.deleteTransmiter(transmiterToDelete));
    }
}