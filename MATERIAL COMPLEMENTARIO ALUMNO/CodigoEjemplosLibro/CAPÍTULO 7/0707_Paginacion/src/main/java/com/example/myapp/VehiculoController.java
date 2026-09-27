package com.example.myapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class VehiculoController {

    @Autowired
    public VehiculoService vehiculoService;

    @GetMapping("/")
    public String showList(@RequestParam(required = false) Integer pag, Model model) {
        int ultPag = vehiculoService.getTotalPaginas() - 1;
        if (pag == null || pag < 0 || pag > ultPag)
            pag = 0;
        Integer pagSig = ultPag > pag ? pag + 1 : ultPag;
        Integer pagAnt = pag > 0 ? pag - 1 : 0;
        model.addAttribute("listaVehiculos", vehiculoService.getVehiculosPaginados(pag));
        model.addAttribute("pagSiguiente", pagSig);
        model.addAttribute("pagAnterior", pagAnt);
        model.addAttribute("pagFinal", ultPag);
        return "listView";
    }
}
