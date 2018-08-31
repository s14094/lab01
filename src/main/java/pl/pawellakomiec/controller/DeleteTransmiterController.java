package pl.pawellakomiec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.pawellakomiec.domain.Transmiter;
import pl.pawellakomiec.repository.TransmiterRepository;

import java.sql.SQLException;

@Controller
public class DeleteTransmiterController {

    @Autowired
    TransmiterRepository transmiterRepository;

    @RequestMapping(value = "/deleteTransmiter", method = RequestMethod.GET)
    public String deleteTransmiterPage() {
        return "deleteTransmiter";
    }

    @RequestMapping(value = "/deleteSuccess", method = RequestMethod.POST)
    public String deleteSuccess(@RequestParam(name = "id") int transmiterId) throws SQLException {

        Transmiter newTransmiter = new Transmiter();
        newTransmiter.setId(transmiterId);
        transmiterRepository.deleteTransmiter(newTransmiter);


        return "redirect:/getAll";
    }
}
