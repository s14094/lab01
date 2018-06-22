package pl.pawellakomiec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.pawellakomiec.domain.Transmiter;
import pl.pawellakomiec.repository.TransmiterRepository;

@Controller
public class AddTransmiterController {

    @Autowired
    TransmiterRepository transmiterRepository;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addTransmiterPage() {
        return "addTransmiter";
    }

    @RequestMapping(value = "/addSuccess", method = RequestMethod.POST)
    public String addSuccess(@RequestParam("name") String transmiterName, @RequestParam("price")
            int transmiterPrice, @RequestParam(name = "power") int transmiterPower) {

        Transmiter newTransmiter = new Transmiter(666, transmiterName, transmiterPrice, transmiterPower);
        transmiterRepository.addTransmiter(newTransmiter);


        return "redirect:/getAll";
    }

}
