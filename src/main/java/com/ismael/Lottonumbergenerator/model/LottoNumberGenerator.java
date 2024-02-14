package com.ismael.Lottonumbergenerator.model;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class LottoNumberGenerator {
    private Set<Integer> playedNumbers = new HashSet<>();
    private Random random = new Random();

    public void addPlayedNumbers(List<Integer> numbers) {
        playedNumbers.addAll(numbers);
    }

    public int generateUniqueNumber(int min, int max, List<Integer> excludeList) {
        int number;
        do {
            number = random.nextInt(max - min + 1) + min;
        } while (excludeList.contains(number) || playedNumbers.contains(number));

        return number;
    }

    public List<Integer> generateUniqueNumbers(int min, int max, int count) {
        List<Integer> lottoNumbers = new ArrayList<>();

        while (lottoNumbers.size() < count) {
            int number = generateUniqueNumber(min, max, lottoNumbers);
            lottoNumbers.add(number);
        }

        return lottoNumbers;
    }

    public List<List<Integer>> generateMultipleLottoNumbers(int min, int max, int numberOfSets, int numbersPerSet) {
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < numberOfSets; i++) {
            List<Integer> lottoNumbers = generateUniqueNumbers(min, max, numbersPerSet);
            result.add(lottoNumbers);
        }

        return result;
    }

    public void resetPlayedNumbers() {
        playedNumbers.clear();
    }
}