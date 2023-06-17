package com.sda.Management.controllers;
import com.sda.Management.dto.FishDto;
import com.sda.Management.dto.FishSummaryDto;
import com.sda.Management.services.FishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class FishController {

    private FishService fishService;
    @Autowired
    public FishController(FishService fishService) {
        this.fishService = fishService;
    }

    @GetMapping("/fish/home")
    public String homepage() {
        return "fish-home";
    }

    @GetMapping("/fish/list")
    public String getListOfFishes(Model model) {
        List<FishDto> fishDtoList = fishService.getAllFishes();
        model.addAttribute("fishDtoList", fishDtoList);
        return "fish-list";
    }

    @GetMapping("/fish/add")
    public String creationForm(Model model) {
        FishDto fishDto = new FishDto();
        model.addAttribute("fishDto", fishDto);
        return "fish-create";
    }

    @PostMapping("/fish/add/save")
    public String saveFish(@ModelAttribute("fishDto") FishDto fishDto, BindingResult result, Model model) {
        FishDto createdFishDto = fishService.createFish(fishDto);
        model.addAttribute("createdFishDto", createdFishDto);
        return "redirect:/fish/list";
    }


    @GetMapping("/fish/{fishId}")
    public String fishDetail(@PathVariable("fishId") Long fishId, Model model) {
        FishDto fishDetail = fishService.getFishById(fishId);
        model.addAttribute("fishDetail", fishDetail);
        return "fish-details";
    }

    @GetMapping("/fish/{fishId}/update")
    public String updateFishForm(@PathVariable("fishId") Long fishId, Model model) {
        FishDto updatedFish = fishService.getFishById(fishId);
        model.addAttribute("updatedFish", updatedFish);
        return "fish-update";
    }

    @PostMapping("/fish/{fishId}/update")
    public String updateFish(@PathVariable("fishId") Long fishId, @ModelAttribute("fishDto") FishDto fishDto) {
        fishService.updateFish(fishDto, fishId);
        return "redirect:/fish/list";
    }

    @GetMapping("/fish/{fishId}/delete")
    public String deleteFish(@PathVariable("fishId") Long fishId) {
        fishService.deleteFishById(fishId);
        return "redirect:/fish/list";
    }

    @GetMapping("/fish/results")
    public String getFishSummary(Model model) {
        FishSummaryDto summary = fishService.getFishSummary();
        model.addAttribute("summary", summary);
        return "fish-results";
    }

    @InitBinder("fishingDate")
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) throws IllegalArgumentException {
                try {
                    setValue(sdf.parse(text));
                } catch (ParseException e) {
                    setValue(null);
                }
            }

            @Override
            public String getAsText() {
                return sdf.format((Date) getValue());
            }
        });
    }
}