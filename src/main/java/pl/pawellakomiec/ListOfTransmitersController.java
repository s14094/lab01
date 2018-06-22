package pl.pawellakomiec;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
}
