package org.example;

import java.util.Map;

public record ApiResponse(String result,
                          String base_code,
                          Map<String, Double> conversion_rates) {
}
