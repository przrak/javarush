package ru.javarush.pr1zrak.testtask.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.javarush.pr1zrak.testtask.entity.Part;
import ru.javarush.pr1zrak.testtask.service.PartService;
import ru.javarush.pr1zrak.testtask.support.FilterType;

import java.util.List;

import static ru.javarush.pr1zrak.testtask.support.FilterType.*;

@Controller
public class PartController {

    private PartService service;
    private Enum<FilterType> lastFilter = FilterType.ALL;

    @Autowired
    public void setService(PartService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String listParts(@PageableDefault() Pageable pageable, Model model)
    {
        prepareModel(pageable, model, this.lastFilter.toString(), null);
        return "index";
    }

    @RequestMapping(value="/filtered", method=RequestMethod.POST)
    public String filteredListPart(@PageableDefault() Pageable pageable,
                                   @RequestParam(value="action") String action,
                                   Model model) {
        prepareModel(pageable, model, action, null);
        return "index";
    }
    
    @RequestMapping(value="/search", method=RequestMethod.GET)
    public String searchPartGet(@PageableDefault() Pageable pageable,
                                Model model) {
        prepareModel(pageable, model, this.lastFilter.toString(), null);
        return "redirect:/";
    }

    @RequestMapping(value="/search", method=RequestMethod.POST)
    public String searchPart(@PageableDefault() Pageable pageable,
                             @RequestParam String name,
                                   Model model) {
        prepareModel(pageable, model, SEARCH.toString(), name);
        return "index";
    }

    @GetMapping("/add")
    public String addNewPart() {
        return "actions/add";
    }

    @PostMapping("/save")
    public String savePart(@RequestParam String name, @RequestParam(value = "need", required = false) boolean need,
                             @RequestParam Integer quantity) {
        service.savePart(new Part(name, need, quantity));
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.deletePartById(id);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        Part part = service.getPartById(id);
        if (part != null)
        {
            model.addAttribute("part", part);
            return "actions/edit";
        }
        else
        {
            return "redirect:/";
        }
    }

    @PostMapping("/update")
    public String updatePart(@RequestParam Long id, @RequestParam String name,
                           @RequestParam(value = "need", required = false) boolean need,
                           @RequestParam Integer quantity) {
        service.updatePartById(id, name, need, quantity);
        return "redirect:/";
    }

    private void prepareModel(Pageable pageable, Model model, String action, String name)
    {
        Page<Part> page;

        switch(FilterType.valueOf(action.toUpperCase())) {
            case NEEDED:
                this.lastFilter = NEEDED;
                page = service.findFiltered(true, pageable);
                break;
            case OPTIONAL:
                this.lastFilter = OPTIONAL;
                page = service.findFiltered(false, pageable);
                break;
            case SEARCH:
                page = service.findByName(name, pageable);
                break;
            case ALL:
            default:
                this.lastFilter = ALL;
                page = service.findAll(pageable);
                break;
        }

        List<Part> parts = page.getContent();

        model.addAttribute("page", page);
        model.addAttribute("isEmpty", parts.isEmpty());
        model.addAttribute("action", this.lastFilter.toString());
        if (!parts.isEmpty() && (action.equals(ALL.toString())
                || action.equals(NEEDED.toString())))
        {
            model.addAttribute("showComputerBlock", true);
        }

        int numberOfCumputeres = calculateNumberOfComputers(service.findByNeedStatus(true));

        model.addAttribute("numberOfComputers", numberOfCumputeres);
    }

    private int calculateNumberOfComputers(List<Part> parts)
    {
        int numberOfCumputeres = 0;

        if (parts != null && !parts.isEmpty())
        {
            parts.sort((p1, p2) -> {
                if (p1.getQuantity() > p2.getQuantity())
                    return 1;
                else if (p1.getQuantity() == p2.getQuantity())
                    return 0;
                else return -1;
            });

            numberOfCumputeres = parts.get(0).getQuantity();
        }

        return numberOfCumputeres;
    }
}
