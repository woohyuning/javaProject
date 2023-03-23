package com.shinhan.day07;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//23.03.02 3교시 2-3
//12장.3 Object 클래스(롬복) page.507
//@Getter
//@Setter
//@EqualsAndHashCode(of = {"model", "price", "maker"})
//@ToString
//@NoArgsConstructor
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Computer {
	@NonNull
	private String model;
	private int price;
	private String maker;
}
