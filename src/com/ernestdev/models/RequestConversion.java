package com.ernestdev.models;

public record RequestConversion(String base_code,
                                String target_code,
                                double conversion_rate ) {
}
