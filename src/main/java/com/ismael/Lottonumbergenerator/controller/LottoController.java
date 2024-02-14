package com.ismael.Lottonumbergenerator.controller;
import com.ismael.Lottonumbergenerator.model.LottoNumberGenerator;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000/")
public class LottoController {

    private final LottoNumberGenerator lottoNumberGenerator;

    public LottoController(LottoNumberGenerator lottoNumberGenerator) {
        this.lottoNumberGenerator = lottoNumberGenerator;
    }

    @GetMapping("/generateUniqueNumber")
    public int generateUniqueNumber(
            @RequestParam int min,
            @RequestParam int max,
            @RequestParam List<Integer> excludeList) {
        return lottoNumberGenerator.generateUniqueNumber(min, max, excludeList);
    }

    @GetMapping("/generateMultipleLottoNumbers")
    public List<List<Integer>> generateMultipleLottoNumbers(
            @RequestParam int min,
            @RequestParam int max,
            @RequestParam int numberOfSets,
            @RequestParam int numbersPerSet) {
        return lottoNumberGenerator.generateMultipleLottoNumbers(min, max, numberOfSets, numbersPerSet);
    }

    @PostMapping("/addPlayedNumbers")
    public void addPlayedNumbers(@RequestBody List<Integer> numbers) {
        lottoNumberGenerator.addPlayedNumbers(numbers);
    }

    @GetMapping("/resetPlayedNumbers")
    public void resetPlayedNumbers() {
        lottoNumberGenerator.resetPlayedNumbers();
    }
}
