package pl.pawellakomiecrest.web;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.pawellakomiecrest.domain.Transmiter;
import pl.pawellakomiecrest.service.TransmiterRepository;


@RestController
public class TransmiterApi {

    @Autowired
    TransmiterRepository transmiterRepository;

    @RequestMapping("/")
    public String index(){
        return "This is non rest, just checking if everything works";
    }

    @RequestMapping(value = "/GET/transmiter/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Transmiter getTransmiter(@PathVariable("id") int id) throws SQLException {
        return transmiterRepository.getById(id);
    }

    @RequestMapping(value = "/GET/transmiters", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Transmiter> getTransmiters(@RequestParam(value = "filter",required = false) String f) throws SQLException{
        if(f != null){
            List<Transmiter> transmiters = new LinkedList<Transmiter>();
            for(Transmiter t : transmiterRepository.getAll()){
                if (t.getName().contains(f)){
                    transmiters.add(t);
                }
            }
            return transmiters;
        }
        else {
            return transmiterRepository.getAll();

        }
    }

    @RequestMapping(value = "/POST/transmiter", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Long addTransmiter(@RequestBody Transmiter t){
        return new Long(transmiterRepository.addTransmiter(t));
    }

    @RequestMapping(value = "/DELETE/transmiter/{id}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Long deleteTransmiter(@PathVariable("id") int id) throws SQLException{
        Transmiter transmiterToDel = new Transmiter();
        transmiterToDel.setId(id);
        return new Long(transmiterRepository.deleteTransmiter(transmiterToDel));
    }
}
