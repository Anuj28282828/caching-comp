package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class StockDetail{
	private Double openPrice;
	private Double closePrice;
	private Double highPrice;
	private Double lowPrice;
	private Double volume;
}
