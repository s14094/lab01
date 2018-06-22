package pl.pawellakomiec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.pawellakomiec.domain.Transmiter;
import pl.pawellakomiec.repository.TransmiterRepositoryImpl;

import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
public class ListOfTransmitersController {

    public List<Transmiter> transmiterList;

    @RequestMapping(value = "/getAll")
    public String getAll(Map<String, Object> model) {

        try {
            TransmiterRepositoryImpl impl = new TransmiterRepositoryImpl();
            model.put("transmiterList", impl.getAll());
        } catch (Exception e) {
            Logger.getGlobal().log(Level.ALL, e.getMessage());
        }


        return "listOfTransmiters";
    }

    @RequestMapping(value = "/deleteSpecificTransmiter/{id}")
    public String deleteSpecificTransmiter(@PathVariable("id") int id, final RedirectAttributes redirectAttributes) {
        try {
            redirectAttributes.addFlashAttribute("css", "Success");
            redirectAttributes.addFlashAttribute("msg", "The transmiter is deleted");
            TransmiterRepositoryImpl impl = new TransmiterRepositoryImpl();
            Transmiter transmiterToDelete = impl.getById(id);
            impl.deleteTransmiter(transmiterToDelete);

        } catch (Exception e) {

            Logger.getGlobal().log(Level.ALL, e.getMessage());
        }
        return "login";
    }
}
