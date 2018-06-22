//package pl.pawellakomiec;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//import pl.pawellakomiec.repository.TransmiterRepositoryImpl;
//
//import java.util.Map;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
//@Controller
//public class DeleteController {
//
//
//    @DeleteMapping("/deleteSpecificTransmiter/{id}")
//    public String deleteTransmiter(@PathVariable("id") int id, final RedirectAttributes redirectAttributes) {
//        try {
//            redirectAttributes.addFlashAttribute("css", "Success");
//            redirectAttributes.addFlashAttribute("msg", "The transmiter is deleted");
//
//
//        } catch (Exception e) {
//
//            Logger.getGlobal().log(Level.ALL, e.getMessage());
//        }
//        return "delete";
//    }
//
//
//
//
//    public String deleteUser(@PathVariable("id") Long idx, final RedirectAttributes redirectAttributes) {
//
//        logger.debug("Delete user with Id {}", id);
//
//        redirectAttributes.addFlashAttribute("css", "Success");
//        redirectAttributes.addFlashAttribute("msg", "The transmiter is deleted");
//
//        // delete the user
//        userService.delete(idx);
//        return "redirect:/users/";
//}
