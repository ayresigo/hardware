package br.com.hardware.controller;

import br.com.hardware.model.Hardware;
import br.com.hardware.repository.HardwareRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HardwareController {
    @Autowired
    private HardwareRepository hardwareRepository;

    @GetMapping("/gerenciar_hardware")
    public String listarProdutos(Model model) {
        model.addAttribute("listaHardware", hardwareRepository.findAll());
        return "gerenciar_hardware";
    }

    @GetMapping("/novoHardware")
    public String novoHardware(Model model) {
        model.addAttribute("hardware", new Hardware());
        return "editar_hardware";
    }

    @GetMapping("/editarHardware/{id}")
    public String editarHardware(@PathVariable("id") long idHardware, Model model) {
        Optional<Hardware> hardware = hardwareRepository.findById(idHardware);
        model.addAttribute("hardware", hardware.get());
        return "editar_hardware";
    }

    @PostMapping("/salvarHardware")
    public String salvarHardware(Hardware hardware, BindingResult result) {
        if (result.hasErrors()) {
            return "editar_hardware";
        }
        hardwareRepository.save(hardware);
        return "redirect:/gerenciar_hardware";
    }

    @GetMapping("/excluirHardware/{id}")
    public String excluirHardware(@PathVariable("id") long idHardware) {
        hardwareRepository.deleteById(idHardware);
        return "redirect:/gerenciar_hardware";
    }
}
